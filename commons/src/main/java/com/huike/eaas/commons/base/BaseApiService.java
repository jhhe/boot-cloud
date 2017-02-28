package com.huike.eaas.commons.base;

import java.util.List;

/**
 * Created by lixzh on 1/17/17.
 */
public abstract class BaseApiService<T> extends BaseService {
    protected abstract BaseMapper<T> getMapper();

    public T findById(Long id) {
        return this.getMapper().findById(id);
    }

    public List<T> findAll() {
        return this.getMapper().findAll();
    }

    public Long create(T t) {
        return this.getMapper().create(t);
    }

    public int update(T t) {
        return this.getMapper().update(t);
    }

    public int deleteById(Long id) {
        return this.getMapper().deleteById(id);
    }

    public int deleteByObject(T t) {
        return this.getMapper().deleteByObject(t);
    }
}
