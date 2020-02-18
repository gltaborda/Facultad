import junit.framework.TestCase;
import org.junit.Test;


import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class AbelPintosTest {

    @Test
    public void testCreoUnAbelPintos(){

        AbelPintos abelPintos = new AbelPintos();
        assertNotNull(abelPintos);

    }

    @Test
    public void testAbelPintosCanta(){

        AbelPintos abelPintos = new AbelPintos();
        assertEquals(abelPintos.cantar(),"vas a entrar sin pedirme la llave...");

    }

    @Test
    public void testAbelPintosCorreEnBarro(){

        AbelPintos abelPintos = new AbelPintos();
        Barro barro = new Barro();
        assertEquals(abelPintos.correr(barro),2);

    }

    @Test
    public void testAbelPintosCorreEnHielo(){

        AbelPintos abelPintos = new AbelPintos();
        Hielo hielo = new Hielo();
        assertEquals(abelPintos.correr(hielo),0);

    }

    @Test
    public void testAbelPintosCorreEnPistaDeAtletismo(){

        AbelPintos abelPintos = new AbelPintos();
        PistaDeAtletismo pistaDeAtletismo = new PistaDeAtletismo();
        assertEquals(abelPintos.correr(pistaDeAtletismo),15);

    }

}
