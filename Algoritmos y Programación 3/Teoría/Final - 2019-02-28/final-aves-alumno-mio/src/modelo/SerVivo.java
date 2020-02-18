package modelo;

import Superficies.Agua;
import Superficies.Barro;
import Superficies.Hielo;
import Superficies.PistaDeAtletismo;

public interface SerVivo {

	public String cantar();
	public int volar();
	public int correr(Hielo superficie);
	public int correr(Barro superficie);
	public int correr(PistaDeAtletismo superficie);
	public int nadar(Agua superficie);
	public int nadar(Hielo superficie);
	public int nadar(Barro superficie);
	public int nadar(PistaDeAtletismo superficie);
}
