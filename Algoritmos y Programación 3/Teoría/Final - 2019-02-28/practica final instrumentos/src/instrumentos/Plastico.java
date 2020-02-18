package instrumentos;

public class Plastico implements Material{

    @Override
    public int aumentarSonido(Instrumento instrumento){

        return 1;
    }

    @Override
    public int aumentarSonido(Charango charango){

        return 1;

    }

    @Override
    public int aumentarSonido(GuitarraCriolla guitarraCriolla){

        return 1;

    }

    @Override
    public int aumentarSonido(Piano piano){

        return 1;

    }

    @Override
    public int aumentarSonido(Saxo saxo){

        return 1;

    }
}
