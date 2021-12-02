package sample.Newton;

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
import java.text.DecimalFormat;

import java.io.IOException;

public class newton {
    @FXML
    Label lblb3,labb0,labb1,labb2,labb3,ecua,ecua1,ecua2,ecua3;
    @FXML
    TextField X0,X1,X2,X3,Y0,Y1,Y2,Y3,XD3,XD2,XD1,XD;
    @FXML
    Canvas Lienzo;
    @FXML
    GraphicsContext context;
    Color colorpincer = Color.RED;
    @FXML protected void initialize() {
        context = Lienzo.getGraphicsContext2D();
        }




    public void botonmas(ActionEvent event){
    X3.setVisible(true);
    Y3.setVisible(true);
    lblb3.setVisible(true);
    labb3.setVisible(true);
    }
    public void calcular(ActionEvent event){




        if (X3.getText().trim().equals("") && Y3.getText().trim().equals("")){
            Double t1;
            Double t2;
            Double t11;
           t1=((Double.parseDouble(Y1.getText())-Double.parseDouble(Y0.getText()))/(Double.parseDouble(X1.getText())-Double.parseDouble(X0.getText())));
           t2=((Double.parseDouble(Y2.getText())-Double.parseDouble(Y1.getText()))/(Double.parseDouble(X2.getText())-Double.parseDouble(X1.getText())));
            t11=((t2-t1)/(Double.parseDouble(X2.getText())-Double.parseDouble(X0.getText())));



            labb0.setText(String.valueOf(Y0.getText()));
            labb1.setText(new DecimalFormat("##.##").format(t1)+"");
            labb2.setText(new DecimalFormat("##.##").format(t11)+"");

            ecua.setText((Y0.getText() +" + "+ new DecimalFormat("##.##").format(t1)+" (X-X0) + "+new DecimalFormat("##.##").format(t11)+" (X-X0)(X-X1) "));
            ecua1.setText((Y0.getText() +" + "+new DecimalFormat("##.##").format(t1)+" (X-"+X0.getText()+") + "+new DecimalFormat("##.##").format(t11)+" (X-"+X0.getText()+")(X-"+X1.getText()+") "));
            double vol0=(t1*-(Double.parseDouble(X0.getText())));
            double vol1=(t11*-(Double.parseDouble(X1.getText())));
            double vol11=(t11*-(Double.parseDouble(X0.getText())));
            double vol2=(t11*-(Double.parseDouble(X0.getText()))*-(Double.parseDouble(X1.getText())));


            ecua2.setText((Y0.getText() +" + "+new DecimalFormat("##.##").format(t1)+"x "+new DecimalFormat("##.##").format(vol0)+" + "+new DecimalFormat("##.##").format(t11)+
                    "x^2 "+new DecimalFormat("##.##").format(vol1)+"x "+new DecimalFormat("##.##").format(vol11)+"x "+new DecimalFormat("##.##").format(vol2)+""));


        }
        if (!X3.getText().trim().equals("") && !Y3.getText().trim().equals("")){

            Double t1;
            Double t2;
            Double t3;

            Double t11;
            Double t22;

            Double t111;


            t1=((Double.parseDouble(Y1.getText())-Double.parseDouble(Y0.getText()))/(Double.parseDouble(X1.getText())-Double.parseDouble(X0.getText())));
            t2=((Double.parseDouble(Y2.getText())-Double.parseDouble(Y1.getText()))/(Double.parseDouble(X2.getText())-Double.parseDouble(X1.getText())));
            t3=((Double.parseDouble(Y3.getText())-Double.parseDouble(Y2.getText()))/(Double.parseDouble(X3.getText())-Double.parseDouble(X2.getText())));

            t11=((t2-t1)/(Double.parseDouble(X2.getText())-Double.parseDouble(X0.getText())));
            t22=((t3-t2)/(Double.parseDouble(X3.getText())-Double.parseDouble(X1.getText())));

            t111=((t22-t11)/(Double.parseDouble(X3.getText())-Double.parseDouble(X0.getText())));

            System.out.println(t11);
            System.out.println(t22);
            System.out.println(t111);

            labb0.setText(String.valueOf(Y0.getText()));
            labb1.setText(new DecimalFormat("##.##").format(t1)+"");
            labb2.setText(new DecimalFormat("##.##").format(t11)+"");
            labb3.setText(new DecimalFormat("##.##").format(t111)+"");


            ecua.setText((Y0.getText() +" + "+ new DecimalFormat("##.##").format(t1)+" (X-X0) + "+new DecimalFormat("##.##").format(t11)+" (X-X0)(X-X1) "+new DecimalFormat("##.##").format(t111)+" (X-X0)(X-X1)(X-X2) "));
            ecua1.setText((Y0.getText() +" + "+new DecimalFormat("##.##").format(t1)+" (X-"+X0.getText()+") + "+new DecimalFormat("##.##").format(t11)+" (X-"+X0.getText()+")(X-"+X1.getText()+")"+new DecimalFormat("##.##").format(t111)+" (X-"+X0.getText()+")(X-"+X1.getText()+")(X-"+X2.getText()+")"));
            double vol0=(t1*-(Double.parseDouble(X0.getText())));
            double vol1=(t11*-(Double.parseDouble(X1.getText())));
            double vol11=(t11*-(Double.parseDouble(X0.getText())));
            double vol2=(t11*-(Double.parseDouble(X0.getText()))*-(Double.parseDouble(X1.getText())));
            double vol3=(t111*-(Double.parseDouble(X0.getText())));


            ecua2.setText((Y0.getText() +" + "+new DecimalFormat("##.##").format(t1)+"x + "+new DecimalFormat("##.##").format(vol0)+" + "+new DecimalFormat("##.##").format(t11)+
                    "x^2 + "+new DecimalFormat("##.##").format(vol1)+"x + "+new DecimalFormat("##.##").format(vol11)+"x + "+new DecimalFormat("##.##").format(vol2)+""));
            ecua3.setText(new DecimalFormat("##.##").format(t111)+"x^3 + -"+new DecimalFormat("##.##").format(t111)+"x^2 + "
                    +new DecimalFormat("##.##").format(vol3)+"x^2 + "+new DecimalFormat("##.##").format(vol3)+"x");





        }










    }
    public void verificar(ActionEvent event) {
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0, 0, Lienzo.getHeight(), Lienzo.getWidth());
        context.setFill(colorpincer);
        Image image = new Image(getClass().getResourceAsStream("../Img/cuadro.jpg"));
        context.drawImage(image, 0, 0,350,200);

        int cont=0;
        int cont2=1;
        double dex0 = (Double.parseDouble(XD3.getText())*((cont*cont*cont)));
        double dex1 = (Double.parseDouble(XD2.getText())*((cont*cont)));
        double dex2 = (Double.parseDouble(XD1.getText())*((cont)));
        double dex3 = Double.parseDouble(XD.getText());
        double dex00 = (Double.parseDouble(XD3.getText())*((cont2*cont2*cont2)));
        double dex11 = (Double.parseDouble(XD2.getText())*((cont2*cont2)));
        double dex22 = (Double.parseDouble(XD1.getText())*((cont2)));
        double dex33 = Double.parseDouble(XD.getText());
        double dwext= dex0+dex1+dex2+dex3;
        double dwext1= dex00+dex11+dex22+dex33;
        System.out.println(dwext);
        System.out.println(dwext1);
        //context.strokeLine(0, (Double.parseDouble(XD3.getText())*((cont*cont*cont)))+(Double.parseDouble(XD2.getText())*((cont*cont)))+(Double.parseDouble(XD1.getText())*((cont)))+Double.parseDouble(XD.getText())*10, 50, (Double.parseDouble(XD3.getText())*((cont2*cont2*cont2)))+(Double.parseDouble(XD2.getText())*((cont2*cont2)))+(Double.parseDouble(XD1.getText())*((cont2)))+Double.parseDouble(XD.getText())*10);
        context.strokeLine(0,((-dwext)*10)+200 , 50, ((-dwext1)*10)+200);
        cont++;
        cont2++;
        double doc = (Double.parseDouble(XD3.getText())*((cont*cont*cont)))+(Double.parseDouble(XD2.getText())*((cont*cont)))+(Double.parseDouble(XD1.getText())*((cont)))+Double.parseDouble(XD.getText());
        double doc1 = (Double.parseDouble(XD3.getText())*((cont2*cont2*cont2)))+(Double.parseDouble(XD2.getText())*((cont2*cont2)))+(Double.parseDouble(XD1.getText())*((cont2)))+Double.parseDouble(XD.getText());

        context.strokeLine(50, ((-doc)*10)+200 , 100 , ((-doc1)*10)+200);
        cont++;
        cont2++;
        double docc = (Double.parseDouble(XD3.getText())*((cont*cont*cont)))+(Double.parseDouble(XD2.getText())*((cont*cont)))+(Double.parseDouble(XD1.getText())*((cont)))+Double.parseDouble(XD.getText());
        double docc1 = (Double.parseDouble(XD3.getText())*((cont2*cont2*cont2)))+(Double.parseDouble(XD2.getText())*((cont2*cont2)))+(Double.parseDouble(XD1.getText())*((cont2)))+Double.parseDouble(XD.getText());

        context.strokeLine(100, ((-docc)*10)+200 , 150 , ((-docc1)*10)+200);
        cont++;
        cont2++;
        double doccc = (Double.parseDouble(XD3.getText())*((cont*cont*cont)))+(Double.parseDouble(XD2.getText())*((cont*cont)))+(Double.parseDouble(XD1.getText())*((cont)))+Double.parseDouble(XD.getText());
        double doccc1 = (Double.parseDouble(XD3.getText())*((cont2*cont2*cont2)))+(Double.parseDouble(XD2.getText())*((cont2*cont2)))+(Double.parseDouble(XD1.getText())*((cont2)))+Double.parseDouble(XD.getText());

        context.strokeLine(150, ((-doccc)*10)+200 , 200 , ((-doccc1)*10)+200);
        cont++;
        cont2++;
        double docccc = (Double.parseDouble(XD3.getText())*((cont*cont*cont)))+(Double.parseDouble(XD2.getText())*((cont*cont)))+(Double.parseDouble(XD1.getText())*((cont)))+Double.parseDouble(XD.getText());
        double docccc1 = (Double.parseDouble(XD3.getText())*((cont2*cont2*cont2)))+(Double.parseDouble(XD2.getText())*((cont2*cont2)))+(Double.parseDouble(XD1.getText())*((cont2)))+Double.parseDouble(XD.getText());

        context.strokeLine(200, ((-docccc)*10)+200 , 250 , ((-docccc1)*10)+200);
        cont++;
        cont2++;
        double doccccc = (Double.parseDouble(XD3.getText())*((cont*cont*cont)))+(Double.parseDouble(XD2.getText())*((cont*cont)))+(Double.parseDouble(XD1.getText())*((cont)))+Double.parseDouble(XD.getText());
        double doccccc1 = (Double.parseDouble(XD3.getText())*((cont2*cont2*cont2)))+(Double.parseDouble(XD2.getText())*((cont2*cont2)))+(Double.parseDouble(XD1.getText())*((cont2)))+Double.parseDouble(XD.getText());

        context.strokeLine(250, ((-doccccc)*10)+200 , 300 , ((-doccccc1)*10)+200);
        cont++;
        cont2++;
        double docccccc = (Double.parseDouble(XD3.getText())*((cont*cont*cont)))+(Double.parseDouble(XD2.getText())*((cont*cont)))+(Double.parseDouble(XD1.getText())*((cont)))+Double.parseDouble(XD.getText());
        double docccccc1 = (Double.parseDouble(XD3.getText())*((cont2*cont2*cont2)))+(Double.parseDouble(XD2.getText())*((cont2*cont2)))+(Double.parseDouble(XD1.getText())*((cont2)))+Double.parseDouble(XD.getText());
        System.out.println(docccccc);
        context.strokeLine(300, ((-docccccc)*10)+200 , 350 , ((-docccccc1)*10)+200);
        cont++;
        cont2++;

    }

    public void atras(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Principal/principal.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);
    }
}
