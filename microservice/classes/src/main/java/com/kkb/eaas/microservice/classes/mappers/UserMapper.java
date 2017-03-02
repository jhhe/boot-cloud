package com.kkb.eaas.microservice.classes.mappers;

import com.kkb.eaas.commons.base.BaseMapper;
import com.kkb.eaas.microservice.classes.domains.User;
import com.kkb.eaas.microservice.classes.repositories.SecondRepository;

/**
 * Created by lixzh on 1/17/17.
 */
@SecondRepository
public interface UserMapper extends BaseMapper<User> {
}