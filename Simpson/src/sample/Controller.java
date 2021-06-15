package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class Controller {
    @FXML TextField N1;
    @FXML Label laberh,LabH,LblTotal;
    @FXML TextField Tf0,Tf1,Tf2,Tf3,Tf4,Tf5,Tf6;
    @FXML TextField AH0,AH1,AH2,AH3,AH4,AH5,AH6;
    @FXML TextField AH0F,AH1F,AH2F,AH3F,AH4F,AH5F,AH6F;
    @FXML TextField coe0,coe1,coe2,coe3,coe4,coe5,coe6;
    @FXML TextField coef0,coef1,coef2,coef3,coef4,coef5,coef6,coef7;

    double A=-1;
    double B=2;




    public void CalcularH(ActionEvent event) {
        double ne= Double.parseDouble(N1.getText());
        double total = (B - (A))/ne;
        DecimalFormat formato1 = new DecimalFormat("#.00");
        laberh.setText(formato1.format(total)+"");
        total=0;


    }

    public void Calculartodo(ActionEvent event) {
        double ne=Double.parseDouble(N1.getText());
        double total = (B - (A))/ne;
        double tatalh =total/3;
        DecimalFormat formato1 = new DecimalFormat("#.00");
        LabH.setText(formato1.format(tatalh)+"");

        if(ne<=4){
            Tf0.setVisible(true);
            Tf1.setVisible(true);
            Tf2.setVisible(true);
            Tf3.setVisible(true);
            Tf4.setVisible(true);

            AH0.setVisible(true);
            AH1.setVisible(true);
            AH2.setVisible(true);
            AH3.setVisible(true);
            AH4.setVisible(true);

            AH0F.setVisible(true);
            AH1F.setVisible(true);
            AH2F.setVisible(true);
            AH3F.setVisible(true);
            AH4F.setVisible(true);

            coe0.setVisible(true);
            coe1.setVisible(true);
            coe2.setVisible(true);
            coe3.setVisible(true);
            coe4.setVisible(true);

            coef0.setVisible(true);
            coef1.setVisible(true);
            coef2.setVisible(true);
            coef3.setVisible(true);
            coef4.setVisible(true);
            coef5.setVisible(true);

            Tf0.setText("0");
            Tf1.setText("1");
            Tf2.setText("2");
            Tf3.setText("3");
            Tf4.setText("4");

            coe0.setText("1");
            coe1.setText("4");
            coe2.setText("2");
            coe3.setText("4");
            coe4.setText("1");

            AH0.setText(String.valueOf(A));
            double fah0= (6+(2*A)-((A*A*A)));
            AH0F.setText(String.valueOf(fah0));

            A=A+total;
            AH1.setText(String.valueOf(A));
            double fah1= (6+(2*A)-((A*A*A)));
            AH1F.setText(String.valueOf(fah1));

            A=A+total;
            AH2.setText(String.valueOf(A));
            double fah2= (6+(2*A)-((A*A*A)));
            AH2F.setText(String.valueOf(fah2));

            A=A+total;
            AH3.setText(String.valueOf(A));
            double fah3= (6+(2*A)-((A*A*A)));
            AH3F.setText(String.valueOf(fah3));

            A=A+total;
            AH4.setText(String.valueOf(A));
            double fah4= (6+(2*A)-((A*A*A)));
            AH4F.setText(String.valueOf(fah4));

            double fahcof0=fah0*Double.parseDouble(coe0.getText());
            coef0.setText(String.valueOf(fahcof0));
            double fahcof1=fah1*Double.parseDouble(coe1.getText());
            coef1.setText(String.valueOf(fahcof1));
            double fahcof2=fah2*Double.parseDouble(coe2.getText());
            coef2.setText(String.valueOf(fahcof2));
            double fahcof3=fah3*Double.parseDouble(coe3.getText());
            coef3.setText(String.valueOf(fahcof3));
            double fahcof4=fah4*Double.parseDouble(coe4.getText());
            coef4.setText(String.valueOf(fahcof4));

            double TotalFinal=(fahcof0+fahcof1+fahcof2+fahcof3+fahcof4);
            coef5.setText(String.valueOf(TotalFinal));
            double cop=TotalFinal*tatalh;
            LblTotal.setText(String.valueOf(cop));
        }
        if(ne==5){
            Tf0.setVisible(true);
            Tf1.setVisible(true);
            Tf2.setVisible(true);
            Tf3.setVisible(true);
            Tf4.setVisible(true);
            Tf5.setVisible(true);

            AH0.setVisible(true);
            AH1.setVisible(true);
            AH2.setVisible(true);
            AH3.setVisible(true);
            AH4.setVisible(true);
            AH5.setVisible(true);

            AH0F.setVisible(true);
            AH1F.setVisible(true);
            AH2F.setVisible(true);
            AH3F.setVisible(true);
            AH4F.setVisible(true);
            AH5F.setVisible(true);

            coe0.setVisible(true);
            coe1.setVisible(true);
            coe2.setVisible(true);
            coe3.setVisible(true);
            coe4.setVisible(true);
            coe5.setVisible(true);

            coef0.setVisible(true);
            coef1.setVisible(true);
            coef2.setVisible(true);
            coef3.setVisible(true);
            coef4.setVisible(true);
            coef5.setVisible(true);
            coef6.setVisible(true);

            Tf0.setText("0");
            Tf1.setText("1");
            Tf2.setText("2");
            Tf3.setText("3");
            Tf4.setText("4");
            Tf5.setText("5");

            coe0.setText("1");
            coe1.setText("4");
            coe2.setText("2");
            coe3.setText("4");
            coe4.setText("2");
            coe5.setText("1");

            AH0.setText(String.valueOf(A));
            double fah0= (6+(2*A)-((A*A*A)));
            AH0F.setText(String.valueOf(fah0));

            A=A+total;
            AH1.setText(String.valueOf(A));
            double fah1= (6+(2*A)-((A*A*A)));
            AH1F.setText(String.valueOf(fah1));

            A=A+total;
            AH2.setText(String.valueOf(A));
            double fah2= (6+(2*A)-((A*A*A)));
            AH2F.setText(String.valueOf(fah2));

            A=A+total;
            AH3.setText(String.valueOf(A));
            double fah3= (6+(2*A)-((A*A*A)));
            AH3F.setText(String.valueOf(fah3));

            A=A+total;
            AH4.setText(String.valueOf(A));
            double fah4= (6+(2*A)-((A*A*A)));
            AH4F.setText(String.valueOf(fah4));

            A=A+total;
            AH5.setText(String.valueOf(A));
            double fah5= (6+(2*A)-((A*A*A)));
            AH5F.setText(String.valueOf(fah5));


            double fahcof0=fah0*Double.parseDouble(coe0.getText());
            coef0.setText(String.valueOf(fahcof0));
            double fahcof1=fah1*Double.parseDouble(coe1.getText());
            coef1.setText(String.valueOf(fahcof1));
            double fahcof2=fah2*Double.parseDouble(coe2.getText());
            coef2.setText(String.valueOf(fahcof2));
            double fahcof3=fah3*Double.parseDouble(coe3.getText());
            coef3.setText(String.valueOf(fahcof3));
            double fahcof4=fah4*Double.parseDouble(coe4.getText());
            coef4.setText(String.valueOf(fahcof4));
            double fahcof5=fah5*Double.parseDouble(coe5.getText());
            coef5.setText(String.valueOf(fahcof5));

            double TotalFinal=(fahcof0+fahcof1+fahcof2+fahcof3+fahcof4+fahcof5);
            coef6.setText(String.valueOf(TotalFinal));
            double cop=TotalFinal*tatalh;
            LblTotal.setText(String.valueOf(cop)+" u^2");
        }
        if(ne==6){
            Tf0.setVisible(true);
            Tf1.setVisible(true);
            Tf2.setVisible(true);
            Tf3.setVisible(true);
            Tf4.setVisible(true);
            Tf5.setVisible(true);
            Tf6.setVisible(true);

            AH0.setVisible(true);
            AH1.setVisible(true);
            AH2.setVisible(true);
            AH3.setVisible(true);
            AH4.setVisible(true);
            AH5.setVisible(true);
            AH6.setVisible(true);

            AH0F.setVisible(true);
            AH1F.setVisible(true);
            AH2F.setVisible(true);
            AH3F.setVisible(true);
            AH4F.setVisible(true);
            AH5F.setVisible(true);
            AH6F.setVisible(true);

            coe0.setVisible(true);
            coe1.setVisible(true);
            coe2.setVisible(true);
            coe3.setVisible(true);
            coe4.setVisible(true);
            coe5.setVisible(true);
            coe6.setVisible(true);

            coef0.setVisible(true);
            coef1.setVisible(true);
            coef2.setVisible(true);
            coef3.setVisible(true);
            coef4.setVisible(true);
            coef5.setVisible(true);
            coef6.setVisible(true);
            coef7.setVisible(true);

            Tf0.setText("0");
            Tf1.setText("1");
            Tf2.setText("2");
            Tf3.setText("3");
            Tf4.setText("4");
            Tf5.setText("5");
            Tf6.setText("6");


            coe0.setText("1");
            coe1.setText("4");
            coe2.setText("2");
            coe3.setText("4");
            coe4.setText("2");
            coe5.setText("4");
            coe6.setText("1");

            AH0.setText(String.valueOf(A));
            double fah0= (6+(2*A)-((A*A*A)));
            AH0F.setText(String.valueOf(fah0));

            A=A+total;
            AH1.setText(String.valueOf(A));
            double fah1= (6+(2*A)-((A*A*A)));
            AH1F.setText(String.valueOf(fah1));

            A=A+total;
            AH2.setText(String.valueOf(A));
            double fah2= (6+(2*A)-((A*A*A)));
            AH2F.setText(String.valueOf(fah2));

            A=A+total;
            AH3.setText(String.valueOf(A));
            double fah3= (6+(2*A)-((A*A*A)));
            AH3F.setText(String.valueOf(fah3));

            A=A+total;
            AH4.setText(String.valueOf(A));
            double fah4= (6+(2*A)-((A*A*A)));
            AH4F.setText(String.valueOf(fah4));

            A=A+total;
            AH5.setText(String.valueOf(A));
            double fah5= (6+(2*A)-((A*A*A)));
            AH5F.setText(String.valueOf(fah5));

            A=A+total;
            AH6.setText(String.valueOf(A));
            double fah6= (6+(2*A)-((A*A*A)));
            AH6F.setText(String.valueOf(fah6));


            double fahcof0=fah0*Double.parseDouble(coe0.getText());
            coef0.setText(String.valueOf(fahcof0));
            double fahcof1=fah1*Double.parseDouble(coe1.getText());
            coef1.setText(String.valueOf(fahcof1));
            double fahcof2=fah2*Double.parseDouble(coe2.getText());
            coef2.setText(String.valueOf(fahcof2));
            double fahcof3=fah3*Double.parseDouble(coe3.getText());
            coef3.setText(String.valueOf(fahcof3));
            double fahcof4=fah4*Double.parseDouble(coe4.getText());
            coef4.setText(String.valueOf(fahcof4));
            double fahcof5=fah5*Double.parseDouble(coe5.getText());
            coef5.setText(String.valueOf(fahcof5));
            double fahcof6=fah6*Double.parseDouble(coe6.getText());
            coef6.setText(String.valueOf(fahcof6));

            double TotalFinal=(fahcof0+fahcof1+fahcof2+fahcof3+fahcof4+fahcof5+fahcof6);
            coef7.setText(String.valueOf(TotalFinal));
            double cop=TotalFinal*tatalh;
            LblTotal.setText(String.valueOf(cop)+" u^2");
        }

















    }
    public void Limpiar(ActionEvent event) {

        A=-1;
        B=2;









        Tf0.setVisible(false);
        Tf1.setVisible(false);
        Tf2.setVisible(false);
        Tf3.setVisible(false);
        Tf4.setVisible(false);
        Tf5.setVisible(false);
        Tf6.setVisible(false);

        AH0.setVisible(false);
        AH1.setVisible(false);
        AH2.setVisible(false);
        AH3.setVisible(false);
        AH4.setVisible(false);
        AH5.setVisible(false);
        AH6.setVisible(false);

        AH0F.setVisible(false);
        AH1F.setVisible(false);
        AH2F.setVisible(false);
        AH3F.setVisible(false);
        AH4F.setVisible(false);
        AH5F.setVisible(false);
        AH6F.setVisible(false);

        coe0.setVisible(false);
        coe1.setVisible(false);
        coe2.setVisible(false);
        coe3.setVisible(false);
        coe4.setVisible(false);
        coe5.setVisible(false);
        coe6.setVisible(false);

        coef0.setVisible(false);
        coef1.setVisible(false);
        coef2.setVisible(false);
        coef3.setVisible(false);
        coef4.setVisible(false);
        coef5.setVisible(false);
        coef6.setVisible(false);
        coef7.setVisible(false);

    }



}
