package io.team.work.model.service.impl;

import io.team.work.model.bean.Message;
import io.team.work.model.dao.Dao;
import io.team.work.model.dao.impl.MessageDao;
import io.team.work.model.service.AbstractBaseService;

import java.util.List;

/**
 * 消息Service
 *
 * @author liuxuhui
 * <p>
 * 2020/12/10 18:17
 */
public class MessageService extends AbstractBaseService<Message, Integer> {
    private final MessageDao messageDao = MessageDao.getInstance();

    private MessageService() {
    }

    public static MessageService getInstance() {
        return MessageService.Instance.INSTANCE;
    }

    @Override
    protected MessageDao getDao() {
        return messageDao;
    }

    private static final class Instance {
        public static final MessageService INSTANCE = new MessageService();
    }

}
