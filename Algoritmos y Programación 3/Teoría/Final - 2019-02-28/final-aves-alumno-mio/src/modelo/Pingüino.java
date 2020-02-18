package modelo;

import Errores.NoVueloNiCantoNadaError;
import Superficies.Agua;
import Superficies.Barro;
import Superficies.Hielo;
import Superficies.PistaDeAtletismo;

public class Pingüino implements SerVivo {

	@Override
	public String cantar() {
		throw new NoVueloNiCantoNadaError();
	}

	@Override
	public int volar() {
		throw new NoVueloNiCantoNadaError();
	}

	@Override
	public int correr(Hielo superficie) {
		return superficie.podesCorrerEnMi(this);
	}

	@Override
	public int correr(Barro superficie) {
		return superficie.podesCorrerEnMi(this);
	}

	@Override
	public int correr(PistaDeAtletismo superficie) {
		return superficie.podesCorrerEnMi(this);
	}
	
	@Override
	public int nadar(Agua superficie) {
		return superficie.podesNadarEnMi(this);
	}

	@Override
	public int nadar(Hielo superficie) {
		// TODO Auto-generated method stub
		return superficie.podesNadarEnMi(this);
	}

	@Override
	public int nadar(Barro superficie) {
		// TODO Auto-generated method stub
		return superficie.podesNadarEnMi(this);
	}

	@Override
	public int nadar(PistaDeAtletismo superficie) {
		// TODO Auto-generated method stub
		return superficie.podesNadarEnMi(this);
	}

}
