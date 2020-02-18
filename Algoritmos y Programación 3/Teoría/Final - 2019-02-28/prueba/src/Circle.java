public class Circle implements Figure {
    public void printOn( Printer printer ) {
        printer.printCircle( this ); // <-- the "trick" !
    }
}
