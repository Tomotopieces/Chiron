package io.team.work.control.servlet.impl;

import io.team.work.control.servlet.AbstractBaseServlet;
import io.team.work.model.service.impl.MessageService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static io.team.work.util.CommonUtil.RequestParameterName.*;
import static io.team.work.util.CommonUtil.ResponseDataWrapper;

/**
 * 管理员留言板相关操作Servlet类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/9 16:34
 */
@WebServlet("/admin.message.do")
public class AdminMessageOperateServlet extends AbstractBaseServlet {
    private static final MessageService MESSAGE_SERVICE = MessageService.getInstance();

    /**
     * 获取留言列表.
     * <p>
     * 动作函数.
     */
    public void getMessageList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(MESSAGE_SERVICE.list()));
    }

    /**
     * 分页获取留言
     * <p>
     * 动作函数
     */
    public void getMessageListByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer pageNo = Integer.valueOf(request.getParameter(GET_MESSAGE_BY_PAGE_PAGE_NO));
        Integer pageSize = Integer.valueOf(request.getParameter(GET_MESSAGE_BY_PAGE_PAGE_SIZE));

        response.getWriter().write(ResponseDataWrapper.of(MESSAGE_SERVICE.listByPage(pageNo, pageSize)));
    }

    /**
     * 移除留言.
     * <p>
     * 动作函数
     */
    public void removeMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(
                ResponseDataWrapper.of(
                        MESSAGE_SERVICE.remove(Integer.valueOf(request.getParameter(REMOVE_MESSAGE_ID)))));
    }

    /**
     * 获取留言总数
     * <p>
     * 动作函数
     */
    public void getMessageCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(MESSAGE_SERVICE.count()));
    }
}
