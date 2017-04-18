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
import javax.swing.border.EmptyBorder;

import Datos.BD;
import Datos.Proveedor;
	
public class VentanaAgregarProveedor extends JFrame{
	
	public static VentanaAgregarProveedor ventana;
    private JPanel contentPane;
	private JLabel titulo;
	private JLabel labelNombre;
	private JLabel labelApellidoP;
	private JLabel labelApellidoM;
	private JLabel labelTelefono;
	private JLabel labelCelular;
	private JLabel labelDetalleP;
	private JButton botonRegistrar;
	private JButton botonCancelar;
	private JTextField textNombre;
	private JTextField textApellidoP;
	private JTextField textApellidoM;
	private JTextField textTelefono;
	private JTextField textCelular;
	private JTextField textDetalleP;

    private JButton nuevoBoton(int x, int y, String txt){
		JButton boton = new JButton(txt);
		boton.setBackground(new Color(245, 245, 245));
		boton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		boton.setBounds(x, y, 150, 30);
		return boton;
	}
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				VentanaAgregarProveedor.ventana = new VentanaAgregarProveedor();
				VentanaAgregarProveedor.ventana.setVisible(true);
			}
		});
	}
    
    public VentanaAgregarProveedor() {
      setResizable(false);
      setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
 	  setBounds(450, 75, 480, 400);
      setTitle("Registrar Nuevo Proveedor");
      setFont(new Font("Century Gothic", Font.BOLD, 18));
      contentPane = new JPanel();
	  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	  setContentPane(contentPane);
	  contentPane.setLayout(null);
		
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
    			botonAgregarActionPerformed(evt);
    		}
	  });
	  contentPane.add(botonRegistrar);
    		
	  textNombre = new JTextField();
	  textNombre.setBounds(180, 50, 130, 20);
	  contentPane.add(textNombre);
    		
	  textApellidoP = new JTextField();
	  textApellidoP.setBounds(180, 95, 130, 20);
	  contentPane.add(textApellidoP);
    		
	  textApellidoM= new JTextField();
	  textApellidoM.setBounds(180, 140, 130, 20);
	  contentPane.add(textApellidoM);
    		
	  textTelefono = new JTextField();
	  textTelefono.setBounds(180, 185, 130, 20);
	  contentPane.add(textTelefono);
    		
	  textCelular = new JTextField();
	  textCelular.setBounds(180, 230, 130, 20);
	  contentPane.add(textCelular);
    		
      textDetalleP = new JTextField();
      textDetalleP.setBounds(180, 275, 130, 20);
      contentPane.add(textDetalleP);		

      botonCancelar = nuevoBoton(50, 340, "Cancelar");
      botonCancelar.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent evt) {
			  int resultado = JOptionPane.showConfirmDialog(null, "Esta Seguro?","Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
			  if (resultado == JOptionPane.YES_OPTION || resultado == JOptionPane.CANCEL_OPTION) System.exit(0);
		  }
	  });
	  contentPane.add(botonCancelar);
    }
   
   private void botonAgregarActionPerformed(ActionEvent evt) {
		Proveedor prov = new Proveedor(textNombre.getText(), textApellidoP.getText(),
				textApellidoM.getText(),Integer.parseInt(textTelefono.getText()),
				Integer.parseInt(textCelular.getText()),textDetalleP.getText());
		BD.bd.guardarProveedor(prov);
		JOptionPane.showMessageDialog(null, "REGISTRO SATISFACTORIAMENTE", " ", JOptionPane.INFORMATION_MESSAGE);
		setVisible(false);
	}
   
}


