package creditcard.model;

import framework.model.Customer;

public class SilverCreditCardAccount extends CreditCardAccount{

    public SilverCreditCardAccount(Customer customer, String ccNumber, String expireDate) {
        super(customer, ccNumber, expireDate);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.SILVER ;
    }

    @Override
    public double getMonthlyInterest() {
        return 0.16;
    }

    @Override
    public double getMonthlyPayment() {
        return 0.18;
    }
}
