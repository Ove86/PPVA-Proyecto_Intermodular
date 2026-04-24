package com.ppva.model.persistence;

import com.ppva.model.usuarios.Cliente;

import java.io.*;

public class GestionFicheros {
    public static void GuardarCliente(Cliente c){
        File f = new File("cliente_test.dat");

        // Usamos try-with-resources (cierra el flujo automáticamente)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
            oos.writeObject(c);
            System.out.println("Éxito: Cliente guardado correctamente.");
        } catch (IOException e){
            System.out.println("Error al escribir el fichero: " + e.getMessage());
        }
    }

    public static Cliente leerCliente(){
        Cliente aux = null;
        File f = new File("cliente_test.dat");

        if (f.exists()){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
                aux = (Cliente) ois.readObject();
            } catch (IOException | ClassNotFoundException e){
                System.out.println("Error al leer: " + e.getMessage());
            }
        }
        return aux;
    }
}
