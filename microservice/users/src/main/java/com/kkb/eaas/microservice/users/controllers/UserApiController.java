package com.kkb.eaas.microservice.users.controllers;

import com.kkb.eaas.commons.base.BaseApiController;
import com.kkb.eaas.commons.exceptions.ServiceException;
import com.kkb.eaas.microservice.users.domain.User;
import com.kkb.eaas.microservice.users.services.UserApiService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserApiController extends BaseApiController {
    private static Logger logger = Logger.getLogger(UserApiController.class);

    @Autowired
    private UserApiService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/haha/{id}", method = RequestMethod.GET)
    public String home(@PathVariable Long id) throws ServiceException {
        logger.info("调用了/user/");
        logger.info(id);
        throw new ServiceException("hello exception");
    }
}