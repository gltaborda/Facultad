package tp2.estrategiasDeCartaMonstruo;

import tp2.CartaMonstruo;
import tp2.EstadoDerrotado;
import tp2.EstadoEmpatado;
import tp2.EstadoVencedor;
import tp2.Jugador;
import tp2.interfaces.EstadoJugador;
import tp2.interfaces.EstrategiaMonstruo;

public class EstrategiaModoAtaque implements EstrategiaMonstruo {

	private CartaMonstruo monstruo;
	
	public EstrategiaModoAtaque (CartaMonstruo monstruo) {
		this.monstruo = monstruo;
	}

	public void descontarPuntosDeVida(Jugador oponente, int diferencia) {
		oponente.descontarPuntosDeVida(diferencia);
	}

	public EstadoJugador atacar(CartaMonstruo cartaOponente) {
		return cartaOponente.recibirAtaque(monstruo, monstruo.obtenerAtaque());
	}

	public EstadoJugador recibirAtaque(CartaMonstruo monstruoAtacante, int ataqueRecibido) {
		int diferencia = ataqueRecibido - monstruo.obtenerAtaque();
		if (ataqueRecibido > monstruo.obtenerAtaque()) return new EstadoVencedor(diferencia);
		if (ataqueRecibido == monstruo.obtenerAtaque()) return new EstadoEmpatado();
		return new EstadoDerrotado(diferencia);
	}

	@Override
	public void atacarDirectamente(Jugador oponente) {
		oponente.recibirAtaqueDirecto(monstruo.obtenerAtaque());
	}

}
