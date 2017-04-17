package Datos;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class CotizacionTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testImporteTotal() {
		
		Producto p = new Producto(10, "Laptop", "HP", "SGHA", 1500, 1000, new Almacen("Sacaba", "Sacaba KM 10", "44444"));
		
		Object[] datos={"00002",new Date("2017/04/15"),new Date("2017/05/15"),(long)175072028,"Toyota", p ,(double)15000,1, (double)15000,(double)104400};
		Cotizacion cotizacion = new Cotizacion((String)datos[0], (Date)datos[1], (Date)datos[2], (long)datos[3], (String)datos[4], (Producto)datos[5], (double)datos[6], (int)datos[7], 6); 
		assertEquals(15000, cotizacion.importeTotal(),0.001);
		assertEquals(104400, cotizacion.importeTotalBs(),0.001);	
	}
	
	@Test
	public void testEquals() {
		Producto p = new Producto(10, "Laptop", "HP", "SGHA", 1500, 1000, new Almacen("Sacaba", "Sacaba KM 10", "44444"));
		Producto p2 = new Producto(10, "Laptop", "Toshiba", "sjhdhfskj", 2000, 1500, new Almacen("Sacaba", "Sacaba KM 10", "44444"));
		Object[] datos={"00002",new Date("2017/04/15"),new Date("2017/05/15"),(long)175072028,"Toyota",p,(double)15000,1, (double)15000,(double)104400};
		Object[] datos2={"00003",new Date("2017/04/15"),new Date("2017/05/15"),(long)175072028,"Toyota",p2,(double)15000,1, (double)15000,(double)104400};
		Cotizacion cotizacion = new Cotizacion((String)datos[0], (Date)datos[1], (Date)datos[2], (long)datos[3], (String)datos[4], (Producto)datos[5], (double)datos[6], (int)datos[7], 6); 
		Cotizacion cotizacion2 = new Cotizacion((String)datos2[0], (Date)datos2[1], (Date)datos2[2], (long)datos2[3], (String)datos2[4], (Producto)datos2[5], (double)datos2[6], (int)datos2[7], 6); 
		assertTrue(cotizacion.equals(cotizacion));
		assertFalse(cotizacion.equals(cotizacion2));
	}
	
	

}
