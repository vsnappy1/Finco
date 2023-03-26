package banking.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import banking.model.BankAccount;
import framework.database.Database;

public class InMemoryDatabase extends Database<BankAccount> {
    private final List<BankAccount> list;

    public InMemoryDatabase() {
        list = new ArrayList<>();
    }

    @Override
    public void addAccount(BankAccount account) {
        list.add(account);
        notify(list);
    }

    @Override
    public void removeAccount(BankAccount account) {
        list.remove(account);
        notify(list);
    }

    @Override
    public BankAccount getAccount(String accountNumber) {
        Optional<BankAccount> account = list.stream().filter(e -> e.getAccountNumber().equals(accountNumber)).findFirst();
        return account.orElse(null);
    }

    @Override
    public List<BankAccount> getAccountList() {
        return list;
    }
}
