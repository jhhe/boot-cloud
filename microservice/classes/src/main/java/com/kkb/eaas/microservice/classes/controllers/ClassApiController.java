package com.kkb.eaas.microservice.classes.controllers;

import com.kkb.eaas.commons.base.BaseApiController;
import com.kkb.eaas.microservice.classes.domains.Clazz;
import com.kkb.eaas.microservice.classes.domains.User;
import com.kkb.eaas.microservice.classes.services.ClassApiService;
import com.kkb.eaas.microservice.classes.services.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

/**
 * Created by lixzh on 1/17/17.
 */
@RestController
@Validated
public class ClassApiController extends BaseApiController {
    @Autowired
    private ClassApiService classService;
    @Autowired
    private UserService userService;

    @ApiOperation(value="获取班次信息", notes="根据id获取班次信息")
    @ApiImplicitParam(name = "id", value = "班次id", required = true, dataType = "Long")
    @RequestMapping(value = "/class/{id}", method = RequestMethod.GET)
    public Clazz getUser(@PathVariable  @Min(10) Long id) {
        Clazz clazz =  classService.findById(id);
        User user = userService.findById(22l);
        return clazz;
    }

    @ApiOperation(value="获取班次信息", notes="根据id获取班次信息")
    @ApiImplicitParam(name = "id", value = "班次id", required = true, dataType = "Long")
    @RequestMapping(value = "/class", method = RequestMethod.POST)
    public Clazz saveUser(@RequestBody @Validated Clazz clazz) {
        return clazz;
    }
}
