package banking.factory;

import banking.view.*;
import banking.model.BankAccount;
import framework.database.Database;
import framework.factory.DefaultFrameFactory;
import framework.model.Frame;
import framework.model.TableConfigurer;
import framework.model.ButtonUIComponent;

public class BankFrameFactory extends DefaultFrameFactory<BankAccount> {
    private final Database<BankAccount> database;

    public BankFrameFactory(Database<BankAccount> database) {
        super(database);
        this.database = database;
    }

    @Override
    public Frame getMainFrame(TableConfigurer<BankAccount> tableConfigurer) {
        BankFrame bankFrame = new BankFrame(database, tableConfigurer);
        bankFrame.setButton1(new ButtonUIComponent("Add Personal Account",
                () -> getAddPersonalAccountFrame().show()));
        bankFrame.setButton2(new ButtonUIComponent("Add Company Account",
                () -> getAddCompanyAccountFrame().show()));
        bankFrame.setButton3(new ButtonUIComponent("Add interest",
                () -> {
                    getAddInterestFrame().show();
                }));
        bankFrame.setButton4(new ButtonUIComponent("Withdraw",
                () -> {
                    if (bankFrame.getSelectedAccountNumber().isEmpty()) return;
                    getWithdrawFrame(bankFrame.getSelectedAccountNumber()).show();
                }));
        return bankFrame;
    }

    private Frame getAddInterestFrame() {
        return new AddInterestFrame(database);
    }

    // Creating a personal account frame to inject in the UI
    public Frame getAddPersonalAccountFrame() {
        return new AddPersonalAccountFrame(database, "Add Personal Account");
    }

    public Frame getAddCompanyAccountFrame() {
        return new AddCompanyAccountFrame(database, "Add Company Account");
    }

    public Frame getWithdrawFrame(String accountNumber) {
        return new WithdrawFrame(database, accountNumber);
    }

}
