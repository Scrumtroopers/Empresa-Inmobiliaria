package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import Datos.BD;
import Datos.Producto;
import jdk.nashorn.internal.scripts.JO;

public class VentanaPedidosUsuario extends JFrame{

	public static VentanaPedidosUsuario ventana;

	private JPanel contentPane;
	private JTable tablPrdctsXPdir;
	private JTable tablPrdctsSelect;
	private JLabel titulo;
	private JTextField espEscri;
	private JLabel usuario;
	private JLabel nombUser;
	private JLabel pagar;		
	private JLabel costoTotal;		
	private JButton botonBuscar;
	private JButton botonAnadir;
	private JButton botonQuitar;
	private JButton botonNUsuario;
	private JButton botonCerrarSecion;
	private JButton botonRealizarPedido;
	private JButton botonCancelarPedido;

	private ArrayList<Producto> productosSeleccionados;

	public VentanaPedidosUsuario(/*Object[][] datos1, String[]nombreColumnas1,Object[][] datos2, String[]nombreColumnas2*/){
		this.productosSeleccionados = new ArrayList<Producto>();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 75, 720, 580);
		contentPane= new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		usuario = new JLabel("Usuario :");
		usuario.setHorizontalAlignment(SwingConstants.LEFT);
		usuario.setFont(new Font("Century Gothic", Font.ITALIC, 12));
		usuario.setBounds(5, 5, 100, 25);
		contentPane.add(usuario);

		botonCerrarSecion = new JButton("Cerrar Secion");
		botonCerrarSecion.setHorizontalAlignment(SwingConstants.RIGHT);
		botonCerrarSecion.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		botonCerrarSecion.setBounds(590, 5, 120, 19);
		botonCerrarSecion.setBackground(new Color(245, 245, 245));
		botonCerrarSecion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CerrarSecion();
			}
		});
		contentPane.add(botonCerrarSecion);

		nombUser = new JLabel(BD.bd.usuarioLogeado.getNombre()+" "+BD.bd.usuarioLogeado.getApellidoPaterno());
		nombUser.setHorizontalAlignment(SwingConstants.LEFT);
		nombUser.setFont(new Font("Century Gothic", Font.ITALIC, 12));
		nombUser.setBounds(55, 5, 135, 25);
		contentPane.add(nombUser);

		titulo = new JLabel("Nuevo Pedido");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Century Gothic", Font.BOLD, 18));
		titulo.setBounds(250, 30, 180, 30);
		contentPane.add(titulo);

		espEscri = new JTextField();
		espEscri.setHorizontalAlignment(SwingConstants.LEFT);
		espEscri.setBounds(20, 75, 203, 20);
		contentPane.add(espEscri);

		botonBuscar = new JButton("Buscar");
		botonBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		botonBuscar.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		botonBuscar.setBounds(221, 75, 78, 19);
		botonBuscar.setBackground(new Color(245, 245, 245));
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarProducto();
			}
		});
		contentPane.add(botonBuscar);

		tablPrdctsXPdir = new JTable();
		tablPrdctsXPdir.setFont(new Font("Century Gothic", Font.PLAIN,13));
		tablPrdctsXPdir.setBorder(new BevelBorder(BevelBorder.LOWERED,null,null,null,null));
		ModeloTabla modelTabla1= new ModeloTabla(BD.bd.getProducto());
		tablPrdctsXPdir.setModel(modelTabla1);
		tablPrdctsXPdir.setBounds(40, 102, 184, 311);
		JScrollPane scrollPaneParaTablPrdctsXPdir =  new JScrollPane(tablPrdctsXPdir);
		scrollPaneParaTablPrdctsXPdir.setBounds(20, 102, 324, 235);
		contentPane.add(scrollPaneParaTablPrdctsXPdir);

		tablPrdctsSelect = new JTable();
		tablPrdctsSelect.setFont(new Font("Century Gothic", Font.PLAIN,13));
		tablPrdctsSelect.setBorder(new BevelBorder(BevelBorder.LOWERED,null,null,null,null));
		ModeloTabla modelTabla2= new ModeloTabla(productosSeleccionados);
		tablPrdctsSelect.setModel(modelTabla2);
		tablPrdctsSelect.setBounds(374, 102, 184, 311);
		JScrollPane scrollPaneParaTablPrdctsSelect =  new JScrollPane(tablPrdctsSelect);
		scrollPaneParaTablPrdctsSelect.setBounds(374, 102, 324, 235);
		contentPane.add(scrollPaneParaTablPrdctsSelect);

		botonAnadir = new JButton();
		//botonAnadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Pedidos/aceptar.png")));
		botonAnadir.setBounds(20, 350, 50, 30);
		botonAnadir.setBackground(new Color(245, 245, 245));
		botonAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirProducto();

			}
		});
		contentPane.add(botonAnadir);

		botonQuitar = new JButton();
		//botonQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Pedidos/quitar.png")));
		botonQuitar.setBounds(100, 350, 50, 30);
		botonQuitar.setBackground(new Color(245, 245, 245));
		botonQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirProducto();

			}
		});
		contentPane.add(botonQuitar);

		botonNUsuario = new JButton();
		//botonNUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Pedidos/newUser.png")));
		botonNUsuario.setBounds(180, 350, 50, 30);
		botonNUsuario.setBackground(new Color(245, 245, 245));
		botonNUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoUsuario();

			}
		});
		contentPane.add(botonNUsuario);

		pagar = new JLabel("Pagar:");
		pagar.setHorizontalAlignment(SwingConstants.LEFT);
		pagar.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		pagar.setBounds(265, 400, 135, 30);
		contentPane.add(pagar);

		costoTotal = new JLabel("$$$$$$$$");
		costoTotal.setHorizontalAlignment(SwingConstants.LEFT);
		costoTotal.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		costoTotal.setBounds(335, 400, 135, 30);
		contentPane.add(costoTotal);

		botonRealizarPedido = new JButton("Realizar Pedido");
		botonRealizarPedido.setBounds(150, 450, 150, 30);
		botonRealizarPedido.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		botonRealizarPedido.setBackground(new Color(245, 245, 245));
		botonRealizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RealizarPedido();

			}
		});
		contentPane.add(botonRealizarPedido);

		botonCancelarPedido = new JButton("Cancelar Pedido");
		botonCancelarPedido.setBounds(350, 450, 150, 30);
		botonCancelarPedido.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		botonCancelarPedido.setBackground(new Color(245, 245, 245));
		botonCancelarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelarPedido();

			}
		});
		contentPane.add(botonCancelarPedido);

	}

	public void actualizarTabla(){
		ModeloTabla modelTabla1= new ModeloTabla(BD.bd.getProducto());
		tablPrdctsXPdir.setModel(modelTabla1);
		ModeloTabla modelTabla2= new ModeloTabla(productosSeleccionados);
		tablPrdctsSelect.setModel(modelTabla2);
	}



	private void CerrarSecion(){
		JOptionPane.showMessageDialog(null, "Hasta Luego");
		setVisible(false);
	}

	private void anadirProducto(){
		
	}

	private void buscarProducto(){
		
	}

	private void nuevoUsuario(){
		if(VistaFormularioDatosCliente.ventana != null && VistaFormularioDatosCliente.ventana.isVisible())
			VistaFormularioDatosCliente.ventana.setVisible(false);
		VistaFormularioDatosCliente.ventana = new VistaFormularioDatosCliente();
		VistaFormularioDatosCliente.ventana.setVisible(true);
	}

	private void RealizarPedido(){

	}

	private void CancelarPedido(){
		JOptionPane.showConfirmDialog(null, "esta seguro?");
	}
}














