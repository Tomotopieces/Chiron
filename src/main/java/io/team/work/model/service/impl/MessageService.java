package io.team.work.model.service.impl;

import io.team.work.model.bean.Homework;
import io.team.work.model.bean.Message;
import io.team.work.model.dao.impl.HomeworkDao;
import io.team.work.model.dao.impl.MessageDao;

import java.util.List;

/**
 * 消息Service
 *
 * @author liuxuhui
 * <p>
 * 2020/12/10 18:17
 */
public class MessageService {
    private final MessageDao messageDao=MessageDao.getInstance();
    private MessageService(){}
    public static MessageService getInstance(){
        return MessageService.Instance.INSTANCE;
    }

    //增加
    public Boolean addMessage(Message message){
        return messageDao.insert(message)==1;
    }
    //删除
    public Boolean removeMessage(Integer id){
        return messageDao.delete(id)==1;
    }
    //根据Id查询
    public Message getMessageById(Integer id){
        return messageDao.queryById(id);
    }

    //查询所有
    public List<Message> listMessage() {
        return messageDao.queryAll();
    }
    //分页查询
    public List<Message> getMessageByPage(Integer pageNo,Integer pageSize) {
        return messageDao.queryByPage(pageNo, pageSize);
    }
    //每次只显示5页的分页
    public List<Message> getMessageByPage(Integer pageNo) {
        return messageDao.queryByPage(pageNo, 5);
    }
    //更新
    public <P> Boolean updateMessage(Integer id, String attribute, P propertyValue) {
        return messageDao.update(id, attribute, propertyValue) == 1;
    }

    private static final class Instance {
        public static final MessageService INSTANCE = new MessageService();
    }

}
