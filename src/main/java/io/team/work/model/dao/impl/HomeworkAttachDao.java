package io.team.work.model.dao.impl;

import io.team.work.model.bean.HomeworkAttach;
import io.team.work.model.dao.BaseDao;

import java.util.List;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 18:00
 * 描述:作业附件
 */
public class HomeworkAttachDao extends BaseDao<HomeworkAttach, Integer> {
    private HomeworkAttachDao(){}

    private static final String TABLE_NAME = "Homework_attach";

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }
    @Override
    public int insert(HomeworkAttach homework_attach) {
        String sql = "INSERT INTO `Homework_attach`(`hw_id`,`title`,`type`,`url`,`create_time`,`create_man`) VALUES(?,?,?,?,?,?)";
        return update(sql, homework_attach.getHw_id(), homework_attach.getTitle(), homework_attach.getType(), homework_attach.getUrl(), homework_attach.getCreate_time(), homework_attach.getCreate_man());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM `Homework_attach` WHERE id=?";
        return update(sql, id);
    }




    public int update(HomeworkAttach homework_attach) {
        String sql = "UPDATE `Homework_attach` SET `hw_id`=?,`title`=?,`type`=?,`url`=?,`create_time`=?,`create_man`=? WHERE `id`=?";
        return update(sql, homework_attach.getHw_id(), homework_attach.getTitle(), homework_attach.getType(), homework_attach.getUrl(), homework_attach.getCreate_time(), homework_attach.getCreate_man(), homework_attach.getId());
    }

    @Override
    public List<HomeworkAttach> queryAll() {
        String sql = "SELECT `id`,`hw_id`,`title`,`type`,`url`,`create_time`,`create_man` FROM `Homework_attach`";
        return queryForList(HomeworkAttach.class, sql);
    }

    @Override
    public HomeworkAttach queryById(Integer id) {
        String sql = "SELECT `id`,`hw_id`,`title`,`type`,`url`,`create_time`,`create_man` FROM `Homework_attach` WHERE `id`=?";
        return queryForOne(HomeworkAttach.class, sql, id);
    }

    @Override
    public List<HomeworkAttach> queryByPage(Integer pageNo, Integer pageSize) {
        String sql = "SELECT `id`,`hw_id`,`title`,`type`,`url`,`create_time`,`create_man` FROM `Homework_attach` LIMIT ?,?";
        return queryForList(HomeworkAttach.class, sql, pageNo, pageSize);
    }

    @Override
    public Integer CountAll() {
        String sql = "SELECT COUNT(1) FROM `Homework_attach`";
        return Math.toIntExact(queryForSingleValue(sql));
    }



    private static class Instance {
        public static final HomeworkAttachDao INSTANCE = new HomeworkAttachDao();
    }

    public static HomeworkAttachDao getInstance() {
        return HomeworkAttachDao.Instance.INSTANCE;
    }
}
