package especialistas;

import Comidas.Comida;
import Comidas.EmpanadaSinGluten;

public class EmpanaderoCeliaco implements EmpanaderoHabilidad{
	
	public Comida hacerEmpanada(){
		EmpanadaSinGluten empanada = new EmpanadaSinGluten();
		return empanada;
	}
	
}
