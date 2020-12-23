package io.team.work.control.servlet.impl;

import io.team.work.control.servlet.AbstractBaseServlet;
import io.team.work.model.bean.Clazz;
import io.team.work.model.service.impl.ClazzService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static io.team.work.util.CommonUtil.RequestParameterName.*;
import static io.team.work.util.CommonUtil.ResponseDataWrapper;
import static io.team.work.util.CommonUtil.ResponseMessage.ADD_DATA_EMPTY_VALUE;

/**
 * 管理员班级相关操作Servlet类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/9 16:32
 */
@WebServlet("/admin.class.do")
public class AdminClassOperateServlet extends AbstractBaseServlet {
    private static final ClazzService CLAZZ_SERVICE = ClazzService.getInstance();

    /**
     * 添加新班级.
     * <p>
     * 动作函数.
     */
    public void addClass(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String classNo = request.getParameter(ADD_CLASS_CLASS_NO);
        String className = request.getParameter(ADD_CLASS_CLASS_NAME);

        if (classNo == null || className == null) {
            response.getWriter().write(ResponseDataWrapper.of(false, ADD_DATA_EMPTY_VALUE));
        }

        Clazz clazz = new Clazz();
        clazz.setClassNo(classNo);
        clazz.setClassName(className);

        response.getWriter().write(ResponseDataWrapper.of(CLAZZ_SERVICE.add(clazz)));
    }

    /**
     * 移除班级.
     * <p>
     * 动作函数.
     */
    public void removeClass(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(
                ResponseDataWrapper.of(
                        CLAZZ_SERVICE.remove(Integer.valueOf(request.getParameter(REMOVE_CLASS_ID)))));
    }

    /**
     * 获取所有班级信息.
     * <p>
     * 动作函数.
     */
    public void getClassList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(CLAZZ_SERVICE.list()));
    }

    /**
     * 分页获取班级信息
     * <p>
     * 动作函数
     */
    public void getClassListByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer pageNo = Integer.valueOf(request.getParameter(GET_CLASS_BY_PAGE_PAGE_NO));
        Integer pageSize = Integer.valueOf(request.getParameter(GET_CLASS_BY_PAGE_PAGE_SIZE));

        response.getWriter().write(ResponseDataWrapper.of(CLAZZ_SERVICE.listByPage(pageNo, pageSize)));
    }

    /**
     * 获取班级总数
     * <p>
     * 动作函数
     */
    public void getClassCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(CLAZZ_SERVICE.count()));
    }
}
