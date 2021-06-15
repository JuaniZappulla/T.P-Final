package com.company;

import java.math.BigInteger;
import java.util.*;

public class Supermercado {
    private String nombreSupermercado;
    private LinkedHashSet<Usuario> usuarios;
    private ArrayList<Producto> listadoProductos;

    public Supermercado(String nombreSupermercado) {
        this.nombreSupermercado = nombreSupermercado;
        usuarios = new LinkedHashSet<>();
        listadoProductos = new ArrayList<>();
    }

    public void nuevoUsuario (Usuario usuario){
        usuarios.add(usuario);
    }

    public void nuevoProducto (Producto producto){
        listadoProductos.add(producto);
    }

    public ArrayList<Producto> getListadoProductos() {
        return listadoProductos;
    }

    public void setListadoProductos(ArrayList<Producto> listadoProductos) {
        this.listadoProductos = listadoProductos;
    }

    public LinkedHashSet<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(LinkedHashSet<Usuario> usuarios) {
        if (usuarios != null){
            this.usuarios = usuarios;
        }
    }

    public String getNombreSupermercado() {
        return nombreSupermercado;
    }

    public void setNombreSupermercado(String nombreSupermercado) {
        this.nombreSupermercado = nombreSupermercado;
    }

    public Cliente buscarClientePorDni(BigInteger dniCliente){
        Cliente clienteBuscado = new Cliente();
        for (Usuario cliente : usuarios){
            if (cliente.getDni().equals(dniCliente)){
                clienteBuscado = (Cliente) cliente;
            }
        }
        return clienteBuscado;
    }

    public Usuario buscarUsuario (String usr, String pass){
        for (Usuario usuario : usuarios){
            if (usuario.getUsuario().equals(usr)){
                if (usuario.getContrasena().equals(pass)){
                    if (usuario instanceof Cliente) {
                        Cliente cliente = new Cliente();
                        return cliente = (Cliente) usuario;
                    }
                    else if(usuario instanceof Admin){
                        Admin admin = new Admin();
                        return admin = (Admin) usuario;
                    }
                }
            }
        }
        return null;
    }

    public boolean buscarPorNombreUsuarioLogin (String usr) {
        boolean flag = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getUsuario().equals(usr)) {
                flag = true;
            }
        }
        return flag;
    }

    public String muestraUsuarios() {
        StringBuilder sb = new StringBuilder();
        for (Usuario usuario : usuarios){
            sb.append("[Nombre: " + usuario.getNombre() + ", ");
            sb.append("Apellido: " + usuario.getApellido() + ", ");
            sb.append("DNI: " + usuario.getDni() + ", ");
            sb.append("Usuario: " + usuario.getUsuario() + ", ");
            sb.append("Contraseña: " + usuario.getContrasena() + ", ");
            if (usuario instanceof Admin){
                sb.append("Cargo: " + ((Admin) usuario).getCargo());
                sb.append("]" + "\n");
            }
            else if (usuario instanceof Cliente){
                sb.append("E-Mail: " + ((Cliente) usuario).getMailCliente() + ", ");
                sb.append("Localidad: " + ((Cliente) usuario).getLocalidadCliente() + ", ");
                sb.append("Categoria: " + ((Cliente) usuario).getCategoria());
                sb.append("]" + "\n");
            }
        }
        return sb.toString();
    }

    public String muestraProductos (){
        StringBuilder sb = new StringBuilder();
        for (Producto producto : listadoProductos){
            sb.append(producto.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    public String muestraProductosPorCategoria (String categoria){
        StringBuilder sb = new StringBuilder();
        for (Producto producto : listadoProductos){
            if (producto.getCategoria().equals(categoria)){
                sb.append(producto.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public Usuario buscarUsuario (String usuario){
        Usuario usr = null;
        for (Usuario usuarioAux : usuarios){
            if (usuarioAux.getDni().equals(usuario)){
                usr = usuarioAux;
            }
        }
        return usr;
    }

}
