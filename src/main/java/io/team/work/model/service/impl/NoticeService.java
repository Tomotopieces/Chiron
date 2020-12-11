package io.team.work.model.service.impl;

import io.team.work.model.bean.Notice;
import io.team.work.model.dao.impl.NoticeDao;
import io.team.work.model.service.AbstractBaseService;

/**
 * 公告Service
 *
 * @author liuxuhui
 * <p>
 * 2020/12/10 18:11
 */
public class NoticeService extends AbstractBaseService<Notice, Integer> {
    private final NoticeDao noticeDao = NoticeDao.getInstance();

    private NoticeService() {
    }

    public static NoticeService getInstance() {
        return NoticeService.Instance.INSTANCE;
    }

    @Override
    protected NoticeDao getDao() {
        return noticeDao;
    }

    private static final class Instance {
        public static final NoticeService INSTANCE = new NoticeService();
    }
}
