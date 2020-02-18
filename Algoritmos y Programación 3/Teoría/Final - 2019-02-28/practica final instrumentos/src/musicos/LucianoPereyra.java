package musicos;

import instrumentos.Charango;
import instrumentos.Instrumento;

public class LucianoPereyra implements Musico {

    @Override
    public int tocar(Instrumento instrumento){

        return instrumento.serTocado(this);

    }

    /*public int tocar(Instrumento instrumento){
        try {
            Charango c = (Charango) instrumento;

            if (c.material == "Madera"){
                return c.decibeles * 2;
            }

            if (c.material == "Plastico"){
                return c.decibeles;
            }

        }catch(ClassCastException e2){
            System.out.println("No se tocar eso...");
        }

        return 0;
    }*/
}