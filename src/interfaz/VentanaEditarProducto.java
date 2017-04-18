package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.Almacen;
import Datos.BD;
import Datos.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEditarProducto extends JFrame {

	public static VentanaEditarProducto ventana;
	
	private JPanel contentPane;
	private JTextField txtAlmacen;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txPrecioCompra;
	private JTextField txtPrecioVenta;
	private JTextField txtUnidades;

	private Producto actual;
	
	public VentanaEditarProducto(Producto actual) {
		this.actual = actual;
		System.out.println(actual);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 340, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar Producto");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 314, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Almacen");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblNombre.setBounds(10, 52, 152, 20);
		contentPane.add(lblNombre);
		
		txtAlmacen = new JTextField();
		txtAlmacen.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtAlmacen.setBounds(10, 83, 152, 30);
		txtAlmacen.setText(actual.getAlmacen().getNombre());
		txtAlmacen.setEditable(false);
		contentPane.add(txtAlmacen);
		txtAlmacen.setColumns(10);
		
		JLabel label = new JLabel("Nombre");
		label.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		label.setBounds(10, 124, 314, 20);
		contentPane.add(label);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtNombre.setColumns(10);
		txtNombre.setBounds(10, 155, 314, 30);
		txtNombre.setText(actual.getNombre());
		contentPane.add(txtNombre);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblMarca.setBounds(10, 196, 314, 20);
		contentPane.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtMarca.setColumns(10);
		txtMarca.setBounds(10, 227, 314, 30);
		txtMarca.setText(actual.getMarca());
		contentPane.add(txtMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblModelo.setBounds(10, 268, 314, 20);
		contentPane.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtModelo.setColumns(10);
		txtModelo.setBounds(10, 299, 314, 30);
		txtModelo.setText(actual.getModelo());
		contentPane.add(txtModelo);
		
		JLabel lblPrecioCompra = new JLabel("Precio Compra");
		lblPrecioCompra.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblPrecioCompra.setBounds(10, 340, 152, 20);
		contentPane.add(lblPrecioCompra);
		
		txPrecioCompra = new JTextField();
		txPrecioCompra.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txPrecioCompra.setColumns(10);
		txPrecioCompra.setBounds(10, 371, 152, 30);
		txPrecioCompra.setText(String.valueOf(actual.getPrecioCompra()));
		contentPane.add(txPrecioCompra);
		
		txtPrecioVenta = new JTextField();
		txtPrecioVenta.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtPrecioVenta.setColumns(10);
		txtPrecioVenta.setBounds(172, 371, 152, 30);
		txtPrecioVenta.setText(String.valueOf(actual.getPrecioVenta()));
		contentPane.add(txtPrecioVenta);
		
		JLabel lblPrecioVenta = new JLabel("Precio Venta");
		lblPrecioVenta.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblPrecioVenta.setBounds(172, 340, 152, 20);
		contentPane.add(lblPrecioVenta);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editarProducto();
			}
		});
		btnAceptar.setBounds(235, 430, 89, 30);
		btnAceptar.setBackground(new Color(245, 245, 245));
		contentPane.add(btnAceptar);
		
		JLabel lblUnidades = new JLabel("Unidades");
		lblUnidades.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblUnidades.setBounds(172, 52, 152, 20);
		contentPane.add(lblUnidades);
		
		txtUnidades = new JTextField();
		txtUnidades.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtUnidades.setColumns(10);
		txtUnidades.setBounds(172, 83, 152, 30);
		txtUnidades.setText(String.valueOf(actual.getUnidades()));
		contentPane.add(txtUnidades);
	}
	
	private void editarProducto(){
		int unidades = Integer.parseInt(txtUnidades.getText());
		String nombre = txtNombre.getText();
		String marca = txtMarca.getText();
		String modelo = txtModelo.getText();
		double precioCompra = Double.parseDouble(txPrecioCompra.getText());
		double precioVenta = Double.parseDouble(txtPrecioVenta.getText());
		
		Producto p = new Producto(unidades, nombre, marca, modelo, precioVenta, precioCompra, actual.getAlmacen());
		BD.bd.eliminarProducto(actual.getNombre(), actual.getMarca(), actual.getModelo());
		BD.bd.guardarProducto(p);
		JOptionPane.showMessageDialog(this, "Cambios guardados");
		if(VentanaProductos.ventana != null && VentanaProductos.ventana.isVisible())
			VentanaProductos.ventana.actualizarTabla();
		this.setVisible(false);
	}
}
