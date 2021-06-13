package com.company;

import com.google.gson.*;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {

    public static Scanner scanner;

    public static void main(String[] args){
        File file = new File ("clientes.json");
        Supermercado superMerca = new Supermercado("LaSuperMerca");
        leer(file.getPath(), superMerca);
        scanner = new Scanner(System.in);
        cargarAdmins(superMerca);
        Usuario usr = Login(superMerca);
        grabar(file.getPath(), superMerca.getUsuarios(), superMerca);
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

    public static void grabar (String file, LinkedHashSet<Usuario> clientes, Supermercado mercado){
        LinkedHashSet<Cliente> clientesAux = new LinkedHashSet<>();
        try {
            BufferedWriter escritura = new BufferedWriter(new FileWriter(file));
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

    public static void leer (String file, Supermercado mercado){
        try {
            BufferedReader lectura = new BufferedReader(new FileReader(file));
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
}
