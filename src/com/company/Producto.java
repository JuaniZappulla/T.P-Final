package com.company;

import Interface.ICategoria;

public class Producto implements ICategoria {
    private int idProducto;
    private String nombreProducto;
    private double precioProducto;
    private int stockProducto;
    private String marcaProducto;
    private String comentario;
    private String categoria;

    public Producto() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param idProducto
     * @param nombreProducto
     * @param precioProducto
     * @param stockProducto
     * @param marcaProducto
     * @param comentario
     */
    public Producto(int idProducto, String nombreProducto, double precioProducto, int stockProducto,
                    String marcaProducto, String comentario, String categoria) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.stockProducto = stockProducto;
        this.marcaProducto = marcaProducto;
        this.comentario = comentario;
        setCategoria(categoria);
    }

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }
    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }
    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    /**
     * @return the precioProducto
     */
    public double getPrecioProducto() {
        return precioProducto;
    }
    /**
     * @param precioProducto the precioProducto to set
     */
    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
    /**
     * @return the stockProducto
     */
    public int getStockProducto() {
        return stockProducto;
    }
    /**
     * @param stockProducto the stockProducto to set
     */
    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }
    /**
     * @return the marcaProducto
     */
    public String getMarcaProducto() {
        return marcaProducto;
    }
    /**
     * @param marcaProducto the marcaProducto to set
     */
    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }
    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }
    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria (){
        return categoria;
    }
}
