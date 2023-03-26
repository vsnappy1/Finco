package framework.model;

import javax.swing.*;
import java.awt.*;

public class ButtonUIComponent implements UIComponent {
    private final JButton jButton;

    public ButtonUIComponent(String text, ActionListener actionListener) {
        jButton = new JButton(text);
        jButton.addActionListener(action -> actionListener.onAction());
    }


    @Override
    public Component getUIComponent() {
        return jButton;
    }
}
