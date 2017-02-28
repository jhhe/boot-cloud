package com.huike.eaas.ui.users.controllers;

import com.huike.eaas.commons.base.BaseUIController;
import com.huike.eaas.ui.users.gateway.UserClient;
import com.vaadin.server.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by lixzh on 1/17/17.
 */
@Controller
public class UserController extends BaseUIController {
    @RequestMapping("/index")
    public String helloHtml(Map<String,Object> map){

        map.put("hello","from TemplateController.helloHtml");
        return"index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting() throws ServiceException{
        throw new ServiceException("发生异常");
    }
}
