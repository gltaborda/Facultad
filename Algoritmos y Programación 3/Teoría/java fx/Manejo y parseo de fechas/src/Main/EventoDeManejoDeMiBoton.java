package Main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class EventoDeManejoDeMiBoton implements EventHandler<ActionEvent>{
	
	private Button miBoton;
	
	public EventoDeManejoDeMiBoton(Button unBoton) {
		
		miBoton = unBoton;
		
	}
	
	@Override
	public void handle(ActionEvent eventoDeManejo) {
		
		String textoClikeado = "me clickearon la con...";
		
		System.out.println(textoClikeado);
		
		miBoton.setText(textoClikeado);
		
	}
}
