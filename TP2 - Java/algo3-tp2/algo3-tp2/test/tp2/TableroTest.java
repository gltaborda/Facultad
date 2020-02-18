package tp2;
import static org.junit.Assert.*;

import org.junit.Test;

import tp2.cartas.AgujeroNegro;
import tp2.cartas.BebeDragon;
import tp2.cartas.Reinforcements;
import tp2.excepciones.LaCartaNoEstaEnElCampoException;
import tp2.interfaces.CartaMagica;
import tp2.interfaces.CartaTrampa;

public class TableroTest {

	@Test
	public void testEstaEnCampoEsTrueLuegoDeColocarUnaCartaDeMonstruo() {
		Tablero tablero = new Tablero();
		CartaMonstruo bebeDragon = new BebeDragon();
		tablero.colocarCarta(bebeDragon);
		
		assertTrue(tablero.estaEnCampo(bebeDragon));
	}
	
	@Test
	public void testEstaEnCampoEsFalseParaUnaCartaDeMonstruoQueNoFueColocada() {
		Tablero tablero = new Tablero();
		CartaMonstruo bebeDragon = new BebeDragon();
		
		assertFalse(tablero.estaEnCampo(bebeDragon));
	}
	
	@Test
	public void testEstaEnCampoEsTrueLuegoDeColocarUnaCartaDeTrampa() {
		Tablero tablero = new Tablero();
		CartaTrampa reinforcements = new Reinforcements();
		tablero.colocarCarta(reinforcements);
		
		assertTrue(tablero.estaEnCampo(reinforcements));
	}
	
	@Test
	public void testEstaEnCampoEsFalseParaUnaCartaDeTrampaQueNoFueColocada() {
		Tablero tablero = new Tablero();
		CartaTrampa reinforcements = new Reinforcements();
		
		assertFalse(tablero.estaEnCampo(reinforcements));
	}
	
	@Test
	public void testEstaEnCampoEsTrueLuegoDeColocarUnaCartaMagica() {
		Tablero tablero = new Tablero();
		CartaMagica agujeroNegro = new AgujeroNegro();
		tablero.colocarCarta(agujeroNegro);
		
		assertTrue(tablero.estaEnCampo(agujeroNegro));
	}
	
	@Test
	public void testEstaEnCampoEsFalseParaUnaCartaMagicaQueNoFueColocada() {
		Tablero tablero = new Tablero();
		CartaMagica agujeroNegro = new AgujeroNegro();
		
		assertFalse(tablero.estaEnCampo(agujeroNegro));
	}
	
	@Test
	public void testEstaEnCementerioEsTrueLuegoDeMandarUnaCartaDeMonstruoAlli() {
		Tablero tablero = new Tablero();
		CartaMonstruo bebeDragon = new BebeDragon();
		tablero.colocarCarta(bebeDragon);
		tablero.mandarAlCementerio(bebeDragon);
		
		assertTrue(tablero.estaEnCementerio(bebeDragon));
	}
	
	@Test
	public void testEstaEnCementerioEsFalseSiLaCartaMonstruoNoFueMandadaAlli() {
		Tablero tablero = new Tablero();
		CartaMonstruo bebeDragon = new BebeDragon();
		tablero.colocarCarta(bebeDragon);
		
		assertFalse(tablero.estaEnCementerio(bebeDragon));
	}
	
	@Test
	public void testEstaEnCementerioEsTrueLuegoDeMandarUnaCartaDeTrampaAlli() {
		Tablero tablero = new Tablero();
		CartaTrampa reinforcements = new Reinforcements();
		tablero.colocarCarta(reinforcements);
		tablero.mandarAlCementerio(reinforcements);
		
		assertTrue(tablero.estaEnCementerio(reinforcements));
	}
	
	@Test
	public void testEstaEnCementerioEsFalseSiLaCartaDeTrampaNoFueMandadaAlli() {
		Tablero tablero = new Tablero();
		CartaTrampa reinforcements = new Reinforcements();
		tablero.colocarCarta(reinforcements);
		
		assertFalse(tablero.estaEnCementerio(reinforcements));
	}
	
	@Test
	public void testEstaEnCementerioEsTrueLuegoDeMandarUnaCartaMagicaAlli() {
		Tablero tablero = new Tablero();
		CartaMagica agujeroNegro = new AgujeroNegro();
		tablero.colocarCarta(agujeroNegro);
		tablero.mandarAlCementerio(agujeroNegro);
		
		assertTrue(tablero.estaEnCementerio(agujeroNegro));
	}
	
	@Test
	public void testEstaEnCementerioEsFalseSiLaCartaMagicaNoFueMandadaAlli() {
		Tablero tablero = new Tablero();
		CartaMagica agujeroNegro = new AgujeroNegro();
		tablero.colocarCarta(agujeroNegro);
		
		assertFalse(tablero.estaEnCementerio(agujeroNegro));
	}
	
	@Test
	public void testMandarAlCementerioLanzaExcepcionCuandoLaCartaTrampaNoEstaEnElCampo() {
		Tablero tablero = new Tablero();
		CartaTrampa reinforcements = new Reinforcements();
		boolean lanzaError = false;
		try {
			tablero.mandarAlCementerio(reinforcements);
		}
		catch (LaCartaNoEstaEnElCampoException e) {
			lanzaError = true;
		}
		
		assertTrue(lanzaError);
	}

	@Test
	public void testMandarAlCementerioLanzaExcepcionCuandoLaCartaMonstruoNoEstaEnElCampo() {
		Tablero tablero = new Tablero();
		CartaMonstruo bebeDragon = new BebeDragon();
		boolean lanzaError = false;
		try {
			tablero.mandarAlCementerio(bebeDragon);
		}
		catch (LaCartaNoEstaEnElCampoException e) {
			lanzaError = true;
		}
		
		assertTrue(lanzaError);
	}
	
	@Test
	public void testMandarAlCementerioLanzaExcepcionCuandoLaCartaMagicaNoEstaEnElCampo() {
		Tablero tablero = new Tablero();
		CartaMagica agujeroNegro = new AgujeroNegro();
		boolean lanzaError = false;
		try {
			tablero.mandarAlCementerio(agujeroNegro);
		}
		catch (LaCartaNoEstaEnElCampoException e) {
			lanzaError = true;
		}
		
		assertTrue(lanzaError);
	}

}
