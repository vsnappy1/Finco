package banking.view;

import banking.model.BankAccount;
import banking.model.InterestTransaction;
import framework.database.Database;
import framework.model.Account;
import framework.model.Frame;
import framework.util.Utils;

import javax.swing.*;

public class AddInterestFrame implements Frame {

    private final Database<BankAccount> database;
    private final JFrame jFrame;

    public AddInterestFrame(Database<BankAccount> database) {
        this.database = database;
        jFrame = getFrame();

    }

    private JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Add Interest");
        jFrame.getContentPane().setLayout(null);
        jFrame.setSize(300, 200);
        jFrame.setVisible(false);
        JLabel2.setText("Interest %");
        jFrame.getContentPane().add(JLabel2);
        JLabel2.setForeground(java.awt.Color.black);
        JLabel2.setBounds(12, 48, 60, 24);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        jFrame.getContentPane().add(JButton_OK);
        JButton_OK.setBounds(36, 84, 84, 24);
        JButton_Cancel.setText("Cancel");
        JButton_Cancel.setActionCommand("Cancel");
        jFrame.getContentPane().add(JButton_Cancel);
        JButton_Cancel.setBounds(156, 84, 84, 24);
        jFrame.getContentPane().add(textField);
        textField.setBounds(84, 48, 144, 24);
        //}}
//	    JTextField_NAME.setText(accnr);

        //{{REGISTER_LISTENERS
//        fincoFramework.view.DepositFrame.SymAction lSymAction = new fincoFramework.view.DepositFrame.SymAction();
        AddInterestFrame.SymAction lSymAction = new AddInterestFrame.SymAction();
        JButton_OK.addActionListener(lSymAction);
        JButton_Cancel.addActionListener(lSymAction);

        return jFrame;
    }

    //{{DECLARE_CONTROLS

    javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
    javax.swing.JButton JButton_OK = new javax.swing.JButton();
    javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
    javax.swing.JTextField textField = new javax.swing.JTextField();
    //}}


    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_OK)
                onOkButtonPressed();
            else if (object == JButton_Cancel)
                onCancelButtonPressed();
        }
    }

    private int getInterestRate() {
        return Integer.parseInt(textField.getText());
    }

    void onOkButtonPressed() {
        for (Account account : database.getAccountList()) {
            int currentBalance = account.getBalance();
            int interest = (int) ((double) currentBalance * (double) getInterestRate() / (double) 100);
            account.addTransaction(new InterestTransaction("Interest", interest, Utils.getCurrentTime()));
        }
        database.notify(database.getAccountList());
        dispose();
    }

    void onCancelButtonPressed() {
        dispose();
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
