package com.ppva.model.usuarios;

import java.io.*;
import java.util.ArrayList;
import java.time.LocalDate;

/*
public class RepositorioUsuarios {
    // Atributo encapsulado
    private ArrayList<Usuario> listado;
    // Ruta relativa a la carpeta que creamos
    private final String RUTA_ARCHIVO = "data/usuarios.dat";

    public RepositorioUsuarios() {
        this.listado = new ArrayList<>();
    }

    // MÉTODO 1: Inicializar datos manualmente
    public void inicializarDatos() {
        // Declaramos las variables justo antes de usarlas (Scope correcto)

        // Cliente 1
        Cliente c1 = new Cliente("12345678A", "carlos@email.com", "pass123", 100, false);
        c1.setNombre("Carlos");
        c1.setApellidos("García");

        // Cliente 2
        Cliente c2 = new Cliente("87654321B", "ana@email.com", "pass456", 250, false);
        c2.setNombre("Ana");
        c2.setApellidos("López");

        // Administrador (Asumiendo que fechaCese puede ser null si está activo)
        Administrador admin = new Administrador("11111111H", "admin@ppva.com", "adminpass",
                LocalDate.now(), null);
        admin.setNombre("Super");
        admin.setApellidos("Admin");

        this.listado.add(c1);
        this.listado.add(c2);
        this.listado.add(admin);

        System.out.println("Datos iniciales cargados en memoria.");
    }

    // MÉTODO 2: Guardar la lista completa en el archivo (Serialización)
    public void serializarLista() {
        // Usamos try-with-resources para asegurar el cierre de flujos
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            oos.writeObject(this.listado);
            System.out.println("Lista guardada exitosamente en: " + RUTA_ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    // MÉTODO 3: Leer la lista desde el archivo
    @SuppressWarnings("unchecked") // Para evitar el aviso del cast de ArrayList
    public void deserializarLista() {
        File archivo = new File(RUTA_ARCHIVO);

        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                // Leemos el objeto y lo convertimos a ArrayList
                this.listado = (ArrayList<Usuario>) ois.readObject();
                System.out.println("Datos recuperados del archivo.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe todavía. Cargando datos por defecto...");
            inicializarDatos();
        }
    }

    // MÉTODO 4: Obtener la lista (Punto único de salida)
    public ArrayList<Usuario> getLista() {
        return this.listado;
    }
}
 */

public class RepositorioUsuarios {
    private ArrayList <Usuario> listado;
    public RepositorioUsuarios() {
        this.listado = new ArrayList<>();
    }
    private final String RUTA_ARCHIVO  = "data/usuarios.dat";

    public void insertarClientes(){
        Cliente cli1 = new Cliente("12345678A","Paco", "Aguilar", "666555444", LocalDate.parse("20-05-1940"), "Calle Sagunto, 22 Bajo", "example@example.com", "1234", true, 124, false);
        Cliente cli2 = new Cliente("12345678B","Sergio", "Ovejero", "666555445", LocalDate.parse("27-11-1986"), "Calle Altura, 66", "example2@example.com", "1234", true, 114, false);
        Administrador admin1 = new Administrador("12345678C","Victor", "Aparicio", "666555446", LocalDate.parse("20-05-1940"), "Calle Pepa, 66", "example3@example.com", "1234", true, LocalDate.parse("22-11-2024"), null);

        this.listado.add(cli1);
        this.listado.add(cli2);
        this.listado.add(admin1);
    }


}
