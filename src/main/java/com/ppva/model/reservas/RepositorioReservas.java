package com.ppva.model.reservas;

import com.ppva.model.articulos.Articulo;
import com.ppva.model.articulos.HerramientaManual;
import com.ppva.model.articulos.RepositorioArticulos;
import com.ppva.model.enums.EstadoReserva;
import com.ppva.model.usuarios.Cliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RepositorioReservas {
    private ArrayList <Reserva> listadoReservas;
    public RepositorioReservas(){this.listadoReservas = new ArrayList<>();}
    private final String RUTA_ARCHIVO_RESERVAS = "data/reservas.dat";

    public void insertarReserva() {
        Cliente cli1 = new Cliente
                ("12345678A","Paco", "Aguilar", "666555444", LocalDate.parse("20-05-1940", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "Calle Sagunto, 22 Bajo", "example@example.com", "1234", true, 124, false);

        Articulo art2 = new HerramientaManual(124, "Taladro 720", "nuevo", "electrico");

        Reserva res1 = new Reserva(1, LocalDate.now(), LocalDate.now().plusDays(7),
                EstadoReserva.PENDIENTECONFIRMAR, cli1, art2);

        this.listadoReservas.add(res1);
    }

}
