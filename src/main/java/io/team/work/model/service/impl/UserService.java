package io.team.work.model.service.impl;

import io.team.work.model.bean.User;
import io.team.work.model.dao.impl.UserDao;

import java.util.List;

/**
 * 用户Service
 *
 * @author liuxuhui
 * <p>
 * 2020/12/10 10:01
 */
public class UserService {
    private  final UserDao userDao=UserDao.getInstance();
    private UserService(){
    }
    public static UserService getInstance(){
        return Instance.INSTANCE;
    }
    //增加用户
    public Boolean addUser(User user){
        return userDao.insert(user)==1;
    }
    //删除
    public Boolean removeUser(Integer id){
        return userDao.delete(id)==1;
    }
    //根据Id查询
    public User getUserById(Integer id){
        return userDao.queryById(id);
    }

   //根据用户名查询
    public User getUserByUsername(String username) {
        return userDao.queryByUsername(username);
    }
    //登录
    public Boolean login(String username,String password){
      User user =  userDao.queryByUsername(username);
        return user!=null&&user.getPassword().equals(password);
    }
    //查询所有
    public List<User> listUsers() {
        return userDao.queryAll();
    }
    //分页查询
    public List<User> getUsersByPage(Integer pageNo,Integer pageSize) {
        return userDao.queryByPage(pageNo, pageSize);
    }
    //每次只显示5页的分页
    public List<User> getUsersByPage(Integer pageNo) {
        return userDao.queryByPage(pageNo, 5);
    }
    //更新
    public <P> Boolean updateUser(Integer id, String attribute, P propertyValue) {
        return userDao.update(id, attribute, propertyValue) == 1;
    }

    private static final class Instance {
        public static final UserService INSTANCE = new UserService();
    }
}
