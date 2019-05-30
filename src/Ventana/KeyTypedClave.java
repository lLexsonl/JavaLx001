package Ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyTypedClave implements KeyListener {
    protected JTextField text;
    protected int maxCharacters;

    public KeyTypedClave(JTextField txt, int a)
    {
        text = txt;
        maxCharacters = a;
    }

    public void keyTyped(KeyEvent event) {

        Character a = event.getKeyChar();

        if (text.getText().length() >= maxCharacters) {
            event.consume();
            JOptionPane.showMessageDialog(null, String.format("No ingresar mas de %d caracteres.", maxCharacters),"Ingreso Clave",JOptionPane.WARNING_MESSAGE);
        }else if(!Character.isLetter(a)  && !a.toString().matches("[0-9]") && (int) a != 127 && (int) a != 8 && (int) a != 13)
        {
            event.consume();
            JOptionPane.showMessageDialog(null, "No debe ingresar valores numericos o caracteres especiales.","Ingreso Clave", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }
}
