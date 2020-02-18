package tp2;

import org.junit.Test;
import tp2.cartas.*;
import tp2.excepciones.CartaEnModoDeDefensaNoPuedeAtacarException;
import tp2.excepciones.UnaCartaBocaArribaNoPuedeVoltearseException;
import tp2.interfaces.CartaTrampa;

import static org.junit.Assert.*;

public class JuegoTest {
	
	@Test
	public void testJugadorTieneSeisCartasAlInicializarElJuego() {
		Juego juego = Juego.nuevoJuego();
		
		//Toma 5 cartas mas 1 mas porque es su turno.
		int cartasEnMano = 6;
		assertEquals(cartasEnMano, juego.jugadorActual.obtenerCantidadCartas());
	}
	
	@Test
	public void test01() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo cartaMenorAtaque = new BebeDragon();
		CartaMonstruo cartaMayorAtaque = new Digitron();
		juego.colocarCartaEnMano(cartaMenorAtaque);
		juego.colocarEnPosicionDeAtaqueBocaAbajo(cartaMenorAtaque);
		juego.terminarTurno();
		juego.colocarCartaEnMano(cartaMayorAtaque);
		juego.colocarEnPosicionDeAtaqueBocaArriba(cartaMayorAtaque);
		juego.atacarCon(cartaMayorAtaque, cartaMenorAtaque);
		juego.terminarTurno();
		
		assertTrue(juego.estaEnCementerio(cartaMenorAtaque));
		
		int puntosDeVidaEsperados = 8000 - (1500 - 1200);
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
	}

	@Test
	public void test02() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo cartaMayorAtaque = new Digitron();
		CartaMonstruo cartaMenorAtaque = new BebeDragon();
		juego.colocarCartaEnMano(cartaMayorAtaque);
		juego.colocarEnPosicionDeAtaqueBocaAbajo(cartaMayorAtaque);
		juego.terminarTurno();
		juego.colocarCartaEnMano(cartaMenorAtaque);
		juego.colocarEnPosicionDeAtaqueBocaArriba(cartaMenorAtaque);
		juego.atacarCon(cartaMenorAtaque, cartaMayorAtaque);
		
		assertTrue(juego.estaEnCementerio(cartaMenorAtaque));
		
		int puntosDeVidaEsperados = 8000 - (1500 - 1200);
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
	}
	
	@Test
	public void test03() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo cartaMonstruo = new Digitron();
		CartaMonstruo otraCartaIgual = new Digitron();
		juego.colocarCartaEnMano(cartaMonstruo);
		juego.colocarEnPosicionDeAtaqueBocaArriba(cartaMonstruo);
		juego.terminarTurno();
		juego.colocarCartaEnMano(otraCartaIgual);
		juego.colocarEnPosicionDeAtaqueBocaArriba(otraCartaIgual);
		juego.atacarCon(otraCartaIgual, cartaMonstruo);
		
		int puntosDeVidaEsperados = 8000;
		
		assertTrue(juego.estaEnCementerio(otraCartaIgual));
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
		
		juego.terminarTurno(); //cambio de jugador para probar lo mismo en el otro jugador.
		
		assertTrue(juego.estaEnCementerio(cartaMonstruo));
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
	}
	
	@Test
	public void test04() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo cartaConMenorDefensa = new Digitron();
		CartaMonstruo cartaConMayorAtaque = new BebeDragon();
		juego.colocarCartaEnMano(cartaConMenorDefensa);
		juego.colocarEnPosicionDeDefensaBocaArriba(cartaConMenorDefensa);
		juego.terminarTurno();
		juego.colocarCartaEnMano(cartaConMayorAtaque);
		juego.colocarEnPosicionDeAtaqueBocaArriba(cartaConMayorAtaque);
		juego.atacarCon(cartaConMayorAtaque, cartaConMenorDefensa);
		
		int puntosDeVidaEsperados = 8000;
		juego.terminarTurno();
		
		assertTrue(juego.estaEnCementerio(cartaConMenorDefensa));
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
	}
	
	@Test
	public void test05() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo cartaConMayorDefensa = new SoldadoGiganteDePiedra();
		CartaMonstruo cartaConMenorAtaque = new BebeDragon();
		juego.colocarCartaEnMano(cartaConMayorDefensa);
		juego.colocarEnPosicionDeDefensaBocaAbajo(cartaConMayorDefensa);
		juego.terminarTurno();
		juego.colocarCartaEnMano(cartaConMenorAtaque);
		juego.colocarEnPosicionDeAtaqueBocaArriba(cartaConMenorAtaque);
		juego.atacarCon(cartaConMenorAtaque, cartaConMayorDefensa);
		
		int puntosDeVidaEsperados = 8000;
		juego.terminarTurno();
		
		assertFalse(juego.estaEnCementerio(cartaConMayorDefensa));
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
	}
	
	@Test
	public void testAtacarConCartaEnModoDefensaLanzaExcepcion() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo cartaMonstruo = new BebeDragon();
		CartaMonstruo otraCarta = new Digitron();
		juego.colocarCartaEnMano(cartaMonstruo);
		juego.colocarEnPosicionDeDefensaBocaArriba(cartaMonstruo);
		
		boolean lanzaExcepcion = false;
		try {
			juego.atacarCon(cartaMonstruo, otraCarta);
		}
		catch (CartaEnModoDeDefensaNoPuedeAtacarException e) {
			lanzaExcepcion = true;
		}
		
		assertTrue(lanzaExcepcion);
	}
	
	@Test
	public void testAgujeroNegro() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo cartaMonstruo = new BebeDragon();
		CartaMonstruo otraCarta = new Digitron();
		juego.colocarCartaEnMano(cartaMonstruo);
		juego.colocarEnPosicionDeDefensaBocaAbajo(cartaMonstruo);
		juego.terminarTurno();
		juego.colocarCartaEnMano(otraCarta);
		juego.colocarEnPosicionDeAtaqueBocaArriba(otraCarta);
		AgujeroNegro agujeroNegro = new AgujeroNegro();
		juego.colocarCartaEnMano(agujeroNegro);
		//Activo la carta desde mi mano, se activa el efecto y se va al cementerio.
		juego.activarCartaMagica(agujeroNegro);
		assertTrue(juego.estaEnCementerio(agujeroNegro));
		
		int puntosDeVidaEsperados = 8000;
		
		assertTrue(juego.estaEnCementerio(otraCarta));
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
		
		juego.terminarTurno();
		
		assertTrue(juego.estaEnCementerio(cartaMonstruo));
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
	}
	
	@Test
	public void test01Sacrificio() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo cartaMonstruo = new BebeDragon();
		CartaMonstruo cartaQueRequiereSacrificio = new DragonMeteoro();
		juego.colocarCartaEnMano(cartaMonstruo);
		juego.colocarCartaEnMano(cartaQueRequiereSacrificio);
		juego.colocarEnPosicionDeDefensaBocaAbajo(cartaMonstruo);
		juego.colocarEnPosicionDeAtaqueBocaAbajo(cartaQueRequiereSacrificio);
		
		assertTrue(juego.estaEnCampo(cartaQueRequiereSacrificio));
		assertTrue(juego.estaEnCementerio(cartaMonstruo));
	}

	@Test
	public void test02Sacrificio() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo cartaMonstruo = new BebeDragon();
		CartaMonstruo otraCarta = new Digitron();
		CartaMonstruo cartaQueRequiereDosSacrificios = new DragonBlancoDeOjosAzules();
		juego.colocarCartaEnMano(cartaMonstruo);
		juego.colocarCartaEnMano(otraCarta);
		juego.colocarCartaEnMano(cartaQueRequiereDosSacrificios);
		juego.colocarEnPosicionDeDefensaBocaArriba(cartaMonstruo);
		juego.colocarEnPosicionDeAtaqueBocaArriba(otraCarta);
		juego.colocarEnPosicionDeAtaqueBocaArriba(cartaQueRequiereDosSacrificios);
		
		assertTrue(juego.estaEnCampo(cartaQueRequiereDosSacrificios));
		assertTrue(juego.estaEnCementerio(cartaMonstruo));
		assertTrue(juego.estaEnCementerio(otraCarta));
	}
	
	@Test
	public void testWastelandAtaque() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo cartaMonstruo = new BebeDragon();
		CartaMonstruo otraCartaIgual = new BebeDragon();
		juego.colocarCartaEnMano(cartaMonstruo);
		juego.colocarEnPosicionDeAtaqueBocaAbajo(cartaMonstruo);
		juego.terminarTurno();
		juego.colocarCartaEnMano(otraCartaIgual);
		juego.colocarEnPosicionDeAtaqueBocaArriba(otraCartaIgual);
		
		//La carta Wasteland aumenta en 200 el ataque propio.
		Wasteland wasteland = new Wasteland();
		juego.colocarCartaEnMano(wasteland);
		juego.colocarCartaCampo(wasteland);
		
		int puntosDeVidaEsperados = 8000 - 200;
		juego.atacarCon(otraCartaIgual, cartaMonstruo);

		juego.terminarTurno();
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
	}
	
	@Test
	public void testWastelandDefensa() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo cartaMonstruo = new BebeDragon();
		CartaMonstruo otraCarta = new MegaBolaDeTrueno();
		juego.colocarCartaEnMano(cartaMonstruo);
		juego.colocarEnPosicionDeDefensaBocaAbajo(cartaMonstruo);
		juego.terminarTurno();
		juego.colocarCartaEnMano(otraCarta);
		juego.colocarEnPosicionDeAtaqueBocaArriba(otraCarta);
		
		//La carta Wasteland aumenta en 300 la defensa rival.
		Wasteland wasteland = new Wasteland();
		juego.colocarCartaEnMano(wasteland);
		juego.colocarCartaCampo(wasteland);
		
		juego.atacarCon(otraCarta, cartaMonstruo);

		juego.terminarTurno();
		assertFalse(juego.estaEnCementerio(cartaMonstruo));
	}
	
	@Test
	public void testSogenAtaque() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo cartaMonstruo = new BebeDragon();
		CartaMonstruo otraCartaIgual = new BebeDragon();
		juego.colocarCartaEnMano(cartaMonstruo);
		juego.colocarEnPosicionDeAtaqueBocaArriba(cartaMonstruo);
		juego.terminarTurno();
		juego.colocarCartaEnMano(otraCartaIgual);
		juego.colocarEnPosicionDeAtaqueBocaArriba(otraCartaIgual);
		
		//La carta Sogen aumenta en 200 el ataque rival.
		Sogen sogen = new Sogen();
		juego.colocarCartaEnMano(sogen);
		juego.colocarCartaCampo(sogen);
		
		int puntosDeVidaEsperados = 8000 - 200;
		juego.atacarCon(otraCartaIgual, cartaMonstruo);

		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
		assertTrue(juego.estaEnCementerio(otraCartaIgual));
	}
	
	@Test
	public void testSogenDefensa() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo cartaMonstruo = new MegaBolaDeTrueno();
		CartaMonstruo otraCarta = new BebeDragon();
		juego.colocarCartaEnMano(cartaMonstruo);
		juego.colocarEnPosicionDeAtaqueBocaArriba(cartaMonstruo);
		juego.terminarTurno();
		juego.colocarCartaEnMano(otraCarta);
		juego.colocarEnPosicionDeDefensaBocaAbajo(otraCarta);
		
		//La carta Sogen aumenta en 500 la defensa propia.
		int puntosDeVidaEsperados = 8000 - ((otraCarta.obtenerDefensa() + 500) - (cartaMonstruo.obtenerAtaque() + 200));
		Sogen sogen = new Sogen();
		juego.colocarCartaEnMano(sogen);
		juego.colocarCartaCampo(sogen);
		juego.terminarTurno();
		juego.atacarCon(cartaMonstruo, otraCarta);
		
		assertTrue(juego.estaEnCementerio(cartaMonstruo));
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
	}
	
	@Test
	public void testOllaDeLaCodicia() {
		Juego juego = Juego.nuevoJuego();
		int cartasEnMano = juego.obtenerCantidadCartas();
		//La carta OllaDeLaCodicia aumenta en 500 la defensa propia.
		OllaDeLaCodicia olla = new OllaDeLaCodicia();
		//Ver de colocar cartas magicas en el campo.
		juego.colocarCartaEnMano(olla);
		juego.activarCartaMagica(olla);
		int cantidadCartasEsperada = cartasEnMano + 2;
		
		assertEquals(cantidadCartasEsperada, juego.obtenerCantidadCartas());
	}
	
	@Test
	public void testFisura() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo cartaMonstruo = new BebeDragon();
		CartaMonstruo cartaConMenorAtaque = new MegaBolaDeTrueno();
		juego.colocarCartaEnMano(cartaMonstruo);
		juego.colocarCartaEnMano(cartaConMenorAtaque);
		juego.colocarEnPosicionDeAtaqueBocaArriba(cartaMonstruo);
		juego.colocarEnPosicionDeAtaqueBocaArriba(cartaConMenorAtaque);
		juego.terminarTurno();
		
		//La carta Fisura destruye el monstruo rival de menor ataque.
		Fisura fisura = new Fisura();
		juego.colocarCartaEnMano(fisura);
		juego.activarCartaMagica(fisura);
		juego.terminarTurno();
		int puntosDeVidaEsperados = 8000;
		
		assertTrue(juego.estaEnCementerio(cartaConMenorAtaque));
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
	}
	
	@Test
	public void testJinzo7() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo cartaMonstruo = new BebeDragon();
		juego.colocarCartaEnMano(cartaMonstruo);
		juego.colocarEnPosicionDeAtaqueBocaArriba(cartaMonstruo);
		juego.terminarTurno();
		
		//Jinzo7 puede atacar a los puntos de vida directamente.
		CartaMonstruo jinzo7 = new Jinzo7();
		juego.colocarCartaEnMano(jinzo7);
		juego.colocarEnPosicionDeAtaqueBocaArriba(jinzo7);
		juego.activarEfecto(jinzo7);
	}
	
	@Test
	public void testDragonDefinitivoDeOjosAzules() {
		Juego juego = Juego.nuevoJuego();
		//Antes de colocar cada dragon, necesito colocar 2 monstruos sacrificio para su invocacion.
		CartaMonstruo cartaMonstruo = new BebeDragon();
		CartaMonstruo otraCarta = new Digitron();
		juego.colocarCartaEnMano(cartaMonstruo);
		juego.colocarCartaEnMano(otraCarta);
		juego.colocarEnPosicionDeDefensaBocaArriba(cartaMonstruo);
		juego.colocarEnPosicionDeAtaqueBocaArriba(otraCarta);
		CartaMonstruo primerDragon = new DragonBlancoDeOjosAzules();
		juego.colocarCartaEnMano(primerDragon);
		juego.colocarEnPosicionDeAtaqueBocaArriba(primerDragon);
		
		juego.colocarCartaEnMano(cartaMonstruo);
		juego.colocarCartaEnMano(otraCarta);
		juego.colocarEnPosicionDeDefensaBocaArriba(cartaMonstruo);
		juego.colocarEnPosicionDeAtaqueBocaArriba(otraCarta);
		CartaMonstruo segundoDragon = new DragonBlancoDeOjosAzules();
		juego.colocarCartaEnMano(segundoDragon);
		juego.colocarEnPosicionDeAtaqueBocaArriba(segundoDragon);
		
		juego.colocarCartaEnMano(cartaMonstruo);
		juego.colocarCartaEnMano(otraCarta);
		juego.colocarEnPosicionDeDefensaBocaArriba(cartaMonstruo);
		juego.colocarEnPosicionDeAtaqueBocaArriba(otraCarta);
		CartaMonstruo tercerDragon = new DragonBlancoDeOjosAzules();
		juego.colocarCartaEnMano(tercerDragon);
		juego.colocarEnPosicionDeAtaqueBocaArriba(tercerDragon);
		
		CartaMonstruo dragonDefinitivo = new DragonDefinitivoDeOjosAzules();
		juego.colocarCartaEnMano(dragonDefinitivo);
		juego.colocarEnPosicionDeAtaqueBocaArriba(dragonDefinitivo);

		assertTrue(juego.estaEnCementerio(primerDragon));
		assertTrue(juego.estaEnCementerio(segundoDragon));
		assertTrue(juego.estaEnCementerio(tercerDragon));
		assertTrue(juego.estaEnCampo(dragonDefinitivo));
	}
	
	@Test
	public void testInsectoComeHombres() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo insecto = new InsectoComeHombres();
		juego.colocarCartaEnMano(insecto);
		juego.colocarEnPosicionDeDefensaBocaAbajo(insecto);
		juego.terminarTurno();
		//Hacer mas tests sobre esto.
		CartaMonstruo cartaMonstruo = new BebeDragon();
		juego.colocarCartaEnMano(cartaMonstruo);
		juego.colocarEnPosicionDeAtaqueBocaArriba(cartaMonstruo);
		juego.atacarCon(cartaMonstruo, insecto);
		
		int puntosDeVidaEsperados = 8000;
		
		assertTrue(juego.estaEnCementerio(cartaMonstruo));
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
		
		juego.terminarTurno();
		assertFalse(juego.estaEnCementerio(insecto));
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
	}
	
	@Test
	public void atacarDirectamenteALosPuntosDeVida() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo insecto = new InsectoComeHombres();
		juego.colocarCartaEnMano(insecto);
		juego.colocarEnPosicionDeAtaqueBocaArriba(insecto);
		juego.atacarDirectamenteCon(insecto);
		
		int puntosDeVidaEsperados = 8000 - insecto.obtenerAtaque();
		juego.terminarTurno();
		
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
	}
	
	@Test
	public void test01CilindroMagico() {
		Juego juego = Juego.nuevoJuego();
		CartaTrampa cilindroMagico = new CilindroMagico();
		juego.colocarCartaEnMano(cilindroMagico);
		juego.colocarCartaTrampa(cilindroMagico);
		juego.terminarTurno();
		
		CartaMonstruo insecto = new InsectoComeHombres();
		juego.colocarCartaEnMano(insecto);
		juego.colocarEnPosicionDeAtaqueBocaArriba(insecto);
		juego.atacarDirectamenteCon(insecto);
		
		int puntosDeVidaEsperados = 8000 - insecto.obtenerAtaque();
		assertFalse(juego.estaEnCementerio(insecto));
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
		
		juego.terminarTurno();
		puntosDeVidaEsperados = 8000;
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
	}
	
	@Test
	public void test02CilindroMagico() {
		Juego juego = Juego.nuevoJuego();
		CartaTrampa cilindroMagico = new CilindroMagico();
		juego.colocarCartaEnMano(cilindroMagico);
		juego.colocarCartaTrampa(cilindroMagico);
		CartaMonstruo cartaMonstruo = new BebeDragon();
		juego.colocarCartaEnMano(cartaMonstruo);
		juego.colocarEnPosicionDeAtaqueBocaArriba(cartaMonstruo);
		juego.terminarTurno();
		
		CartaMonstruo insecto = new InsectoComeHombres();
		juego.colocarCartaEnMano(insecto);
		juego.colocarEnPosicionDeAtaqueBocaArriba(insecto);
		juego.atacarCon(insecto, cartaMonstruo);
		
		int puntosDeVidaEsperados = 8000 - insecto.obtenerAtaque();
		assertFalse(juego.estaEnCementerio(insecto));
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
		
		juego.terminarTurno();
		puntosDeVidaEsperados = 8000;
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
		assertFalse(juego.estaEnCementerio(cartaMonstruo));
	}
	
	@Test
	public void testReinforcements() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo cartaMayorAtaque = new Digitron();
		CartaMonstruo cartaMenorAtaque = new BebeDragon();
		juego.colocarCartaEnMano(cartaMenorAtaque);
		juego.colocarEnPosicionDeAtaqueBocaArriba(cartaMenorAtaque);
		CartaTrampa reinforcements = new Reinforcements();
		juego.colocarCartaEnMano(reinforcements);
		juego.colocarCartaTrampa(reinforcements);
		juego.terminarTurno();
		juego.colocarCartaEnMano(cartaMayorAtaque);
		juego.colocarEnPosicionDeAtaqueBocaArriba(cartaMayorAtaque);
		juego.atacarCon(cartaMayorAtaque, cartaMenorAtaque);
		
		assertTrue(juego.estaEnCementerio(cartaMayorAtaque));
		
		int puntosDeVidaEsperados = 8000 - ((1200 + 500) - 1500);
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
	}
	
	@Test
	public void testMazoSinCartasJuegoTerminado() {
		Juego juego = Juego.nuevoJuego();
		//el jugador actual ya tomo 6 cartas, faltan 34.
		
		for (int i=0; i<69; i++) {
			//Cada vez que cambia el turno, el oponente agarra una carta.
			//Termino el turno 69 veces (35 del segundo jugador y 34 del primero que tenia 6 cartas) 
			//para que se quede sin cartas en el mazo.
			juego.terminarTurno();
		}
		
		assertTrue(juego.haTerminado());
	}
	
	@Test
	public void testJugadorConExodiaCompletoEnManoJuegoTerminado() {
		Juego juego = Juego.nuevoJuego();
		ParteDeExodia cabeza = new ExodiaElProhibido();
		ParteDeExodia brazoDerecho = new BrazoDerechoDelProhibido();
		ParteDeExodia brazoIzquierdo = new BrazoIzquierdoDelProhibido();
		ParteDeExodia piernaDerecha = new PiernaDerechaDelProhibido();
		ParteDeExodia piernaIzquierda = new PiernaIzquierdaDelProhibido();
		
		assertFalse(juego.haTerminado());
		
		//Agrego las partes de exodia a la mano del jugador actual.
		juego.agregarExodia(cabeza, brazoDerecho, brazoIzquierdo, piernaDerecha, piernaIzquierda);
		
		assertTrue(juego.haTerminado());
		assertTrue(juego.jugadorActual.haGanado());
		assertTrue(juego.oponente.haPerdido());
	}
	
	@Test
	public void testAtacarDirectamenteOponenteRecibeAtaqueALosPuntosDeVida() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo digitron = new Digitron();
		juego.colocarCartaEnMano(digitron);
		juego.colocarEnPosicionDeAtaqueBocaArriba(digitron);
		juego.atacarDirectamenteCon(digitron);
		juego.terminarTurno();
		
		int puntosDeVidaEsperados = 8000 - digitron.obtenerAtaque();
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
	}
	
	@Test
	public void testVoltearUnaCartaDeMonstruoBocaAbajoAhoraEstaBocaArriba() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo digitron = new Digitron();
		juego.colocarCartaEnMano(digitron);
		juego.colocarEnPosicionDeAtaqueBocaAbajo(digitron);
		
		//Ahora digitron esta boca arriba y puede atacar.
		juego.voltearMonstruo(digitron);
		
		juego.atacarDirectamenteCon(digitron);
		juego.terminarTurno();
		
		int puntosDeVidaEsperados = 8000 - digitron.obtenerAtaque();
		assertEquals(puntosDeVidaEsperados, juego.obtenerPuntosDeVida());
	}
	
	@Test
	public void testVoltearUnaCartaDeMonstruoBocaArribaLanzaExcepcion() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo digitron = new Digitron();
		juego.colocarCartaEnMano(digitron);
		juego.colocarEnPosicionDeAtaqueBocaArriba(digitron);
		boolean lanzaError = false;
		try {
			juego.voltearMonstruo(digitron);
		}
		catch (UnaCartaBocaArribaNoPuedeVoltearseException e) {
			lanzaError = true;
		}
		
		assertTrue(lanzaError);
	}
	
	@Test
	public void testPuntosDeVidaDeOponenteLlegaACeroTerminaElJuego() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo digitron = new Digitron();
		juego.colocarCartaEnMano(digitron);
		juego.colocarEnPosicionDeAtaqueBocaArriba(digitron);
		
		//Ataco a los puntos de vida del oponente 6 veces, para que sus puntos de vida lleguen a 0
		for (int i=0; i < 6; i++) juego.atacarDirectamenteCon(digitron);
		
		assertTrue(juego.haTerminado());
		assertTrue(juego.jugadorActual.haGanado());
		assertTrue(juego.oponente.haPerdido());
	}
	
	@Test
	public void testVoltearCartaMagica() {
		Juego juego = Juego.nuevoJuego();
		CartaMonstruo cartaMonstruo = new BebeDragon();
		CartaMonstruo cartaConMenorAtaque = new MegaBolaDeTrueno();
		juego.colocarCartaEnMano(cartaMonstruo);
		juego.colocarCartaEnMano(cartaConMenorAtaque);
		juego.colocarEnPosicionDeAtaqueBocaArriba(cartaMonstruo);
		juego.colocarEnPosicionDeAtaqueBocaArriba(cartaConMenorAtaque);
		juego.terminarTurno();
		
		//La carta Fisura destruye el monstruo rival de menor ataque.
		Fisura fisura = new Fisura();
		juego.colocarCartaEnMano(fisura);
		juego.colocarCartaMagica(fisura);
		juego.terminarTurno();
		
		//La carta magica solo fue colocada, no se activo aun.
		assertFalse(juego.estaEnCementerio(cartaConMenorAtaque));
		
		juego.terminarTurno();
		//Se activa la carta y se manda al cementerio
		juego.voltearCarta(fisura);
		assertTrue(juego.estaEnCementerio(fisura));
		
		juego.terminarTurno();
		
		assertTrue(juego.estaEnCementerio(cartaConMenorAtaque));
	}

}
