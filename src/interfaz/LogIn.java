package interfaz;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Datos.BD;
import Datos.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {
	private JTextField nameField;
	
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogIn() {
		setTitle("SCT LOG IN");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 360, 368);
		getContentPane().setLayout(null);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setFont(new Font("Segoe Print", Font.BOLD, 17));
		lblLogIn.setBounds(140, 20, 100, 50);
		getContentPane().add(lblLogIn);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblUser.setBounds(30, 80, 100, 15);
		getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblPassword.setBounds(30, 130, 100, 15);
		getContentPane().add(lblPassword);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		nameField.setBounds(130, 80, 175, 20);
		getContentPane().add(nameField);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		passwordField.setBounds(130, 130, 175, 20);
		getContentPane().add(passwordField);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(new Color(245, 245, 245));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				log();
			}
		});
		btnOk.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnOk.setBackground(new Color(245, 245, 245));
		btnOk.setBounds(110, 190, 140, 25);
		getContentPane().add(btnOk);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setBackground(new Color(245, 245, 245));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchToSignIn();
			}
		});
		btnSignIn.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnSignIn.setBounds(110, 284, 140, 25);
		getContentPane().add(btnSignIn);
		
		JLabel lblDontHaveAn = new JLabel("Don't have an account?");
		lblDontHaveAn.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblDontHaveAn.setForeground(new Color(0, 0, 128));
		lblDontHaveAn.setBounds(90, 244, 180, 15);
		getContentPane().add(lblDontHaveAn);	
	}

	void switchToSignIn(){
		try {
			this.dispose();
			ventana_crear_Usuario.init();
		} catch (Throwable e) {
			System.out.println("error cambio de vista");
			e.printStackTrace();
		}
	}
	
	void log(){
		Usuario user = BD.bd.getUsuario(nameField.getText(), String.valueOf(passwordField.getPassword()));
		BD.bd.usuarioLogeado = user;
		if (user!=null){
			dispose();
			newWindow(user.getCategoria());
		}
		else{
			nameField.setText("");
			passwordField.setText("");
		}
	}
	
	void newWindow(String categoria){
		if (categoria.equals("ADMINISTRADOR_ALMACEN")){
			if(VentanaRegistroAlmacenes.ventana == null)
				VentanaRegistroAlmacenes.ventana = new VentanaRegistroAlmacenes();
			VentanaRegistroAlmacenes.ventana.setVisible(true);
		}
		else{
			if (categoria.equals("EMPLEADO")){
				if(VentanaPedidosUsuario.ventana == null)
					VentanaPedidosUsuario.ventana = new VentanaPedidosUsuario();
				VentanaPedidosUsuario.ventana.setVisible(true);
			}
			else{ 
					if(categoria.equals("COMPRADOR")){
						if(VentanaCotizaciones.ventana == null)
							VentanaCotizaciones.ventana = new VentanaCotizaciones("Ventana Cotizaciones");
						VentanaCotizaciones.ventana.setVisible(true);
				}
			}
		}
	}
}
