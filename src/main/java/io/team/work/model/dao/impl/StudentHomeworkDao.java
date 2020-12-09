package io.team.work.model.dao.impl;

import io.team.work.model.bean.StudentHomework;
import io.team.work.model.dao.BaseDao;

import java.util.List;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 18:35
 * 描述:学生作业
 */
public class StudentHomeworkDao extends BaseDao<StudentHomework, Integer> {
    @Override
    public int insert(StudentHomework studentHomework) {
        String sql = "INSERT INTO `Stu_hw`(`hw_id`,`s_id`,`status`,`review_content`,`review_time`)";
        return update(sql, studentHomework.getHw_id(), studentHomework.getS_id(), studentHomework.getStatus(), studentHomework.getReview_content(), studentHomework.getReview_time());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM `Stu_hw` WHERE id=?";
        return update(sql, id);
    }

    @Override
    public int update(StudentHomework studentHomework) {
        String sql = "UPDATE `Stu_hw` SET `hw_id`=?,`s_id`=?,`status`=?,`review_content`,`review_time`=? WHERE id =?";
        return update(sql, studentHomework.getHw_id(), studentHomework.getS_id(), studentHomework.getStatus(), studentHomework.getReview_content(), studentHomework.getReview_time(), studentHomework.getId());
    }

    @Override
    public List<StudentHomework> queryAll() {
        String sql = "SELECT `id`,`hw_id`,`s_id`,`status`,`review_content`,`review_time` FROM `Stu_hw`";
        return queryForList(StudentHomework.class, sql);
    }

    @Override
    public StudentHomework queryById(Integer id) {
        String sql = "SELECT `id`,`hw_id`,`s_id`,`status`,`review_content`,`review_time` FROM `Stu_hw` WHERE `id` = ?";
        return queryForOne(StudentHomework.class, sql, id);
    }

    @Override
    public List<StudentHomework> queryByPage(Integer pageNo, Integer pageSize) {
        String sql = "SELECT `id`,`hw_id`,`s_id`,`status`,`review_content`,`review_time` FROM `Stu_hw`  LIMIT ?,?";
        return queryForList(StudentHomework.class, sql, pageNo, pageSize);
    }

    @Override
    public Integer CountAll() {
        String sql = "SELECT COUNT(1) FROM `Stu_hw`";
        return Math.toIntExact(queryForSingleValue(sql));
    }

    private static class Instance {
        public static final StudentHomeworkDao INSTANCE = new StudentHomeworkDao();
    }

    public static StudentHomeworkDao getInstance() {
        return StudentHomeworkDao.Instance.INSTANCE;
    }
}
