package io.team.work.control.servlet.impl;

import io.team.work.control.servlet.AbstractBaseServlet;
import io.team.work.model.bean.Clazz;
import io.team.work.model.service.impl.ClazzService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static io.team.work.util.CommonUtil.RequestParameterName.ADD_CLASS_CLASS_NAME;
import static io.team.work.util.CommonUtil.RequestParameterName.ADD_CLASS_CLASS_NO;
import static io.team.work.util.CommonUtil.RequestParameterName.REMOVE_CLASS_ID;
import static io.team.work.util.CommonUtil.ResponseDataWrapper;

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
    public void getClasses(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(CLAZZ_SERVICE.list()));
    }
}
