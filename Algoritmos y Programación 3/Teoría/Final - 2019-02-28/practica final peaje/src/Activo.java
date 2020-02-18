public class Activo implements Telepase {

    @Override
    public double aplicarDescuento(Transporte transporte){

        return 1;

    }

    @Override
    public double aplicarDescuento(Auto auto){

        return 0.5;

    }

    @Override
    public double aplicarDescuento(Camion camion){

        return 0.25;

    }

    @Override
    public double aplicarDescuento(Moto moto){

        return 1;

    }

}
