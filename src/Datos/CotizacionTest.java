package view;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class CotizacionTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testImporteTotal() {
		Object[] datos={"00002",new Date("2017/04/15"),new Date("2017/05/15"),(long)175072028,"Toyota",new Producto("automovil"),(double)15000,1, (double)15000,(double)104400};
		Cotizacion cotizacion = new Cotizacion((String)datos[0], (Date)datos[1], (Date)datos[2], (long)datos[3], (String)datos[4], (Producto)datos[5], (double)datos[6], (int)datos[7]); 
		assertEquals(15000, cotizacion.importeTotal(),0.001);
		assertEquals(104400, cotizacion.importeTotalBs(6.96),0.001);	
	}
	
	@Test
	public void testEquals() {
		Object[] datos={"00002",new Date("2017/04/15"),new Date("2017/05/15"),(long)175072028,"Toyota",new Producto("automovil"),(double)15000,1, (double)15000,(double)104400};
		Object[] datos2={"00003",new Date("2017/04/15"),new Date("2017/05/15"),(long)175072028,"Toyota",new Producto("automovil"),(double)15000,1, (double)15000,(double)104400};
		Cotizacion cotizacion = new Cotizacion((String)datos[0], (Date)datos[1], (Date)datos[2], (long)datos[3], (String)datos[4], (Producto)datos[5], (double)datos[6], (int)datos[7]); 
		Cotizacion cotizacion2 = new Cotizacion((String)datos2[0], (Date)datos2[1], (Date)datos2[2], (long)datos2[3], (String)datos2[4], (Producto)datos2[5], (double)datos2[6], (int)datos2[7]); 
		assertTrue(cotizacion.equals(cotizacion));
		assertFalse(cotizacion.equals(cotizacion2));
	}
	
	

}
