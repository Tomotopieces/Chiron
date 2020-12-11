package io.team.work.model.service.impl;

import io.team.work.model.bean.StudentHomeworkAttach;
import io.team.work.model.dao.Dao;
import io.team.work.model.dao.impl.StudentHomeworkAttachDao;
import io.team.work.model.service.AbstractBaseService;

/**
 * 学生提交作业 附件Service
 *
 * @author liuxuhui
 * <p>
 * 2020/12/10 18:02
 */
public class StudentHomeworkAttachService extends AbstractBaseService<StudentHomeworkAttach, Integer> {
    private final StudentHomeworkAttachDao studentHomeworkAttachDao = StudentHomeworkAttachDao.getInstance();

    private StudentHomeworkAttachService() {
    }

    public static StudentHomeworkAttachService getInstance() {
        return Instance.INSTANCE;
    }

    @Override
    protected Dao<StudentHomeworkAttach, Integer> getDao() {
        return studentHomeworkAttachDao;
    }

    private static final class Instance {
        public static final StudentHomeworkAttachService INSTANCE = new StudentHomeworkAttachService();
    }
}
