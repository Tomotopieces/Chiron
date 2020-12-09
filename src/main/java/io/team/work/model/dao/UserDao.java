package io.team.work.model.dao;

import io.team.work.model.bean.User;

import java.util.List;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 11:21
 * 描述:
 */
public interface UserDao {
    //增加
    int insert(User user);
    //删除
    int delete(Integer id);
    //更新
    int update(User user);
    //查找所有
    List<User> queryAll();
    //根据用户类型查找
    User queryUserByType(Integer type);
    //根据用户名密码查找
    User queryUserByNameAndPassword(User user);
    //分页查询
    List<User> queryUserByPage(int pageNo, int pageSize);
    //计数
    Long CountAll();
}
