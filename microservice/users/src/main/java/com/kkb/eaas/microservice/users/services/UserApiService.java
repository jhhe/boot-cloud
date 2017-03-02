package com.kkb.eaas.microservice.users.services;

import com.kkb.eaas.commons.base.BaseMapper;
import com.kkb.eaas.commons.base.BaseApiService;
import com.kkb.eaas.microservice.users.domain.User;
import com.kkb.eaas.microservice.users.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lixzh on 1/17/17.
 */
@Service
public class UserApiService extends BaseApiService<User> {

    @Autowired
    private UserMapper userMapper;

    @Override
    protected BaseMapper<User> getMapper() {
        return userMapper;
    }
}
