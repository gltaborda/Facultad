package Comidas;

import comensales.Persona;

public class Pan extends Comida{

	public Pan() {
		
		calorias = 10;
		
	}
	@Override
	public void mePodesComer(Persona comensal) {

		comensal.comer(this);
		
	}
	
}
