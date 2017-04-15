import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Almacen_DB {
	
	private ArrayList<String[]> productos = null;
	private String almacen_ID;
	
	
	public Almacen_DB(String id){
		productos = new ArrayList<String[]>();
		almacen_ID = id;
	}
	
	/*
	 *  Metodo para añadir un producto
	 */
	public void añadir_Producto(String[] producto){
		productos.add(producto);
	}
	
	
	/*
	 *  Metodo para eliminar un producto segun su ID
	 */
	public void eliminar_Producto(String id){
		for(int c=0;c<productos.size();c++){
			String[] temp = productos.get(c);
			if (temp[0].equals(id)){
				productos.remove(c);
				break;
			}
		}
	}
	
	/*/ Metodo para reemplazar el campo 'index' de un producto por el valor de 'update'
	 *  index : 1 : id
	 *  		2 : nombre
	 *  		3 : marca
	 *  		4 : modelo
	 *  		5 : numero de unidades
	 */
	public void editar_Producto(int index, String id, String update){
		for(String[] producto:productos){
			if (producto[0].equals(id)){
				producto[index] = update;
				break;
			}
		}
	}
	
	/*
	 *  Metodo para buscar un producto segun su ID
	 */
	public String[] buscar_Producto(String id){
		String[] res = null;
		for(String[] producto:productos){
			if (producto[0].equals(id)){
				res = producto;
				break;
			}
		}	
		return (res == null)?null:res.clone();
	}
	
	/*
	 *  Metodo para guardar la base de datos de productos
	 */
	public void guardar_DB_Almacen(){
		try {
			FileOutputStream fout = new FileOutputStream("Files\\DB_Almacen_"+almacen_ID+".db");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(productos);
			oos.close();
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 
	 * Metodo para cargar la base de datos de productos
	 */
	public void cargar_DB_Almacen(String id){
		try {
			FileInputStream fis = new FileInputStream("Files\\DB_Almacen_"+id+".db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			productos = (ArrayList<String[]>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
