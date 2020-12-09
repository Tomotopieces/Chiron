package io.team.work.model.dao;

import java.util.List;

/**
 * 作者：liuxuhui
 * 日期: 2020/12/9 11:44
 * 描述:
 */
public interface Homework {
    //增加
    int insert(Homework homework);
    //删除
    int delete(Integer id);
    //更新
    int update(Homework homework);
    //查询所有
    List<Homework> queryAll();
    //根据id查询
    Homework queryHomeworkById(Integer id);
    //分页
    List<Homework> queryHomeworkByPage(int pageNo, int pageSize);
    //计数
    Long CountAll();
}
