package especialistas;

import Comidas.Comida;
import Comidas.Empanada;
import Comidas.EmpanadaSinGluten;
import Comidas.EmpanadaSinSal;
import Comidas.Pan;
import Comidas.PanSinGluten;
import Comidas.PanSinSal;

public class MasterChef implements EmpanaderoHabilidad, PanaderoHabilidad{

	public Comida hacerEmpanadaSinSal() {
		EmpanadaSinSal empanada = new EmpanadaSinSal();
		return empanada;
	}

	public Comida hacerPan() {
		Pan pan = new Pan();
		return pan;
	}

	public Comida hacerPanSinGluten() {
		PanSinGluten pan = new PanSinGluten();
		return pan;
	}

	public Comida hacerPanSinSal() {
		PanSinSal pan = new PanSinSal();
		return pan;
	}

	public Comida hacerEmpanada() {
		Empanada empanada = new Empanada();
		return empanada;
	}

	public Comida hacerEmpanadaSinGluten() {
		EmpanadaSinGluten empanada = new EmpanadaSinGluten();
		return empanada;
	}

}
