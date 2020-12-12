package io.team.work.model.dao.impl;

import io.team.work.model.bean.Homework;
import io.team.work.model.bean.StudentHomework;
import io.team.work.model.dao.AbstractBaseDao;

import java.util.List;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 18:35
 * 描述:学生作业
 */
public class StudentHomeworkDao extends AbstractBaseDao<StudentHomework, Integer> {
    private StudentHomeworkDao() {
    }

    private static final String TABLE_NAME = "T_student_homework";

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }


    @Override
    public int insert(StudentHomework studentHomework) {
        String sql = "INSERT INTO `T_student_homework`(`hw_id`,`s_id`,`status`,`title`,`describe`,`review_content`,`review_time`,`attach_title`,`attach_url`) VALUES(?,?,?,?,?,?,?,?)";
        return update(sql, studentHomework.getHw_id(), studentHomework.getS_id(), studentHomework.getStatus(), studentHomework.getReview_content(), studentHomework.getReview_time(), studentHomework.getAttach_title(), studentHomework.getAttach_url());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM `T_student_homework` WHERE id=?";
        return update(sql, id);
    }


    public int update(StudentHomework studentHomework) {
        String sql = "UPDATE `T_student_homework` SET `hw_id`=?,`s_id`=?,`status`=?,`title`=?,`describe`=?,`review_content`=?,`review_time`=?,`attach_title`=?,`attach_url`=? WHERE id =?";
        return update(sql, studentHomework.getHw_id(), studentHomework.getS_id(), studentHomework.getStatus(), studentHomework.getReview_content(), studentHomework.getReview_time(), studentHomework.getAttach_title(), studentHomework.getAttach_url(), studentHomework.getId());
    }

    @Override
    public List<StudentHomework> queryAll() {
        String sql = "SELECT `id`,`hw_id`,`s_id`,`status`,`title`,`describe`,`review_content`,`review_time`,`attach_title`,`attach_url` FROM `T_student_homework`";
        return queryForList(StudentHomework.class, sql);
    }

    @Override
    public StudentHomework queryById(Integer id) {
        String sql = "SELECT `id`,`hw_id`,`s_id`,`status`,`title`,`describe`,`review_content`,`review_time`,`attach_title`,`attach_url` FROM `T_student_homework` WHERE `id` = ?";
        return queryForOne(StudentHomework.class, sql, id);
    }

    public List<StudentHomework> queryByStudentId(Integer s_id) {
        String sql = "SELECT `id`,`hw_id`,`s_id`,`title`,`describe`,`status`,`review_content`,`review_time`,`attach_title`,`attach_url` FROM `T_student_homework` WHERE `s_id`=?";
        return queryForList(StudentHomework.class, sql, s_id);
    }

    public List<StudentHomework> queryByTeacherId(Integer teacherId) {
        String sql = "SELECT `Stu_hw`.`hw.id`,`Stu_hw`.`s.id`,`Stu_hw`.`title`,`Stu_hw`.`describe`,`Stu_hw`.`status`,`Stu_hw`.`review_content`,`T_student_homework`.`review_time`,`Stu_hw`.`attach_title`,`Stu_hw`.`attach_url`,`User`.`name` FROM `stu_hw` inner join `User` on `Stu_hw`.`hw_id`=`User`.`id` WHERE `type`=1";
        return queryForList(StudentHomework.class, sql, teacherId);
    }

    @Override
    public List<StudentHomework> queryByPage(Integer pageNo, Integer pageSize) {
        String sql = "SELECT `id`,`hw_id`,`s_id`,`status`,`title`,`describe`,`review_content`,`review_time`,`attach_title`,`attach_url` FROM `T_student_homework`  LIMIT ?,?";
        return queryForList(StudentHomework.class, sql, pageNo, pageSize);
    }

    @Override
    public Integer CountAll() {
        String sql = "SELECT COUNT(1) FROM `T_student_homework`";
        return Math.toIntExact(queryForSingleValue(sql));
    }



    private static class Instance {
        public static final StudentHomeworkDao INSTANCE = new StudentHomeworkDao();
    }

    public static StudentHomeworkDao getInstance() {
        return StudentHomeworkDao.Instance.INSTANCE;
    }
}
