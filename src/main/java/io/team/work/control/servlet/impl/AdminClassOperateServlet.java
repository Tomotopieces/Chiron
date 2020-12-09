package io.team.work.control.servlet.impl;

import io.team.work.control.servlet.BaseServlet;
import io.team.work.model.bean.Clazz;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static io.team.work.util.ServletUtil.GSON;
import static io.team.work.util.ServletUtil.RequestParameterName.ADD_CLASS_CLASS_NAME;
import static io.team.work.util.ServletUtil.RequestParameterName.ADD_CLASS_CLASS_NO;
import static io.team.work.util.ServletUtil.RequestParameterName.REMOVE_CLASS_ID;
import static io.team.work.util.ServletUtil.writeResult;

/**
 * 管理员班级相关操作Servlet类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/9 16:32
 */
@WebServlet("/admin.class.do")
public class AdminClassOperateServlet extends BaseServlet {
    private static final ClassService CLASS_SERVICE = ClassService.getInstance();

    /**
     * 添加新班级.
     * <p>
     * 动作函数.
     */
    public void addClass(HttpServletRequest request, HttpServletResponse response) {
        String classNo = request.getParameter(ADD_CLASS_CLASS_NO);
        String className = request.getParameter(ADD_CLASS_CLASS_NAME);

        Clazz clazz = new Clazz();
        clazz.setClassNo(classNo);
        clazz.setClassName(className);

        writeResult(CLASS_SERVICE.add(clazz));
    }

    /**
     * 移除班级.
     * <p>
     * 动作函数.
     */
    public void removeClass(HttpServletRequest request, HttpServletResponse response) {
        writeResult(CLASS_SERVICE.remove(request.getParameter(REMOVE_CLASS_ID)));
    }

    /**
     * 获取所有班级信息.
     * <p>
     * 动作函数.
     */
    public void getClasses(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(GSON.toJson(CLASS_SERVICE.listClasses()));
    }
}
