package com.ppva.model.usuarios;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;


public class RepositorioUsuarios {
    private ArrayList <Usuario> listadoUsuarios;
    public RepositorioUsuarios() {
        this.listadoUsuarios = new ArrayList<>();
    }
    private final String RUTA_ARCHIVO  = "data/usuarios.dat";

    public void insertarUsuarios(){
        Cliente cli1 = new Cliente("12345678A","Paco", "Aguilar", "666555444", LocalDate.parse("20-05-1940", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "Calle Sagunto, 22 Bajo", "example@example.com", "1234", true, 124, false);
        Cliente cli2 = new Cliente("12345678B","Sergio", "Ovejero", "666555445", LocalDate.parse("27-11-1986", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "Calle Altura, 66", "example2@example.com", "1234", true, 114, false);
        Administrador admin1 = new Administrador("12345678C","Victor", "Aparicio", "666555446", LocalDate.parse("20-05-1940", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "Calle Pepa, 66", "example3@example.com", "1234", true, LocalDate.parse("22-11-2024"), null);

        this.listadoUsuarios.add(cli1);
        this.listadoUsuarios.add(cli2);
        this.listadoUsuarios.add(admin1);
    }

    // Guardar listadoUsuarios (serializacion)
    public void guardarlistadoUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            oos.writeObject(this.listadoUsuarios);
            System.out.println("Lista guardada exitosamente en: " + RUTA_ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    // Leer listadoUsuarios
    public void deserializarLista() {
        @SuppressWarnings("unchecked") // Para evitar el aviso del cast de ArrayList
        File archivo = new File(RUTA_ARCHIVO);

        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                // Leemos el objeto y lo convertimos a ArrayList
                this.listadoUsuarios = (ArrayList<Usuario>) ois.readObject();
                System.out.println("Datos recuperados del archivo.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe todavía. Cargando datos por defecto...");
            insertarUsuarios();
        }
    }

    // Obtener Lista
    public ArrayList<Usuario> getLista() {
        return this.listadoUsuarios;
    }
}
