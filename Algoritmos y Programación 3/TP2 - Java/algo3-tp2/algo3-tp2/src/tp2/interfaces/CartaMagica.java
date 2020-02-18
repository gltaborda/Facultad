package tp2.interfaces;

import tp2.Jugador;

public interface CartaMagica extends Carta {

	void activarEfecto(Jugador jugadorActual, Jugador oponente);

}
