/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio.modelos;

import java.sql.Date;

/**
 *
 * @author sergi
 */
public class Libros {

    /**
     *
     */
    protected int id;

    protected String nombre;
    private String editorial;
    private String autor;
    private String genero;
    private Date fecha;
    private double precio;
    private String saga;
    private int prestamo;

    /**
     *
     * @param id
     * @param nombre
     * @param editorial
     * @param autor
     * @param genero
     * @param fecha
     * @param precio
     * @param saga
     * @param prestamo
     */
    public Libros(int id, String nombre, String editorial, String autor, String genero, Date fecha, double precio, String saga, int prestamo) {
        this.id = id;
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
        this.genero = genero;
        this.fecha = fecha;
        this.precio = precio;
        this.saga = saga;
        this.prestamo = prestamo;
    }

    /**
     *
     * @return
     */
    public int getPrestamo() {
        return prestamo;
    }

    /**
     *
     * @param prestamo
     */
    public void setPrestamo(int prestamo) {
        this.prestamo = prestamo;
    }

    /**
     *
     * @param fecha
     */
    public Libros(Date fecha) {
        this.fecha = fecha;
    }

    /**
     *Constructor vacio
     */
    public Libros() {
    }
//
//    /**
//     *
//     * @param i
//     * @param parseInt
//     * @param text
//     * @param text0
//     * @param text1
//     * @param indexOf
//     * @param valueOf
//     * @param parseFloat
//     * @param text2
//     */
//    public Libros(int i, int parseInt, String text, String text0, String text1, int indexOf, Date valueOf, float parseFloat, String text2) {
//    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     *
     * @param editorial
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     *
     * @return
     */
    public String getAutor() {
        return autor;
    }

    /**
     *
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     *
     * @return
     */
    public String getGenero() {
        return genero;
    }

    /**
     *
     * @param genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     *
     * @return
     */
    public double getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     *
     * @return
     */
    public String getSaga() {
        return saga;
    }

    /**
     *
     * @param saga
     */
    public void setSaga(String saga) {
        this.saga = saga;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "id:" + id + ", nombre:" + nombre + ", editorial:" + editorial + ", autor:" + autor + ", genero:" + genero + ", precio:" + precio + ", saga:" + saga
                + ", estado:" + prestamo ;
    }

    /**
     *
     * @return
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
