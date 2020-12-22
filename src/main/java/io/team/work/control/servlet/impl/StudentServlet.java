package io.team.work.control.servlet.impl;

import io.team.work.control.servlet.AbstractBaseServlet;
import io.team.work.model.bean.StudentHomework;
import io.team.work.model.bean.User;
import io.team.work.model.service.impl.HomeworkService;
import io.team.work.model.service.impl.StudentHomeworkService;
import io.team.work.util.FileUploadHelper;
import io.team.work.util.FileUtil;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.team.work.util.CommonUtil.RequestParameterName.*;
import static io.team.work.util.CommonUtil.ResponseDataWrapper;
import static io.team.work.util.CommonUtil.ResponseMessage.MESSAGE_FILE_UPLOAD_FAILED;
import static io.team.work.util.CommonUtil.SessionAttributeName.USER;

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
    private static final StudentHomeworkService STUDENT_HOMEWORK_SERVICE = StudentHomeworkService.getInstance();

    /**
     * 通过request session获取学生班级id.
     */
    private static Integer getStudentClassId(HttpServletRequest request) {
        return ((User) request.getServletContext().getAttribute(USER)).getClass_id();
    }

    /**
     * 通过request session获取学生id.
     */
    private static Integer getStudentId(HttpServletRequest request) {
        return ((User) request.getSession().getAttribute(USER)).getId();
    }

    /**
     * 根据学生id获取应完成作业.
     * <p>
     * 动作函数.
     */
    public void getHomeworkListByStudentId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(HOMEWORK_SERVICE.listByClassId(getStudentClassId(request))));
    }

    /**
     * 通过学生id分页获取应完成作业
     * <p>
     * 动作函数
     */
    public void getHomeworkListByPageAndStudentId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer pageNo = Integer.valueOf(request.getParameter(GET_ASSIGN_HOMEWORK_BY_PAGE_ID_PAGE_NO));
        Integer pageSize = Integer.valueOf(request.getParameter(GET_ASSIGN_HOMEWORK_BY_PAGE_PAGE_SIZE));

        response.getWriter().write(
                ResponseDataWrapper.of(
                        HOMEWORK_SERVICE.listByPageAndClassId(pageNo, pageSize, getStudentClassId(request))));
    }

    /**
     * 通过学生id获取应完成作业数量
     * <p>
     * 动作函数
     */
    public void getHomeworkCountByStudentId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(HOMEWORK_SERVICE.countByClassId(getStudentClassId(request))));
    }

    /**
     * 根据学生id获取个人已提交作业.
     * <p>
     * 动作函数.
     */
    public void getSubmittedHomeworkListByStudentId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(STUDENT_HOMEWORK_SERVICE.listByStudentId(getStudentId(request))));
    }

    /**
     * 通过学生id分页获取已提交作业
     * <p>
     * 动作函数
     */
    public void getSubmittedHomeworkListByPageAndStudentId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer pageNo = Integer.valueOf(request.getParameter(GET_SUBMIT_HOMEWORK_BY_PAGE_PAGE_NO));
        Integer pageSize = Integer.valueOf(request.getParameter(GET_SUBMIT_HOMEWORK_BY_PAGE_PAGE_SIZE));

        response.getWriter().write(
                ResponseDataWrapper.of(
                        STUDENT_HOMEWORK_SERVICE.listByPageAndClassId(pageNo, pageSize, getStudentClassId(request))));
    }

    /**
     * 通过学生id获取已提交作业数量
     * <p>
     * 动作函数
     */
    public void getSubmittedHomeworkCountByStudnetId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(STUDENT_HOMEWORK_SERVICE.countByClassId(getStudentClassId(request))));
    }

    /**
     * 提交作业.
     * <p>
     * 动作函数.
     */
    public void submitHomework(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FileUploadHelper helper = new FileUploadHelper(request);
        Map<String, String> parameterMap = helper.getParameterMap();
        FileItem fileItem = helper.getFileItem();
        String filename = helper.getFilename();

        StudentHomework studentHomework = new StudentHomework();
        studentHomework.setHw_id(Integer.valueOf(parameterMap.get(SUBMIT_HOMEWORK_HOMEWORK_ID)));
        studentHomework.setS_id(getStudentId(request));
        studentHomework.setStatus(false);
        studentHomework.setTitle(parameterMap.get(SUBMIT_HOMEWORK_TITLE));
        studentHomework.setDescribe(parameterMap.get(SUBMIT_HOMEWORK_DESCRIBE));
        studentHomework.setAttachment_title(filename);
        studentHomework.setAttachment_url(FileUtil.STUDENT_HOMEWORK_SAVE_PATH + filename);

        try {
            FileUtil.upload(request, fileItem, FileUtil.STUDENT_HOMEWORK_SAVE_PATH + filename);
            response.getWriter().write(ResponseDataWrapper.of(STUDENT_HOMEWORK_SERVICE.add(studentHomework)));
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write(ResponseDataWrapper.of(false, MESSAGE_FILE_UPLOAD_FAILED));
        }
    }
}
