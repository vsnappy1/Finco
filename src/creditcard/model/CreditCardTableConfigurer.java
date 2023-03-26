package creditcard.model;


import framework.model.TableConfigurer;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CreditCardTableConfigurer implements TableConfigurer<CreditCardAccount> {
    List<String> bankTableLabels = List.of("CC Number", "Name", "Exp Date", "Type(G/S/C)", "Balance");

    @Override
    public DefaultTableModel getModel() {
        DefaultTableModel model = new DefaultTableModel();
        bankTableLabels.forEach(model::addColumn);
        return model;
    }

    @Override
    public String[] mapToRow(CreditCardAccount account) {

        return new String[]{
                account.getCcNumber(),
                account.getCustomer().getName(),
                account.getExpireDate(),
                account.getAccountType() == AccountType.GOLDEN ? "G" :
                        account.getAccountType() == AccountType.SILVER ? "S" : "C",
                String.valueOf(account.getBalance())
        };
    }
}
