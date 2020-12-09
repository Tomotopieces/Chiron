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

import static io.team.work.util.BeanUtil.PROPERTY_REVIEW_CONTENT;
import static io.team.work.util.ServletUtil.GSON;
import static io.team.work.util.ServletUtil.RequestParameterName.ASSIGN_HOMEWORK_CLASS_ID;
import static io.team.work.util.ServletUtil.RequestParameterName.ASSIGN_HOMEWORK_DESCRIBE;
import static io.team.work.util.ServletUtil.RequestParameterName.ASSIGN_HOMEWORK_END_TIME;
import static io.team.work.util.ServletUtil.RequestParameterName.ASSIGN_HOMEWORK_TITLE;
import static io.team.work.util.ServletUtil.RequestParameterName.REVIEW_HOMEWORK_ID;
import static io.team.work.util.ServletUtil.RequestParameterName.REVIEW_HOMEWORK_REVIEW_CONTENT;
import static io.team.work.util.ServletUtil.SessionAttributeName.USER;
import static io.team.work.util.ServletUtil.writeResult;

/**
 * 教师相关操作Servlet类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/9 9:14
 */
@WebServlet("/teacher.do")
public class TeacherServlet extends BaseServlet {
    private static final HomeworkService HOMEWORK_SERVICE = HomeworkService.getInstance();
    private static final StudentHomeworkService STUDENT_HOMEWORK_SERVICE = StudentHomeworkService.getInstance();

    /**
     * 根据教师ID查询已布置的作业.
     * <p>
     * 动作函数.
     */
    public void getAssignedHomeworkList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User teacher = (User) request.getSession().getAttribute(USER);
        List<Homework> homeworkList = HOMEWORK_SERVICE.getHomeworkByTeacherId(teacher.getId());
        response.getWriter().write(GSON.toJson(homeworkList));
    }

    /**
     * 根据教师ID查询学生提交了的作业.
     * <p>
     * 动作函数.
     */
    public void getSubmittedHomeworkList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User teacher = (User) request.getSession().getAttribute(USER);
        List<StudentHomework> studentHomeworkList = STUDENT_HOMEWORK_SERVICE.getHomeworkByTeacherId(teacher.getId());
        response.getWriter().write(GSON.toJson(studentHomeworkList));
    }

    /**
     * 布置作业.
     * <p>
     * 动作函数
     */
    public void assignHomework(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute(USER);
        Integer teacherId = user.getId();
        String title = request.getParameter(ASSIGN_HOMEWORK_TITLE);
        String describe = request.getParameter(ASSIGN_HOMEWORK_DESCRIBE);
        String endTime = request.getParameter(ASSIGN_HOMEWORK_END_TIME);
        Integer classId = Integer.valueOf(request.getParameter(ASSIGN_HOMEWORK_CLASS_ID));

        Homework homework = new Homework();
        homework.setTitle(title);
        homework.setTeacher_id(teacherId);
        homework.setDescribe(describe);
        homework.setEnd_time(endTime);
        homework.setClass_id(classId);

        writeResult(HOMEWORK_SERVICE.add(homework), response);
    }

    /**
     * 删除已发布的作业.
     * <p>
     * 动作函数.
     */
    public void deleteHomework(HttpServletRequest request, HttpServletResponse response) throws IOException {
        writeResult(HOMEWORK_SERVICE.remove(request.getParameter(REVIEW_HOMEWORK_ID)), response);
    }

    /**
     * 作业审阅.
     * <p>
     * 动作函数.
     */
    public void reviewHomework(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String homeworkId = request.getParameter(REVIEW_HOMEWORK_ID);
        String reviewContent = request.getParameter(REVIEW_HOMEWORK_REVIEW_CONTENT);
        writeResult(HOMEWORK_SERVICE.update(homeworkId, PROPERTY_REVIEW_CONTENT, reviewContent), response);
    }
}
