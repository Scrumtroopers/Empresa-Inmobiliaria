package interfaz;

//import controller.BD;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.BD;
import Datos.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ventana_crear_Usuario extends JFrame {

    private JPanel contentPane;
    private JTextField textNombre;
    private JTextField textAP;
    private JTextField textAM;
    private JTextField textContrasena;
    private JTextField textNickName;
    private JSpinner spinnerDia;
    private JSpinner spinnerMes;
    private JSpinner spinnerAno;
    private JSpinner spinnerSexo;
    private JSpinner spinnerCategoria;

    /**
     * Launch the application.
     */
    public static void init() {
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
    	setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(390, 75, 493, 485);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblRegistrarte = new JLabel("Registro");
        lblRegistrarte.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegistrarte.setFont(new Font("Century Gothic", Font.BOLD, 18));
        lblRegistrarte.setBounds(150, 5, 174, 42);
        contentPane.add(lblRegistrarte);

        JLabel lblNombres = new JLabel("Nombre(s) :");
        lblNombres.setHorizontalAlignment(SwingConstants.LEFT);
        lblNombres.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        lblNombres.setBounds(15, 70, 100, 15);
        contentPane.add(lblNombres);

        textNombre = new JTextField();
        textNombre.setBounds(125, 70, 180, 20);
        textNombre.setFont(new Font("Century Gothic ", Font.PLAIN, 17));
        textNombre.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(textNombre);

        JLabel lblApellidoPaterno = new JLabel("Apellido Paterno :");
        lblApellidoPaterno.setHorizontalAlignment(SwingConstants.LEFT);
        lblApellidoPaterno.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        lblApellidoPaterno.setBounds(15, 110, 180, 20);
        contentPane.add(lblApellidoPaterno);

        textAP = new JTextField();
        textAP.setBounds(182, 113, 180, 20);
        textAP.setFont(new Font("Century Gothic ", Font.PLAIN, 17));
        textAP.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(textAP);

        JLabel lblApellidoMaterno = new JLabel("Apellido Materno :");
        lblApellidoMaterno.setHorizontalAlignment(SwingConstants.LEFT);
        lblApellidoMaterno.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        lblApellidoMaterno.setBounds(15, 150, 180, 20);
        contentPane.add(lblApellidoMaterno);

        textAM = new JTextField();
        textAM.setBounds(188, 153, 180, 20); 
        textAM.setFont(new Font("Century Gothic ", Font.PLAIN, 17));
        textAM.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(textAM);

        JLabel lblContraseaNueva = new JLabel("Contrase�a Nueva :");
        lblContraseaNueva.setHorizontalAlignment(SwingConstants.LEFT);
        lblContraseaNueva.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        lblContraseaNueva.setBounds(15, 193, 180, 20);
        contentPane.add(lblContraseaNueva);

        textContrasena = new JTextField();
        textContrasena.setBounds(200, 196, 120, 20);
        textContrasena.setFont(new Font("Century Gothic ", Font.PLAIN, 17));
        textContrasena.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(textContrasena);

        JLabel lblNickname = new JLabel("NickName :");
        lblNickname.setHorizontalAlignment(SwingConstants.LEFT);
        lblNickname.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        lblNickname.setBounds(15, 233, 110, 20);
        contentPane.add(lblNickname);

        textNickName = new JTextField();
        textNickName.setBounds(123, 235, 120, 20);
        textNickName.setFont(new Font("Century Gothic ", Font.PLAIN, 17));
        textNickName.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(textNickName);
        
        JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento :");
        lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
        lblFechaDeNacimiento.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        lblFechaDeNacimiento.setBounds(15, 273, 202, 20);
        contentPane.add(lblFechaDeNacimiento);

        spinnerDia = new JSpinner();
        spinnerDia.setModel(new SpinnerListModel(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        spinnerDia.setFont(new Font("Century Gothic", Font.PLAIN, 17));
        spinnerDia.setBounds(220, 275, 38, 22);
        contentPane.add(spinnerDia);

        spinnerMes = new JSpinner();
        spinnerMes.setModel(new SpinnerListModel(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
        spinnerMes.setFont(new Font("Century Gothic", Font.PLAIN, 17));
        spinnerMes.setBounds(265, 275, 38, 22);
        contentPane.add(spinnerMes);

        spinnerAno = new JSpinner();
        spinnerAno.setModel(new SpinnerListModel(new String[]{"1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008"}));
        spinnerAno.setFont(new Font("Century Gothic", Font.PLAIN, 17));
        spinnerAno.setBounds(310, 275, 60, 22);
        contentPane.add(spinnerAno);

        JLabel lblSexo = new JLabel("Sexo :");
        lblSexo.setBounds(15, 315, 70, 15);
        lblSexo.setHorizontalAlignment(SwingConstants.LEFT);
        lblSexo.setFont(new Font("Century Gothic", Font.PLAIN, 17));
        contentPane.add(lblSexo);

        spinnerSexo = new JSpinner();
        spinnerSexo.setModel(new SpinnerListModel(new String[]{"FEMENINO", "MASCULINO"}));
        spinnerSexo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        spinnerSexo.setBounds(70, 315, 98, 20);
        contentPane.add(spinnerSexo);

        JLabel lblCategoria = new JLabel("Categoria :");
        lblCategoria.setBounds(15, 350, 120, 24);
        lblCategoria.setHorizontalAlignment(SwingConstants.LEFT);
        lblCategoria.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        contentPane.add(lblCategoria);

        spinnerCategoria = new JSpinner();
        spinnerCategoria.setModel(new SpinnerListModel(new String[]{"EMPLEADO", "ADMINISTRADOR_ALMACEN", "ADMINISTRADOR_INVENTARIO", "COMPRADOR"}));
        spinnerCategoria.setBounds(120, 355, 240, 20);
        spinnerCategoria.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        contentPane.add(spinnerCategoria);
        
        JButton btnRegistrase = new JButton("Registrase");
        btnRegistrase.setHorizontalAlignment(SwingConstants.CENTER);
        btnRegistrase.setBackground(new Color(245, 245, 245));
        btnRegistrase.setBounds(180, 414, 145, 28);
        btnRegistrase.setFont(new Font("Century Gothic", Font.BOLD, 18));
        btnRegistrase.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		registrar();
        	}
        	
        });
        contentPane.add(btnRegistrase);
        
      

    }

    private void registrar() {
        String nickname = textNickName.getText();
        String nombre = textNickName.getText();
        String apellidoP = textAP.getText();
        String apellidoM = textAM.getText();
        String clave = textContrasena.getText();
        String dia = (String) spinnerDia.getValue();
        String mes = (String) spinnerMes.getValue();
        String anio = (String) spinnerAno.getValue();
        Date fecha = new Date(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia));
        String sexo = (String) spinnerSexo.getValue();
        String cargo = (String) spinnerCategoria.getValue();
        if (BD.bd.disponibleUsuario(nickname)) {
        	Usuario nuevo = new Usuario(nickname, nombre, apellidoP, apellidoM, clave, fecha, sexo, cargo);
            //String[] usuario = {nickname, nombre, apellidoP, apellidoM, clave, fecha, sexo, cargo};
            BD.bd.guardarUsuario(nuevo);
            JOptionPane.showMessageDialog(null, "REGISTRO SATISFACTORIAMENTE", " ", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            LogIn.init();
            
        }else{
            JOptionPane.showMessageDialog(null, "ESTE USUARIO YA EXISTE", " ", JOptionPane.WARNING_MESSAGE);
        }
    }
}

