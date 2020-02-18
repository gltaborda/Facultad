package modelo;

import Superficies.Agua;
import Superficies.Barro;
import Superficies.Hielo;
import Superficies.PistaDeAtletismo;

public class Gorrion implements SerVivo{

	@Override
	public String cantar() {
		return "pio pio";
	}

	@Override
	public int volar() {
		return 50;
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
