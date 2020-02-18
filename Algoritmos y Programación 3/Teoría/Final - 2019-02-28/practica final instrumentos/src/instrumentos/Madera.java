package instrumentos;


public class Madera implements Material {

    @Override
    public int aumentarSonido(Instrumento instrumento){

        return 1;
    }

    @Override
    public int aumentarSonido(Charango charango){

        return 2;

    }

    @Override
    public int aumentarSonido(GuitarraCriolla guitarraCriolla){

        return 1;

    }

    @Override
    public int aumentarSonido(Piano piano){

        return 3;

    }

    @Override
    public int aumentarSonido(Saxo saxo){

        return 1;

    }


}
