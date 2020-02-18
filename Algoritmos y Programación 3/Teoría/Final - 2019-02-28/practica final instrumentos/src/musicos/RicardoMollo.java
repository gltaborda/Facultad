package musicos;

import instrumentos.GuitarraCriolla;
import instrumentos.Instrumento;

public class RicardoMollo implements Musico {

    @Override
    public int tocar(Instrumento instrumento){

        return instrumento.serTocado(this);

    }

    /*public int tocar(Instrumento instrumento){
        try {
            GuitarraCriolla g = (GuitarraCriolla) instrumento;

            if (g.material == "Madera"){
                return g.decibeles;
            }

            if (g.material == "Plastico"){
                return g.decibeles  - 3;
            }

        }catch(ClassCastException e2){
            System.out.println("No se tocar eso...");
        }

        return 0;
    }*/
}