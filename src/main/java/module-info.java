module com.example.appbiblicafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.appbiblicafx to javafx.fxml;
    exports com.example.appbiblicafx;
    exports com.example.appbiblicafx.controllers;
    opens com.example.appbiblicafx.controllers to javafx.fxml;
    exports com.example.appbiblicafx.utils;
    opens com.example.appbiblicafx.utils to javafx.fxml;
    exports com.example.appbiblicafx.models;
    opens com.example.appbiblicafx.models to javafx.fxml;
}