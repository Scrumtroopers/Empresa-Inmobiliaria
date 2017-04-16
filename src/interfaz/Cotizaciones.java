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

public class Cotizaciones extends JFrame{

	private JFrame frame;
	private JPanel contentPane;
	private JTable tablaCotizaciones;
	private JLabel titulo,cotizacionLabel,cotizacionText;
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
					Object[][] datos={
							{"00001",new Date("2017/04/15"),new Date("2017/05/15"),175072028,"Toyota","automovil",15000,1, 15000,104400},
							{"00002",new Date("2017/04/15"),new Date("2017/05/15"),175072028,"Toyota","automovil",15000,1, 15000,104400}
					};
					String[] nombresColumnas = {"Codigo","Fecha","Fecha de Vencimiento","NIT","Empresa","Producto","Valor Unitario($us)","Cantidad","Importe Total Moneda Extranjera","Importe Total(Bs)"};
					
					
					Cotizaciones frame = new Cotizaciones(datos,nombresColumnas,"LISTADO DE COTIZACIONES DE PRODUCTOS");
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
	public Cotizaciones(Object[][] datos, String[] nombresColumnas, String txtTitulo) {
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
		
		
		//tabla de cotizaciones
		tablaCotizaciones = new JTable();
		tablaCotizaciones.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		tablaCotizaciones.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ModeloTabla modelo = new ModeloTabla(datos,nombresColumnas);
		tablaCotizaciones.setModel(modelo);
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
		
		
		
	}

	
	private JButton nuevoBoton(int x, int y, String txt){
		JButton boton = new JButton(txt);
		boton.setBackground(new Color(245, 245, 245));
		boton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		boton.setBounds(x, y, 150, 30);
		return boton;
	}
	
	private void editarCotizacion() {
		// TODO Auto-generated method stub
		
	}
	
	private void agregarCotizacion() {
		// TODO Auto-generated method stub
		
	}
	
	private void eliminarCotizacion() {
		// TODO Auto-generated method stub
		
	}

}
