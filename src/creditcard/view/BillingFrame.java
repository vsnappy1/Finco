package creditcard.view;


import creditcard.model.CreditCardAccount;
import framework.database.Database;
import framework.model.Frame;
import framework.model.Transaction;

import javax.swing.*;
import java.util.Calendar;

public class BillingFrame implements Frame {
    private final StringBuilder stringBuilder;
    private final JFrame jFrame;
    private final Database<CreditCardAccount> database;

    public BillingFrame(Database<CreditCardAccount> database) {
        this.database = database;
        stringBuilder = new StringBuilder();
        jFrame = getFrame();
    }

    private JFrame getFrame() {
        JFrame jFrame = new JFrame();
        JScrollPane JScrollPane1 = new JScrollPane();
        JTextArea JTextField1 = new JTextArea();
        JButton JButton_OK = new JButton();
        jFrame.getContentPane().setLayout(null);
        jFrame.setSize(405, 367);
        jFrame.setVisible(false);
        jFrame.getContentPane().add(JScrollPane1);
        JScrollPane1.setBounds(24, 24, 358, 240);
        JScrollPane1.getViewport().add(JTextField1);
        JTextField1.setBounds(0, 0, 355, 237);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        jFrame.getContentPane().add(JButton_OK);
        JButton_OK.setBounds(156, 276, 96, 24);

        // generate the string for the monthly bill
        for (CreditCardAccount creditCardAccount : database.getAccountList()) {
            stringBuilder.append(getAccountDetails(creditCardAccount));
        }
        JTextField1.setText(stringBuilder.toString());
        JButton_OK.addActionListener((e) -> dispose());
        return jFrame;
    }

    private String getAccountDetails(CreditCardAccount creditCardAccount) {

        return "Name: " +
                creditCardAccount.getCustomer().getName() +
                "\n" +
                "Email: " +
                creditCardAccount.getCustomer().getEmail() +
                "\n" +
                "Address: " +
                creditCardAccount.getCustomer().getStreet() +
                ", " +
                creditCardAccount.getCustomer().getCity() +
                ", " +
                creditCardAccount.getCustomer().getState() +
                ", " +
                creditCardAccount.getCustomer().getZip() +
                "\n" +
                "Credit Card #: " +
                creditCardAccount.getCcNumber() +
                "\n" +
                "Credit Card Type: " +
                creditCardAccount.getAccountType().toString() +
                "\n" +
                "Previous Balance: " +
                getPreviousBalance() +
                "\n" +
                "Total Credits: " +
                getTotalCredits(creditCardAccount) +
                "\n" +
                "Total Charges: " +
                getTotalCharges(creditCardAccount) +
                "\n" +
                "New Balance: " +
                getNewBalance(creditCardAccount) +
                "\n" +
                "Total Amount Due: " +
                getTotalDue(creditCardAccount) +
                "\n" +
                "\n";
    }

    private double getTotalDue(CreditCardAccount creditCardAccount) {
        return creditCardAccount.getMonthlyPayment() * getNewBalance(creditCardAccount);
    }

    private double getNewBalance(CreditCardAccount creditCardAccount) {
        return getPreviousBalance() - getTotalCredits(creditCardAccount) + getTotalCharges(creditCardAccount) +
                creditCardAccount.getMonthlyInterest() * (getPreviousBalance() - getTotalCredits(creditCardAccount));
    }

    private double getTotalCharges(CreditCardAccount creditCardAccount) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return creditCardAccount.getTransactions()
                .stream()
                .filter(t -> t.getDate().after(calendar))
                .filter(t -> t.getAmount() < 0)
                .mapToInt(Transaction::getAmount)
                .reduce(0, Integer::sum);
    }

    private double getTotalCredits(CreditCardAccount creditCardAccount) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return creditCardAccount.getTransactions()
                .stream()
                .filter(t -> t.getDate().after(calendar))
                .filter(t -> t.getAmount() > 0)
                .mapToInt(Transaction::getAmount)
                .reduce(0, Integer::sum);
    }

    private double getPreviousBalance() {
        return 0;
    }

    @Override
    public void show() {
        jFrame.setVisible(true);
    }

    @Override
    public void dispose() {
        jFrame.dispose();
    }
}
