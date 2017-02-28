package com.huike.eaas.microservice.classes.services;

import com.huike.eaas.commons.base.BaseMapper;
import com.huike.eaas.commons.base.BaseApiService;
import com.huike.eaas.microservice.classes.domains.Clazz;
import com.huike.eaas.microservice.classes.mappers.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lixzh on 1/17/17.
 */
@Service
public class ClassApiService extends BaseApiService<Clazz> {
    @Autowired
    private ClassMapper classMapper;

    @Override
    protected BaseMapper<Clazz> getMapper() {
        return this.classMapper;
    }
}
