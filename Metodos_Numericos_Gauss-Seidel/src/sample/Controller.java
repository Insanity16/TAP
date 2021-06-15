package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Controller<hi> {
    @FXML TextField txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt1A,txt2A,txt3A;
    @FXML TextField X1,X2,X3,Y1,Y2,Y3,Z1,Z2,Z3,Di1,Di2,Di3,Di4,X4,Y4,Z4,X0,Y0,Z0;



    public void acomodar(ActionEvent event){
        int precio1;
        int precio2;
        int precio3;
        int precio4;
        int precio5;
        int precio6;
        int precio7;
        int precio8;
        int precio9;

        precio1=Integer.parseInt(txt1.getText());
        precio2=Integer.parseInt(txt2.getText());
        precio3=Integer.parseInt(txt3.getText());
        precio4=Integer.parseInt(txt4.getText());
        precio5=Integer.parseInt(txt5.getText());
        precio6=Integer.parseInt(txt6.getText());
        precio7=Integer.parseInt(txt7.getText());
        precio8=Integer.parseInt(txt8.getText());
        precio9=Integer.parseInt(txt9.getText());

if (precio1==0&&precio2==0) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Cuidado");
    alert.setHeaderText("Falta de datos");
    alert.setContentText("Porfavor de introducir los datos necesarios");
    alert.showAndWait();

}else {
    if (precio1 > precio4) {
        if (precio1 > precio7) {
            System.out.println("El mayor es: " + precio1);

            txt1.setLayoutX(63);
            txt1.setLayoutY(48);
            txt2.setLayoutX(125);
            txt2.setLayoutY(48);
            txt3.setLayoutX(189);
            txt3.setLayoutY(48);
            txt1A.setLayoutX(253);
            txt1A.setLayoutY(48);

        } else {
            System.out.println("el mayor es: " + precio7);
            txt7.setLayoutX(63);
            txt7.setLayoutY(48);
            txt8.setLayoutX(125);
            txt8.setLayoutY(48);
            txt9.setLayoutX(189);
            txt9.setLayoutY(48);
            txt3A.setLayoutX(253);
            txt3A.setLayoutY(48);

        }
    } else if (precio4 > precio7) {
        System.out.println("el mayor es: " + precio4);
        txt4.setLayoutX(63);
        txt4.setLayoutY(48);
        txt5.setLayoutX(125);
        txt5.setLayoutY(48);
        txt6.setLayoutX(189);
        txt6.setLayoutY(48);
        txt2A.setLayoutX(253);
        txt2A.setLayoutY(48);

    } else {
        System.out.println("el mayor es: " + precio7);
        txt7.setLayoutX(63);
        txt7.setLayoutY(48);
        txt8.setLayoutX(125);
        txt8.setLayoutY(48);
        txt9.setLayoutX(189);
        txt9.setLayoutY(48);
        txt3A.setLayoutX(253);
        txt3A.setLayoutY(48);

    }


    if (precio2 > precio5) {
        if (precio2 > precio8) {
            System.out.println("El mayor es: " + precio2);
            txt1.setLayoutX(63);
            txt1.setLayoutY(80);
            txt2.setLayoutX(125);
            txt2.setLayoutY(80);
            txt3.setLayoutX(189);
            txt3.setLayoutY(80);
            txt1A.setLayoutX(253);
            txt1A.setLayoutY(80);

        } else {
            System.out.println("el mayor es: " + precio8);
            txt7.setLayoutX(63);
            txt7.setLayoutY(80);
            txt8.setLayoutX(125);
            txt8.setLayoutY(80);
            txt9.setLayoutX(189);
            txt9.setLayoutY(80);
            txt3A.setLayoutX(253);
            txt3A.setLayoutY(80);


        }
    } else if (precio5 > precio8) {
        System.out.println("el mayor es: " + precio5);
        txt4.setLayoutX(63);
        txt4.setLayoutY(80);
        txt5.setLayoutX(125);
        txt5.setLayoutY(80);
        txt6.setLayoutX(189);
        txt6.setLayoutY(80);
        txt2A.setLayoutX(253);
        txt2A.setLayoutY(80);

    } else {
        System.out.println("el mayor es: " + precio8);
        txt7.setLayoutX(63);
        txt7.setLayoutY(80);
        txt8.setLayoutX(125);
        txt8.setLayoutY(80);
        txt9.setLayoutX(189);
        txt9.setLayoutY(80);
        txt3A.setLayoutX(253);
        txt3A.setLayoutY(80);

    }


    if (precio3 > precio6) {
        if (precio3 > precio9) {
            System.out.println("El mayor es: " + precio3);
            txt1.setLayoutX(63);
            txt1.setLayoutY(111);
            txt2.setLayoutX(125);
            txt2.setLayoutY(111);
            txt3.setLayoutX(189);
            txt3.setLayoutY(111);
            txt1A.setLayoutX(253);
            txt1A.setLayoutY(111);

        } else {
            System.out.println("el mayor es: " + precio9);
            txt7.setLayoutX(63);
            txt7.setLayoutY(111);
            txt8.setLayoutX(125);
            txt8.setLayoutY(111);
            txt9.setLayoutX(189);
            txt9.setLayoutY(111);
            txt3A.setLayoutX(253);
            txt3A.setLayoutY(111);

        }
    } else if (precio6 > precio9) {
        System.out.println("el mayor es: " + precio6);
        txt4.setLayoutX(63);
        txt4.setLayoutY(111);
        txt5.setLayoutX(125);
        txt5.setLayoutY(111);
        txt6.setLayoutX(189);
        txt6.setLayoutY(111);
        txt2A.setLayoutX(253);
        txt2A.setLayoutY(111);

    } else {
        System.out.println("el mayor es: " + precio9);
        txt7.setLayoutX(63);
        txt7.setLayoutY(111);
        txt8.setLayoutX(125);
        txt8.setLayoutY(111);
        txt9.setLayoutX(189);
        txt9.setLayoutY(111);
        txt3A.setLayoutX(253);
        txt3A.setLayoutY(111);


    }
}

    }
    public void calcular(ActionEvent event) {
        double ant1=Double.parseDouble(X0.getText());
        double ant2=Double.parseDouble(Y0.getText());
        double ant3=Double.parseDouble(Z0.getText());
        double x=0;
        double y=0;
        double z=0;


        x=(y-(2*z)+12)/11;
        X1.setText(String.valueOf(x));
        y=(8-x-(2*z))/5;
        Y1.setText(String.valueOf(y));
        z=(11+x-(2*y))/10;
        Z1.setText(String.valueOf(z));
        double di1=Math.sqrt((x-ant1)*(x-ant1)+(y-ant2)*(y-ant2)+(z-ant3)*(z-ant3));
        Di1.setText(String.valueOf(di1));




        double ant4=Double.parseDouble(X1.getText());
        double ant5=Double.parseDouble(Y1.getText());
        double ant6=Double.parseDouble(Z1.getText());

        x=(y-(2*z)+12)/11;
        X2.setText(String.valueOf(x));
        y=(8-x-(2*z))/5;
        Y2.setText(String.valueOf(y));
        z=(11+x-(2*y))/10;
        Z2.setText(String.valueOf(z));
        double di2=Math.sqrt((x-ant4)*(x-ant4)+(y-ant5)*(y-ant5)+(z-ant6)*(z-ant6));
        Di2.setText(String.valueOf(di2));

        double ant7=Double.parseDouble(X2.getText());
        double ant8=Double.parseDouble(Y2.getText());
        double ant9=Double.parseDouble(Z2.getText());

        x=(y-(2*z)+12)/11;
        X3.setText(String.valueOf(x));
        y=(8-x-(2*z))/5;
        Y3.setText(String.valueOf(y));
        z=(11+x-(2*y))/10;
        Z3.setText(String.valueOf(z));
        double di3=Math.sqrt((x-ant7)*(x-ant7)+(y-ant8)*(y-ant8)+(z-ant9)*(z-ant9));
        Di3.setText(String.valueOf(di3));

        double ant10=Double.parseDouble(X3.getText());
        double ant11=Double.parseDouble(Y3.getText());
        double ant12=Double.parseDouble(Z3.getText());

        x=(y-(2*z)+12)/11;
        X4.setText(String.valueOf(x));
        y=(8-x-(2*z))/5;
        Y4.setText(String.valueOf(y));
        z=(11+x-(2*y))/10;
        Z4.setText(String.valueOf(z));
        double di4=Math.sqrt((x-ant10)*(x-ant10)+(y-ant11)*(y-ant11)+(z-ant12)*(z-ant12));
        Di4.setText(String.valueOf(di4));



    }






}