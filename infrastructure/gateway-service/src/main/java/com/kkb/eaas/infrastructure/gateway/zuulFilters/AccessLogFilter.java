package com.kkb.eaas.infrastructure.gateway.zuulFilters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lixzh on 1/19/17.
 */
@Component
public class AccessLogFilter extends ZuulFilter {
    private static Logger logger = Logger.getLogger(AccessLogFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info(String.format("%s access request to %s", request.getMethod(), request.getRequestURL().toString()));

        return null;
    }
}
