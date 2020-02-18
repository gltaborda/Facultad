package tp2.estrategiasDeCartaMonstruo;

import tp2.CartaMonstruo;
import tp2.Jugador;
import tp2.excepciones.CartaBocaAbajoNoPuedeAtacarException;
import tp2.interfaces.EstadoJugador;
import tp2.interfaces.EstrategiaLadoCarta;
import tp2.interfaces.EstrategiaMonstruo;

public class LadoBocaAbajo implements EstrategiaLadoCarta {

private CartaMonstruo monstruo;
	
	public LadoBocaAbajo (CartaMonstruo monstruo) {
		this.monstruo = monstruo;
	}

	public EstadoJugador atacar(CartaMonstruo cartaOponente, EstrategiaMonstruo estrategia) {
		throw new CartaBocaAbajoNoPuedeAtacarException();
	}

	public EstadoJugador recibirAtaque(CartaMonstruo monstruoAtacante, int obtenerAtaque, 
EstrategiaMonstruo estrategia) {
		monstruo.voltear();
		return monstruo.activarEfectoDeVolteo(monstruoAtacante, obtenerAtaque, estrategia);
	}

	public void atacarDirectamente(Jugador oponente, EstrategiaMonstruo estrategia) {
		throw new CartaBocaAbajoNoPuedeAtacarException();
	}

	@Override
	public EstrategiaLadoCarta voltear() {
		return new LadoBocaArriba();
	}

}
