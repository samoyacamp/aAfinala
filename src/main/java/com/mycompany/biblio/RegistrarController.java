package com.mycompany.biblio;

import com.mycompany.biblio.DAO.UsuarioDAO;
import com.mycompany.biblio.modelos.Libros;
import com.mycompany.biblio.modelos.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author power
 */
public class RegistrarController {

    private static Usuario user;
    private static UsuarioDAO udao;
    /**
     * Text field donde pasamos el codigo del usuario No es necesario ya que el
     * codigo usuario Es autoincrement conforme se añade un usuario El id se
     * suma en 1
     */
    @FXML
    private TextField codigo_usuarios;
    /**
     * Textfield para pasar el nombre
     */
    @FXML
    private TextField nombre;
    /**
     * Text field para pasar el apellido
     */
    @FXML
    private TextField apellido;
    /**
     * TextField para pasar el email
     */
    @FXML
    private TextField email;
    /**
     * Text Field para pasar la contraseña
     */
    @FXML
    private TextField pwd;
    /**
     * TextField para pasar el DNI
     */
    @FXML
    private TextField DNI;
    /**
     * TextField para pasar el domicilio
     */
    @FXML
    private TextField domicilio;
    /**
     * TextField para pasar la ciudad
     */
    @FXML
    private TextField ciudad;
    /**
     * TextField para pasar la provincia
     */
    @FXML
    private TextField provincia;
    /**
     * Imagen
     */
    @FXML
    private ImageView image6;

    /**
     *
     * @param u Constructor de la clase Registrar Controller Le pasamos el user
     * relacionado con usuario y con el metodo de conectar para acceder a la
     * base de datos
     */
    public RegistrarController(Usuario u) {
        user = u;
        conectarBD();
    }

    /**
     * Metodo para conectarse a la base de datos
     */
    private static void conectarBD() {
        udao = new UsuarioDAO();
        try {
            udao.conectar();
        } catch (SQLException sqle) {
            AlertsUtil.mostrarError("Error al conectar con la base de datos" + sqle.getMessage());
        } catch (ClassNotFoundException cnfe) {
            AlertsUtil.mostrarError("Error al iniciar la aplicación");
        } catch (IOException ioe) {
            AlertsUtil.mostrarError("Error al cargar la configuración");
        }

    }

    /**
     *
     * @throws IOException Metodo y boton para volver a la primera ventana de la
     * apalicacion
     */
    @FXML
    private void volver() throws IOException {
        App.setRoot("primary");

    }

    /**
     *
     * @throws IOException
     * @throws SQLException Metodo y boton para añadir usuario
     */
    @FXML
    private void addUser() throws IOException, SQLException {
        udao.addUsuario(new Usuario(Integer.parseInt(codigo_usuarios.getText()),
                nombre.getText(), apellido.getText(), email.getText(), pwd.getText(),
                DNI.getText(), domicilio.getText(), ciudad.getText(), provincia.getText()));
        AlertsUtil.mostrarInformacion("Registrado");
    }

    /**
     * Metodo para cargar la imagen
     */
    public void loadImage6() {
        Image img;
        try {
            img = new Image(new FileInputStream(new File(System.getProperty("user.dir") + "/images/error.jpg")));
            image6.setImage(img);
        } catch (FileNotFoundException ex) {
            img = new Image(getClass().getResourceAsStream("/images/usu.png"));
            image6.setImage(img);
        }
    }

}
