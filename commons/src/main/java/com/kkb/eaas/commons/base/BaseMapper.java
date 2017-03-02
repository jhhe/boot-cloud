package com.kkb.eaas.commons.base;

import java.util.List;

/**
 * Created by lixzh on 1/17/17.
 */
//@Component
public interface BaseMapper<T> {
    T findById(Long id);
    List<T> findAll();
    Long create(T t);
    int update(T t);
    int deleteById(Long id);
    int deleteByObject(T t);
}
