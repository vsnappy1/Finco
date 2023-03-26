package creditcard.view;

import creditcard.model.CreditCardAccount;
import framework.database.Database;
import framework.model.TableConfigurer;
import framework.view.DefaultMainFrame;

public class CreditCardFrame extends DefaultMainFrame<CreditCardAccount>{

	public CreditCardFrame(Database<CreditCardAccount> database, TableConfigurer<CreditCardAccount> tableConfigurer) {
        super(database,tableConfigurer, "Credit Card Application");
	}

	public String getSelectedAccountNumber() {
		return getChosenAccountNumber();
	}
}
