package io.team.work.control.servlet.impl;

import io.team.work.control.servlet.AbstractBaseServlet;
import io.team.work.model.bean.Message;
import io.team.work.model.bean.Notice;
import io.team.work.model.bean.User;
import io.team.work.model.service.impl.MessageService;
import io.team.work.model.service.impl.NoticeService;
import io.team.work.model.service.impl.UserService;
import io.team.work.util.ServletUtil.ResponseDataWrapper;
import io.team.work.util.UserUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static io.team.work.util.BeanUtil.PROPERTY_PASSWORD;
import static io.team.work.util.DateTimeUtil.DATE_TIME_FORMAT;
import static io.team.work.util.ServletUtil.PROJECT_PATH;
import static io.team.work.util.ServletUtil.RequestParameterName.LOGIN_PASSWORD;
import static io.team.work.util.ServletUtil.RequestParameterName.LOGIN_USERNAME;
import static io.team.work.util.ServletUtil.RequestParameterName.MESSAGE_CONTENT;
import static io.team.work.util.ServletUtil.RequestParameterName.MESSAGE_TITLE;
import static io.team.work.util.ServletUtil.RequestParameterName.RESET_PASSWORD_NEW_PASSWORD;
import static io.team.work.util.ServletUtil.RequestParameterName.RESET_PASSWORD_OLD_PASSWORD;
import static io.team.work.util.ServletUtil.ResponseMessage.ILLEGAL_USERNAME;
import static io.team.work.util.ServletUtil.ResponseMessage.WRONG_USERNAME_OR_PASSWORD;
import static io.team.work.util.ServletUtil.SessionAttributeName.USER;

/**
 * 用户基本操作Servlet类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/8 15:43
 */
@WebServlet("user.do")
public class UserServlet extends AbstractBaseServlet {
    private static final UserService USER_SERVICE = UserService.getInstance();
    private static final MessageService MESSAGE_SERVICE = MessageService.getInstance();
    private static final NoticeService NOTICE_SERVICE = NoticeService.getInstance();

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
            response.getWriter().write(ResponseDataWrapper.of(false, ILLEGAL_USERNAME));
        }
        String spacePath = PROJECT_PATH + spacePage;

        if (USER_SERVICE.login(username, password)) { // 如果登陆成功
            request.getSession().setAttribute(USER, USER_SERVICE.getUserByUsername(username));
            response.getWriter().write(ResponseDataWrapper.of(spacePath));
        } else {
            response.getWriter().write(ResponseDataWrapper.of(false, WRONG_USERNAME_OR_PASSWORD));
        }
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
     * 查看公告板
     * <p>
     * 动作函数.
     */
    public void getNoticeList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Notice> noticeList = NOTICE_SERVICE.list();
        response.getWriter().write(ResponseDataWrapper.of(noticeList));
    }
}
