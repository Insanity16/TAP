package sample;

import javafx.application.Platform;
import javafx.scene.control.Button;


public class Hilo2 extends Thread {
    private Button button;
    public Hilo2(Button button){
        this.button=button;
    }

    int randomy = (int)(Math.random()*10+10);



    @Override
    public void run() {
        while (true){

            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        if(button.getLayoutY()<=500) {
                            button.setLayoutY(button.getLayoutY() - randomy);
                        }

                    }
                });
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
