package musicos;

import instrumentos.Charango;

public class LucianoPereyra {

    public int tocar(instrumento i){
        try {
            Charango c = (Charango) i;

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
    }
}