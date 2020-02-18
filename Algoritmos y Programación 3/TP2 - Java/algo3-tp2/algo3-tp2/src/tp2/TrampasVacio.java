package tp2;

import tp2.excepciones.LaCartaNoEstaEnElCampoException;
import tp2.interfaces.CartaTrampa;
import tp2.interfaces.EstadoDeTrampas;

public class TrampasVacio implements EstadoDeTrampas {

	public void activarTrampa(CartaMonstruo monstruoAtacante, CartaMonstruo cartaPropia, Jugador jugadorAtacante, 
Jugador jugador) {
		jugadorAtacante.finalizarAtaque(monstruoAtacante, cartaPropia, jugador);	
	}

	public void activarTrampa(CartaMonstruo monstruoAtacante, Jugador jugadorAtacante, Jugador jugador) {
		monstruoAtacante.descontarPuntosDeVida(jugador);
	}

	public EstadoDeTrampas colocar(CartaTrampa cartaTrampa) {
		EstadoDeTrampas estado = new TrampasOcupado();
		estado.colocar(cartaTrampa);
		return estado;
	}

	public boolean contieneA(CartaTrampa cartaTrampa) {
		return false;
	}

	public CartaTrampa obtenerCarta(CartaTrampa cartaTrampa) {
		throw new LaCartaNoEstaEnElCampoException();
	}

}
