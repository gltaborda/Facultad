public class Avestruz implements Corredor{


    private int velocidadEnHielo = 0;
    private int velocidadEnBarro = 70;
    private int velocidadEnPistaDeAtletismo = 70;

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