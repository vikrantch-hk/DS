package design.pattern.bridge;

public class EmailNotificationChannel implements NotificationChannel{
    @Override
    public void sendNotification() {
        System.out.println("sending via email");
    }
}
