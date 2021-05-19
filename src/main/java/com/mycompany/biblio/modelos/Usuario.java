
package com.mycompany.biblio.modelos;

/**
 *
 * @author sergi
 */

public class Usuario {

    private int codigo_usuarios;
    private String nombre;
    private String email;
    private String password;
    private String apellido;
    private String DNI;
    private String domicilio;
    private String ciudad;
    private String provincia;

    /**
     *
     * @param codigo_usuarios
     * @param nombre
     * @param email
     * @param password
     * @param apellido
     * @param DNI
     * @param domicilio
     * @param ciudad
     * @param provincia
     */
    public Usuario(int codigo_usuarios, String nombre, String email, String password, String apellido, String DNI, String domicilio, String ciudad, String provincia) {
        this.codigo_usuarios = codigo_usuarios;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.apellido = apellido;
        this.DNI = DNI;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{nombre=").append(nombre);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }

    public Usuario() {
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param nombre
     * @return Metodo para comprobar que el nombre es mayor o igual que 6
     */
    public boolean checkNombre(String nombre) {
        return nombre.length() >= 6;
    }

    /**
     *
     * @param email
     * @return Metodo para comprobar que el email tiene un @ y un .
     */
    public boolean checkEmail(String email) {
        //return email.matches("@+");
        boolean ok = false;
        if (email.matches("[-\\w\\.]+@\\w+\\.\\w+")) {
            ok = true;
        }
        return ok;
    }

    /**
     *
     * @param pwd
     * @return Metodo con expresión regular para comprobar que la contraseña
     * Empieza por mayusucla y es mayor que 8
     */
    public boolean checkPassword(String pwd) {
        boolean ok = false;
        if (pwd.matches(".*[A-Z].*") && pwd.length() >= 8) {
            ok = true;
        }
        return ok;
    }

    /**
     * @return the codigo_usuarios
     */
    public int getCodigo_usuarios() {
        return codigo_usuarios;
    }

    /**
     * @param codigo_usuarios the codigo_usuarios to set
     */
    public void setCodigo_usuarios(int codigo_usuarios) {
        this.codigo_usuarios = codigo_usuarios;
    }

    /**
     *
     * @return
     */
    public String getApellido() {
        return apellido;
    }

    /**
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     *
     * @return
     */
    public String getDNI() {
        return DNI;
    }

    /**
     *
     * @param DNI
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     *
     * @return
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     *
     * @param domicilio
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     *
     * @return
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     *
     * @param ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     *
     * @return
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     *
     * @param provincia
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

}
