package com.company;

import java.io.Serializable;

public class Admin extends Usuario implements Serializable {

    private int idAdministrador;
    private String cargo;
    private static int idAdmin = 1;

    public Admin() {
    }

    public Admin(String nombre, String apellido, String dni, String usuario, String contrasena, String cargo) {
        super(nombre, apellido, dni, usuario, contrasena);
        setIdAdministrador(idAdmin);
        idAdmin++;
        this.cargo = cargo;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Cargo: " + cargo + "\n");

        return sb.toString();
    }
}
