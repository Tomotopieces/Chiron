package io.team.work.control.servlet.impl;

import io.team.work.control.servlet.AbstractBaseServlet;
import io.team.work.model.bean.Notice;
import io.team.work.model.service.impl.NoticeService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static io.team.work.util.CommonUtil.RequestParameterName.*;
import static io.team.work.util.CommonUtil.ResponseDataWrapper;
import static io.team.work.util.CommonUtil.ResponseMessage.ADD_DATA_EMPTY_VALUE;
import static io.team.work.util.DateTimeUtil.DATE_TIME_FORMAT;

/**
 * 管理员公告板相关操作Servlet类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/9 16:38
 */
@WebServlet("/admin.notice.do")
public class AdminNoticeOperateServlet extends AbstractBaseServlet {
    private static final NoticeService NOTICE_SERVICE = NoticeService.getInstance();

    /**
     * 添加公告.
     * <p>
     * 动作函数.
     */
    public void addNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter(ADD_NOTICE_TITLE);
        String content = request.getParameter(ADD_NOTICE_CONTENT);

        if (title == null || content == null) {
            response.getWriter().write(ResponseDataWrapper.of(false, ADD_DATA_EMPTY_VALUE));
        }

        Notice notice = new Notice();
        notice.setTitle(title);
        notice.setContent(content);
        notice.setCreate_time(DATE_TIME_FORMAT.format(new Date()));

        response.getWriter().write(ResponseDataWrapper.of(NOTICE_SERVICE.add(notice)));
    }

    /**
     * 移除公告.
     * <p>
     * 动作函数.
     */
    public void removeNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(
                ResponseDataWrapper.of(
                        NOTICE_SERVICE.remove(Integer.valueOf(request.getParameter(REMOVE_NOTICE_ID)))));
    }

    /**
     * 获取公告列表.
     * <p>
     * 动作函数.
     */
    public void getNoticeList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(NOTICE_SERVICE.list()));
    }

    /**
     * 分页获取公告
     * <p>
     * 动作函数
     */
    public void getNoticeListByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer pageNo = Integer.valueOf(request.getParameter(GET_NOTICE_BY_PAGE_PAGE_NO));
        Integer pageSize = Integer.valueOf(request.getParameter(GET_NOTICE_BY_PAGE_PAGE_SIZE));

        response.getWriter().write(ResponseDataWrapper.of(NOTICE_SERVICE.listByPage(pageNo, pageSize)));
    }

    /**
     * 更新公告.
     * <p>
     * 动作函数.
     */
    public void updateNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer noticeId = Integer.valueOf(request.getParameter(UPDATE_NOTICE_ID));
        String propertyName = request.getParameter(UPDATE_NOTICE_PROPERTY_NAME);
        String propertyValue = request.getParameter(UPDATE_NOTICE_PROPERTY_VALUE);

        response.getWriter().write(
                ResponseDataWrapper.of(NOTICE_SERVICE.update(noticeId, propertyName, propertyValue)));
    }

    /**
     * 获取公告总数
     * <p>
     * 动作函数
     */
    public void getNoticeCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(ResponseDataWrapper.of(NOTICE_SERVICE.count()));
    }
}
