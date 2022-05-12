package com.syning.except;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
/**
 *  处理整个web controller的异常
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    // 处理异常
    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public String handlerArithException(Exception ex) {
        log.error("处理的异常是:{}", ex.getClass());

        return "login";  // 可以返回视图名称，也可以直接返回 ModelAndView
    }
}
