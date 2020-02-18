package tp2.interfaces;

import tp2.CartaMonstruo;
import tp2.Jugador;

public interface EstrategiaLadoCarta {

	EstadoJugador atacar(CartaMonstruo cartaOponente, EstrategiaMonstruo estrategia);

	EstadoJugador recibirAtaque(CartaMonstruo monstruo, int obtenerAtaque, EstrategiaMonstruo estrategia);

	void atacarDirectamente(Jugador oponente, EstrategiaMonstruo estrategia);

	EstrategiaLadoCarta voltear();

}
