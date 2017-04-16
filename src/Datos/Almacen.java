package Datos;

import java.io.Serializable;

/**
* Esta clase es el modelo que representa a un Almacen
* @author Bernardo
*/

public class Almacen implements Serializable, DatoTabla {
	
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
	
	/**
 	 * @return Devuelve una representacion en String de la instancia
	 */
	@Override
	public String toString(){
		return nombre;
	}

	/**
 	 * @return Devuelve los nombres de los atributos de esta clase
	 */
	@Override
	public String[] getNombresVariables() {
		String[] nombres = {"Nombre", "Direccion", "Telefono"};
		return nombres;
	}

	/**
 	 * @return Devuelve los valores de los atributos de esta clase
	 */
	@Override
	public Object[] getValores() {
		Object[] valores = {nombre, direccion, telefono};
		return valores;
	}

	@Override
	public boolean compararValores(Object[] valores) {
		boolean iguales = true;
		Object[] vals = getValores();
		int i = 0;
		while(i < valores.length && iguales){
			iguales = vals[i] == valores[i];
			i++;
		}
		return iguales;
	}
}
