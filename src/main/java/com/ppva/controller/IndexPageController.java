package com.ppva.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import com.ppva.model.articulos.RepositorioArticulos;

public class IndexPageController {

    @FXML private TextField buscadorField;
    @FXML private VBox sidebar;
    @FXML private VBox contenedorArticulos;

    private RepositorioArticulos repoArticulos;

    @FXML
    public void initialize() {
        repoArticulos = new RepositorioArticulos();
        repoArticulos.deserializarLista();

        // Aquí llamaríamos a una función para dibujar los artículos
        mostrarArticulosEnPantalla();
    }

    @FXML
    private void handleBuscar() {
        System.out.println("Buscando: " + buscadorField.getText());
    }

    @FXML
    private void handleFiltrar() {
        System.out.println("Filtrando contenido...");
    }

    @FXML
    private void iniciarSesion() {
        System.out.println("Abriendo ventana de login...");
    }

    private void mostrarArticulosEnPantalla() {
        // Lógica para crear etiquetas/tarjetas dinámicamente
    }
}