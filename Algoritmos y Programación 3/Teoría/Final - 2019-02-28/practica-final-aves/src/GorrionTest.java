import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class GorrionTest {

    @Test
    public void testCreoUnGorrion(){

        Gorrion gorrion = new Gorrion();
        assertNotNull(gorrion);

    }

    @Test
    public void testGorrionCanta(){

        Gorrion gorrion = new Gorrion();
        assertEquals(gorrion.cantar(),"pio pio");

    }

    @Test
    public void testGorrionVuela(){

        Gorrion gorrion = new Gorrion();
        assertEquals(gorrion.volar(),50);

    }

}
