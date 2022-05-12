package com.syning.boot.boot04web02.exception_;


import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *  处理整个 web controller 的异常
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    // 处理异常注解
    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public String handleArithException(Exception e, Model model) {

        model.addAttribute("message", "除0异常");

        return "login";
    }


}
