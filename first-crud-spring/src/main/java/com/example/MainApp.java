package com.example;

import com.example.config.AppConfig;
import com.example.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        UserController controller = applicationContext.getBean(UserController.class);
        controller.createUser("Puku");
        controller.createUser("Anik");
        controller.listUsers();
    }
}
