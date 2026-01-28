package com.example.autowire;

public class LifeCycleBean {
    private NotificationService notificationService;
    public LifeCycleBean(NotificationService notificationService){
        System.out.println("Constructor Called: Dependency Injected");
        this.notificationService = notificationService;
    }

    public void init(){
        System.out.println("init() called : Bean Initialised");
    }
    public void performTask(){
        System.out.println("Ready for use,Performing");
    }
    public void cleanup(){
        System.out.println("Cleanup called");
    }
}
