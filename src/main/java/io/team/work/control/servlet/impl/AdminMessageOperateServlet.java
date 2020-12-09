package io.team.work.control.servlet.impl;

import io.team.work.control.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static io.team.work.util.ServletUtil.RequestParameterName.REMOVE_MESSAGE_ID;
import static io.team.work.util.ServletUtil.writeResult;

/**
 * 管理员留言板相关操作Servlet类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/9 16:34
 */
@WebServlet("/admin.message.do")
public class AdminMessageOperateServlet extends BaseServlet {
    private static final MessageService MESSAGE_SERVICE = MessageService.getInstance();

    /**
     * 移除留言.
     * <p>
     * 动作函数
     */
    public void removeMessage(HttpServletRequest request, HttpServletResponse response) {
        writeResult(MESSAGE_SERVICE.remove(REMOVE_MESSAGE_ID));
    }
}
