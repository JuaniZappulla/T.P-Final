package com.company;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class Supermercado {
    private String nombreSupermercado;
    private LinkedHashSet<Usuario> usuarios;
    private HashMap<Integer,Producto> listadoProductos;

    public Supermercado(String nombreSupermercado) {
        this.nombreSupermercado = nombreSupermercado;
        usuarios = new LinkedHashSet<>();
        listadoProductos = new HashMap<>();
    }

    public void nuevoUsuario (Usuario usuario){
        usuarios.add(usuario);
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

    public boolean buscarPorNombreUsuario (String usr) {
        boolean flag = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getUsuario().equals(usr)) {
                flag = true;
            }
        }
        return flag;
    }

    public String getUsuarios() {
        StringBuilder sb = new StringBuilder();
        for (Usuario usuario : usuarios){
            if (usuario instanceof Admin){
                sb.append("[");
                sb.append("Nombre: " + usuario.getNombre() + ", ");
                sb.append("Apellido: " + usuario.getApellido() + ", ");
                sb.append("DNI: " + usuario.getDni() + ", ");
                sb.append("Usuario: " + usuario.getUsuario() + ", ");
                sb.append("Contraseña: " + usuario.getContrasena() + ", ");
                sb.append("Cargo: " + ((Admin) usuario).getCargo());
                sb.append("]" + "\n");
            }
            else if (usuario instanceof Cliente){
                sb.append("[");
                sb.append("Nombre: " + usuario.getNombre() + ", ");
                sb.append("Apellido: " + usuario.getApellido() + ", ");
                sb.append("DNI: " + usuario.getDni() + ", ");
                sb.append("Usuario: " + usuario.getUsuario() + ", ");
                sb.append("Contraseña: " + usuario.getContrasena() + ", ");
                sb.append("E-Mail: " + ((Cliente) usuario).getMailCliente() + ", ");
                sb.append("Localidad: " + ((Cliente) usuario).getLocalidadCliente() + ", ");
                sb.append("Categoria: " + ((Cliente) usuario).getCategoria());
                sb.append("]" + "\n");
            }
        }
        return sb.toString();
    }
}
