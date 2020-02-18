package tp2;

import tp2.estrategiasDeCartaMonstruo.InvocacionDragonDefinitivo;
import tp2.excepciones.ElJugadorTieneMonstruosEnElCampoException;
import tp2.excepciones.NoHaySuficientesSacrificiosException;
import tp2.interfaces.Carta;
import tp2.interfaces.CartaCampo;
import tp2.interfaces.CartaMagica;
import tp2.interfaces.CartaTrampa;
import tp2.interfaces.EstrategiaInvocacion;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

    private List<Carta> cementerio = new ArrayList<Carta>();
    private ZonaDeMonstruos zonaDeMonstruos = new ZonaDeMonstruos();
    private ZonaDeTrampasYMagicas zonaDeTrampasYMagicas = new ZonaDeTrampasYMagicas();
    private ZonaDeCampo zonaDeCampo = new ZonaDeCampo();

    public void mandarAlCementerio(Carta carta) {
		carta.mandarAlCementerio(this);
	}
    
    public void mandarAlCementerio(CartaMonstruo cartaMonstruo) {
    	CartaMonstruo monstruo = zonaDeMonstruos.obtenerCarta(cartaMonstruo);
        cementerio.add(monstruo);
    }

    public void mandarAlCementerio(CartaTrampa cartaTrampa) {
        CartaTrampa trampa = zonaDeTrampasYMagicas.obtenerCarta(cartaTrampa);
        cementerio.add(trampa);
    }
    
    public void mandarAlCementerio(CartaMagica cartaMagica) {
    	CartaMagica magica = zonaDeTrampasYMagicas.obtenerCarta(cartaMagica);
        cementerio.add(magica);
    }
    
    public void mandarAlCementerio(CartaCampo cartaCampo) {
    	CartaCampo campo = zonaDeCampo.obtenerCarta(cartaCampo);
    	cementerio.add(campo);
    }

    public boolean estaEnCementerio(Carta carta) {
    	return cementerio.contains(carta);
    }

    public void colocarCarta(CartaMonstruo monstruo) {
    	monstruo.invocar(this);
    	zonaDeMonstruos.colocar(monstruo);
    }

    public void colocarCarta(CartaCampo cartaCampo) {
    	zonaDeCampo.limpiarCampo(this);
        zonaDeCampo.colocar(cartaCampo);
    }

    public void colocarCarta(CartaTrampa cartaTrampa) {
        zonaDeTrampasYMagicas.colocar(cartaTrampa);
    }
    
    public void colocarCarta(CartaMagica cartaMagica) {
    	zonaDeTrampasYMagicas.colocar(cartaMagica);
    }

    public void destruirMonstruos() {
        zonaDeMonstruos.destruirMonstruos(this);
    }

    public boolean estaEnCampo(CartaMonstruo cartaMonstruo) {
        return zonaDeMonstruos.contieneA(cartaMonstruo);
    }

    public boolean estaEnCampo(CartaTrampa cartaTrampa) {
        return zonaDeTrampasYMagicas.contieneA(cartaTrampa);
    }
    
	public boolean estaEnCampo(CartaMagica agujeroNegro) {
		return zonaDeTrampasYMagicas.contieneA(agujeroNegro);
	}

    public void aumentarAtaque(int ataque) {
        zonaDeMonstruos.aumentarAtaque(ataque);
    }

    public void aumentarDefensa(int defensa) {
        zonaDeMonstruos.aumentarDefensa(defensa);
    }

    public void destruirCartaMenorAtaque() {
        CartaMonstruo monstruoConMenorAtaque = zonaDeMonstruos.destruirCartaMenorAtaque();
        mandarAlCementerio(monstruoConMenorAtaque);
    }

    public void sacrificarDragonBlancoOjosAzules(InvocacionDragonDefinitivo invocacion) {
        CartaMonstruo dragon = zonaDeMonstruos.sacrificarDragonBlancoOjosAzules(invocacion);
        mandarAlCementerio(dragon);
    }

    public void activarEfecto(CartaMonstruo cartaMonstruo, Jugador jugadorActual, Jugador oponente) {
        zonaDeMonstruos.activarEfecto(cartaMonstruo, jugadorActual, oponente);
    }

    public void sacrificarMonstruo(EstrategiaInvocacion invocacion, int cantidadSacrificios) {
        if (!invocacion.esRealizable(zonaDeMonstruos)) throw new NoHaySuficientesSacrificiosException();
        for (int i = 0; i < cantidadSacrificios; i++) invocacion.realizarSacrificio(this);
    }

    public void destruirCarta(CartaMonstruo cartaAtacante) {
        zonaDeMonstruos.destruirMonstruo(cartaAtacante);
        mandarAlCementerio(cartaAtacante);
    }

    public void recibirAtaqueDirecto(int ataqueRecibido, Jugador jugador) {
        if (! zonaDeMonstruos.estaVacia()) throw new ElJugadorTieneMonstruosEnElCampoException();
        jugador.descontarPuntosDeVida(ataqueRecibido);
    }

    public void activarTrampa(CartaMonstruo cartaJugadorAtacante, CartaMonstruo cartaPropia, Jugador jugadorAtacante,
Jugador jugador) {
        zonaDeTrampasYMagicas.activarTrampa(cartaJugadorAtacante, cartaPropia, jugadorAtacante, jugador);
    }

    public void activarTrampa(CartaMonstruo monstruoAtacante, Jugador jugadorAtacante, Jugador jugador) {
        zonaDeTrampasYMagicas.activarTrampa(monstruoAtacante, jugadorAtacante, jugador);
    }
	
    public void voltearCarta(CartaMonstruo monstruo) {
    	zonaDeMonstruos.voltear(monstruo);
    }

    public List<CartaMonstruo> obtenerCartasEnZonaDeMonstruos() {
        return zonaDeMonstruos.obtenerCartas();
    }

	public CartaMagica voltearCarta(CartaMagica cartaMagica) {
		return zonaDeTrampasYMagicas.voltear(cartaMagica);
	}
}
