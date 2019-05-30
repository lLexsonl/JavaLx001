package Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoBotonCambiar implements ActionListener {
    ///protected JFrame ventanaL;
    protected Ventana ventana;

    EventoBotonCambiar(/*JFrame ventanaL, */Ventana ventana){
        /*this.ventanaL = ventanaL;*/
        this.ventana = ventana;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        ventana.dispose();
        VentanaLectura vl = new VentanaLectura();
        vl.setVisible(true);
        JOptionPane.showMessageDialog(null, "Ventana de lectura", "Ventana Lectura", JOptionPane.INFORMATION_MESSAGE);
    }
}
