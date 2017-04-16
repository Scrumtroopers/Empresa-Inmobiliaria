package Datos;

import java.io.Serializable;

/**
* Esta clase es el modelo del Producto que se guardara en la Base de Datos general
* @author Bernardo
*/

public class Producto implements Serializable, DatoTabla{
	
	private int unidades; //Unidades totales del producto
	private String nombre; 
	private String marca; //Marca o empresa
	private String modelo; //Modelo o version
	private double precioVenta;
	private double precioCompra;
	private Almacen almacen; //Esto es porque un producto estará en un almacen, simplemente para no complicarnos
	
	public Producto(int unidades, String nombre, String marca, String modelo, double precioVenta, double precioCompra, Almacen almacen){
		this.unidades = unidades;
		this.nombre = nombre;
		this.marca = marca;
		this.modelo = modelo;
		this.precioVenta = precioVenta;
		this.precioCompra = precioCompra;
		this.almacen = almacen;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getModelo(){
		return modelo;
	}
	
	public String getMarca(){
		return marca;
	}
	
	public double getPrecioVenta(){
		return precioVenta;
	}
	
	public double getPrecioCompra(){
		return precioCompra;
	}
	
	public Almacen getAlmacen(){
		return almacen;
	}
	
	public int getUnidades(){
		return unidades;
	}
	
	public void quitarUnidades(int num){
		unidades -= num;
	}
	
	/**
 	 * @return Devuelve una representacion en String de la instancia
	 */
	@Override
	public String toString(){
		return nombre+" "+marca+" "+modelo;
	}

	/**
 	 * @return Devuelve los nombres de los atributos de esta clase
	 */
	@Override
	public String[] getNombresVariables() {
		String[] nombres = {"Nombre", "Marca", "Modelo", "Precio Venta", "Precio Compra", "Unidades", "Almacen"};
		return nombres;
	}

	/**
 	 * @return Devuelve los valores de los atributos de esta clase
	 */
	@Override
	public Object[] getValores() {
		Object[] valores = {nombre, marca, modelo, precioVenta, precioCompra, unidades, almacen.toString()};
		return valores;
	}

	@Override
	public boolean compararValores(Object[] valores) {
		boolean iguales = true;
		Object[] vals = getValores();
		int i = 0;
		while(i < valores.length && iguales){
			iguales = vals[i].toString().equals(valores[i].toString());
			i++;
		}
		return iguales;
	}
	
	
}
