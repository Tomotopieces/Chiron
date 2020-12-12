package io.team.work.control.servlet.impl;

import io.team.work.control.servlet.AbstractBaseServlet;
import io.team.work.model.bean.Homework;
import io.team.work.model.bean.StudentHomework;
import io.team.work.model.bean.User;
import io.team.work.model.service.impl.ClazzService;
import io.team.work.model.service.impl.HomeworkService;
import io.team.work.model.service.impl.StudentHomeworkService;
import io.team.work.util.FileUploadHelper;
import io.team.work.util.FileUtil;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static io.team.work.util.BeanUtil.PROPERTY_REVIEW_TIME;
import static io.team.work.util.BeanUtil.PROPERTY_REVIEW_CONTENT;
import static io.team.work.util.BeanUtil.PROPERTY_REVIEW_STATUS;
import static io.team.work.util.DateTimeUtil.DATE_TIME_FORMAT;
import static io.team.work.util.ServletUtil.RequestParameterName.ASSIGN_HOMEWORK_CLASS_ID;
import static io.team.work.util.ServletUtil.RequestParameterName.ASSIGN_HOMEWORK_DESCRIBE;
import static io.team.work.util.ServletUtil.RequestParameterName.ASSIGN_HOMEWORK_END_TIME;
import static io.team.work.util.ServletUtil.RequestParameterName.ASSIGN_HOMEWORK_TITLE;
import static io.team.work.util.ServletUtil.RequestParameterName.REVIEW_HOMEWORK_ID;
import static io.team.work.util.ServletUtil.RequestParameterName.REVIEW_HOMEWORK_REVIEW_CONTENT;
import static io.team.work.util.ServletUtil.ResponseDataWrapper;
import static io.team.work.util.ServletUtil.ResponseMessage.FILE_UPLOAD_FAILED;
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
    private static final ClazzService CLAZZ_SERVICE = ClazzService.getInstance();

    /**
     * 根据教师ID获取已布置的作业.
     * <p>
     * 动作函数.
     */
    public void getAssignedHomeworkList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User teacher = (User) request.getSession().getAttribute(USER);
        List<Homework> homeworkList = HOMEWORK_SERVICE.listByTeacherId(teacher.getId());
        response.getWriter().write(ResponseDataWrapper.of(homeworkList));
    }

    /**
     * 根据教师ID获取学生提交了的作业.
     * <p>
     * 动作函数.
     */
    public void getSubmittedHomeworkList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User teacher = (User) request.getSession().getAttribute(USER);
        List<StudentHomework> studentHomeworkList = STUDENT_HOMEWORK_SERVICE.listByTeacherId(teacher.getId());
        response.getWriter().write(ResponseDataWrapper.of(studentHomeworkList));
    }

    /**
     * 获取班级列表.
     * <p>
     * 动作函数.
     */
    public void getClassesList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(CLAZZ_SERVICE.list()));
    }

    /**
     * 布置作业.
     * <p>
     * 动作函数
     */
    public void assignHomework(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FileUploadHelper helper = new FileUploadHelper(request);
        Map<String, String> parameterMap = helper.getParameterMap();
        FileItem fileItem = helper.getFileItem();
        String filename = helper.getFilename();
        User user = (User) request.getSession().getAttribute(USER);
        Integer teacherId = user.getId();

        Homework homework = new Homework();
        homework.setTeacher_id(teacherId);
        homework.setTitle(parameterMap.get(ASSIGN_HOMEWORK_TITLE));
        homework.setDescribe(parameterMap.get(ASSIGN_HOMEWORK_DESCRIBE));
        homework.setEnd_time(parameterMap.get(ASSIGN_HOMEWORK_END_TIME));
        homework.setClass_id(Integer.valueOf(parameterMap.get(ASSIGN_HOMEWORK_CLASS_ID)));
        homework.setAttach_title(filename);
        homework.setAttach_url(FileUtil.HOMEWORK_SAVE_PATH + filename);

        try {
            FileUtil.upload(request, fileItem, FileUtil.HOMEWORK_SAVE_PATH + filename);
            response.getWriter().write(ResponseDataWrapper.of(HOMEWORK_SERVICE.add(homework)));
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write(ResponseDataWrapper.of(false, FILE_UPLOAD_FAILED));
        }
    }

    /**
     * 删除已发布的作业.
     * <p>
     * 动作函数.
     */
    public void deleteHomework(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(
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
        response.getWriter().write(ResponseDataWrapper.of(
                STUDENT_HOMEWORK_SERVICE.update(homeworkId, PROPERTY_REVIEW_CONTENT, reviewContent) &&
                STUDENT_HOMEWORK_SERVICE.update(homeworkId, PROPERTY_REVIEW_TIME, DATE_TIME_FORMAT.format(new Date())) &&
                STUDENT_HOMEWORK_SERVICE.update(homeworkId, PROPERTY_REVIEW_STATUS, true)));
    }
}
