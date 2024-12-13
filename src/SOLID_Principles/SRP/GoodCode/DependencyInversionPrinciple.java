package SOLID_Principles.SRP.GoodCode;

interface NotificationChannel {
    void sendNotification();
}

class EmailNotificationChannel implements NotificationChannel {

    @Override
    public void sendNotification() {
        System.out.println("Email Notification Channel");
    }
}

class SMSNotificationChannel implements NotificationChannel {

    @Override
    public void sendNotification() {
        System.out.println("SMS Notification Channel");
    }
}

class NotificationService{
    private NotificationChannel notificationChannel;

    public NotificationService(NotificationChannel notificationChannel) {
        this.notificationChannel = notificationChannel;
    }
    public void sendNotification() {
        notificationChannel.sendNotification();
    }
}

public class DependencyInversionPrinciple {
    public static void main(String[] args) {
     NotificationService notificationService = new NotificationService(new EmailNotificationChannel());
     notificationService.sendNotification();
    }
}
