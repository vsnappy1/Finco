package creditcard.model;

import framework.model.Customer;

public class CopperCreditCardAccount extends CreditCardAccount{

    public CopperCreditCardAccount(Customer customer, String ccNumber, String expireDate) {
        super(customer, ccNumber, expireDate);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.COPPER ;
    }

    @Override
    public double getMonthlyInterest() {
        return 0.20;
    }

    @Override
    public double getMonthlyPayment() {
        return 0.22;
    }
}
