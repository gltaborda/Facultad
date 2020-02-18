package instrumentos;

import musicos.*;

public class GuitarraCriolla extends Instrumento{

    private int decibeles = 20;

    public GuitarraCriolla(Material material){

        this.material = material;
    }

    public int serTocado(Musico musico){

        return 0 * this.material.aumentarSonido(this);

    }

    public int serTocado(FitoPaez fitoPaez){

        return 0 * this.material.aumentarSonido(this);

    }

    public int serTocado(LucianoPereyra lucianoPereyra){

        return 0 * this.material.aumentarSonido(this);

    }

    public int serTocado(RicardoMollo ricardoMollo){

        return this.decibeles * this.material.aumentarSonido(this);

    }

    public int serTocado(RobertoPetinatto robertoPetinatto){

        return 0;

    }
}