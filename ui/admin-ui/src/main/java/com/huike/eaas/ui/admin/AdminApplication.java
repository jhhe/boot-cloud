package com.huike.eaas.ui.admin;

import com.huike.eaas.commons.base.BaseUIApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
//@EnableFeignClients
//@EnableAutoConfiguration
//@EnableDiscoveryClient
public class AdminApplication extends BaseUIApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}

