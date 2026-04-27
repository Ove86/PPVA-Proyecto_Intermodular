module com.ppva {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.base; // Incluido por defecto, pero útil recordarlo para LocalDate

    // Permitir que JavaFX acceda a la clase principal (App/Launcher)
    opens com.ppva to javafx.fxml;
    exports com.ppva;

    // MUY IMPORTANTE: Abrir el modelo para que la UI pueda leer los atributos de tus objetos
    opens com.ppva.model.usuarios to javafx.base, javafx.fxml;
    opens com.ppva.model.articulos to javafx.base, javafx.fxml;
    opens com.ppva.model.reservas to javafx.base, javafx.fxml;

    // Permitir que JavaFX infle las vistas FXML usando tus controladores
    opens com.ppva.controller to javafx.fxml;
    exports com.ppva.controller;
}