package com.company;

public class Compra {
	private String producto;
	private int cantidad;
	private double precioTotal;
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
		return "Compra [getProducto()=" + getProducto() + ", getCantidad()=" + getCantidad() + ", getPrecioTotal()="
				+ getPrecioTotal() + "]";
	}
	
	
	
	
}
