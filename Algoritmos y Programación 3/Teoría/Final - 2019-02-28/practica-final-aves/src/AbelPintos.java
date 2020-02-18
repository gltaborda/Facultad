public class AbelPintos implements Cantante, Corredor {

    private String canto = "vas a entrar sin pedirme la llave...";
    private int velocidadEnHielo = 0;
    private int velocidadEnBarro = 2;
    private int velocidadEnPistaDeAtletismo = 15;

    @Override
    public String cantar() {
        return canto;
    }

    @Override
    public int correr(Superficie superficie) {

        return superficie.decimeQuienSos(this);

    }

    @Override
    public int correr(Barro barro){

        return velocidadEnBarro;

    }

    @Override
    public int correr(Hielo hielo){

        return velocidadEnHielo;

    }

    @Override
    public int correr(PistaDeAtletismo pistaDeAtletismo){

        return velocidadEnPistaDeAtletismo;

    }

}
