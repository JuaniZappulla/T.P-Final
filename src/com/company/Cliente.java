package com.company;

import Interface.ICategoria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Cliente extends Usuario implements Serializable, ICategoria {

    private HashMap<Integer, Carrito> historialCompras;
    private String mailCliente;
    private String localidadCliente;
    private boolean isActivo;
    private String categoria;

    public Cliente() {
        setId(getId());
    }

    public Cliente(String nombre, String apellido, String dni, String usuario, String contrasena, String mailCliente, String localidadCliente, Boolean isActivo, String categoria) {
        super(nombre, apellido, dni, usuario, contrasena);
        historialCompras = new HashMap<>();
        setId(getId());
        this.mailCliente = mailCliente;
        this.localidadCliente = localidadCliente;
        this.isActivo = isActivo;
        setCategoria(categoria);
    }

    public HashMap<Integer, Carrito> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(HashMap<Integer, Carrito> historialCompras) {
        this.historialCompras = historialCompras;
    }

    public String getMailCliente() {
        return mailCliente;
    }

    public void setMailUsuario(String mailUsuario) {
        this.mailCliente = mailUsuario;
    }

    public String getLocalidadCliente() {
        return localidadCliente;
    }

    public void setLocalidadCliente(String localidadUsuario) {
        this.localidadCliente = localidadUsuario;
    }

    public Boolean getActivo() {
        return isActivo;
    }

    public void setActivo(Boolean activo) {
        isActivo = activo;
    }

    public Compra nuevaCompra (){
        Compra nuevaCompra = new Compra();

        return nuevaCompra();
    }

    @Override
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public String getCategoria(){
        return categoria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("E-Mail: " + mailCliente + "\n");
        sb.append("Localidad: " + localidadCliente + "\n");
        sb.append("Categoria: " + getCategoria() + "\n");
        sb.append("Usuario: " + getUsuario() + "\n");
        sb.append("Contraseña: " + getContrasena() + "\n");

        return sb.toString();
    }

}
