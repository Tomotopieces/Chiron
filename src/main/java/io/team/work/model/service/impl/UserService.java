package io.team.work.model.service.impl;

import io.team.work.model.bean.User;
import io.team.work.model.dao.impl.UserDao;
import io.team.work.model.service.AbstractBaseService;

import java.util.List;

/**
 * 用户Service
 *
 * @author liuxuhui
 * <p>
 * 2020/12/10 10:01
 */
public class UserService extends AbstractBaseService<User, Integer> {
    private final UserDao userDao = UserDao.getInstance();

    private UserService() {
    }

    public static UserService getInstance() {
        return Instance.INSTANCE;
    }

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return 用户
     */
    public User getUserByUsername(String username) {
        return userDao.queryByUsername(username);
    }

    /**
     * 获取所有教师用户
     *
     * @return 类型为教师的用户列表
     */
    public List<User> listTeachers() {
        return userDao.queryByType(1);
    }

    /**
     * 获取所有学生用户
     *
     * @return 类型为学生的用户列表
     */
    public List<User> listStudents() {
        return userDao.queryByType(2);
    }

    /**
     * 登录判断
     *
     * @param username 用户名
     * @param password 密码
     * @return 登陆成功与否
     */
    public Boolean login(String username, String password) {
        User user = userDao.queryByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    public List<User> listTeacherByPage(Integer pageNo,Integer pageSize) {
        return userDao.queryByPageType1(pageNo,pageSize);
    }

    public List<User> listStudentByPage(Integer pageNo,Integer pageSize){
        return userDao.queryByPageType2(pageNo,pageSize);
    }

    @Override
    protected UserDao getDao() {
        return userDao;
    }

    private static final class Instance {
        public static final UserService INSTANCE = new UserService();
    }
}
