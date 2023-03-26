package framework.model;

import javax.swing.table.DefaultTableModel;

public class DefaultTableConfigurer implements TableConfigurer<DefaultAccount> {

	@Override
	public DefaultTableModel getModel() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("City");
		model.addColumn("Balance");
		return model;
	}

	@Override
	public String[] mapToRow(DefaultAccount account) {
		return new String[] {
				account.getCustomer().getName(),
				account.getCustomer().getCity(),
				String.valueOf(account.getBalance())
		};
	}

}
