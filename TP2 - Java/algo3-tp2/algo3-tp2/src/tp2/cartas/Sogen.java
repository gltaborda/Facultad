package tp2.cartas;

import tp2.Jugador;
import tp2.Tablero;
import tp2.interfaces.CartaCampo;

public class Sogen implements CartaCampo {

	public void activarEfecto(Jugador jugadorActual, Jugador oponente) {
		jugadorActual.aumentarDefensa(500);
		oponente.aumentarAtaque(200);
	}

	public void colocarEn(Tablero tablero) {
		tablero.colocarCarta(this);
	}
	
	public void mandarAlCementerio(Tablero tablero) {
		tablero.mandarAlCementerio(this);
	}

	@Override
	public String obtenerNombre() {
		return "Sogen";
	}

	public void voltearEn(Tablero tablero) {
		//Las cartas de campo no pueden voltearse.
	}
}