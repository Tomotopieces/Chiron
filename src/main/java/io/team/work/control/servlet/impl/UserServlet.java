package io.team.work.control.servlet.impl;

import io.team.work.control.servlet.AbstractBaseServlet;
import io.team.work.model.bean.Message;
import io.team.work.model.bean.Notice;
import io.team.work.model.bean.User;
import io.team.work.model.service.impl.*;
import io.team.work.util.CommonUtil.ResponseDataWrapper;
import io.team.work.util.FileUtil;
import io.team.work.util.UserUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static io.team.work.util.BeanUtil.PROPERTY_PASSWORD;
import static io.team.work.util.CommonUtil.PROJECT_PATH;
import static io.team.work.util.CommonUtil.RequestParameterName.*;
import static io.team.work.util.CommonUtil.ResponseMessage.MESSAGE_ILLEGAL_USERNAME;
import static io.team.work.util.CommonUtil.ResponseMessage.MESSAGE_WRONG_USERNAME_OR_PASSWORD;
import static io.team.work.util.CommonUtil.SessionAttributeName.USER;
import static io.team.work.util.DateTimeUtil.DATE_TIME_FORMAT;

/**
 * 用户基本操作Servlet类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/8 15:43
 */
@WebServlet("/user.do")
public class UserServlet extends AbstractBaseServlet {
    private static final UserService USER_SERVICE = UserService.getInstance();
    private static final MessageService MESSAGE_SERVICE = MessageService.getInstance();
    private static final NoticeService NOTICE_SERVICE = NoticeService.getInstance();
    private static final HomeworkService HOMEWORK_SERVICE = HomeworkService.getInstance();
    private static final StudentHomeworkService STUDENT_HOMEWORK_SERVICE = StudentHomeworkService.getInstance();

    /**
     * 登录.
     * <p>
     * 动作函数.
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter(LOGIN_USERNAME);
        String password = request.getParameter(LOGIN_PASSWORD);

        String spacePage = UserUtil.getSpace(UserUtil.getType(username));
        if (spacePage == null) {
            response.getWriter().write(ResponseDataWrapper.of(false, MESSAGE_ILLEGAL_USERNAME));
            return;
        }
        String spacePath = PROJECT_PATH + spacePage;

        if (USER_SERVICE.login(username, password)) { // 如果登陆成功
            request.getSession().setAttribute(USER, USER_SERVICE.getUserByUsername(username));
            response.getWriter().write(ResponseDataWrapper.of(spacePath));
        } else {
            response.getWriter().write(ResponseDataWrapper.of(false, MESSAGE_WRONG_USERNAME_OR_PASSWORD));
        }
    }

    /**
     * 获取当前用户.
     * <p>
     * 动作函数.
     */
    public void getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(request.getSession().getAttribute(USER)));
    }

    /**
     * 登出.
     * <p>
     * 动作函数.
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.getWriter().write(ResponseDataWrapper.of(true));
    }

    /**
     * 密码检查, 用于密码修改时的旧密码判断.
     * <p>
     * 动作函数.
     */
    public void passwordCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String password = request.getParameter(RESET_PASSWORD_OLD_PASSWORD);
        User user = (User) request.getSession().getAttribute(USER);

        response.getWriter().write(ResponseDataWrapper.of(true, user.getPassword().equals(password)));
    }

    /**
     * 重置密码.
     * <p>
     * 动作函数
     */
    public void resetPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String newPassword = request.getParameter(RESET_PASSWORD_NEW_PASSWORD);
        User user = (User) request.getSession().getAttribute(USER);

        user.setPassword(newPassword);
        request.getSession().setAttribute(USER, user);

        response.getWriter().write(
                ResponseDataWrapper.of(USER_SERVICE.update(user.getId(), PROPERTY_PASSWORD, newPassword)));
    }

    /**
     * 在留言板上留言.
     * <p>
     * 动作函数.
     */
    public void leaveMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter(MESSAGE_TITLE);
        String content = request.getParameter(MESSAGE_CONTENT);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        message.setCreate_time(DATE_TIME_FORMAT.format(new Date()));

        response.getWriter().write(ResponseDataWrapper.of(MESSAGE_SERVICE.add(message)));
    }

    /**
     * 获取所有留言.
     * <p>
     * 动作函数.
     */
    public void getMessageList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Message> messageList = MESSAGE_SERVICE.list();
        response.getWriter().write(ResponseDataWrapper.of(messageList));
    }

    /**
     * 分页获取留言
     * <p>
     * 动作函数
     */
    public void getMessageListByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer pageNo = Integer.valueOf(request.getParameter(GET_MESSAGE_BY_PAGE_PAGE_NO));
        Integer pageSize = Integer.valueOf(request.getParameter(GET_MESSAGE_BY_PAGE_PAGE_SIZE));

        List<Message> messageList = MESSAGE_SERVICE.listByPage(pageNo, pageSize);
        response.getWriter().write(ResponseDataWrapper.of(messageList));
    }

    /**
     * 获取留言总数
     * <p>
     * 动作函数
     */
    public void getMessageCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(MESSAGE_SERVICE.count()));
    }

    /**
     * 查看公告板.
     * <p>
     * 动作函数.
     */
    public void getNoticeList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Notice> noticeList = NOTICE_SERVICE.list();
        response.getWriter().write(ResponseDataWrapper.of(noticeList));
    }

    /**
     * 分页获取公告
     * <p>
     * 动作函数
     */
    public void getNoticeListByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer pageNo = Integer.valueOf(request.getParameter(GET_NOTICE_BY_PAGE_PAGE_NO));
        Integer pageSize = Integer.valueOf(request.getParameter(GET_NOTICE_BY_PAGE_PAGE_SIZE));

        List<Notice> messageList = NOTICE_SERVICE.listByPage(pageNo, pageSize);
        response.getWriter().write(ResponseDataWrapper.of(messageList));
    }

    /**
     * 获取公告总数
     * <p>
     * 动作函数
     */
    public void getNoticeCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(NOTICE_SERVICE.count()));
    }

    /**
     * 文件下载.
     * <p>
     * 动作函数.
     */
//    public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String type = request.getParameter(DOWNLOAD_FILE_TYPE);
//        Integer id = Integer.valueOf(request.getParameter(DOWNLOAD_FILE_ID));
//
//        if (type.equals("homework")) {
//            FileUtil.download(response, HOMEWORK_SERVICE.getById(id).getAttach_url());
//        } else if (type.equals("studentHomework")) {
//            FileUtil.download(response, STUDENT_HOMEWORK_SERVICE.getById(id).getAttach_url());
//        } else {
//            response.getWriter().write(ResponseDataWrapper.of(false, "You wanna download what?"));
//        }
//    }
}
