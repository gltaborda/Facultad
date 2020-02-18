package Superficies;

import Errores.NoPuedoCorrerError;
import Errores.NoPuedoNadarAhiError;
import modelo.AbelPintos;
import modelo.Avestruz;
import modelo.Gorrion;
import modelo.Pingüino;

public class Hielo implements Superficie {

	@Override
	public int podesCorrerEnMi(AbelPintos serVivo) {
		return 0;
	}

	@Override
	public int podesCorrerEnMi(Avestruz serVivo) {
		return 0;
	}

	@Override
	public int podesCorrerEnMi(Gorrion serVivo) {
		throw new NoPuedoCorrerError();
	}

	@Override
	public int podesCorrerEnMi(Pingüino serVivo) {
		return 5;
	}

	@Override
	public int podesNadarEnMi(Pingüino serVivo) {
		throw new NoPuedoNadarAhiError();
	}

	@Override
	public int podesNadarEnMi(AbelPintos serVivo) {
		// TODO Auto-generated method stub
		throw new NoPuedoNadarAhiError();
	}

	@Override
	public int podesNadarEnMi(Avestruz serVivo) {
		// TODO Auto-generated method stub
		throw new NoPuedoNadarAhiError();
	}

	@Override
	public int podesNadarEnMi(Gorrion serVivo) {
		// TODO Auto-generated method stub
		throw new NoPuedoNadarAhiError();
	}

}
