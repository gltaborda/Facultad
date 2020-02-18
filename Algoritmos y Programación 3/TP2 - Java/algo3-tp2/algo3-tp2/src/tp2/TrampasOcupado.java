package tp2;

import java.util.ArrayList;
import java.util.List;

import tp2.excepciones.LaCartaNoEstaEnElCampoException;
import tp2.interfaces.CartaTrampa;
import tp2.interfaces.EstadoDeTrampas;

public class TrampasOcupado implements EstadoDeTrampas {

	private List<CartaTrampa> trampas = new ArrayList<CartaTrampa>();

	public void activarTrampa(CartaMonstruo monstruoAtacante, CartaMonstruo cartaPropia, Jugador jugadorAtacante,
			Jugador jugador) {
		CartaTrampa trampa = trampas.remove(0);
		trampa.activarTrampa(monstruoAtacante, cartaPropia, jugadorAtacante, jugador);
	}

	public void activarTrampa(CartaMonstruo monstruoAtacante, Jugador jugadorAtacante, Jugador jugador) {
		CartaTrampa trampa = trampas.remove(0);
    	trampa.activarTrampa(monstruoAtacante, jugadorAtacante, jugador);
	}

	public EstadoDeTrampas colocar(CartaTrampa cartaTrampa) {
		trampas.add(cartaTrampa);
		return this;
	}

	public boolean contieneA(CartaTrampa cartaTrampa) {
		return trampas.contains(cartaTrampa);
	}

	public CartaTrampa obtenerCarta(CartaTrampa cartaTrampa) {
		 if (! trampas.contains(cartaTrampa)) throw new LaCartaNoEstaEnElCampoException();
	     int indice = trampas.indexOf(cartaTrampa);
	     return trampas.remove(indice);
	}

}
