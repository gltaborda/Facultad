import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TransporteTest {

    @Test
    public void testCreoUnAuto(){

        Auto auto = new Auto();
        assertNotNull(auto);

    }

    @Test
    public void testCreoUnaMoto(){

        Moto moto = new Moto();
        assertNotNull(moto);

    }

    @Test
    public void testCreoUnCamion(){

        Camion camion = new Camion();
        assertNotNull(camion);

    }

    @Test
    public void testAutoPagaPeaje(){

        Auto auto = new Auto();
        CabinaDePeaje cabinaDePeaje = new CabinaDePeaje();

        assertEquals(cabinaDePeaje.cobrarPeaje(auto),8,1e-5);

    }

    @Test
    public void testCamionPagaPeaje(){

        Camion camion = new Camion();
        CabinaDePeaje cabinaDePeaje = new CabinaDePeaje();

        assertEquals(cabinaDePeaje.cobrarPeaje(camion),36,1e-5);

    }

    @Test
    public void testMotoPagaPeaje(){

        Moto moto = new Moto();
        CabinaDePeaje cabinaDePeaje = new CabinaDePeaje();

        assertEquals(cabinaDePeaje.cobrarPeaje(moto),4,1e-5);

    }

    @Test
    public void testAutoConTelepasePagaLaMitad(){

        Auto auto = new Auto();
        auto.activarTelepase();
        CabinaDePeaje cabinaDePeaje = new CabinaDePeaje();

        assertEquals(cabinaDePeaje.cobrarPeaje(auto),4,1e-5);

    }

    @Test
    public void testMotoPagaConTelepasePagaIgual(){

        Moto moto = new Moto();
        CabinaDePeaje cabinaDePeaje = new CabinaDePeaje();
        double montoSinTelepase = cabinaDePeaje.cobrarPeaje(moto);

        //assertEquals(cabinaDePeaje.cobrarPeaje(moto),4,1e-5);

        moto.activarTelepase();

        double montoConTelepase = cabinaDePeaje.cobrarPeaje(moto);

        //assertEquals(cabinaDePeaje.cobrarPeaje(moto),4,1e-5);

        assertEquals(montoConTelepase,montoSinTelepase,1e-5);

    }

}
