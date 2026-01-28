package com.example.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("UserServiceSMS")
public class UseServices {
    NotificationService notificationService;
    @Autowired
    public UseServices(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    public void notifyUser(){
        notificationService.hello();
    }
}
