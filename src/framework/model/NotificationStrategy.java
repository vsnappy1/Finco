package framework.model;

public interface NotificationStrategy<T extends Customer> {
    void sendNotification(T customer, String text);
}
