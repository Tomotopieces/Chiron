package io.team.work.control.servlet.impl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 教师相关操作Servlet类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/9 9:14
 */
@WebServlet("/teacher.do")
public class TeacherServlet {
    private static final HomeworkDao HOMEWORK_DAO = HomeworkDao.getInstance();

    /**
     * 作业审阅.
     * <p>
     * 动作函数.
     */
    public void review(HttpServletRequest request, HttpServletResponse response) {
        String homeworkId = request.getParameter("homeworkId");
        String reviewContent = request.getParameter("reviewContent");
        if (HOMEWORK_DAO.update(homeworkId, "review_content", reviewContent)) {

        }
    }
}
