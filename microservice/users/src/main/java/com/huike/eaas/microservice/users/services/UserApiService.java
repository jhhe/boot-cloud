package com.huike.eaas.microservice.users.services;

import com.huike.eaas.commons.base.BaseMapper;
import com.huike.eaas.commons.base.BaseApiService;
import com.huike.eaas.microservice.users.domain.User;
import com.huike.eaas.microservice.users.mappers.UserMapper;
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
