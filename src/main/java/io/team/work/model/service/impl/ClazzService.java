package io.team.work.model.service.impl;

import io.team.work.model.bean.Clazz;
import io.team.work.model.dao.impl.ClazzDao;
import io.team.work.model.service.AbstractBaseService;

/**
 * 班级Service
 *
 * @author liuxuhui
 * <p>
 * 2020/12/10 16:05
 */
public class ClazzService extends AbstractBaseService<Clazz, Integer> {
    private final ClazzDao clazzDao = ClazzDao.getInstance();

    private ClazzService() {
    }

    public static ClazzService getInstance() {
        return Instance.INSTANCE;
    }

    @Override
    protected ClazzDao getDao() {
        return clazzDao;
    }

    private static final class Instance {
        public static final ClazzService INSTANCE = new ClazzService();
    }
}
