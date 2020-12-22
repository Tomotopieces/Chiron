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
        return studentHomeworkDao.queryByStudentId(studentId);
    }

    /**
     * 根据教师id获取学生提交作业
     *
     * @param teacherId 学生id
     * @return 学生提交作业列表
     */
    public List<StudentHomework> listByTeacherId(Integer teacherId) {
        return studentHomeworkDao.queryByTeacherId(teacherId);
    }

    /**
     * 关联教师布置作业表，然后根据班级ID分页查询
     *
     * @param pageNo   页码
     * @param pageSize 条数
     * @param classId  班级ID
     * @return 学生作业列表
     */
    public List<StudentHomework> listByPageAndClassId(Integer classId, Integer pageNo, Integer pageSize) {
        return studentHomeworkDao.listByPageAndClassId(classId, pageNo, pageSize);
    }

    /**
     * 关联教师布置作业表，然后根据教师ID分页查询
     *
     * @param pageNo    页码
     * @param pageSize  条数
     * @param teacherId 教师ID
     * @return 学生作业列表
     */
    public List<StudentHomework> listByPageAndTeacherId(Integer pageNo, Integer pageSize, Integer teacherId) {
        return studentHomeworkDao.listByPageAndTeacherId(teacherId, pageNo, pageSize);
    }

    /**
     * 根据班级ID查找记录，并记录共有多少条
     *
     * @param classId 班级ID
     * @return 关联教师布置作业表，并根据班级ID查找出来的条数
     */
    public Long countByClassId(Integer classId) {
        return studentHomeworkDao.countByClassId(classId);
    }

    /**
     * 根据教师ID查找记录，并记录共有多少条
     *
     * @param teacherId 教师ID
     * @return 关联教师布置作业表，并根据教师ID查找出来的条数
     */
    public Long countByTeacherId(Integer teacherId) {
        return studentHomeworkDao.countByTeacherId(teacherId);
    }

    private static final class Instance {
        public static final StudentHomeworkService INSTANCE = new StudentHomeworkService();
    }
}
