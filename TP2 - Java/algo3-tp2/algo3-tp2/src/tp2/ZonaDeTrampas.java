package tp2;

import tp2.interfaces.CartaTrampa;
import tp2.interfaces.EstadoDeTrampas;

public class ZonaDeTrampas {

    private EstadoDeTrampas estado = new TrampasVacio();

    public void colocar(CartaTrampa cartaTrampa) {
        estado = estado.colocar(cartaTrampa);
    }

    public void activarTrampa(CartaMonstruo monstruoAtacante, CartaMonstruo cartaPropia, Jugador jugadorAtacante,
Jugador jugador) {
    	estado.activarTrampa(monstruoAtacante, cartaPropia, jugadorAtacante, jugador);
    }

	public void activarTrampa(CartaMonstruo monstruoAtacante, Jugador jugadorAtacante, Jugador jugador) {
		estado.activarTrampa(monstruoAtacante, jugadorAtacante, jugador);
    }
    
    public boolean contieneA(CartaTrampa cartaTrampa) {
        return estado.contieneA(cartaTrampa);
    }

    public CartaTrampa obtenerCarta(CartaTrampa cartaTrampa) {
    	return estado.obtenerCarta(cartaTrampa);
    }

}
