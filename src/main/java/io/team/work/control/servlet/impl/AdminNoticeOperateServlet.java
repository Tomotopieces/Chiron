package io.team.work.control.servlet.impl;

import io.team.work.model.bean.Notice;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static io.team.work.util.DateTimeUtil.DATE_TIME_FORMAT;
import static io.team.work.util.ServletUtil.RequestParameterName.ADD_NOTICE_CONTENT;
import static io.team.work.util.ServletUtil.RequestParameterName.ADD_NOTICE_TITLE;
import static io.team.work.util.ServletUtil.RequestParameterName.REMOVE_NOTICE_ID;
import static io.team.work.util.ServletUtil.RequestParameterName.UPDATE_NOTICE_ID;
import static io.team.work.util.ServletUtil.RequestParameterName.UPDATE_NOTICE_PROPERTY_NAME;
import static io.team.work.util.ServletUtil.RequestParameterName.UPDATE_NOTICE_PROPERTY_VALUE;
import static io.team.work.util.ServletUtil.writeResult;

/**
 * 管理员公告板相关操作Servlet类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/9 16:38
 */
@WebServlet("/admin.notice.do")
public class AdminNoticeOperateServlet {
    private static final NoticeService NOTICE_SERVICE = NoticeService.getInstance();

    /**
     * 添加公告.
     * <p>
     * 动作函数.
     */
    public void addNotice(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter(ADD_NOTICE_TITLE);
        String content = request.getParameter(ADD_NOTICE_CONTENT);

        Notice notice = new Notice();
        notice.setTitle(title);
        notice.setContent(content);
        notice.setCreate_time(DATE_TIME_FORMAT.format(new Date()));

        writeResult(NOTICE_SERVICE.add(notice));
    }

    /**
     * 移除公告.
     * <p>
     * 动作函数.
     */
    public void removeNotice(HttpServletRequest request, HttpServletResponse response) {
        writeResult(NOTICE_SERVICE.remove(request.getParameter(REMOVE_NOTICE_ID)));
    }

    /**
     * 更新公告.
     * <p>
     * 动作函数.
     */
    public void updateNotice(HttpServletRequest request, HttpServletResponse response) {
        Integer noticeId = Integer.valueOf(request.getParameter(UPDATE_NOTICE_ID));
        String propertyName = request.getParameter(UPDATE_NOTICE_PROPERTY_NAME);
        String propertyValue = request.getParameter(UPDATE_NOTICE_PROPERTY_VALUE);

        writeResult(NOTICE_SERVICE.update(noticeId, propertyName, propertyValue));
    }
}
