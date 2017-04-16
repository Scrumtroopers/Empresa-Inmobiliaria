package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaModificarCotizacion extends JFrame{

	private JFrame frame;
	private JTextField tffecha;
	private JTextField tfFechaVencimiento;
	private JTextField tfNit;
	private JTextField tfEmpresa;
	private JTextField tfProducto;
	private JTextField tfValorUnitario;
	private JTextField tfCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaModificarCotizacion window = new VentanaModificarCotizacion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaModificarCotizacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 472, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titulo = new JLabel("Agregar/Editar Cotizacion");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(146, 11, 185, 14);
		frame.getContentPane().add(titulo);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(21, 68, 46, 14);
		frame.getContentPane().add(lblFecha);
		
		tffecha = new JTextField();
		tffecha.setBounds(67, 65, 100, 20);
		frame.getContentPane().add(tffecha);
		tffecha.setColumns(10);
		
		JLabel lblFechaDeVencimiento = new JLabel("Fecha de Vencimiento:");
		lblFechaDeVencimiento.setBounds(177, 68, 130, 14);
		frame.getContentPane().add(lblFechaDeVencimiento);
		
		tfFechaVencimiento = new JTextField();
		tfFechaVencimiento.setBounds(330, 65, 100, 20);
		frame.getContentPane().add(tfFechaVencimiento);
		tfFechaVencimiento.setColumns(10);
		
		JLabel lblNit = new JLabel("NIT:");
		lblNit.setBounds(21, 107, 46, 14);
		frame.getContentPane().add(lblNit);
		
		tfNit = new JTextField();
		tfNit.setBounds(67, 104, 100, 20);
		frame.getContentPane().add(tfNit);
		tfNit.setColumns(10);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(177, 107, 69, 14);
		frame.getContentPane().add(lblEmpresa);
		
		tfEmpresa = new JTextField();
		tfEmpresa.setBounds(245, 104, 185, 20);
		frame.getContentPane().add(tfEmpresa);
		tfEmpresa.setColumns(10);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(21, 146, 63, 14);
		frame.getContentPane().add(lblProducto);
		
		tfProducto = new JTextField();
		tfProducto.setBounds(82, 143, 164, 20);
		frame.getContentPane().add(tfProducto);
		tfProducto.setColumns(10);
		
		JLabel lblValorUnitario = new JLabel("Valor Unitario($us):");
		lblValorUnitario.setBounds(21, 179, 115, 14);
		frame.getContentPane().add(lblValorUnitario);
		
		tfValorUnitario = new JTextField();
		tfValorUnitario.setBounds(146, 176, 100, 20);
		frame.getContentPane().add(tfValorUnitario);
		tfValorUnitario.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(256, 179, 53, 14);
		frame.getContentPane().add(lblCantidad);
		
		tfCantidad = new JTextField();
		tfCantidad.setBounds(319, 176, 100, 20);
		frame.getContentPane().add(tfCantidad);
		tfCantidad.setColumns(10);
		
		JButton btnGuardar = nuevoBoton(230,201,"Guardar");		
		frame.getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				guardar();
				
			}			
		});
		
		JButton btnCancelar = nuevoBoton(340,201,"Cancelar");	
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cancelar();
				
			}			
		});
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblYyyymmdd = new JLabel("yyyy/mm/dd");
		lblYyyymmdd.setBounds(82, 40, 79, 14);
		frame.getContentPane().add(lblYyyymmdd);
		
		JLabel label = new JLabel("yyyy/mm/dd");
		label.setBounds(354, 40, 79, 14);
		frame.getContentPane().add(label);
	}
	
	private JButton nuevoBoton(int x, int y, String txt){
		JButton boton = new JButton(txt);
		boton.setBackground(new Color(245, 245, 245));
		boton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		boton.setBounds(230, 219, 100, 30);
		return boton;
	}
	
	public void guardar(){
		String codigoCot="0001";
		Date fecha=new Date(tffecha.getText());
		Date fechaVenc=new Date(tfFechaVencimiento.getText());
		long NIT=Long.parseLong(tfNit.getText());
		String empresa=tfEmpresa.getText();
		Producto producto = new Producto(tfProducto.getText());
		double valorUni = Double.parseDouble(tfValorUnitario.getText());
		int cantidad= Integer.parseInt(tfCantidad.getText());		
		Cotizacion cotizacion = new Cotizacion(codigoCot, fecha, fechaVenc, NIT, empresa, producto, valorUni, cantidad);
		System.out.println(cotizacion.getCodigoCot());
	}
	
	public void cancelar(){
		System.exit(1);
	}
	
	private void SNumeros(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                  char c=e.getKeyChar();
                  if(!Character.isDigit(c)&&c!='.'){
                      getToolkit().beep();
                      e.consume();
                  }
            }
        });
	}

	private double getNumero(JTextField tf){
		double numero=0.0;
		String num = tf.getText();
		
	     try {numero = Double.parseDouble(num);
		
	     } catch( Exception e){
	    	 	
	     }
	     return numero;
	     
	}
}
