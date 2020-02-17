package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CiudadTest {

    private static final double DELTA = 1e-2;

    @Test
    public void ciudadCalculaDistanciaASiMismaYDaCero(){

        Ciudad unaCiudad = new Ciudad();
        unaCiudad.guardarDatos("Buenos Aires", "Argentina", -34.60, -58.38);
        double distancia = unaCiudad.calcularDistanciaHasta(unaCiudad);
        assertEquals(0, distancia, DELTA);

    }

}
