package tp2.estrategiasDeCartaMonstruo;

import tp2.CartaMonstruo;
import tp2.EstadoDerrotado;
import tp2.EstadoEmpatado;
import tp2.EstadoVencedor;
import tp2.Jugador;
import tp2.excepciones.CartaEnModoDeDefensaNoPuedeAtacarException;
import tp2.interfaces.EstadoJugador;
import tp2.interfaces.EstrategiaMonstruo;

public class EstrategiaModoDefensa implements EstrategiaMonstruo {

	private CartaMonstruo monstruo;
	
	public EstrategiaModoDefensa(CartaMonstruo monstruo) {
		this.monstruo = monstruo;
	}

	public void descontarPuntosDeVida(Jugador oponente, int diferencia) {
	}

	public EstadoJugador atacar(CartaMonstruo cartaOponente) {
		throw new CartaEnModoDeDefensaNoPuedeAtacarException();
	}

	public EstadoJugador recibirAtaque(CartaMonstruo monstruoAtacante, int ataqueRecibido) {
		int diferencia = ataqueRecibido - monstruo.obtenerDefensa();
		if (ataqueRecibido > monstruo.obtenerDefensa()) return new EstadoVencedor(diferencia);
		if (ataqueRecibido == monstruo.obtenerDefensa()) return new EstadoEmpatado();
		return new EstadoDerrotado(diferencia);
	}
	
	public void atacarDirectamente(Jugador oponente) {
		throw new CartaEnModoDeDefensaNoPuedeAtacarException();
	}

}
