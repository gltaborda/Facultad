package tp2;
import static org.junit.Assert.*;

import org.junit.Test;

import tp2.CartaMonstruo;
import tp2.Jugador;
import tp2.cartas.BebeDragon;
import tp2.cartas.Digitron;
import tp2.cartas.OllaDeLaCodicia;
import tp2.excepciones.ElJugadorTieneMonstruosEnElCampoException;
import tp2.excepciones.LaCartaNoEstaEnElCampoException;
import tp2.excepciones.LaCartaNoEstaEnLaManoException;
import tp2.interfaces.CartaMagica;

public class JugadorTest {

	@Test
	public void testObtenerCantidadCartasDevuelveCeroAlInicializar() {
		Jugador jugador = new Jugador();
		
		int cartasEnMano = 0;
		assertEquals(cartasEnMano, jugador.obtenerCantidadCartas());
	}
	
	@Test
	public void testAtacarDirectamenteAOtroJugadorReduceSusPuntosDeVida() {
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		CartaMonstruo bebeDragon = new BebeDragon();
		jugador.colocarCartaEnMano(bebeDragon);
		jugador.colocarEnPosicionDeAtaqueBocaArriba(bebeDragon);
		jugador.atacarDirectamenteCon(bebeDragon, oponente);
		
		int puntosDeVidaEsperados = 8000 - 1200;
		
		assertEquals(puntosDeVidaEsperados, oponente.obtenerPuntosDeVida());
	}
	
	@Test
	public void testColocarCartaQueNoEstaEnLaManoLanzaExcepcion() {
		Jugador jugador = new Jugador();
		CartaMonstruo bebeDragon = new BebeDragon();
		boolean lanzaError = false;
		try {
			jugador.colocarEnPosicionDeAtaqueBocaArriba(bebeDragon);
		}
		catch(LaCartaNoEstaEnLaManoException e) {
			lanzaError = true;
		}
		
		assertTrue(lanzaError);
	}
	
	@Test
	public void testAtacarAMonstruoDeOtroJugadorConMenosAtaqueLoMandaAlCementerioYDescuentaVida() {
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		CartaMonstruo cartaMonstruo = new BebeDragon();
		CartaMonstruo otraCarta = new Digitron();
		jugador.colocarCartaEnMano(cartaMonstruo);
		oponente.colocarCartaEnMano(otraCarta);
		jugador.colocarEnPosicionDeAtaqueBocaArriba(cartaMonstruo);
		oponente.colocarEnPosicionDeAtaqueBocaArriba(otraCarta);
		oponente.atacarAMonstruo(otraCarta, cartaMonstruo, jugador);
		
		assertTrue(jugador.estaEnCementerio(cartaMonstruo));
		
		int puntosDeVidaEsperados = 8000 - 300;
		assertEquals(puntosDeVidaEsperados, jugador.obtenerPuntosDeVida());
	}
	
	@Test
	public void testEstaEnCementerioEsFalseSiLaCartaNoFueEnviadaAlli() {
		Jugador jugador = new Jugador();
		CartaMonstruo cartaMonstruo = new BebeDragon();
		jugador.colocarCartaEnMano(cartaMonstruo);
		jugador.colocarEnPosicionDeAtaqueBocaArriba(cartaMonstruo);
		
		assertFalse(jugador.estaEnCementerio(cartaMonstruo));
	}
	
	@Test
	public void testMandarCartaAlCementerioCartaEstaEnCementerioEsTrue() {
		Jugador jugador = new Jugador();
		CartaMonstruo cartaMonstruo = new BebeDragon();
		jugador.colocarCartaEnMano(cartaMonstruo);
		jugador.colocarEnPosicionDeAtaqueBocaArriba(cartaMonstruo);

		jugador.mandarAlCementerio(cartaMonstruo);
		assertTrue(jugador.estaEnCementerio(cartaMonstruo));
	}
	
	@Test
	public void testEstaEnCampoEsTrueLuegoDeColocarCarta() {
		Jugador jugador = new Jugador();
		CartaMonstruo cartaMonstruo = new BebeDragon();
		jugador.colocarCartaEnMano(cartaMonstruo);
		
		jugador.colocarEnPosicionDeAtaqueBocaArriba(cartaMonstruo);
		assertTrue(jugador.estaEnCampo(cartaMonstruo));
	}
	
	@Test
	public void testEstaEnCampoEsFalseSiLaCartaNoSeHaColocado() {
		Jugador jugador = new Jugador();
		CartaMonstruo cartaMonstruo = new BebeDragon();
		jugador.colocarCartaEnMano(cartaMonstruo);
		
		assertFalse(jugador.estaEnCampo(cartaMonstruo));
	}
	
	@Test
	public void testRecibirAtaqueDirectoConMonstruosEnCampoLanzaError() {
		Jugador jugador = new Jugador();
		CartaMonstruo cartaMonstruo = new BebeDragon();
		jugador.colocarCartaEnMano(cartaMonstruo);
		jugador.colocarEnPosicionDeAtaqueBocaArriba(cartaMonstruo);
		boolean lanzaError = false;
		try {
			jugador.recibirAtaqueDirecto(1000);
		}
		catch(ElJugadorTieneMonstruosEnElCampoException e) {
			lanzaError = true;
		}
		
		assertTrue(lanzaError);
	}
	
	@Test
	public void testRecibirAtaqueDirectoSinMonstruosEnElCampoReduceMisPuntosDeVida() {
		Jugador jugador = new Jugador();
		int ataque = 1000;
		jugador.recibirAtaqueDirecto(ataque);
		
		int puntosDeVidaEsperados = 8000 - ataque;
		assertEquals(puntosDeVidaEsperados, jugador.obtenerPuntosDeVida());
	}
	
	@Test
	public void testColocarCartaMagicaNoActivaEfecto() {
		Jugador jugador = new Jugador();
		CartaMagica olla = new OllaDeLaCodicia();
		jugador.colocarCartaEnMano(olla);
		jugador.colocarCartaMagica(olla);
		
		//No se activa el efecto de la carta olla de la codicia que es tomar 2 cartas del mazo a la mano.
		int cartasEnMano = 0;
		assertEquals(cartasEnMano, jugador.obtenerCantidadCartas());
	}
	
	@Test
	public void testColocarCartaMagicaYLuegoVoltearlaActivaSuEfecto() {
		Jugador jugador = new Jugador();
		CartaMagica olla = new OllaDeLaCodicia();
		jugador.colocarCartaEnMano(olla);
		jugador.colocarCartaMagica(olla);
		
		//Volteo la carta y se activa el efecto.
		jugador.voltearCarta(olla, new Jugador());
		int cartasEnMano = 2;
		assertEquals(cartasEnMano, jugador.obtenerCantidadCartas());
	}
	
	@Test
	public void testVoltearCartaMagicaQueNoEstaEnCampoLanzaExcepcion() {
		Jugador jugador = new Jugador();
		CartaMagica olla = new OllaDeLaCodicia();
		jugador.colocarCartaEnMano(olla);		
		boolean lanzaError = false;
		try {
			jugador.voltearCarta(olla, new Jugador());
		}
		catch(LaCartaNoEstaEnElCampoException e) {
			lanzaError = true;
		}
		
		assertTrue(lanzaError);
	}
}
