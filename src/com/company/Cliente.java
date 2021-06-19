package com.company;

import Interface.ICategoria;


import java.io.Serializable;
import java.util.HashMap;



public class Cliente extends Usuario implements Serializable, ICategoria {

    private HashMap<Integer, Carrito<Compra>> historialCompras;
    private String mailCliente;
    private String localidadCliente;
    private boolean isActivo;
    private String categoria;
    private int idCarrito;
    private static int id = 0;

    public Cliente() {
        setId(getId());
        historialCompras = new HashMap<>();
        idCarrito = ++id;
    }

    public Cliente(String nombre, String apellido, String dni, String usuario, String contrasena, String mailCliente, String localidadCliente, Boolean isActivo, String categoria) {
        super(nombre, apellido, dni, usuario, contrasena);
        historialCompras = new HashMap<>();
        setId(getId());
        this.mailCliente = mailCliente;
        this.localidadCliente = localidadCliente;
        this.isActivo = isActivo;
        setCategoria(categoria);
        idCarrito = ++id;
    }

    public HashMap<Integer, Carrito<Compra>> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(HashMap<Integer, Carrito<Compra>> historialCompras) {
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
        sb.append("E-Mail: " + mailCliente + ", ");
        sb.append("Localidad: " + localidadCliente + ", ");
        sb.append("Categoria: " + getCategoria() + ", ");
        sb.append("Usuario: " + getUsuario() + ", ");
        sb.append("Contraseña: " + getContrasena());
        return sb.toString();
    }

    public void agregarHistorial(Carrito<Compra> lacompra){
    	/*
        System.out.println("pppppppppppppppppppppppppppppppppppppppppppppppppp"+ lacompra.getIdCarrito());
       if(historialCompras.containsKey(lacompra.getIdCarrito()))
    	 {
    	  System.out.println("no se puede agregar");///borrar
    	  }
       else
       {
    	   historialCompras.put(lacompra.getIdCarrito(), lacompra);

    	   System.out.println("ingresa???????");
       }
        */
        historialCompras.put(idCarrito, lacompra);
        }

}
