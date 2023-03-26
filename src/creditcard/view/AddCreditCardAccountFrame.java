package creditcard.view;


import creditcard.model.*;
import framework.database.Database;
import framework.model.*;
import framework.view.AddAccountFrame;

import java.util.List;

public class AddCreditCardAccountFrame extends AddAccountFrame<CreditCardAccount> {

    private final RadioButtonGroupUIComponent accountTypeRadioButtonGroupUIComponent;
    private final LabelTextFieldUIComponent expiryDateLabelTextFieldUIComponent;
    private final LabelTextFieldUIComponent accountNumberLabelTextFieldUIComponent;

    public AddCreditCardAccountFrame(Database<CreditCardAccount> database, String title) {
        super(database, title, 550);
        accountTypeRadioButtonGroupUIComponent = new RadioButtonGroupUIComponent(List.of(new RadioButton("Golden"),  new RadioButton("Silver"), new RadioButton("Copper")));
        accountNumberLabelTextFieldUIComponent = new LabelTextFieldUIComponent("CC Number");
        expiryDateLabelTextFieldUIComponent = new LabelTextFieldUIComponent("Expiry Date");
        addComponentAtTop(accountTypeRadioButtonGroupUIComponent.getUIComponent());
        addComponentAtBottom(accountNumberLabelTextFieldUIComponent.getUIComponent());
        addComponentAtBottom(expiryDateLabelTextFieldUIComponent.getUIComponent());
    }

    @Override
    public void onOkButtonPressed() {
        CreditCardAccount account = getAccount();
        addAccount(account);
        dispose();
    }

    private CreditCardAccount getAccount() {
        Customer customer = new DefaultCustomer(getName(), getStreet(), getCity(), getState(), getZip(), getEmail());
        String ccNumber = accountNumberLabelTextFieldUIComponent.getText();
        String expDate = expiryDateLabelTextFieldUIComponent.getText();

        String chosenOption = accountTypeRadioButtonGroupUIComponent.getSelected();
        if (chosenOption.equals("Golden")) {
            return new GoldenCreditCardAccount(customer, ccNumber, expDate);
        } else if (chosenOption.equals("Silver")) {
            return new SilverCreditCardAccount(customer, ccNumber, expDate);
        } else {
            return new CopperCreditCardAccount(customer, ccNumber, expDate);
        }
    }
}
