package tp2.estrategiasDeCartaMonstruo;

import tp2.Tablero;
import tp2.ZonaDeMonstruos;
import tp2.interfaces.EstrategiaInvocacion;

public class InvocacionConDosSacrificios implements EstrategiaInvocacion {

	int cantidadSacrificios = 2;
	
	public void colocarEn(Tablero tablero) {
		tablero.sacrificarMonstruo(this, cantidadSacrificios);
	}

	public boolean esRealizable(ZonaDeMonstruos zonaDeMonstruos) {
		return zonaDeMonstruos.obtenerCantidadMonstruos() > 1;
	}

	public void realizarSacrificio(Tablero tablero) {
		tablero.destruirCartaMenorAtaque();
	}

}
