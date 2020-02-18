package test;

import static org.junit.Assert.*;


import instrumentos.*;
import musicos.RobertoPetinatto;
import org.junit.Test;

import musicos.FitoPaez;
import musicos.LucianoPereyra;
import musicos.RicardoMollo;

public class InstrumentosTest {

    @Test
    public void testCreoFitoPaez(){

        FitoPaez fitoPaez = new FitoPaez();
        assertNotNull(fitoPaez);

    }

    @Test
    public void testCreoLucianoPereyra(){

        LucianoPereyra lucianoPereyra = new LucianoPereyra();
        assertNotNull(lucianoPereyra);

    }

    @Test
    public void testCreoRicardoMollo(){

        RicardoMollo ricardoMollo = new RicardoMollo();
        assertNotNull(ricardoMollo);

    }

    @Test
    public void testCreoRobertoPetinatto(){

        RobertoPetinatto robertoPetinatto = new RobertoPetinatto();
        assertNotNull(robertoPetinatto);

    }

    @Test
    public void testFitoPaezTocaElPiano(){

        FitoPaez fitoPaez = new FitoPaez();
        Madera madera = new Madera();
        Piano piano = new Piano(madera);
        assertEquals(fitoPaez.tocar(piano),150);

    }

    @Test
    public void testFitoPaezTocaLosInstrumentosQueNoSabe(){

        FitoPaez fitoPaez = new FitoPaez();
        Madera madera = new Madera();
        Charango charango = new Charango(madera);
        GuitarraCriolla guitarraCriolla = new GuitarraCriolla(madera);
        Saxo saxo = new Saxo(madera);

        assertEquals(fitoPaez.tocar(charango),0);
        assertEquals(fitoPaez.tocar(guitarraCriolla),0);
        assertEquals(fitoPaez.tocar(saxo),0);
    }

    @Test
    public void testLucianoPereyraTocaElCharango(){

        LucianoPereyra lucianoPereyra = new LucianoPereyra();
        Madera madera = new Madera();
        Charango charango = new Charango(madera);
        assertEquals(lucianoPereyra.tocar(charango),20);

    }

    @Test
    public void testLucianoPereyraTocaLosInstrumentosQueNoSabe(){

        LucianoPereyra lucianoPereyra = new LucianoPereyra();
        Madera madera = new Madera();
        GuitarraCriolla guitarraCriolla = new GuitarraCriolla(madera);
        Piano piano = new Piano(madera);
        Saxo saxo = new Saxo(madera);

        assertEquals(lucianoPereyra.tocar(guitarraCriolla),0);
        assertEquals(lucianoPereyra.tocar(piano),0);
        assertEquals(lucianoPereyra.tocar(saxo),0);
    }

    @Test
    public void testRicardoMolloTocaLaGuitarraCriolla(){

        RicardoMollo ricardoMollo = new RicardoMollo();
        Madera madera = new Madera();
        GuitarraCriolla guitarraCriolla = new GuitarraCriolla(madera);
        assertEquals(ricardoMollo.tocar(guitarraCriolla),20);

    }

    @Test
    public void testRicardoMolloTocaLosInstrumentosQueNoSabe(){

        RicardoMollo ricardoMollo = new RicardoMollo();
        Madera madera = new Madera();
        Charango charango = new Charango(madera);
        Piano piano = new Piano(madera);
        Saxo saxo = new Saxo(madera);

        assertEquals(ricardoMollo.tocar(charango),0);
        assertEquals(ricardoMollo.tocar(piano),0);
        assertEquals(ricardoMollo.tocar(saxo),0);
    }

    @Test
    public void testRobertoPetinattoTocaElSaxo(){

        RobertoPetinatto robertoPetinatto = new RobertoPetinatto();
        Metal metal = new Metal();
        Saxo saxo = new Saxo(metal);
        assertEquals(robertoPetinatto.tocar(saxo),90);

    }

    @Test
    public void testRobertoPetinattoTocaLosInstrumentosQueNoSabe(){

        RobertoPetinatto robertoPetinatto = new RobertoPetinatto();
        Madera madera = new Madera();
        Charango charango = new Charango(madera);
        GuitarraCriolla guitarraCriolla = new GuitarraCriolla(madera);
        Piano piano = new Piano(madera);

        assertEquals(robertoPetinatto.tocar(charango),0);
        assertEquals(robertoPetinatto.tocar(guitarraCriolla),0);
        assertEquals(robertoPetinatto.tocar(piano),0);

    }

    /*@Test
    public void testInstrumentosDePlastico(){

        FitoPaez fitoPaez = new FitoPaez();
        LucianoPereyra lucianoPereyra = new LucianoPereyra();


    }*/


    /*@Test
    public void test_BIEN_BIEN_COMPLETO(){

        LucianoPereyra lucianoPereyra = new LucianoPereyra();
        FitoPaez fitoPaez = new FitoPaez();
        RicardoMollo ricardoMollo = new RicardoMollo();

        assertEquals(lucianoPereyra.tocar(new Charango()), 20);
        assertEquals(lucianoPereyra.tocar(new GuitarraCriolla()), 0);
        assertEquals(lucianoPereyra.tocar(new Piano()), 0);

        assertEquals(fitoPaez.tocar(new Charango()), 0);
        assertEquals(fitoPaez.tocar(new GuitarraCriolla()), 0);
        assertEquals(fitoPaez.tocar(new Piano()), 150);

        assertEquals(ricardoMollo.tocar(new Charango()), 0);
        assertEquals(ricardoMollo.tocar(new GuitarraCriolla()), 20);
        assertEquals(ricardoMollo.tocar(new Piano()), 0);


        Charango charangoDePlastico = new Charango();
        charangoDePlastico.material = "Plastico";

        GuitarraCriolla guitarraDePlastico = new GuitarraCriolla();
        guitarraDePlastico.material = "Plastico";

        Piano pianoDePlastico = new Piano();
        pianoDePlastico.material = "Plastico";

        assertEquals(lucianoPereyra.tocar(charangoDePlastico), 10);
        assertEquals(lucianoPereyra.tocar(guitarraDePlastico), 0);
        assertEquals(lucianoPereyra.tocar(pianoDePlastico), 0);

        assertEquals(fitoPaez.tocar(charangoDePlastico), 0);
        assertEquals(fitoPaez.tocar(guitarraDePlastico), 0);
        assertEquals(fitoPaez.tocar(pianoDePlastico), 45);

        assertEquals(ricardoMollo.tocar(charangoDePlastico), 0);
        assertEquals(ricardoMollo.tocar(guitarraDePlastico), 17);
        assertEquals(ricardoMollo.tocar(pianoDePlastico), 0);

    }*/

}