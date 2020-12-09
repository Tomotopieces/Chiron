package io.team.work.model.dao.impl;

import io.team.work.model.bean.Notice;
import io.team.work.model.bean.User;
import io.team.work.model.dao.BaseDao;

import java.util.List;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 20:12
 * 描述:
 */
public class NoticeDao extends BaseDao<Notice, Integer> {
    @Override
    public int insert(Notice notice) {
        String sql = "INSERT INTO `Notice`(`title`,`content`,`create_time`) VALUES (?,?,?)";
        return update(sql, notice.getTitle(), notice.getContent(), notice.getCreate_time());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM `Notice` WHERE `id`=?";
        return update(sql, id);
    }

    @Override
    public int update(Notice notice) {
        String sql = "UPDATE `Notice` SET `title`=?,`content`=?,`create_time`=? WHERE `id`=?";
        return update(sql, notice.getTitle(), notice.getContent(), notice.getCreate_time(), notice.getId());
    }

    @Override
    public List<Notice> queryAll() {
        String sql = "SELECT `id`,`title`,`content`,`create_time` FROM `Notice`";
        return queryForList(Notice.class, sql);
    }

    @Override
    public Notice queryById(Integer id) {
        String sql = "SELECT `id`,`title`,`content`,`create_time` FROM `Notice` WHERE `id`=?";
        return queryForOne(Notice.class, sql, id);
    }

    @Override
    public List<Notice> queryByPage(Integer pageNo, Integer pageSize) {
        String sql = "SELECT `id`,`title`,`content`,`create_time` FROM `Notice` LIMIT ?,?";
        return queryForList(Notice.class, sql, pageNo, pageSize);
    }

    @Override
    public Integer CountAll() {
        String sql = "SELECT COUNT(1) FROM `Notice`";
        return Math.toIntExact(queryForSingleValue(sql));
    }

    private static class Instance {
        public static final NoticeDao INSTANCE = new NoticeDao();
    }

    public static NoticeDao getInstance() {
        return NoticeDao.Instance.INSTANCE;
    }

}
