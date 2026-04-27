package com.ppva;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("indexPage.fxml"));

        Parent root = fxmlLoader.load();

        // 2. Creamos la escena (la "lámina" donde va el dibujo)
        Scene scene = new Scene(root, 1000, 700);

        // 3. Configuramos el escenario (la "ventana")
        stage.setTitle("PPVA - Gestión de Préstamos Comunitarios");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(); // Este método es el que arranca todo el motor de JavaFX
    }
}
