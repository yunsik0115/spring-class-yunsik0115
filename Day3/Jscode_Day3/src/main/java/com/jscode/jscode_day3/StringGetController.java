package com.jscode.jscode_day3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StringGetController {

    @GetMapping("/name")
    public String myName(){
        log.info("------- log test name --------");
        return "김윤식";
    }

    @GetMapping("/api/{id}")
    @ResponseBody
    public String getFoos(@PathVariable("id") String name) {
        log.info("----- log test pathvariable-----");
        return name;
    }

    @GetMapping("/api")
    @ResponseBody
    public String getFoo(@RequestParam("name") String name){
        return name;
    }

}
