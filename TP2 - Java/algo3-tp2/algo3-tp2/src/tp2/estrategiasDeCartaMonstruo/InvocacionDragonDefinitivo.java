package tp2.estrategiasDeCartaMonstruo;

import java.util.Iterator;
import java.util.List;

import tp2.CartaMonstruo;
import tp2.Tablero;
import tp2.ZonaDeMonstruos;
import tp2.interfaces.EstrategiaInvocacion;

public class InvocacionDragonDefinitivo implements EstrategiaInvocacion {

	private String sacrificio = "Dragon Blanco De Ojos Azules";
	private int cantidadSacrificios = 3;
	
	public void colocarEn(Tablero tablero) {
		tablero.sacrificarMonstruo(this, cantidadSacrificios);
	}

	public boolean esRealizable(ZonaDeMonstruos zonaDeMonstruos) {
		return zonaDeMonstruos.contieneA("Dragon Blanco De Ojos Azules", 3);
	}

	public CartaMonstruo obtenerSacrificio(List<CartaMonstruo> monstruos) {
		Iterator<CartaMonstruo> iterador = monstruos.iterator();
		while (iterador.hasNext()) {
		    CartaMonstruo monstruo = iterador.next();
		    if (monstruo.obtenerNombre().equals(sacrificio)) {
		        iterador.remove();
		        return monstruo;
		    }
		}
		return null;
	}

	public void realizarSacrificio(Tablero tablero) {
		tablero.sacrificarDragonBlancoOjosAzules(this);
	}
	

}
