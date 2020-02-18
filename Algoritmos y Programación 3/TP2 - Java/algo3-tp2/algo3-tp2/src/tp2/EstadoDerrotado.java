package tp2;

import tp2.interfaces.EstadoJugador;

public class EstadoDerrotado implements EstadoJugador {
	
	private int diferencia;
	
	public EstadoDerrotado(int diferencia) {
		this.diferencia = diferencia;
	}

	public void resolverAtaque(CartaMonstruo cartaJugador, CartaMonstruo cartaOponente, Jugador jugador,
Jugador oponente) {
		jugador.mandarAlCementerio(cartaJugador);
		jugador.descontarPuntosDeVida(- diferencia); //la diferencia es negativa, la paso a positiva.
	}

	
}
