package Datos;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable, DatoTabla {

	private String nombreCliente;
	private String apellidoPaternoCliente;
	private String apellidoMaternoCliente;
	private String direccionCliente;
	private String telefonoCliente;
	private double garantia;
	private ArrayList<Producto> productos;
	
	public Pedido(String nombreCliente, String apellidoP, String apellidoM){

	}

	@Override
	public String[] getNombresVariables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getValores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean compararValores(Object[] valores) {
		// TODO Auto-generated method stub
		return false;
	}

}
