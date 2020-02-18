package tp2;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.cartas.Reinforcements;
import tp2.excepciones.LaCartaNoEstaEnElCampoException;
import tp2.interfaces.CartaTrampa;

public class ZonaDeTrampasTest {

	@Test
	public void testContieneACartaMonstruoEsFalseSiNoFueAgregada() {
		ZonaDeTrampas zona = new ZonaDeTrampas();
		CartaTrampa reinforcements = new Reinforcements();
		
		assertFalse(zona.contieneA(reinforcements));
	}
	
	@Test
	public void testContieneACartaMonstruoEsTrueLuegoDeSerAgregada() {
		ZonaDeTrampas zona = new ZonaDeTrampas();
		CartaTrampa reinforcements = new Reinforcements();
		zona.colocar(reinforcements);
		
		assertTrue(zona.contieneA(reinforcements));
	}

	@Test
	public void testObtenerCartaQueNoEstaEnLaZonaLanzaExcepcion() {
		ZonaDeTrampas zona = new ZonaDeTrampas();
		CartaTrampa reinforcements = new Reinforcements();
		
		boolean lanzaError = false;
		try {
			zona.obtenerCarta(reinforcements);
		}
		catch (LaCartaNoEstaEnElCampoException e) {
			lanzaError = true;
		}
		
		assertTrue(lanzaError);
	}
	
	@Test
	public void testObtenerCartaQueFueAgregadaMeDevuelveDichaCarta() {
		ZonaDeTrampas zona = new ZonaDeTrampas();
		CartaTrampa reinforcements = new Reinforcements();
		zona.colocar(reinforcements);
		
		assertEquals(reinforcements, zona.obtenerCarta(reinforcements));
	}
	
}
