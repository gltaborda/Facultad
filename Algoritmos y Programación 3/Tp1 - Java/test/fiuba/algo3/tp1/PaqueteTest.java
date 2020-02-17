package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;




import org.junit.Test;

public class PaqueteTest {

    private static final double DELTA = 1e-2;

    @Test
    public void paqueteVacioTieneCostoCero (){

        Paquete unPaquete = new Paquete();

        assertEquals(0, unPaquete.obtenerCosto(), DELTA);


    }


}
