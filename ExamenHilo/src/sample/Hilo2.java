package sample;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;


public class Hilo2 extends Thread{
    Label label;
    TextField textField;
    public Hilo2(Label label,TextField textField){
        this.label=label;
        this.textField=textField;
    }

    int con=0;
    int porcentaje=100;
    boolean tr=true;
    double hjs=0;
    @Override
    public void run() {
        while (true){
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        double textint=Double.parseDouble(textField.getText());
                        if ( tr==true && hjs<=100) {

                            double jsd=textint/porcentaje;

                             hjs=(jsd*(porcentaje*con)/textint);

                            label.setText(hjs + "% de Gasolina Cargada");
                            con = con + 1;
                        }else if(con>=textint && hjs>=100){
                            hjs=0;
                            tr=false;
                        }




                    }
                });
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
