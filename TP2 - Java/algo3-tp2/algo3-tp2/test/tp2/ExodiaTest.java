package tp2;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.cartas.BrazoDerechoDelProhibido;
import tp2.cartas.BrazoIzquierdoDelProhibido;
import tp2.cartas.ExodiaElProhibido;
import tp2.cartas.PiernaDerechaDelProhibido;
import tp2.cartas.PiernaIzquierdaDelProhibido;

public class ExodiaTest {

	@Test
	public void testEstaCompletoAlInicializarEsFalse() {
		Exodia exodia = new Exodia();
		
		assertFalse(exodia.estaCompleto());
	}
	
	@Test
	public void testEstaCompletoAlAgregarTodasLasPartesEsTrue() {
		Exodia exodia = new Exodia();
		ParteDeExodia cabeza = new ExodiaElProhibido();
		ParteDeExodia brazoDerecho = new BrazoDerechoDelProhibido();
		ParteDeExodia brazoIzquierdo = new BrazoIzquierdoDelProhibido();
		ParteDeExodia piernaDerecha = new PiernaDerechaDelProhibido();
		ParteDeExodia piernaIzquierda = new PiernaIzquierdaDelProhibido();
		
		exodia.agregarParte(cabeza);
		exodia.agregarParte(brazoDerecho);
		exodia.agregarParte(brazoIzquierdo);
		exodia.agregarParte(piernaDerecha);
		exodia.agregarParte(piernaIzquierda);
		
		assertTrue(exodia.estaCompleto());
	}
	
	@Test
	public void testAgregarUnaParteYaExistenteLanzaError() {
		
	}

}
