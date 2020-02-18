package tp2;

import tp2.excepciones.LaCartaNoEstaEnElCampoException;
import tp2.interfaces.CartaCampo;
import tp2.interfaces.EstadoDeCampo;

public class CampoVacio implements EstadoDeCampo {
	
	public EstadoDeCampo colocar(CartaCampo cartaCampo) {
		return new CampoOcupado(cartaCampo);
	}

	@Override
	public CartaCampo obtenerCarta(CartaCampo cartaCampo, EstadoDeCampo estado) {
		throw new LaCartaNoEstaEnElCampoException();
	}

	@Override
	public void limpiarCampo(Tablero tablero) {
		//No hace nada, esta vacio.
	}

}
