package fiuba.algo3.tp1;

import java.time.Duration;

public class Paquete extends Viaje{

    @Override
    public double obtenerCosto(){

        double costoDeVuelos = this.vuelos.stream().mapToDouble(v->v.calcularCosto()).sum();
        double costoDeHoteles = this.estadias.stream().mapToDouble(v->v.calcularCosto()).sum();

        return ((0.8 * costoDeHoteles) + (0.9 * costoDeVuelos));

    }

    @Override
    public int obtenerDuracion() {

        int duracion;

        try {

            Duration diff = Duration.between(this.fechaDeInicioDeViaje.atStartOfDay(), this.fechaDeFinalDeViaje.atStartOfDay());
            duracion = Math.toIntExact(diff.toDays());


        }catch (NullPointerException excepcion){

            duracion = 0;

        }

        return duracion;

    }
}
