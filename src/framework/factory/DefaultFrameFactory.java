package framework.factory;

import framework.database.Database;
import framework.model.Account;
import framework.model.Frame;
import framework.model.TableConfigurer;
import framework.view.AddAccountFrame;
import framework.view.DefaultMainFrame;
import framework.view.DepositFrame;
import framework.model.ButtonUIComponent;

public class DefaultFrameFactory<T extends Account> implements FrameFactory<T> {
    private final Database<T> database;

    public DefaultFrameFactory(Database<T> database) {
        this.database = database;
    }

    @Override
    public Frame getMainFrame(TableConfigurer<T> tableConfigurer) {
        DefaultMainFrame<T> dfm = new DefaultMainFrame<>(database, tableConfigurer, "Finco Application");
        dfm.setButton1(new ButtonUIComponent("Add Account", () -> getAddAccountFrame().show()));
        return dfm;
    }

    @Override
    public Frame getAddAccountFrame() {
        return new AddAccountFrame<>(database, "Add Account");
    }

    @Override
    public Frame getDepositFrame(String accountNumber) {
        return new DepositFrame<>(database, accountNumber);
    }
}
