package com.jscode.jscode_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/restget")
    public String restget(){
        return "restcontroller";
    }

}
