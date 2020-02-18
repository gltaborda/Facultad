package instrumentos;

public interface Material {

    int aumentarSonido(Instrumento instrumento);
    int aumentarSonido(Charango charango);
    int aumentarSonido(GuitarraCriolla guitarraCriolla);
    int aumentarSonido(Piano piano);
    int aumentarSonido(Saxo saxo);

}