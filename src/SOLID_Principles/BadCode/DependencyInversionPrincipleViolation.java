package SOLID_Principles.BadCode;

class SMSNotification {
    public void sendSMS(String message) {
        System.out.println("Message send to " + message);
    }
}

//tightly couple
//violates the dependency inversion principle
class EmailNotification {
    public void sendEmail(String message) {
        System.out.println("Email sent to " + message);
    }
}

class NotificationService {
    private EmailNotification emailNotification;
    private SMSNotification smsNotification;

    public NotificationService() {
        emailNotification = new EmailNotification();
        smsNotification = new SMSNotification();
    }

    public void notifySMS(String message) {
        smsNotification.sendSMS(message);
    }

    public void notifyEmail(String message) {
        emailNotification.sendEmail(message);
    }
}



public class DependencyInversionPrincipleViolation {
    public static void main(String[] args) {

    }
}
