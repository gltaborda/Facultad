package tp2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tp2.estrategiasDeCartaMonstruo.InvocacionDragonDefinitivo;
import tp2.excepciones.EstaCartaNoEstaEnElCampoException;
import tp2.excepciones.LaCartaNoEstaEnElCampoException;
import tp2.excepciones.LaZonaDeMonstruosEstaLlenaException;

public class ZonaDeMonstruos {

    private List<CartaMonstruo> monstruos = new ArrayList<CartaMonstruo>();
    private OrganizadorMonstruos organizador = new OrganizadorMonstruos();
    private Map<String, Integer> contadorMonstruos = new HashMap<String, Integer>();

    public void colocar(CartaMonstruo cartaMonstruo) {
        if (estaLlena()) throw new LaZonaDeMonstruosEstaLlenaException();
        monstruos.add(cartaMonstruo);
        organizador.agregar(cartaMonstruo);
        cartaMonstruo.agregarOcurrencia(contadorMonstruos);
    }

    public void destruirMonstruos(Tablero tablero) {
    	while (! estaVacia()) tablero.mandarAlCementerio(monstruos.get(0));
    }

    public int obtenerCantidadMonstruos() {
        return monstruos.size();
    }

    public boolean contieneA(CartaMonstruo cartaMonstruo) {
        return monstruos.contains(cartaMonstruo);
    }

    public void aumentarAtaque(int ataque) {
        for (CartaMonstruo monstruo : monstruos) monstruo.aumentarAtaque(ataque);
    }

    public void aumentarDefensa(int defensa) {
        for (CartaMonstruo monstruo : monstruos) monstruo.aumentarDefensa(defensa);
    }

    public CartaMonstruo destruirCartaMenorAtaque() {

        CartaMonstruo monstruoMenorAtaque = organizador.obtenerMonstruoMenorAtaque();
        return monstruoMenorAtaque;
    }

    public void activarEfecto(CartaMonstruo cartaMonstruo, Jugador jugadorActual, Jugador oponente) {
        if (! monstruos.contains(cartaMonstruo)) throw new EstaCartaNoEstaEnElCampoException();
        int indice = monstruos.indexOf(cartaMonstruo);
        CartaMonstruo monstruo = monstruos.get(indice);
        monstruo.activarEfecto(jugadorActual, oponente);
    }

    public boolean estaVacia() {
        return monstruos.isEmpty();
    }

    public boolean contieneA(String nombreMonstruo, int cantidadSacrificios) {
        int ocurrencias = contadorMonstruos.get(nombreMonstruo);
        return ocurrencias == cantidadSacrificios;
    }

    public CartaMonstruo sacrificarDragonBlancoOjosAzules(InvocacionDragonDefinitivo invocacion) {
        CartaMonstruo dragon = organizador.obtenerDragonBlancoOjosAzules(invocacion);
        return dragon;
    }

    public boolean estaLlena() {
        return monstruos.size() == 5;
    }

    public void destruirMonstruo(CartaMonstruo cartaAtacante) {
        organizador.eliminarMonstruo(cartaAtacante);
        monstruos.remove(cartaAtacante);
    }

    public List<CartaMonstruo> obtenerCartas() {
        return monstruos;
    }

	public CartaMonstruo obtenerCarta(CartaMonstruo cartaMonstruo) {
		if (! monstruos.contains(cartaMonstruo)) throw new LaCartaNoEstaEnElCampoException();
        int indice = monstruos.indexOf(cartaMonstruo);
        return monstruos.remove(indice);
	}

	public void voltear(CartaMonstruo cartaMonstruo) {
		int indice = monstruos.indexOf(cartaMonstruo);
		CartaMonstruo monstruo = monstruos.get(indice);
		monstruo.voltear();
	}
}
