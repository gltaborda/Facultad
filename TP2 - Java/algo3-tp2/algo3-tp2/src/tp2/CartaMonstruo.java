package tp2;

import java.util.Map;

import tp2.estrategiasDeCartaMonstruo.EstrategiaModoAtaque;
import tp2.estrategiasDeCartaMonstruo.EstrategiaModoDefensa;
import tp2.estrategiasDeCartaMonstruo.LadoBocaAbajo;
import tp2.estrategiasDeCartaMonstruo.LadoBocaArriba;
import tp2.excepciones.EstaCartaNoContieneUnEfectoException;
import tp2.interfaces.Carta;
import tp2.interfaces.EstadoJugador;
import tp2.interfaces.EstrategiaInvocacion;
import tp2.interfaces.EstrategiaLadoCarta;
import tp2.interfaces.EstrategiaMonstruo;

public abstract class CartaMonstruo implements Carta {

	protected String nombre;
	protected int ataque;
	protected int defensa;
	protected int nivel; //este es el nivel de estrellas (usado para sacrificios).
	private EstrategiaMonstruo estrategia;
	protected EstrategiaInvocacion invocacion;
	private EstrategiaLadoCarta ladoCarta;
	
	public int obtenerAtaque() {
		return ataque;
	}
	
	public int obtenerDefensa() {
		return defensa;
	}
	
	public void modoAtaque() {
        estrategia = new EstrategiaModoAtaque(this);
    }
	
	public void modoDefensa() {
        estrategia = new EstrategiaModoDefensa(this);
    }

	public void descontarPuntosDeVida(Jugador oponente, int diferencia) {
		estrategia.descontarPuntosDeVida(oponente, diferencia);
	}

	public void colocarEn(Tablero tablero) {
		tablero.colocarCarta(this);
	}
	
	public void invocar(Tablero tablero) {
		invocacion.colocarEn(tablero);
	}

	public void aumentarAtaque(int aumentoDeAtaque) {
		ataque += aumentoDeAtaque;
	}

	public void aumentarDefensa(int aumentoDeDefensa) {
		defensa += aumentoDeDefensa;
	}

	public int compararCon(CartaMonstruo otroMonstruo) {
		return otroMonstruo.comparar(ataque);
	}

	private int comparar(int otroAtaque) {
		//metodo comparador.
		if (otroAtaque > ataque) return 1;
		if (otroAtaque < ataque) return -1;
		return 0;
	}

	public void activarEfecto(Jugador Actual, Jugador oponente) {
		throw new EstaCartaNoContieneUnEfectoException();
	}

	public void agregarOcurrencia(Map<String, Integer> contadorMonstruos) {
		int ocurrencias = contadorMonstruos.containsKey(nombre) ? contadorMonstruos.get(nombre) : 0;
		contadorMonstruos.put(nombre, ocurrencias + 1);
	}

	public String obtenerNombre() {
		return nombre;
	}

	public void bocaAbajo() {
		ladoCarta = new LadoBocaAbajo(this);
	}
	
	public void bocaArriba() {
		ladoCarta = new LadoBocaArriba();
	}

	public EstadoJugador atacar(CartaMonstruo cartaOponente) {
		return ladoCarta.atacar(cartaOponente, estrategia);
	}

	public EstadoJugador recibirAtaque(CartaMonstruo monstruo, int ataque) {
		return ladoCarta.recibirAtaque(monstruo, ataque, estrategia);
	}

	public EstadoJugador activarEfectoDeVolteo(CartaMonstruo monstruoAtacante, int obtenerAtaque, 
EstrategiaMonstruo estrategia) {
		return estrategia.recibirAtaque(monstruoAtacante, obtenerAtaque);
	}

	public void atacarDirectamente(Jugador oponente) {
		ladoCarta.atacarDirectamente(oponente, estrategia);
	}

	public void descontarPuntosDeVida(Jugador jugador) {
		jugador.descontarPuntosDeVida(ataque);
	}

	public void voltear() {
		ladoCarta = ladoCarta.voltear();
	}

	public void disminuirAtaque(int disminucion) {
		ataque -= disminucion;	
	}

}
