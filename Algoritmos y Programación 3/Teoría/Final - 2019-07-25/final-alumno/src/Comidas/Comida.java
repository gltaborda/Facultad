package Comidas;

import comensales.Persona;

public abstract class Comida {

	protected int calorias;

	public int getCalorias() {
		
		return calorias;
		
	}
	public abstract void mePodesComer(Persona comensal);
}
