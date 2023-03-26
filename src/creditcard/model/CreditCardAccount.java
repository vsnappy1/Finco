package creditcard.model;

import framework.model.Customer;
import framework.model.DefaultAccount;
import framework.model.Notification;
import framework.model.Transaction;

public abstract class CreditCardAccount extends DefaultAccount {
    private final String ccNumber;
    private final String expireDate;
    public CreditCardAccount(Customer customer, String ccNumber, String expireDate) {
        super(customer, new Notification<>() {
            @Override
            public boolean shouldSendNotification(Transaction transaction) {
                return -transaction.getAmount() > 600;
            }

            @Override
            public String getMessage(Transaction transaction) {
                if (transaction.getAmount() > 0) {
                    return transaction.getAmount() + "$ deposited in your account";
                }
                return -transaction.getAmount() + "$ charged from your account";
            }
        });
        this.ccNumber = ccNumber;
        this.expireDate = expireDate;
    }

    public abstract AccountType getAccountType();
    public abstract double getMonthlyInterest();
    public abstract double getMonthlyPayment();

    public String getCcNumber() {
        return ccNumber;
    }

    public String getExpireDate() {
        return expireDate;
    }

}
