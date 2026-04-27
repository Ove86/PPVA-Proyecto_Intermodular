package com.ppva.model.articulos;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class RepositorioArticulos {
    private ArrayList <Articulo> listadoArticulos;
    public  RepositorioArticulos(){this.listadoArticulos = new ArrayList<>();}
    private final String RUTA_ARCHIVO_ARTICULOS = "data/articulos.dat";

    public void insertarArticulo(){
        Articulo art1 = new MaterialConstruccion
                (123, "Saco de cemento", 1, LocalDate.of(2028, 06, 12), "saco");
        Articulo art2 = new HerramientaManual(124, "Taladro 720", "nuevo", "electrico");
        Articulo art3 = new ManualDigital (125, "Manual instrucciones Taladro 700W", "PDF", 24.40f, "Libre", false, "Manual", "2.1", 4 );


        this.listadoArticulos.add(art1);
        this.listadoArticulos.add(art2);
        this.listadoArticulos.add(art3);
    }

    // Guardar listadoArticulos
    public void guardarListadoArticulos(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO_ARTICULOS))) {
            oos.writeObject(this.listadoArticulos);
            System.out.println("Lista guardada exitosamente en: " + RUTA_ARCHIVO_ARTICULOS);
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    // Leer listadoUsuarios
    public void deserializarLista() {
        @SuppressWarnings("unchecked") // Para evitar el aviso del cast de ArrayList
        File archivo = new File(RUTA_ARCHIVO_ARTICULOS);

        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                // Leemos el objeto y lo convertimos a ArrayList
                this.listadoArticulos = (ArrayList<Articulo>) ois.readObject();
                System.out.println("Datos recuperados del archivo.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe todavía. Cargando datos por defecto...");
            insertarArticulo();
        }
    }

    // Obtener Lista
    public ArrayList<Articulo> getLista() {
        return this.listadoArticulos;
    }
}
