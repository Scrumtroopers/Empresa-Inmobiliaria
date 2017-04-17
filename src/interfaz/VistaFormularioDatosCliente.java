package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import Datos.BD;
import Datos.Pedido;
import Datos.Usuario;

public class VistaFormularioDatosCliente extends JFrame  {
	
	public static VistaFormularioDatosCliente ventana;
	
	private JPanel contentPane;
	private JLabel titulo;
	private JLabel nombClient;
	private JLabel apellPat;
	private JLabel apellMat;
	private JLabel correo;
	private JLabel direccion;
	private JLabel telefono;
	private JLabel garantia;
	private JTextField espacNombCliente;
	private JTextField espacApellPCli;
	private JTextField espacApellMCli;
	private JTextField espacCorreCli;
	private JTextField espacDirecCli;
	private JTextField espacTelfCli;
	private JTextField espacGaranCli;
	private JButton guardar;
	
	public VistaFormularioDatosCliente(){
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(450, 75, 580, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titulo = new JLabel("Formulario Datos Cliente");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Century Gothic", Font.BOLD, 18));
		titulo.setBounds(190, 20, 215, 20);
		contentPane.add(titulo);
		
		nombClient = new JLabel("Nombre Completo :");
		nombClient.setHorizontalAlignment(SwingConstants.LEFT);
		nombClient.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		nombClient.setBounds(10, 80, 215, 20);
		contentPane.add(nombClient);
		
		espacNombCliente = new JTextField();
		espacNombCliente.setHorizontalAlignment(SwingConstants.LEFT);
		espacNombCliente.setBounds(190, 82, 203, 20);
		contentPane.add(espacNombCliente);
		
		apellPat = new JLabel("Apellido Paterno :");
		apellPat.setHorizontalAlignment(SwingConstants.LEFT);
		apellPat.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		apellPat.setBounds(10, 130, 215, 20);
		contentPane.add(apellPat);
		
		espacApellPCli = new JTextField();
		espacApellPCli.setHorizontalAlignment(SwingConstants.LEFT);
		espacApellPCli.setBounds(190, 132, 203, 20);
		contentPane.add(espacApellPCli);
		
		apellMat = new JLabel("Apellido Materno :");
		apellMat.setHorizontalAlignment(SwingConstants.LEFT);
		apellMat.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		apellMat.setBounds(10, 180, 215, 20);
		contentPane.add(apellMat);
		
		espacApellMCli = new JTextField();
		espacApellMCli.setHorizontalAlignment(SwingConstants.LEFT);
		espacApellMCli.setBounds(190, 182, 203, 20);
		contentPane.add(espacApellMCli);
		
		correo = new JLabel("Correo Electronico :");
		correo.setHorizontalAlignment(SwingConstants.LEFT);
		correo.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		correo.setBounds(10, 230, 215, 20);
		contentPane.add(correo);
		
		espacCorreCli = new JTextField();
		espacCorreCli.setHorizontalAlignment(SwingConstants.LEFT);
		espacCorreCli.setBounds(190, 232, 275, 20);
		contentPane.add(espacCorreCli);
		
		direccion = new JLabel("Direccion :");
		direccion.setHorizontalAlignment(SwingConstants.LEFT);
		direccion.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		direccion.setBounds(10, 280, 215, 20);
		contentPane.add(direccion);
		
		espacDirecCli = new JTextField();
		espacDirecCli.setHorizontalAlignment(SwingConstants.LEFT);
		espacDirecCli.setBounds(190, 282, 275, 20);
		contentPane.add(espacDirecCli);
		
		telefono = new JLabel("Telefono :");
		telefono.setHorizontalAlignment(SwingConstants.LEFT);
		telefono.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		telefono.setBounds(10, 330, 215, 20);
		contentPane.add(telefono);
		
		espacTelfCli = new JTextField();
		espacTelfCli.setHorizontalAlignment(SwingConstants.LEFT);
		espacTelfCli.setBounds(190, 332, 150, 20);
		contentPane.add(espacTelfCli);

		garantia = new JLabel("Garantia :");
		garantia.setHorizontalAlignment(SwingConstants.LEFT);
		garantia.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		garantia.setBounds(10, 380, 215, 20);
		contentPane.add(garantia);
		
		espacGaranCli = new JTextField();
		espacGaranCli.setHorizontalAlignment(SwingConstants.LEFT);
		espacGaranCli.setBounds(190, 382, 225, 20);
		contentPane.add(espacGaranCli);
		
		guardar = new JButton("Guardar");
		guardar.setHorizontalAlignment(SwingConstants.CENTER);
		guardar.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		guardar.setBounds(240, 450, 120, 19);
		guardar.setBackground(new Color(245, 245, 245));
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuardarInformacionCliente();
			}
		});
		contentPane.add(guardar);
	}

	private void GuardarInformacionCliente() {
		String nombreC = espacNombCliente.getText();
		String apellPC = espacApellPCli.getText();
		String apellMC = espacApellMCli.getText();
		String direcC = espacDirecCli.getText();
		String telefC = espacTelfCli.getText();
		String correoC = espacCorreCli.getText();
		double garanC = Double.parseDouble(espacGaranCli.getText());
		Pedido pedidoCliente = new Pedido(nombreC, apellPC, apellMC, direcC, telefC, correoC, garanC);
		JOptionPane.showConfirmDialog(null,"Los datos fueron guardados satisfactoriamente ");
		BD.bd.guardarPedidoCliente(pedidoCliente);
		this.setVisible(false);
	}
	
}
