package com.kkb.eaas.ui.admin;

import com.kkb.eaas.commons.base.BaseUIApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableFeignClients
//@EnableAutoConfiguration
//@EnableDiscoveryClient
public class AdminApplication extends BaseUIApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}

