package Structural_Design_Pattern.Adapter_Pattern;

//Legacy Code
//Part of our system
interface NotificationService {
    void sendNotification(String to, String subject, String body);
}

class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String to, String subject, String body) {
        System.out.println("Email Notification Service");
        System.out.println("Message to: " + to);
        System.out.println("Message subject: " + subject);
        System.out.println("Message body: " + body);
    }
}


//Different system code
//Now lets say we have SendGrid class
class SendGridNotificationService {
    public void sendEmail(String recipient, String title, String message) {
        System.out.println("Email Notification Service");
        System.out.println("Message to: " + recipient);
        System.out.println("Message subject: " + title);
        System.out.println("Message body: " + message);
    }
}

//client
public class WithoutAdapterPattern {
    public static void main(String[] args) {
        NotificationService notificationService = new EmailNotificationService();
        notificationService.sendNotification("abc.gmail.abc", "my subject", "my body");

        // wanted to do this they both have different method name
        // we won't be since SendGridNotificationService doesn't implement NotificationService

        // NotificationService sendGridNotification = new SendGridNotificationService();

        //how can we do ??
        //we won't directly use it for that we have to create an adapter between them

    }
}
