package framework.model;

public class NotificationContext<T extends Customer> {
    private NotificationStrategy<T> strategy;

    public NotificationContext(NotificationStrategy<T> strategy) {
        this.strategy = strategy;
    }
    public void sendNotification(T customer, String text){
        strategy.sendNotification(customer, text);
    }

    public void setStrategy(NotificationStrategy<T> strategy) {
        this.strategy = strategy;
    }
}
