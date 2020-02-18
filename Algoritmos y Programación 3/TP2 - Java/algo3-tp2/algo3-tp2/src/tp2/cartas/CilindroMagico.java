package tp2.cartas;

import tp2.CartaMonstruo;
import tp2.Jugador;
import tp2.Tablero;
import tp2.interfaces.CartaTrampa;

public class CilindroMagico implements CartaTrampa {

	public void activarTrampa(CartaMonstruo cartaJugadorAtacante, CartaMonstruo cartaPropia, Jugador jugadorAtacante,
Jugador jugador) {
		cartaJugadorAtacante.descontarPuntosDeVida(jugadorAtacante);
	}
	
	public void activarTrampa(CartaMonstruo monstruoAtacante, Jugador jugadorAtacante, Jugador jugador) {
		monstruoAtacante.descontarPuntosDeVida(jugadorAtacante);
	}

	public void colocarEn(Tablero tablero) {
		tablero.colocarCarta(this);
	}
	
	public void mandarAlCementerio(Tablero tablero) {
		tablero.mandarAlCementerio(this);
	}

	@Override
	public String obtenerNombre() {
		return "Cilindro Mágico";
	}

}
