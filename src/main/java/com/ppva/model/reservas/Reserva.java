package com.ppva.model.reservas;

import com.ppva.model.articulos.Articulo;
import com.ppva.model.enums.EstadoReserva;
import com.ppva.model.usuarios.Cliente;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva implements Serializable {
    private int numReserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoReserva estadoReserva;
    private Cliente cliente; // Usamos el objeto completo
    private Articulo articulo;

    public Reserva(int numReserva, LocalDate fechaInicio, LocalDate fechaFin, EstadoReserva estadoReserva, Cliente cliente, Articulo articulo) {
        this.numReserva = numReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoReserva = estadoReserva;
        this.cliente = cliente;
        this.articulo = articulo;
    }

    public int getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public String mostrarReserva() {
        return "--- Reserva ---" +
                "\n Nº de reserva: " + numReserva +
                "\n Fecha inicio reserva: " + fechaInicio +
                "\n Fecha fin reserva: " + fechaFin +
                "\n Cliente:" + cliente +
                "\n Articulo: " + articulo +
                "\n Estado de la reserva=" + estadoReserva;
    }
}
