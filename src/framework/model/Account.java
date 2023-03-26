package framework.model;

public interface Account {
	int getBalance();
	void addTransaction(Transaction transaction);
	Customer getCustomer() ;
}
