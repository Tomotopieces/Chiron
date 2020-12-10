package io.team.work.model.dao.impl;

import io.team.work.model.bean.StudentHomeworkAttach;
import io.team.work.model.dao.BaseDao;

import java.util.List;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 19:06
 * 描述:学生作业附件
 */
public class StudentHomeworkAttachDao extends BaseDao<StudentHomeworkAttach, Integer> {
    private StudentHomeworkAttachDao(){}

    private static final String TABLE_NAME = "Stu_hw_attach";

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public int insert(StudentHomeworkAttach stuHwAttach) {
        String sql = "INSERT INTO `Stu_hw_attach`(`stu_hw_id`,`title`,`type`,`url`) VALUES(?,?,?,?)";
        return update(sql, stuHwAttach.getStu_hw_id(), stuHwAttach.getTitle(),stuHwAttach.getType(), stuHwAttach.getUrl());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM `Stu_hw_attach` WHERE `id`=?";
        return update(sql, id);
    }




    public int update(StudentHomeworkAttach stuHwAttach) {
        String sql = "UPDATE `Stu_hw_attach` SET `stu_hw_id`=?,`title`=?,`type`=?,`url`=? WHERE id=?";
        return update(sql, stuHwAttach.getStu_hw_id(),stuHwAttach.getTitle(), stuHwAttach.getType(), stuHwAttach.getUrl(), stuHwAttach.getId());
    }

    @Override
    public List<StudentHomeworkAttach> queryAll() {
        String sql = "SELECT `id`,`stu_hw_id`,`title`,`type`,`url` FROM `Stu_hw_attach`";
        return queryForList(StudentHomeworkAttach.class, sql);
    }

    @Override
    public StudentHomeworkAttach queryById(Integer id) {
        String sql = "SELECT `id`,`stu_hw_id`,`title`,`type`,`url` FROM `Stu_hw_attach` WHERE `id`=?";
        return queryForOne(StudentHomeworkAttach.class, sql, id);
    }

    @Override
    public List<StudentHomeworkAttach> queryByPage(Integer pageNo, Integer pageSize) {
        String sql = "SELECT `id`,`stu_hw_id`,`title`,`type`,`url` FROM `Stu_hw_attach` FROM `Stu_hw_attach` LIMIT ?,?";
        return queryForList(StudentHomeworkAttach.class, sql, pageNo, pageSize);
    }

    @Override
    public Integer CountAll() {
        String sql = "SELECT COUNT(1) FROM `Stu_hw_attach`";
        return Math.toIntExact(queryForSingleValue(sql));
    }



    private static class Instance {
        public static final StudentHomeworkAttachDao INSTANCE = new StudentHomeworkAttachDao();
    }

    public static StudentHomeworkAttachDao getInstance() {
        return StudentHomeworkAttachDao.Instance.INSTANCE;
    }
}
