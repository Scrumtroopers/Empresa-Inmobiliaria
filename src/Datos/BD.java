package Datos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class BD {

    private static ArrayList<String[]> usuarios = new ArrayList<>();

    public static void guardarUsuario(String[] usuario) {
        usuarios.add(usuario);
        String nickname = usuario[0];
        guardarDBUsuario(nickname);
    }

    public static Usuario getUsuario(String nickname, String clave) {
        cargarDBUsuario(nickname);
        for (String[] usuario : usuarios) {

            if (usuario[0].equals(nickname) && usuario[4].equals(clave)) {
                return convertirUsuario(usuario);
            }
        }
        return null;
    }

    private static Usuario convertirUsuario(String[] user) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = user[5];
        Date fecha = null;
        try {

            fecha = formatoDelTexto.parse(strFecha);

        } catch (ParseException ex) {

            ex.printStackTrace();

        }

        Sexo sexo;
        if (user[6].equalsIgnoreCase("Femenino")) {
            sexo = Sexo.FEMENINO;
        } else {
            sexo = Sexo.MASCULINO;
        }

        String categoria = "";
        switch (user[7]) {
            case "Administrador":
                categoria = "ADMINISTRADOR_ALMACEN";
                break;
            case "Empleado":
                categoria = "EMPLEADO";
                break;
        }

        return new Usuario(user[0], user[1], user[2], user[3], user[4], fecha, sexo, categoria);
    }

    private static void guardarDBUsuario(String nickname) {
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("FilesUsuario\\usuario_" + nickname + ".obj"));
            salida.writeObject(usuarios);
            salida.close();
        } catch (Exception e) {
            System.out.println("datos incorrectos");
        }
    }

    private static void cargarDBUsuario(String nickname) {
        try {
            FileInputStream fis = new FileInputStream("FilesUsuario\\usuario_" + nickname + ".obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            usuarios = (ArrayList<String[]>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            System.out.println("no existe usuario");
        }
    }
    
    public static boolean disponibleUsuario(String nickname){
        boolean res = false;
        try{
            FileInputStream fis = new FileInputStream("FilesUsuario\\usuario_" + nickname + ".obj");
            
        } catch(Exception e){
            res = true;
        }
        return res;
    }
}
