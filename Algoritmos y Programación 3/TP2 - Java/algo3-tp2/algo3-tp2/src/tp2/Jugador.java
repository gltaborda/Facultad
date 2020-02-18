package tp2;

import tp2.interfaces.Carta;
import tp2.interfaces.CartaCampo;
import tp2.interfaces.CartaMagica;
import tp2.interfaces.CartaTrampa;
import tp2.interfaces.EstadoJugador;

import java.util.List;

public class Jugador {
	
	private int puntosDeVida = 8000;
	private Tablero tablero = new Tablero();
	private EstadoJugador estado;
	private Mano mano = new Mano();
	private Mazo mazo = new Mazo();
	private boolean perdedor = false;
	private boolean ganador = false;

	public Jugador() {
	}
	
	public boolean estaEnCementerio(Carta carta) {
		return tablero.estaEnCementerio(carta);
	}

	public int obtenerPuntosDeVida() {
		return puntosDeVida;
	}

	public void mandarAlCementerio(Carta carta) {
		tablero.mandarAlCementerio(carta);
	}

	public void descontarPuntosDeVida(int diferencia) {
		puntosDeVida -= diferencia;
		if (puntosDeVida < 0) Juego.getInstance().jugadorHaGanado();
	}

	public void destruirMonstruos() {
		tablero.destruirMonstruos();
	}

	public boolean estaEnCampo(CartaMonstruo cartaMonstruo) {
		return tablero.estaEnCampo(cartaMonstruo);
	}

	public void aumentarAtaque(int ataque) {
		tablero.aumentarAtaque(ataque);
	}

	public void aumentarDefensa(int defensa) {
		tablero.aumentarDefensa(defensa);
	}

	public int obtenerCantidadCartas() {
		return mano.obtenerCantidadCartas();
	}

	public void tomarCarta() {
		mazo.agregarCartaEn(mano);
	}

	public void destruirCartaMenorAtaque() {
		tablero.destruirCartaMenorAtaque();
	}

	public void activarEfecto(CartaMonstruo cartaMonstruo, Jugador oponente) {
		tablero.activarEfecto(cartaMonstruo, this, oponente);
	}

	public void recibirAtaqueDirecto(int ataqueRecibido) {
		tablero.recibirAtaqueDirecto(ataqueRecibido, this);
	}

	public void atacarAMonstruo(CartaMonstruo cartaJugador, CartaMonstruo cartaOponente, Jugador oponente) {
		oponente.activarTrampa(cartaJugador, cartaOponente, this);
	}
	
	public void atacarDirectamenteCon(CartaMonstruo cartaMonstruo, Jugador oponente) {
		oponente.activarTrampa(cartaMonstruo, this);
	}
	
	public void finalizarAtaque(CartaMonstruo cartaJugador, CartaMonstruo cartaOponente, Jugador oponente) {
		estado = cartaJugador.atacar(cartaOponente);
		estado.resolverAtaque(cartaJugador, cartaOponente, this, oponente);
	}
	
	public void activarTrampa(CartaMonstruo cartaJugadorAtacante, CartaMonstruo cartaPropia, Jugador jugadorAtacante){
		tablero.activarTrampa(cartaJugadorAtacante, cartaPropia, jugadorAtacante, this);
	}
	
	public void activarTrampa(CartaMonstruo monstruoAtacante, Jugador jugadorAtacante) {
		tablero.activarTrampa(monstruoAtacante, jugadorAtacante, this);
	}

	public void perdedor() {
		perdedor = true;
	}

	public void ganador() {
		ganador = true;
	}
	
	public boolean haPerdido() {
		return perdedor;
	}
	
	public boolean haGanado() {
		return ganador;
	}

	public void cambiarMano(Mano manoConExodia) {
		//Metodo para ultimo test.
		mano = manoConExodia;
	}

	public void colocarCarta(CartaTrampa cartaTrampa) {
		//Las trampas se colocan siempre boca abajo (no pueden activarse desde la mano).
		mano.retirarCarta(cartaTrampa);
		tablero.colocarCarta(cartaTrampa);
	}

	public void colocarCarta(CartaCampo cartaCampo, Jugador oponente) {
		mano.retirarCarta(cartaCampo);
		tablero.colocarCarta(cartaCampo);
		cartaCampo.activarEfecto(this, oponente);
	}

	public void colocarEnPosicionDeDefensaBocaAbajo(CartaMonstruo cartaMonstruo) {
		mano.retirarCarta(cartaMonstruo);
		cartaMonstruo.modoDefensa();
		cartaMonstruo.bocaAbajo();
		tablero.colocarCarta(cartaMonstruo);
	}

	public void colocarEnPosicionDeAtaqueBocaArriba(CartaMonstruo cartaMonstruo) {
		mano.retirarCarta(cartaMonstruo);
		cartaMonstruo.modoAtaque();
		cartaMonstruo.bocaArriba();
		tablero.colocarCarta(cartaMonstruo);
	}

	public void colocarEnPosicionDeDefensaBocaArriba(CartaMonstruo cartaMonstruo) {
		mano.retirarCarta(cartaMonstruo);
		cartaMonstruo.modoDefensa();
		cartaMonstruo.bocaArriba();
		tablero.colocarCarta(cartaMonstruo);
	}

	public void colocarEnPosicionDeAtaqueBocaAbajo(CartaMonstruo cartaMonstruo) {
		mano.retirarCarta(cartaMonstruo);
		cartaMonstruo.modoAtaque();
		cartaMonstruo.bocaAbajo();
		tablero.colocarCarta(cartaMonstruo);
	}

	public void colocarCartaEnMano(Carta carta) {
		mano.agregarCarta(carta);
	}

	public List<Carta> obtenerCartasEnMano() {
		return mano.obtenerCartasEnMano();
	}

	public List<CartaMonstruo> obtenerCartasEnZonaDeMonstruos() {
		return tablero.obtenerCartasEnZonaDeMonstruos();
	}

	public void activarCartaMagica(CartaMagica cartaMagica, Jugador oponente) {
		mano.retirarCarta(cartaMagica);
		tablero.colocarCarta(cartaMagica);
		cartaMagica.activarEfecto(this, oponente);
	}

	public void colocarCartaMagica(CartaMagica cartaMagica) {
		//Las cartas magicas solo se colocan boca abajo, sino, se activan desde la mano.
		mano.retirarCarta(cartaMagica);
		tablero.colocarCarta(cartaMagica);
	}

	public void voltearCarta(CartaMonstruo monstruo) {
		tablero.voltearCarta(monstruo);
	}

	public void voltearCarta(CartaMagica cartaMagica, Jugador oponente) {
		CartaMagica magica = tablero.voltearCarta(cartaMagica);
		magica.activarEfecto(this, oponente);
		tablero.mandarAlCementerio(magica);
	}
}
