package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HotelTest {

    private static final double DELTA = 1e-2;

    @Test
    public void testCostoSeModificaAlAgregarAsistenciaAlViajero(){

        Hotel unHotel = new Hotel(1500, "2018-06-13", "2018-06-20");
        assertEquals(10500, unHotel.calcularCosto(),DELTA);

        unHotel.agregarAsistenciaAlViajero();
        assertEquals(10710, unHotel.calcularCosto(),DELTA);

    }

}
