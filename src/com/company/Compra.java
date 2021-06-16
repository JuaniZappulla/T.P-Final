package com.company;

import java.util.ArrayList;

public class Compra extends Producto{
	private String producto;
	private int cantidad;
	private double precioTotal;




	private ArrayList<Producto> listaCompras;


	public Compra() {
		listaCompras= new ArrayList<Producto>();
	}





	/**
	 * @param producto
	 * @param cantidad
	 * @param precioTotal
	 * @param listaCompras
	 */
	public Compra(String producto, int cantidad, double precioTotal, ArrayList<Producto> listaCompras) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
		this.listaCompras = listaCompras;
	}






	///busco por id el producto comprado
	public int buscarPorId(int idProducto)
	{

		int i=0;
		int flag=-1;
		while(i<listaCompras.size()&& flag==-1)
		{

			Producto unProducto= listaCompras.get(i);

			if(unProducto.getIdProducto()==idProducto)
			{

				flag=i;

			}
			else
			{
				i++;
			}
		}


		return flag;
	}
	
	public Producto buscarPorNombre(String nombreProducto, Supermercado mercado)
	{

		int i=0;
		int flag=-1;
		
		Producto unProducto= new Producto();
		unProducto=null;
		
		while(i<mercado.getListadoProductos().size()&& flag==-1)
		{

			unProducto= mercado.getListadoProductos().get(i);
           
			if(unProducto.getNombreProducto().equals(nombreProducto))
			{

				flag=1;

			}
			else
			{
				i++;
			}
		}
		
		return unProducto;
	}






	///puedo agregar un producto a la compra
	public void agregarCompra(Producto produc)
	{
		listaCompras.add(produc);
	}





	///eliminar un producto que se agrego a la compra por error
	public int  eliminar(int idProducto)
	{
		int flag=-1;
		int borrar=0;
		borrar= buscarPorId(idProducto);
		if(borrar==1)
		{
			listaCompras.remove(borrar);
			flag=1;
		}
		return flag;
	}

	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the precioTotal
	 */
	public double getPrecioTotal() {
		return precioTotal;
	}
	/**
	 * @param precioTotal the precioTotal to set
	 */
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}


	@Override
	public String toString() {
		return super.toString()+"Compra [getProducto()=" + getProducto() + ", getCantidad()=" + getCantidad() + ", getPrecioTotal()="
				+ getPrecioTotal() + "]";
	}

	///Precio del total

	public double precioTotal(int idProducto,int cantidad)
	{
		double precioAPagar=0;
		double precio=0;

		precio=buscarPorId(idProducto);

		if(precio!=-1)
		{
			precioAPagar= precio * cantidad;

		}

		return precioAPagar;//si retorna 0, el producto el id es incorrecto;
	}




}
