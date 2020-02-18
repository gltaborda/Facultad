package tp2.cartas;

import tp2.CartaMonstruo;
import tp2.EstadoDerrotado;
import tp2.Tablero;
import tp2.estrategiasDeCartaMonstruo.InvocacionSinSacrificio;
import tp2.interfaces.EstadoJugador;
import tp2.interfaces.EstrategiaMonstruo;

public class InsectoComeHombres extends CartaMonstruo {

	public InsectoComeHombres() {
		ataque = 450;
		defensa = 600;
		nivel = 2;
		invocacion = new InvocacionSinSacrificio();
	}
	
	public EstadoJugador activarEfectoDeVolteo(CartaMonstruo monstruoAtacante, int obtenerAtaque,
EstrategiaMonstruo estrategia2) {
		int ataqueALosPuntosDeVidaDelRival = 0;
		return new EstadoDerrotado(ataqueALosPuntosDeVidaDelRival);
	}
	
	public void mandarAlCementerio(Tablero tablero) {
		tablero.mandarAlCementerio(this);
	}

	public void voltearEn(Tablero tablero) {
		tablero.voltearCarta(this);
	}
	
}
