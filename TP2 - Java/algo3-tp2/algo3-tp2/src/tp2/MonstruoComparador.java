package tp2;
import java.util.Comparator;

public class MonstruoComparador implements Comparator<CartaMonstruo> {

	public int compare(CartaMonstruo unMonstruo, CartaMonstruo otroMonstruo) {
		return unMonstruo.compararCon(otroMonstruo);
	}

}
