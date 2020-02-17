package fiuba.algo3.tp1;

public class VueloInternacional implements TipoDeVuelo{

    public double obtenerCosto(Ciudad origen, Ciudad destino){

        return ((origen.calcularDistanciaHasta(destino)*1.5)*1.05);

    }

}
