package com.company;

import exceptions.CargaProductoException;
import java.util.Scanner;

public class Main {

    public static Scanner scanner;

    public static void main(String[] args){
        lecturaEscritura lye = new lecturaEscritura();
        int opc = 0;
        Supermercado superMerca = new Supermercado("LaSuperMerca");
        lye.leeClientes(superMerca);
        superMerca.setListadoProductos(lye.leeProductos());
        scanner = new Scanner(System.in);
        cargarAdmins(superMerca);
        Usuario usr = Login(superMerca);
        if (usr instanceof Admin){
            do{
                menuAdmin();
                opc = scanner.nextInt();
                scanner.nextLine();
                switch (opc){
                    case 1:
                        try{
                            nuevoProducto(superMerca);
                        }catch(CargaProductoException e){
                            e.getMessage();
                        }
                        break;
                    case 2:
                        System.out.println(superMerca.muestraProductos());
                        break;
                    case 3:
                        muestraPorCategoria(superMerca);
                        break;
                }
            }while (opc != 0);

        }
        lye.grabaClientes(superMerca.getUsuarios(), superMerca);
        lye.grabaProductos(superMerca.getListadoProductos(), superMerca);
    }

    public static void menuAdmin (){
        System.out.println("MENU ADMINISTRADOR: ");
        System.out.println("1. AGREGA PRODUCTO");
        System.out.println("2. VER LISTA PRODUCTOS ");
        System.out.println("3. VER LISTA PRODUCTOS POR CATEGORIA");
        System.out.println("0. SALIR");
        System.out.println("SELECCIONE UNA OPCION: ");
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

    public static void nuevoProducto (Supermercado mercado) {
        Producto producto = new Producto();
        System.out.println("Nombre del producto: ");
        producto.setNombreProducto(scanner.nextLine());
        System.out.println("Marca del producto: ");
        producto.setMarcaProducto(scanner.nextLine());
        System.out.println("Precio del producto: ");
        producto.setPrecioProducto(scanner.nextDouble());
        System.out.println("Stock Actual del producto: ");
        producto.setStockProducto(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Comentario: ");
        producto.setComentario(scanner.nextLine());
        System.out.println("Categoria: ");
        producto.setCategoria(scanner.nextLine());
        mercado.nuevoProducto(producto);
    }

    public static void muestraPorCategoria(Supermercado mercado){
        String categoria = "prueba";
        System.out.println("INGRESE CATEGORIA: ");
        categoria = scanner.nextLine();
        mercado.muestraProductosPorCategoria("categoria");
    }


}
