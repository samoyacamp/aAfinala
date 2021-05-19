/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio;

import javafx.scene.control.Alert;

/**
 *
 * @author sergi
 */
public class AlertsUtil {

    /**
     *
     * @param mensaje Metodo que Muestra error
     */
    public static void mostrarError(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setContentText(mensaje);
        alerta.show();
    }

    /**
     *
     * @param mensaje Metodo que muestra informacion
     */
    public static void mostrarInformacion(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setContentText(mensaje);
        alerta.show();
    }

    /**
     *
     * @param mensaje Metood que muestra que ha pasado algo
     */
    public static void mostrarConfi(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.NONE);
        alerta.setContentText(mensaje);
        alerta.show();
    }

    /**
     *
     * @param mensaje Metodo que muestra confirmacion
     */

    public static void mostrarSeguro(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setContentText(mensaje);
        alerta.show();
    }

}
