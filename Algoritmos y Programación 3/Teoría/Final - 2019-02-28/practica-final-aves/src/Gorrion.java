public class Gorrion implements Cantante,Volador{

    private String canto = "pio pio";
    private int velocidadEnAire = 50;

    @Override
    public String cantar() {
        return canto;
    }

    @Override
    public int volar() {
        return velocidadEnAire;
    }

}