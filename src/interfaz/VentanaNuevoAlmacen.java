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

public class VentanaNuevoAlmacen extends JFrame {

	public static VentanaNuevoAlmacen ventana;
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;

	
	public VentanaNuevoAlmacen() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 340, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nuevo Almacen");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 314, 30);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("Nombre");
		label.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		label.setBounds(10, 52, 314, 20);
		contentPane.add(label);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtNombre.setColumns(10);
		txtNombre.setBounds(10, 83, 314, 30);
		contentPane.add(txtNombre);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblDireccion.setBounds(10, 124, 314, 20);
		contentPane.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(10, 155, 314, 30);
		contentPane.add(txtDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblTelefono.setBounds(10, 196, 314, 20);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(10, 227, 314, 30);
		contentPane.add(txtTelefono);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarAlmacen();
			}
		});
		btnRegistrar.setBounds(235, 271, 89, 30);
		btnRegistrar.setBackground(new Color(245, 245, 245));
		contentPane.add(btnRegistrar);
	}
	
	private void registrarAlmacen(){
		String nombre = txtNombre.getText();
		String direccion = txtDireccion.getText();
		String telefono = txtTelefono.getText();
		Almacen alm = new Almacen(nombre, direccion, telefono);
		BD.bd.guardarAlmacen(alm);
		JOptionPane.showMessageDialog(this, "Almacen registrado");
		if(VentanaRegistroAlmacenes.ventana != null && VentanaRegistroAlmacenes.ventana.isValid())
			VentanaRegistroAlmacenes.ventana.actualizarTabla();
		this.setVisible(false);
	}
}
