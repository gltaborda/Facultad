package tp2.cartas;

import tp2.CartaMonstruo;
import tp2.Tablero;
import tp2.estrategiasDeCartaMonstruo.InvocacionSinSacrificio;

public class SoldadoGiganteDePiedra extends CartaMonstruo {

	public SoldadoGiganteDePiedra() {
		nombre = "Soldado Gigante De Piedra";
		ataque = 1200;
		defensa = 2000;
		nivel = 4;
		invocacion = new InvocacionSinSacrificio();
	}
	
	public void mandarAlCementerio(Tablero tablero) {
		tablero.mandarAlCementerio(this);
	}

	public void voltearEn(Tablero tablero) {
		tablero.voltearCarta(this);
	}
}
