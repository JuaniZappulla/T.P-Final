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

    public Cliente buscarClientePorDni(BigInteger dniCliente){
        Cliente clienteBuscado = new Cliente();
        for (Usuario cliente : usuarios){
            if (cliente.getDni().equals(dniCliente)){
                clienteBuscado = (Cliente) cliente;
            }
        }
        return clienteBuscado;
    }

}
