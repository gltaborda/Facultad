package comensales;

import comidas.Comida;

public class PersonaHipertensa implements Persona {

    public boolean comer(Comida comida){

        return comida.mePodesComer(this);

    }
}
