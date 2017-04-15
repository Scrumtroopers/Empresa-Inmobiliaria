package ventanaUsuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class ventana_crear_Usuario extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textAP;
	private JTextField textAM;
	private JTextField textContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_crear_Usuario frame = new ventana_crear_Usuario();
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
	public ventana_crear_Usuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrarte = new JLabel("Registrarte");
		lblRegistrarte.setFont(new Font("DejaVu Serif", Font.BOLD, 19));
		lblRegistrarte.setBounds(195, 12, 174, 42);
		contentPane.add(lblRegistrarte);
		
		JLabel lblNombres = new JLabel("Nombre(s)");
		lblNombres.setBounds(24, 120, 94, 15);
		contentPane.add(lblNombres);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setBounds(24, 172, 130, 15);
		contentPane.add(lblApellidoPaterno);
		
		textNombre = new JTextField();
		textNombre.setBounds(157, 118, 114, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textAP = new JTextField();
		textAP.setBounds(157, 170, 114, 19);
		contentPane.add(textAP);
		textAP.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setBounds(24, 218, 130, 15);
		contentPane.add(lblApellidoMaterno);
		
		textAM = new JTextField();
		textAM.setBounds(157, 218, 114, 19);
		contentPane.add(textAM);
		textAM.setColumns(10);
		
		JLabel lblContraseaNueva = new JLabel("Contraseña Nueva");
		lblContraseaNueva.setBounds(12, 273, 137, 15);
		contentPane.add(lblContraseaNueva);
		
		textContrasena = new JTextField();
		textContrasena.setBounds(157, 271, 114, 19);
		contentPane.add(textContrasena);
		textContrasena.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(12, 317, 157, 15);
		contentPane.add(lblFechaDeNacimiento);
		
		JSpinner spinnerDia = new JSpinner();
		spinnerDia.setModel(new SpinnerListModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		spinnerDia.setBounds(174, 315, 58, 20);
		contentPane.add(spinnerDia);
		
		JSpinner spinnerMes = new JSpinner();
		spinnerMes.setModel(new SpinnerListModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		spinnerMes.setBounds(258, 315, 58, 20);
		contentPane.add(spinnerMes);
		
		JSpinner spinnerAno = new JSpinner();
		spinnerAno.setModel(new SpinnerListModel(new String[] {"1995", "1996", "1997", "1998", "2000", "2001"}));
		spinnerAno.setBounds(339, 315, 99, 20);
		contentPane.add(spinnerAno);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBounds(50, 384, 94, 23);
		contentPane.add(rdbtnMujer);
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(195, 384, 99, 23);
		contentPane.add(rdbtnHombre);
		
		JButton btnRegistrase = new JButton("Registrase");
		btnRegistrase.setBounds(321, 383, 117, 25);
		contentPane.add(btnRegistrase);
	}
}
