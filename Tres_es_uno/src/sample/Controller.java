package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class Controller {

    public void newton (ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("newton.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);
    }


}
