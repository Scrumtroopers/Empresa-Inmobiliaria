/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.umss.formulariobiografico.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.umss.formulariobiografico.model.Persona;

/**
 *
 * @author ariel
 */

public class Consulta {

    Connection conection = null;
    Statement getStatement = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    ResultSet userID = null;

    String url = "jdbc:postgresql://localhost:5432/DBBiografico";
    String user = "postgres";
    String password = "";
    int id;

    public Consulta() throws SQLException {
        conection = DriverManager.getConnection(url, user, password);
    }
    
    public void registrarPersona(Persona persona) {
        try {
            statement = conection.prepareStatement("INSERT INTO persona (nombre, apellido, cod_sis, sexo, estado_civil, correo_electronico, telefono, "
                    + "fecha_nacimiento, pais_nacimiento) VALUES (?,?,?,?,?,?,?,?,?)");
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getApellido());
            statement.setInt(3, persona.getCodigo_sis());
            statement.setString(4, persona.getSexo() + "");
            statement.setString(5, persona.getEstado_civil());
            statement.setString(6, persona.getCorreo());
            statement.setInt(7, persona.getTelefono());
            statement.setString(8, persona.getFecha_de_nacimiento());
            statement.setString(9, persona.getPais_de_nacimiento());
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Consulta.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
