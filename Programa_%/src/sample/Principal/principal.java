package sample.Principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.Main;

import java.io.IOException;

public class principal {



    public void Newton(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Newton/newton.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);
    }
    public void Minimo(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Minimo_cuadrado/minimo_cuadrado.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);
    }
    public void Lagrange(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Lagrange/langrange.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);
    }
}
