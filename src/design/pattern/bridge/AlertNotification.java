package design.pattern.bridge;

public class AlertNotification implements Notification{
    NotificationChannel notificationChannel;
    public AlertNotification(NotificationChannel notificationChannel){
        this.notificationChannel = notificationChannel;
    }
    @Override
    public void send(String message) {
        System.out.println("Alert "+message);
        notificationChannel.sendNotification();
    }
}
