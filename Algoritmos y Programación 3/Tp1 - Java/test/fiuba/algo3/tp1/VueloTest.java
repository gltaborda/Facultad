package fiuba.algo3.tp1;


import org.junit.Test;

public class VueloTest {

    @Test (expected = VueloEnMismaCiudadError.class)
    public void vueloDeCiudadALaMismaCiudadNoEsValido(){

        Ciudad unaCiudad = new Ciudad();
        unaCiudad.guardarDatos("Buenos Aires", "Argentina", -34.60, -58.38);
        Vuelo unVuelo = new Vuelo(unaCiudad, unaCiudad);

    }

}
