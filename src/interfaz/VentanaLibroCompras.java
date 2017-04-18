package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class VentanaLibroCompras extends JFrame{

	private JFrame frame;
	private JPanel contentPane;
	private JTable tablaCompras;
	private JLabel titulo;
	private JButton botonEditar;
	private JButton botonAgregar;
	private JButton botonEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("deprecation")
					Object[][] datos={{1,new Date("2015/11/13"),new Long("12345678910"),"Toyota",new Long("1566"),"2015701C11909",new Long ("2101002425"),1200.0,1200.0,0.0,0.0,0.0,0.0,"2A-E5-E4-43",1}, {2,new Date("2015/11/13"),new Long("12345678910"),"Toyota",new Long("1566"),"2015701C11909",new Long ("2101002425"),1200.0,1200.0,0.0,0.0,0.0,0.0,"2A-E5-E4-43",1}}; 
														
					
					String[] nombresColumnas = {"Nro","Fecha de la Factura o DUI","NIT Proveedor","Nombre y Apellidos/Razon Social","Nro de Factura","Nro de DUI","Nro de Autorizacion","Importe Total de la Compra","Importe no Sujeto a Credito Fiscal","Subtotal","Descuentos, Bonificaciones y Rebajas Obtenidas","Importe Base para Credito Fiscal","Credito Fiscal","Codigo de Control","Tipo de Compra"};
					long num = new Long("123456789123456");
					
					
					VentanaLibroCompras frame = new VentanaLibroCompras(datos,nombresColumnas,"LIBRO DE COMPRAS");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaLibroCompras(Object[][] datos, String[] nombresColumnas, String txtTitulo) {
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
		
		
		//tabla de compras
		tablaCompras = new JTable();
		tablaCompras.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		tablaCompras.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ModeloTabla modelo = new ModeloTabla(datos,nombresColumnas);
		tablaCompras.setModel(modelo);
		tablaCompras.setBounds(10, 52, 1350, 311);
		JScrollPane scrollPane = new JScrollPane(tablaCompras);
		scrollPane.setBounds(10, 52, 1350, 600);
		contentPane.add(scrollPane);
		
		//botones
		botonEditar = nuevoBoton(15,660, "Editar");
		botonEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				editarCompra();
				
			}			
		});
		contentPane.add(botonEditar);
		
		botonAgregar = nuevoBoton(170, 660, "Agregar");
		botonAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				agregarCompra();
				
			}			
		});
		contentPane.add(botonAgregar);
		
		botonEliminar = nuevoBoton(325, 660, "Eliminar");
		botonEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				eliminarCompra();
				
			}			
		});
		contentPane.add(botonEliminar);
		
		
		
	}

	
	private JButton nuevoBoton(int x, int y, String txt){
		JButton boton = new JButton(txt);
		boton.setBackground(new Color(245, 245, 245));
		boton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		boton.setBounds(x, y, 150, 30);
		return boton;
	}
	
	private void editarCompra() {
		// TODO Auto-generated method stub
		
	}
	
	private void agregarCompra() {
		// TODO Auto-generated method stub
		
	}
	
	private void eliminarCompra() {
		// TODO Auto-generated method stub
		
	}

}
