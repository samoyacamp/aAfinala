/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio;

import com.mycompany.biblio.DAO.LibroDAO;
import com.mycompany.biblio.DAO.PrestamoDAO;
import com.mycompany.biblio.modelos.Libros;
import com.mycompany.biblio.modelos.Prestamo;
import com.mycompany.biblio.modelos.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author sergi
 */
public class PrestamoController {

    private static PrestamoDAO pdao;
    private static Usuario user;
    private static LibroDAO ldao;
    private Libros librosSel;
    /**
     * ListView para cargar los datos del libro
     */
    @FXML
    private ListView listaLibro;
    /**
     * TextField para pasar el id
     */
    @FXML
    private TextField id;
    /**
     * Carga de imagen
     */
    @FXML
    private ImageView img1;
    /**
     * Carga de imagen
     */
    @FXML
    private ImageView img2;

    /**
     *
     * @param u Constructor de PrestamoController pasamos el user Y el metodo de
     * conectar con la base de datos
     */
    public PrestamoController(Usuario u) {
        user = u;
        conectarBD();

    }

    /**
     * Metodo para conectar con la base de datos
     */
    private static void conectarBD() {
        ldao = new LibroDAO() {
        };
        try {
            ldao.conectar();
        } catch (SQLException sqle) {
            AlertsUtil.mostrarError("Error cargando la app" + sqle.getMessage());
        } catch (ClassNotFoundException cnfe) {
            AlertsUtil.mostrarError("Error al iniciar la aplicación");
        } catch (IOException ioe) {
            AlertsUtil.mostrarError("Algo ha pasado");
        }

    }

    /**
     * Carga de la base de datos
     */
    public void initLists() {

        listaLibro.getItems().clear();
        try {
            conectarBD();
            List<Libros> libro = ldao.listLibros();
            listaLibro.setItems(FXCollections.observableList(libro));

        } catch (SQLException sqle) {
            AlertsUtil.mostrarError("Error cargando los libros");
        }
    }

    /**
     *
     * @throws SQLException
     * @throws IOException Metodo para pedir libro
     */
    @FXML
    private void pedir() throws SQLException, IOException {
        librosSel = (Libros) listaLibro.getSelectionModel().getSelectedItem();
        if (librosSel == null) {
            AlertsUtil.mostrarError("No se ha seleccionado nigun libro");
            return;
        }
        try {
            ldao.pedirLibro(new Prestamo((Integer.parseInt(id.getText()))));
            AlertsUtil.mostrarInformacion("Libro pedido");
            initLists();
        } catch (SQLException e) {
            AlertsUtil.mostrarError("Algo ha pasado");
        }
    }

    /**
     *
     * @throws SQLException
     * @throws IOException Metodo para devolver el libro
     */
    @FXML
    private void back() throws SQLException, IOException {
        librosSel = (Libros) listaLibro.getSelectionModel().getSelectedItem();
        if (librosSel == null) {
            AlertsUtil.mostrarError("No se ha seleccionado nigun libro");
            return;
        }
        try {
            ldao.devolverLibro(new Prestamo((Integer.parseInt(id.getText()))));
            AlertsUtil.mostrarInformacion("Libro Devuelto");
            initLists();
        } catch (SQLException e) {
            AlertsUtil.mostrarError("Algo ha pasado");
        }
    }

    /**
     * metodo para salir de la aplicacion
     */
    @FXML
    public void salir() {
        try {
            ldao.desconectar();
            Platform.exit();
        } catch (SQLException ex) {
            AlertsUtil.mostrarError("Error desconexion");

        }
    }

    /**
     *
     * @throws IOException Metodo para volver a la primera pantalla
     */
    @FXML
    private void sesion() throws IOException {
        App.setRoot("primary");

    }

    /**
     * Metodo para cargar la imagen
     */
    public void loadImg1() {
        Image img;
        try {
            img = new Image(new FileInputStream(new File(System.getProperty("user.dir") + "/images/error.jpg")));
            img1.setImage(img);
        } catch (FileNotFoundException ex) {
            img = new Image(getClass().getResourceAsStream("/images/images.png"));
            img1.setImage(img);
        }
    }

    /**
     * Metodo para cambiar la imagen
     */
    public void loadImg2() {
        Image img;
        try {
            img = new Image(new FileInputStream(new File(System.getProperty("user.dir") + "/images/error.jpg")));
            img2.setImage(img);
        } catch (FileNotFoundException ex) {
            img = new Image(getClass().getResourceAsStream("/images/vue.png"));
            img2.setImage(img);
        }
    }

}
