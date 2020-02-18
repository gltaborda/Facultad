package tp2.cartas;

import tp2.Jugador;
import tp2.Tablero;
import tp2.interfaces.CartaMagica;

public class OllaDeLaCodicia implements CartaMagica {

	public void activarEfecto(Jugador jugadorActual, Jugador oponente) {
		for(int i = 0; i < 2; ++i) jugadorActual.tomarCarta();
	}
	
	public void colocarEn(Tablero tablero) {
		tablero.colocarCarta(this);
	}

	public void mandarAlCementerio(Tablero tablero) {
		tablero.mandarAlCementerio(this);
	}

	@Override
	public String obtenerNombre() {
		return "Olla de la Codicia";
	}
}
