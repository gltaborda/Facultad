package tp2.interfaces;

import tp2.Tablero;
import tp2.ZonaDeMonstruos;

public interface EstrategiaInvocacion {

	public void colocarEn(Tablero tablero);

	public boolean esRealizable(ZonaDeMonstruos zonaDeMonstruos);

	public void realizarSacrificio(Tablero tablero);
	
}
