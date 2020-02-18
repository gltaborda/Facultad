package Superficies;

import Errores.NoPuedoCorrerEnEsaSuperficieError;
import Errores.NoPuedoNadarError;
import modelo.AbelPintos;
import modelo.Avestruz;
import modelo.Gorrion;
import modelo.Pingüino;

public class Agua implements Superficie {

	@Override
	public int podesCorrerEnMi(AbelPintos serVivo) {
		throw new NoPuedoCorrerEnEsaSuperficieError();
	}

	@Override
	public int podesCorrerEnMi(Avestruz serVivo) {
		throw new NoPuedoCorrerEnEsaSuperficieError();
	}

	@Override
	public int podesCorrerEnMi(Gorrion serVivo) {
		throw new NoPuedoCorrerEnEsaSuperficieError();
	}

	@Override
	public int podesCorrerEnMi(Pingüino serVivo) {
		// TODO Auto-generated method stub
		throw new NoPuedoCorrerEnEsaSuperficieError();
	}

	@Override
	public int podesNadarEnMi(Pingüino serVivo) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int podesNadarEnMi(AbelPintos serVivo) {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int podesNadarEnMi(Avestruz serVivo) {
		// TODO Auto-generated method stub
		throw new NoPuedoNadarError();
	}

	@Override
	public int podesNadarEnMi(Gorrion serVivo) {
		// TODO Auto-generated method stub
		throw new NoPuedoNadarError();
	}

}
