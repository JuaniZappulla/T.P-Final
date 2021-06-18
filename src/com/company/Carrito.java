package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Carrito<T> {
 
 	private int idCarrito;
	private static int id = 0;
 	private Date fecha;
 	private String tipoPago;
 	private boolean isPago;
 	private float descuento;
	private ArrayList<T>lista;
	
	public Carrito() {
		lista = new ArrayList<T>();
		idCarrito = ++id;
		fecha = new Date();
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
	 * @param isPago the isPago to set
	 */
	public void setPago(boolean isPago) {
		this.isPago = isPago;
	}

	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	/**
	 * @return the lista
	 */
	public ArrayList<T> getLista() {
		return lista;
	}

	 public void agregarCarrito(T compra)
	 {
		 lista.add(compra);
	 }

	public void setLista(ArrayList<T> lista) {
		this.lista = lista;
	}

	//permite mostrar el carrito completo
 
	public String mostrarCarrito() {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < lista.size(); i++) {
					builder.append(lista.get(i).toString() + "\n");
			}
			return builder.toString();
		}
	//obtener el total a pagar con el descuento

	 public double getPrecioTotal() {
		 double total=0;
		 float aplicarDescuento=0;

		 for (int i=0;i< lista.size();i++)
		 {

			 total+= (double)lista.get(i);

		 }
		 if (getTipoPago()=="efectivo")
		 {
			 aplicarDescuento=(float)total*getDescuento();

		 }
		 else {
			 aplicarDescuento=(float)total;
		 }

		 return aplicarDescuento;
	 }

	@Override
	public String toString() {
		return "Carrito{" +
				"idCarrito=" + idCarrito +
				", fecha=" + fecha +
				", tipoPago='" + tipoPago + '\'' +
				", isPago=" + isPago +
				", descuento=" + descuento +
				", productos=" + lista +
				'}';
	}
}
