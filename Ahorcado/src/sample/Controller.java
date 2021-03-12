package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.Random;

public class Controller {
    @FXML HBox contenedor;
    @FXML AnchorPane padre;

    String[] palabras={"pelota","microfono","libro","cartera"};
    TextField[] arraytxt=null;

@FXML protected void initialize(){
    Random random = new Random();
    int aleatorio=random.nextInt( 4);
    String palabra=palabras[aleatorio].toLowerCase();
    System.out.println(palabra);
    arraytxt=new  TextField[palabra.length()];
    int ayuda=1;//letras de ayuda


    final int[] y = {-1};
    final int[] p = {0};
    for(int x=0; x<palabra.length(); x++){
        arraytxt[x]=new TextField();
        arraytxt[x].setPrefHeight(50);
        arraytxt[x].setPrefWidth(50);
        arraytxt[x].setId("txt-"+x+"-"+palabra.charAt(x));
        arraytxt[x].setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                TextField textField =(TextField) event.getTarget();
                String[] nombre = textField.getId().split("-");
                
                if(nombre[2].equals(textField.getText().toLowerCase())){
                    System.out.println("correcto "+textField.getId());
                    textField.setDisable(true);
                    /*
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("!Win");
                        alert.setContentText("Ganaste eres mas listo que el promedio");
                        alert.showAndWait();
                */

                }else{
                    System.out.println("incorrecto "+textField.getId());
                    textField.setText("");



                        ImageView cabeza= new ImageView(new Image("sample/img/cabeza.png"));
                        cabeza.setFitWidth(70);
                        cabeza.setFitHeight(70);
                        cabeza.setLayoutX(200);
                        cabeza.setLayoutY(200);
                        padre.getChildren().addAll(cabeza);
                        y[0]++;



                    if(y[0] == 1){
                        ImageView torso= new ImageView(new Image("sample/img/TORSO.png"));
                        torso.setFitWidth(70);
                        torso.setFitHeight(70);
                        torso.setLayoutX(200);
                        torso.setLayoutY(270);
                        padre.getChildren().addAll(torso);

                    }

                    if(y[0] == 2){
                        ImageView brazoi= new ImageView(new Image("sample/img/Brazo-izquierdo.png"));
                        brazoi.setFitWidth(70);
                        brazoi.setFitHeight(70);
                        brazoi.setLayoutX(160);
                        brazoi.setLayoutY(270);
                        padre.getChildren().addAll(brazoi);

                    }

                    if(y[0] == 3){
                        ImageView brazod= new ImageView(new Image("sample/img/Brazo-derecho.png"));
                        brazod.setFitWidth(70);
                        brazod.setFitHeight(70);
                        brazod.setLayoutX(238);
                        brazod.setLayoutY(270);
                        padre.getChildren().addAll(brazod);

                    }

                    if(y[0] == 4){
                        ImageView piernaI= new ImageView(new Image("sample/img/Pierna-izquierda.png"));
                        piernaI.setFitWidth(70);
                        piernaI.setFitHeight(70);
                        piernaI.setLayoutX(170);
                        piernaI.setLayoutY(330);
                        padre.getChildren().addAll(piernaI);

                    }

                    if(y[0] == 5){
                        ImageView piernaD= new ImageView(new Image("sample/img/Pierna-derecha.png"));
                        piernaD.setFitWidth(70);
                        piernaD.setFitHeight(70);
                        piernaD.setLayoutX(232);
                        piernaD.setLayoutY(330);
                        padre.getChildren().addAll(piernaD);

                    }



                }
            }
        });
        contenedor.getChildren().add(arraytxt[x]);

    }
}




}

