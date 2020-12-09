package io.team.work.model.dao;

import io.team.work.model.bean.User;

import java.util.List;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 10:46
 * 描述:
 */
public interface Dao<T, ID> {
    //插入
    int insert(T t);
    //删除
    int delete(ID id);
    //更新
    int update(T t);
    //查询所有
    List<T> queryAll();
    //根据账号和密码查询
    T queryUserByNameAndPassword(T t);
    //根据user的id查询
    T queryUserById(Long id);
    //根据user的类型查询
    //分页
    List<T> queryUserByPage(Integer pageNo,  Integer pageSize);
    //计数
    Long CountAll();

}
