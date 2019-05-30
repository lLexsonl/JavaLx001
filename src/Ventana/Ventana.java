package Ventana;

import Iconos.BotonCambiar;
import Iconos.BotonCancelar;
import Iconos.BotonIcon;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    /**
     * Datos
     */
    protected JLabel lblId;
    protected JTextField txtId;
    protected JLabel lblClave;
    protected JTextField txtClave;
    protected JLabel lblNombre;
    protected JTextField txtNombre;
    protected JLabel lblTel;
    protected JTextField txtTel;
    protected JLabel lblGen;
    protected JTextField txtGen;
    protected JLabel lblCasado;
    protected JTextField txtCasado;
    private JPanel panelDatos;
    private GridLayout grid1 = new GridLayout(6, 2, 0, 5);

    /**
     * Botones
     */
    private JPanel panelBotones;
    private FlowLayout flBotones;
    protected JButton botonGuardar;
    protected JButton botonCancelar;
    protected JButton botonCambiarLectura;

    public Ventana() {
        super();
        configurarVentana();
        inicializarComponentes();
        inicializarBotones();
        /**
         * Container
         */
        Container cp = getContentPane();
        cp.add(panelDatos, BorderLayout.CENTER);
        cp.add(panelBotones, BorderLayout.SOUTH);

    }

    private void configurarVentana() {

        this.setTitle("Archivos y Objetos");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        /**
         * Datos Jpanel
         */
        panelDatos = new JPanel();
        grid1 = new GridLayout(6, 2, 0, 5);
        panelDatos.setLayout(grid1);

        //cp.setLayout(new FlowLayout());
        lblId = new JLabel("Identificacion: ");
        txtId = new JTextField(10);
        txtId.addKeyListener(new EventoKeyTyped(this.txtId,10));
        lblClave = new JLabel("Clave: ");
        txtClave = new JTextField(10);
        txtClave.addKeyListener(new KeyTypedClave(this.txtClave,4));
        lblNombre = new JLabel("Nombre: ");
        txtNombre = new JTextField(15);
        txtNombre.addKeyListener(new KeyTypedNombre(this.txtNombre,15));
        lblTel = new JLabel("Telefono: ");
        txtTel = new JTextField(10);
        txtTel.addKeyListener(new EventoKeyTyped(this.txtTel, 10));
        lblGen = new JLabel("Genero: ");
        txtGen = new JTextField(10);
        txtGen.addKeyListener(new KeyTypedGenero(this.txtGen,1));
        lblCasado = new JLabel("Casado: ");
        txtCasado = new JTextField(10);
        txtCasado.addKeyListener(new KeyTypedCasado(this.txtCasado,2));

        panelDatos.add(lblId);
        panelDatos.add(txtId);
        panelDatos.add(lblClave);
        panelDatos.add(txtClave);
        panelDatos.add(lblNombre);
        panelDatos.add(txtNombre);
        panelDatos.add(lblTel);
        panelDatos.add(txtTel);
        panelDatos.add(lblGen);
        panelDatos.add(txtGen);
        panelDatos.add(lblCasado);
        panelDatos.add(txtCasado);
    }

    private void inicializarBotones()
    {
        panelBotones = new JPanel();
        flBotones = new FlowLayout();
        panelBotones.setLayout(flBotones);
        botonGuardar = new JButton("Guardar", new BotonIcon());
        botonGuardar.addActionListener(new EventoBotonPulsado(this));
        panelBotones.add(botonGuardar);
        botonCambiarLectura = new JButton("Cambiar", new BotonCambiar());
        botonCambiarLectura.addActionListener(new EventoBotonCambiar(/*new VentanaLectura(),*/this));
        panelBotones.add(botonCambiarLectura);
        botonCancelar = new JButton("Cancelar", new BotonCancelar());
        botonCancelar.addActionListener(new EventoSalida(this));
        panelBotones.add(botonCancelar);
    }
    public String txtNombre()
    {
        return txtNombre.getText();
    }
    public String txtId()
    {
        return txtId.getText();
    }
    public String txtClave()
    {
        return txtClave.getText();
    }
    public String txtTelefono()
    {
        return txtTel.getText();
    }
    public String txtGenero()
    {
        return txtGen.getText();
    }
    public String txtCasado()
    {
        return txtCasado.getText();
    }
}
