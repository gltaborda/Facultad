package comensales;

import Comidas.Comida;
import Comidas.Empanada;
import Comidas.EmpanadaSinGluten;
import Comidas.EmpanadaSinSal;
import Comidas.Pan;
import Comidas.PanSinGluten;
import Comidas.PanSinSal;

public abstract class Persona {
	
	public int calorias;

	public abstract void comer(Comida algo);
	public abstract void comer(Empanada algo);
	public abstract void comer(EmpanadaSinGluten algo);
	public abstract void comer(EmpanadaSinSal algo);
	public abstract void comer(Pan algo);
	public abstract void comer(PanSinGluten algo);
	public abstract void comer(PanSinSal algo);
}
