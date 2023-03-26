package framework.model;

public interface Notification<T> {
    boolean shouldSendNotification(T t);
    String getMessage(T t);
}
