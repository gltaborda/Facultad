package tp2;

import tp2.excepciones.LaZonaDeTrampasYMagicasEstaLlenaException;
import tp2.interfaces.CartaMagica;
import tp2.interfaces.CartaTrampa;

public class ZonaDeTrampasYMagicas {

	private ZonaDeTrampas zonaDeTrampas = new ZonaDeTrampas();
	private ZonaDeMagicas zonaDeMagicas = new ZonaDeMagicas();
	private int cantidadCartas = 0;
	
	public boolean contieneA(CartaTrampa cartaTrampa) {
		return zonaDeTrampas.contieneA(cartaTrampa);
	}

	public void colocar(CartaTrampa cartaTrampa) {
		if (cantidadCartas == 5) throw new LaZonaDeTrampasYMagicasEstaLlenaException();
		zonaDeTrampas.colocar(cartaTrampa);
		cantidadCartas += 1;
	}

	public boolean contieneA(CartaMagica cartaMagica) {
		return zonaDeMagicas.contieneA(cartaMagica);
	}

	public void colocar(CartaMagica cartaMagica) {
		if (cantidadCartas == 5) throw new LaZonaDeTrampasYMagicasEstaLlenaException();
		zonaDeMagicas.colocar(cartaMagica);
        cantidadCartas += 1;
	}

	public CartaTrampa obtenerCarta(CartaTrampa cartaTrampa) {
		CartaTrampa trampa = zonaDeTrampas.obtenerCarta(cartaTrampa);
		cantidadCartas -= 1;
		return trampa;
	}

	public CartaMagica obtenerCarta(CartaMagica cartaMagica) {
		CartaMagica magica = zonaDeMagicas.obtenerCarta(cartaMagica);
		cantidadCartas -= 1;
		return magica;
	}

	public void activarTrampa(CartaMonstruo cartaJugadorAtacante, CartaMonstruo cartaPropia, Jugador jugadorAtacante,
			Jugador jugador) {
		zonaDeTrampas.activarTrampa(cartaJugadorAtacante, cartaPropia, jugadorAtacante, jugador);
	}

	public void activarTrampa(CartaMonstruo monstruoAtacante, Jugador jugadorAtacante, Jugador jugador) {
		zonaDeTrampas.activarTrampa(monstruoAtacante, jugadorAtacante, jugador);
		
	}

	public CartaMagica voltear(CartaMagica cartaMagica) {
		return zonaDeMagicas.voltearCarta(cartaMagica);
	}

}
