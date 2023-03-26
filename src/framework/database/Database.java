package framework.database;

import framework.model.Subject;
import framework.model.Account;

import java.util.List;

public abstract class Database<T extends Account> extends Subject<List<T>> {
	public abstract void addAccount(T account);
	public abstract void removeAccount(T account);
	public abstract T getAccount(String accountNumber);
	public abstract List<T> getAccountList();


}
