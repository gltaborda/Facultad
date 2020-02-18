package tp2;

import java.util.ArrayList;
import java.util.List;

public class Exodia {
	
	private List<CartaMonstruo> partes = new ArrayList<CartaMonstruo>();

	public boolean estaCompleto() {
		return partes.size() == 5;
	}

	public void agregarParte(ParteDeExodia parte) {
		partes.add(parte);
	}

}
