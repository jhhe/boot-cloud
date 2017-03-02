/**
 *  Copyright (c)  2014-2020 Gaoxiaobang, Inc.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of Gaoxiaobang, 
 *  Inc. ("Confidential Information"). You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into with Gaoxiaobang.
 */
package com.kkb.eaas.microservice.classes.db.route;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * aspect point cut.
 * 
 * Filtration Principle:
 * 1.method name
 * 2.transactional sign
 * 
 * @author lh
 * @date 2015年11月4日
 */
@Aspect
@Component
@Slf4j
public class ReadWriteDataSourceAspect {

	@Pointcut("execution(* com.kkb.eaas.microservice.classes.services.*Service.*(..)) ||" +
			"execution(* com.kkb.eaas.commons.base.*ApiService.*(..))")
	public void readWrite(){}

	@Before("readWrite()")
	public void before(JoinPoint point) {
		log.debug("into read write aop");
		
		Object target = point.getTarget();
		String method = point.getSignature().getName();

        // if current is write,no change
        if(ReadWriteDataSourceDecision.isChoiceWrite()) {
            return;
        }
        
		Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
		try {
			Method m = target.getClass().getMethod(method, parameterTypes);
			if (m != null && (m.isAnnotationPresent(Transactional.class) || m.getName().matches("save.*|update.*|delete.*")) ) {
				ReadWriteDataSourceDecision.markWrite();
			}else{
				ReadWriteDataSourceDecision.markRead();
			}
		} catch (Exception e) {
			log.error("mark read write error",e);
		}
	}

}
