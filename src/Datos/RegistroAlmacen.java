package Datos;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

/**
* Esta clase es el modelo de un registro de un almacen
* @author Bernardo
*/

public class RegistroAlmacen implements Serializable, DatoTabla{
	
	private Date fecha; //Fecha del registro
	private Almacen almacen; //Almacen afectado
	private Producto producto; //Producto afectado
	private Usuario usuarioResponsable; //Usuario responsable del movimiento
	private int unidadesAfectadas; // Las unidades afectadas
	private String tipoAccion; //Venta, Compra, eliminacion, agregacion

	
	public RegistroAlmacen(Almacen almacen, Producto producto, Usuario usuarioResponsable, int unidadesAfectadas, String tipoAccion){
		this.almacen = almacen;
		this.producto = producto;
		this.usuarioResponsable = usuarioResponsable;
		this.unidadesAfectadas = unidadesAfectadas;
		this.tipoAccion = tipoAccion;
		fecha = Date.from(Instant.now());
	}
	
	public Producto getProducto(){
		return producto;
	}
	
	public Almacen getAlmacen(){
		return almacen;
	}
	
	public Usuario getUsuario(){
		return usuarioResponsable;
	}
	
	public int getUnidadesAfectadas(){
		return unidadesAfectadas;
	}
	
	public Date getFechaRegistro(){
		return fecha;
	}
	
	/**
 	 * @return Devuelve una representacion en String de la instancia
	 */
	@Override
	public String toString(){
		return fecha.toString();
	}
	
	/**
 	 * @return Devuelve los nombres de los atributos de esta clase
	 */
	@Override
	public String[] getNombresVariables() {
		String[] vars = {"Fecha", "Almacen", "Producto", "Usuario Responsable", "Unidades", "Tipo Accion"};
		return vars;
	}

	/**
 	 * @return Devuelve los valores de los atributos de esta clase
	 */
	@Override
	public Object[] getValores() {
		Object[] vals = new Object[]{fecha, almacen.toString(), producto.toString(), usuarioResponsable.toString(), unidadesAfectadas, tipoAccion};
		return vals;
	}

}
