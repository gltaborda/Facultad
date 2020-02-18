import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class PinguinoTest {

    @Test
    public void testCreoUnPinguino(){

        Pinguino pinguino = new Pinguino();
        assertNotNull(pinguino);

    }

    @Test
    public void testPinguinoNada(){

        Pinguino pinguino = new Pinguino();
        assertEquals(pinguino.nadar(),20);

    }

    @Test
    public void testPinguinoCorreEnHielo(){

        Pinguino pinguino = new Pinguino();
        Hielo hielo = new Hielo();
        assertEquals(pinguino.correr(hielo),5);

    }

    @Test
    public void testPinguinoCorreEnBarro(){

        Pinguino pinguino = new Pinguino();
        Barro barro = new Barro();
        assertEquals(pinguino.correr(barro),0);

    }

    @Test
    public void testPinguinoCorreEnPistaDeAtletismo(){

        Pinguino pinguino = new Pinguino();
        PistaDeAtletismo pistaDeAtletismo = new PistaDeAtletismo();
        assertEquals(pinguino.correr(pistaDeAtletismo),0);

    }

}
