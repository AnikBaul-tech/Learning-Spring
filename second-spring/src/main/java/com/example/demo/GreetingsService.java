package com.example.demo;

import org.springframework.stereotype.Component;
@Component("myBean")
public class GreetingsService {
    public void sayHello(){
        System.out.println("Hello From Spring ! Using Annotations");
    }
}