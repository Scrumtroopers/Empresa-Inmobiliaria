package Datos;

/**
*Esta interfaz sera para los objetos que se visualizaran en Tablas, facilitando la obtencion de datos
* @author Bernardo
*/

public interface DatoTabla {
	public String[] getNombresVariables(); //Obtiene los nombres de los atributos de la clase
	public Object[] getValores(); //Obtiene los valores de los atributos de la clase
	public String toString(); //Obtiene una representacion del objeto en String
	public boolean compararValores(Object[] valores);
}
