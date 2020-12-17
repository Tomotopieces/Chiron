package io.team.work.model.dao.impl;

import io.team.work.model.bean.Notice;
import io.team.work.model.dao.AbstractBaseDao;

import java.util.List;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 20:12
 * 描述:
 */
public class NoticeDao extends AbstractBaseDao<Notice, Integer> {
    private NoticeDao(){}

    private static final String TABLE_NAME = "T_notice";

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public int insert(Notice notice) {
        String sql = "INSERT INTO `T_notice`(`title`,`content`,`create_time`) VALUES (?,?,?)";
        return update(sql, notice.getTitle(), notice.getContent(), notice.getCreate_time());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM `T_notice` WHERE `id`=?";
        return update(sql, id);
    }




    public int update(Notice notice) {
        String sql = "UPDATE `T_notice` SET `title`=?,`content`=?,`create_time`=? WHERE `id`=?";
        return update(sql, notice.getTitle(), notice.getContent(), notice.getCreate_time(), notice.getId());
    }

    @Override
    public List<Notice> queryAll() {
        String sql = "SELECT `id`,`title`,`content`,`create_time` FROM `T_notice`";
        return queryForList(Notice.class, sql);
    }

    @Override
    public Notice queryById(Integer id) {
        String sql = "SELECT `id`,`title`,`content`,`create_time` FROM `T_notice` WHERE `id`=?";
        return queryForOne(Notice.class, sql, id);
    }

    @Override
    public List<Notice> queryByPage(Integer pageNo, Integer pageSize) {
        String sql = "SELECT `id`,`title`,`content`,`create_time` FROM `T_notice` LIMIT ?,?";
        return queryForList(Notice.class, sql, (pageNo-1)*pageSize, pageSize);
    }

    @Override
    public Long countAll() {
        String sql = "SELECT COUNT(1) FROM `T_notice`";
        return queryForSingleValue(sql);
    }



    private static class Instance {
        public static final NoticeDao INSTANCE = new NoticeDao();
    }

    public static NoticeDao getInstance() {
        return NoticeDao.Instance.INSTANCE;
    }

}
