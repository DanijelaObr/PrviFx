module com.example.prvifx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires json.simple;
    requires java.logging;

    opens com.example.projekatDiamondCircle to javafx.fxml;
    exports com.example.projekatDiamondCircle;
    exports com.example.cards;
    opens com.example.cards to javafx.fxml;
}