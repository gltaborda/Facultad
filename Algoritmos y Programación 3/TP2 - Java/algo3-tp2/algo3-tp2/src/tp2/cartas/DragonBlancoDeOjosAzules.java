package tp2.cartas;

import tp2.CartaMonstruo;
import tp2.Tablero;
import tp2.estrategiasDeCartaMonstruo.InvocacionConDosSacrificios;

public class DragonBlancoDeOjosAzules extends CartaMonstruo {

	public DragonBlancoDeOjosAzules() {
		nombre = "Dragon Blanco De Ojos Azules";
		ataque = 3000;
		defensa = 2500;
		nivel = 8;
		invocacion = new InvocacionConDosSacrificios();
	}

	public void mandarAlCementerio(Tablero tablero) {
		tablero.mandarAlCementerio(this);
	}

	public void voltearEn(Tablero tablero) {
		tablero.voltearCarta(this);
	}
}
