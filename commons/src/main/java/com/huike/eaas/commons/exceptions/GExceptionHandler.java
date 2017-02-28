package com.huike.eaas.commons.exceptions;

import com.huike.eaas.commons.objects.ErrorObject;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lixzh on 1/20/17.
 */

@ControllerAdvice
public class GExceptionHandler {
    private static Logger logger = Logger.getLogger(GExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error("发生Exception");
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public ErrorObject<String> jsonErrorHandler(HttpServletRequest req, ServiceException e) throws Exception {
        logger.error("发生ServiceException");
        ErrorObject<String> r = new ErrorObject<String>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorObject.ERROR);
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
}
