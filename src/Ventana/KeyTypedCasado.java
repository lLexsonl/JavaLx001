package Ventana;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyTypedCasado implements KeyListener {
    protected JTextField text;
    protected int maxCharacters;

    public KeyTypedCasado(JTextField txt, int a)
    {
        text = txt;
        maxCharacters = a;
    }

    public void keyTyped(KeyEvent event) {

        Character a = event.getKeyChar();

        if (text.getText().length() >= maxCharacters) {
            event.consume();
            JOptionPane.showMessageDialog(null, String.format("No ingresar mas de %d caracteres%n%nNota: Solo se deben ingresar las palabras 'si' o 'no'", maxCharacters),"Ingreso Casado",JOptionPane.ERROR_MESSAGE);
        }
        else if(!Character.isLetter(a) && (int) a != 127 && (int) a != 8 && (int) a != 13)
        {
            event.consume();
            JOptionPane.showMessageDialog(null, "No debe ingresar valores numericos o caracteres especiales.","Ingreso Casado",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }
}
