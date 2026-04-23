package com.ppva;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import com.ppva.model.usuarios.Cliente;

public class Launcher {
    public static void main(String[] args) {
        Scanner scTexto = new Scanner(System.in);
        Scanner scNumero = new Scanner(System.in);
        String nombre, apellidos, email, dni, contrasenya, telefono;
        LocalDate fechaNacimiento;
        int credito;
        boolean penalizado = false;

        // 1. Pedir DNI, Email, etc... (lo que ya tenías)
        System.out.print("Introduce nombre: ");
        nombre = scTexto.nextLine();

        System.out.print("Introduce los apellidos: ");
        apellidos = scTexto.nextLine();

        System.out.print("Introduce el dni: ");
        dni = scTexto.nextLine();

        System.out.print("Introduce el telefono: ");
        telefono = scTexto.nextLine();

        System.out.print("Introduce el e-mail: ");
        email = scTexto.nextLine();

        System.out.print("Contraseña: ");
        contrasenya = scTexto.nextLine();


        // 2. Pedir Fecha con validación
        LocalDate fechaNac; // Declaramos la variable
        System.out.print("Fecha de nacimiento (dd/mm/yyyy): ");

        try {
            // Usamos el formato que indicaste
            fechaNac = LocalDate.parse(scTexto.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) { // Es más específico que DateTimeException
            System.out.println("Error: Formato incorrecto. Se asignará la fecha de hoy por defecto.");
            fechaNac = LocalDate.now();
        }

        // 3. Pedir Crédito con validación (para que no explote si meten letras)
        System.out.print("Crédito inicial: ");
        try {
            credito = scNumero.nextInt();
        } catch (Exception e) {
            System.out.println("Error: No es un número. Crédito inicial: 0.");
            credito = 0;
            scNumero.nextLine(); // Limpiamos el búfer por si acaso
        }

        // 4. Creamos el cliente con TODO
        Cliente cli1 = new Cliente(dni, nombre, apellidos, "600000000", fechaNac, "Calle Falsa 123", email, contrasenya, true, credito, false);

        System.out.println("\n--- Cliente registrado con éxito ---");
        System.out.println(cli1.mostrarDatosUsuario());

        scTexto.close();
        scNumero.close();
    }
}
