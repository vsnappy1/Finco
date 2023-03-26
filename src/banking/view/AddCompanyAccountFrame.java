package banking.view;

import banking.model.BankAccount;
import banking.model.AccountType;
import banking.model.CompanyBankAccount;
import framework.database.Database;
import framework.model.*;
import framework.view.AddAccountFrame;

import java.util.List;

public class AddCompanyAccountFrame extends AddAccountFrame<BankAccount> {
    private final RadioButtonGroupUIComponent accountTypeRadioButtonGroupUIComponent;
    private final LabelTextFieldUIComponent noOfEmployeesLabelTextFieldUIComponent;
    private final LabelTextFieldUIComponent accountNumberLabelTextFieldUIComponent;
    public AddCompanyAccountFrame(Database<BankAccount> database, String title) {
        super(database, title, 450);
        accountTypeRadioButtonGroupUIComponent = new RadioButtonGroupUIComponent(List.of(new RadioButton("Savings"), new RadioButton("Checking")));
        accountNumberLabelTextFieldUIComponent = new LabelTextFieldUIComponent("Account #");
        noOfEmployeesLabelTextFieldUIComponent = new LabelTextFieldUIComponent("No of Employees");
        addComponentAtTop(accountNumberLabelTextFieldUIComponent.getUIComponent());
        addComponentAtTop(accountTypeRadioButtonGroupUIComponent.getUIComponent());
        addComponentAtBottom(noOfEmployeesLabelTextFieldUIComponent.getUIComponent());
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
        BankAccount account = new CompanyBankAccount(accountNumber, new DefaultCompany(name, street, city, state, zip, email, noOfEmployeesLabelTextFieldUIComponent.getText()), getAccountType());
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
