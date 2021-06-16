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
        if(listadoProductos != null){
            this.listadoProductos = listadoProductos;
        }
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

    public Usuario buscarUsuarioLogin (String usr, String pass){
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
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Cliente){
                if (((Cliente) usuario).getActivo()){
                    sb.append("\n");
                    sb.append("[" + usuario + "]");
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    public String muestraProductos (){
        StringBuilder sb = new StringBuilder();
        for (Producto producto : listadoProductos){
            if (producto.isActivo()){
                sb.append(producto);
                sb.append("\n");
            }
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

    public Usuario buscarUsuario (String dni){
        Usuario usr = null;
        for (Usuario usuarioAux : usuarios){
            if (usuarioAux.getDni().equals(dni)){
                usr = usuarioAux;
            }
        }
        return usr;
    }

    public boolean BuscaProducto (int id){
        boolean flag = false;
        for (Producto producto : listadoProductos){
            if (producto.getIdProducto() == id){
                if (producto.isActivo()){
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean restockProducto (int id, int cantidad){
        boolean flag = false;
        for (Producto producto : listadoProductos){
            if(producto.getIdProducto() == id){
                cantidad += producto.getStockProducto();
                producto.setStockProducto(cantidad);
                flag = true;
            }
        }
        return flag;
    }

    public boolean bajaDeProducto (int id){
        boolean flag = false;
        for (Producto producto : listadoProductos){
            if (producto.getIdProducto() == id){
                if (producto.isActivo()){
                    producto.setActivo(false);
                    flag = true;
                }
            }
        }
        return flag;
    }

    public String muestraDadosDeBajaProductos (){
        StringBuilder sb = new StringBuilder();
        for (Producto producto : listadoProductos){
            if (!producto.isActivo()){
                sb.append(producto);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public boolean altaDeProducto (int id){
        boolean flag = false;
        for (Producto producto : listadoProductos){
            if (producto.getIdProducto() == id){
                if (!producto.isActivo()){
                    producto.setActivo(true);
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean bajaDeCliente(String dni){
        boolean flag = false;
        for (Usuario usuarioAux: usuarios){
            if (usuarioAux.getDni().equals(dni)){
                if (usuarioAux instanceof Cliente){
                    if (((Cliente) usuarioAux).getActivo()){
                        ((Cliente) usuarioAux).setActivo(false);
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public String muestraDadosDeBajaUsuarios() {
        StringBuilder sb = new StringBuilder();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Cliente){
                if (!((Cliente) usuario).getActivo()){
                    sb.append("\n");
                    sb.append("[" + usuario + "]");
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    public boolean altaDeCliente(String dni){
        boolean flag = false;
        for (Usuario usuarioAux: usuarios){
            if (usuarioAux instanceof Cliente) {
                if (usuarioAux.getDni().equals(dni)) {
                    if (!((Cliente) usuarioAux).getActivo()) {
                        ((Cliente) usuarioAux).setActivo(true);
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }
}
