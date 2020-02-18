package tp2;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.cartas.BebeDragon;
import tp2.excepciones.LaCartaNoEstaEnElCampoException;
import tp2.excepciones.LaZonaDeMonstruosEstaLlenaException;

public class ZonaDeMonstruosTest {

	@Test
	public void testContieneACartaMonstruoEsFalseSiNoFueAgregada() {
		ZonaDeMonstruos zona = new ZonaDeMonstruos();
		CartaMonstruo bebeDragon = new BebeDragon();
		
		assertFalse(zona.contieneA(bebeDragon));
	}
	
	@Test
	public void testContieneACartaMonstruoEsTrueLuegoDeSerAgregada() {
		ZonaDeMonstruos zona = new ZonaDeMonstruos();
		CartaMonstruo bebeDragon = new BebeDragon();
		zona.colocar(bebeDragon);
		
		assertTrue(zona.contieneA(bebeDragon));
	}
	
	@Test
	public void testColocarMasDeCincoCartasLanzaExcepcion() {
		ZonaDeMonstruos zona = new ZonaDeMonstruos();
		CartaMonstruo bebeDragon = new BebeDragon();
		//Coloco 5 cartas en la zona de monstruos.
		for (int i=0; i < 5; i++) zona.colocar(bebeDragon);
		
		boolean lanzaError = false;
		try {
			zona.colocar(bebeDragon);
		}
		catch (LaZonaDeMonstruosEstaLlenaException e) {
			lanzaError = true;
		}
		
		assertTrue(lanzaError);
	}
	
	@Test
	public void testEstaVaciaAlInicializarEsTrue() {
		ZonaDeMonstruos zona = new ZonaDeMonstruos();
		
		assertTrue(zona.estaVacia());
	}
	
	@Test
	public void testEstaVaciaAlAgregarUnMonstruoEsFalse() {
		ZonaDeMonstruos zona = new ZonaDeMonstruos();
		CartaMonstruo bebeDragon = new BebeDragon();
		zona.colocar(bebeDragon);
		
		assertFalse(zona.estaVacia());
	}
	
	@Test
	public void testEstaLlenaAlInicializarEsFalse() {
		ZonaDeMonstruos zona = new ZonaDeMonstruos();
		
		assertFalse(zona.estaLlena());
	}
	
	@Test
	public void testEstaLlenaAlAgregarCincoMonstruosEsTrue() {
		ZonaDeMonstruos zona = new ZonaDeMonstruos();
		CartaMonstruo bebeDragon = new BebeDragon();
		for (int i=0; i < 5; i++) zona.colocar(bebeDragon);
		
		assertTrue(zona.estaLlena());
	}
	
	@Test
	public void testObtenerCartaQueNoEstaEnLaZonaLanzaExcepcion() {
		ZonaDeMonstruos zona = new ZonaDeMonstruos();
		CartaMonstruo bebeDragon = new BebeDragon();
		
		boolean lanzaError = false;
		try {
			zona.obtenerCarta(bebeDragon);
		}
		catch (LaCartaNoEstaEnElCampoException e) {
			lanzaError = true;
		}
		
		assertTrue(lanzaError);
	}
	
	@Test
	public void testObtenerCartaQueFueAgregadaMeDevuelveDichaCarta() {
		ZonaDeMonstruos zona = new ZonaDeMonstruos();
		CartaMonstruo bebeDragon = new BebeDragon();
		zona.colocar(bebeDragon);
		
		assertEquals(bebeDragon, zona.obtenerCarta(bebeDragon));
	}

}
