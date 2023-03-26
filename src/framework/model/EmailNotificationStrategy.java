package framework.model;

public class EmailNotificationStrategy<T extends Customer> implements NotificationStrategy<T>{
    @Override
    public void sendNotification(T customer, String text) {
        System.out.println(text);
        System.out.println("Sent to "+customer.getEmail());
    }
}
