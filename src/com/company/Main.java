package com.company;

import com.google.gson.*;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {

    public static Scanner scanner;

    public static void main(String[] args){

        Supermercado superMerca = new Supermercado("LaSuperMerca");
        scanner = new Scanner(System.in);
        cargarAdmins(superMerca);
        Usuario usr = Login(superMerca);
        System.out.println(superMerca.getUsuarios());

    }

    public static Usuario Login (Supermercado mercado) {
        String usuario, contrasena;
        char opc;
        Usuario usr;
        System.out.println("Login");
        System.out.println("Usuario");
        usuario = scanner.nextLine();
        System.out.println("Contraseña");
        contrasena = scanner.nextLine();
        usr = mercado.buscarUsuario(usuario, contrasena);
        if (usr != null) {
            System.out.println("Logeado con exito!");
            System.out.println("Bienvenido " + usr.getNombre());
        }
        else{
            System.out.println("Usuario o Contraseña incorrectos!!");
            do {
                System.out.println("Desea crear un nuevo usuario? S/N");
                opc = scanner.nextLine().charAt(0);
                if (opc == 's' || opc == 'S') {
                    usr = nuevoCliente(mercado);
                    mercado.nuevoUsuario(usr);
                    System.out.println("Cliente creado con exito!");
                } else if (opc == 'n' || opc == 'N') {
                    System.out.println("Hasta pronto!");
                }
            }while (opc != 's' && opc != 'S' && opc != 'n' && opc != 'N');
        }
        return usr;
    }

    public static Usuario nuevoCliente (Supermercado mercado){
        boolean flag = false;
        String usuario;
        Cliente cliente = new Cliente();
        System.out.println("Nombre: ");
        cliente.setNombre(scanner.nextLine());
        System.out.println("Apellido: ");
        cliente.setApellido(scanner.nextLine());
        System.out.println("DNI");
        cliente.setDni(scanner.nextLine());
        do{
            System.out.println("E-Mail");
            cliente.setMailUsuario(scanner.nextLine());
            if (cliente.getMailCliente().contains("@")){
                flag = true;
            }else{
                System.out.println("Error, mail no valido, reintente...");
            }
        }while (!flag);
        System.out.println("Localidad: ");
        cliente.setLocalidadCliente(scanner.nextLine());
        System.out.println("Categoria: ");
        cliente.setCategoria(scanner.nextLine());
        do{
            System.out.println("Nombre de usuario: ");
            usuario = scanner.nextLine();
            if (mercado.buscarPorNombreUsuario(usuario)){
                System.out.println("Error, usuario ya registrado.");
            }
            else{
                cliente.setUsuario(usuario);
            }
        }while (mercado.buscarPorNombreUsuario(usuario));
        System.out.println("contraseña: ");
        cliente.setContrasena(scanner.nextLine());
        cliente.setActivo(true);
        return cliente;
    }

    public static void cargarAdmins (Supermercado mercado){
        Usuario admin1 = new Admin("Juan Ignacio", "Zappulla", "41928220", "juani99", "8914122", "Jefe");
        mercado.nuevoUsuario(admin1);
    }

    public static void grabar (LinkedHashSet<Cliente> clientes){
        File file = new File ("clientes.json");
        try {
            BufferedWriter escritura = new BufferedWriter(new FileWriter(file));
            for (Cliente cliente : clientes){
                Gson gson = new Gson();
                gson.toJson(cliente, Cliente.class, escritura);
                escritura.flush();
                escritura.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leer (File file){
        try {
            Usuario usr = new Cliente();
            BufferedReader lectura = new BufferedReader(new FileReader(file));
            Gson gson = new Gson();
            usr = gson.fromJson(lectura, Cliente.class);
            System.out.println(usr.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



}
