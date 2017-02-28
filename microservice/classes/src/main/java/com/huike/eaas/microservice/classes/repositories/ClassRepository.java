package com.huike.eaas.microservice.classes.repositories;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by lixzh on 1/17/17.
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ClassRepository {
    String value() default "";
}