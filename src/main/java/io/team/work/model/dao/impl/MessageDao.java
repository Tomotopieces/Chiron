package io.team.work.model.dao.impl;

import io.team.work.model.bean.Message;
import io.team.work.model.dao.BaseDao;

import java.util.List;

/**
 * (留言Dao)
 *
 * @author liuxuhui
 * <p>
 * 2020/12/9 20:44
 */
public class MessageDao extends BaseDao<Message, Integer> {

    private MessageDao() {
    }

    private static final String TABLE_NAME = "Message";

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public int insert(Message message) {
        String sql = "INSERT INTO `Message`(`title`,`content`,`create_time`) VALUES(?,?,?)";
        return update(sql, message.getTitle(), message.getContent(), message.getCreate_time());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM `Message` WHERE `id`=?";
        return update(sql, id);
    }


    public int update(Message message) {
        String sql = "UPDATE `Message` SET `title`=?,`content`=?,`create_time`=? WHERE `id`=?";
        return update(sql, message.getTitle(), message.getContent(), message.getCreate_time(), message.getId());
    }

    @Override
    public List<Message> queryAll() {
        String sql = "SELECT `id`,`title`,`content`,`create_time` FROM `Message`";
        return queryForList(Message.class, sql);
    }

    @Override
    public Message queryById(Integer id) {
        String sql = "SELECT `id`,`title`,`content`,`create_time` FROM `Message` WHERE `id`=?";
        return queryForOne(Message.class, sql, id);
    }

    @Override
    public List<Message> queryByPage(Integer pageNo, Integer pageSize) {
        String sql = "SELECT `id`,`title`,`content`,`create_time` FROM `Message` LIMIT ?,?";
        return queryForList(Message.class, sql, pageNo, pageSize);
    }

    @Override
    public Integer CountAll() {
        String sql = "SELECT COUNT(1) FROM `Message`";
        return Math.toIntExact(queryForSingleValue(sql));
    }


    private static class Instance {
        public static final MessageDao INSTANCE = new MessageDao();
    }

    public static MessageDao getInstance() {
        return MessageDao.Instance.INSTANCE;
    }
}
