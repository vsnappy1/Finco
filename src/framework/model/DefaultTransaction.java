package framework.model;

import java.util.Calendar;
import java.util.Date;

public class DefaultTransaction implements Transaction {
    private String name;
    private final int amount;
    private final Calendar date;

    public DefaultTransaction(String name, int amount, Calendar date) {
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
        return amount;
    }

    @Override
    public Calendar getDate() {
        return date;
    }
}
