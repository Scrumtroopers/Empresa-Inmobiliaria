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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignIn extends JFrame {
	private JTextField nameField;
	private JTextField apellidoField;
	private JTextField emailField;
	
	JRadioButton rdbtnMasculino;
	JRadioButton rdbtnFemenino;
	
	private JPasswordField passwordField;
	private JPasswordField passwordField2;	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
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
	public SignIn() {
		setTitle("SCT SING IN");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 497);
		getContentPane().setBackground(new Color(60, 179, 113));
		getContentPane().setLayout(null);
		
		JLabel lblSignIn = new JLabel("SIGN IN");
		lblSignIn.setFont(new Font("Segoe Print", Font.BOLD, 17));
		lblSignIn.setBounds(140, 20, 100, 50);
		getContentPane().add(lblSignIn);
		
		JLabel lblNombre = new JLabel("Nombre(s):");
		lblNombre.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		lblNombre.setBounds(30, 80, 100, 15);
		getContentPane().add(lblNombre);

		JLabel lblApellido = new JLabel("Apellidos:");
		lblApellido.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		lblApellido.setBounds(30, 120, 100, 15);
		getContentPane().add(lblApellido);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		lblSexo.setBounds(30, 160, 100, 15);
		getContentPane().add(lblSexo);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		lblEmail.setBounds(30, 200, 100, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		lblPassword.setBounds(30, 240, 100, 15);
		getContentPane().add(lblPassword);
		
		JLabel lblReptPwd = new JLabel("Repeat pwd:");
		lblReptPwd.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		lblReptPwd.setBounds(30, 280, 100, 15);
		getContentPane().add(lblReptPwd);		
		
		nameField = new JTextField();
		nameField.setFont(new Font("Lucida Bright", Font.PLAIN, 13));
		nameField.setBounds(130, 80, 175, 20);
		getContentPane().add(nameField);

		apellidoField = new JTextField();
		apellidoField.setFont(new Font("Lucida Bright", Font.PLAIN, 13));
		apellidoField.setBounds(130, 120, 175, 20);
		getContentPane().add(apellidoField);

		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(130, 160, 109, 23);
		rdbtnMasculino.setBackground(new Color(60, 179, 113));
		getContentPane().add(rdbtnMasculino);
		
		rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBounds(240, 160, 109, 23);
		rdbtnFemenino.setBackground(new Color(60, 179, 113));
		getContentPane().add(rdbtnFemenino);
		
		ButtonGroup grSexo = new ButtonGroup();
		grSexo.add(rdbtnMasculino);
		grSexo.add(rdbtnFemenino);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Lucida Bright", Font.PLAIN, 13));
		emailField.setBounds(130, 200, 175, 20);
		getContentPane().add(emailField);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Lucida Bright", Font.PLAIN, 13));
		passwordField.setBounds(130, 240, 175, 20);
		getContentPane().add(passwordField);

		passwordField2 = new JPasswordField();
		passwordField2.setFont(new Font("Lucida Bright", Font.PLAIN, 13));
		passwordField2.setBounds(130, 280, 175, 20);
		getContentPane().add(passwordField2);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btnOk.setBackground(new Color(192, 192, 192));
		btnOk.setBounds(110, 330, 140, 25);
		getContentPane().add(btnOk);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchToLogIn();
			}
		});
		btnLogIn.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		btnLogIn.setBackground(new Color(192, 192, 192));
		btnLogIn.setBounds(110, 400, 140, 25);
		getContentPane().add(btnLogIn);
		
		JLabel lblAlreadyHaveAn = new JLabel("Already have an account?");
		lblAlreadyHaveAn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAlreadyHaveAn.setForeground(new Color(0, 0, 128));
		lblAlreadyHaveAn.setBounds(110, 370, 150, 15);
		getContentPane().add(lblAlreadyHaveAn);		
	}

	void switchToLogIn(){
		try {
			this.dispose();
			LogIn frame = new LogIn();
			frame.setVisible(true);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
	}
}
