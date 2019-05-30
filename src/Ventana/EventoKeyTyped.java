package Ventana;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventoKeyTyped implements KeyListener {
    JTextField text;
    protected int maxCharacters;

    EventoKeyTyped(JTextField _text, int _max) {
        text = _text;
        maxCharacters = _max;
    }

    public void keyTyped(KeyEvent event) {
        Character a = event.getKeyChar();

        if (text.getText().length() >= maxCharacters) {
            event.consume();
            JOptionPane.showMessageDialog(null, String.format("No ingresar mas de %d caracteres.", maxCharacters),"Ingreso Denegado",JOptionPane.ERROR_MESSAGE);
        }else if(!a.toString().matches("[0-9]") && (int) a != 127 && (int) a != 8 && (int) a != 13)
        {
            event.consume();
            JOptionPane.showMessageDialog(null, "No ingresar caracteres diferentes a numeros.","Ingreso Dengado",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }
}
