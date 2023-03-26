package creditcard.model;

import framework.model.Transaction;

import java.util.Calendar;
import java.util.Date;

public class ChargeTransaction implements Transaction {
    private final String name;
    private final int amount;
    private final Calendar date;

    public ChargeTransaction(String name, int amount, Calendar date) {
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAmount() {
        return -amount;
    }

    @Override
    public Calendar getDate() {
        return date;
    }
}
