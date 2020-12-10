package io.team.work.model.dao.impl;

import io.team.work.model.bean.Homework;
import io.team.work.model.dao.BaseDao;

import java.util.List;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 16:20
 * 描述:作业
 */
public class HomeworkDao extends BaseDao<Homework, Integer> {
    private HomeworkDao(){
    }

    private static final String TABLE_NAME = "Homework";

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }


    @Override
    public int insert(Homework homework) {
        String sql = "INSERT INTO `Homework`(`teacher_id`,`title`,`describe`,`class_id`,`end_time`) VALUES(?,?,?,?,?)";
        return update(sql, homework.getTeacher_id(), homework.getTitle(), homework.getDescribe(), homework.getClass_id(), homework.getEnd_time());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM `Homework` WHERE `id`=?";
        return update(sql, id);
    }




    public int update(Homework homework) {
        String sql = "UPDATE `Homework` SET `teacher_id`=?,`title`=?,`describe`=?,`class_id`=?,`end_time`=? WHERE `id`=?";
        return update(sql, homework.getTeacher_id(), homework.getTitle(), homework.getDescribe(), homework.getClass_id(), homework.getEnd_time());
    }

    @Override
    public List<Homework> queryAll() {
        String sql = "SELECT `id`,`teacher_id`,`title`,`describe`,`class_id`,`end_time` FROM `Homework`";
        return queryForList(Homework.class, sql);
    }

    @Override
    public Homework queryById(Integer id) {
        String sql = "SELECT `id`,`teacher_id`,`title`,`describe`,`class_id`,`end_time` FROM `Homework` WHERE `id`=?";
        return queryForOne(Homework.class, sql, id);
    }

    @Override
    public List<Homework> queryByPage(Integer pageNo, Integer pageSize) {
        String sql = "SELECT `id`,`teacher_id`,`title`,`describe`,`class_id`,`end_time` FROM `Homework` LIMIT ?,?";
        return queryForList(Homework.class, sql, pageNo, pageSize);
    }

    @Override
    public Integer CountAll() {
        String sql = "SELECT COUNT(1) FROM `Homework`";
        return Math.toIntExact(queryForSingleValue(sql));
    }

    public Homework queryByTeacherId(Homework homework) {
        String sql = "SELECT `id`,`teacher_id`,`title`,`describe`,`class_id`,`end_time` FROM `Homework` WHERE `teacher_id`=?";
        return queryForOne(Homework.class, sql, homework.getTeacher_id());
    }

    public Homework queryByClassId(Homework homework) {
        String sql = "SELECT `id`,`teacher_id`,`title`,`describe`,`class_id`,`end_time` FROM `Homework` WHERE `class_id`=?";
        return queryForOne(Homework.class, sql, homework.getClass_id());
    }



    private static class Instance {
        public static final HomeworkDao INSTANCE = new HomeworkDao();
    }

    public static HomeworkDao getInstance() {
        return HomeworkDao.Instance.INSTANCE;
    }
}
