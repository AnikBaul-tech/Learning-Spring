package com.example.autowire;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class EmailNotification implements NotificationService{
    @Override
    public void hello() {
        System.out.println("Hello,Sending an Email");
    }
}
