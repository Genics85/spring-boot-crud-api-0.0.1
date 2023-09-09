package com.spring.bootlearn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/ping")
    public String helloWorld(){
        return "pong";
    }
}
