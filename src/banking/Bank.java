package banking;

import banking.database.InMemoryDatabase;
import banking.factory.BankFrameFactory;
import banking.model.BankAccount;
import banking.model.BankTableConfigurer;
import framework.*;
import framework.database.Database;
import framework.factory.FrameFactory;

public class Bank extends Finco {

	public Bank() {
		super(Bank.class);
	}
	
	public static void main(String[] args) {
		new Bank();
	}
	
	@Override
	public void onLoad() {
		Database<BankAccount> database = new InMemoryDatabase();
		FrameFactory<BankAccount> frameFactory = new BankFrameFactory(database);
		frameFactory.getMainFrame(new BankTableConfigurer()).show();
	}

}
