package sample.Lagrange;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import sample.Main;

import java.io.IOException;
import java.text.DecimalFormat;

public class langrange {
    @FXML
    Label idloxa,idloxb,idl1xa,idl1xb,idl2xa,idl2xb,ecuacion;
    @FXML
    TextField X0,X1,X2,Y0,Y1,Y2;
    @FXML
    Canvas Lienzo;
    @FXML
    GraphicsContext context;
    Color colorpincer = Color.RED;
    @FXML
    protected void initialize() {
        context = Lienzo.getGraphicsContext2D();
    }

    public void atras(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Principal/principal.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);
    }
    public void calcular(ActionEvent event) {
        Double t1;
        Double t2;
        Double t3;
        t1 = (-1 * Double.parseDouble(X2.getText()));
        t2 = (-1 * Double.parseDouble(X1.getText()));
        t3 = (-1 * Double.parseDouble(X1.getText()) * -Double.parseDouble(X2.getText()));
        idloxa.setText("X^2 + " + new DecimalFormat("##.##").format(t1) + "X + " + new DecimalFormat("##.##").format(t2) + "X + " + new DecimalFormat("##.##").format(t3) + "");

        Double d1;
        Double d2;
        Double d3;
        Double d4;
        d1 = (Double.parseDouble(X0.getText()) - Double.parseDouble(X1.getText()));
        d2 = (Double.parseDouble(X0.getText()) - Double.parseDouble(X2.getText()));
        d3 = (d1 * d2);
        d4 = (1/d3);
        idloxb.setText(d3 + "");
//segundo
        Double t11;
        Double t22;
        Double t33;
        t11 = (-1 * Double.parseDouble(X2.getText()));
        t22 = (-1 * Double.parseDouble(X0.getText()));
        t33 = (-1 * Double.parseDouble(X0.getText()) * -Double.parseDouble(X2.getText()));
        idl1xa.setText("X^2 + " + new DecimalFormat("##.##").format(t11) + "X + " + new DecimalFormat("##.##").format(t22) + "X + " + new DecimalFormat("##.##").format(t33) + "");

        Double d11;
        Double d22;
        Double d33;
        Double d44;

        d11 = (Double.parseDouble(X1.getText()) - Double.parseDouble(X0.getText()));
        d22 = (Double.parseDouble(X1.getText()) - Double.parseDouble(X2.getText()));
        d33 = (d11 * d22);
        d44 = (1/d33);
        idl1xb.setText(d33 + "");
        //tercero
        Double t111;
        Double t222;
        Double t333;
        t111 = (-1 * Double.parseDouble(X1.getText()));
        t222 = (-1 * Double.parseDouble(X0.getText()));
        t333 = (-1 * Double.parseDouble(X0.getText()) * -Double.parseDouble(X1.getText()));
        idl2xa.setText("X^2 + " + new DecimalFormat("##.##").format(t111) + "X + " + new DecimalFormat("##.##").format(t222) + "X + " + new DecimalFormat("##.##").format(t333) + "");

        Double d111;
        Double d222;
        Double d333;
        Double d444;
        d111 = (Double.parseDouble(X2.getText()) - Double.parseDouble(X0.getText()));
        d222 = (Double.parseDouble(X2.getText()) - Double.parseDouble(X1.getText()));
        d333 = (d111 * d222);
        d444 = (1/d333);
        idl2xb.setText(d333 + "");

        Double h1;
        Double h2;
        Double h3;

        Double j=1.0;

        h1=(d4*j);
        h2=(d4*(t1+t2));
        h3=(d4*t3);
        Double k1=(Double.parseDouble(Y0.getText())*h1);
        Double k2=(Double.parseDouble(Y0.getText())*h2);
        Double k3=(Double.parseDouble(Y0.getText())*h3);
        System.out.println(k1);
        System.out.println(k2);
        System.out.println(k3);

        Double h11;
        Double h22;
        Double h33;
        h11=(d44*j);
        h22=(d44*(t11+t22));
        h33=(d44*t33);
        Double k11=(Double.parseDouble(Y1.getText())*h11);
        Double k22=(Double.parseDouble(Y1.getText())*h22);
        Double k33=(Double.parseDouble(Y1.getText())*h33);
        System.out.println(k11);
        System.out.println(k22);
        System.out.println(k33);

        Double h111;
        Double h222;
        Double h333;
        h111=(d444*j);
        h222=(d444*(t111+t222));
        h333=(d444*t333);
        Double k111=(Double.parseDouble(Y2.getText())*h111);
        Double k222=(Double.parseDouble(Y2.getText())*h222);
        Double k333=(Double.parseDouble(Y2.getText())*h333);
        System.out.println(k111);
        System.out.println(k222);
        System.out.println(k333);

        Double final1;
        Double final2;
        Double final3;


        final1=(k1+k11+k111);
        final2=(k2+k22+k222);
        final3=(k3+k33+k333);

        ecuacion.setText(new DecimalFormat("##.##").format(final1) + "X^2 + " + new DecimalFormat("##.##").format(final2) + "X + " + new DecimalFormat("##.##").format(final3) + "");

        context.setFill(Color.WHITESMOKE);
        context.fillRect(0, 0, Lienzo.getHeight(), Lienzo.getWidth());
        context.setFill(colorpincer);
        Image image = new Image(getClass().getResourceAsStream("../Img/cuadro.jpg"));
        context.drawImage(image, 0, 0,400,200);
        int cont=-4;
        int cont2=-3;
        double doc = final1*((cont*cont))+final2*((cont))+final3;
        System.out.println(doc);
        double doc2 = final1*((cont2*cont2))+final2*((cont2))+final3;
        context.strokeLine(0,((-doc))+160 , 40, ((-doc2))+160);
        cont++;
        cont2++;
        double docc = final1*((cont*cont))+final2*((cont))+final3;
        double docc2 = final1*((cont2*cont2))+final2*((cont2))+final3;
        context.strokeLine(40,((-docc))+160 , 80, ((-docc2))+160);
        cont++;
        cont2++;
        double doccc = final1*((cont*cont))+final2*((cont))+final3;
        double doccc2 = final1*((cont2*cont2))+final2*((cont2))+final3;
        context.strokeLine(80,((-doccc))+160 , 120, ((-doccc2))+160);
        cont++;
        cont2++;
        double docccc = final1*((cont*cont))+final2*((cont))+final3;
        double docccc2 = final1*((cont2*cont2))+final2*((cont2))+final3;
        context.strokeLine(120,((-docccc))+160 , 160, ((-docccc2))+160);
        cont++;
        cont2++;
        double doccccc = final1*((cont*cont))+final2*((cont))+final3;
        double doccccc2 = final1*((cont2*cont2))+final2*((cont2))+final3;
        context.strokeLine(160,((-doccccc))+160 , 200, ((-doccccc2))+160);
        cont++;
        cont2++;
        double docccccc = final1*((cont*cont))+final2*((cont))+final3;
        double docccccc2 = final1*((cont2*cont2))+final2*((cont2))+final3;
        context.strokeLine(200,((-docccccc))+160 , 240, ((-docccccc2))+160);
        cont++;
        cont2++;
        double doccccccc = final1*((cont*cont))+final2*((cont))+final3;
        double doccccccc2 = final1*((cont2*cont2))+final2*((cont2))+final3;
        context.strokeLine(240,((-doccccccc))+160 , 280, ((-doccccccc2))+160);
        cont++;
        cont2++;
        double docccccccc = final1*((cont*cont))+final2*((cont))+final3;
        double docccccccc2 = final1*((cont2*cont2))+final2*((cont2))+final3;
        context.strokeLine(280,((-docccccccc))+160 , 320, ((-docccccccc2))+160);
        cont++;
        cont2++;
        double doccccccccc = final1*((cont*cont))+final2*((cont))+final3;
        double doccccccccc2 = final1*((cont2*cont2))+final2*((cont2))+final3;
        context.strokeLine(320,((-doccccccccc))+160 , 360, ((-doccccccccc2))+160);
        cont++;
        cont2++;
        double docccccccccc = final1*((cont*cont))+final2*((cont))+final3;
        double docccccccccc2 = final1*((cont2*cont2))+final2*((cont2))+final3;
        context.strokeLine(360,((-docccccccccc))+160 , 400, ((-docccccccccc2))+160);
        cont++;
        cont2++;

    }
}
