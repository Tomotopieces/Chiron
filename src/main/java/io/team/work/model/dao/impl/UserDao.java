package io.team.work.model.dao.impl;


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
    private UserDao() {
    }

    private static final String TABLE_NAME = "T_user";
    private static final String PROPERTIES = "`username`, `password`, `name`, `sex`, `age`,`class_id`,`type`";
    private static final String READ_BY_USERNAME =
            "SELECT `id`, " + PROPERTIES + " FROM `" + TABLE_NAME + "` WHERE `username` = ?;";

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

    public User queryByUsername(String username){
        try (Connection connection= JdbcUtils.getConnection()){
             return getQueryRunner().query(connection,READ_BY_USERNAME,new BeanHandler<>(User.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User queryById(Integer id) {
        String sql = "SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `T_user` WHERE `id`=?";
        return queryForOne(User.class, sql, id);
    }

    /**
     * 通过类型来查找所有信息
     * @param type 教师：1,学生：2
     * @return
     */
    public List<User> queryByType(Integer type) {
        String sql = "SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `T_user` WHERE `type`=?";
        return queryForList(User.class, sql, type);
    }

//    /**
//     * 通过类型来查找学生的所有信息
//     * @param type=2,学生
//     * @return
//     */
//    public User queryByType2(Integer type) {
//        String sql = "SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `User` WHERE `type`=2";
//        return queryForOne(User.class, sql, type);
//    }

    @Override
    public List<User> queryByPage(Integer pageNo, Integer pageSize) {
        String sql = "SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `T_user` LIMIT ?, ?";
        return queryForList(User.class, sql, pageNo, pageSize);
    }

    public List<User> queryByPageType1(Integer pageNo,Integer pageSize){
        String sql="SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `T_user` WHERE `type`=1 LIMIT ?, ?";
        return queryForList(User.class,sql,pageNo,pageSize);
    }

    public List<User> queryByPageType2(Integer pageNo,Integer pageSize){
        String sql="SELECT `id`,`username`,`password`,`name`,`sex`,`age`,`class_id`,`type` FROM `T_user` WHERE `type`=2 LIMIT ?, ?";
        return queryForList(User.class,sql,pageNo,pageSize);
    }

    @Override
    public Integer CountAll() {
        String sql = "SELECT COUNT(1) FROM `T_user`";
        return Math.toIntExact(queryForSingleValue(sql));
    }


    private static class Instance {
        public static final UserDao INSTANCE = new UserDao();
    }

    public static UserDao getInstance() {
        return Instance.INSTANCE;
    }
}
