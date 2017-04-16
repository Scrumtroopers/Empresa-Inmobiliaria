package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import Datos.Almacen;
import Datos.BD;
import Datos.Producto;

public class VentanaRegistroAlmacenes extends JFrame {

	public static VentanaRegistroAlmacenes ventana;
	
	private JPanel contentPane;
	private JTable tablaRegistro;
	private JLabel titulo;
	private ModeloTabla modeloTabla;
	
	private JButton botonAbrirAlmacen;
	private JButton botonNuevoAlmacen;


	/**
	 * Create the frame.
	 */
	public VentanaRegistroAlmacenes() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		titulo = new JLabel("Registro Almacenes");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Century Gothic", Font.BOLD, 18));
		titulo.setBounds(10, 11, 654, 30);
		
		contentPane.add(titulo);
		tablaRegistro = new JTable();
		tablaRegistro.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		tablaRegistro.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		modeloTabla = new ModeloTabla(BD.bd.getAlamacenes());
		tablaRegistro.setModel(modeloTabla);
		
		tablaRegistro.setBounds(10, 52, 654, 311);
		JScrollPane scrollPane = new JScrollPane(tablaRegistro);
		scrollPane.setBounds(10, 52, 654, 348);
		contentPane.add(scrollPane);
		
		botonAbrirAlmacen = nuevoBoton(516, 411, "Abrir Almacen");
		botonAbrirAlmacen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbrirAlmacen();
			}
		});
		contentPane.add(botonAbrirAlmacen);
		
		
		botonNuevoAlmacen = nuevoBoton(356, 411, "Nuevo Almacen");
		botonNuevoAlmacen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NuevoAlmacen();
			}
		});
		contentPane.add(botonNuevoAlmacen);
	}
	
	private JButton nuevoBoton(int x, int y, String txt){
		JButton boton = new JButton(txt);
		boton.setBackground(new Color(245, 245, 245));
		boton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		boton.setBounds(x, y, 150, 30);
		return boton;
	}
	
	private void NuevoAlmacen(){
		if(VentanaNuevoAlmacen.ventana != null && VentanaNuevoAlmacen.ventana.isVisible()){
			VentanaNuevoAlmacen.ventana.setVisible(false);
		}
		VentanaNuevoAlmacen.ventana = new VentanaNuevoAlmacen();
		VentanaNuevoAlmacen.ventana.setVisible(true);
	}
	
	public void actualizarTabla(){
		modeloTabla = new ModeloTabla(BD.bd.getAlamacenes());
		this.tablaRegistro.setModel(modeloTabla);
	}
	
	private void AbrirAlmacen(){
		int i = tablaRegistro.getSelectedRow();
		if(i != -1){
			Object[] fila = modeloTabla.getFila(i);
			ArrayList<Almacen> almacenes = BD.bd.getAlamacenes();
			Almacen encontrado = null;
			int j = 0;
			while(j < almacenes.size() && encontrado == null){
				if(almacenes.get(i).compararValores(fila)){
					encontrado = almacenes.get(i);
				}
				j++;
			}
			if(encontrado != null){
				if(VentanaAlmacen.ventana != null && VentanaAlmacen.ventana.isVisible())
					VentanaAlmacen.ventana.setVisible(false);
				VentanaAlmacen.ventana = new VentanaAlmacen(encontrado);
				VentanaAlmacen.ventana.setVisible(true);
			}
		}
		
	}

}
