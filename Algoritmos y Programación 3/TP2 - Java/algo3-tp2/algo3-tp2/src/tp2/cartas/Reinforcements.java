package tp2.cartas;

import tp2.CartaMonstruo;
import tp2.Jugador;
import tp2.Tablero;
import tp2.interfaces.CartaTrampa;

public class Reinforcements implements CartaTrampa {

    public void activarTrampa(CartaMonstruo monstruoAtacante, CartaMonstruo cartaPropia, Jugador jugadorAtacante,
Jugador jugador) {
        cartaPropia.aumentarAtaque(500);
        jugadorAtacante.finalizarAtaque(monstruoAtacante, cartaPropia, jugador);
        cartaPropia.disminuirAtaque(500);
    }

    public void activarTrampa(CartaMonstruo monstruoAtacante, Jugador jugadorAtacante, Jugador jugador) {
        //carta no puede activarse, no hay monstruos en el campo.
    }

    public void colocarEn(Tablero tablero) {
        tablero.colocarCarta(this);
    }
    
    public void mandarAlCementerio(Tablero tablero) {
		tablero.mandarAlCementerio(this);
	}

    public String obtenerNombre() {
        return "Reinforcements";
    }
}
