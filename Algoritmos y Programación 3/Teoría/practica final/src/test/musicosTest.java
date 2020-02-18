package test;
import instrumentos.*;
import musicos.LucianoPereyra;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class musicosTest {

    @Test
    public void testLucianoPereyraTocaCharango(){

        LucianoPereyra lucianoPereyra = new LucianoPereyra();
        assertEquals(lucianoPereyra.tocar(new Charango()),20);

    }

    @Test
    public void testLucianoPereyraNoTocaOtroInstrumento(){

        LucianoPereyra lucianoPereyra = new LucianoPereyra();
        assertEquals(lucianoPereyra.tocar(new GuitarraCriolla()),0);
        assertEquals(lucianoPereyra.tocar(new Piano()),0);
    }
}
