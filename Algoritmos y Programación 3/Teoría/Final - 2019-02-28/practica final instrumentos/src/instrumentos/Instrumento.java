package instrumentos;

import musicos.*;

public abstract class Instrumento {

    public Material material;
    public int decibeles;

    public int serTocado(Musico musico){
        //si no me saben tocar produzco 0 decibeles
        return 0;

    }

    public int serTocado(FitoPaez fitoPaez){
        //si no me saben tocar produzco 0 decibeles
        return 0;

    }

    public int serTocado(LucianoPereyra lucianoPereyra){
        //si no me saben tocar produzco 0 decibeles
        return 0;

    }

    public int serTocado(RicardoMollo ricardoMollo){
        //si no me saben tocar produzco 0 decibeles
        return 0;

    }

    public int serTocado(RobertoPetinatto robertoPetinatto){
        //si no me saben tocar produzco 0 decibeles
        return 0;

    }

}
