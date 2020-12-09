package io.team.work.control.servlet.impl;

import io.team.work.control.servlet.BaseServlet;
import io.team.work.model.bean.User;
import io.team.work.util.UserUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static io.team.work.util.BeanUtil.PROPERTY_PASSWORD;
import static io.team.work.util.ServletUtil.PROJECT_PATH;
import static io.team.work.util.ServletUtil.RequestParameterName.LOGIN_PASSWORD;
import static io.team.work.util.ServletUtil.RequestParameterName.LOGIN_USERNAME;
import static io.team.work.util.ServletUtil.RequestParameterName.RESET_PASSWORD_NEW_PASSWORD;
import static io.team.work.util.ServletUtil.RequestParameterName.RESET_PASSWORD_OLD_PASSWORD;
import static io.team.work.util.ServletUtil.ResponseMessage.ILLEGAL_USERNAME;
import static io.team.work.util.ServletUtil.ResponseMessage.WRONG_USERNAME_OR_PASSWORD;
import static io.team.work.util.ServletUtil.SessionAttributeName.USER;
import static io.team.work.util.ServletUtil.writeResult;

/**
 * 用户相关操作Servlet类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/8 15:43
 */
@WebServlet("user.do")
public class UserServlet extends BaseServlet {
    private static final UserService USER_SERVICE = UserService.getInstance();

    /**
     * 登录.
     * <p>
     * 动作函数.
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter(LOGIN_USERNAME);
        String password = request.getParameter(LOGIN_PASSWORD);

        String spacePage;
        Integer role = UserUtil.roleCheck(username);
        switch (role) { // 通过类型来决定重定向的地址
            case UserUtil.ADMIN_ACCOUNT:
                spacePage = UserUtil.ADMIN_SPACE;
                break;
            case UserUtil.TEACHER_ACCOUNT:
                spacePage = UserUtil.TEACHER_SPACE;
                break;
            case UserUtil.STUDENT_ACCOUNT:
                spacePage = UserUtil.STUDENT_SPACE;
                break;
            default: // 非法用户名
                response.getWriter().write(ILLEGAL_USERNAME);
                return;
        }

        if (USER_SERVICE.login(username, password)) { // 如果登陆成功
            request.getSession().setAttribute(USER, USER_SERVICE.getUserByUsername(username));
            response.sendRedirect(PROJECT_PATH + spacePage);
        } else {
            response.getWriter().write(WRONG_USERNAME_OR_PASSWORD);
        }
    }

    /**
     * 登出.
     * <p>
     * 动作函数.
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect(PROJECT_PATH);
    }

    /**
     * 密码检查, 用于密码修改时的旧密码判断.
     * <p>
     * 动作函数.
     */
    public void passwordCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String password = request.getParameter(RESET_PASSWORD_OLD_PASSWORD);
        User user = (User) request.getSession().getAttribute(USER);
        writeResult(user.getPassword().equals(password), response);
    }

    /**
     * 重置密码.
     * <p>
     * 动作函数
     */
    public void resetPassword(HttpServletRequest request, HttpServletResponse response) {
        String newPassword = request.getParameter(RESET_PASSWORD_NEW_PASSWORD);
        User user = (User) request.getSession().getAttribute(USER);
        user.setPassword(newPassword);
        request.getSession().setAttribute(USER, user);
        USER_SERVICE.update(user.getId(), PROPERTY_PASSWORD, newPassword);
    }

    /**
     * 在留言板上留言.
     * <p>
     * 动作函数.
     */
    public void leaveMessage(HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * 在留言板上回复.
     * <p>
     * 动作函数.
     */
    public void replyMessage(HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * 查看公告板
     * <p>
     * 动作函数.
     */
    public void viewBulletinBoard(HttpServletRequest request, HttpServletResponse response) {

    }
}
