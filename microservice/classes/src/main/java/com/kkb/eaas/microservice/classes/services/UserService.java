package com.kkb.eaas.microservice.classes.services;

import com.kkb.eaas.commons.base.BaseApiService;
import com.kkb.eaas.commons.base.BaseMapper;
import com.kkb.eaas.microservice.classes.domains.User;
import com.kkb.eaas.microservice.classes.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lixzh on 1/17/17.
 */
@Service
public class UserService extends BaseApiService<User> {
    @Autowired
    private UserMapper userMapper;

    @Override
    protected BaseMapper<User> getMapper() {
        return this.userMapper;
    }
}
