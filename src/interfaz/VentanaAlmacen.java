package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Datos.Almacen;
import Datos.BD;
import Datos.DatoTabla;
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
public class VentanaAlmacen extends JFrame {

	public static VentanaAlmacen ventana;
	
	private JPanel contentPane;
	private JTable tablaProductos;
	private JLabel titulo;
	
	private ModeloTabla modeloTabla;
	
	private JButton botonAgregar;
	private JButton botonSalir;
	private JButton botonEliminar;
	
	private Almacen almacen;
	
	/**
	 * Constructor
	 * 
	 * @param productos son los datos que contendra la tabla
	 * @param txtTitulo el titulo de la ventana
	 */
	public VentanaAlmacen(Almacen almacen) {
		this.almacen = almacen;
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 680, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		titulo = new JLabel(almacen.getNombre());
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
		//botonEditar = nuevoBoton(10, 411, "Editar Producto");
		/*botonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editarProducto();
			}
		});*/
		//contentPane.add(botonEditar);
		botonEliminar = nuevoBoton(170, 411, "Eliminar Producto");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarProducto();
			}
		});
		contentPane.add(botonEliminar);
		botonAgregar = nuevoBoton(330, 411, "Agregar Producto");
		botonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarProducto();
			}
		});
		contentPane.add(botonAgregar);
		botonSalir = nuevoBoton(516, 411, "Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		contentPane.add(botonSalir);
		actualizarTabla();
	}
	
	public void actualizarTabla(){
		ArrayList<Producto> productos = BD.bd.getProducto();
		ArrayList<Producto> seleccionados = new ArrayList<Producto>();
		for(Producto p : productos){
			if(p.getAlmacen() == almacen){
				seleccionados.add(p);
			}
		}
		modeloTabla = new ModeloTabla(seleccionados);
		tablaProductos.setModel(modeloTabla);
	}
	
	private JButton nuevoBoton(int x, int y, String txt){
		JButton boton = new JButton(txt);
		boton.setBackground(new Color(245, 245, 245));
		boton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		boton.setBounds(x, y, 150, 30);
		return boton;
	}
	
	private void agregarProducto(){
		if(VentanaNuevoProducto.ventana != null && VentanaNuevoProducto.ventana.isVisible()){
			VentanaNuevoProducto.ventana.setVisible(false);
		}
		VentanaNuevoProducto.ventana = new VentanaNuevoProducto(almacen);
		VentanaNuevoProducto.ventana.setVisible(true);
	}
	
	private void eliminarProducto(){
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
	
	private void salir(){
		this.setVisible(false);
	}
}
