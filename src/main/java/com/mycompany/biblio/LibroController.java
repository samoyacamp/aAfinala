/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio;

import com.mycompany.biblio.modelos.Usuario;
import com.mycompany.biblio.DAO.LibroDAO;
import com.mycompany.biblio.modelos.Genero;
import com.mycompany.biblio.modelos.Libros;
import com.mycompany.biblio.modelos.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author sergi
 */
public class LibroController {

    private static Usuario user;
    private static LibroDAO ldao;
    private Libros librosSel;
    private ObservableList<Genero> generoz = FXCollections.observableArrayList(Arrays.asList(Genero.values()));
    @FXML
    private ComboBox genero;
    @FXML
    private TextField id;
    @FXML
    private TextField nombre;
    @FXML
    private TextField editorial;
    @FXML
    private TextField autor;
    @FXML
    private DatePicker fecha;
    @FXML
    private TextField precio;
    @FXML
    private TextField saga;
    @FXML
    private TextField prestamo;
    @FXML
    private ListView listaLibro;
    @FXML
    private ImageView imagen1;
    @FXML
    private ImageView imagen2;
    @FXML
    private ImageView imagen3;

    /**
     *
     * @throws IOException Boton que nos cambia de pantalla a la principal
     */
    @FXML
    private void sesion() throws IOException {
        App.setRoot("primary");

    }

    /**
     * Boton que sirve para añadir libros, despues de haber introducido todos
     * los valores de libros
     */
    @FXML
    private void addl() {
        try {

            ldao.insertarLibro(new Libros(Integer.parseInt(id.getText()), nombre.getText(), editorial.getText(), autor.getText(),
                    genero.getValue().toString(),
                    Date.valueOf(fecha.getValue()), Float.parseFloat(precio.getText()), saga.getText(), Integer.parseInt(prestamo.getText())));
            initLists();
        } catch (SQLException ex) {
            AlertsUtil.mostrarError("Error al modificar el libro seleccionada. ");

        }

    }

    /**
     * Boton que modifica el libro despues de haber rellenado todos los campos
     * para guardarlo
     */
    @FXML
    private void savel() {
        librosSel = (Libros) listaLibro.getSelectionModel().getSelectedItem();

        if (librosSel == null) {
            AlertsUtil.mostrarError("No se ha seleccionado ningun libro");
            return;
        }
        try {

            ldao.modificarLibro(new Libros(Integer.parseInt(id.getText()), nombre.getText(), editorial.getText(), autor.getText(),
                    genero.getValue().toString(), Date.valueOf(fecha.getValue()), Double.parseDouble(precio.getText()), saga.getText(),
                    Integer.parseInt(prestamo.getText())));
            initLists();
        } catch (SQLException ex) {
            AlertsUtil.mostrarError("Error al modificar el libro seleccionado");
        }

    }

    /**
     * Boton que sirve para borrar el libro, despues de haberlo seleccionado y
     * haber aceptado el alert que aperece
     */
    @FXML
    private void deletel() {
        librosSel = (Libros) listaLibro.getSelectionModel().getSelectedItem();
        if (librosSel == null) {
            AlertsUtil.mostrarError("No se ha seleccionado nigun libro");
            return;
        }
        try {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Eliminar Libro");
            confirmacion.setContentText("¿Estas seguro que quieres elminar el libro?");
            Optional<ButtonType> respuesta = confirmacion.showAndWait();
            if (respuesta.get().getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE) {
                return;
            }
            ldao.deleteLibro(librosSel);
            initLists();

        } catch (SQLException ex) {
            AlertsUtil.mostrarError("Error al eliminar el libro seleccionado" + ex.getMessage());
        }

    }

    /**
     *
     * @param u Constructor de la clase libro controller
     */
    public LibroController(Usuario u) {
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
            AlertsUtil.mostrarError("Error al conectar con la base de datos" + sqle.getMessage());
        } catch (ClassNotFoundException cnfe) {
            AlertsUtil.mostrarError("Error al iniciar la aplicación");
        } catch (IOException ioe) {
            AlertsUtil.mostrarError("Error al cargar la configuración");
        }

    }

    /**
     * Metodo para cargar el libro en la base de datos
     */
    public void initLists() {

        genero.setItems(generoz);
        listaLibro.getItems().clear();
        try {
            conectarBD();
            List<Libros> libro = ldao.listLibros();
            listaLibro.setItems(FXCollections.observableList(libro));

        } catch (SQLException sqle) {
            AlertsUtil.mostrarError("Error cargando los datos de la aplicación");
        }
    }

    /**
     * Metodo para salir de la aplicacion
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
     * Metodo para cargar ficheros al programa Aún no funciona
     */
    @FXML
    public void loadArticulosFromFile() {
        File fichero = null;
        FileReader lector = null;
        BufferedReader buffer = null;

        try {
            fichero = new File("libros.txt");
            lector = new FileReader(fichero);
            buffer = new BufferedReader(lector);
            String linea = null;
            while ((linea = buffer.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (buffer != null)
                try {
                buffer.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Carga de imagen
     */
    public void loadImage() {
        Image img;
        try {
            img = new Image(new FileInputStream(new File(System.getProperty("user.dir") + "/images/modi.png")));
            imagen1.setImage(img);
        } catch (FileNotFoundException ex) {
            img = new Image(getClass().getResourceAsStream("/images/suma.png"));
            imagen1.setImage(img);
        }
    }

    /**
     * Carga de imagen
     */
    public void loadImage1() {
        Image img;
        try {
            img = new Image(new FileInputStream(new File(System.getProperty("user.dir") + "/images/error.jpg")));
            imagen2.setImage(img);
        } catch (FileNotFoundException ex) {
            img = new Image(getClass().getResourceAsStream("/images/modi.png"));
            imagen2.setImage(img);
        }
    }

    /**
     * Carga de imagen
     */
    public void loadImage2() {
        Image img;
        try {
            img = new Image(new FileInputStream(new File(System.getProperty("user.dir") + "/images/error.jpg")));
            imagen3.setImage(img);
        } catch (FileNotFoundException ex) {
            img = new Image(getClass().getResourceAsStream("/images/borra.jpg"));
            imagen3.setImage(img);
        }
    }
}
