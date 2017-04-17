import Datos.BD;
import interfaz.*;
import sun.rmi.runtime.Log;
public class Principal {

	public static void main(String[] args) {
		System.out.println("Scrumtroopers");
		try{
			BD.cargarDB();
		}
		catch(Exception e){
			BD.bd = new BD();
		}
		//LogIn.init();
		VentanaCotizaciones.ventana = new VentanaCotizaciones("Ventana Cotizaciones");
		VentanaCotizaciones.ventana.setVisible(true);
		
	}
}
