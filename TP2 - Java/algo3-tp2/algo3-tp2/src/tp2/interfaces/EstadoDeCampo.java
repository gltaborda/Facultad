package tp2.interfaces;

import tp2.Tablero;

public interface EstadoDeCampo {

	public EstadoDeCampo colocar(CartaCampo cartaCampo);

	public CartaCampo obtenerCarta(CartaCampo cartaCampo, EstadoDeCampo estado);

	public void limpiarCampo(Tablero tablero);
}
