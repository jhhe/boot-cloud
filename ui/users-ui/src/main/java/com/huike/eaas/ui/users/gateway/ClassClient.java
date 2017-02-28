package com.huike.eaas.ui.users.gateway;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lixzh on 1/17/17.
 */
@FeignClient("class-service")
public interface ClassClient {
    @RequestMapping(method = RequestMethod.GET, value = "/class/{id}")
    Object findById(@RequestParam("id") String id);
}