package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ViajeTest {

    private static final double DELTA = 1e-2;

    @Test
    public void viajeConDosPaquetes (){

        AlgoTrip algoTrip = new AlgoTrip();
        algoTrip.agregarCiudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
        algoTrip.agregarCiudad("COR", "Cordoba", "Argentina", -31.42, -64.18);
        algoTrip.agregarCiudad("MOW", "Moscu", "Rusia", 55.75, 37.62);

        algoTrip.agregarHotel("Matreshka Hotel", "MOW", 3000);
        algoTrip.agregarHotel("Hotel Fernet Con Cola", "COR", 500);

        algoTrip.agregarPaquete("Vacaciones primera parte");
        algoTrip.agregarVueloEnPaquete("Vacaciones primera parte", "BUE", "COR", "2018-06-06");
        algoTrip.agregarVueloEnPaquete("Vacaciones primera parte", "COR", "BUE", "2018-06-14");
        algoTrip.agregarEstadiaEnPaquete("Vacaciones primera parte", "Hotel Fernet Con Cola", "2018-06-07", "2018-06-13");

        algoTrip.agregarPaquete("Vacaciones segunda parte");
        algoTrip.agregarVueloEnPaquete("Vacaciones segunda parte", "BUE", "MOW", "2018-06-15");
        algoTrip.agregarVueloEnPaquete("Vacaciones segunda parte", "MOW", "BUE", "2018-06-23");
        algoTrip.agregarEstadiaEnPaquete("Vacaciones segunda parte", "Matreshka Hotel", "2018-06-16", "2018-06-22");

        algoTrip.crearViaje("Vacaciones 2018");
        algoTrip.agregarPaqueteEnViaje("Vacaciones 2018", "Vacaciones primera parte");
        algoTrip.agregarPaqueteEnViaje("Vacaciones 2018", "Vacaciones segunda parte");

        double costoDeVueloDePrimerPaquete = 2 * (645.97 * 1);
        double costoDeEstadiaDePrimerPaquete = (500 * 6);
        double costoDePrimerPaquete = ((0.8 * costoDeEstadiaDePrimerPaquete) +(0.9 * costoDeVueloDePrimerPaquete));
        double costoDeVueloDeSegundoPaquete = 2 * (13475.12 * 1.5 * 1.05);
        double costoDeEstadiaDeSegundoPaquete = (3000 * 6);
        double costoDeSegundoPaquete = ((0.8 * costoDeEstadiaDeSegundoPaquete) + (0.9 * costoDeVueloDeSegundoPaquete));
        double costoEsperado = (costoDePrimerPaquete + costoDeSegundoPaquete);

        assertEquals(costoEsperado, algoTrip.obtenerCostoDelViaje("Vacaciones 2018"), DELTA);

    }

}
