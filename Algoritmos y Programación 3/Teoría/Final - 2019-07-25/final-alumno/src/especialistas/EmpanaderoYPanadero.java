package especialistas;

import Comidas.Comida;
import Comidas.Empanada;
import Comidas.Pan;

public class EmpanaderoYPanadero implements EmpanaderoHabilidad, PanaderoHabilidad{

	public Comida hacerEmpanada(){
		Empanada empanada = new Empanada();
		return empanada;
	}
	
	public Comida hacerPan(){
		Pan pan = new Pan();
		return pan;
	}

}
