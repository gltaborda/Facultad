package tp2;

import tp2.interfaces.EstadoJugador;

public class EstadoVencedor implements EstadoJugador {
	
	private int diferencia;
	
	public EstadoVencedor(int diferencia) {
		this.diferencia = diferencia;
	}

	public void resolverAtaque(CartaMonstruo cartaJugador, CartaMonstruo cartaOponente, Jugador atacante,
Jugador oponente) {
		oponente.mandarAlCementerio(cartaOponente);
		cartaOponente.descontarPuntosDeVida(oponente, diferencia);
	}

}
