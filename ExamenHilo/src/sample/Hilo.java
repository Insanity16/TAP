package sample;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class Hilo extends Thread{
    Label label;
    TextField textField;
    public Hilo(Label label,TextField textField){
        this.label=label;
        this.textField=textField;
    }

    int con=0;
    boolean tr=true;

    @Override
    public void run() {
        while (true){
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        int text= Integer.parseInt(textField.getText());

                        if (con<=text && tr==true) {
                            int t = con * 20;
                            label.setText("$ "+t + "");
                            con = con + 1;
                        }else if(con>=text){
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
