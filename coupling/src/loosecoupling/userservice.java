package loosecoupling;

public class userservice {
    NotificationService notificationService;

    public userservice(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyUser(String message){
        notificationService.send("Notification: "+ message);
    }
}