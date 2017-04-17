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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 368);
		getContentPane().setLayout(null);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setFont(new Font("Segoe Print", Font.BOLD, 17));
		lblLogIn.setBounds(140, 20, 100, 50);
		getContentPane().add(lblLogIn);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		lblUser.setBounds(30, 80, 100, 15);
		getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		lblPassword.setBounds(30, 130, 100, 15);
		getContentPane().add(lblPassword);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Lucida Bright", Font.PLAIN, 13));
		nameField.setBounds(130, 80, 175, 20);
		getContentPane().add(nameField);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Lucida Bright", Font.PLAIN, 13));
		passwordField.setBounds(130, 130, 175, 20);
		getContentPane().add(passwordField);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				log();
			}
		});
		btnOk.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btnOk.setBounds(110, 190, 140, 25);
		getContentPane().add(btnOk);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchToSignIn();
			}
		});
		btnSignIn.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btnSignIn.setBounds(110, 284, 140, 25);
		getContentPane().add(btnSignIn);
		
		JLabel lblDontHaveAn = new JLabel("Don't have an account?");
		lblDontHaveAn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDontHaveAn.setForeground(new Color(0, 0, 128));
		lblDontHaveAn.setBounds(110, 244, 150, 15);
		getContentPane().add(lblDontHaveAn);	
	}

	void switchToSignIn(){
		try {
			this.dispose();
			ventana_crear_Usuario.init();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("error cambio de vista");
			e.printStackTrace();
		}
	}
	
	void log(){
		Usuario user = BD.bd.getUsuario(nameField.getText(), String.valueOf(passwordField.getPassword()));
		BD.bd.usuarioLogeado = user;
		//System.out.println(user.getNickname());
		//System.out.println(user.getCategoria());
		dispose();
		if (user.getCategoria().equals("ADMINISTRADOR_ALMACEN")){
			if(VentanaRegistroAlmacenes.ventana == null)
				VentanaRegistroAlmacenes.ventana = new VentanaRegistroAlmacenes();
			VentanaRegistroAlmacenes.ventana.setVisible(true);
		}
		else{
			if (user.getCategoria().equals("EMPLEADO")){
				if(VentanaPedidosUsuario.ventana == null)
					VentanaPedidosUsuario.ventana = new VentanaPedidosUsuario();
				VentanaPedidosUsuario.ventana.setVisible(true);
			}
			else if(user.getCategoria().equals("COMPRADOR")){
				if(VentanaCotizaciones.ventana == null)
					VentanaCotizaciones.ventana = new VentanaCotizaciones("Ventana Cotizaciones");
				VentanaCotizaciones.ventana.setVisible(true);
			}
		}
	}
}
