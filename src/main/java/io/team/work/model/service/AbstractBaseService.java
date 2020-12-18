package io.team.work.model.service;

import io.team.work.model.dao.Dao;

import java.util.List;

/**
 * 基础Service类.
 * <p>
 * 实现了基本的增删查改.
 *
 * @author Tomoto
 * <p>
 * 2020/12/11 11:19
 */
public abstract class AbstractBaseService<T, ID> implements Service<T, ID> {
    @Override
    public Boolean add(T t) {
        return getDao().insert(t) == 1;
    }

    @Override
    public Boolean remove(ID id) {
        return getDao().delete(id) == 1;
    }

    @Override
    public T getById(ID id) {
        return getDao().queryById(id);
    }

    @Override
    public List<T> list() {
        return getDao().queryAll();
    }

    @Override
    public List<T> listByPage(Integer pageNo, Integer pageSize) {
        return getDao().queryByPage(pageNo, pageSize);
    }

    @Override
    public <P> Boolean update(ID id, String propertyName, P propertyValue) {
        return getDao().update(id, propertyName, propertyValue) == 1;
    }

    @Override
    public Long count() {
        return getDao().countAll();
    }

    protected abstract Dao<T, ID> getDao();
}
