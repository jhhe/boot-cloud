package com.kkb.eaas.infrastructure.gateway;

import com.kkb.eaas.commons.base.BaseInfrastructureApplication;
import com.kkb.eaas.infrastructure.gateway.zuulFilters.AccessLogFilter;
import com.kkb.eaas.infrastructure.gateway.zuulFilters.AuthLogFilter;
import com.kkb.eaas.infrastructure.gateway.zuulFilters.StatisticsLogPostFilter;
import com.kkb.eaas.infrastructure.gateway.zuulFilters.StatisticsLogPreFilter;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lixzh on 1/19/17.
 */
@EnableZuulProxy
@EnableDiscoveryClient
@EnableAutoConfiguration
@SpringBootApplication
public class Application extends BaseInfrastructureApplication {
    private static Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("============= Gateway Service Start Success =============");
    }

    @Configuration
    public static class GatewayZuulFilterConfiguration{
        @Bean
        public AccessLogFilter initAccessLogFilter(){
            return new AccessLogFilter();
        }

        @Bean
        public AuthLogFilter initAuthLogFilter(){
            return new AuthLogFilter();
        }

        @Bean
        public StatisticsLogPreFilter initStatisticsLogPreFilter(){
            return new StatisticsLogPreFilter();
        }

        @Bean
        public StatisticsLogPostFilter initStatisticsLogPostFilter(){
            return new StatisticsLogPostFilter();
        }
    }
}