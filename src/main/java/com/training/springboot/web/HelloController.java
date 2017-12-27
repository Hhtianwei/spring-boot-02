package com.training.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2017/12/25.
 */
@RestController("/world")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello world";
    }

    @GetMapping("/hello2")
    public String sayHello2(){
        return "hello world2";
    }

    @GetMapping("/hi")
    public String sayHi(){
        return "hi world";
    }

}
