package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Carrito<T> extends Compra {
	private int idCarrito;
	private Date fecha;
	private String tipoPago;
	private boolean isPago;
	private float descuento;
	private T unProducto;

	private ArrayList<T>lista;

	public Carrito() {
		lista=new ArrayList<T>();
	}

	/**
	 * @param idCarrito
	 * @param fecha
	 * @param tipoPago
	 * @param isPago
	 * @param descuento
	 * @param unProducto
	 * @param lista
	 */
	public Carrito(int idCarrito, Date fecha, String tipoPago, boolean isPago, float descuento, T unProducto,
				   ArrayList<T> lista) {
		super();
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.tipoPago = tipoPago;
		this.isPago = isPago;
		this.descuento = descuento;
		this.unProducto = unProducto;
		this.lista = lista;
	}






	/**
	 * @return the idCarrito
	 */
	public int getIdCarrito() {
		return idCarrito;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @return the tipoPago
	 */
	public String getTipoPago() {
		return tipoPago;
	}


	/**
	 * @return the isPago
	 */
	public boolean isPago() {
		return isPago;
	}


	/**
	 * @param isPago the isPago to set
	 */
	public void setPago(boolean isPago) {
		this.isPago = isPago;
	}






	/**
	 * @return the descuento
	 */
	public float getDescuento() {
		return descuento;
	}

	/**
	 * @return the unProducto
	 */
	public T getUnProducto() {
		return unProducto;
	}

	/**
	 * @return the lista
	 */
	public ArrayList<T> getLista() {
		return lista;
	}

	/**
	 * @param unProducto the unProducto to set
	 */




	public void setUnProducto(T unProducto) {
		this.unProducto = unProducto;
	}





	/**
	 * @param idCarrito the idCarrito to set
	 */
	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}


	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}






	/**
	 * @param tipoPago the tipoPago to set
	 */
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}






	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}


	/**
	 * @param lista the lista to set
	 */
	public void setLista(ArrayList<T> lista) {
		this.lista = lista;
	}


	@Override
	public String toString() {
		return super.toString()+"Carrito [getIdCarrito()=" + getIdCarrito() + ", getFecha()=" + getFecha() + ", getTipoPago()="
				+ getTipoPago() + ", isPago()=" + isPago() + ", getDescuento()=" + getDescuento() + ", getUnProducto()="
				+ getUnProducto() + ", getLista()=" + getLista() + ", getPrecioTotal()=" + getPrecioTotal() + "]";
	}






	public void agregarCarrito(T unProducto)
	{
		lista.add(unProducto);
	}


//permite mostrar el carrito

	public String mostrarCarrito()
	{
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < lista.size(); i++) {
			builder.append(lista.get(i).toString() + "\n");
		}
		return builder.toString();
	}



	//obtener el total a pagar
	public double getPrecioTotal()
	{
		double precio=0, total=0, descuento=0;
		String formaPago="efectivo";

		for (int i=0;i< lista.size();i++)
		{

			precio+= (double)lista.get(i);

		}
		if(precio!=0)
		{
			if(getTipoPago().equals(formaPago)){
				descuento=precio/getDescuento();
				total=precio-descuento;
			}
		}
		else
		{
			total=precio;
		}

		return total;
	}

	///comprueba si la compra fue realizada o no
	public boolean estaPago()
	{
		boolean pagado=false;

		if(isPago()!=pagado)
		{
			pagado= true;
		}
		return pagado;
	}


}
