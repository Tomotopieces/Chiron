package io.team.work.control.servlet.impl;

import io.team.work.control.servlet.BaseServlet;
import io.team.work.model.bean.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static io.team.work.util.BeanUtil.USER_TYPE_STUDENT;
import static io.team.work.util.ServletUtil.GSON;
import static io.team.work.util.ServletUtil.RequestParameterName.ADD_USER_AGE;
import static io.team.work.util.ServletUtil.RequestParameterName.ADD_USER_CLASS;
import static io.team.work.util.ServletUtil.RequestParameterName.ADD_USER_NAME;
import static io.team.work.util.ServletUtil.RequestParameterName.ADD_USER_SEX;
import static io.team.work.util.ServletUtil.RequestParameterName.ADD_USER_TYPE;
import static io.team.work.util.ServletUtil.RequestParameterName.ADD_USER_USERNAME;
import static io.team.work.util.ServletUtil.RequestParameterName.REMOVE_USER_ID;
import static io.team.work.util.ServletUtil.writeResult;

/**
 * 管理员的用户相关操作Servlet类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/9 16:30
 */
@WebServlet("/admin.user.do")
public class AdminUserOperateServlet extends BaseServlet {
    private static final UserService USER_SERVICE = UserService.getInstance();

    /**
     * 添加学生或教师账号.
     * <p>
     * 动作函数.
     */
    public void addUser(HttpServletRequest request, HttpServletResponse response) {
        Integer type = Integer.valueOf(request.getParameter(ADD_USER_TYPE));
        String username = request.getParameter(ADD_USER_USERNAME);
//        String password = request.getParameter(ADD_USER_PASSWORD);
        String name = request.getParameter(ADD_USER_NAME);
        String sex = request.getParameter(ADD_USER_SEX);
        Integer age = Integer.valueOf(request.getParameter(ADD_USER_AGE));
        Integer classId = Integer.valueOf(request.getParameter(ADD_USER_CLASS));

        User user = new User();
        user.setUsername(username);
        user.setPassword("123456");
        user.setName(name);
        user.setSex(sex);
        user.setAge(age);
        if (type.equals(USER_TYPE_STUDENT)) {
            user.setClass_id(classId);
        }

        writeResult(USER_SERVICE.add(user));
    }

    /**
     * 移除学生或教师账号.
     * <p>
     * 动作函数.
     */
    public void removeUser(HttpServletRequest request, HttpServletResponse response) {
        writeResult(USER_SERVICE.remove(request.getParameter(REMOVE_USER_ID)), response);
    }

    /**
     * 获取所有老师信息.
     * <p>
     * 动作函数.
     */
    public void getTeacherList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(GSON.toJson(USER_SERVICE.listTeachers()));
    }

    /**
     * 获取所有学生信息.
     * <p>
     * 动作函数.
     */
    public void getStudentList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(GSON.toJson(USER_SERVICE.listStudents()));
    }
}