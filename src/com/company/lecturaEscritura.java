package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.*;

public class lecturaEscritura {

    private File fileClient = new File ("clientes.json");
    private File fileProduct = new File ("productos.json");

    public void grabaClientes (LinkedHashSet<Usuario> clientes, Supermercado mercado){
        LinkedHashSet<Cliente> clientesAux = new LinkedHashSet<>();
        try {
            BufferedWriter escritura = new BufferedWriter(new FileWriter(fileClient));
            Gson gson = new Gson();
            for (Usuario usuarioAux : clientes){
                if (usuarioAux instanceof Cliente){
                    clientesAux.add((Cliente) usuarioAux);
                }
            }
            gson.toJson(clientesAux, LinkedHashSet.class, escritura);
            escritura.flush();
            escritura.newLine();
            escritura.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leeClientes (Supermercado mercado){
        try {
            BufferedReader lectura = new BufferedReader(new FileReader(fileClient));
            Gson gson = new Gson();
            Cliente[] clientes = gson.fromJson(lectura, Cliente[].class);
            LinkedHashSet<Cliente> usuarios = new LinkedHashSet<>(Arrays.asList(clientes));
            for (Cliente usuario2 : usuarios){
                mercado.nuevoUsuario(usuario2);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void grabaProductos (ArrayList<Producto> listadoProductos, Supermercado mercado){
        try {
            BufferedWriter escritura = new BufferedWriter(new FileWriter(fileProduct));
            Gson gson = new Gson();
            gson.toJson(listadoProductos, List.class, escritura);
            escritura.flush();
            escritura.newLine();
            escritura.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Producto> leeProductos () {
        ArrayList<Producto> producto = null;
        try {
            BufferedReader lectura = new BufferedReader(new FileReader(fileClient));
            Gson gson = new Gson();
            Producto[] productos = gson.fromJson(lectura, Producto[].class);
            producto = new ArrayList<>(Arrays.asList(productos));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return producto;
    }

}
