package Main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
		
	@Override
	public void start (Stage stage) throws Exception {
		
		stage.setTitle("Mi primera ventana");
		
		StackPane layout = new StackPane();
		
		// Creación de etiquetas
		
		Label etiqueta = new Label();
		
		etiqueta.setText("Teto de mi primer etiqueta");
		
		layout.getChildren().add(etiqueta);
		
		//Creacion de  cuadros de entrada de texto
		
		TextField entradaDeTexto = new TextField();
		
		entradaDeTexto.setText("puto");
		
		layout.getChildren().add(entradaDeTexto);
		
		//Creacion de areas de texto
		
		/*TextArea areaDeTexto = new TextArea();
		
		areaDeTexto.setPrefRowCount(20);
		areaDeTexto.setPrefWidth(400);
		
		layout.getChildren().add(areaDeTexto);*/
		
		//Creacion de botones 
		
		/* creacion de boton*/
		Button boton = new Button();
		
		boton.setText("Clickeame guachin");
		
		/* 3 formas de agregado de acciones al clickear el boton */ 
		/* prmiera */
		/*boton.setOnAction(new EventHandler<ActionEvent>() {
			
				public void handle(ActionEvent eventoDeAcction) {
					
					System.out.println("Me han clickeao");
					
				}
				
			}
		);*/
		
		/* segunda */
		/*boton.setOnAction(e->{
				System.out.println("Expresion");
				System.out.println("lambda");
			}
		);*/
		
		/* tercera, manejado con EventoDeManejoDeMiBoton */
		EventoDeManejoDeMiBoton eventoDeManejoDeMiBoton = new EventoDeManejoDeMiBoton(boton);
		
		boton.setOnAction(eventoDeManejoDeMiBoton);
		
		layout.getChildren().add(boton);
		
		Scene scene = new Scene(layout);
		
		stage.setScene(scene);
		
		stage.show();
		
		
	}
}
