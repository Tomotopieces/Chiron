package io.team.work.model.service.impl;

import io.team.work.model.bean.Homework;
import io.team.work.model.dao.impl.HomeworkDao;
import io.team.work.model.service.AbstractBaseService;

import java.util.List;

/**
 * 教师布置作业Service
 *
 * @author liuxuhui
 * <p>
 * 2020/12/10 16:19
 */
public class HomeworkService extends AbstractBaseService<Homework, Integer> {
    private final HomeworkDao homeworkDao = HomeworkDao.getInstance();

    private HomeworkService() {
    }

    public static HomeworkService getInstance() {
        return HomeworkService.Instance.INSTANCE;
    }

    @Override
    protected HomeworkDao getDao() {
        return homeworkDao;
    }

    /**
     * 通过班级id获取教师布置作业.
     *
     * @param classId 班级id
     * @return 教师布置作业列表
     */
    public List<Homework> listByClassId(Integer classId) {
        return homeworkDao.queryByClassId(classId);
    }

    /**
     * 根据教师id获取教师布置作业
     *
     * @param teacherId 教师id
     * @return 教师布置作业列表
     */
    public List<Homework> listByTeacherId(Integer teacherId) {
        return homeworkDao.queryByTeacherId(teacherId);
    }

    private static final class Instance {
        public static final HomeworkService INSTANCE = new HomeworkService();
    }

}
