package tp2;

import tp2.interfaces.CartaCampo;
import tp2.interfaces.EstadoDeCampo;

public class ZonaDeCampo {

    private EstadoDeCampo estado = new CampoVacio();

    public void colocar(CartaCampo cartaCampo) {
        estado = estado.colocar(cartaCampo);
    }

	public CartaCampo obtenerCarta(CartaCampo cartaCampo) {
		return estado.obtenerCarta(cartaCampo, estado);
	}

	public void limpiarCampo(Tablero tablero) {
		estado.limpiarCampo(tablero);
	}

}
