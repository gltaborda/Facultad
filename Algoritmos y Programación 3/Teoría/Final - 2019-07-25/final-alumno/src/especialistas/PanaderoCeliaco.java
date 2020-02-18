package especialistas;

import Comidas.Comida;
import Comidas.PanSinGluten;

public class PanaderoCeliaco implements PanaderoHabilidad{

	public Comida hacerPan() {
		PanSinGluten pan = new PanSinGluten();
		return pan;
	}

}
