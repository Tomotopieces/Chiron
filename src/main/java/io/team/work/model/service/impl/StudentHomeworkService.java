package io.team.work.model.service.impl;

import io.team.work.model.bean.StudentHomework;
import io.team.work.model.dao.Dao;
import io.team.work.model.dao.impl.StudentHomeworkDao;
import io.team.work.model.service.AbstractBaseService;

import java.util.List;

/**
 * 学生提交作业Service
 *
 * @author liuxuhui
 * <p>
 * 2020/12/10 16:54
 */
public class StudentHomeworkService extends AbstractBaseService<StudentHomework, Integer> {
    private final StudentHomeworkDao studentHomeworkDao = StudentHomeworkDao.getInstance();

    private StudentHomeworkService() {
    }

    public static StudentHomeworkService getInstance() {
        return Instance.INSTANCE;
    }

    @Override
    protected StudentHomeworkDao getDao() {
        return studentHomeworkDao;
    }

    /**
     * 根据学生id获取学生提交作业.
     *
     * @param studentId 学生id
     * @return 学生提交作业列表
     */
    public List<StudentHomework> listByStudentId(Integer studentId) {
        // todo
        return null;
    }

    /**
     * 根据教师id获取学生提交作业
     *
     * @param teacherId 学生id
     * @return 学生提交作业列表
     */
    public List<StudentHomework> listByTeacherId(Integer teacherId) {
        // todo
        return null;
    }

    private static final class Instance {
        public static final StudentHomeworkService INSTANCE = new StudentHomeworkService();
    }
}
