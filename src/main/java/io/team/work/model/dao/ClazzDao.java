package io.team.work.model.dao;

import io.team.work.model.bean.Clazz;

import java.util.List;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 11:31
 * 描述:
 */
public interface ClazzDao {
    //增加
    int insert(Clazz clazz);
    //删除
    int delete(Integer id);
    //更新
    int update(Clazz clazz);
    //查询所有
    List<Clazz> queryAll();
    //查询班级id
    Clazz queryClassById(Integer id);
    //分页查询
    List<Clazz> queryClazzByPage(int pageNo, int pageSize);
    //计数
    Long CountAll();
}
