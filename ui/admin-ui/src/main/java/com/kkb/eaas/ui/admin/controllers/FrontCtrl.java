package com.kkb.eaas.ui.admin.controllers;

import com.kkb.eaas.commons.base.BaseUIController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lixzh on 2/20/17.
 */
@Controller
@RequestMapping("/eaas/front")
public class FrontCtrl extends BaseUIController {
    @RequestMapping("/")
    public String helloHtml(){
        return "class";
    }
}