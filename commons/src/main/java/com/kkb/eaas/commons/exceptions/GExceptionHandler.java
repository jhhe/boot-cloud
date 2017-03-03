package com.kkb.eaas.commons.exceptions;

import com.kkb.eaas.commons.objects.ErrorObject;
import com.kkb.eaas.commons.tool.CollectionTools;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<Object> processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<ObjectError> allError = result.getAllErrors();
        StringBuilder builder = new StringBuilder();
        if(CollectionTools.isNotEmpty(allError)){
            for(ObjectError objectError : allError){
                if(objectError instanceof FieldError){
                    FieldError fieldError = (FieldError) objectError;
                    builder.append(fieldError.getField()).append(fieldError.getDefaultMessage()).append(",");
                }
                else
                    builder.append(objectError.getDefaultMessage()).append(",");
            }
        }
        String errorStr = builder.toString();
        if(errorStr.length()>0)
            errorStr = errorStr.substring(0,errorStr.length()-1);
        ErrorObject<String> r = new ErrorObject<String>();
        r.setMessage(errorStr);
        r.setCode(ErrorObject.ERROR);
        r.setData(errorStr);
        return new ResponseEntity<Object>(r, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity<Object> processValidationError(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> set = ex.getConstraintViolations();
        StringBuilder builder = new StringBuilder();
        if(CollectionTools.isNotEmpty(set)){
            for(ConstraintViolation objectError : set){
                builder.append(objectError.getMessage()).append(",");
            }
        }
        String errorStr = builder.toString();
        if(errorStr.length()>0)
            errorStr = errorStr.substring(0,errorStr.length()-1);
        ErrorObject<String> r = new ErrorObject<String>();
        r.setMessage(errorStr);
        r.setCode(ErrorObject.ERROR);
        r.setData(errorStr);
        return new ResponseEntity<Object>(r, HttpStatus.BAD_REQUEST);
    }
}
