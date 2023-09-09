package com.spring.bootlearn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiResponseController {

    @GetMapping("/response")
    public ApiResponse getResponse(){
        return new ApiResponse("hello","code","no data");
    }
}
