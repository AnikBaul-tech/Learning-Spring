package com.example.autowire;

import org.springframework.stereotype.Component;

@Component
public class SMSNotification implements NotificationService{
    public void hello(){
        System.out.println("Hello , Sending an SMS");
    }
}
