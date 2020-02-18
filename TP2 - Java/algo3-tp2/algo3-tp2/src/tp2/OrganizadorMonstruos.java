package tp2;
import java.util.ArrayList;
import java.util.List;

import tp2.estrategiasDeCartaMonstruo.InvocacionDragonDefinitivo;
import tp2.interfaces.Carta;

public class OrganizadorMonstruos {

	private MonstruoComparador comparador = new MonstruoComparador();
	private List<CartaMonstruo> monstruos = new ArrayList<CartaMonstruo>();
	
	public void agregar(CartaMonstruo cartaMonstruo) {
		monstruos.add(cartaMonstruo);
		monstruos.sort(comparador);
	}

	public CartaMonstruo obtenerMonstruoMenorAtaque() {
		return monstruos.remove(0);
	}

	public CartaMonstruo obtenerDragonBlancoOjosAzules(InvocacionDragonDefinitivo invocacion) {
		return invocacion.obtenerSacrificio(monstruos);
	}

	public void eliminarMonstruo(Carta cartaAtacante) {
		int posicion = monstruos.indexOf(cartaAtacante);
		monstruos.remove(posicion);
	}
	
	
}
