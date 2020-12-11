package io.team.work.model.service.impl;

import io.team.work.model.bean.User;
import io.team.work.model.dao.Dao;
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
        // todo
        return null;
    }

    /**
     * 获取所有学生用户
     *
     * @return 类型为学生的用户列表
     */
    public List<User> listStudents() {
        // todo
        return null;
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

    @Override
    protected UserDao getDao() {
        return userDao;
    }

    private static final class Instance {
        public static final UserService INSTANCE = new UserService();
    }
}
