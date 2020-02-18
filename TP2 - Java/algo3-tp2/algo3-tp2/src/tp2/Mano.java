package tp2;

import java.util.ArrayList;
import java.util.List;

import tp2.excepciones.LaCartaNoEstaEnLaManoException;
import tp2.interfaces.Carta;

public class Mano {

	private List<Carta> cartas = new ArrayList<Carta>();
	private Exodia exodia = new Exodia();

	public void agregarCarta(Carta carta) {
		cartas.add(carta);
	}

	public int obtenerCantidadCartas() {
		return cartas.size();
	}

	public void agregarParteExodia(ParteDeExodia parte) {
		agregarCarta(parte);
		exodia.agregarParte(parte);
		if (exodia.estaCompleto()) Juego.getInstance().jugadorHaGanado();
	}

	public void retirarCarta(Carta carta) {
		if (! cartas.contains(carta)) throw new LaCartaNoEstaEnLaManoException();

		int indice = cartas.indexOf(carta);
		cartas.remove(indice);
	}

	public List<Carta> obtenerCartasEnMano() {
		return cartas;
	}
}
