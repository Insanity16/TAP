package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Objects;

public class Controller {
    @FXML Label Lb1,Lb2,Lb3,Lb4;
    @FXML Button btn;
    Hilo h1,h2,h3,h4;

    int con=0;
    public void generar(ActionEvent event){
if(btn.getText().equals("Generar")){
    h1=new Hilo(Lb1);
    h2=new Hilo(Lb2);
    h3=new Hilo(Lb3);
    h4=new Hilo(Lb4);
    h1.start();
    h2.start();
    h3.start();
    h4.start();
    btn.setText("Detener");
    btn.setStyle("-fx-background-color: red");

}else {


    if (con==0) {

        if (!Lb1.getText().equals( Lb2.getText())) {
            con=1;
        }else if (Lb1.getText().equals(Lb2.getText())){
            con=0;
        }
    }

    if (con==1) {
        if (!Lb1.getText().equals( Lb3.getText())&&!Lb2.getText().equals( Lb3.getText())) {
            con=2;
        }else if (Lb1.getText().equals(Lb3.getText())||Lb2.getText().equals(Lb3.getText())){
            con=0;
        }
    }
    if (con==2) {
        if (!Lb1.getText().equals( Lb4.getText())&&!Lb2.getText().equals( Lb4.getText())&&!Lb3.getText().equals( Lb4.getText())) {
            con=3;

        }else if (Lb1.getText().equals(Lb4.getText())||Lb2.getText().equals(Lb4.getText())||Lb3.getText().equals(Lb4.getText())){
            con=0;
        }
    }
    if (con==3){
        System.out.println(Lb1.getText()+"/"+Lb2.getText()+"/"+Lb3.getText()+"/"+Lb4.getText()+"  Si jala");
        con=0;
        h1.stop();
        h2.stop();
        h3.stop();
        h4.stop();
    }
    btn.setText("Generar");
    btn.setStyle("-fx-background-color: white");
}

    }

}
