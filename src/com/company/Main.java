package com.company;

import exceptions.CargaProductoException;
import java.util.Scanner;



public class Main {

    public static Scanner scanner;

    public static void main(String[] args){
        int opc;
        scanner = new Scanner(System.in);
        lecturaEscritura lye = new lecturaEscritura();
        Supermercado superMerca = new Supermercado("La Super Merca");
        superMerca.setUsuarios(lye.leeClientes());
        superMerca.setListadoProductos(lye.leeProductos());
        cargarAdmins(superMerca);
        System.out.println("SuperMercado " + superMerca.getNombreSupermercado());
        Usuario usr = Login(superMerca);
        
        Cliente datosCliente= new Cliente();
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
                    case 4:
                        restockearProducto(superMerca);
                        break;
                    case 5:
                        bajaProducto(superMerca);
                        break;
                    case 6:
                        altaProducto(superMerca);
                        break;
                    case 7:
                        System.out.println(usr);
                        break;
                    case 8:
                        System.out.println(superMerca.muestraUsuarios());
                        break;
                    case 9:
                        buscaUsuario(superMerca);
                        break;
                    case 10:
                        bajaCliente(superMerca);
                        break;
                    case 11:
                        altaCliente(superMerca);
                        break;
                }
            }while (opc != 0);
        }
        else if (usr instanceof Cliente){
            menuCliente();
             opc = scanner.nextInt();
             scanner.nextLine();
             switch (opc)
             {
                 case 1:
                	 System.out.println(superMerca.muestraProductos());
                	 break;
                 case 2:
                	 muestraPorCategoria(superMerca);
                	 break;
                 case 3:
                	 realizarCompra();
                	 break;
                 case 4:
                	 
                	 Carrito<Compra>ProcesoCompras= new Carrito<>();
                	 System.out.println(ProcesoCompras.mostrarCarrito());
                	 
                	 break;
                 case 5:
                	
                    System.out.println(datosCliente.getHistorialCompras());
                	 break;
                 case 6:
                	 finCompra(superMerca);
                	 break;
                 case 7:
                	 System.out.println("en proceso...");
                	
                	 break;
                 case 8:
                	 
                	 break;
                	 
                	 
             }
        }
        lye.grabaClientes(superMerca.getUsuarios(), superMerca);
        lye.grabaProductos(superMerca.getListadoProductos(), superMerca);
    }

    public static void menuAdmin (){
        System.out.println("MENU ADMINISTRADOR: ");
        System.out.println("1. AGREGA PRODUCTO");
        System.out.println("2. VER LISTA PRODUCTOS");
        System.out.println("3. VER LISTA PRODUCTOS POR CATEGORIA");
        System.out.println("4. RENOVAR STOCK DE UN PRODUCTO");
        System.out.println("5. DAR DE BAJA UN PRODUCTO");
        System.out.println("6. DAR DE ALTA UN PRODUCTO");
        System.out.println("7. VER USUARIO ADMINISTRADOR");
        System.out.println("8. VER LISTA CLIENTES");
        System.out.println("9. BUSCAR CLIENTE");
        System.out.println("10. DAR DE BAJA UN CLIENTE");
        System.out.println("11. DAR DE ALTA UN CLIENTE");
        System.out.println("0. SALIR");
        System.out.println("SELECCIONE UNA OPCION: ");
    }

    public static void menuCliente (){
        System.out.println("MENU CLIENTE");
        System.out.println("1. VER LISTA PRODUCTOS");
        System.out.println("2. VER LISTA DE PRODUCTOS POR CATEGORIA");
        System.out.println("3. CARGAR PRODUCTO AL CARRITO");
        System.out.println("4.VER CARRITO");
        System.out.println("5.VER HISTORIAL DE COMPRA");
        System.out.println("6.FINALIZAR PEDIDO");
        System.out.println("7.CANCELAR PEDIDO");///SE PODRIA MODIFICAR
        System.out.println("8.MODIFICAR DATOS PERSONALES");
        System.out.println("9.DAR DEBAJA LA CUENTA");
        System.out.println("10. BUSCAR UN PRODUCTO EN ESPECIFICO");
        System.out.println("11. DEJAR UN COMENTARIO DEL PRODUCTO");
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
        System.out.println("ContraseÃ±a");
        contrasena = scanner.nextLine();
        usr = mercado.buscarUsuarioLogin(usuario, contrasena);
        if (usr != null) {
            System.out.println("Logeado con exito!");
            System.out.println("Bienvenido " + usr.getNombre());
        }
        else{
            System.out.println("Usuario o ContraseÃ±a incorrectos!!");
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
            if (mercado.buscarPorNombreUsuarioLogin(usuario)){
                System.out.println("Error, usuario ya registrado.");
            }
            else{
                cliente.setUsuario(usuario);
            }
        }while (mercado.buscarPorNombreUsuarioLogin(usuario));
        System.out.println("contraseÃ±a: ");
        cliente.setContrasena(scanner.nextLine());
        cliente.setActivo(true);
        return cliente;
    }

    public static void cargarAdmins (Supermercado mercado){
        Usuario admin1 = new Admin("Juan Ignacio", "Zappulla", "41928220", "juani99", "8914122", "Jefe");
        Usuario admin2= new Admin("Nahuel Ariel","Zamudio","41542799","nahuel98","741852","jefe2");
        mercado.nuevoUsuario(admin1);
        mercado.nuevoUsuario(admin2);
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
        String categoria;
        System.out.println("INGRESE CATEGORIA: ");
        categoria = scanner.nextLine();
        System.out.println(mercado.muestraProductosPorCategoria(categoria));
    }

    public static void buscaUsuario(Supermercado mercado) {
        String usuario;
        System.out.println("INGRESE DNI DE USUARIO: ");
        usuario = scanner.nextLine();
        Usuario usr = mercado.buscarUsuario(usuario);
        if ( usr instanceof Cliente) {
            System.out.println("Id:" + usr.getId());
            System.out.println(usr);
        } else if (usr instanceof Admin) {
            System.out.println("Id:" + usr.getId());
            System.out.println(usr);
        }
    }

    public static void restockearProducto (Supermercado mercado){
        int idProducto;
        int cantidad;
        boolean flag;
        System.out.println("Ingrese id de producto: ");
        idProducto = scanner.nextInt();
        flag = mercado.BuscaProducto(idProducto);
        if (!flag){
            System.out.println("ERROR, ID INCORRECTO O SE DESACTIVÃ“ EL PRODUCTO");
        }
        else{
            System.out.println("Ingrese cantidad para reestockear");
            cantidad = scanner.nextInt();
            flag = mercado.restockProducto(idProducto, cantidad);
            if(!flag){
                System.out.println("ERROR, REINTENTE");
            }
            else{
                System.out.println("INGRESO DE STOCK CORRECTO");
            }
        }
    }

    public static void bajaProducto (Supermercado mercado){
        int idProducto;
        boolean flag;
        System.out.println("Ingrese id de producto: ");
        idProducto = scanner.nextInt();
        flag = mercado.bajaDeProducto(idProducto);
        if (!flag){
            System.out.println("ERROR, EL PRODUCTO NO SE ENCUENTRA O YA ESTÃ� DESACTIVADO");
        }
        else{
            System.out.println("PRODUCTO DADO DE BAJA CON EXITO");
        }
    }

    public static void altaProducto (Supermercado mercado){
        int idProducto;
        boolean flag;
        System.out.println("PRODUCTOS DADOS DE BAJA");
        System.out.println(mercado.muestraDadosDeBajaProductos());
        System.out.println("Ingrese id de producto: ");
        idProducto = scanner.nextInt();
        flag = mercado.altaDeProducto(idProducto);
        if (!flag){
            System.out.println("ERROR, EL PRODUCTO NO SE ENCUENTRA O YA ESTÃ� DADO DE ALTA");
        }
        else{
            System.out.println("PRODUCTO DADO DE ALTA CON EXITO");
        }
    }

    public static void bajaCliente (Supermercado mercado){
        String dni;
        boolean flag;
        System.out.println("Ingrese DNI de cliente: ");
        dni = scanner.nextLine();
        flag = mercado.bajaDeCliente(dni);
        if (!flag){
            System.out.println("ERROR, EL CLIENTE NO SE ENCUENTRA O YA ESTÃ� DADO DE BAJA");
        }
        else{
            System.out.println("CLIENTE DADO DE BAJA CON EXITO");
        }
    }

    public static void altaCliente (Supermercado mercado){
        String dni;
        boolean flag;
        System.out.println("CLIENTES DADOS DE BAJA");
        System.out.println(mercado.muestraDadosDeBajaUsuarios());
        System.out.println("Ingrese DNI de producto: ");
        dni = scanner.nextLine();
        flag = mercado.altaDeCliente(dni);
        if (!flag){
            System.out.println("ERROR, EL USUARIO NO SE ENCUENTRA O YA ESTÃ� DADO DE ALTA");
        }
        else{
            System.out.println("USUARIO DADO DE ALTA CON EXITO");
        }
    }
    public static void finCompra(Supermercado mercado)
    {
    	int tipoPago=0;
    	int aux=0;
    	Carrito<Producto>unProducto=new Carrito<>();
    	do {
    	System.out.println("seleccione el metodo de pago: 1) efectivo/n 2) tarjeta");
    	tipoPago=scanner.nextInt();
    	if(tipoPago==1)
    	{
    		unProducto.setTipoPago("efectivo");
    	}
    	else if(tipoPago==2)
    	{
    		unProducto.setTipoPago("tarjeta");
    	}
    	else
    	{
    		System.out.println("el tipo de pago es incorrecto, intente nuevamente");
    	}
    	}while(tipoPago==1 || tipoPago==2);
    	
    	
    	System.out.println("el total a pagar es:" +unProducto.getPrecioTotal());
    	System.out.println("para realizar el pago precione 1, en caso contrario 2");
    	aux=scanner.nextInt();
    	if(aux==1)
    	{
    		unProducto.setPago(true);
    	}
    	else
    	{
    		unProducto.setPago(false);
    	}
    }
    public static void realizarCompra()///falta probar 
    {
    	Carrito<Producto> unProducto= new Carrito<>();
    	
    	Compra compraProducto= new Compra();
    	String nombreProducto;
       System.out.println("ingrese el procuto que dese comprar:");
       nombreProducto= scanner.next();
      compraProducto=(Compra) compraProducto.buscarPorNombre(nombreProducto);
      if( compraProducto!=null)
      {
    	  unProducto.agregarCarrito(compraProducto);
      }
      else
      {
    	  System.out.println("el producto elegido no existe");
      }
    }
public static Usuario modificarDatos(Supermercado mercado)
{
	Cliente modCliente = new Cliente();
	///falta terminar 
	
	return modCliente;
}
}
