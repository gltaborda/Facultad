package comidas;

import comensales.Persona;
import comensales.PersonaCeliaca;
import comensales.PersonaHipertensa;
import comensales.PersonaNormal;

public abstract class Comida {

    int calorias;

    public abstract boolean mePodesComer (Persona persona);
    public abstract boolean mePodesComer (PersonaNormal personaNormal);
    public abstract boolean mePodesComer (PersonaCeliaca personaCeliaca);
    public abstract boolean mePodesComer (PersonaHipertensa personaHipertensa);

}
