package com.example.appbiblicafx.controllers;

import com.example.appbiblicafx.models.Versiculo;
import com.example.appbiblicafx.utils.BibliaData;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class BibliaController {

    @FXML private ListView<Versiculo> listaVersiculos;
    @FXML private Label labelReferencia;
    @FXML private Label labelTexto;
    @FXML private Button btnFavorito;
    @FXML private Button btnBuscar;

    @FXML
    public void initialize() {
        configurarListaVersiculos();
        cargarVersiculos();
        configurarBotones(); // ← Nuevo
    }

    private void configurarListaVersiculos() {
        listaVersiculos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        listaVersiculos.getSelectionModel().selectedItemProperty()
                .addListener((obs, anterior, actual) -> {
                    if (actual != null) {
                        mostrarVersiculo(actual);
                    }
                });
    }

    private void cargarVersiculos() {
        try {
            listaVersiculos.getItems().setAll(BibliaData.obtenerVersiculos());

            if (!listaVersiculos.getItems().isEmpty()) {
                listaVersiculos.getSelectionModel().selectFirst();
            } else {
                mostrarMensaje("No hay versículos disponibles para mostrar.");
            }

        } catch (Exception e) {
            mostrarMensaje("Error al cargar versículos: " + e.getMessage());
        }
    }

    private void mostrarVersiculo(Versiculo versiculo) {
        labelReferencia.setText(versiculo.getReferencia());
        labelTexto.setText(versiculo.getTexto());
    }

    private void configurarBotones() {
        btnBuscar.setOnAction(e -> onBuscar());
        btnFavorito.setOnAction(e -> onMarcarFavorito());
    }

    private void onBuscar() {
        mostrarMensaje("Función de búsqueda próximamente 🙏");
    }

    private void onMarcarFavorito() {
        Versiculo seleccionado = listaVersiculos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            mostrarMensaje("📌 Versículo marcado como favorito:\n\n" + seleccionado.getReferencia());
        } else {
            mostrarMensaje("Selecciona un versículo primero.");
        }
    }

    private void mostrarMensaje(String mensaje) {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Mensaje de la Aplicación Bíblica");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
