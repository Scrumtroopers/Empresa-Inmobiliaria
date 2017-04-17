package interfaz;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class VentanaAgregarProveedor extends JDialog{
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

    private JButton nuevoBoton(int x, int y, String txt){
		JButton boton = new JButton(txt);
		boton.setBackground(new Color(245, 245, 245));
		boton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		boton.setBounds(x, y, 150, 30);
		return boton;
	}
    
    public VentanaAgregarProveedor(Frame owner) {
        super(owner);
        createGUI();
    }
    
   public void createGUI(){
      setTitle("Registrar Nuevo Proveedor");
      setFont(new Font("Century Gothic", Font.BOLD, 18));
      setPreferredSize(new Dimension(480, 400));
      contentPane = new JPanel();
	  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	  contentPane.setLayout(null);
	  getContentPane().add(contentPane);
      pack();
	  setLocationRelativeTo(getParent()); 	

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
    			//	botonAgregarActionPerformed(evt);
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
 
      setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      setModal(true);
      setVisible(true);
    }
   
   
}
   
   
   /*http://stackoverflow.com/questions/30381351/how-to-open-a-jdialog-from-a-jframe
   http://stackoverflow.com/questions/8671322/change-jframe-to-jdialog
   https://www.google.com/search?client=safari&rls=en&q=how+to+update+jtable+from+another+jframe%3F&ie=UTF-8&oe=UTF-8
   http://stackoverflow.com/questions/25583002/jdialog-not-showing
   http://1bestcsharp.blogspot.com/2015/05/java-jtable-add-delete-update-row.html
   http://1bestcsharp.blogspot.com/2015/04/java-how-to-update-jtable-row-using-joptionpane-showinputdialog-in-java-netbeans.html
   */
    