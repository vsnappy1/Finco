package creditcard.database;

import creditcard.model.CreditCardAccount;
import framework.database.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryDatabase extends Database<CreditCardAccount> {
    private final List<CreditCardAccount> list;

    public InMemoryDatabase() {
        list = new ArrayList<>();
    }

    @Override
    public void addAccount(CreditCardAccount account) {
        list.add(account);
        notify(list);
    }

    @Override
    public void removeAccount(CreditCardAccount account) {
        list.remove(account);
        notify(list);
    }

    @Override
    public CreditCardAccount getAccount(String ccNumber) {
        Optional<CreditCardAccount> account = list.stream().filter(e -> e.getCcNumber().equals(ccNumber)).findFirst();
        return account.orElse(null);
    }

    @Override
    public List<CreditCardAccount> getAccountList() {
        return list;
    }
}
