package design.pattern.bridge;

public class Main {
    public static void main(String[] args) {
        Notification notification = new AlertNotification(new EmailNotificationChannel());
        notification.send("hiii");
        }
    }
}
