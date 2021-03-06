package tp2.cartas;

import tp2.CartaMonstruo;
import tp2.Tablero;
import tp2.estrategiasDeCartaMonstruo.InvocacionSinSacrificio;

public class MegaBolaDeTrueno extends CartaMonstruo {
	
	public MegaBolaDeTrueno() {
		nombre = "Mega Bola De Trueno";
		ataque = 750;
		defensa = 600;
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
