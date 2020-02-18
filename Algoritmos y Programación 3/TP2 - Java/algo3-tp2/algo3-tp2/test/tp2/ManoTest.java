package tp2;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.cartas.AgujeroNegro;
import tp2.cartas.BebeDragon;
import tp2.excepciones.LaCartaNoEstaEnLaManoException;
import tp2.interfaces.Carta;

public class ManoTest {

	@Test
	public void testCantidadCartasEsCeroAlInicializar() {
		Mano mano = new Mano();
		
		int cantidadCartas = 0;
		assertEquals(cantidadCartas, mano.obtenerCantidadCartas());
	}
	
	@Test
	public void testCantidadCartasEsLaCantidadDeCartasAgregadas() {
		Mano mano = new Mano();
		Carta agujeroNegro = new AgujeroNegro();
		mano.agregarCarta(agujeroNegro);
		
		int cantidadCartas = 1;
		assertEquals(cantidadCartas, mano.obtenerCantidadCartas());
	}
	
	@Test
	public void testCantidadCartasEsCeroLuegoDeAgregarUnaCartaYRetirarla() {
		Mano mano = new Mano();
		Carta agujeroNegro = new AgujeroNegro();
		mano.agregarCarta(agujeroNegro);
		mano.retirarCarta(agujeroNegro);
		
		int cantidadCartas = 0;
		assertEquals(cantidadCartas, mano.obtenerCantidadCartas());
	}
	
	@Test
	public void testRetirarCartaQueNoEstaEnManoLanzaExcepcion() {
		Mano mano = new Mano();
		Carta agujeroNegro = new AgujeroNegro();
		boolean lanzaError = false;
		try {
			mano.retirarCarta(agujeroNegro);
		}
		catch(LaCartaNoEstaEnLaManoException e) {
			lanzaError = true;
		}
		
		assertTrue(lanzaError);
	}

	@Test
	public void testObtenerCantidadCartasEsCeroAlInicializar() {
		Mano mano = new Mano();
		
		int cantidadEsperada = 0;
		assertEquals(cantidadEsperada, mano.obtenerCantidadCartas());
	}
	
	@Test
	public void testObtenerCantidadCartasEsLaCantidadDeCartasAgregadas() {
		Mano mano = new Mano();
		Carta agujeroNegro = new AgujeroNegro();
		Carta bebeDragon = new BebeDragon();
		mano.agregarCarta(agujeroNegro);
		mano.agregarCarta(bebeDragon);
		
		int cantidadEsperada = 2;
		assertEquals(cantidadEsperada, mano.obtenerCantidadCartas());
	}
}
