package com.huike.eaas.ui.classes;

import com.huike.eaas.commons.base.BaseUIApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by lixzh on 1/19/17.
 */
@SpringBootApplication
@EnableFeignClients
@EnableAutoConfiguration
@EnableDiscoveryClient
public class Application extends BaseUIApplication {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
