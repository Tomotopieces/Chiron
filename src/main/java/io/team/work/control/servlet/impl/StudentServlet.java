package io.team.work.control.servlet.impl;

import io.team.work.control.servlet.AbstractBaseServlet;
import io.team.work.model.bean.Homework;
import io.team.work.model.bean.StudentHomework;
import io.team.work.model.bean.User;
import io.team.work.model.service.impl.HomeworkAttachService;
import io.team.work.model.service.impl.HomeworkService;
import io.team.work.model.service.impl.StudentHomeworkAttachService;
import io.team.work.model.service.impl.StudentHomeworkService;
import io.team.work.util.FileUploadHelper;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.team.work.util.ServletUtil.*;
import static io.team.work.util.ServletUtil.SessionAttributeName.USER;

/**
 * 学生相关操作Servlet类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/9 10:47
 */
@WebServlet("/student.do")
public class StudentServlet extends AbstractBaseServlet {
    private static final HomeworkService HOMEWORK_SERVICE = HomeworkService.getInstance();
    private static final HomeworkAttachService HOMEWORK_ATTACH_SERVICE = HomeworkAttachService.getInstance();
    private static final StudentHomeworkService STUDENT_HOMEWORK_SERVICE = StudentHomeworkService.getInstance();
    private static final StudentHomeworkAttachService STUDENT_HOMEWORK_ATTACH_SERVICE =
            StudentHomeworkAttachService.getInstance();

    /**
     * 根据学生班级id查询应完成作业.
     * <p>
     * 动作函数.
     */
    public void getHomeworkList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User student = (User) request.getSession().getAttribute(USER);
        List<Homework> homeworkList = HOMEWORK_SERVICE.listByClassId(student.getClass_id());
        response.getWriter().write(ResponseDataWrapper.of(homeworkList));
    }

    /**
     * 根绝学生id查询个人已完成作业.
     * <p>
     * 动作函数.
     */
    public void getFinishedHomeworkList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User student = (User) request.getSession().getAttribute(USER);
        List<StudentHomework> studentHomeworkList = STUDENT_HOMEWORK_SERVICE.listByStudentId(student.getId());
        response.getWriter().write(ResponseDataWrapper.of(studentHomeworkList));
    }

    /**
     * 上传作业.
     * <p>
     * 动作函数.
     */
    public void uploadHomework(HttpServletRequest request, HttpServletResponse response) {
        FileUploadHelper helper = new FileUploadHelper(request);
        Map<String, String> parameterMap = helper.getParameterMap();
        FileItem fileItem = helper.getFileItem();
        String filename = helper.getFilename();
        // todo
    }
}
