package interfaz;

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


import Datos.Compra;

public class VentanaModificarCompra extends JFrame{
	
	public static VentanaModificarCompra ventana;
	
	
	private JTextField tfFecha;
	private JTextField tfNIT;
	private JTextField tfEmpresa;
	private JTextField tfNroFactura;
	private JTextField tfNroDUI;
	private JTextField tfNroAutorizacion;
	private JTextField tfImporteTotal;
	private JTextField tfImporteNoCreditoFiscal;
	private JTextField tfDescuento;
	private JTextField tfCodigoControl;
	private JTextField tfTipoCompra;
	
	private Compra compra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaModificarCompra window = new VentanaModificarCompra();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaModificarCompra() {
		initialize();
	}
	
	public VentanaModificarCompra(Compra compra) {
		this.compra = compra;
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {		
		setBounds(100, 100, 419, 415);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel titulo = new JLabel("Agregar/Editar Compra");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		titulo.setBounds(130, 11, 159, 14);
		getContentPane().add(titulo);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 47, 46, 14);
		getContentPane().add(lblFecha);
		
		tfFecha = new JTextField();
		tfFecha.setBounds(53, 44, 86, 20);
		getContentPane().add(tfFecha);
		tfFecha.setColumns(10);
		
		JLabel lblNit = new JLabel("NIT:");
		lblNit.setBounds(182, 47, 45, 14);
		getContentPane().add(lblNit);
		
		tfNIT = new JTextField();
		tfNIT.setBounds(238, 44, 150, 20);
		getContentPane().add(tfNIT);
		tfNIT.setColumns(10);
		SNumeros(tfNIT);
		
		JLabel lblNombreY = new JLabel("Nombre y Apellidos/Razon Social:");
		lblNombreY.setBounds(10, 75, 194, 14);
		getContentPane().add(lblNombreY);
		
		tfEmpresa = new JTextField();
		tfEmpresa.setBounds(10, 97, 378, 20);
		getContentPane().add(tfEmpresa);
		tfEmpresa.setColumns(10);
		
		JLabel lblNroDeFactura = new JLabel("Nro. de Factura:");
		lblNroDeFactura.setBounds(10, 123, 105, 14);
		getContentPane().add(lblNroDeFactura);
		
		tfNroFactura = new JTextField();
		tfNroFactura.setBounds(145, 122, 243, 20);
		getContentPane().add(tfNroFactura);
		tfNroFactura.setColumns(10);
		SNumeros(tfNroFactura);
		
		JLabel lblNroDeDui = new JLabel("Nro. de DUI:");
		lblNroDeDui.setBounds(10, 148, 95, 14);
		getContentPane().add(lblNroDeDui);
		
		tfNroDUI = new JTextField();
		tfNroDUI.setBounds(145, 147, 243, 20);
		getContentPane().add(tfNroDUI);
		tfNroDUI.setColumns(10);
		
		JLabel lblNroDeAutorizacion = new JLabel("Nro. de Autorizacion:");
		lblNroDeAutorizacion.setBounds(10, 173, 129, 14);
		getContentPane().add(lblNroDeAutorizacion);
		
		tfNroAutorizacion = new JTextField();
		tfNroAutorizacion.setBounds(145, 172, 243, 20);
		getContentPane().add(tfNroAutorizacion);
		tfNroAutorizacion.setColumns(10);
		SNumeros(tfNroAutorizacion);
		
		JLabel lblImporteTotalDe = new JLabel("Importe Total de la Compra:");
		lblImporteTotalDe.setBounds(10, 198, 168, 14);
		getContentPane().add(lblImporteTotalDe);
		
		tfImporteTotal = new JTextField();
		tfImporteTotal.setBounds(214, 197, 174, 20);
		getContentPane().add(tfImporteTotal);
		tfImporteTotal.setColumns(10);
		SNumeros2(tfImporteTotal);
		
		JLabel lblImporteNoSujeto = new JLabel("Importe No Sujeto a Credito Fiscal:");
		lblImporteNoSujeto.setBounds(10, 227, 194, 14);
		getContentPane().add(lblImporteNoSujeto);
		
		tfImporteNoCreditoFiscal = new JTextField();
		tfImporteNoCreditoFiscal.setBounds(214, 223, 174, 20);
		getContentPane().add(tfImporteNoCreditoFiscal);
		tfImporteNoCreditoFiscal.setColumns(10);
		SNumeros2(tfImporteNoCreditoFiscal);
		
		JLabel lblNewLabel = new JLabel("Descuentos, Bonificaciones y Rebajas Obtenidas:");
		lblNewLabel.setBounds(10, 249, 296, 14);
		getContentPane().add(lblNewLabel);
		
		tfDescuento = new JTextField();
		tfDescuento.setBounds(302, 248, 86, 20);
		getContentPane().add(tfDescuento);
		tfDescuento.setColumns(10);
		SNumeros2(tfDescuento);
		
		JLabel lblCodigoDeControl = new JLabel("Codigo de Control:");
		lblCodigoDeControl.setBounds(10, 274, 129, 14);
		getContentPane().add(lblCodigoDeControl);
		
		tfCodigoControl = new JTextField();
		tfCodigoControl.setBounds(145, 273, 243, 20);
		getContentPane().add(tfCodigoControl);
		tfCodigoControl.setColumns(10);
		
		JLabel lblTipoDeCompra = new JLabel("Tipo de Compra:");
		lblTipoDeCompra.setBounds(10, 301, 105, 14);
		getContentPane().add(lblTipoDeCompra);
		
		tfTipoCompra = new JTextField();
		tfTipoCompra.setBounds(145, 300, 108, 20);
		getContentPane().add(tfTipoCompra);
		tfTipoCompra.setColumns(10);
		SNumeros(tfTipoCompra);
		
		JButton btnGuardar = nuevoBoton(180, 330, "Guardar");		
		getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				guardar();

			}						
		});
		
		JButton btnCancelar = nuevoBoton(290, 330, "Cancelar");				
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cancelar();

			}			
		});
	}
	
	private JButton nuevoBoton(int x, int y, String txt){
		JButton boton = new JButton(txt);
		boton.setBackground(new Color(245, 245, 245));
		boton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		boton.setBounds(x, y, 100, 30);
		return boton;
	}
	
	private void guardar() {
		int nro = 1;
		Date fecha=new Date(tfFecha.getText());
		long nit = getNumero2(tfNIT);
		String empresa = tfEmpresa.getText();
		long numFactura=getNumero2(tfNroFactura);
		String numDUI=tfNroDUI.getText();
		long numAutorizacion=getNumero2(tfNroAutorizacion);
		double importeTotal=getNumero(tfImporteTotal);
		double importeNoCreditoFiscal=getNumero(tfImporteNoCreditoFiscal);
		double descuento=getNumero(tfDescuento);
		String codigoControl=tfCodigoControl.getText();
		int tipoCompra=getNumero3(tfTipoCompra);
		Compra compra = new Compra(nro, fecha, nit, empresa, numFactura, numDUI, numAutorizacion, importeTotal, importeNoCreditoFiscal, descuento, codigoControl, tipoCompra);
		
	}
	
	private void cancelar() {
		this.setVisible(false);		
	}
	
	private void SNumeros(JTextField a){
		a.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char c=e.getKeyChar();
				if(!Character.isDigit(c)){
					getToolkit().beep();
					e.consume();
				}
			}
		});
	}
	
	private void SNumeros2(JTextField a){
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
	
	private long getNumero2(JTextField tf){
		long numero=0;
		String num = tf.getText();
		try {numero = Long.parseLong(num);
		} catch( Exception e){
		}
		return numero;
	}
	
	private int getNumero3(JTextField tf){
		int numero=0;
		String num = tf.getText();
		try {numero = Integer.parseInt(num);
		} catch( Exception e){
		}
		return numero;
	}
}
