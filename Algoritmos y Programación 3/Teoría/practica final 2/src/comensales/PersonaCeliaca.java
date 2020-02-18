package comensales;

import comidas.Comida;

public class PersonaCeliaca implements Persona {

    public boolean comer(Comida comida){

        return comida.mePodesComer(this);

    }
}
