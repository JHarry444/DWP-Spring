package com.qa.demo.rest;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// Spring uses annotations to configure the project
@RestController // it allows Spring to process HTTP requests
public class TreeController {

    // receives a GET request to /test
    // Responds with text - "Hello, World!"
    @GetMapping("/test")
    public String get() {
        return "Hello, World!";
    }
}
