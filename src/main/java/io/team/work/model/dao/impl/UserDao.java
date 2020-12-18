package io.team.work.model.dao.impl;


import io.team.work.model.bean.Clazz;
import io.team.work.model.bean.User;
import io.team.work.model.dao.AbstractBaseDao;
import io.team.work.util.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 14:17
 * 描述:用户
 */
public class UserDao extends AbstractBaseDao<User, Integer> {
    private static final String TABLE_NAME = "T_user";
    private static final String PROPERTIES = "`username`, `password`, `name`, `sex`, `age`,`class_id`,`type`";
    private static final String READ_BY_USERNAME =
            "SELECT `id`, " + PROPERTIES + " FROM `" + TABLE_NAME + "` WHERE `username` = ?;";
    private UserDao() {
    }

    public static UserDao getInstance() {
        return Instance.INSTANCE;
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public int insert(User user) {
        String sql = "INSERT INTO `T_user`(" + PROPERTIES + ") VALUES(?,?,?,?,?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getSex(), user.getAge(), user.getClass_id(), user.getType());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM `T_user` WHERE id=?";
        return update(sql, id);
    }

    public int update(User user) {
        String sql = "UPDATE `T_user` SET `username`=?,`password`=?,`name`=?,`sex`=?,`age`=?,`class_id`=?,`type` WHERE `id`=?";
        return update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getSex(), user.getAge(), user.getClass_id(), user.getType(), user.getId());
    }

    @Override
    public List<User> queryAll() {
        String sql = "SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `T_user`";
        return queryForList(User.class, sql);
    }

    public User queryUserByNameAndPassword(User user) {
        String sql = "SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `T_user` WHERE `username`=? AND `password`=?";
        return queryForOne(User.class, sql, user.getUsername(), user.getPassword());
    }

    public User queryByUsername(String username) {
        try (Connection connection = JdbcUtils.getConnection()) {
            return getQueryRunner().query(connection, READ_BY_USERNAME, new BeanHandler<>(User.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 模糊查询
     * @param user 用户名
     * @return
     */
    public  List<User> queryUserByUsername(User user){
        String sql="SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `T_user` WHERE `username` like `%?%`";
        return queryForList(User.class,sql,user.getUsername());
    }

    /**
     * 模糊查询
     * @param user 名字
     * @return
     */
    public List<User> queryUserByName(User user){
        String sql="SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `T_user` WHERE `name` like '%?%'";
        return queryForList(User.class,sql,user.getName());
    }

    /**
     *关联模糊查询
     * @param clazz 班级名称
     * @return
     */
    public List<User> queryByClassName(Clazz clazz){
        String sql="SELECT t_user.`id`,t_user.`username`,t_user.`password`,t_user.`name`,t_user.`sex`,t_user.`age`,t_user.`class_id`,t_user.`type`FROM `T_user` left join `T_class` on t_user.class_id=t_class.id WHERE t_class.className Like '%?%' ";
        return queryForList(User.class,sql,clazz.getClassName());
    }

    /**
     *关联模糊查询
     * @param clazz 班级编号
     * @return
     */
    public List<User> queryByClassNo(Clazz clazz){
        String sql="SELECT t_user.`id`,t_user.`username`,t_user.`password`,t_user.`name`,t_user.`sex`,t_user.`age`,t_user.`class_id`,t_user.`type`FROM `T_user` left join `T_class` on t_user.class_id=t_class.id WHERE t_class.classNo Like '%?%' ";
        return queryForList(User.class,sql,clazz.getClassNo());
    }

    @Override
    public User queryById(Integer id) {
        String sql = "SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `T_user` WHERE `id`=?";
        return queryForOne(User.class, sql, id);
    }

    /**
     * 通过类型来查找所有信息
     *
     * @param type 教师：1,学生：2
     * @return
     */
    public List<User> queryByType(Integer type) {
        String sql = "SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `T_user` WHERE `type`=?";
        return queryForList(User.class, sql, type);
    }

    @Override
    public List<User> queryByPage(Integer pageNo, Integer pageSize) {
        String sql = "SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `T_user` LIMIT ?, ?";
        return queryForList(User.class, sql, (pageNo-1)*pageSize, pageSize);
    }

    public List<User> queryByPageAndType(Integer pageNo, Integer pageSize, Integer type) {
        String sql = "SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `T_user` WHERE " +
                "`type` = ? LIMIT ?, ?";
        return queryForList(User.class, sql, type, (pageNo-1)*pageSize, pageSize);
    }

    @Override
    public Long countAll() {
        String sql = "SELECT COUNT(1) FROM `T_user`";
        return queryForSingleValue(sql);
    }

    public Long countType(Integer type) {
        String sql = "SELECT COUNT(1) FROM `T_user` WHERE `type` = ?";
        return queryForSingleValue(sql, type);
    }

    private static class Instance {
        public static final UserDao INSTANCE = new UserDao();
    }
}
