package tp2.interfaces;

import tp2.CartaMonstruo;
import tp2.Jugador;

public interface EstadoJugador {
	
	public void resolverAtaque(CartaMonstruo cartaJugador, CartaMonstruo cartaOponente, Jugador atacante, Jugador oponente);
	
}
