public class Camion extends Transporte {

    public Camion (){

        this.ruedas = 18;
        this.telepase = new Inactivo();

    }

    public double pagarPeaje(){

        return this.ruedas * telepase.aplicarDescuento(this);

    }

    public void activarTelepase(){

        this.telepase = new Activo();

    }

}
