package io.team.work.control.servlet.impl;

import io.team.work.control.servlet.AbstractBaseServlet;
import io.team.work.model.bean.User;
import io.team.work.model.service.impl.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static io.team.work.util.BeanUtil.USER_TYPE_STUDENT;
import static io.team.work.util.CommonUtil.RequestParameterName.*;
import static io.team.work.util.CommonUtil.ResponseDataWrapper;
import static io.team.work.util.CommonUtil.ResponseMessage.ADD_DATA_EMPTY_VALUE;

/**
 * 管理员的用户相关操作Servlet类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/9 16:30
 */
@WebServlet("/admin.user.do")
public class AdminUserOperateServlet extends AbstractBaseServlet {
    private static final UserService USER_SERVICE = UserService.getInstance();

    /**
     * 添加学生或教师账号.
     * <p>
     * 动作函数.
     */
    public void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer type = null;
        String typeString = request.getParameter(ADD_USER_TYPE);
        if (!typeString.isEmpty()) {
            type = Integer.valueOf(typeString);
        }
        String username = request.getParameter(ADD_USER_USERNAME);
        String name = request.getParameter(ADD_USER_NAME);
        String sex = request.getParameter(ADD_USER_SEX);
        Integer age = null;
        String ageString = request.getParameter(ADD_USER_AGE);
        if (!ageString.isEmpty()) {
            age = Integer.valueOf(ageString);
        }
        Integer classId = Integer.valueOf(request.getParameter(ADD_USER_CLASS));

        if (type == null || username == null || name == null || age == null) {
            response.getWriter().write(ResponseDataWrapper.of(false, ADD_DATA_EMPTY_VALUE));
            return;
        }

        User user = new User();
        user.setType(type);
        user.setUsername(username);
        user.setPassword("123456");
        user.setName(name);
        user.setSex(sex);
        user.setAge(age);
        if (type.equals(USER_TYPE_STUDENT)) {
            user.setClass_id(classId);
        }

        response.getWriter().write(ResponseDataWrapper.of(USER_SERVICE.add(user)));
    }

    /**
     * 移除学生或教师账号.
     * <p>
     * 动作函数.
     */
    public void removeUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(
                ResponseDataWrapper.of(USER_SERVICE.remove(Integer.valueOf(request.getParameter(REMOVE_USER_ID)))));
    }

    /**
     * 获取所有老师信息.
     * <p>
     * 动作函数.
     */
    public void getTeacherList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(USER_SERVICE.listTeachers()));
    }

    /**
     * 获取所有学生信息.
     * <p>
     * 动作函数.
     */
    public void getStudentList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(USER_SERVICE.listStudents()));
    }

    /**
     * 分页获取学生信息
     * <p>
     * 动作函数
     */
    public void getStudentListByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer pageNo = Integer.valueOf(request.getParameter(GET_USER_BY_PAGE_PAGE_NO));
        Integer pageSize = Integer.valueOf(request.getParameter(GET_USER_BY_PAGE_PAGE_SIZE));

        response.getWriter().write(ResponseDataWrapper.of(USER_SERVICE.listStudentsByPage(pageNo, pageSize)));
    }

    /**
     * 分页获取教师信息
     * <p>
     * 动作函数
     */
    public void getTeacherListByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer pageNo = Integer.valueOf(request.getParameter(GET_USER_BY_PAGE_PAGE_NO));
        Integer pageSize = Integer.valueOf(request.getParameter(GET_USER_BY_PAGE_PAGE_SIZE));

        response.getWriter().write(ResponseDataWrapper.of(USER_SERVICE.listTeachersByPage(pageNo, pageSize)));
    }

    /**
     * 获取学生总数
     * <p>
     * 动作函数
     */
    public void getStudentCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(USER_SERVICE.countStudent()));
    }

    /**
     * 获取教师总数
     * <p>
     * 动作函数
     */
    public void getTeacherCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(USER_SERVICE.countTeacher()));
    }
}
