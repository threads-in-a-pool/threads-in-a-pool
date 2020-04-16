package org.academiadecodigo.rhashtafaris.threadsinapool.controller.web;

import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.WebAppException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = WebAppException.class)
    public ModelAndView handleClientErrors(HttpServletRequest req, WebAppException ex){

        ModelAndView model = new ModelAndView();

        model.setViewName("404");
        return model;
    }
}
