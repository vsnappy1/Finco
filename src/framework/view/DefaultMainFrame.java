package framework.view;

import framework.model.Frame;
import framework.factory.FrameFactory;
import framework.model.Observer;
import framework.model.TableConfigurer;
import framework.database.Database;
import framework.model.Account;
import framework.factory.DefaultFrameFactory;
import framework.model.ButtonUIComponent;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DefaultMainFrame<T extends Account> implements Frame, Observer<List<T>> {

    private JFrame jFrame;
    private final TableConfigurer<T> tableConfigurer;
    private final DefaultTableModel model;
    private FrameFactory<T> frameFactory;
    private String frameTitle = "Finco Application";
    private ButtonUIComponent button1;
    private ButtonUIComponent button2;
    private ButtonUIComponent button3;
    private ButtonUIComponent button4;
    private JTable JTable1;
    private ActionListener exitButtonActionListener;
    private ActionListener depositButtonActionListener;

    public DefaultMainFrame(Database<T> database, TableConfigurer<T> tableConfigurer, String frameTitle) {
        this.tableConfigurer = tableConfigurer;
        this.model = tableConfigurer.getModel();
        this.frameFactory = new DefaultFrameFactory<>(database);
        this.frameTitle = frameTitle;
        setupExitButtonActionListener();
        setupDepositButtonActionListener();
        database.attach(this);
        initFrame(frameTitle);
    }

    private void setupExitButtonActionListener() {
        this.exitButtonActionListener = e -> System.exit(0);
    }

    private void setupDepositButtonActionListener() {
        this.depositButtonActionListener = e -> {
            if(getChosenAccountNumber().isEmpty()) return;
            openDepositFrame();
        };
    }

    private void openDepositFrame() {
        frameFactory.getDepositFrame(getChosenAccountNumber()).show();
    }

    JButton JButton_Deposit = new JButton();
    JButton JButton_Exit = new JButton();

    private void initFrame(String title) {
        jFrame = new JFrame();
        JButton_Exit.removeActionListener(exitButtonActionListener);
        JButton_Deposit.removeActionListener(depositButtonActionListener);
        JButton_Exit.addActionListener(exitButtonActionListener);
        JButton_Deposit.addActionListener(depositButtonActionListener);
        JPanel JPanel1 = new JPanel();
        jFrame.setTitle(title);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.getContentPane().setLayout(new BorderLayout(0, 0));
        int width = 600;
        int height = 325;
        jFrame.setSize(width, height);
        jFrame.setVisible(false);
        JPanel1.setLayout(null);
        jFrame.getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0, 0, width, height);
		/*
		/Add five buttons on the pane 
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane JScrollPane1;
        JScrollPane1 = new JScrollPane();
        JTable1 = new JTable(model);
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12, 92, 444, 160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);

        if (button1 != null) {
            JPanel1.add(button1.getUIComponent());
            button1.getUIComponent().setBounds(24, 20, 192, 33);
        }

        if (button2 != null) {
            JPanel1.add(button2.getUIComponent());
            button2.getUIComponent().setBounds(240, 20, 190, 34);
        }

        if (button3 != null) {
            JPanel1.add(button3.getUIComponent());
            button3.getUIComponent().setBounds(448, 20, 106, 33);
        }
        if (button4 != null) {
            JPanel1.add(button4.getUIComponent());
            button4.getUIComponent().setBounds(468, 164, 96, 33);
        }
        JButton_Deposit.setText("Deposit");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468, 104, 96, 33);

        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468, 248, 96, 31);
    }

    public String getChosenAccountNumber() {
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            return (String) model.getValueAt(selection, 0);
        }
        return "";
    }

    private void reloadFrame() {
        initFrame(frameTitle);
    }

    @Override
    public void show() {
        jFrame.setVisible(true);
    }

    @Override
    public void dispose() {
        jFrame.dispose();
    }

    @Override
    public void update(List<T> value) {
        while (model.getRowCount() != 0) {
            model.removeRow(0);
        }
        value.forEach(account -> model.addRow(tableConfigurer.mapToRow(account)));
    }

    public void setButton1(ButtonUIComponent button1) {
        this.button1 = button1;
        reloadFrame();
    }

    public void setButton2(ButtonUIComponent button2) {
        this.button2 = button2;
        reloadFrame();
    }

    public void setButton3(ButtonUIComponent button3) {
        this.button3 = button3;
        reloadFrame();
    }

    public void setButton4(ButtonUIComponent button4) {
        this.button4 = button4;
        reloadFrame();
    }
}
