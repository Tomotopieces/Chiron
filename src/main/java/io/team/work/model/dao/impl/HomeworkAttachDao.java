package io.team.work.model.dao.impl;

import io.team.work.model.bean.Homework_attach;
import io.team.work.model.dao.BaseDao;

import java.util.List;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 18:00
 * 描述:作业附件
 */
public class HomeworkAttachDao extends BaseDao<Homework_attach, Integer> {
    @Override
    public int insert(Homework_attach homework_attach) {
        String sql = "INSERT INTO `Homework_attach`(`hw_id`,`title`,`type`,`url`,`create_time`,`create_man`) VALUES(?,?,?,?,?,?)";
        return update(sql, homework_attach.getHw_id(), homework_attach.getTitle(), homework_attach.getType(), homework_attach.getUrl(), homework_attach.getCreate_time(), homework_attach.getCreate_man());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM `Homework_attach` WHERE id=?";
        return update(sql, id);
    }

    @Override
    public int update(Homework_attach homework_attach) {
        String sql = "UPDATE `Homework_attach` SET `hw_id`=?,`title`=?,`type`=?,`url`=?,`create_time`=?,`create_man`=? WHERE `id`=?";
        return update(sql, homework_attach.getHw_id(), homework_attach.getTitle(), homework_attach.getType(), homework_attach.getUrl(), homework_attach.getCreate_time(), homework_attach.getCreate_man(), homework_attach.getId());
    }

    @Override
    public List<Homework_attach> queryAll() {
        String sql = "SELECT `id`,`hw_id`,`title`,`type`,`url`,`create_time`,`create_man` FROM `Homework_attach`";
        return queryForList(Homework_attach.class, sql);
    }

    @Override
    public Homework_attach queryById(Integer id) {
        String sql = "SELECT `id`,`hw_id`,`title`,`type`,`url`,`create_time`,`create_man` FROM `Homework_attach` WHERE `id`=?";
        return queryForOne(Homework_attach.class, sql, id);
    }

    @Override
    public List<Homework_attach> queryByPage(Integer pageNo, Integer pageSize) {
        String sql = "SELECT `id`,`hw_id`,`title`,`type`,`url`,`create_time`,`create_man` FROM `Homework_attach` LIMIT ?,?";
        return queryForList(Homework_attach.class, sql, pageNo, pageSize);
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
