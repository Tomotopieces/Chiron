package io.team.work.model.dao.impl;

import io.team.work.model.bean.Clazz;
import io.team.work.model.dao.BaseDao;
import io.team.work.util.JdbcUtils;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 15:37
 * 描述:班级
 */
public class ClazzDao extends BaseDao<Clazz, Integer> {
    private ClazzDao(){}

    private static final String TABLE_NAME = "Clazz";

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public int insert(Clazz clazz) {
        String sql = "INSERT INTO `Class`(`classNo`,`className`) VALUES(?,?)";
        return update(sql, clazz.getClassNo(), clazz.getClassName());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM `Class` WHERE `id`=?";
        return update(sql, id);
    }





    public int update(Clazz clazz) {
        String sql = "UPDATE `Class` SET `classNo`=?,`className`=? WHERE `id`=?";
        return update(sql, clazz.getClassNo(), clazz.getClassName(), clazz.getId());
    }

    @Override
    public List<Clazz> queryAll() {
        String sql = "SELECT `id`, `classNo`,`className` FROM `Class`";
        return queryForList(Clazz.class, sql);
    }


    @Override
    public Clazz queryById(Integer id) {
        String sql = "SELECT `classNo`,`className` FROM `Class` WHERE `id`=?";
        return queryForOne(Clazz.class, sql, id);
    }


    @Override
    public List<Clazz> queryByPage(Integer pageNo, Integer pageSize) {
        String sql = "SELECT `classNo`,`className` FROM `Class` LIMIT ?, ?";
        return queryForList(Clazz.class, sql, pageNo, pageSize);
    }

    @Override
    public Integer CountAll() {
        String sql = "SELECT COUNT(1) FROM `Class`";
        return Math.toIntExact(queryForSingleValue(sql));
    }



    private static class Instance {
        public static final ClazzDao INSTANCE = new ClazzDao();
    }

    public static ClazzDao getInstance() {
        return ClazzDao.Instance.INSTANCE;
    }
}
