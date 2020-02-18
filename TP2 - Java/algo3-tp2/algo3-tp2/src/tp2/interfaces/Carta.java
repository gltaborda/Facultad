package tp2.interfaces;

import tp2.Tablero;

public interface Carta {

	void colocarEn(Tablero tablero);

	void mandarAlCementerio(Tablero tablero);

	String obtenerNombre();

}
