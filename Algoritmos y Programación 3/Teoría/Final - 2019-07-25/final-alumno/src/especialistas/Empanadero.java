package especialistas;

import Comidas.Comida;
import Comidas.Empanada;

public class Empanadero implements EmpanaderoHabilidad{

	public Comida hacerEmpanada() {
		Empanada empanada = new Empanada();
		return (Empanada)empanada;
	}
	
}
