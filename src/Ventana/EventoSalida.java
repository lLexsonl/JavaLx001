package Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoSalida implements ActionListener {
    JFrame ventana;
    public EventoSalida(JFrame ventana){
        this.ventana = ventana;
    }
    public void actionPerformed(ActionEvent e)
    {
        ventana.setVisible(false);
        ventana.dispose();
    }
}
