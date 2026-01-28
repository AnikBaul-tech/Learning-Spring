import loosecoupling.EmailNotification;
import loosecoupling.NotificationService;
import loosecoupling.userservice;
import tightcoupling.UserService;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        tight
        UserService userService = new UserService();
        userService.notifyUser("Order Placed");

//        loose
        NotificationService emailService = new EmailNotification();
        loosecoupling.userservice userservice = new userservice(emailService);
        userService.notifyUser("Order Processed");
//        Dependency injections are explained in detail in the notes
    }
}