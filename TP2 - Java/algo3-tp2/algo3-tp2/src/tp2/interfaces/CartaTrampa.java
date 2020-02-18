package tp2.interfaces;

import tp2.CartaMonstruo;
import tp2.Jugador;

public interface CartaTrampa extends Carta {

	void activarTrampa(CartaMonstruo monstruoAtacante, CartaMonstruo monstruo, Jugador jugadorAtacante, Jugador jugador);

	void activarTrampa(CartaMonstruo monstruoAtacante, Jugador jugadorAtacante, Jugador jugador);

}
