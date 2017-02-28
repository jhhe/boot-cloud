package com.huike.eaas.infrastructure.monitor;

import com.huike.eaas.commons.base.BaseInfrastructureApplication;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by lixzh on 1/19/17.
 */

@EnableEurekaServer
@SpringBootApplication
public class Application extends BaseInfrastructureApplication {
    private static Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("============= Monitor Service Start Success =============");
    }
}
