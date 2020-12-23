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
        String sql = "INSERT INTO `T_student_homework`(`hw_id`,`s_id`,`status`,`title`,`describe`,`review_content`,`review_time`,`attachment_title`,`attachment_url`) VALUES(?,?,?,?,?,?,?,?)";
        return update(sql, studentHomework.getHw_id(), studentHomework.getS_id(), studentHomework.getStatus(), studentHomework.getReview_content(), studentHomework.getReview_time(), studentHomework.getAttachment_title(), studentHomework.getAttachment_url());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM `T_student_homework` WHERE id=?";
        return update(sql, id);
    }


    public int update(StudentHomework studentHomework) {
        String sql = "UPDATE `T_student_homework` SET `hw_id`=?,`s_id`=?,`status`=?,`title`=?,`describe`=?,`review_content`=?,`review_time`=?,`attachment_title`=?,`attachment_url`=? WHERE id =?";
        return update(sql, studentHomework.getHw_id(), studentHomework.getS_id(), studentHomework.getStatus(), studentHomework.getReview_content(), studentHomework.getReview_time(), studentHomework.getAttachment_title(), studentHomework.getAttachment_url(), studentHomework.getId());
    }

    @Override
    public List<StudentHomework> queryAll() {
        String sql = "SELECT `id`,`hw_id`,`s_id`,`status`,`title`,`describe`,`review_content`,`review_time`,`attachment_title`,`attachment_url` FROM `T_student_homework`";
        return queryForList(StudentHomework.class, sql);
    }

    @Override
    public StudentHomework queryById(Integer id) {
        String sql = "SELECT `id`,`hw_id`,`s_id`,`status`,`title`,`describe`,`review_content`,`review_time`,`attachment_title`,`attachment_url` FROM `T_student_homework` WHERE `id` = ?";
        return queryForOne(StudentHomework.class, sql, id);
    }

    public List<StudentHomework> queryByStudentId(Integer s_id) {
        String sql = "SELECT `id`,`hw_id`,`s_id`,`title`,`describe`,`status`,`review_content`,`review_time`,`attachment_title`,`attachment_url` FROM `T_student_homework` WHERE `s_id`=?";
        return queryForList(StudentHomework.class, sql, s_id);
    }

    public List<StudentHomework> queryByTeacherId(Integer teacherId) {
        String sql = "SELECT `T_Student_homework`.`hw_id`,`T_Student_homework`.`s_id`,`T_Student_homework`.`title`,`T_Student_homework`.`describe`,`T_Student_homework`.`status`,`T_Student_homework`.`review_content`,`T_student_homework`.`review_time`,`T_Student_homework`.`attachment_title`,`T_Student_homework`.`attachment_url`,`T_User`.`name` FROM `T_student_homework` inner join `T_User` on `T_Student_homework`.`hw_id`=`T_User`.`id` WHERE `type`=1";
        return queryForList(StudentHomework.class, sql, teacherId);
    }

    @Override
    public List<StudentHomework> queryByPage(Integer pageNo, Integer pageSize) {
        String sql = "SELECT `id`,`hw_id`,`s_id`,`status`,`title`,`describe`,`review_content`,`review_time`,`attachment_title`,`attachment_url` FROM `T_student_homework`  LIMIT ?,?";
        return queryForList(StudentHomework.class, sql, (pageNo - 1) * pageSize, pageSize);
    }

    /**
     * 班级ID查询分页
     *
     * @param pageNo   页码
     * @param pageSize 条数
     * @return 所有数据
     */
    public List<StudentHomework> listByPageAndClassId(Integer classId, Integer pageNo, Integer pageSize) {
        String sql = "SELECT `T_Student_homework`.`hw_id`,`T_Student_homework`.`s_id`,`T_Student_homework`.`title`,`T_Student_homework`.`describe`,`T_Student_homework`.`status`,`T_Student_homework`.`review_content`,`T_student_homework`.`review_time`,`T_Student_homework`.`attachment_title`,`T_Student_homework`.`attachment_url` FROM `T_student_homework` inner join `t_homework` on `T_Student_homework`.`hw_id`=`t_homework`.`id` WHERE  `class_id`=? LIMIT ?,?";
        return queryForList(StudentHomework.class, sql, classId, (pageNo - 1) * pageSize, pageSize);
    }

    /**
     * 教师ID查询分页
     *
     * @param pageNo   页码
     * @param pageSize 条数
     * @return 所有数据
     */
    public List<StudentHomework> listByPageAndTeacherId(Integer teacherId, Integer pageNo, Integer pageSize) {
        String sql = "SELECT `T_Student_homework`.`hw_id`,`T_Student_homework`.`s_id`,`T_Student_homework`.`title`,`T_Student_homework`.`describe`,`T_Student_homework`.`status`,`T_Student_homework`.`review_content`,`T_student_homework`.`review_time`,`T_Student_homework`.`attachment_title`,`T_Student_homework`.`attachment_url` FROM `T_student_homework` inner join `t_homework` on `T_Student_homework`.`hw_id`=`t_homework`.`id` WHERE  `teacher_id`=? LIMIT ?,?";
        return queryForList(StudentHomework.class, sql, teacherId, (pageNo - 1) * pageSize, pageSize);
    }

    /**
     * 通过学生id分页获取学生提交作业
     *
     * @param studentId 学生id
     * @param pageNo    页码
     * @param pageSize  每页条数
     * @return 学生提交作业表
     */
    public List<StudentHomework> listByPageAndStudentId(Integer studentId, Integer pageNo, Integer pageSize) {
        String sql = "SELECT `hw_id`, `s_id`, `title`, `describe`, `status`, `review_content`, `review_time`, `attachment_title`, `attachment_url` FROM `T_student_homework` WHERE  `s_id`=? LIMIT ?,?";
        return queryForList(StudentHomework.class, sql, studentId, (pageNo - 1) * pageSize, pageSize);
    }

    @Override
    public Long countAll() {
        String sql = "SELECT COUNT(1) FROM `T_student_homework`";
        return queryForSingleValue(sql);
    }

    public Long countByClassId(Integer classId) {
        String sql = "SELECT COUNT(1) FROM `T_student_homework` inner join `t_homework` on `T_Student_homework`.`hw_id`=`t_homework`.`id` WHERE `class_id`=?";
        return queryForSingleValue(sql, classId);
    }

    public Long countByTeacherId(Integer teacherId) {
        String sql = "SELECT COUNT(1) FROM `T_student_homework` inner join `t_homework` on `T_Student_homework`.`hw_id`=`t_homework`.`id` WHERE `teacher_id`=?";
        return queryForSingleValue(sql, teacherId);
    }

    private static class Instance {
        public static final StudentHomeworkDao INSTANCE = new StudentHomeworkDao();
    }

    public static StudentHomeworkDao getInstance() {
        return StudentHomeworkDao.Instance.INSTANCE;
    }
}
