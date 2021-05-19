/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio;

import com.mycompany.biblio.DAO.LibroDAO;
import com.mycompany.biblio.modelos.Libros;
import com.mycompany.biblio.DAO.UsuarioDAO;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.mycompany.biblio.modelos.Usuario;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sergi
 */
public class LoginController {

    private static Usuario user;
    private static UsuarioDAO udao;
    @FXML
    private TextField nombre;
    @FXML
    private TextField email;
    @FXML
    private TextField pwd;
    @FXML
    private ImageView imagen;

    /**
     *
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException Metodo del login el cual mira todos los
     * requisitos al usuario que le demos para ver si puede pasar a la isguiente
     * ventana
     */
    @FXML
    private void login() throws SQLException, IOException, ClassNotFoundException {
        //String usuario = nombre.getText();
        //Usuario u = new Usuario(-1, nombre.getText(), email.getText(), pwd.getText());
        //u.checkNombre(usuario);
        //UsuarioDAO x = new UsuarioDAO();
        //System.out.println(u.getNombre());
        //boolean correcto = u.checkBDUsuario();
        //x.checkBDUsuario(u.getNombre());
        //boolean correcto = x.checkBDUsuario(u.toString());
        // DriverManager.println(String.valueOf(correcto));
        UsuarioDAO login = new UsuarioDAO();
        String user = nombre.getText();
        String pass = pwd.getText();
        String correo = email.getText();

        boolean ok = true;
        boolean vale = true;

        try {
            login.conectar();

            ok = login.checkBDAdmin(user, correo, pass);
            vale = login.checkBDUsuario(user, correo, pass);
            if (ok) {
                App.loadLibrosWindow();

                //AlertsUtil.mostrarConfi("Correcto");
            } else if (vale) {
                App.loadPrestaWindow();
            }
        } catch (SQLException e) {
            AlertsUtil.mostrarConfi("Algo ha pasado mal");

        }
        if (nombre.getText().isEmpty()) {
            AlertsUtil.mostrarError("no se ha pueto ningun nombre");
        }

        if (email.getText().isEmpty()) {
            AlertsUtil.mostrarError("no se ha puesto ningun email");
        }
        if (pwd.getText().isEmpty()) {
            AlertsUtil.mostrarError("no se ha puesto ninguna contraseña");
        }

    }

    /**
     *
     * @throws IOException metodo para llevarnos a la ventana de registrar
     */
    @FXML
    private void register() throws IOException {

        App.loadRegisterWindow();

    }

}
