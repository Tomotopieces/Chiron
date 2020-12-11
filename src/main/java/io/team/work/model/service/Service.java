package io.team.work.model.service;

import java.util.List;

/**
 * Service接口
 *
 * @author liuxuhui
 * <p>
 * 2020/12/10 9:51
 */
public interface Service<T, ID> {

    /**
     * 添加数据
     *
     * @param t 数据
     * @return 添加成功与否
     */
    Boolean add(T t);

    /**
     * 移除数据
     *
     * @param id 数据id
     * @return 移除成功与否
     */
    Boolean remove(ID id);

    /**
     * 通过id获取数据
     *
     * @param id 数据id
     * @return 数据
     */
    T getById(ID id);

    /**
     * 获取所有数据
     *
     * @return 数据列表
     */
    List<T> list();

    /**
     * 分页获取数据
     *
     * @param pageNo   页码
     * @param pageSize 每页数据条数
     * @return 数据列表
     */
    List<T> listByPage(Integer pageNo, Integer pageSize);

    /**
     * 分页获取数据, 每页数据条数为5
     *
     * @param pageNo 页码
     * @return 数据列表
     */
    default List<T> listByPage(Integer pageNo) {
        return listByPage(pageNo, 5);
    }

    /**
     * 更新数据属性
     *
     * @param id            数据id
     * @param propertyName  属性名
     * @param propertyValue 新属性值
     * @param <P>           属性类型
     * @return 更新成功与否
     */
    <P> Boolean update(ID id, String propertyName, P propertyValue);
}
