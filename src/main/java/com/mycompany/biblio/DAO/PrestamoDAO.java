/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio.DAO;

import com.mycompany.biblio.App;
import com.mycompany.biblio.modelos.Libros;
import com.mycompany.biblio.modelos.Prestamo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author sergi
 */
public class PrestamoDAO extends LibroDAO{
private Connection conexion;

    public void conectar() throws ClassNotFoundException, SQLException, IOException {

        Properties configuration = new Properties();
        configuration.load(new FileInputStream(new File(App.class.getResource("connectionDB.properties").getPath())));
        String host = configuration.getProperty("host");
        String port = configuration.getProperty("port");
        String name = configuration.getProperty("name");
        String username = configuration.getProperty("username");
        String password = configuration.getProperty("password");

        conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
                username, password);
    }
 
    public void desconectar() throws SQLException {
        conexion.close();
    }
    public void pedirLibro(Prestamo pre) throws SQLException {
         String sql = "{call spPedirLibro (?)}";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, pre.getId());
        sentencia.execute();
        
    }
    
}
