package io.team.work.control.servlet.impl;

import io.team.work.control.servlet.AbstractBaseServlet;
import io.team.work.model.bean.Homework;
import io.team.work.model.bean.StudentHomework;
import io.team.work.model.bean.User;
import io.team.work.model.service.impl.HomeworkService;
import io.team.work.model.service.impl.StudentHomeworkService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static io.team.work.util.BeanUtil.PROPERTY_REVIEW_CONTENT;
import static io.team.work.util.ServletUtil.RequestParameterName.ASSIGN_HOMEWORK_CLASS_ID;
import static io.team.work.util.ServletUtil.RequestParameterName.ASSIGN_HOMEWORK_DESCRIBE;
import static io.team.work.util.ServletUtil.RequestParameterName.ASSIGN_HOMEWORK_END_TIME;
import static io.team.work.util.ServletUtil.RequestParameterName.ASSIGN_HOMEWORK_TITLE;
import static io.team.work.util.ServletUtil.RequestParameterName.REVIEW_HOMEWORK_ID;
import static io.team.work.util.ServletUtil.RequestParameterName.REVIEW_HOMEWORK_REVIEW_CONTENT;
import static io.team.work.util.ServletUtil.ResponseDataWrapper;
import static io.team.work.util.ServletUtil.SessionAttributeName.USER;

/**
 * 教师相关操作Servlet类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/9 9:14
 */
@WebServlet("/teacher.do")
public class TeacherServlet extends AbstractBaseServlet {
    private static final HomeworkService HOMEWORK_SERVICE = HomeworkService.getInstance();
    private static final StudentHomeworkService STUDENT_HOMEWORK_SERVICE = StudentHomeworkService.getInstance();

    /**
     * 根据教师ID查询已布置的作业.
     * <p>
     * 动作函数.
     */
    public void getAssignedHomeworkList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User teacher = (User) request.getSession().getAttribute(USER);
        List<Homework> homeworkList = HOMEWORK_SERVICE.listByTeacherId(teacher.getId());
        response.getWriter().write(ResponseDataWrapper.of(homeworkList));
    }

    /**
     * 根据教师ID查询学生提交了的作业.
     * <p>
     * 动作函数.
     */
    public void getSubmittedHomeworkList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User teacher = (User) request.getSession().getAttribute(USER);
        List<StudentHomework> studentHomeworkList = STUDENT_HOMEWORK_SERVICE.listByTeacherId(teacher.getId());
        response.getWriter().write(ResponseDataWrapper.of(studentHomeworkList));
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

        response.getWriter().write(ResponseDataWrapper.of(HOMEWORK_SERVICE.add(homework)));
    }

    /**
     * 删除已发布的作业.
     * <p>
     * 动作函数.
     */
    public void deleteHomework(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(
                ResponseDataWrapper.of(
                        HOMEWORK_SERVICE.remove(Integer.valueOf(request.getParameter(REVIEW_HOMEWORK_ID)))));
    }

    /**
     * 作业评阅.
     * <p>
     * 动作函数.
     */
    public void reviewHomework(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int homeworkId = Integer.parseInt(request.getParameter(REVIEW_HOMEWORK_ID));
        String reviewContent = request.getParameter(REVIEW_HOMEWORK_REVIEW_CONTENT);
        response.getWriter().write(
                ResponseDataWrapper.of(
                        STUDENT_HOMEWORK_SERVICE.update(
                                homeworkId, PROPERTY_REVIEW_CONTENT, reviewContent)));
    }
}
