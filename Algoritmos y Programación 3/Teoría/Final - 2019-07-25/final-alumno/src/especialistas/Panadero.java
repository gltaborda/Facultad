package especialistas;

import Comidas.Comida;
import Comidas.Pan;

public class Panadero implements PanaderoHabilidad{

	public Comida hacerPan() {
		Pan pan = new Pan();
		return (Pan)pan;
	}

}
