package comensales;

import Comidas.Comida;
import Comidas.Empanada;
import Comidas.EmpanadaSinGluten;
import Comidas.EmpanadaSinSal;
import Comidas.Pan;
import Comidas.PanSinGluten;
import Comidas.PanSinSal;
import Exceptions.NoPuedoComerEsoError;

public class PersonaHipertensa extends Persona{

	@Override
	public void comer(Comida algo) {

		algo.mePodesComer(this);
		
	}

	@Override
	public void comer(Empanada algo) {

		throw new NoPuedoComerEsoError();
		
	}

	@Override
	public void comer(EmpanadaSinGluten algo) {

		throw new NoPuedoComerEsoError();
		
	}

	@Override
	public void comer(EmpanadaSinSal algo) {

		calorias += algo.getCalorias();
		
	}

	@Override
	public void comer(Pan algo) {

		throw new NoPuedoComerEsoError();
		
	}

	@Override
	public void comer(PanSinGluten algo) {

		throw new NoPuedoComerEsoError();
		
	}

	@Override
	public void comer(PanSinSal algo) {

		calorias += algo.getCalorias();
		
	}


	
}
