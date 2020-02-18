package Comidas;

import comensales.Persona;
public class EmpanadaSinSal extends Comida {

	public EmpanadaSinSal() {
		
		calorias = 15%10;
		
	}
	@Override
	public void mePodesComer(Persona comensal) {

		comensal.comer(this);
		
	}


}
