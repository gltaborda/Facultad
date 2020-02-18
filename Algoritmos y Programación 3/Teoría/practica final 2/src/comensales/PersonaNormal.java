package comensales;

import comidas.Comida;

public class PersonaNormal implements Persona {

    public boolean comer(Comida comida){

        return comida.mePodesComer(this);

    }

}
