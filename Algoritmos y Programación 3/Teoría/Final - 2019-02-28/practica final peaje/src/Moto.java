public class Moto extends Transporte {

    public Moto(){

        this.ruedas = 2;
        this.telepase = new Inactivo();
    }

    public double pagarPeaje(){

        return this.ruedas * telepase.aplicarDescuento(this);

    }

    public void activarTelepase(){

        this.telepase = new Inactivo();

    }

}
