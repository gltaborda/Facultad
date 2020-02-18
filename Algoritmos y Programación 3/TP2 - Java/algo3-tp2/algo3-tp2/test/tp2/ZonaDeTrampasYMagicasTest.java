package tp2;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.cartas.AgujeroNegro;
import tp2.cartas.Reinforcements;
import tp2.excepciones.LaCartaNoEstaEnElCampoException;
import tp2.excepciones.LaZonaDeTrampasYMagicasEstaLlenaException;
import tp2.interfaces.CartaMagica;
import tp2.interfaces.CartaTrampa;

public class ZonaDeTrampasYMagicasTest {

	@Test
	public void testContieneACartaTrampaEsFalseSiNoFueAgregada() {
		ZonaDeTrampasYMagicas zona = new ZonaDeTrampasYMagicas();
		CartaTrampa reinforcements = new Reinforcements();
		
		assertFalse(zona.contieneA(reinforcements));
	}
	
	@Test
	public void testContieneACartaTrampaEsTrueLuegoDeSerAgregada() {
		ZonaDeTrampasYMagicas zona = new ZonaDeTrampasYMagicas();
		CartaTrampa reinforcements = new Reinforcements();
		zona.colocar(reinforcements);
		
		assertTrue(zona.contieneA(reinforcements));
	}
	
	@Test
	public void testContieneACartaMagicaEsFalseSiNoFueAgregada() {
		ZonaDeTrampasYMagicas zona = new ZonaDeTrampasYMagicas();
		CartaMagica agujeroNegro = new AgujeroNegro();
		
		assertFalse(zona.contieneA(agujeroNegro));
	}
	
	@Test
	public void testContieneACartaMagicaEsTrueLuegoDeSerAgregada() {
		ZonaDeTrampasYMagicas zona = new ZonaDeTrampasYMagicas();
		CartaMagica agujeroNegro = new AgujeroNegro();
		zona.colocar(agujeroNegro);
		
		assertTrue(zona.contieneA(agujeroNegro));
	}
	
	@Test
	public void testColocarMasDeCincoCartasLanzaExcepcion() {
		ZonaDeTrampasYMagicas zona = new ZonaDeTrampasYMagicas();
		CartaTrampa reinforcements = new Reinforcements();
		CartaMagica agujeroNegro = new AgujeroNegro();
		//Coloco 5 cartas en la zona de magicas y trampas.
		for (int i=0; i < 3; i++) zona.colocar(reinforcements);
		for (int i=0; i < 2; i++) zona.colocar(agujeroNegro);
		
		boolean lanzaError = false;
		try {
			zona.colocar(reinforcements);
		}
		catch (LaZonaDeTrampasYMagicasEstaLlenaException e) {
			lanzaError = true;
		}
		
		assertTrue(lanzaError);
	}

	@Test
	public void testObtenerCartaTrampaQueNoEstaEnLaZonaLanzaExcepcion() {
		ZonaDeTrampasYMagicas zona = new ZonaDeTrampasYMagicas();
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
	public void testObtenerCartaTrampaQueFueAgregadaMeDevuelveDichaCarta() {
		ZonaDeTrampasYMagicas zona = new ZonaDeTrampasYMagicas();
		CartaTrampa reinforcements = new Reinforcements();
		zona.colocar(reinforcements);
		
		assertEquals(reinforcements, zona.obtenerCarta(reinforcements));
	}

	@Test
	public void testObtenerCartaMagicaQueNoEstaEnLaZonaLanzaExcepcion() {
		ZonaDeTrampasYMagicas zona = new ZonaDeTrampasYMagicas();
		CartaMagica agujeroNegro = new AgujeroNegro();
		
		boolean lanzaError = false;
		try {
			zona.obtenerCarta(agujeroNegro);
		}
		catch (LaCartaNoEstaEnElCampoException e) {
			lanzaError = true;
		}
		
		assertTrue(lanzaError);
	}
	
	@Test
	public void testObtenerCartaMagicaQueFueAgregadaMeDevuelveDichaCarta() {
		ZonaDeTrampasYMagicas zona = new ZonaDeTrampasYMagicas();
		CartaMagica agujeroNegro = new AgujeroNegro();
		zona.colocar(agujeroNegro);
		
		assertEquals(agujeroNegro, zona.obtenerCarta(agujeroNegro));
	}
}
