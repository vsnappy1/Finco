package banking.view;

import banking.model.BankAccount;
import banking.model.AccountType;
import banking.model.PersonalBankAccount;
import framework.database.Database;
import framework.model.*;
import framework.view.AddAccountFrame;

import java.util.List;

public class AddPersonalAccountFrame extends AddAccountFrame<BankAccount> {

    private final RadioButtonGroupUIComponent accountTypeRadioButtonGroupUIComponent;
    private final LabelTextFieldUIComponent dateOfBirthLabelTextFieldUIComponent;
    private final LabelTextFieldUIComponent accountNumberLabelTextFieldUIComponent;
    public AddPersonalAccountFrame(Database<BankAccount> database, String title) {
        super(database, title, 500);
        accountTypeRadioButtonGroupUIComponent = new RadioButtonGroupUIComponent(List.of(new RadioButton("Savings"), new RadioButton("Checking")));
        accountNumberLabelTextFieldUIComponent = new LabelTextFieldUIComponent("Account #");
        dateOfBirthLabelTextFieldUIComponent = new LabelTextFieldUIComponent("Birthdate");
        addComponentAtTop(accountNumberLabelTextFieldUIComponent.getUIComponent());
        addComponentAtTop(accountTypeRadioButtonGroupUIComponent.getUIComponent());
        addComponentAtBottom(dateOfBirthLabelTextFieldUIComponent.getUIComponent());
    }

    @Override
    public void onOkButtonPressed() {
        String accountNumber = accountNumberLabelTextFieldUIComponent.getText();
        String name = getName();
        String street = getStreet();
        String city = getCity();
        String state = getState();
        String zip = getZip();
        String email = getEmail();
        BankAccount account = new PersonalBankAccount(accountNumber, new DefaultPerson(name, street, city, state, zip, email, dateOfBirthLabelTextFieldUIComponent.getText()), getAccountType());
        addAccount(account);
        dispose();
    }

    private AccountType getAccountType() {
        String chosenOption = accountTypeRadioButtonGroupUIComponent.getSelected();
        if(chosenOption.equals("Savings")){
            return AccountType.SAVING;
        }else  if(chosenOption.equals("Checking")){
            return AccountType.CHECKING;
        }
        return null;
    }
}
