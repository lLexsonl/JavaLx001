package Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoBtnCambiarL implements ActionListener {
    protected VentanaLectura ventana;

    EventoBtnCambiarL(VentanaLectura ventana){
        this.ventana = ventana;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        ventana.dispose();
        Ventana vl = new Ventana();
        vl.setVisible(true);
        JOptionPane.showMessageDialog(null, "Ventana de escritura", "Ventana", JOptionPane.INFORMATION_MESSAGE);
    }
}