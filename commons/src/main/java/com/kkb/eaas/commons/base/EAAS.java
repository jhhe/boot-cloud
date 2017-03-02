package com.kkb.eaas.commons.base;

import com.kkb.eaas.commons.exceptions.GExceptionHandler;
import org.springframework.context.annotation.Bean;

/**
 * Created by lixzh on 1/21/17.
 */
public abstract class EAAS {
    @Bean
    public GExceptionHandler initException(){
        return new GExceptionHandler();
    }
}
