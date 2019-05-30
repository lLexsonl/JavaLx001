package Ventana;

import Iconos.BotonCambiar;
import Iconos.BotonCancelar;
import Iconos.BotonLeer;

import javax.swing.*;
import java.awt.*;

public class VentanaLectura extends JFrame {
    /**
     * Datos
     */
    protected JLabel lblId;
    protected JLabel txtId;
    protected JLabel lblClave;
    protected JLabel txtClave;
    protected JLabel lblNombre;
    protected JLabel txtNombre;
    protected JLabel lblTel;
    protected JLabel txtTel;
    protected JLabel lblGen;
    protected JLabel txtGen;
    protected JLabel lblCasado;
    protected JLabel txtCasado;
    private JPanel panelDatos;
    private GridLayout grid1 = new GridLayout(6, 2, 0, 5);

    //Boton cambiar
    private JPanel panelCambiar;
    private FlowLayout flCambiar;
    /**
     * Botones
     */
    private JPanel panelBotones;
    private FlowLayout flBotones;
    protected JButton botonLeer;
    protected JTextField txtBuscar;
    protected JButton botonCambiar1;
    protected JButton botonCancelar;

    public VentanaLectura()
    {
        super();
        configurarVentanta();
        inicializarComponentes();
        inicializarBotones();
        /**
         * Container
         */
        Container cp = getContentPane();
        cp.add(panelCambiar, BorderLayout.NORTH);
        cp.add(panelDatos, BorderLayout.CENTER);
        cp.add(panelBotones, BorderLayout.SOUTH);
    }
    private void configurarVentanta()
    {
        this.setTitle("Archivos");
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
        txtId = new JLabel();
        lblClave = new JLabel("Clave: ");
        txtClave = new JLabel();
        lblNombre = new JLabel("Nombre: ");
        txtNombre = new JLabel();
        lblTel = new JLabel("Telefono: ");
        txtTel = new JLabel();
        lblGen = new JLabel("Genero: ");
        txtGen = new JLabel();
        lblCasado = new JLabel("Casado: ");
        txtCasado = new JLabel();

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
        botonLeer = new JButton("Buscar", new BotonLeer());
        botonLeer.addActionListener(new EventoLeerArchivo(this));
        panelBotones.add(botonLeer);
        txtBuscar = new JTextField(10);
        txtBuscar.addKeyListener(new EventoKeyTyped(this.txtBuscar,10));
        panelBotones.add(txtBuscar);
        panelCambiar = new JPanel();
        flCambiar = new FlowLayout();
        botonCambiar1 = new JButton("Cambiar", new BotonCambiar());
        botonCambiar1.addActionListener(new EventoBtnCambiarL(this));
        panelCambiar.add(botonCambiar1);
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
