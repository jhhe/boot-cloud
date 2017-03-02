package com.kkb.eaas.microservice.users.repositories;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by lixzh on 1/17/17.
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface UserRepository {
    String value() default "";
}