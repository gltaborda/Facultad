package tp2.estrategiasDeCartaMonstruo;

import tp2.Tablero;
import tp2.ZonaDeMonstruos;
import tp2.interfaces.EstrategiaInvocacion;

public class InvocacionSinSacrificio implements EstrategiaInvocacion {

	public void colocarEn(Tablero tablero) {
	}

	public boolean esRealizable(ZonaDeMonstruos zonaDeMonstruos) {
		return true;
	}

	public void realizarSacrificio(Tablero tablero) {
	}

}
