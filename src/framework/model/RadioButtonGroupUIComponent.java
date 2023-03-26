package framework.model;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RadioButtonGroupUIComponent implements UIComponent {

    private final List<RadioButton> list;

    public RadioButtonGroupUIComponent(List<RadioButton> list) {
        this.list = list;
        if(!list.isEmpty()){
            list.get(0).get().setSelected(true);
        }
    }

    @Override
    public Component getUIComponent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        ButtonGroup buttonGroup = new ButtonGroup();
        for(RadioButton radioButton: list){
            buttonGroup.add(radioButton.get());
            panel.add(radioButton.get());
        }
        return panel;
    }

    public String getSelected(){
        for(RadioButton radioButton: list){
            if(radioButton.get().isSelected()){
                return radioButton.get().getText();
            }
        }
        return "";
    }
}
