package fiuba.algo3.tp1;

import java.util.List;
import java.util.ArrayList;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Viaje {

    protected List<Vuelo> vuelos = new ArrayList<Vuelo>();
    protected List<Hotel> estadias = new ArrayList<Hotel>();
    protected LocalDate fechaDeInicioDeViaje, fechaDeFinalDeViaje;
    private List<Paquete> paquetes = new ArrayList<Paquete>();

    public double obtenerCosto(){

        double costoDeVuelos = this.vuelos.stream().mapToDouble(v->v.calcularCosto()).sum();
        double costoDeHoteles = this.estadias.stream().mapToDouble(v->v.calcularCosto()).sum();
        double costoDePaquetes = this.paquetes.stream().mapToDouble(v->v.obtenerCosto()).sum();

        return (costoDeHoteles + costoDeVuelos + costoDePaquetes);

    }

    public int obtenerDuracion (){

        int duracion;

        try {

            Duration diff = Duration.between(this.fechaDeInicioDeViaje.atStartOfDay(), this.fechaDeFinalDeViaje.atStartOfDay());
            duracion = Math.toIntExact(diff.toDays())+1;


        }catch (NullPointerException excepcion){

            duracion = 0;

        }

        int duracionDePaquetes = this.paquetes.stream().mapToInt(v->v.obtenerDuracion()).sum();
        return (duracion + duracionDePaquetes);

    }

    public void validarFecha(String fecha){

         LocalDate fechaAValidar = LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE);

         try {

             if ((fechaAValidar.compareTo(this.fechaDeInicioDeViaje)) < 0) {

                 this.fechaDeInicioDeViaje = fechaAValidar;

             }

             if ((fechaAValidar.compareTo(this.fechaDeFinalDeViaje)) > 0) {

                 this.fechaDeFinalDeViaje = fechaAValidar;

             }
         } catch (NullPointerException excepcion){

             this.fechaDeInicioDeViaje = fechaAValidar;
             this.fechaDeFinalDeViaje = fechaAValidar;

         }
    }

    public void agregarVuelo(Ciudad origen, Ciudad destino, String fecha) {

        Vuelo unVuelo = new Vuelo(origen, destino);

        if (!(origen.enMismoPaisQue(destino))){

            unVuelo.esInternacional();

        }

        vuelos.add(unVuelo);
        this.validarFecha(fecha);

    }

    public void agregarEstadia(Integer costoPorNoche, String fechaDeIngreso, String fechaDeEgreso){

        Hotel unHotel = new Hotel(costoPorNoche, fechaDeIngreso, fechaDeEgreso);
        estadias.add(unHotel);
        this.validarFecha(fechaDeIngreso);
        this.validarFecha(fechaDeEgreso);

    }

    public void agregarAsistenciaAlViajero() {

        this.estadias.stream().forEach(hotel->hotel.agregarAsistenciaAlViajero());
        this.vuelos.stream().forEach(vuelo->vuelo.agregarAsistenciaAlViajero());

    }

   public void solicitarComidaEspecialAbordo() throws NoHayVuelosError {


        if (this.vuelos.isEmpty()){

            throw new NoHayVuelosError();

        }

        this.vuelos.stream().forEach(vuelo->vuelo.agregarComidaAbordo());

    }

    public void agregarPaquete(Paquete unPaquete){

        paquetes.add(unPaquete);

    }

}
