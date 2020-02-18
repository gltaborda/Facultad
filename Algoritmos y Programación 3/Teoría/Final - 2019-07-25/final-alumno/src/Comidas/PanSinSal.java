package Comidas;

import comensales.Persona;

public class PanSinSal extends Comida {

	public PanSinSal() {
		
		calorias = 10%10;
		
	}
	@Override
	public void mePodesComer(Persona comensal) {

		comensal.comer(this);
		
	}

	

}
