package fiuba.algo3.tp1;

public class Ciudad {

    private String nombre, pais;
    private double latitud, longitud;

    public Ciudad (){

    }

    public void guardarDatos(String nombreDeCiudad, String paisDeCiudad, double latitudDeCiudad, double longitudDeCiudad){

        this.nombre = nombreDeCiudad;
        this.pais = paisDeCiudad;
        this.latitud = latitudDeCiudad;
        this.longitud = longitudDeCiudad;

    }

    private double obtenerLatitud(){

        return this.latitud;

    }

    private double obtenerLongitud(){

        return this.longitud;

    }

    public double calcularDistanciaHasta (Ciudad unaCiudad){

        return unaCiudad.calcularDistanciaDesde(latitud, longitud);

    }

    private double calcularDistanciaDesde (double latitud1, double longitud1){

        double radioTerrestre, latitud2, longitud2, distancia;

        radioTerrestre = 6371;
        latitud2 = this.obtenerLatitud();
        longitud2 = this.obtenerLongitud();

        distancia = 2 * radioTerrestre *
                (Math.asin(Math.sqrt(Math.pow(Math.sin(Math.toRadians(latitud2 - latitud1) / 2),2)
        + (Math.cos(Math.toRadians(latitud1)) * (Math.cos(Math.toRadians(latitud2))) *
        (Math.pow(Math.sin(Math.toRadians(longitud2 - longitud1) / 2),2))))));

        return distancia;

    }

    public boolean enMismoPaisQue(Ciudad otraCiudad){

        return (otraCiudad.estaEnPais(this.pais));

    }

    private boolean estaEnPais(String unPais){

        return ((this.pais) == (unPais));

    }

}
