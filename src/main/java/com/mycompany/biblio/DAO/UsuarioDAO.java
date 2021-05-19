/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio.DAO;

import com.mycompany.biblio.App;
import com.mycompany.biblio.modelos.Usuario;
// import com.mycompany.biblio.modelos.Libros;
// import com.mycompany.biblio.modelos.Usuario;
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
public class UsuarioDAO {

    /**
     * Atributo que accede a Conecction que ejecuta las ordenes que se reciven
     * del sql
     */
    private Connection conexion;

    /**
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException Metodo para conectar a la base de datos accediendo
     * por el fichero de conexion a la base de datos
     */
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

    /**
     *
     * @param nombre
     * @param email
     * @param pwd
     * @return
     * @throws SQLException Metodo que verifica que el admin esta en la base de
     * datos
     */
    public boolean checkBDAdmin(String nombre, String email, String pwd) throws SQLException {
        String sql = "SELECT * FROM USUARIOS WHERE Nombre=? AND Pwd=? AND email=? AND PUESTO='admin' LIMIT 1";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, nombre);
        sentencia.setString(2, pwd);
        sentencia.setString(3, email);
        ResultSet resultado = sentencia.executeQuery();

        return resultado.next();

    }

    /**
     *
     * @param nombre
     * @param email
     * @param pwd
     * @return
     * @throws SQLException Metodo que verifica que el usuario esta en la base
     * de datos
     */
    public boolean checkBDUsuario(String nombre, String email, String pwd) throws SQLException {
        String sql = "SELECT * FROM USUARIOS WHERE Nombre=? AND Pwd=? AND email=? LIMIT 1";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, nombre);
        sentencia.setString(2, pwd);
        sentencia.setString(3, email);
        ResultSet resultado = sentencia.executeQuery();

        return resultado.next();
    }

    /**
     *
     * @param user
     * @throws SQLException Metodo para añadir usuario a la base de datos
     */
    public void addUsuario(Usuario user) throws SQLException {
        String sql = "{call spNewUser (?,?,?,?,?,?,?,?,?)}";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, user.getCodigo_usuarios());
        sentencia.setString(2, user.getNombre());
        sentencia.setString(3, user.getEmail());
        sentencia.setString(4, user.getApellido());
        sentencia.setString(5, user.getPassword());
        sentencia.setString(6, user.getDNI());
        sentencia.setString(7, user.getDomicilio());
        sentencia.setString(8, user.getCiudad());
        sentencia.setString(9, user.getProvincia());
        sentencia.executeUpdate();

    }

}
