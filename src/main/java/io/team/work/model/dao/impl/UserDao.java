package io.team.work.model.dao.impl;


import io.team.work.model.bean.User;
import io.team.work.model.dao.BaseDao;


import java.util.List;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 14:17
 * 描述:用户
 */
public class UserDao extends BaseDao<User, Integer> {
    private UserDao() {
    }

    @Override
    public int insert(User user) {
        String sql = "INSERT INTO `User`(`username`,`password`,`name`,`sex`,`age`,`class_id`,`type`) VALUES(?,?,?,?,?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getSex(), user.getAge(), user.getClass_id(), user.getType());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM `User` WHERE id=?";
        return update(sql, id);
    }

    @Override
    public int update(User user) {
        String sql = "UPDATE `User` SET `username`=?,`password`=?,`name`=?,`sex`=?,`age`=?,`class_id`=?,`type` WHERE `id`=?";
        return update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getSex(), user.getAge(), user.getClass_id(), user.getType(), user.getId());
    }

    @Override
    public List<User> queryAll() {
        String sql = "SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `User`";
        return queryForList(User.class, sql);
    }


    public User queryUserByNameAndPassword(User user) {
        String sql = "SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `User` WHERE `username`=? AND `password`=?";
        return queryForOne(User.class, sql, user.getUsername(), user.getPassword());
    }

    @Override
    public User queryById(Integer id) {
        String sql = "SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `User` WHERE `id`=?";
        return queryForOne(User.class, sql, id);
    }


    public User queryByType(Integer type) {
        String sql = "SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `User` WHERE `type`=?";
        return queryForOne(User.class, sql, type);
    }

    @Override
    public List<User> queryByPage(Integer pageNo, Integer pageSize) {
        String sql = "SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `User` LIMIT ?, ?";
        return queryForList(User.class, sql, pageNo, pageSize);
    }

    @Override
    public Integer CountAll() {
        String sql = "SELECT COUNT(1) FROM `User`";
        return Math.toIntExact(queryForSingleValue(sql));
    }


    private static class Instance {
        public static final UserDao INSTANCE = new UserDao();
    }

    public static UserDao getInstance() {
        return Instance.INSTANCE;
    }
}
