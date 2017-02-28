package com.huike.eaas.ui.admin.controllers;

import com.huike.eaas.commons.base.BaseUIController;
import com.huike.eaas.commons.exceptions.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by lixzh on 2/19/17.
 */
@Controller
@RequestMapping("/eaas/admin")
public class AdminCtrl extends BaseUIController {
    @RequestMapping("/")
    public String helloHtml(){
        return "class";
    }
}