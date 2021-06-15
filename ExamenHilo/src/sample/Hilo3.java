package sample;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;



public class Hilo3 extends Thread{
    ProgressBar progressBar;
    TextField textField;
    public Hilo3(ProgressBar progressBar,TextField textField){
        this.progressBar=progressBar;
        this.textField=textField;
    }

    double con=0;
    boolean tr=true;
    @Override
    public void run() {
        while (true){
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        double textint=Double.parseDouble(textField.getText());
                        if (con<=textint && tr==true) {

                            progressBar.setProgress(con/100);
                            con = con + 1;

                        }else if(textint>=con){

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
