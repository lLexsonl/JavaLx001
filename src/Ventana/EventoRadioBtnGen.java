package Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoRadioBtnGen implements ActionListener {
    private JRadioButton radioBtn;
    private JRadioButton radioBtn2;
    EventoRadioBtnGen(JRadioButton radioBtn, JRadioButton radioBtn2) {
        this.radioBtn = radioBtn;
        this.radioBtn2 = radioBtn2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        radioBtn.setActionCommand(radioBtn.getText());
        radioBtn2.setActionCommand("");
    }
}
