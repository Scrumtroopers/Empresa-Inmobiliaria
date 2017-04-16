package interfaz;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ventanaAgregarProveedor extends JFrame{
	private JPanel contentPane;
	private JLabel titulo;
	private JLabel labelNombre;
	private JLabel labelApellidoP;
	private JLabel labelApellidoM;
	private JLabel labelTelefono;
	private JLabel labelCelular;
	private JLabel labelDetalleP;
	private JButton botonRegistrar;
	private JTextField textNombre;
	private JTextField textApellidoP;
	private JTextField textApellidoM;
	private JTextField textTelefono;
	private JTextField textCelular;
	private JTextField textDetalleP;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					ventanaAgregarProveedor frame = new ventanaAgregarProveedor();
					frame.setVisible(true);
				}
			});
		}
	
	private JButton nuevoBoton(int x, int y, String txt){
		JButton boton = new JButton(txt);
		boton.setBackground(new Color(245, 245, 245));
		boton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		boton.setBounds(x, y, 150, 30);
		return boton;
	}
	
	public ventanaAgregarProveedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 480, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		titulo = new JLabel("Registrar Nuevo Proveedor");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Century Gothic", Font.BOLD, 18));
		titulo.setBounds(10, 11, 450, 30);	
		contentPane.add(titulo);
		
		labelNombre = new JLabel("Nombre(s):");
		labelNombre.setBounds(24, 50, 130, 15);
		contentPane.add(labelNombre);
		
		labelApellidoP = new JLabel("Apellido Paterno:");
		labelApellidoP.setBounds(24, 95, 130, 15);
		contentPane.add(labelApellidoP);
		
		labelApellidoM = new JLabel("Apellido Materno:");
		labelApellidoM.setBounds(24, 140, 130, 15);
		contentPane.add(labelApellidoM);
		
		labelTelefono = new JLabel("Numero de Telefono:");
		labelTelefono.setBounds(24, 185, 140, 15);
		contentPane.add(labelTelefono);
		
		labelCelular = new JLabel("Numero de Celular:");
		labelCelular.setBounds(24, 230, 130, 15);
		contentPane.add(labelCelular);
		
		labelDetalleP = new JLabel("Detalle de Producto:");
		labelDetalleP.setBounds(24, 275, 130, 15);
		contentPane.add(labelDetalleP);

		botonRegistrar = nuevoBoton(300, 340, "Registrar");
		botonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				/* guardar en ArrayList<Proovedores> proveedores.
				actualizar tabla en ventaProveedores
				*/
			}
		});
		contentPane.add(botonRegistrar);
		
		textNombre = new JTextField();
		textNombre.setBounds(180, 50, 130, 15);
		contentPane.add(textNombre);
		
		textApellidoP = new JTextField();
		textApellidoP.setBounds(180, 95, 130, 15);
		contentPane.add(textApellidoP);
		
		textApellidoM= new JTextField();
		textApellidoM.setBounds(180, 140, 130, 15);
		contentPane.add(textApellidoM);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(180, 185, 130, 15);
		contentPane.add(textTelefono);
		
		textCelular = new JTextField();
		textCelular.setBounds(180, 230, 130, 15);
		contentPane.add(textCelular);
		
		textDetalleP = new JTextField();
		textDetalleP.setBounds(180, 275, 130, 15);
		contentPane.add(textDetalleP);
		
	}
}
