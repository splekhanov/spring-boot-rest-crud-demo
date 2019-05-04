package com.example.demo.rest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.exception.RestExceptionHandler.response;

@RestController
public class IndexController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public ResponseEntity<String> error() {
        return response("Bad Request", "The request could not be understood by the server due to malformed syntax",
                HttpStatus.BAD_REQUEST);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
