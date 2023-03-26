package framework.model;

import java.util.ArrayList;
import java.util.List;

public class DefaultAccount implements Account {
    private final Customer customer;
    private final List<Transaction> transactions;
    private int balance;
    private NotificationContext<Customer> notificationContext;
    private final Notification<Transaction> notification;

    public DefaultAccount(Customer customer, Notification<Transaction> notification) {
        this.customer = customer;
        this.notification = notification;
        this.notificationContext = new NotificationContext<>(new EmailNotificationStrategy<>());
        this.transactions = new ArrayList<>();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setNotificationContext(NotificationContext<Customer> notificationContext) {
        this.notificationContext = notificationContext;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        balance += transaction.getAmount();
        if (notification.shouldSendNotification(transaction)) {
            notificationContext.sendNotification(customer, notification.getMessage(transaction));
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
