package tp2.cartas;

import tp2.CartaMonstruo;
import tp2.Tablero;
import tp2.estrategiasDeCartaMonstruo.InvocacionSinSacrificio;

public class Digitron extends CartaMonstruo {

	public Digitron() {
		nombre = "Digitron";
		ataque = 1500;
		defensa = 0;
		nivel = 2;
		invocacion = new InvocacionSinSacrificio();
	}
	
	public void mandarAlCementerio(Tablero tablero) {
		tablero.mandarAlCementerio(this);
	}

	public void voltearEn(Tablero tablero) {
		tablero.voltearCarta(this);
	}
}
