public class Main {
    public static void main( String[] args ) {
        Figure [] figures = new Figure [] {
                new Circle(), new Rectangle() };
        Printer [] printers = new Printer [] {
                new PostscriptPrinter(), new InkjetPrinter() };

        new Client().printAllEverywhere( figures, printers );
    }
}