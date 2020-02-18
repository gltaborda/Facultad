package comidas;

import comensales.Persona;
import comensales.PersonaCeliaca;
import comensales.PersonaHipertensa;
import comensales.PersonaNormal;

public class Empanada extends Comida{

    private int caloriasEnEmpanada = 15;

    @Override
    public  boolean mePodesComer (Persona persona){

        return persona.comer(this);

    }

    @Override
    public  boolean mePodesComer (PersonaNormal personaNormal){

        return true;

    }

    @Override
    public  boolean mePodesComer (PersonaCeliaca personaCeliaca){

        return false;

    }

    @Override
    public  boolean mePodesComer (PersonaHipertensa personaHipertensa){

        return false;

    }

}
