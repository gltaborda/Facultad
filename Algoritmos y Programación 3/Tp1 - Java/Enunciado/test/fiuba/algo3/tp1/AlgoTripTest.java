package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AlgoTripTest {
	
	private static final double DELTA = 1e-3;

	@Test
	public void test01ViajeVacio() {
		AlgoTrip algoTrip = new AlgoTrip();
		algoTrip.crearViaje("vacaciones-2018");
        
		assertEquals(0, algoTrip.obtenerCostoDelViaje("vacaciones-2018"));
		assertEquals(0, algoTrip.obtenerDuracionEnDiasDelViaje("vacaciones-2018"));
	}

	@Test
	public void test02ViajeConVueloDomestico() {
		AlgoTrip algoTrip = new AlgoTrip();
		algoTrip.agregarCiudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		algoTrip.agregarCiudad("COR", "Cordoba", "Argentina", -31.42, -64.18);
		algoTrip.crearViaje("vacaciones-2018");
		algoTrip.agregarVueloEnViaje("vacaciones-2018", "BUE", "COR", "2018-06-01");
		
		// Costo: 1 peso por km para vuelos domesticos. La distancia se calcula con la formula del haversine.
		double costoEsperado = 645.97 * 1;
        assertEquals(costoEsperado, algoTrip.obtenerCostoDelViaje("vacaciones-2018"), DELTA);
        
        // Duracion del viaje es un dia (el 1 de Junio que estamos volando).
		assertEquals(1, algoTrip.obtenerDuracionEnDiasDelViaje("vacaciones-2018"));
	}

	@Test
	public void test02BisCorreccionCoordenadasCiudadCorrigeCostoVuelo() {
		AlgoTrip algoTrip = new AlgoTrip();
		algoTrip.agregarCiudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		algoTrip.agregarCiudad("COR", "Cordoba", "Argentina", -22.90, -43.19);
		algoTrip.crearViaje("vacaciones-2018");
		algoTrip.agregarVueloEnViaje("vacaciones-2018", "BUE", "COR", "2018-06-01");
		
		// Costo: 1 peso por km para vuelos domesticos. La distancia se calcula con la formula del haversine.
		double costoEsperado = 1966.7 * 1;
        assertEquals(costoEsperado, algoTrip.obtenerCostoDelViaje("vacaciones-2018"), DELTA);
        
        // Corregimos las coordenadas de la ciudad (estaban mal) agregandola nuevamente con el mismo codigo
		algoTrip.agregarCiudad("COR", "Cordoba", "Argentina", -31.42, -64.18);
		
		// El costo del viaje se actualiza
		costoEsperado = 645.97 * 1;
        assertEquals(costoEsperado, algoTrip.obtenerCostoDelViaje("vacaciones-2018"), DELTA);		
	}

	@Test
	public void test03ViajeConVueloInternacional() {
		AlgoTrip algoTrip = new AlgoTrip();
		algoTrip.agregarCiudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		algoTrip.agregarCiudad("RIO", "Rio", "Brasil", -22.90, -43.19);
		algoTrip.crearViaje("vacaciones-2018");
		algoTrip.agregarVueloEnViaje("vacaciones-2018", "BUE", "RIO", "2018-06-01");
		
		// costo: 1.5 peso por km para vuelos internacionales, mas 5% de impuestos
        double costoEsperado = 1966.7 * 1.5 * 1.05;
		assertEquals(costoEsperado, algoTrip.obtenerCostoDelViaje("vacaciones-2018"), DELTA);
		assertEquals(1, algoTrip.obtenerDuracionEnDiasDelViaje("vacaciones-2018"));
	}

	@Test
	public void test04ViajeConDosVuelos() {
		AlgoTrip algoTrip = new AlgoTrip();
		algoTrip.agregarCiudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		algoTrip.agregarCiudad("COR", "Cordoba", "Argentina", -31.42, -64.18);
		algoTrip.agregarCiudad("RIO", "Rio", "Brasil", -22.90, -43.19);
		algoTrip.crearViaje("vacaciones-2018");
		algoTrip.agregarVueloEnViaje("vacaciones-2018", "BUE", "RIO", "2018-06-01");
		algoTrip.agregarVueloEnViaje("vacaciones-2018", "BUE", "COR", "2018-06-05");
		
		// Se suma el costo de de cada vuelo.
        double costoEsperado = (1966.7 * 1.5 * 1.05) + (645.97 * 1);
		assertEquals(costoEsperado, algoTrip.obtenerCostoDelViaje("vacaciones-2018"), DELTA);
        
		// El viaje dura 5 dias, incluyendo tanto el dia del primer vuelo como el del ultimo.
		assertEquals(5, algoTrip.obtenerDuracionEnDiasDelViaje("vacaciones-2018"));
	}

	@Test
	public void test05ViajeConHotel() {
		AlgoTrip algoTrip = new AlgoTrip();
		algoTrip.agregarCiudad("RIO", "Rio", "Brasil", -22.90, -43.19);
		algoTrip.agregarHotel("Copacabana Palace", "RIO", 3000);
		algoTrip.crearViaje("vacaciones-2018");
		algoTrip.agregarEstadiaEnViaje("vacaciones-2018", "Copacabana Palace", "2018-06-01", "2018-06-07");
		
		// 6 noches a 3000 pesos por noche
        double costoEsperado = 6 * 3000;
		assertEquals(costoEsperado, algoTrip.obtenerCostoDelViaje("vacaciones-2018"), DELTA);
        
		// La estadia es de 6 noches pero el viaje es de 7 dias.
		assertEquals(7, algoTrip.obtenerDuracionEnDiasDelViaje("vacaciones-2018"));
	}

	@Test
	public void test06ViajeConTresVuelosYDosHoteles() {
		AlgoTrip algoTrip = new AlgoTrip();
		algoTrip.agregarCiudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		algoTrip.agregarCiudad("COR", "Cordoba", "Argentina", -31.42, -64.18);
		algoTrip.agregarCiudad("RIO", "Rio", "Brasil", -22.90, -43.19);
		algoTrip.agregarHotel("Copacabana Palace", "RIO", 3000);
		algoTrip.agregarHotel("Gran Cordoba", "COR", 1200);
		
		algoTrip.crearViaje("vacaciones-2018");
		algoTrip.agregarVueloEnViaje("vacaciones-2018", "BUE", "RIO", "2018-06-01");
		algoTrip.agregarVueloEnViaje("vacaciones-2018", "BUE", "COR", "2018-06-05");
		algoTrip.agregarVueloEnViaje("vacaciones-2018", "BUE", "COR", "2018-06-06");
		algoTrip.agregarEstadiaEnViaje("vacaciones-2018", "Copacabana Palace", "2018-06-03", "2018-06-08");
		algoTrip.agregarEstadiaEnViaje("vacaciones-2018", "Gran Cordoba", "2018-06-02", "2018-06-03");

        double costoEsperado = (1966.7 * 1.5 * 1.05) + (645.97 * 2) + (5 * 3000) + (1 * 1200);
		assertEquals(costoEsperado, algoTrip.obtenerCostoDelViaje("vacaciones-2018"), DELTA);

        // El viaje dura 8 dias (del 1 al 8 de Junio inclusive)
		assertEquals(8, algoTrip.obtenerDuracionEnDiasDelViaje("vacaciones-2018"));		
	}

	@Test
	public void test07ViajesConAsistenciaAlViajero() {
		AlgoTrip algoTrip = new AlgoTrip();
		algoTrip.agregarCiudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		algoTrip.agregarCiudad("COR", "Cordoba", "Argentina", -31.42, -64.18);
		algoTrip.agregarHotel("Hotel Fernet Con Cola", "COR", 500);

		algoTrip.crearViaje("vacaciones-2018");
		algoTrip.agregarVueloEnViaje("vacaciones-2018", "BUE", "COR", "2018-06-01");
		algoTrip.agregarAsistenciaAlViajeroAlViaje("vacaciones-2018");

		algoTrip.crearViaje("vacaciones-2019");
		algoTrip.agregarEstadiaEnViaje("vacaciones-2019", "Hotel Fernet Con Cola", "2018-06-01", "2018-06-07");
		algoTrip.agregarAsistenciaAlViajeroAlViaje("vacaciones-2019");

		algoTrip.crearViaje("Fiesta del Fernet");
		algoTrip.agregarVueloEnViaje("Fiesta del Fernet", "BUE", "COR", "2018-08-01");
		algoTrip.agregarVueloEnViaje("Fiesta del Fernet", "COR", "BUE", "2018-08-07");
		algoTrip.agregarEstadiaEnViaje("Fiesta del Fernet", "Hotel Fernet Con Cola", "2018-08-01", "2018-08-07");
		algoTrip.agregarAsistenciaAlViajeroAlViaje("Fiesta del Fernet");

		// Asistencia al viajero para vuelos: 10% del valor (ya sean internacionales o domesticos).
        double costoEsperado = (645.97 * 1 * 1.1);
		assertEquals(costoEsperado, algoTrip.obtenerCostoDelViaje("vacaciones-2018"), DELTA);

		// Asistencia al viajero para hoteles: 30 pesos por dia de estadia.
        costoEsperado = (6 * 500) + (6 * 30);
		assertEquals(costoEsperado, algoTrip.obtenerCostoDelViaje("vacaciones-2019"), DELTA);

		// Viaje de ida y vuelta con hotel y asistencia al viajero.
        costoEsperado = (2 * 645.97 * 1 * 1.1) + (6 * 500) + (6 * 30);
		assertEquals(costoEsperado, algoTrip.obtenerCostoDelViaje("Fiesta del Fernet"), DELTA);		
	}

	@Test
	public void test08ViajeDeIdaConComidaEspecialAbordo() {
		AlgoTrip algoTrip = new AlgoTrip();
		algoTrip.agregarCiudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		algoTrip.agregarCiudad("COR", "Cordoba", "Argentina", -31.42, -64.18);

		algoTrip.crearViaje("vacaciones-2018");
		algoTrip.agregarVueloEnViaje("vacaciones-2018", "BUE", "COR", "2018-06-01");
		
		algoTrip.solicitarComidaEspecialAbordoPara("vacaciones-2018");
		
		// comida a bordo suma 100 pesos por vuelo
		double costoEsperado = 645.97 + 100;
		assertEquals(costoEsperado, algoTrip.obtenerCostoDelViaje("vacaciones-2018"), DELTA);		
	}	
	
	@Test
	public void test09PaqueteConVuelosYHotelMasHotelAparte() {
		AlgoTrip algoTrip = new AlgoTrip();
		algoTrip.agregarCiudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		algoTrip.agregarCiudad("MOW", "Moscu", "Rusia", 55.75, 37.62);
		algoTrip.agregarHotel("Matreshka Hotel", "MOW", 3000);
		algoTrip.agregarHotel("NH Ezeiza", "BUE", 1200);

		algoTrip.agregarPaquete("Rusia 18");
		algoTrip.agregarVueloEnPaquete("Rusia 18", "BUE", "MOW", "2018-06-13");
		algoTrip.agregarVueloEnPaquete("Rusia 18", "MOW", "BUE", "2018-07-16");
		algoTrip.agregarEstadiaEnPaquete("Rusia 18", "Matreshka Hotel", "2018-06-14", "2018-07-16");

		algoTrip.crearViaje("vacaciones-2018");
		algoTrip.agregarPaqueteEnViaje("vacaciones-2018", "Rusia 18");
		
		// hotel aparte para la primera noche en buenos aires
		algoTrip.agregarEstadiaEnViaje("vacaciones-2018", "NH Ezeiza", "2018-06-12", "2018-06-13");
		
		// El paquete descuenta 10% del costo de vuelos y 20% del costo de hotel.
		double costoVuelos = 2 * (13475.12 * 1.5 * 1.05);
		double costoHotel = (32 * 3000);
		double costoHotelAparte = 1200;
		double costoEsperado = (0.9 * costoVuelos) + (0.8 * costoHotel) + costoHotelAparte;
		assertEquals(costoEsperado, algoTrip.obtenerCostoDelViaje("vacaciones-2018"), DELTA);		
		
		// El viaje dura 35 dias
		assertEquals(35, algoTrip.obtenerDuracionEnDiasDelViaje("vacaciones-2018"));
	}
	
}