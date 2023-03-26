package banking.model;

import framework.model.Customer;
import framework.model.Notification;
import framework.model.Transaction;

public class PersonalBankAccount extends BankAccount{

    public PersonalBankAccount(String accountNumber, Customer customer, AccountType accountType) {
        super(accountNumber, customer, accountType, new Notification<>() {
            @Override
            public boolean shouldSendNotification(Transaction transaction) {
                return Math.abs(transaction.getAmount()) > 400;
            }

            @Override
            public String getMessage(Transaction transaction) {
                if (transaction.getAmount() > 0) {
                    return transaction.getAmount() + "$ deposited in your account";
                }
                return -transaction.getAmount() + "$ withdrawn from your account";
            }
        });
    }

    @Override
    public OwnerType getOwnerType() {
        return OwnerType.PERSONAL;
    }
}
