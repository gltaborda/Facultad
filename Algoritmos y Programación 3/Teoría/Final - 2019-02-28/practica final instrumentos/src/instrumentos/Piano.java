package instrumentos;

import musicos.FitoPaez;
import musicos.LucianoPereyra;
import musicos.RicardoMollo;
import musicos.RobertoPetinatto;

public class Piano extends Instrumento{



    private int decibeles = 50;

    public Piano(Material material){

        this.material = material;
    }

    public int serTocado(FitoPaez fitoPaez){

        return this.decibeles * this.material.aumentarSonido(this);

    }

    public int serTocado(LucianoPereyra lucianoPereyra){

        return 0 * this.material.aumentarSonido(this);

    }

    public int serTocado(RicardoMollo ricardoMollo){

        return 0 * this.material.aumentarSonido(this);

    }

    public int serTocado(RobertoPetinatto robertoPetinatto){

        return 0 * this.material.aumentarSonido(this);

    }

}