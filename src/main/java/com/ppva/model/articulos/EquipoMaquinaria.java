package com.ppva.model.articulos;

import com.ppva.model.enums.TipoEstado;

public class EquipoMaquinaria extends ArticuloNoFungible {
    private float potencia;
    private float energia;

    public EquipoMaquinaria(int codArticulo, String nombre, String estadoFisico, float potencia, float energia) {
        super(codArticulo, nombre, estadoFisico);
        this.potencia = potencia;
        this.energia = energia;
    }

    public EquipoMaquinaria(int codArticulo, String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String estadoFisico, float potencia, float energia) {
        super(codArticulo, nombre, marca, descripcion, credito, imagen, estado, estadoFisico);
        this.potencia = potencia;
        this.energia = energia;
    }

    public EquipoMaquinaria(String nombre, String estadoFisico, float potencia, float energia) {
        super(nombre, estadoFisico);
        this.potencia = potencia;
        this.energia = energia;
    }

    public EquipoMaquinaria(String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String estadoFisico, float potencia, float energia) {
        super(nombre, marca, descripcion, credito, imagen, estado, estadoFisico);
        this.potencia = potencia;
        this.energia = energia;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public float getEnergia() {
        return energia;
    }

    public void setEnergia(float energia) {
        this.energia = energia;
    }

    @Override
    public String mostrarDatos() {
        String cadena = super.muestraArtNoFung();
        cadena += "\nEquipo de Maquinaria. ";
        cadena += "\n\tPotencia : " + getPotencia();
        cadena += "\n\tEnergía  : " + getEnergia();

        return cadena;
    }
}