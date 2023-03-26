package creditcard.model;

import framework.model.Customer;

public class GoldenCreditCardAccount extends CreditCardAccount{

    public GoldenCreditCardAccount(Customer customer, String ccNumber, String expireDate) {
        super(customer, ccNumber, expireDate);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.GOLDEN ;
    }

    @Override
    public double getMonthlyInterest() {
        return 0.14;
    }

    @Override
    public double getMonthlyPayment() {
        return 0.12;
    }
}
