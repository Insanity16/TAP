package sample.Principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.Main;

import java.io.IOException;

public class principal {


    public void login (ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("sample/Principal/lange.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);

    }
}
