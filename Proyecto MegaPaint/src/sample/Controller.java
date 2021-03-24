package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {
    @FXML
    Canvas Lienzo;
    @FXML
    GraphicsContext context;
    @FXML
    ColorPicker colorpiker;
    @FXML
    Slider Slider;
    @FXML
    ComboBox ComboOpciones;
    Color colorpincer = Color.BLACK;

    @FXML
    protected void initialize() {
        context=Lienzo.getGraphicsContext2D();
        Slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                pintarDibujos(t1.intValue());

            }
        });
        ComboOpciones.getItems().addAll("Cuadricula", "ajedrez", "Estrella", "Estrella doble","Curvas","Estrella Tapiz","circulo para exentar");

//traer pixeles para moverle
        /*

        context.setFill(Color.BLACK);
        context.fillRect(10,20,100,50);
        context.strokeRect(200,150,200,100);
        context.strokeRect(400,250,200,100);
        context.fillOval(325,325,50,50);
        context.strokeLine(20,20,700,700);
*/
    }

    public void pintarDibujos(int valor) {
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0, 0, Lienzo.getHeight(), Lienzo.getWidth());
        context.setFill(colorpincer);
        System.out.println(valor);
        if (ComboOpciones.getSelectionModel().getSelectedIndex() == 0) {
            for (int x = 0; x < valor + 1; x++) {
                int diviciones = (int) Lienzo.getWidth() / valor;
                context.strokeLine(0, diviciones * x, Lienzo.getHeight(), diviciones * x);
                context.strokeLine(diviciones * x, 0, diviciones * x, Lienzo.getHeight());
            }

        } else if (ComboOpciones.getSelectionModel().getSelectedIndex() == 1) {
            context.fillRect(0,0,Lienzo.getWidth(), Lienzo.getHeight());
            int diviciones = 2 * valor;
            for (int x = 0; x <= Lienzo.getWidth(); x += diviciones) {

                for (int y = 0; y <= Lienzo.getWidth(); y += diviciones) {

                    context.clearRect(x, y, valor, valor);
                }
            }
            for(int x=valor; x<=Lienzo.getWidth(); x+=diviciones){
                for(int y=valor; y<=Lienzo.getWidth(); y+=diviciones){
                    context.clearRect(x,y,valor,valor);
                }
            }


        } else if (ComboOpciones.getSelectionModel().getSelectedIndex() == 2) {
            int divAalto = ((int) Lienzo.getHeight()) / 2;
            int divAncho = ((int) Lienzo.getWidth()) / 2;
            context.strokeLine(divAncho, 0, divAncho, Lienzo.getHeight());
            context.strokeLine(0, divAalto, Lienzo.getWidth(), divAalto);
            int diviosiones = divAncho / valor;
            for (int j = 1; j < valor + 1; j++) {
                context.strokeLine(divAncho, diviosiones * j, divAncho + (diviosiones * j), divAalto);
                context.strokeLine(divAncho, diviosiones * j, divAncho - (diviosiones * j), divAalto);
                context.strokeLine(divAncho, divAncho + (diviosiones * j), diviosiones * j, divAalto);
                context.strokeLine(divAalto, 700 - (diviosiones * j), (diviosiones * j) + divAalto, divAalto);


            }


        } else if (ComboOpciones.getSelectionModel().getSelectedIndex() == 3) {
            int divAalto = ((int) Lienzo.getHeight()) / 2;
            int divAncho = ((int) Lienzo.getWidth()) / 2;
            context.strokeLine(divAncho, 0, divAncho, Lienzo.getHeight());
            context.strokeLine(0, divAalto, Lienzo.getWidth(), divAalto);
            int diviosiones = divAncho / valor;
            for (int j = 1; j < valor + 1; j++) {
                context.strokeLine(divAncho, diviosiones * j, divAncho + (diviosiones * j), divAalto);
                context.strokeLine(divAncho, diviosiones * j, divAncho - (diviosiones * j), divAalto);
                context.strokeLine(divAncho, divAncho + (diviosiones * j), diviosiones * j, divAalto);
                context.strokeLine(divAalto, 700 - (diviosiones * j), (diviosiones * j) + divAalto, divAalto);
                //doble
                context.strokeLine(diviosiones * j, diviosiones * j, (diviosiones * j) + divAalto, divAncho - (diviosiones * j));
                context.strokeLine(diviosiones * j, diviosiones * j, divAncho - (j * diviosiones), divAncho + (j * diviosiones));
                context.strokeLine((divAncho * 2) - (diviosiones * j), (divAncho * 2) - (diviosiones * j), (diviosiones * j) + divAalto, divAncho - (diviosiones * j));
                context.strokeLine((divAncho * 2) - (diviosiones * j), (divAncho * 2) - (diviosiones * j), divAncho - (j * diviosiones), divAncho + (j * diviosiones));
                //orillas
                context.strokeLine(0, diviosiones * j, divAncho - (diviosiones * j), 0);
                context.strokeLine(0, divAncho + (diviosiones * j), diviosiones * j, (divAncho * 2));
                context.strokeLine(700, divAncho + (diviosiones * j), (divAncho * 2) - (diviosiones * j), 700);
                context.strokeLine(700, (divAncho) - (diviosiones * j), (divAncho * 2) - (diviosiones * j), 0);

            }

        } else if (ComboOpciones.getSelectionModel().getSelectedIndex() == 4) {
            int divAalto = ((int) Lienzo.getHeight()) / 2;
            int divAncho = ((int) Lienzo.getWidth()) / 2;
            int diviosiones = divAncho / valor;
            for (int j = 1; j < valor + 1; j++) {
                context.strokeLine(0, (diviosiones * j)*2, (divAncho*2)-(diviosiones * j)*2, 0);
                context.strokeLine(0, (diviosiones * j)*2, (diviosiones * j)*2, (divAncho*2));
                context.strokeLine((divAncho*2), (diviosiones * j)*2, (divAncho*2)-(diviosiones * j)*2, (divAncho*2));
                context.strokeLine((divAncho*2), (diviosiones * j)*2, (diviosiones * j)*2, 0);

                }
        }else if (ComboOpciones.getSelectionModel().getSelectedIndex() == 5) {
            int divAalto = ((int) Lienzo.getHeight()) / 2;
            int divAncho = ((int) Lienzo.getWidth()) / 2;
            int diviosiones = divAncho / valor;
            for (int j = 1; j < valor + 1; j++) {
                context.strokeLine(divAncho, diviosiones * j, divAncho + (diviosiones * j), divAalto);
                context.strokeLine(divAncho, diviosiones * j, divAncho - (diviosiones * j), divAalto);
                context.strokeLine(divAncho, divAncho + (diviosiones * j), diviosiones * j, divAalto);
                context.strokeLine(divAalto, 700 - (diviosiones * j), (diviosiones * j) + divAalto, divAalto);

                context.setFill(Color.CYAN);
                context.strokeLine(divAncho*2, diviosiones * j, (divAncho*2) - (diviosiones * j), divAalto);
                context.strokeLine(divAncho*2, 700 - (diviosiones * j), (divAncho*2) - (diviosiones * j), divAalto);

                context.setFill(Color.PINK);
                context.strokeLine(0, divAalto-(diviosiones * j), divAncho - (diviosiones * j), divAalto);
                context.strokeLine(0, divAncho + (diviosiones * j), divAncho - (diviosiones * j), divAalto);

                context.setFill(Color.GREEN);
                context.strokeLine(divAalto-(diviosiones * j), 0,divAncho , divAncho - (diviosiones * j));
                context.strokeLine(divAalto+(diviosiones * j), 0,divAncho , divAncho - (diviosiones * j));

                context.setFill(Color.RED);
                context.strokeLine(divAalto-(diviosiones * j), 700,divAncho , divAncho + (diviosiones * j));
                context.strokeLine(divAalto+(diviosiones * j), 700,divAncho , divAncho + (diviosiones * j));

            }
        }else if (ComboOpciones.getSelectionModel().getSelectedIndex() == 6) {
            int divAalto = ((int) Lienzo.getHeight()) / 2;
            int divAncho = ((int) Lienzo.getWidth()) / 2;
            int diviosiones = (int) (Lienzo.getWidth() / valor);
            int diviosionesC = (int) ((divAncho/2) / valor);
            int g=51;
            int h=299;

            context.strokeLine(divAncho, 0, divAncho, Lienzo.getHeight());
            context.strokeLine(0, divAalto, Lienzo.getWidth(), divAalto);
            context.strokeOval(0,0,Lienzo.getWidth(),Lienzo.getWidth() );
            for (int j = 1; j < valor + 1; j++) {

                /*context.strokeOval(g+(Math.sin(diviosiones+divAncho)*j),g-(Math.cos(diviosiones+divAncho)*j),divAncho,divAncho);
                context.strokeOval(299+j*(Math.sin(diviosiones)),51+j*(Math.sin(diviosiones)),divAncho,divAncho);
                context.strokeOval(51,299,divAncho,divAncho);
                context.strokeOval(299,299,divAncho,divAncho);
*/
// no se pudo :C




            }
            }

    }
    public void cambiarcolor(ActionEvent event){
        colorpincer= colorpiker.getValue();
    }
    public void limpiar(ActionEvent event){
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,Lienzo.getHeight(),Lienzo.getWidth());
        //colorpincer=Color.WHITESMOKE;

    }
public void arrastar(MouseEvent event){
        context.setFill(colorpincer);
        context.fillOval(event.getX(),event.getY(),10,10);

}
}
