package io.team.work.model.dao.impl;

import io.team.work.model.bean.Homework;
import io.team.work.model.dao.AbstractBaseDao;

import java.util.List;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 16:20
 * 描述:作业
 */
public class HomeworkDao extends AbstractBaseDao<Homework, Integer> {
    private HomeworkDao() {
    }

    private static final String TABLE_NAME = "T_homework";

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }


    @Override
    public int insert(Homework homework) {
        String sql = "INSERT INTO `T_homework`(`teacher_id`,`title`,`describe`,`class_id`,`end_time`,`attachment_title`,`attachment_url`) VALUES(?,?,?,?,?,?,?)";
        return update(sql, homework.getTeacher_id(), homework.getTitle(), homework.getDescribe(), homework.getClass_id(), homework.getEnd_time(), homework.getAttachment_title(), homework.getAttachment_url());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM `T_homework` WHERE `id`=?";
        return update(sql, id);
    }

    public int update(Homework homework) {
        String sql = "UPDATE `T_homework` SET `teacher_id`=?,`title`=?,`describe`=?,`class_id`=?,`end_time`=?,`attachment_title`=?,`attachment_url`=? WHERE `id`=?";
        return update(sql, homework.getTeacher_id(), homework.getTitle(), homework.getDescribe(), homework.getClass_id(), homework.getEnd_time(), homework.getAttachment_title(), homework.getAttachment_url(), homework.getId());
    }

    @Override
    public List<Homework> queryAll() {
        String sql = "SELECT `id`,`teacher_id`,`title`,`describe`,`class_id`,`end_time`,`attachment_title`,`attachment_url` FROM `T_homework`";
        return queryForList(Homework.class, sql);
    }

    @Override
    public Homework queryById(Integer id) {
        String sql = "SELECT `id`,`teacher_id`,`title`,`describe`,`class_id`,`end_time`,`attachment_title`,`attachment_url` FROM `T_homework` WHERE `id`=?";
        return queryForOne(Homework.class, sql, id);
    }

    /**
     * 全部分页查询
     *
     * @param pageNo   页码
     * @param pageSize 条数
     * @return
     */
    @Override
    public List<Homework> queryByPage(Integer pageNo, Integer pageSize) {
        String sql = "SELECT `id`, `teacher_id`, `title`, `describe`, `class_id`, `end_time`, `attachment_title`, `attachment_url` FROM `T_homework` LIMIT ?,?";
        return queryForList(Homework.class, sql, (pageNo - 1) * pageSize, pageSize);
    }

    /**
     * 根据班级ID查询分页
     *
     * @param pageNo   页码
     * @param pageSize 条数
     * @return
     */
    public List<Homework> listByPageAndClassId( Integer classId,Integer pageNo, Integer pageSize) {
        String sql = "SELECT `id`, `teacher_id`, `title`, `describe`, `class_id`, `end_time`, `attachment_title`, `attachment_url` FROM `T_homework` WHERE `class_id`=? LIMIT ?,?";
        return queryForList(Homework.class, sql,  classId, (pageNo - 1) * pageSize, pageSize);
    }

    /**
     * 根据教师ID查询分页
     *
     * @param pageNo   页码
     * @param pageSize 条数
     * @return
     */
    public List<Homework> listByPageAndTeacherId(Integer teacherId,Integer pageNo, Integer pageSize) {
        String sql = "SELECT `id`, `teacher_id`, `title`, `describe`, `class_id`, `end_time`, `attachment_title`, `attachment_url` FROM `T_homework` WHERE `teacher_id`= ? LIMIT ?,?";
        return queryForList(Homework.class, sql, teacherId, (pageNo - 1) * pageSize, pageSize);
    }

    /**
     * 记录全部总数
     *
     * @return
     */
    @Override
    public Long countAll() {
        String sql = "SELECT COUNT(1) FROM `T_homework`";
        return queryForSingleValue(sql);
    }

    /**
     * 根据班级ID查找总条数
     *
     * @param classId
     * @return
     */
    public Long countByClassId(Integer classId) {
        String sql = "SELECT COUNT(1) FROM `T_homework` WHERE `class_id`=?";
        return queryForSingleValue(sql, classId);
    }

    public Long countByTeacherId(Integer teacherId) {
        String sql = "SELECT COUNT(1) FROM `T_homework` WHERE `teacher_id`=?";
        return queryForSingleValue(sql, teacherId);
    }

    public List<Homework> queryByTeacherId(Integer teacher_id) {
        String sql = "SELECT `id`,`teacher_id`,`title`,`describe`,`class_id`,`end_time`,`attachment_title`,`attachment_url` FROM `T_homework` WHERE `teacher_id`=?";
        return queryForList(Homework.class, sql, teacher_id);
    }

    public List<Homework> queryByClassId(Integer class_id) {
        String sql = "SELECT `id`,`teacher_id`,`title`,`describe`,`class_id`,`end_time`,`attachment_title`,`attachment_url` FROM `T_homework` WHERE `class_id`=?";
        return queryForList(Homework.class, sql, class_id);
    }


    private static class Instance {
        public static final HomeworkDao INSTANCE = new HomeworkDao();
    }

    public static HomeworkDao getInstance() {
        return HomeworkDao.Instance.INSTANCE;
    }
}
