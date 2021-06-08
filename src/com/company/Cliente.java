package com.company;

import java.math.BigInteger;
import java.util.ArrayList;

public class Cliente extends Usuario{
    private ArrayList<Carrito> historialCompras;
    private String mailCliente;
    private String localidadCliente;
    private boolean isActivo;
    private static int idCliente = 1;

    public Cliente() {
        setIdCliente(idCliente);
        idCliente++;
    }

    public Cliente(String nombre, String apellido, BigInteger dni, String usuario, String contrasena, ArrayList<Carrito> historialCompras, String mailCliente, String localidadCliente, Boolean isActivo) {
        super(nombre, apellido, dni, usuario, contrasena);
        this.historialCompras = historialCompras;
        setIdCliente(idCliente);
        this.mailCliente = mailCliente;
        this.localidadCliente = localidadCliente;
        this.isActivo = isActivo;
    }

    public ArrayList<Carrito> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(ArrayList<Carrito> historialCompras) {
        this.historialCompras = historialCompras;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idUsuario) {
        this.idCliente = idUsuario;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("E-Mail: " + mailCliente + "\n");
        sb.append("Localidad: " + localidadCliente + "\n");
        sb.append("Usuario: " + getUsuario() + "\n");
        sb.append("Contraseña: " + getContrasena());
        return sb.toString();
    }
}
