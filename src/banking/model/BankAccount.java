package banking.model;

import framework.model.DefaultAccount;
import framework.model.Customer;
import framework.model.Notification;
import framework.model.Transaction;

public abstract class BankAccount extends DefaultAccount {
    private final String accountNumber;
    private final AccountType accountType;

    public BankAccount(String accountNumber, Customer customer, AccountType accountType, Notification<Transaction> notification) {
        super(customer, notification);
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public abstract OwnerType getOwnerType();
    public AccountType getAccountType(){
        return accountType;
    };
}
