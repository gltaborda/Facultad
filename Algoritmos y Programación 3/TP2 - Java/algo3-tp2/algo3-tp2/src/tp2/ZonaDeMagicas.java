package tp2;

import java.util.ArrayList;
import java.util.List;

import tp2.excepciones.LaCartaNoEstaEnElCampoException;
import tp2.interfaces.CartaMagica;

public class ZonaDeMagicas {

	private List<CartaMagica> magicas = new ArrayList<CartaMagica>();
	
	public boolean contieneA(CartaMagica cartaMagica) {
		return magicas.contains(cartaMagica);
	}

	public void colocar(CartaMagica cartaMagica) {
		magicas.add(cartaMagica);
	}

	public CartaMagica obtenerCarta(CartaMagica cartaMagica) {
		if (! magicas.contains(cartaMagica)) throw new LaCartaNoEstaEnElCampoException();
        int indice = magicas.indexOf(cartaMagica);
        return magicas.remove(indice);
	}

	public CartaMagica voltearCarta(CartaMagica cartaMagica) {
		if (! magicas.contains(cartaMagica)) throw new LaCartaNoEstaEnElCampoException();
		int indice = magicas.indexOf(cartaMagica);
		return magicas.get(indice);
	}

}
