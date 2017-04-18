package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Datos.Almacen;
import Datos.BD;
import Datos.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
* Esta ventana es la vista de un almacen en especifico
* @author Bernardo
*/
public class VentanaProductos extends JFrame {

	public static VentanaProductos ventana;
	
	private JPanel contentPane;
	private JTable tablaProductos;
	private JLabel titulo;
	
	private ModeloTabla modeloTabla;
	
	private JButton botonCerrarSesion;
	private JButton botonEditar;
	private JButton botonEliminar;
	
	/**
	 * Constructor
	 * 
	 * @param productos son los datos que contendra la tabla
	 * @param txtTitulo el titulo de la ventana
	 */
	public VentanaProductos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 680, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		titulo = new JLabel("Inventario de Productos");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Century Gothic", Font.BOLD, 18));
		titulo.setBounds(10, 11, 654, 30);
		
		contentPane.add(titulo);
		tablaProductos = new JTable();
		tablaProductos.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		tablaProductos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		tablaProductos.setBounds(10, 52, 654, 311);
		JScrollPane scrollPane = new JScrollPane(tablaProductos);
		scrollPane.setBounds(10, 52, 654, 348);
		contentPane.add(scrollPane);

		botonCerrarSesion = nuevoBoton(516, 411, "Cerrar sesión");
		botonCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		
		botonEditar = nuevoBoton(170, 411, "Editar");
		botonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editar();
			}
		});
		
		botonEliminar = nuevoBoton(330, 411, "Eliminar");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminar();
			}
		});
		
		contentPane.add(botonCerrarSesion);
		contentPane.add(botonEditar);
		contentPane.add(botonEliminar);
		
		actualizarTabla();
	}
	
	public void actualizarTabla(){
		ArrayList<Producto> productos = BD.bd.getProducto();

		modeloTabla = new ModeloTabla(productos);
		tablaProductos.setModel(modeloTabla);
	}
	
	private JButton nuevoBoton(int x, int y, String txt){
		JButton boton = new JButton(txt);
		boton.setBackground(new Color(245, 245, 245));
		boton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		boton.setBounds(x, y, 150, 30);
		return boton;
	}
	
	private void salir(){
		LogIn.init();
		this.setVisible(false);
	}
	
	private void eliminar(){
		int i = tablaProductos.getSelectedRow();
		if(i != -1){
			Object[] fila = modeloTabla.getFila(i);
			ArrayList<Producto> productos = BD.bd.getProducto();
			Producto encontrado = null;
			int j = 0;
			while(j < productos.size() && encontrado == null){
				if(productos.get(i).compararValores(fila)){
					encontrado = productos.get(i);
				}
				j++;
			}
			if(encontrado != null){
				BD.bd.eliminarProducto(encontrado.getNombre(), encontrado.getMarca(), encontrado.getModelo());
				JOptionPane.showMessageDialog(this, "Producto Eliminado");
				actualizarTabla();
			}
		}
		else{
			JOptionPane.showMessageDialog(this, "Debe seleccionar un producto");
		}
	}
	
	private void editar(){
		int i = tablaProductos.getSelectedRow();
		if(i != -1){
			Object[] fila = modeloTabla.getFila(i);
			ArrayList<Producto> productos = BD.bd.getProducto();
			Producto encontrado = null;
			int j = 0;
			while(j < productos.size() && encontrado == null){
				if(productos.get(i).compararValores(fila)){
					encontrado = productos.get(i);
				}
				j++;
			}
			if(encontrado != null){
				if(VentanaEditarProducto.ventana != null && VentanaEditarProducto.ventana.isVisible()){
					VentanaEditarProducto.ventana.setVisible(false);
				}
				VentanaEditarProducto.ventana = new VentanaEditarProducto(encontrado);
				VentanaEditarProducto.ventana.setVisible(true);
			}
		}
		else{
			JOptionPane.showMessageDialog(this, "Debe seleccionar un producto");
		}
		
	}
}
