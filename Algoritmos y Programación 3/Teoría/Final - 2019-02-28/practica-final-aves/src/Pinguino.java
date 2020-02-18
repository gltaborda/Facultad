public class Pinguino implements Nadador,Corredor {

    private int velocidadEnAgua = 20;
    private int velocidadEnHielo = 5;
    private int velocidadEnBarro = 0;
    private int velocidadEnPistaDeAtletismo = 0;

    public int nadar(){

        return velocidadEnAgua;

    }


    @Override
    public int correr(Superficie superficie){

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
