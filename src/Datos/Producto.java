package Datos;

/**
*
* @author Bernardo
*/

public class Producto {
	
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
}
