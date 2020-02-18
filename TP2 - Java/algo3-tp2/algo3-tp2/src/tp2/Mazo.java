package tp2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tp2.cartas.*;
import tp2.interfaces.Carta;

public class Mazo {
	
	private List<Carta> cartas = new ArrayList<Carta>();
	
	public Mazo() {
		//Contiene 40 cartas.
		for (int i = 0; i<4; i++) {
			Carta bebeDragon = new BebeDragon();
			cartas.add(bebeDragon);
		}
		for (int i = 0; i<3; i++) {
			Carta conejoOscuro = new ConejoOscuro();
			cartas.add(conejoOscuro);
		}
		for (int i = 0; i<3; i++) {
			Carta digitron = new Digitron();
			cartas.add(digitron);
		}
		for (int i = 0; i<3; i++) {
			Carta disuelverocas = new Disuelverocas();
			cartas.add(disuelverocas);
		}
		for (int i = 0; i<3; i++) {
			Carta dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();
			cartas.add(dragonBlancoDeOjosAzules);
		}
		for (int i = 0; i<2; i++) {
			Carta dragonMeteoro = new DragonMeteoro();
			cartas.add(dragonMeteoro);
		}
		Carta ollaDeLaCodicia = new OllaDeLaCodicia();
		Carta agujeroNegro = new AgujeroNegro();
		Carta wasteland = new Wasteland();
		Carta sogen = new Sogen();
		Carta fisura = new Fisura();
		Carta jinzo7 = new Jinzo7();
		for (int i = 0; i<3; i++) {
			Carta megaBolaDeTrueno = new MegaBolaDeTrueno();
			cartas.add(megaBolaDeTrueno);
		}
		for (int i = 0; i<3; i++) {
			Carta soldadoGiganteDePiedra = new SoldadoGiganteDePiedra();
			cartas.add(soldadoGiganteDePiedra);
		}
		Carta cilindroMagico = new CilindroMagico();
		Carta dragonDefinitivoDeOjosAzules = new DragonDefinitivoDeOjosAzules();
		Carta insectoComeHombres = new InsectoComeHombres();
		for (int i = 0; i<2; i++) {
			Carta reinforcements = new Reinforcements();
			cartas.add(reinforcements);
		}
		Carta cabeza = new ExodiaElProhibido();
		Carta brazoDerecho = new BrazoDerechoDelProhibido();
		Carta brazoIzquierdo = new BrazoIzquierdoDelProhibido();
		Carta piernaDerecha = new PiernaDerechaDelProhibido();
		Carta piernaIzquierda = new PiernaIzquierdaDelProhibido();
		cartas.add(fisura);
		cartas.add(cabeza);
		cartas.add(brazoIzquierdo);
		cartas.add(brazoDerecho);
		cartas.add(piernaIzquierda);
		cartas.add(piernaDerecha);
		cartas.add(jinzo7);
		cartas.add(agujeroNegro);
		cartas.add(ollaDeLaCodicia);
		cartas.add(wasteland);
		cartas.add(sogen);
		cartas.add(cilindroMagico);
		cartas.add(dragonDefinitivoDeOjosAzules);
		cartas.add(insectoComeHombres);
		
		Collections.shuffle(cartas);
	}

	public void agregarCartaEn(Mano mano) {
		Carta carta = cartas.remove(0);
		if (cartas.isEmpty()) Juego.getInstance().jugadorHaPerdido();
		mano.agregarCarta(carta);
	}
	
}
