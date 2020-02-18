package javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("views/mainView.fxml"));
        Scene scene = new Scene(root, 800, 600);
//        scene.getStylesheets().add("/css/main.css");

        stage.setTitle("Al-Go-Oh!");
        stage.setScene(scene);
        stage.show();
    }
}