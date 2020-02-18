package Superficies;

import modelo.AbelPintos;
import modelo.Avestruz;
import modelo.Gorrion;
import modelo.Pingüino;

public interface Superficie {

	public int podesCorrerEnMi(AbelPintos serVivo);
	public int podesCorrerEnMi(Avestruz serVivo);
	public int podesCorrerEnMi(Gorrion serVivo);
	public int podesCorrerEnMi(Pingüino serVivo);
	public int podesNadarEnMi(Pingüino serVivo);
	public int podesNadarEnMi(AbelPintos serVivo);
	public int podesNadarEnMi(Avestruz serVivo);
	public int podesNadarEnMi(Gorrion serVivo);
	
}