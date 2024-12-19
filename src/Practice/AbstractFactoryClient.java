package Practice;

interface Notification {
    void notifyUser();
}
//Concrete classes for notification
//Email Notification
class GmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending Email Notification via Gmail");
    }
}

class OutlookNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending Email Notification via Outlook");
    }
}

//SMS Notification
class TwilioNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending SMS Notification via Twilio");
    }
}

class NexmoNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending SMS Notification via Nexmo");
    }
}

//Push Notification
class FirebaseNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending Push Notification via Firebase");
    }
}

class OneSignalNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending Push Notification via OneSignal");
    }
}



// categorization of notification email, sms, and push
// abstract factory
// Factory of Factory
interface NotificationFactory {
    Notification createNotification(String provider);
}

class EmailNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification(String provider) {
        switch (provider.toLowerCase()) {
            case "gmail":
                return new GmailNotification();
            case "outlook":
                return new OutlookNotification();
            default:
                throw new IllegalArgumentException("Unknown Email Provider: " + provider);
        }
    }
}

class SMSNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification(String provider) {
        switch (provider.toLowerCase()) {
            case "twilio":
                return new TwilioNotification();
            case "nexmo":
                return new NexmoNotification();
            default:
                throw new IllegalArgumentException("Unknown SMS Provider: " + provider);
        }
    }
}

class PushNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification(String provider) {
        switch (provider.toLowerCase()) {
            case "firebase":
                return new FirebaseNotification();
            case "onesignal":
                return new OneSignalNotification();
            default:
                throw new IllegalArgumentException("Unknown Push Provider: " + provider);
        }
    }
}

// Master factory
class NotificationMasterFactory {
    public static NotificationFactory getNotificationFactory(String type) {
        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotificationFactory();
            case "sms":
                return new SMSNotificationFactory();
            case "push":
                return new PushNotificationFactory();
            default:
                throw new IllegalArgumentException("Unknown Notification Type: " + type);
        }
    }
}


public class AbstractFactoryClient {
    public static void main(String[] args) {

        // Get Email Factory and create notifications
        NotificationFactory emailFactory = NotificationMasterFactory.getNotificationFactory("email");
        Notification gmailNotification = emailFactory.createNotification("gmail");
        gmailNotification.notifyUser();

        Notification outlookNotification = emailFactory.createNotification("outlook");
        outlookNotification.notifyUser();

        // Get SMS Factory and create notifications
        NotificationFactory smsFactory = NotificationMasterFactory.getNotificationFactory("sms");
        Notification twilioNotification = smsFactory.createNotification("twilio");
        twilioNotification.notifyUser();

        Notification nexmoNotification = smsFactory.createNotification("nexmo");
        nexmoNotification.notifyUser();

        // Get Push Factory and create notifications
        NotificationFactory pushFactory = NotificationMasterFactory.getNotificationFactory("push");
        Notification firebaseNotification = pushFactory.createNotification("firebase");
        firebaseNotification.notifyUser();

        Notification oneSignalNotification = pushFactory.createNotification("onesignal");
        oneSignalNotification.notifyUser();
    }
}
