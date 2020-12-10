package io.team.work.model.service.impl;

import io.team.work.model.bean.Clazz;
import io.team.work.model.bean.HomeworkAttach;
import io.team.work.model.dao.impl.HomeworkAttachDao;

import java.util.List;

/**
 * 作业附件Service
 *
 * @author liuxuhui
 * <p>
 * 2020/12/10 16:36
 */
public class HomeworkAttachService {
    private final HomeworkAttachDao homeworkAttachDao=HomeworkAttachDao.getInstance();
    private HomeworkAttachService(){
    }
    public static HomeworkAttachService getInstance(){
        return Instance.INSTANCE;
    }
    //增加
    public Boolean addHomeworkAttach(HomeworkAttach homeworkAttach){
        return homeworkAttachDao.insert(homeworkAttach)==1;
    }
    //删除
    public Boolean removeHomeworkAttach(Integer id){
        return homeworkAttachDao.delete(id)==1;
    }
    //根据Id查询
    public HomeworkAttach getHomeworkAttachById(Integer id){
        return homeworkAttachDao.queryById(id);
    }
    //查询所有
    public List<HomeworkAttach> listHomeworkAttach() {
        return homeworkAttachDao.queryAll();
    }
    //分页查询
    public List<HomeworkAttach> getHomeworkAttachByPage(Integer pageNo,Integer pageSize) {
        return homeworkAttachDao.queryByPage(pageNo, pageSize);
    }
    //每次只显示5页的分页
    public List<HomeworkAttach> getHomeworkAttachByPage(Integer pageNo) {
        return homeworkAttachDao.queryByPage(pageNo, 5);
    }
    //更新
    public <P> Boolean updateHomeworkAttach(Integer id, String attribute, P propertyValue) {
        return homeworkAttachDao.update(id, attribute, propertyValue) == 1;
    }

    public static  final class Instance{
        public static final HomeworkAttachService INSTANCE = new HomeworkAttachService();
    }
}
