package com.kkb.eaas.ui.users.gateway;

import org.apache.log4j.Logger;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by lixzh on 1/17/17.
 */
@FeignClient("user-service")
public interface UserClient {
    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    Object findById(@RequestParam("id") String id);
}
