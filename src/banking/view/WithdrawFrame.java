package banking.view;

import banking.model.BankAccount;
import banking.model.WithdrawTransaction;
import framework.database.Database;
import framework.model.Frame;
import framework.util.Utils;

import javax.swing.JFrame;

public class WithdrawFrame implements Frame
{

    private final Database<BankAccount> database;
    private final JFrame jFrame;
    String accountNumber;

    public WithdrawFrame(Database<BankAccount> database,String accountNumber)
    {
        this.accountNumber = accountNumber;
        this.database = database;
        jFrame = getFrame();

    }

    private JFrame getFrame()
    {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Withdraw");
        jFrame.getContentPane().setLayout(null);
        jFrame.setSize(300,200);
        jFrame.setVisible(false);
        JLabel1.setText("Acc Nr");
        jFrame.getContentPane().add(JLabel1);
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(12,12,48,24);
        JLabel2.setText("Withdraw Amount");
        jFrame.getContentPane().add(JLabel2);
        JLabel2.setForeground(java.awt.Color.black);
        JLabel2.setBounds(12,48,48,24);
        JTextField_NAME.setEditable(false);
        JTextField_NAME.setText(accountNumber);
        jFrame.getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(84,12,144,24);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        jFrame.getContentPane().add(JButton_OK);
        JButton_OK.setBounds(36,84,84,24);
        JButton_Cancel.setText("Cancel");
        JButton_Cancel.setActionCommand("Cancel");
        jFrame.getContentPane().add(JButton_Cancel);
        JButton_Cancel.setBounds(156,84,84,24);
        jFrame.getContentPane().add(JTextField_Deposit);
        JTextField_Deposit.setBounds(84,48,144,24);
        //}}
//	    JTextField_NAME.setText(accnr);

        //{{REGISTER_LISTENERS
//        fincoFramework.view.DepositFrame.SymAction lSymAction = new fincoFramework.view.DepositFrame.SymAction();
        banking.view.WithdrawFrame.SymAction lSymAction = new banking.view.WithdrawFrame.SymAction();
        JButton_OK.addActionListener(lSymAction);
        JButton_Cancel.addActionListener(lSymAction);

        return jFrame;
    }

    //{{DECLARE_CONTROLS
    javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
    javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
    javax.swing.JButton JButton_OK = new javax.swing.JButton();
    javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
    javax.swing.JTextField JTextField_Deposit = new javax.swing.JTextField();
    //}}


    class SymAction implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            Object object = event.getSource();
            if (object == JButton_OK)
                onOkButtonPressed();
            else if (object == JButton_Cancel)
                onCancelButtonPressed();
        }
    }

    void onOkButtonPressed()
    {
        int amount = Integer.parseInt(JTextField_Deposit.getText());
        database.getAccount(accountNumber).addTransaction(new WithdrawTransaction("adidas",amount, Utils.getCurrentTime()));
        database.notify(database.getAccountList());
        dispose();
    }

    void onCancelButtonPressed()
    {
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
