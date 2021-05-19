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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.*;

/**
 *
 * @author sergi
 */
public class LibroDAO extends Prestamo {

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

    /**
     *
     * @throws SQLException metodo que sirve para desconectar la aplicación
     */
    public void desconectar() throws SQLException {
        conexion.close();
    }

    /**
     *
     * @param libro
     * @throws SQLException Metodo para insertar libros a la base de datos
     */
    public void insertarLibro(Libros libro) throws SQLException {
        String sql = "{call spNewLibro (?,?,?,?,?,?,?,?,?)}";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, libro.getId());
        sentencia.setString(2, libro.getNombre());
        sentencia.setString(3, libro.getEditorial());
        sentencia.setString(4, libro.getAutor());
        sentencia.setString(5, libro.getGenero());
        sentencia.setDate(6, libro.getFecha());
        sentencia.setDouble(7, libro.getPrecio());
        sentencia.setString(8, libro.getSaga());
        sentencia.setInt(9, libro.getPrestamo());
        sentencia.executeUpdate();

    }

    /**
     *
     * @param libro
     * @throws SQLException Metodo para borrar libros de la base de datos
     */
    public void deleteLibro(Libros libro) throws SQLException {
        String sql = "DELETE FROM libros WHERE id = ?";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, libro.getId());
        sentencia.executeUpdate();
    }

    /**
     *
     */
    public void selectLibros(Libros libro) throws SQLException {
        String sql = "SELECT * FROM LIBROS";
    }

    /**
     *
     * @return @throws SQLException Metodo para Mostrar los datos de la base de
     * datos
     */
    public List<Libros> listLibros() throws SQLException {
        List<Libros> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
            Libros libro = new Libros();
            libro.setId(resultado.getInt(1));
            libro.setNombre(resultado.getString(2));
            libro.setEditorial(resultado.getString(3));
            libro.setAutor(resultado.getString(4));
            libro.setGenero(resultado.getString(5));
            libro.setFecha(resultado.getDate(6));
            libro.setPrecio(resultado.getDouble(7));
            libro.setSaga(resultado.getString(8));
            libro.setPrestamo(resultado.getInt(9));
            libros.add(libro);
        }

        return libros;
    }

    /**
     *
     * @param libro
     * @throws SQLException Metodo para modificar libros donde el id sea igual
     * al id que pongamos
     */
    public void modificarLibro(Libros libro) throws SQLException {
        String sql = "{call spUpdateLibro (?,?,?,?,?,?,?,?,?)}";

        CallableStatement sentencia = conexion.prepareCall(sql);
        sentencia.setInt(1, libro.getId());
        sentencia.setString(2, libro.getNombre());
        sentencia.setString(3, libro.getEditorial());
        sentencia.setString(4, libro.getAutor());
        sentencia.setString(5, libro.getGenero());
        sentencia.setDate(6, libro.getFecha());
        sentencia.setDouble(7, libro.getPrecio());
        sentencia.setString(8, libro.getSaga());
        sentencia.setInt(9, libro.getPrestamo());

        sentencia.execute();

    }

    /**
     *
     * @param pre
     * @throws SQLException Metodo para pedir libro donde pone la columna
     * prestamo de 1 a 2
     */
    public void pedirLibro(Prestamo pre) throws SQLException {
        String sql = "{call spPedirLibro (?)}";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, pre.getId());
        sentencia.execute();

    }

    /**
     *
     * @param pre
     * @throws SQLException Metodo para pedir el libro cambia el valor de
     * prestamo de 3 a 1
     */
    public void devolverLibro(Prestamo pre) throws SQLException {
        String sql = "{call spDevolver (?)}";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, pre.getId());
        sentencia.execute();

    }
}
