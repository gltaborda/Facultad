package Comidas;

import comensales.Persona;

public class EmpanadaSinGluten extends Comida {

	public EmpanadaSinGluten() {
		
		calorias = 15;
		
	}
	@Override
	public void mePodesComer(Persona comensal) {

		comensal.comer(this);
		
	}


}
