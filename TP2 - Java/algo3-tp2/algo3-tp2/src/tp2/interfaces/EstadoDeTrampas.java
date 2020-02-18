package tp2.interfaces;

import tp2.CartaMonstruo;
import tp2.Jugador;

public interface EstadoDeTrampas {

	void activarTrampa(CartaMonstruo monstruoAtacante, CartaMonstruo cartaPropia, Jugador jugadorAtacante, Jugador jugador);

	void activarTrampa(CartaMonstruo monstruoAtacante, Jugador jugadorAtacante, Jugador jugador);

	EstadoDeTrampas colocar(CartaTrampa cartaTrampa);

	boolean contieneA(CartaTrampa cartaTrampa);

	CartaTrampa obtenerCarta(CartaTrampa cartaTrampa);

}
