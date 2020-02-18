package javafx.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.models.CartaButton;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import tp2.CartaMonstruo;
import tp2.Juego;
import tp2.interfaces.Carta;

import java.util.ArrayList;
import java.util.List;

public class MainViewController {

    private static final int FASE_INICIAL = 0;
    private static final int FASE_PREPARACION = 1;
    private static final int FASE_ATAQUE = 2;
    private static final int FASE_TRAMPA = 3;
    private static final int FASE_FINAL = 4;

    @FXML
    public TableView<Carta> tablaCartasJugadorUno;
    @FXML
    public TableView<Carta> tablaCartasJugadorDos;

    public AnchorPane paneCartasJugadorUno;

    public GridPane gridCartasJugadorUno;
    public GridPane gridCartasJugadorDos;
    public Label txtFaseActual;
    public Button btnSiguienteFase;
    public GridPane zonaMonstruosJugador1;
    public GridPane zonaMonstruosJugador2;
    public Label puntosVidaJugadorUno;
    public Label puntosVidaJugadorDos;

    private ObservableList<Carta> listaCartasJugadorUno = FXCollections.observableArrayList();
    private ObservableList<Carta> listaCartasJugadorDos = FXCollections.observableArrayList();

    private Juego juego;

    // TODO: ATENCIÓN! ESTO SOLO LO AGREGO PARA TENER INDICADOR VISUAL.
    private static ArrayList<String> fases = new ArrayList<>();
    private static int faseActual = 0;
    private CartaMonstruo cartaAtacante;

    // Add a public no-args constructor
    public MainViewController() {
        juego = Juego.nuevoJuego();
        fases.add(FASE_INICIAL, "Fase inicial"); // TOMA CARTA
        fases.add(FASE_PREPARACION, "Fase de preparación");
        fases.add(FASE_ATAQUE, "Fase de ataque");
        fases.add(FASE_TRAMPA, "Fase de trampas");
        fases.add(FASE_FINAL, "Fase final");
    }

    @FXML
    private void initialize() {
        actualizarElementosDeInterfaz();
    }

    private void actualizarElementosDeInterfaz() {
        actualizarManosDeJugadores();
        actualizarFase();
        actualizarZonasDeCampo();
        actualizarPuntosDeVida();
    }

    private void avanzarFase() {
        faseActual++;
        if(faseActual > FASE_FINAL) {
            juego.terminarTurno();
            faseActual = 0;
        }
    }

    private void actualizarFase() {
        txtFaseActual.setText(faseActual + ": " + fases.get(faseActual));
    }

    public void actualizarManosDeJugadores() {
        gridCartasJugadorUno.getChildren().clear();
        gridCartasJugadorDos.getChildren().clear();

        List<Carta> cartasJugadorUno = juego.obtenerJugadorActual().obtenerCartasEnMano();
        int index = 0;

        for (Carta carta : cartasJugadorUno) {
            CartaButton cartaButton = new CartaButton(carta, faseActual == FASE_PREPARACION, this::jugarCarta);
            gridCartasJugadorUno.add(cartaButton, index, 0);
            index++;
        }

        List<Carta> cartasJugadorDos = juego.obtenerOponente().obtenerCartasEnMano();
        index = 0;

        for (Carta carta : cartasJugadorDos) {
            CartaButton cartaButton = new CartaButton(carta, false, this::jugarCarta);
            gridCartasJugadorDos.add(cartaButton, index, 0);
            index++;
        }
    }

    public void actualizarZonasDeCampo() {
        zonaMonstruosJugador1.getChildren().clear();
        zonaMonstruosJugador2.getChildren().clear();

        List<CartaMonstruo> monstruosJugadorUno = juego.obtenerJugadorActual().obtenerCartasEnZonaDeMonstruos();
        List<CartaMonstruo> monstruosJugadorDos = juego.obtenerOponente().obtenerCartasEnZonaDeMonstruos();

        int index = 0;

        for (CartaMonstruo carta : monstruosJugadorUno) {
            CartaButton cartaButton = new CartaButton(carta, faseActual == FASE_ATAQUE, this::atacarConCarta); // todo event handler para poder atacar.
            zonaMonstruosJugador1.add(cartaButton, index, 0);
            index++;
        }

        index = 0;
        for (CartaMonstruo carta : monstruosJugadorDos) {
            CartaButton cartaButton = new CartaButton(carta, false, null);
            zonaMonstruosJugador2.add(cartaButton, index, 0);
            index++;
        }
    }

    private void actualizarPuntosDeVida() {
        puntosVidaJugadorUno.setText(String.valueOf(juego.obtenerJugadorActual().obtenerPuntosDeVida()));
        puntosVidaJugadorDos.setText(String.valueOf(juego.obtenerOponente().obtenerPuntosDeVida()));
    }

    public void terminarFase(ActionEvent actionEvent) {
        avanzarFase();
        actualizarElementosDeInterfaz();
    }

    private void jugarCarta(ActionEvent e) {
        CartaButton button = (CartaButton)e.getTarget();
        button.jugarCarta();
        terminarFase(null); // solo se puede jugar una carta
    }

    private void atacarConCarta(ActionEvent e) {
        CartaButton button = (CartaButton)e.getTarget();
        this.cartaAtacante = (CartaMonstruo)button.getCarta();

        zonaMonstruosJugador2.getChildren().forEach(n -> {
            CartaButton monstruoJugador2 = (CartaButton)n;
            monstruoJugador2.setStyle("-fx-background-color: orange");
            monstruoJugador2.setOnAction(this::recibirAtaque);
        });
    }

    private void popupParaColocarEnCampo(ActionEvent e) {
        final Popup popup = new Popup();
        popup.setX(300);
        popup.setY(200);
        popup.getContent().addAll(new Circle(25, 25, 50, Color.AQUAMARINE));
        popup.show(((Node)e.getSource()).getScene().getWindow());
    }

    private void recibirAtaque(ActionEvent e) {
        CartaButton button = (CartaButton)e.getTarget();
        juego.atacarCon(this.cartaAtacante, (CartaMonstruo) button.getCarta());
        actualizarElementosDeInterfaz();
    }
}
