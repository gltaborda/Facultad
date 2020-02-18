package tp2.cartas;

import tp2.ParteDeExodia;
import tp2.Tablero;
import tp2.estrategiasDeCartaMonstruo.InvocacionSinSacrificio;

public class BrazoDerechoDelProhibido extends ParteDeExodia {

	public BrazoDerechoDelProhibido() {
		nombre = "Brazo Derecho Del Prohibido";
		ataque = 200;
		defensa = 300;
		nivel = 1;
		invocacion = new InvocacionSinSacrificio();
	}
	
	public void mandarAlCementerio(Tablero tablero) {
		tablero.mandarAlCementerio(this);
	}

	public void voltearEn(Tablero tablero) {
		tablero.voltearCarta(this);
	}
}
