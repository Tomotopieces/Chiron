package io.team.work.control.servlet.impl;

import io.team.work.control.servlet.BaseServlet;
import io.team.work.model.bean.Homework;
import io.team.work.model.bean.StudentHomework;
import io.team.work.model.bean.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static io.team.work.util.ServletUtil.GSON;
import static io.team.work.util.ServletUtil.SessionAttributeName.USER;

/**
 * 学生相关操作Servlet类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/9 10:47
 */
@WebServlet("/student.do")
public class StudentServlet extends BaseServlet {
    private static final HomeworkService HOMEWORK_SERVICE = HomeworkService.getInstance();
    private static final StudentHomeworkService STUDENT_HOMEWORK_SERVICE = StudentHomeworkService.getInstance();

    /**
     * 根据学生班级id查询应完成作业.
     * <p>
     * 动作函数.
     */
    public void getHomeworkList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User student = (User) request.getSession().getAttribute(USER);
        List<Homework> homeworkList = HOMEWORK_SERVICE.getHomeworkListByClassId(student.getClass_id());
        response.getWriter().write(GSON.toJson(homeworkList));
    }

    /**
     * 根绝学生id查询个人已完成作业.
     * <p>
     * 动作函数.
     */
    public void getFinishedHomeworkList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User student = (User) request.getSession().getAttribute(USER);
        List<StudentHomework> studentHomeworkList = STUDENT_HOMEWORK_SERVICE.getHomeworkListByStudentId(student.getId());
        response.getWriter().write(GSON.toJson(studentHomeworkList));
    }

    /**
     * 上传作业.
     * <p>
     * 动作函数.
     */
    public void uploadHomework(HttpServletRequest request, HttpServletResponse response) {

    }
}
