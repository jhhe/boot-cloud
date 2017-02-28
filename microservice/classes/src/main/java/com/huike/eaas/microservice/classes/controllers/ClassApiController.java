package com.huike.eaas.microservice.classes.controllers;

import com.huike.eaas.commons.base.BaseApiController;
import com.huike.eaas.microservice.classes.domains.Clazz;
import com.huike.eaas.microservice.classes.services.ClassApiService;
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

    @RequestMapping(value = "/class/{id}", method = RequestMethod.GET)
    public Clazz getUser(@PathVariable Long id) {
        return classService.findById(id);
    }
}
