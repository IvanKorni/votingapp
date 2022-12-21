package com.app.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MenuGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<MenuIncorrectData> handlerException(
            IdMenuException exception) {
        MenuIncorrectData menuIncorrectData = new MenuIncorrectData();
        menuIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(menuIncorrectData, HttpStatus.NOT_FOUND);
    }
}
