public abstract class Transporte {

    public int ruedas;

    public Telepase telepase;

    public abstract double pagarPeaje();



    /*public Transporte(int ruedas) {
        this.ruedas = ruedas;
        this.telepase = false;
    }*/

   /* public int getRuedas(){
        return ruedas;
    }

    public void instalarTelepase(){
        if (this.ruedas == 2){
            //A las motos no se les puede poner telepase
            this.telepase = false;
        }else{
            this.telepase = true;
        }
    }

    public boolean tieneTelepase(){
        return telepase;
    }*/
}