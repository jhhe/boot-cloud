package com.huike.eaas.infrastructure.conf;

import com.huike.eaas.commons.base.BaseInfrastructureApplication;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lixzh on 1/19/17.
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableConfigServer
public class Application extends BaseInfrastructureApplication {

    private static Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("============= Conf Service Start Success =============");
    }
}
