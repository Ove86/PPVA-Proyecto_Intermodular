package com.ppva.model.articulos;

import com.ppva.model.enums.TipoEstado;

public abstract class ArticuloNoFungible extends Articulo{
    private String estadoFisico;

    public ArticuloNoFungible(int codArticulo, String nombre, int credito, TipoEstado estado, String estadoFisico) {
        super(codArticulo, nombre, credito, estado);
        this.estadoFisico = estadoFisico;
    }

    public ArticuloNoFungible(int codArticulo, String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String estadoFisico) {
        super(codArticulo, nombre, marca, descripcion, credito, imagen, estado);
        this.estadoFisico = estadoFisico;
    }

    public ArticuloNoFungible(int codArticulo, String nombre, String estadoFisico) {
        super(codArticulo, nombre);
        this.estadoFisico = estadoFisico;
    }

    public ArticuloNoFungible(String nombre, String estadoFisico) {
        super(nombre);
        this.estadoFisico = estadoFisico;
    }

    public ArticuloNoFungible(String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String estadoFisico) {
        super(nombre, marca, descripcion, credito, imagen, estado);
        this.estadoFisico = estadoFisico;
    }

    public String getEstadoFisico() {
        return estadoFisico;
    }

    public void setEstadoFisico(String estadoFisico) {
        this.estadoFisico = estadoFisico;
    }

    public String muestraArtNoFung() {
        return  super.muestraArticulo() +
                "\nArtículo NoFungible" +
                "\n\tEstado Físico :" + estadoFisico;
    }
}
