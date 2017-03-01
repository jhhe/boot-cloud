package com.huike.eaas.microservice.classes.controllers;

import com.huike.eaas.commons.base.BaseApiController;
import com.huike.eaas.microservice.classes.domains.Clazz;
import com.huike.eaas.microservice.classes.services.ClassApiService;
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

    @ApiOperation(value="获取班次信息", notes="根据id获取班次信息")
    @ApiImplicitParam(name = "id", value = "班次id", required = true, dataType = "Long")
    @RequestMapping(value = "/class/{id}", method = RequestMethod.GET)
    public Clazz getUser(@PathVariable Long id) {
        return classService.findById(id);
    }
}
