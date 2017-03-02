package com.kkb.eaas.ui.users.controllers;

import com.kkb.eaas.commons.base.BaseUIController;
import com.kkb.eaas.ui.users.gateway.ClassClient;
import com.kkb.eaas.ui.users.gateway.UserClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lixzh on 1/17/17.
 */
@RestController
public class UserApiController extends BaseUIController {
    private static Logger logger = Logger.getLogger(UserApiController.class);

    @Autowired
    private UserClient userClient;

    @Autowired
    private ClassClient classClient;

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public Object user(){
        return userClient.findById("1");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/class")
    public Object clazz(){
        return classClient.findById("1");
    }
}
