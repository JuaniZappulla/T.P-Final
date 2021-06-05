package com.company;

import java.math.BigInteger;
import java.util.ArrayList;

public class Cliente extends Usuario{
    private ArrayList<Carrito> historialCompras;
    private int idCliente;
    private String mailUsuario;
    private String localidadUsuario;
    private Boolean isActivo;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, BigInteger dni, String usuario, String contraseña, ArrayList<Carrito> historialCompras, int idUsuario, String mailUsuario, String localidadUsuario, Boolean isActivo) {
        super(nombre, apellido, dni, usuario, contraseña);
        this.historialCompras = historialCompras;
        this.idCliente = idUsuario;
        this.mailUsuario = mailUsuario;
        this.localidadUsuario = localidadUsuario;
        this.isActivo = isActivo;
    }

    public ArrayList<Carrito> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(ArrayList<Carrito> historialCompras) {
        this.historialCompras = historialCompras;
    }

    public int getIdUsuario() {
        return idCliente;
    }

    public void setIdUsuario(int idUsuario) {
        this.idCliente = idUsuario;
    }

    public String getMailUsuario() {
        return mailUsuario;
    }

    public void setMailUsuario(String mailUsuario) {
        this.mailUsuario = mailUsuario;
    }

    public String getLocalidadUsuario() {
        return localidadUsuario;
    }

    public void setLocalidadUsuario(String localidadUsuario) {
        this.localidadUsuario = localidadUsuario;
    }

    public Boolean getActivo() {
        return isActivo;
    }

    public void setActivo(Boolean activo) {
        isActivo = activo;
    }

    public String verHistorialDeCompras (){
        StringBuilder sb = new StringBuilder();
        for (Carrito carrito : historialCompras){
            sb.append(carrito.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public Compra nuevaCompra (){
        Compra nuevaCompra = new Compra();

        return nuevaCompra();
    }

}
