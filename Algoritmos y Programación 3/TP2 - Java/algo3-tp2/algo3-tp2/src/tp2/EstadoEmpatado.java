package tp2;

import tp2.interfaces.EstadoJugador;

public class EstadoEmpatado implements EstadoJugador {

	public void resolverAtaque(CartaMonstruo cartaJugador, CartaMonstruo cartaOponente, Jugador jugador,
Jugador oponente) {
		jugador.mandarAlCementerio(cartaJugador);
		oponente.mandarAlCementerio(cartaOponente);
	}

}
