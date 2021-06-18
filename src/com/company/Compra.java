package com.company;

import java.util.ArrayList;

public class Compra{
	private Producto producto;
	private int cantidad;
	private double precioTotal;

	public Compra() {

	}

	/**
	 * @param producto
	 * @param cantidad
	 * @param precioTotal
	 */
	public Compra(Producto producto, int cantidad, double precioTotal) {

		this.producto = producto;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
	}

	public Producto buscarPorNombre(String nombreProducto, Supermercado mercado)
	{

		int i=0;
		int flag=-1;
		
		Producto unProducto;
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
	///eliminar un producto que se agrego a la compra por error
	/*public int  eliminar(int idProducto)
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
*/
	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
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
		return getProducto() + "Cantidad: " + getCantidad() + " Precio: " + getPrecioTotal();
	}

	///Precio del total
	public void precioTotal(double precioProducto , int cantidad)
	{
		precioTotal = precioProducto * cantidad;
	}

	public Producto buscaUnProducto (String nombreProducto, Supermercado mercado){
		Producto aux = new Producto();
		for (Producto producto : mercado.getListadoProductos()){
			if (producto.getNombreProducto().equals(nombreProducto)){
				aux = producto;
			}
		}
		return aux;
	}

}
