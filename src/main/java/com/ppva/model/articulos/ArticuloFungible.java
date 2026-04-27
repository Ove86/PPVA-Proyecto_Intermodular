package com.ppva.model.articulos;

import com.ppva.model.enums.TipoEstado;
import java.time.LocalDate;

public abstract class ArticuloFungible extends Articulo{
    private int cantidad;
    private LocalDate fechaCaducidad;

    public ArticuloFungible(int codArticulo, String nombre, int credito, TipoEstado estado, int cantidad, LocalDate fechaCaducidad) {
        super(codArticulo, nombre, credito, estado);
        this.cantidad = cantidad;
        this.fechaCaducidad = fechaCaducidad;
    }

    public ArticuloFungible(int codArticulo, String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, int cantidad, LocalDate fechaCaducidad) {
        super(codArticulo, nombre, marca, descripcion, credito, imagen, estado);
        this.cantidad = cantidad;
        this.fechaCaducidad = fechaCaducidad;
    }

    public ArticuloFungible(int codArticulo, String nombre, int cantidad, LocalDate fechaCaducidad) {
        super(codArticulo, nombre);
        this.cantidad = cantidad;
        this.fechaCaducidad = fechaCaducidad;
    }

    public ArticuloFungible(String nombre, int cantidad, LocalDate fechaCaducidad) {
        super(nombre);
        this.cantidad = cantidad;
        this.fechaCaducidad = fechaCaducidad;
    }

    public ArticuloFungible(String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, int cantidad, LocalDate fechaCaducidad) {
        super(nombre, marca, descripcion, credito, imagen, estado);
        this.cantidad = cantidad;
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String muestraArtFung() {
        return  super.muestraArticulo()+
                "\n Artículo Fungible" +
                "\n\t Cantidad de artículos :" + cantidad +
                // convertir para que se visualice correctamente
                "\n\t Fecha de caducidad :" + fechaCaducidad ;
    }
}
