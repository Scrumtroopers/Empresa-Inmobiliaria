package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import Datos.Cotizacion;
import Datos.Producto;

public class VentanaCotizaciones extends JFrame{

	public static VentanaCotizaciones ventana;
	
	//private JFrame frame;
	private JPanel contentPane;
	private JTable tablaCotizaciones;
	private JLabel titulo,tipoCambioL;
	private JButton botonEditar;
	private JButton botonAgregar;
	private JButton botonEliminar;
	private JButton botonActualizar;
	private JButton botonProveedores;
	private double tipoCambio;
	private JTextField tipoCambiotf;
	private ModeloTabla modeloTabla;
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("deprecation")
					Date fecha;
					fecha = new Date("2017/04/15");
					SimpleDateFormat formtatoFecha = new SimpleDateFormat("yyyyy/mm/dd");
					formtatoFecha.format(fecha);
					
					//System.out.println(fecha);
	
					 
					/* String fecha = "2017/04/15"; 
					 Date date = new SimpleDateFormat("yyyyy/mm/dd").parse(fecha);
					 
					System.out.println(fecha);
					 
					Object[][] datos={
							{"00001","2017/05/15",175072028,"Toyota","automovil",15000,1, 15000,104400},
							{"00002","2017/04/15",new Date("2017/05/15"),175072028,"Toyota","automovil",15000,1, 15000,104400}
					};
					String[] nombresColumnas = {"Codigo","Fecha","Fecha de Vencimiento","NIT","Empresa","Producto","Valor Unitario($us)","Cantidad","Importe Total Moneda Extranjera","Importe Total(Bs)"};
					
					
					VentanaCotizaciones frame = new VentanaCotizaciones(datos,nombresColumnas,"LISTADO DE COTIZACIONES DE PRODUCTOS");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public VentanaCotizaciones(String txtTitulo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//titulo
		titulo = new JLabel(txtTitulo);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Century Gothic", Font.BOLD, 18));
		titulo.setBounds(370, 11, 654, 30);
		contentPane.add(titulo);
		
		//tipo de cambio
		tipoCambioL = new JLabel("Tipo de cambio:");
		tipoCambioL.setFont(new Font("Century Gothic", Font.BOLD, 11));
		tipoCambioL.setBounds(1140, 15, 90, 30);
		contentPane.add(tipoCambioL);
		
		tipoCambiotf = new JTextField();
		tipoCambiotf.setBounds(1240, 20, 86, 20);
		contentPane.add(tipoCambiotf);
		tipoCambiotf.setColumns(10);
		SNumeros(tipoCambiotf);
		
		
		//tabla de cotizaciones
		tablaCotizaciones = new JTable();
		tablaCotizaciones.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		tablaCotizaciones.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		modeloTabla = new ModeloTabla(BD.bd.getCotizaciones());
		tablaCotizaciones.setModel(modeloTabla);
		tablaCotizaciones.setBounds(10, 52, 1350, 311);
		JScrollPane scrollPane = new JScrollPane(tablaCotizaciones);
		scrollPane.setBounds(10, 52, 1350, 600);
		contentPane.add(scrollPane);
		
		//botones
		botonEditar = nuevoBoton(15,660, "Editar");
		botonEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				editarCotizacion();
				
			}			
		});
		contentPane.add(botonEditar);
		
		botonAgregar = nuevoBoton(170, 660, "Agregar");
		botonAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				agregarCotizacion();
				
			}			
		});
		contentPane.add(botonAgregar);
		
		botonEliminar = nuevoBoton(325, 660, "Eliminar");
		botonEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				eliminarCotizacion();
				
			}			
		});
		contentPane.add(botonEliminar);
		
		botonActualizar = nuevoBoton(1200, 660, "Actualizar");
		botonActualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				actualizarCotizacion();
				
			}			
		});
		contentPane.add(botonActualizar);
		
		botonProveedores = nuevoBoton(900, 660, "Proveedores");
		botonProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaProveedores.ventana = new VentanaProveedores("Lista de Proveedores");
				VentanaProveedores.ventana.setVisible(true);	
			}			
		});
		contentPane.add(botonProveedores);
		
		
	}

	
	private JButton nuevoBoton(int x, int y, String txt){
		JButton boton = new JButton(txt);
		boton.setBackground(new Color(245, 245, 245));
		boton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		boton.setBounds(x, y, 150, 30);
		return boton;
	}
	
	private void editarCotizacion() {
		int i = tablaCotizaciones.getSelectedRow();
		if(i != -1){
			Object[] fila = modeloTabla.getFila(i);
			ArrayList<Cotizacion> cotizaciones = BD.bd.getCotizaciones();
			Cotizacion encontrado = null;
			int j = 0;
			while(j < cotizaciones.size() && encontrado == null){
				if(cotizaciones.get(i).compararValores(fila)){
					encontrado = cotizaciones.get(i);
				}
				j++;
			}
			if(encontrado != null){
				if(VentanaModificarCotizacion.ventana != null && VentanaModificarCotizacion.ventana.isVisible())
					VentanaModificarCotizacion.ventana.setVisible(false);
				VentanaModificarCotizacion.ventana = new VentanaModificarCotizacion(encontrado);
				VentanaModificarCotizacion.ventana.setVisible(true);
			}
		}
		else{
			JOptionPane.showMessageDialog(this, "Debe seleccionar una Cotizacion");
		}
	}
	
	private void agregarCotizacion() {
		if(VentanaModificarCotizacion.ventana != null && VentanaModificarCotizacion.ventana.isVisible())
			VentanaModificarCotizacion.ventana.setVisible(false);
		VentanaModificarCotizacion.ventana = new VentanaModificarCotizacion();
		VentanaModificarCotizacion.ventana.setVisible(true);
		
	}
	
	private void eliminarCotizacion() {
		int i = tablaCotizaciones.getSelectedRow();
		if(i != -1){
			Object[] fila = modeloTabla.getFila(i);
			ArrayList<Cotizacion> cotizaciones = BD.bd.getCotizaciones();
			Cotizacion encontrado = null;
			int j = 0;
			while(j < cotizaciones.size() && encontrado == null){
				if(cotizaciones.get(i).compararValores(fila)){
					encontrado = cotizaciones.get(i);
				}
				j++;
			}
			if(encontrado != null){
				BD.bd.eliminarCotizacion(encontrado);
				JOptionPane.showMessageDialog(this, "Cotizacion Eliminada");
				actualizarTabla();
			}
		}
		else{
			JOptionPane.showMessageDialog(this, "Debe seleccionar una Cotizacion");
		}
		
	}
	
	private void actualizarCotizacion() {
		double num = getNumero(tipoCambiotf);
		ArrayList<Cotizacion> cotizaciones = BD.bd.getCotizaciones();
		for(Cotizacion c : cotizaciones){
			c.setTipoCambio(num);
		}
		actualizarTabla();
	}
	
	private void SNumeros(JTextField a){
	        a.addKeyListener(new KeyAdapter(){
	            public void keyTyped(KeyEvent e){
	                  char c=e.getKeyChar();
	                  if(!Character.isDigit(c)&&c!='.'){
	                      getToolkit().beep();
	                      e.consume();
	                  }
	            }
	        });
	}
	
	private double getNumero(JTextField tf){
		double numero=0.0;
		String num = tf.getText();
		
	     try {numero = Double.parseDouble(num);
		
	     } catch( Exception e){
	    	 System.out.println("numero incorrecto");
	     }
	     return numero;
	     
	}
	
	public void actualizarTabla(){
		modeloTabla = new ModeloTabla(BD.bd.getCotizaciones());
		tablaCotizaciones.setModel(modeloTabla);
	}
	
	
}
