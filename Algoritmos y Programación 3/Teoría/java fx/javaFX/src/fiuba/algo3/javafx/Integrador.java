package fiuba.algo3.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import fiuba.algo3.javafx.eventos.manejadores.BotonEnviarEventHandler;
import fiuba.algo3.javafx.eventos.manejadores.BotonLimpiarEventHandler;
import fiuba.algo3.javafx.eventos.manejadores.TextoEventHandler;

public class Integrador extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Ejemplo Integrador");

        TextField texto = new TextField();
        texto.setPromptText("Ingrese el texto deseado");

        Label etiqueta = new Label();
        etiqueta.setText(texto.getText());

        Button botonEnviar = new Button();
        botonEnviar.setText("Enviar");

        Button botonLimpiar = new Button();
        botonLimpiar.setText("Limpiar cuadro texto");

        HBox contenedorHorizontal = new HBox(botonEnviar, botonLimpiar);
        contenedorHorizontal.setSpacing(10);

        VBox contenedorPrincipal = new VBox(texto, contenedorHorizontal, etiqueta);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20));

        BotonLimpiarEventHandler botonLimpiarEventHandler = new BotonLimpiarEventHandler(texto);
        botonLimpiar.setOnAction(botonLimpiarEventHandler);

        BotonEnviarEventHandler botonEnviarEventHandler = new BotonEnviarEventHandler(texto, etiqueta);
        botonEnviar.setOnAction(botonEnviarEventHandler);

        TextoEventHandler textoEventHandler = new TextoEventHandler(botonEnviar);
        texto.setOnKeyPressed(textoEventHandler);

        Scene scene = new Scene(contenedorPrincipal, 300, 250);

        stage.setScene(scene);

        stage.show();
    }
}