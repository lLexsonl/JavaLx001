package Ventana;

import Archivos.Fichero;
import Objeto.Objeto;
import Objeto.Valida;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoLeerArchivo implements ActionListener {
    VentanaLectura ventanaLectura;

    public EventoLeerArchivo(VentanaLectura ventanaLectura)
    {
        this.ventanaLectura = ventanaLectura;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!ventanaLectura.txtBuscar.getText().equals("") && Valida.validarId(ventanaLectura.txtBuscar.getText()))
        {
            Objeto obj = Fichero.buscarObjeto(ventanaLectura.txtBuscar.getText());
            if(obj != null)
            {
                ventanaLectura.txtId.setText(obj.getId());
                ventanaLectura.txtClave.setText(obj.getClave().toString());
                ventanaLectura.txtNombre.setText(obj.getNombre());
                ventanaLectura.txtTel.setText(obj.getTelefono().toString());
                ventanaLectura.txtGen.setText(obj.getGenero().toString());
                ventanaLectura.txtCasado.setText(obj.getCasado().toString());
            }
            else
                JOptionPane.showMessageDialog(null, "Objeto NO encontrado", "Buscar Objeto",JOptionPane.ERROR_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Informacion Incorrecta", "Buscar Objeto",JOptionPane.ERROR_MESSAGE);
    }
}
