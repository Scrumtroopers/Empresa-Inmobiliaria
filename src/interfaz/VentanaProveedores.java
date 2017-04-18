package interfaz;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import Datos.BD;
import Datos.Proveedor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaProveedores extends JFrame{

	private JPanel contentPane;
	private JTable tablaProveedores;
	private ModeloTabla modelo;
	private JLabel titulo;
	private JButton botonNuevoProveedor;
	
	public VentanaProveedores(String textoTitulo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 680, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		titulo = new JLabel(textoTitulo);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Century Gothic", Font.BOLD, 18));
		titulo.setBounds(10, 11, 654, 30);
		contentPane.add(titulo);
		
		tablaProveedores = new JTable();
		tablaProveedores.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		tablaProveedores.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tablaProveedores.setBounds(10, 52, 654, 311);
		JScrollPane scrollPane = new JScrollPane(tablaProveedores);
		scrollPane.setBounds(10, 52, 654, 348);
		contentPane.add(scrollPane);
			
		botonNuevoProveedor = nuevoBoton(510, 411, "Nuevo Proveedor");
		botonNuevoProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAgregarProveedor prov = new VentanaAgregarProveedor();
        			prov.setVisible(true); 
			}
		 });
		contentPane.add(botonNuevoProveedor);
		
		actualizarTabla();
	}
	
	private JButton nuevoBoton(int x, int y, String txt){
		JButton boton = new JButton(txt);
		boton.setBackground(new Color(245, 245, 245));
		boton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		boton.setBounds(x, y, 150, 30);
		return boton;
	}
	
	public void actualizarTabla(){
		ArrayList<Proveedor> proveedores = BD.bd.getProveedores();
		modelo = new ModeloTabla(proveedores);
		tablaProveedores.setModel(modelo);
	}

}
