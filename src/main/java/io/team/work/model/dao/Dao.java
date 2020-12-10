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
    <P> Integer update(ID id, String username, P propertyValue);

    //查询所有
    List<T> queryAll();

    //根据id查询
    T queryById(ID id);

    //分页
    List<T> queryByPage(Integer pageNo, Integer pageSize);

    //计数
    Integer CountAll();

}
