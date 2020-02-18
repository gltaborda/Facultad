package tp2;

import tp2.excepciones.LaCartaNoEstaEnElCampoException;
import tp2.interfaces.CartaCampo;
import tp2.interfaces.EstadoDeCampo;

public class CampoOcupado implements EstadoDeCampo {

	private CartaCampo campo;
	
	public CampoOcupado (CartaCampo cartaCampo) {
		campo = cartaCampo;
	}
	
	@Override
	public EstadoDeCampo colocar(CartaCampo cartaCampo) {
		campo = cartaCampo;
		return this;
	}

	@Override
	public CartaCampo obtenerCarta(CartaCampo cartaCampo, EstadoDeCampo estado) {
		if (! (campo == cartaCampo)) throw new LaCartaNoEstaEnElCampoException();
		estado = new CampoVacio();
		return campo;
	}

	@Override
	public void limpiarCampo(Tablero tablero) {
		tablero.mandarAlCementerio(campo);
	}
}
