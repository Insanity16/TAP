package sample.Minimo_cuadrado;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.Main;

import java.io.IOException;

public class minimo_cuadrado {
    public void atras(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Principal/principal.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);
    }
}
