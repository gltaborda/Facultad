package musicos;

import instrumentos.Instrumento;
import instrumentos.Piano;

public class FitoPaez implements Musico {

    @Override
    public int tocar(Instrumento instrumento){

        return instrumento.serTocado(this);

    }

   /*public int tocar(Instrumento instrumento){
        try {
            Piano p = (Piano) instrumento;

            if (p.material == "Madera"){
                return p.decibeles  * 3;
            }

            if (p.material == "Plastico"){
                return p.decibeles  - 5;
            }

        }catch(ClassCastException e2){
            System.out.println("No se tocar eso...");
        }

        return 0;
    }*/
}