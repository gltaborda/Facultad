package fiuba.algo3.tp1;

public class Vuelo {

    private Ciudad origen, destino;
    private TipoDeVuelo tipoDeVuelo = new VueloNacional();
    private double costo;
    private int asistenciaAlViajero = 0;

    public Vuelo (Ciudad origen, Ciudad destino) throws VueloEnMismaCiudadError{

        if (origen == destino){

            throw new VueloEnMismaCiudadError();

        }

        this.origen = origen;
        this.destino = destino;

    }

    public double calcularCosto(){

       double costo = (this.costo + this.tipoDeVuelo.obtenerCosto(this.origen, this.destino));
       costo = (costo + (costo * 0.1 * this.asistenciaAlViajero));
       return costo;

    }

    public void esInternacional(){

       this.tipoDeVuelo = new VueloInternacional();

    }

    public void agregarComidaAbordo(){

        this.costo = this.costo + 100;

    }

    public void agregarAsistenciaAlViajero(){

        this.asistenciaAlViajero = 1;

    }

}


