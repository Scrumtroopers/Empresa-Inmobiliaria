package Datos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ariel
 */
public class BD implements Serializable{
    
    public static BD bd;

    private ArrayList<Usuario> usuarios;
    //private static ArrayList<Proveedor> proveedores = new ArrayList<>();
    private ArrayList<Producto> productos;
    private ArrayList<Almacen> almacenes;
    private ArrayList<RegistroAlmacen> registroAlmacenes;
    
    public BD(){
        usuarios = new ArrayList<>();
        productos = new ArrayList<>();
        almacenes = new ArrayList<>();
        registroAlmacenes = new ArrayList<>();
    }

    //******************USUARIO****************************
    public void guardarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        guardarDB();
    }

    public Usuario getUsuario(String nickname, String clave) {
        for (Usuario usuario : usuarios) {

            if (usuario.getNickname().equals(nickname) && usuario.getClave().equals(clave)) {
                return usuario;
            }
        }
        return null;
    }
    
    
    public boolean disponibleUsuario(String nickname) {
        boolean res = true;
        for (Usuario usuario : usuarios) {
            if (usuario.getNickname().equalsIgnoreCase(nickname)) {
                return false;
            }
        }
        return res;
    }
    
    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }
    //***********************Fin operaciones de USUARIO*************************
    
    //************************ DB GENERAL ***************************************

    public void guardarDB() {
    	System.out.println("Guardando....");
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("Files\\BASE_DE_DATOS.obj"));
            salida.writeObject(this);
            salida.close();
        } catch (Exception e) {
            System.out.println("datos incorrectos");
        }
    }

    public static void cargarDB() throws IOException, ClassNotFoundException {
    	FileInputStream fis = new FileInputStream("Files\\BASE_DE_DATOS.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        bd = (BD) ois.readObject();
        ois.close();
        fis.close();
    }
    
    //************************ FIN DB GENERAL ***************************************
    //**********************PRODUCTO**********************************
    public void guardarProducto(Producto producto) {
        productos.add(producto);
        guardarDB();
    }
    
    public Producto getProducto(String nombre, String marca, String modelo){
        for(Producto producto : productos){
            if(producto.getNombre().equals(nombre) && producto.getMarca().equals(marca) && producto.getModelo().equals(modelo)){
                return producto;
            }
        }
        return null;
    }
    
    public ArrayList<Producto> getProducto(){
        return productos;
    }
    
    public void eliminarProducto(String nombre, String marca, String modelo){
    	ArrayList<Producto> eliminar = new ArrayList<Producto>();
    	for(Producto producto : productos){
    		if(producto.getNombre().equals(nombre) && producto.getMarca().equals(marca) && producto.getModelo().equals(modelo)){
    			//productos.remove(producto);
    			eliminar.add(producto);
    		}
    	}
    	for(Producto p : eliminar)
    		productos.remove(p);
    }

    //*********************FIN de operaciones de PRODUCTO*****************************
    
    //********************Almacen **************************************
    public void guardarAlmacen(Almacen almacen){
        almacenes.add(almacen);
        guardarDB();
    }
    
    public ArrayList<Almacen> getAlamacenes(){
        return almacenes;
    }
    
    
    public void eliminarAlmacen(String nombre){
    	ArrayList<Almacen> eliminar = new ArrayList<Almacen>();
    	for(Almacen almacen : almacenes){
    		if(almacen.getNombre().equals(nombre)){
    			eliminar.add(almacen);
    		}
    	}
    	for(Almacen a : eliminar)
    		almacenes.remove(a);
    }
    
     //*********************FIN de operaciones de ALMACEN*****************************
    
    //********************** Registro Almacenes************************************
    public void guardarRegistroAlmacen(RegistroAlmacen registro){
    	registroAlmacenes.add(registro);
    	guardarDB();
    }
    
    public ArrayList<RegistroAlmacen> getRegistroAlmacenes(){
        return registroAlmacenes;
    }
    
    //********************** Fin de Registro Almacenes **************************
}
