package io.team.work.model.service.impl;

import io.team.work.model.bean.Clazz;
import io.team.work.model.bean.Notice;
import io.team.work.model.dao.impl.ClazzDao;
import io.team.work.model.dao.impl.NoticeDao;

import java.util.List;

/**
 * 公告Service
 *
 * @author liuxuhui
 * <p>
 * 2020/12/10 18:11
 */
public class NoticeService {
    private final NoticeDao noticeDao=NoticeDao.getInstance();
    private NoticeService(){
    }
    public static NoticeService getInstance(){
        return NoticeService.Instance.INSTANCE;
    }

    //增加
    public Boolean addNotice(Notice notice){
        return noticeDao.insert(notice)==1;
    }
    //删除
    public Boolean removeNotice(Integer id){
        return noticeDao.delete(id)==1;
    }
    //根据Id查询
    public Notice getNoticeById(Integer id){
        return noticeDao.queryById(id);
    }
    //查询所有
    public List<Notice> listNotice() {
        return noticeDao.queryAll();
    }
    //分页查询
    public List<Notice> getNoticeByPage(Integer pageNo,Integer pageSize) {
        return noticeDao.queryByPage(pageNo, pageSize);
    }
    //每次只显示5页的分页
    public List<Notice> getNoticeByPage(Integer pageNo) {
        return noticeDao.queryByPage(pageNo, 5);
    }
    //更新
    public <P> Boolean updateNotice(Integer id, String attribute, P propertyValue) {
        return noticeDao.update(id, attribute, propertyValue) == 1;
    }

    private static final class Instance {
        public static final NoticeService INSTANCE = new NoticeService();
    }
}
