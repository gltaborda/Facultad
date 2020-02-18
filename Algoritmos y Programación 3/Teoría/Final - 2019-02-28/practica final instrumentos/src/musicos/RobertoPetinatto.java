package musicos;

import instrumentos.Instrumento;

public class RobertoPetinatto implements Musico {

    @Override
    public int tocar(Instrumento instrumento){

        return instrumento.serTocado(this);

    }
}
