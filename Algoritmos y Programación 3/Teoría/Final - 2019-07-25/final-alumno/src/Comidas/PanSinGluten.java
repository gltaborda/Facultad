package Comidas;

import comensales.Persona;

public class PanSinGluten extends Comida {

	public PanSinGluten() {
		
		calorias = 10;
		
	}
	@Override
	public void mePodesComer(Persona comensal) {

		comensal.comer(this);
		
	}


}
