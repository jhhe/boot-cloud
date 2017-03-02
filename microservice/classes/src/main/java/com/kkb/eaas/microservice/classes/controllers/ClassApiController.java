package com.kkb.eaas.microservice.classes.controllers;

import com.kkb.eaas.commons.base.BaseApiController;
import com.kkb.eaas.microservice.classes.domains.Clazz;
import com.kkb.eaas.microservice.classes.domains.User;
import com.kkb.eaas.microservice.classes.services.ClassApiService;
import com.kkb.eaas.microservice.classes.services.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lixzh on 1/17/17.
 */
@RestController
public class ClassApiController extends BaseApiController {
    @Autowired
    private ClassApiService classService;
    @Autowired
    private UserService userService;

    @ApiOperation(value="获取班次信息", notes="根据id获取班次信息")
    @ApiImplicitParam(name = "id", value = "班次id", required = true, dataType = "Long")
    @RequestMapping(value = "/class/{id}", method = RequestMethod.GET)
    public Clazz getUser(@PathVariable Long id) {
        Clazz clazz =  classService.findById(id);
        User user = userService.findById(22l);
        return clazz;
    }
}
