package com.example.autowire;

import com.example.demo.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UseServices useServices = (UseServices) context.getBean("UserServiceSMS");
        useServices.notifyUser();
    }
}
