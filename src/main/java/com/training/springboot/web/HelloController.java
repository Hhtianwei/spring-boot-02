package com.training.springboot.web;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2017/12/25.
 */
@RestController
@RequestMapping("/world")
public class HelloController {

    private PasswordEncoder passwordEncoder;

    public HelloController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

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

    @GetMapping("/password")
    public String test4(){
        boolean flag = passwordEncoder.matches("tianwei",passwordEncoder.encode("tianwei"));
        return "flag:" +flag +"  "+ passwordEncoder.encode("tianwei");
    }
}
