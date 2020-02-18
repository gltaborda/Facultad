package javafx.models;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;
import tp2.CartaMonstruo;
import tp2.Juego;
import tp2.interfaces.Carta;
import tp2.interfaces.CartaCampo;
import tp2.interfaces.CartaMagica;
import tp2.interfaces.CartaTrampa;

public class CartaButton extends Button {

    private static final int FASE_VALIDA = 1;

    private final String nombre;
    private Carta carta;

    public CartaButton(Carta carta, boolean enabled, EventHandler<ActionEvent> handle) {
        super(carta.obtenerNombre());
        this.carta = carta;
        this.nombre = carta.obtenerNombre();
        setMinWidth(120);
        setMinHeight(80);
        setWrapText(true);
        setTextAlignment(TextAlignment.CENTER);
        setDisabled(!enabled);

        if (enabled)
            setOnAction(handle);
    }

    public String obtenerNombre() {
        return nombre;
    }

    public Carta getCarta() {
        return this.carta;
    }

    public void jugarCarta() {
        Juego juego = Juego.getInstance();
        if (carta instanceof CartaMonstruo)
            juego.colocarEnPosicionDeAtaqueBocaArriba((CartaMonstruo) carta);
        if (carta instanceof CartaMagica)
            juego.activarCartaMagica((CartaMagica) carta);
        if (carta instanceof CartaTrampa)
            juego.colocarCartaTrampa((CartaTrampa) carta);
        if (carta instanceof CartaCampo)
            juego.colocarCartaCampo((CartaCampo) carta);
    }
}
