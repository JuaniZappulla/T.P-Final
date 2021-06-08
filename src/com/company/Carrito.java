package com.company;

import java.util.ArrayList;
import java.util.Date;

import com.sun.tools.javac.util.List;



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
 public void agregarCarrito(T unProducto)
 {
	 lista.add(unProducto);
 }
//permite mostrar el carrito
 /*
	public String mostrarCarrito() 
		{
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < lista.size(); i++) {
					builder.append(lista.get(i).toString() + "\n");
			}
			return builder.toString();
		}*/
	//obtener el total a pagar
 public double getPrecioTotal()
 {
	 double total=0;
	 
	 for (int i=0;i< lista.size();i++)
	 {
		 
		 total+= (double)lista.get(i);
	 }
	 
	 return total;
 }
 
	///comprueba si la compra fue realizada o no
 private boolean estaPago(T unProducto)
 {
	 boolean pagado=false;
	 if(unProducto.)
	 
	 return pagado;
 }
}
