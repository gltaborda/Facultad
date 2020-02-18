package instrumentos;

import musicos.*;

public class Charango extends Instrumento{

    private int decibeles = 10;

    public Charango(Material material){

        this.material = material;
    }

    public int serTocado(Musico musico){

        return 0 * this.material.aumentarSonido(this);

    }

    public int serTocado(FitoPaez fitoPaez){

        return 0 * this.material.aumentarSonido(this);

    }

    public int serTocado(LucianoPereyra lucianoPereyra){

        return this.decibeles * this.material.aumentarSonido(this);

    }

    public int serTocado(RicardoMollo ricardoMollo){

        return 0 * this.material.aumentarSonido(this);

    }

    public int serTocado(RobertoPetinatto robertoPetinatto){

        return 0 * this.material.aumentarSonido(this);

    }
}