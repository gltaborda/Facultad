package tp2.interfaces;

import tp2.Jugador;

public interface CartaCampo extends Carta {

    void activarEfecto(Jugador jugadorActual, Jugador oponente);

}
