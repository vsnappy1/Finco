package banking.view;

import banking.model.BankAccount;
import framework.database.Database;
import framework.view.DefaultMainFrame;
import framework.model.TableConfigurer;

public class BankFrame extends DefaultMainFrame<BankAccount>{

	public BankFrame(Database<BankAccount> database, TableConfigurer<BankAccount> tableConfigurer) {
        super(database,tableConfigurer, "Bank Application");
	}

	public String getSelectedAccountNumber() {
		return getChosenAccountNumber();
	}
}
