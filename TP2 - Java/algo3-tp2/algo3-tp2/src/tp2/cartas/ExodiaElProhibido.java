package tp2.cartas;

import tp2.ParteDeExodia;
import tp2.Tablero;
import tp2.estrategiasDeCartaMonstruo.InvocacionSinSacrificio;

public class ExodiaElProhibido extends ParteDeExodia {

	public ExodiaElProhibido() {
		nombre = "Exodia El Prohibido";
		ataque = 1000;
		defensa = 1000;
		nivel = 3;
		invocacion = new InvocacionSinSacrificio();
	}
	
	public void mandarAlCementerio(Tablero tablero) {
		tablero.mandarAlCementerio(this);
	}

	public void voltearEn(Tablero tablero) {
		tablero.voltearCarta(this);
	}
}
