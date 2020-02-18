package modelo;

import Errores.NoVueloNiCantoNadaError;
import Superficies.Agua;
import Superficies.Barro;
import Superficies.Hielo;
import Superficies.PistaDeAtletismo;

public class Avestruz implements SerVivo{

	@Override
	public String cantar() {
		throw new NoVueloNiCantoNadaError();
	}

	@Override
	public int volar() {
		return 0;
	}
	
	public int correr(Hielo superficie) {
		return superficie.podesCorrerEnMi(this);
	}

	public int correr(Barro superficie) {
		return superficie.podesCorrerEnMi(this);
	}

	public int correr(PistaDeAtletismo superficie) {
		return superficie.podesCorrerEnMi(this);
	}
	
	@Override
	public int nadar(Agua superficie) {
		return superficie.podesNadarEnMi(this);
	}

	@Override
	public int nadar(Hielo superficie) {
		return superficie.podesNadarEnMi(this);
	}

	@Override
	public int nadar(Barro superficie) {
		return superficie.podesNadarEnMi(this);
	}

	@Override
	public int nadar(PistaDeAtletismo superficie) {
		return superficie.podesNadarEnMi(this);
	}
}
