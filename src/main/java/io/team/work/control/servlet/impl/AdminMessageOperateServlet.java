package io.team.work.control.servlet.impl;

import io.team.work.control.servlet.AbstractBaseServlet;
import io.team.work.model.service.impl.MessageService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static io.team.work.util.CommonUtil.*;
import static io.team.work.util.CommonUtil.RequestParameterName.REMOVE_MESSAGE_ID;

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
     * 移除留言.
     * <p>
     * 动作函数
     */
    public void removeMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(
                ResponseDataWrapper.of(
                        MESSAGE_SERVICE.remove(Integer.valueOf(request.getParameter(REMOVE_MESSAGE_ID)))));
    }
}
