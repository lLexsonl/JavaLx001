package Ventana;

import Objeto.Valida;
import Archivos.Fichero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoBotonPulsado implements ActionListener {
    Ventana vent;

    public EventoBotonPulsado(Ventana v)
    {
        vent = v;
    }
    public void actionPerformed(ActionEvent e)
    {
        if(!Valida.validarVacio(this.vent.txtNombre()) &&
                !Valida.validarVacio(this.vent.txtId()) &&
                !Valida.validarVacio(this.vent.txtClave()) &&
                !Valida.validarVacio(this.vent.txtTelefono()) &&
                !Valida.validarVacio(this.vent.txtGenero()) &&
                !Valida.validarVacio(this.vent.txtCasado())
        )
        {
            if(Valida.validarNombre(this.vent.txtNombre()) &&
                    Valida.validarTelefono(this.vent.txtTelefono()) &&
                    Valida.validarId(this.vent.txtId()) &&
                    Valida.validarGenero(this.vent.txtGenero()) &&
                    Valida.validarCasado(this.vent.txtCasado()) &&
                    Valida.validarClave(this.vent.txtClave()))
            {
                JOptionPane.showMessageDialog(null, "Datos Guardados", "Guardar", JOptionPane.INFORMATION_MESSAGE);
                Fichero.escribirArchObjeto(String.format("%s,%s,%s,%s,%s,%s",vent.txtId.getText(),vent.txtClave.getText(),vent.txtNombre.getText(),
                vent.txtTel.getText(),vent.txtGen.getText(),vent.txtCasado.getText()));

                vent.txtId.setText(null);
                vent.txtClave.setText(null);
                vent.txtCasado.setText(null);
                vent.txtNombre.setText(null);
                vent.txtTel.setText(null);
                vent.txtGen.setText(null);
            }
            else
                JOptionPane.showMessageDialog(null,"Datos NO Guardados","Guardar", JOptionPane.ERROR_MESSAGE);

        }
        else
            JOptionPane.showMessageDialog(null,"No se pueden guardar campos vacios","Guardar", JOptionPane.ERROR_MESSAGE);

    }
}
