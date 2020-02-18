package tp2.cartas;

import tp2.CartaMonstruo;
import tp2.Tablero;
import tp2.estrategiasDeCartaMonstruo.InvocacionDragonDefinitivo;

public class DragonDefinitivoDeOjosAzules extends CartaMonstruo {

	public DragonDefinitivoDeOjosAzules() {
		nombre = "Dragon Definitivo De Ojos Azules";
		ataque = 4500;
		defensa = 3800;
		nivel = 12;
		invocacion = new InvocacionDragonDefinitivo();
	}

	public void mandarAlCementerio(Tablero tablero) {
		tablero.mandarAlCementerio(this);
	}

	public void voltearEn(Tablero tablero) {
		tablero.voltearCarta(this);
	}
}
