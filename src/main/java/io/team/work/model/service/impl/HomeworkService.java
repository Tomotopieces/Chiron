package io.team.work.model.service.impl;

import io.team.work.model.bean.Clazz;
import io.team.work.model.bean.Homework;
import io.team.work.model.bean.User;
import io.team.work.model.dao.impl.HomeworkDao;

import java.util.List;

/**
 * 作业Service
 *
 * @author liuxuhui
 * <p>
 * 2020/12/10 16:19
 */
public class HomeworkService {
    private final HomeworkDao homeworkDao=HomeworkDao.getInstance();
    private HomeworkService(){}
    public static HomeworkService getInstance(){
        return HomeworkService.Instance.INSTANCE;
    }

    //增加
    public Boolean addHomework(Homework homework){
        return homeworkDao.insert(homework)==1;
    }
    //删除
    public Boolean removeHomework(Integer id){
        return homeworkDao.delete(id)==1;
    }
    //根据Id查询
    public Homework getHomeworkById(Integer id){
        return homeworkDao.queryById(id);
    }

    //查询所有
    public List<Homework> listHomework() {
        return homeworkDao.queryAll();
    }
    //分页查询
    public List<Homework> getHomeworkByPage(Integer pageNo,Integer pageSize) {
        return homeworkDao.queryByPage(pageNo, pageSize);
    }
    //每次只显示5页的分页
    public List<Homework> getHomeworkByPage(Integer pageNo) {
        return homeworkDao.queryByPage(pageNo, 5);
    }
    //更新
    public <P> Boolean updateHomework(Integer id, String attribute, P propertyValue) {
        return homeworkDao.update(id, attribute, propertyValue) == 1;
    }

    private static final class Instance {
        public static final HomeworkService INSTANCE = new HomeworkService();
    }

}
