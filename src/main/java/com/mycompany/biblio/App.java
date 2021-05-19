package com.mycompany.biblio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.mycompany.biblio.modelos.Usuario;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    /**
     * Creación del objeto
     */
    private static Usuario user = new Usuario();

    /**
     *
     * @param stage
     * @throws IOException Metodo para abrir la primera ventana
     */
    @Override
    public void start(Stage stage) throws IOException {
        String fxml = "primary";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        scene = new Scene(fxmlLoader.load(), 700, 700);
        stage.setScene(scene);
        stage.show();

    }

    /**
     *
     * @throws IOException Metodo que sirve para cargar la ventana secondary que
     * hace referencia al controller de libro Se le da acceso a la app del
     * controller libro y el constructor Se carga la base de datos y las
     * imagenes
     */
    static void loadLibrosWindow() throws IOException {
        String fxml = "secondary";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        // Give the controller access to the main app.
        LibroController controller = new LibroController(user);
        fxmlLoader.setController(controller);
        scene.setRoot(fxmlLoader.load());
        controller.initLists();
        controller.loadImage();
        controller.loadImage1();
        controller.loadImage2();
    }

    /**
     *
     * @throws IOException sirve para cargar la ventana Registrar Se le da
     * acceso al app.java del controller que necesitemos con su constructor Se
     * carga la base de datos Y la imagen
     */
    static void loadRegisterWindow() throws IOException {
        String fxml = "register";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        RegistrarController controller = new RegistrarController(user);
        fxmlLoader.setController(controller);
        scene.setRoot(fxmlLoader.load());
        controller.loadImage6();

    }

    /**
     *
     * @throws IOException Metodo para cargar la ventana prestamos Le damos
     * acceso a la app del controller con el constructor Cargamos la base de
     * datos y las imagenes
     */
    static void loadPrestaWindow() throws IOException {
        String fxml = "presta";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        PrestamoController controller = new PrestamoController(user);
        fxmlLoader.setController(controller);
        scene.setRoot(fxmlLoader.load());
        controller.initLists();
        controller.loadImg1();
        controller.loadImg2();

    }

    /**
     *
     * @param fxml
     * @throws IOException Metodo que sirve para dar rutas a otras ventanas
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    /**
     * 
     * @param args
     * Main que ejecuta la aplicación
     */
    public static void main(String[] args) {
        launch();
    }

}
