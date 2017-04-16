package Datos;

import java.io.Serializable;

/**
*
* @author Bernardo
*/

public class Almacen implements Serializable {
	
	private String nombre; //Nombre del almacen
	private String direccion; //Direccion del almacen
	private String telefono; //Telefono del alamcen
	
	public Almacen(String nombre, String direccion, String telefono){
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getDireccion(){
		return direccion;
	}
	
	public String getTelefono(){
		return telefono;
	}
}
