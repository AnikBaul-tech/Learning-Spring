package com.demo.first_spring_boot.controller;

import com.demo.first_spring_boot.app.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/user")  //@RequestMapping(value ="/user",method = RequestMethod.GET)
    public User getUser(){
        return new User(1,"Anik","anik@gmail.com");
    }
}
