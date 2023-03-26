package framework.model;

import javax.swing.*;

public class RadioButton {
    private final JRadioButton radioButton;

    public RadioButton(String text) {
        radioButton = new JRadioButton(text);
    }

    public JRadioButton get(){
        return radioButton;
    }
}
