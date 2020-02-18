public class Auto extends Transporte {

    public Auto (){

        this.ruedas = 4;
        this.telepase = new Inactivo();

    }

    public double pagarPeaje(){

        return this.ruedas * telepase.aplicarDescuento(this);

    }

    public void activarTelepase(){

        this.telepase = new Activo();

    }

}
