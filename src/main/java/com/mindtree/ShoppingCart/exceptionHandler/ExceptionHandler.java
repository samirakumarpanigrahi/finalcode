package com.mindtree.ShoppingCart.exceptionHandler;

import com.mindtree.ShoppingCart.dto.ExceptionDto;
import com.mindtree.ShoppingCart.exception.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


@RestControllerAdvice(annotations = RestController.class)
public class ExceptionHandler {

        @org.springframework.web.bind.annotation.ExceptionHandler(ApplicationException.class)
        @ResponseStatus(value = HttpStatus.NOT_FOUND)
        public ExceptionDto exceptionGetter(final ApplicationException exception, final HttpServletRequest request) {
            ExceptionDto exceptionDto = new ExceptionDto();
            exceptionDto.setMessage(exception.getMessage());
            exceptionDto.setUrl(request.getRequestURI());
            return exceptionDto;
        }

    }
