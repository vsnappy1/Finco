package framework.model;

import javax.swing.*;
import java.awt.*;

public class LabelTextFieldUIComponent implements UIComponent {

    private final String label;
    private final JTextField textField;

    public LabelTextFieldUIComponent(String label) {
        this.label = label;
        this.textField = new JTextField();
        this.textField.setSize(250,10);
    }

    @Override
    public Component getUIComponent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JLabel label = new JLabel(this.label);
        label.setSize(48, 24);
        label.setForeground(java.awt.Color.black);

        panel.add(label);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(textField);
        return panel;
    }

    public String getText() {
        return textField.getText();
    }
}
