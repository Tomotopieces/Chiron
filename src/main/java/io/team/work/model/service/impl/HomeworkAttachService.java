package io.team.work.model.service.impl;

import io.team.work.model.bean.HomeworkAttach;
import io.team.work.model.dao.impl.HomeworkAttachDao;
import io.team.work.model.service.AbstractBaseService;

/**
 * 老师布置作业 附件Service
 *
 * @author liuxuhui
 * <p>
 * 2020/12/10 16:36
 */
public class HomeworkAttachService extends AbstractBaseService<HomeworkAttach, Integer> {
    private final HomeworkAttachDao homeworkAttachDao = HomeworkAttachDao.getInstance();

    private HomeworkAttachService() {
    }

    public static HomeworkAttachService getInstance() {
        return Instance.INSTANCE;
    }

    @Override
    protected HomeworkAttachDao getDao() {
        return homeworkAttachDao;
    }

    public static final class Instance {
        public static final HomeworkAttachService INSTANCE = new HomeworkAttachService();
    }
}
