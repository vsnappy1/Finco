package creditcard.factory;

import creditcard.model.CreditCardAccount;
import creditcard.view.AddCreditCardAccountFrame;
import creditcard.view.BillingFrame;
import creditcard.view.ChargeFrame;
import creditcard.view.CreditCardFrame;
import framework.database.Database;
import framework.factory.DefaultFrameFactory;
import framework.model.ButtonUIComponent;
import framework.model.Frame;
import framework.model.TableConfigurer;

public class CreditCardFrameFactory extends DefaultFrameFactory<CreditCardAccount> {
    private final Database<CreditCardAccount> database;

    public CreditCardFrameFactory(Database<CreditCardAccount> database) {
        super(database);
        this.database = database;
    }

    @Override
    public Frame getMainFrame(TableConfigurer<CreditCardAccount> tableConfigurer) {
        CreditCardFrame ccFrame = new CreditCardFrame(database, tableConfigurer);
        ccFrame.setButton1(new ButtonUIComponent("Add Credit Card Account", () -> getAddCreditCardAccountFrame().show()));
        ccFrame.setButton2(new ButtonUIComponent("Generate Monthly Bills", () -> getBillingFrame(database).show()));
        ccFrame.setButton4(new ButtonUIComponent("Charge",
                () -> {
                    if (ccFrame.getSelectedAccountNumber().isEmpty()) return;
                    getChargeFrame(ccFrame.getSelectedAccountNumber()).show();
                }));
        return ccFrame;
    }

    // Creating a personal account frame to inject in the UI
    public Frame getAddCreditCardAccountFrame() {
        return new AddCreditCardAccountFrame(database, "Add Credit Card Account");
    }

    public Frame getChargeFrame(String ccNumber) {
        return new ChargeFrame(database, ccNumber);
    }

    public Frame getBillingFrame(Database<CreditCardAccount> database) {
        return new BillingFrame(database);
    }
}
