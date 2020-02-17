package fiuba.algo3.tp1;

public class VueloNacional implements TipoDeVuelo{

    public double obtenerCosto(Ciudad origen, Ciudad destino){

        return (origen.calcularDistanciaHasta(destino));

    }

}
