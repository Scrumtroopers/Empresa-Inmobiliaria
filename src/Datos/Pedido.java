package Datos;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {

	private String nombreCliente;
	private String apellidoPaternoCliente;
	private String apellidoMaternoCliente;
	private String correoCliente;
	private String direccionCliente;
	private String telefonoCliente;
	private double garantia;
	private ArrayList<Producto> productos;
	
	public Pedido(String nombreCliente, String apellidoP, String apellidoM, String direccion, String telefono, String correo, double garantia){
		this.setNombreCliente(nombreCliente);
		this.setApellidoPaternoCliente(apellidoP);
		this.setApellidoMaternoCliente(apellidoM);
		this.setDireccionCliente(direccion);
		this.setTelefonoCliente(telefono);
		this.setCorreoCliente(correo);
		this.productos = new ArrayList<Producto>();
	}
	
	public void agregarProducto(Producto p){
		productos.add(p);
	}
	
	public void eliminarProducto(Producto p){
		productos.remove(p);
	}
	
	public ArrayList<Producto> getProductos(){
		return productos;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoPaternoCliente() {
		return apellidoPaternoCliente;
	}

	public void setApellidoPaternoCliente(String apellidoPaternoCliente) {
		this.apellidoPaternoCliente = apellidoPaternoCliente;
	}

	public String getApellidoMaternoCliente() {
		return apellidoMaternoCliente;
	}

	public void setApellidoMaternoCliente(String apellidoMaternoCliente) {
		this.apellidoMaternoCliente = apellidoMaternoCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public double getGarantia() {
		return garantia;
	}

	public void setGarantia(double garantia) {
		this.garantia = garantia;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}
}
