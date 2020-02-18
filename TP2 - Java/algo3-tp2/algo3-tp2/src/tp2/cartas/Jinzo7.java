package tp2.cartas;

import tp2.CartaMonstruo;
import tp2.Jugador;
import tp2.Tablero;
import tp2.estrategiasDeCartaMonstruo.InvocacionSinSacrificio;

public class Jinzo7 extends CartaMonstruo {

	public Jinzo7() {
		nombre = "Jinzo 7";
		ataque = 500;
		defensa = 400;
		nivel = 2;
		invocacion = new InvocacionSinSacrificio();
	}

	public void activarEfecto(Jugador jugadorActual, Jugador oponente) {
		oponente.descontarPuntosDeVida(500);
	}
	public void mandarAlCementerio(Tablero tablero) {
		tablero.mandarAlCementerio(this);
	}

	public void voltearEn(Tablero tablero) {
		tablero.voltearCarta(this);
	}

}
