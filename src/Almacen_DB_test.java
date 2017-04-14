import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Almacen_DB_test {

	private Almacen_DB almacen; 
	private String almacen_id = "test";
	
	@Before
	public void setUp() throws Exception {
		almacen = new Almacen_DB(almacen_id);
	}

	@Test
	public void test() {
		String[] producto_01 = {"504", "Laptop", "Toshiba", "5DHGS", "1"};
		String[] producto_02 = {"1001", "Lavadora", "Patinar", "XGAH", "2"};
		String[] producto_03 = {"250", "Television", "Escalar", "SHUJHA", "5"};
		almacen.añadir_Producto(producto_01);
		almacen.añadir_Producto(producto_02);
		almacen.añadir_Producto(producto_03);
		assertArrayEquals(producto_01, almacen.buscar_Producto("504"));			// test de buscar producto por ID
		almacen.editar_Producto(4, "504", "10");
		assertNull(almacen.buscar_Producto("1"));								// test de buscar producto por id que no existe
		almacen.guardar_DB_Almacen();
		almacen.cargar_DB_Almacen(almacen_id);
		assertArrayEquals(producto_02, almacen.buscar_Producto("1001"));		// test de persistencia de la base de datos (guardar y recuperar)
		
	}


}
