package tp2.cartas;

import tp2.Jugador;
import tp2.Tablero;
import tp2.interfaces.CartaMagica;

public class AgujeroNegro implements CartaMagica {

	public void activarEfecto(Jugador jugadorActual, Jugador oponente) {
		jugadorActual.destruirMonstruos();
		oponente.destruirMonstruos();
		jugadorActual.mandarAlCementerio(this);
	}

	public void colocarEn(Tablero tablero) {
		tablero.colocarCarta(this);
	}

	public void mandarAlCementerio(Tablero tablero) {
		tablero.mandarAlCementerio(this);
	}

	@Override
	public String obtenerNombre() {
		return "Agujero Negro";
	}


}
