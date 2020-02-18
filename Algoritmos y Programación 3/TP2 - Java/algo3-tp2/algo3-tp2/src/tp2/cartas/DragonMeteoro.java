package tp2.cartas;

import tp2.CartaMonstruo;
import tp2.Tablero;
import tp2.estrategiasDeCartaMonstruo.InvocacionConUnSacrificio;

public class DragonMeteoro extends CartaMonstruo {

	public DragonMeteoro() {
		nombre = "Dragon Meteoro";
		ataque = 1800;
		defensa = 2000;
		nivel = 6;
		invocacion = new InvocacionConUnSacrificio();
	}
	
	public void mandarAlCementerio(Tablero tablero) {
		tablero.mandarAlCementerio(this);
	}

	public void voltearEn(Tablero tablero) {
		tablero.voltearCarta(this);
	}
}
