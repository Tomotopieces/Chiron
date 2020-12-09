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
public class MessageDao extends BaseDao<Message,Integer> {
    @Override
    public int insert(Message message) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public int update(Message message) {
        return 0;
    }

    @Override
    public List<Message> queryAll() {
        return null;
    }

    @Override
    public Message queryById(Integer integer) {
        return null;
    }

    @Override
    public List<Message> queryByPage(Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    public Integer CountAll() {
        return null;
    }
}
