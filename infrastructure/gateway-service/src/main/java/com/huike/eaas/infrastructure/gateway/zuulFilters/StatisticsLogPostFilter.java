package com.huike.eaas.infrastructure.gateway.zuulFilters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lixzh on 1/21/17.
 */
public class StatisticsLogPostFilter extends ZuulFilter {
    private static Logger logger = Logger.getLogger(AccessLogFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 99;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info(String.format("%s statistic post request to %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
    }
}
