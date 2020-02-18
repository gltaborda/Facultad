package tp2;

import javafx.scene.control.Label;
import tp2.interfaces.Carta;
import tp2.interfaces.CartaCampo;
import tp2.interfaces.CartaMagica;
import tp2.interfaces.CartaTrampa;

import java.util.ArrayList;
import java.util.List;

public class Juego {

	private static Juego instance = new Juego();
	Jugador jugadorActual = new Jugador(); //El jugador que empieza toma 6 cartas
	Jugador oponente = new Jugador();
	private boolean terminado;
			
	private Juego() {
	}
	
	public static Juego getInstance() {
		return instance;
	}
	
	public static Juego nuevoJuego() {
		instance = new Juego();
		instance.empezarJuego();
		return instance;
	}
	
	private void empezarJuego() {
		//Cuando empieza el juego, el jugador actual tiene 6 cartas y el oponente 5.
		for (int i=0; i<6; i++) jugadorActual.tomarCarta();
		for (int i=0; i<5; i++) oponente.tomarCarta();
	}

	public void terminarTurno() {
		//Hace un swap y toma una carta el jugador actual.
		Jugador copiaOponente = oponente;
		oponente = jugadorActual;
		jugadorActual = copiaOponente;
		jugadorActual.tomarCarta();
	}

	public void atacarCon(CartaMonstruo cartaJugador, CartaMonstruo cartaOponente) {
		jugadorActual.atacarAMonstruo(cartaJugador, cartaOponente, oponente);
	}
	
	public void atacarDirectamenteCon(CartaMonstruo cartaMonstruo) {
		jugadorActual.atacarDirectamenteCon(cartaMonstruo, oponente);
	}

	public boolean estaEnCementerio(Carta carta) {
		return jugadorActual.estaEnCementerio(carta);
	}

	public int obtenerPuntosDeVida() {
		return jugadorActual.obtenerPuntosDeVida();
	}

	public void activarCartaMagica(CartaMagica cartaMagica) {
		//Activo una carta magica que tenga en la mano.
		jugadorActual.activarCartaMagica(cartaMagica, oponente);
	}
	
	public void voltearMonstruo(CartaMonstruo monstruo) {
		jugadorActual.voltearCarta(monstruo);
	}

	public void colocarCartaCampo(CartaCampo cartaCampo) {
		jugadorActual.colocarCarta(cartaCampo, oponente);
	}

	public boolean estaEnCampo(CartaMonstruo cartaMonstruo) {
		return jugadorActual.estaEnCampo(cartaMonstruo);
	}

	public int obtenerCantidadCartas() {
		return jugadorActual.obtenerCantidadCartas();
	}

	public void activarEfecto(CartaMonstruo cartaMonstruo) {
		jugadorActual.activarEfecto(cartaMonstruo, oponente);
	}

	public void colocarEnPosicionDeDefensaBocaAbajo(CartaMonstruo cartaMonstruo) {
		jugadorActual.colocarEnPosicionDeDefensaBocaAbajo(cartaMonstruo);
	}

	public void colocarEnPosicionDeAtaqueBocaArriba(CartaMonstruo cartaMonstruo) {
		jugadorActual.colocarEnPosicionDeAtaqueBocaArriba(cartaMonstruo);
	}

	public void colocarEnPosicionDeDefensaBocaArriba(CartaMonstruo cartaMonstruo) {
		jugadorActual.colocarEnPosicionDeDefensaBocaArriba(cartaMonstruo);
	}

	public void colocarEnPosicionDeAtaqueBocaAbajo(CartaMonstruo cartaMonstruo) {
		jugadorActual.colocarEnPosicionDeAtaqueBocaAbajo(cartaMonstruo);
	}

	public void colocarCartaTrampa(CartaTrampa cilindroMagico) {
		jugadorActual.colocarCarta(cilindroMagico);
	}
	
	public void colocarCartaMagica(CartaMagica cartaMagica) {
		jugadorActual.colocarCartaMagica(cartaMagica);
	}
	
	public boolean haTerminado() {
		return terminado;
	}
	
	public void jugadorHaPerdido() {
		jugadorActual.perdedor();
		oponente.ganador();
		terminado = true;
	}

	public void jugadorHaGanado() {
		jugadorActual.ganador();
		oponente.perdedor();
		terminado = true;
	}

	public void agregarExodia(ParteDeExodia cabeza, ParteDeExodia brazoDerecho, ParteDeExodia brazoIzquierdo,
			ParteDeExodia piernaDerecha, ParteDeExodia piernaIzquierda) {
		//Metodo que coloca las 5 partes de exodia en la mano de un jugador, es para el ultimo test.
		Mano manoConExodia = new Mano();
		jugadorActual.cambiarMano(manoConExodia);
		manoConExodia.agregarParteExodia(cabeza);
		manoConExodia.agregarParteExodia(brazoDerecho);
		manoConExodia.agregarParteExodia(brazoIzquierdo);
		manoConExodia.agregarParteExodia(piernaDerecha);
		manoConExodia.agregarParteExodia(piernaIzquierda);
	}

	public void colocarCartaEnMano(Carta carta) {
		jugadorActual.colocarCartaEnMano(carta);
	}
	
	public void voltearCarta(CartaMagica cartaMagica) {
		jugadorActual.voltearCarta(cartaMagica, oponente);
	}

	public Jugador obtenerJugadorActual() {
		return jugadorActual;
	}

	public Jugador obtenerOponente() {
		return oponente;
	}

	public String getFase() {
		return null;
		// return this.fase.getNombre(); algo así sería?
	}

	public void terminarFase() {
		// this.fase.siguienteFase(); algo así?
	}
}
