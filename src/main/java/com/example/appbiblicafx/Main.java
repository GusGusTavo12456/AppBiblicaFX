package com.example.appbiblicafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Objects;

/**
 * Clase principal para iniciar la aplicación bíblica JavaFX
 * ¡Que todo sea para la gloria y honra de Dios!
 */
public class Main extends Application {
    private static final String FXML_PATH = "/com/example/appbiblicafx/biblia.fxml";
    private static final String CSS_PATH = "/com/example/appbiblicafx/style.css";
    private static final String TITULO_APP = "📖 Aplicación Bíblica - ¡Gloria a Dios!";

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource(FXML_PATH)));
            Parent root = loader.load();

            Scene scene = new Scene(root, 800, 500);
            scene.getStylesheets().add(Objects.requireNonNull(
                    getClass().getResource(CSS_PATH)).toExternalForm());

            primaryStage.setTitle(TITULO_APP);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.centerOnScreen();
            primaryStage.show();

        } catch (Exception e) {
            mostrarAlertaError("Error al iniciar la aplicación", e.getMessage());
        }
    }

    /**
     * Muestra un cuadro de diálogo en caso de errores críticos.
     */
    private void mostrarAlertaError(String titulo, String mensaje) {
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText("¡Ha ocurrido un error inesperado!");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}