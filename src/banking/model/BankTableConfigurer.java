package banking.model;

import framework.model.TableConfigurer;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class BankTableConfigurer implements TableConfigurer<BankAccount> {
    List<String> bankTableLabels = List.of("Account Number", "Name", "City", "Ch/S", "P/C", "Balance");

    @Override
    public DefaultTableModel getModel() {
        DefaultTableModel model = new DefaultTableModel();
        bankTableLabels.forEach(model::addColumn);
        return model;
    }

    @Override
    public String[] mapToRow(BankAccount account) {

        return new String[]{
                account.getAccountNumber(),
                account.getCustomer().getName(),
                account.getCustomer().getCity(),
                account.getAccountType() == AccountType.CHECKING ? "Ch" : "S",
                account.getOwnerType() == OwnerType.COMPANY ? "C" : "P",
                String.valueOf(account.getBalance())
        };
    }
}
