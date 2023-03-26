package framework.database;

import framework.model.DefaultAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DefaultDatabase extends Database<DefaultAccount> {

    private final List<DefaultAccount> list;

    public DefaultDatabase() {
        list = new ArrayList<>();
    }

    @Override
    public void addAccount(DefaultAccount account) {
        list.add(account);
        notify(list);
    }

    @Override
    public void removeAccount(DefaultAccount account) {
        list.remove(account);
        notify(list);
    }

    @Override
    public DefaultAccount getAccount(String name) {
        Optional<DefaultAccount> account = list.stream().filter(e -> e.getCustomer().getName().equals(name)).findFirst();
        return account.orElse(null);
    }

    @Override
    public List<DefaultAccount> getAccountList() {
        return list;
    }

}
