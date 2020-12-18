package io.team.work.model.dao.impl;

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
        String sql = "SELECT `T_Student_homework`.`hw.id`,`T_Student_homework`.`s.id`,`T_Student_homework`.`title`,`T_Student_homework`.`describe`,`T_Student_homework`.`status`,`T_Student_homework`.`review_content`,`T_student_homework`.`review_time`,`T_Student_homework`.`attach_title`,`T_Student_homework`.`attach_url`,`T_User`.`name` FROM `T_student_homework` inner join `T_User` on `T_Student_homework`.`hw_id`=`T_User`.`id` WHERE `type`=1";
        return queryForList(StudentHomework.class, sql, teacherId);
    }

    @Override
    public List<StudentHomework> queryByPage(Integer pageNo, Integer pageSize) {
        String sql = "SELECT `id`,`hw_id`,`s_id`,`status`,`title`,`describe`,`review_content`,`review_time`,`attach_title`,`attach_url` FROM `T_student_homework`  LIMIT ?,?";
        return queryForList(StudentHomework.class, sql, (pageNo-1)*pageSize, pageSize);
    }

    @Override
    public Long countAll() {
        String sql = "SELECT COUNT(1) FROM `T_student_homework`";
        return queryForSingleValue(sql);
    }



    private static class Instance {
        public static final StudentHomeworkDao INSTANCE = new StudentHomeworkDao();
    }

    public static StudentHomeworkDao getInstance() {
        return StudentHomeworkDao.Instance.INSTANCE;
    }
}
