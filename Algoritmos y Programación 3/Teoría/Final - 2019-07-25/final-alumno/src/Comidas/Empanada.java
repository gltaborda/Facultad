package Comidas;

import comensales.Persona;

public class Empanada extends Comida {

	public Empanada(){
		
		calorias = 15;
		
	}
	@Override
	public void mePodesComer(Persona comensal) {
		
		comensal.comer(this);
		
	}


}
