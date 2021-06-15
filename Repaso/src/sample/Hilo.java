package sample;

import javafx.application.Platform;
import javafx.scene.control.Button;

public class Hilo extends Thread {
    private  Button button;
    public Hilo(Button button){
        this.button=button;

    }
    int velx1= 1;
    int velx2= 1;
    int vely1= 1;
    int vely2= 1;



    int randomx = (int)(Math.random()*400+50);
    int randomy = (int)(Math.random()*400+50);
    @Override
    public void run() {
        while (true){


            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        if(button.getLayoutX()<=randomx) {
                            button.setLayoutX(button.getLayoutX() + velx1);
                        }else {
                            velx1=0;
                        }
                        if(button.getLayoutX()>=randomx) {
                            button.setLayoutX(button.getLayoutX() - velx2);
                        }else {
                            velx2=0;
                        }


                        if(button.getLayoutY()<=randomy) {
                            button.setLayoutY(button.getLayoutY() + vely1);
                        }else {
                            vely1=0;
                        }
                        if(button.getLayoutY()>=randomy) {
                            button.setLayoutY(button.getLayoutY() - vely2);
                        }else {
                            vely2=0;
                        }



                    }
                });
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
