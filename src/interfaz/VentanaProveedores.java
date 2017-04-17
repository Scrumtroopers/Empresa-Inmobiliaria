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
import javax.swing.SwingUtilities;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaProveedores extends JFrame{

	private JPanel contentPane;
	private JTable tablaProveedores;
	private ModeloTabla modelo;
	private JLabel titulo;
	private JButton botonNuevoProveedor;
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Object[][] datos = new Object[][] {
						{"Pepe", "Rodriguez", "Sanchez","123123", "112233", "especificaciones"},
						{"Miguel",  "Antonio", "Marcos", "987987","998877", "espicificaciones"},
					};
					String[] nombresColumnas = new String[] {
							"Nombre", "Apellido Paterno", "Apellido Materno", "Telefono", "Celular", "Detalle Producto"
						};
					VentanaProveedores frame = new VentanaProveedores(datos, nombresColumnas, "Lista de Proveedores");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaProveedores(Object[][] datos, String[] nombresColumnas, String textoTitulo) {
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
		
		// UTILIZAR SOLO PARA PROBAR MAIN()
		modelo = new ModeloTabla(datos, nombresColumnas);
		
		/* UTILIZAR EN PROGRAMA
		modelo = new ModeloTabla(BD.bd.getAlamacenes()); 
		*/
		
		tablaProveedores.setModel(modelo);
		tablaProveedores.setBounds(10, 52, 654, 311);
		JScrollPane scrollPane = new JScrollPane(tablaProveedores);
		scrollPane.setBounds(10, 52, 654, 348);
		contentPane.add(scrollPane);
		
		botonNuevoProveedor = nuevoBoton(510, 411, "Nuevo Proveedor");
		botonNuevoProveedor.addActionListener(new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
	                SwingUtilities.invokeLater(new Runnable() {
	                    @Override
	                    public void run() {
	                        VentanaAgregarProveedor dialog = new VentanaAgregarProveedor(VentanaProveedores.this);
	                        //retorna proveedor desde JDialog
	                        Proveedor prov = dialog.getProveedor();
	                        // necesitar llamar a actualizarTabla() y que se vean los cambios
	                    }
	                });
	            }
	        });
		
		contentPane.add(botonNuevoProveedor);
	}
	
	private JButton nuevoBoton(int x, int y, String txt){
		JButton boton = new JButton(txt);
		boton.setBackground(new Color(245, 245, 245));
		boton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		boton.setBounds(x, y, 150, 30);
		return boton;
	}
	
	public void actualizarTabla(){
		modelo = new ModeloTabla(BD.bd.getProveedores());
		tablaProveedores.setModel(modelo);
	}

}



   
