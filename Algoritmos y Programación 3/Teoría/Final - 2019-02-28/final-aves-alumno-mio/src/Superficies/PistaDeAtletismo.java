package Superficies;

import Errores.NoPuedoCorrerError;
import Errores.NoPuedoNadarAhiError;
import modelo.AbelPintos;
import modelo.Avestruz;
import modelo.Gorrion;
import modelo.Pingüino;

public class PistaDeAtletismo implements Superficie {

	@Override
	public int podesCorrerEnMi(AbelPintos serVivo) {
		// TODO Auto-generated method stub
		return 15;
	}

	@Override
	public int podesCorrerEnMi(Avestruz serVivo) {
		// TODO Auto-generated method stub
		return 70;
	}

	@Override
	public int podesCorrerEnMi(Gorrion serVivo) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public int podesCorrerEnMi(Pingüino serVivo) {
		throw new NoPuedoCorrerError();
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
