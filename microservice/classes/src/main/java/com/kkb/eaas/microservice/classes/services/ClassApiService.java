package com.kkb.eaas.microservice.classes.services;

import com.kkb.eaas.commons.base.BaseMapper;
import com.kkb.eaas.commons.base.BaseApiService;
import com.kkb.eaas.microservice.classes.domains.Clazz;
import com.kkb.eaas.microservice.classes.mappers.ClassMapper;
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
