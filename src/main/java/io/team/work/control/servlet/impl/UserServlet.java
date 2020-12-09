package io.team.work.control.servlet.impl;

import io.team.work.util.UserUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户相关操作Servlet类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/8 15:43
 */
@WebServlet("user.do")
public class UserServlet {
    private static final UserDao USER_DAO = UserDao.getInstance();

    /**
     * 登录.
     * <p>
     * 动作函数.
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String spacePage;
        Integer role = UserUtil.roleCheck(username);
        switch (role) {
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
                response.getWriter().write("Illegal username");
                return;
        }

        if (USER_DAO.login(username, password)) { // 如果登陆成功
            request.getSession().setAttribute("user", USER_DAO.getUserByUsername(username));
            response.sendRedirect("/Chiron/" + spacePage);
        } else {
            response.getWriter().write("Login failed");
        }
    }

    /**
     * 登出.
     * <p>
     * 动作函数.
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("/Chiron");
    }

    /**
     * 密码检查, 用于密码修改时的旧密码判断.
     * <p>
     * 动作函数.
     */
    public void passwordCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String password = request.getParameter("password");
        User user = (User) request.getSession().getAttribute("user");
        if (user.getPassword().equals(password)) {
            response.getWriter().write("true");
        } else {
            response.getWriter().write("false");
        }
    }

    /**
     * 重置密码.
     * <p>
     * 动作函数
     */
    public void resetPassword(HttpServletRequest request, HttpServletResponse response) {
        String newPassword = request.getParameter("newPassword");
        User user = (User) request.getSession().getAttribute("user");
        user.setPassword(newPassword);
        request.getSession().setAttribute("user", user);
        USER_DAO.update(user.getId(), "password", newPassword);
    }
}
