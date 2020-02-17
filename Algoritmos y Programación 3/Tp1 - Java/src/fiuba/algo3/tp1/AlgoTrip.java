package fiuba.algo3.tp1;

import java.util.HashMap;
import java.util.Map;



public class AlgoTrip {

    private Map<String, Viaje> viajes = new HashMap<String,Viaje>();
    private Map<String, Ciudad> ciudades = new HashMap<String,Ciudad>();
    private Map<String, Integer> hoteles = new HashMap<String,Integer>();
    private Map<String, Paquete> paquetes = new HashMap<String,Paquete>();


    public AlgoTrip(){

    }


    public void crearViaje(String nombreDeViaje){

        Viaje viaje = new Viaje ();
        viajes.put(nombreDeViaje, viaje);

    }

    public double obtenerCostoDelViaje(String nombreDeViaje){

        return this.viajes.get(nombreDeViaje).obtenerCosto();

    }

    public int obtenerDuracionEnDiasDelViaje(String nombreDeViaje){

        return this.viajes.get(nombreDeViaje).obtenerDuracion();

    }

    public void agregarCiudad(String codigoDeCiudad, String nombreDeCiudad, String paisDeCiudad, double latitudDeCiudad, double longitudDeCiudad){

        Ciudad ciudad;

        if(!ciudades.containsKey(codigoDeCiudad)){

            ciudad = new Ciudad();

        }else{

            ciudad = ciudades.get(codigoDeCiudad);

        }

        ciudad.guardarDatos(nombreDeCiudad, paisDeCiudad, latitudDeCiudad, longitudDeCiudad);

        ciudades.put(codigoDeCiudad, ciudad);

    }

    public void agregarVueloEnViaje(String nombreDeViaje, String origen, String destino, String fechaDeViaje){

        Ciudad ciudadDeOrigen, ciudadDeDestino;

        ciudadDeOrigen = ciudades.get(origen);
        ciudadDeDestino = ciudades.get(destino);

        this.viajes.get(nombreDeViaje).agregarVuelo(ciudadDeOrigen, ciudadDeDestino, fechaDeViaje);

    }

    public void agregarHotel(String nombreDeHotel, String codigoDeCiudad, Integer costoPorNoche){

        hoteles.put(nombreDeHotel, costoPorNoche);

    }

    public void agregarEstadiaEnViaje(String nombreDeViaje, String nombreDeHotel, String fechaDeIngreso, String fechaDeEgreso){

        Viaje viaje = viajes.get(nombreDeViaje);
        Integer costoPorNoche = hoteles.get(nombreDeHotel);
        viaje.agregarEstadia(costoPorNoche, fechaDeIngreso, fechaDeEgreso);

    }

    public void agregarAsistenciaAlViajeroAlViaje(String nombreDeViaje){

        Viaje unViaje = viajes.get(nombreDeViaje);
        unViaje.agregarAsistenciaAlViajero();

    }

    public void solicitarComidaEspecialAbordoPara(String nombreDeViaje){

        Viaje unViaje = viajes.get(nombreDeViaje);
        unViaje.solicitarComidaEspecialAbordo();

    }

    public void agregarPaquete(String nombreDePaquete){

        Paquete paquete = new Paquete();
        paquetes.put(nombreDePaquete, paquete);

    }

    public void agregarVueloEnPaquete(String nombreDePaquete, String origen, String destino, String fechaDeViaje){

        Ciudad ciudadDeOrigen, ciudadDeDestino;

        ciudadDeOrigen = ciudades.get(origen);
        ciudadDeDestino = ciudades.get(destino);

        this.paquetes.get(nombreDePaquete).agregarVuelo(ciudadDeOrigen, ciudadDeDestino, fechaDeViaje);


    }

    public void agregarEstadiaEnPaquete(String nombreDePaquete, String nombreDeHotel, String fechaDeIngreso, String fechaDeEgreso){

        Paquete paquete = paquetes.get(nombreDePaquete);
        Integer costoPorNoche = hoteles.get(nombreDeHotel);
        paquete.agregarEstadia(costoPorNoche, fechaDeIngreso, fechaDeEgreso);

    }

    public void agregarPaqueteEnViaje(String nombreDeViaje, String nombreDePaquete) throws PaqueteNoExisteError {

        Paquete unPaquete = paquetes.get(nombreDePaquete);

        if (unPaquete == null){

            throw new PaqueteNoExisteError();

        }

        Viaje unViaje = viajes.get(nombreDeViaje);
        unViaje.agregarPaquete(unPaquete);

    }

}
