package com.example.autowire;

import com.example.demo.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp2 {
    public static void main(String[] args) {
        System.out.println("Starting Spring Application");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UseServices useServices = context.getBean(UseServices.class);
        useServices.notifyUser(); //Autowire example showing
        System.out.println("Retrieving Lifecycle Bean");
        LifeCycleBean lifeCycleBean = context.getBean(LifeCycleBean.class);
        lifeCycleBean.performTask();
        System.out.println("Closing");
    }
}
