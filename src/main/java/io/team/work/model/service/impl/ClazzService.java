package io.team.work.model.service.impl;

import io.team.work.model.bean.Clazz;
import io.team.work.model.bean.User;
import io.team.work.model.dao.impl.ClazzDao;

import javax.enterprise.inject.New;
import java.util.List;

/**
 * 班级Service
 *
 * @author liuxuhui
 * <p>
 * 2020/12/10 16:05
 */
public class ClazzService {
    private final ClazzDao clazzDao=ClazzDao.getInstance();
    private ClazzService(){
    }
    public static ClazzService getInstance(){
        return Instance.INSTANCE;
    }

    //增加
    public Boolean addClazz(Clazz clazz){
        return clazzDao.insert(clazz)==1;
    }
    //删除
    public Boolean removeClazz(Integer id){
        return clazzDao.delete(id)==1;
    }
    //根据Id查询
    public Clazz getClazzById(Integer id){
        return clazzDao.queryById(id);
    }
    //查询所有
    public List<Clazz> listClazz() {
        return clazzDao.queryAll();
    }
    //分页查询
    public List<Clazz> getClazzByPage(Integer pageNo,Integer pageSize) {
        return clazzDao.queryByPage(pageNo, pageSize);
    }
    //每次只显示5页的分页
    public List<Clazz> getClazzByPage(Integer pageNo) {
        return clazzDao.queryByPage(pageNo, 5);
    }
    //更新
    public <P> Boolean updateClazz(Integer id, String attribute, P propertyValue) {
        return clazzDao.update(id, attribute, propertyValue) == 1;
    }

    private static final class Instance {
        public static final ClazzService INSTANCE = new ClazzService();
    }
}
