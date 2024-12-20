package Structural_Design_Pattern.Adapter_Pattern;

interface Notification {
    void send(String to, String subject, String body);
}

class EmailNotification implements Notification {
    @Override
    public void send(String to, String subject, String body) {
        System.out.println("Email Notification Legacy service");
        System.out.println("To: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
}


//different service with different method name
class SendGridNotification {
    public void sendEmail(String recipient, String title, String message) {
        System.out.println("Email Notification from SendGridNotificationService");
        System.out.println("To: " + recipient);
        System.out.println("Subject: " + title);
        System.out.println("Body: " + message);
    }
}

//creating adapter for new SendGrid service to be used from our existing Notification Service
class SendGridAdapter implements Notification {

    private final SendGridNotification sendGridNotification;

    public SendGridAdapter(SendGridNotification sendGridNotification) {
        this.sendGridNotification = sendGridNotification;
    }

    @Override
    public void send(String to, String subject, String body) {
        sendGridNotification.sendEmail(to, subject, body);
    }
}

//client
public class AdapterPattern {
    public static void main(String[] args) {
        Notification notification = new EmailNotification();
        notification.send("abc@abc.com", "Hello", "Hello World");

        Notification sendGridNotification = new SendGridAdapter(new SendGridNotification());
        sendGridNotification.send("abc@abc.com", "Hello", "Hello World");
    }
}
