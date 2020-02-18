import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class AvestruzTest {

    @Test
    public void testCreoUnAvestruz(){

        Avestruz avestruz = new Avestruz();
        assertNotNull(avestruz);

    }

    @Test
    public void testAvestruzCorreEnBarro(){

        Avestruz avestruz = new Avestruz();
        Barro barro = new Barro();
        assertEquals(avestruz.correr(barro),70);

    }

    @Test
    public void testAvestruzCorreEnHielo(){

        Avestruz avestruz = new Avestruz();
        Hielo hielo = new Hielo();
        assertEquals(avestruz.correr(hielo),0);

    }

    @Test
    public void testAvestruzCorreEnPistaDeAtletismo(){

        Avestruz avestruz = new Avestruz();
        PistaDeAtletismo pistaDeAtletismo = new PistaDeAtletismo();
        assertEquals(avestruz.correr(pistaDeAtletismo),70);

    }

}
