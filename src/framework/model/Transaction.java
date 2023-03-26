package framework.model;

import java.util.Calendar;
import java.util.Date;

public interface Transaction {
    public String getName();
    int getAmount();
    Calendar getDate();
}
