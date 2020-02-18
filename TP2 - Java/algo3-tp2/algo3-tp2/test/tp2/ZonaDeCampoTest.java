package tp2;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.cartas.Sogen;
import tp2.excepciones.LaCartaNoEstaEnElCampoException;
import tp2.interfaces.CartaCampo;

public class ZonaDeCampoTest {

	@Test
	public void testObtenerCartaQueNoEstaEnLaZonaLanzaExcepcion() {
		ZonaDeCampo zona = new ZonaDeCampo();
		CartaCampo sogen = new Sogen();
		
		boolean lanzaError = false;
		try {
			zona.obtenerCarta(sogen);
		}
		catch (LaCartaNoEstaEnElCampoException e) {
			lanzaError = true;
		}
		
		assertTrue(lanzaError);
	}
	
	@Test
	public void testObtenerCartaQueFueAgregadaMeDevuelveDichaCarta() {
		ZonaDeCampo zona = new ZonaDeCampo();
		CartaCampo sogen = new Sogen();
		zona.colocar(sogen);
		
		assertEquals(sogen, zona.obtenerCarta(sogen));
	}
	
}