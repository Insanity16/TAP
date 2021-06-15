package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    Label LblDinero,LblP;
    @FXML
    TextField tot;
    @FXML
    ProgressBar Proges;

    Hilo hilo1;
    Hilo2 hilo2;
    Hilo3 hilo3;



    public void Start(ActionEvent event) {
            hilo1 = new Hilo(LblDinero,tot);
            hilo1.start();
            hilo2= new Hilo2(LblP,tot);
            hilo2.start();
            hilo3 = new Hilo3(Proges,tot);
            hilo3.start();
        }






}
