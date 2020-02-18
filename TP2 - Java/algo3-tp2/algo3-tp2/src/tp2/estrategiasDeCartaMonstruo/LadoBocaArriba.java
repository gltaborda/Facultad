package tp2.estrategiasDeCartaMonstruo;

import tp2.CartaMonstruo;
import tp2.Jugador;
import tp2.excepciones.UnaCartaBocaArribaNoPuedeVoltearseException;
import tp2.interfaces.EstadoJugador;
import tp2.interfaces.EstrategiaLadoCarta;
import tp2.interfaces.EstrategiaMonstruo;

public class LadoBocaArriba implements EstrategiaLadoCarta {

	public EstadoJugador atacar(CartaMonstruo cartaOponente, EstrategiaMonstruo estrategia) {
		return estrategia.atacar(cartaOponente);
	}

	public EstadoJugador recibirAtaque(CartaMonstruo monstruo, int obtenerAtaque, 
EstrategiaMonstruo estrategia) {
		return estrategia.recibirAtaque(monstruo, obtenerAtaque);
	}

	public void atacarDirectamente(Jugador oponente, EstrategiaMonstruo estrategia) {
		estrategia.atacarDirectamente(oponente);
	}

	@Override
	public EstrategiaLadoCarta voltear() {
		throw new UnaCartaBocaArribaNoPuedeVoltearseException();
	}
	
}
