package tp2.interfaces;

import tp2.CartaMonstruo;
import tp2.Jugador;

public interface EstrategiaMonstruo {

	void descontarPuntosDeVida(Jugador oponente, int diferencia);

	EstadoJugador atacar(CartaMonstruo cartaOponente);

	EstadoJugador recibirAtaque(CartaMonstruo monstruoAtacante, int obtenerAtaque);

	void atacarDirectamente(Jugador oponente);
	
}
