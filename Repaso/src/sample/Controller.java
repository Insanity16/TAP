package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;




public class Controller {
    @FXML
    Button Btsi,Btno,Bti,Bti1,Bti2,Bti3,Bti4,Bti5,Bti6,Bti7;
    Hilo hilo1;
    Hilo2 hilo2;



    public void Si(ActionEvent event){
        Bti.setVisible(true);
        Bti1.setVisible(true);
        Bti2.setVisible(true);
        Bti3.setVisible(true);
        Bti4.setVisible(true);
        Bti5.setVisible(true);
        Bti6.setVisible(true);
        Bti7.setVisible(true);

hilo2= new Hilo2(Bti);
hilo2.start();
hilo2= new Hilo2(Bti1);
hilo2.start();
hilo2= new Hilo2(Bti2);
hilo2.start();
hilo2= new Hilo2(Bti3);
hilo2.start();
hilo2= new Hilo2(Bti4);
hilo2.start();
hilo2= new Hilo2(Bti5);
hilo2.start();
hilo2= new Hilo2(Bti6);
hilo2.start();
hilo2= new Hilo2(Bti7);
hilo2.start();

    }
    public void no(MouseEvent event){
hilo1= new Hilo(Btno);
hilo1.start();
    }


}
