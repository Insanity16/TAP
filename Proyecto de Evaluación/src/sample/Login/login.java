package sample.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.Main;
import sample.models.conexion;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class login {
    private sample.models.conexion conexion;
    @FXML
    TextField txtusuario,txtpassword;


    public void initialize(){
        conexion=new conexion();
    }
    public void Simulador(ActionEvent event) throws IOException, SQLException {
       
        String email=txtusuario.getText();
        String pass=txtpassword.getText();
        System.out.println(email);
        System.out.println(pass);


        ResultSet resultSet=conexion.consultar("select * from users where email='"+email+"' and password='"+pass+"'");
        System.out.println("select * from users where email= '"+email+"' and password='"+pass+"'");

 if(resultSet!=null){
int cont=0;
while (resultSet.next()){
    Alert alert=new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Bienvenido");
    alert.setContentText("Bienvenido: "+resultSet.getObject("name"));
    alert.show();
    cont++;
  //System.out.println(resultSet.getObject("name"));
  //System.out.println(resultSet.getObject("email"));

 }
if(cont==0){
    Alert alert=new Alert(Alert.AlertType.ERROR);
    alert.setTitle("ERROR");
    alert.setContentText("Usuario o contaseña no valido");
    alert.show();
}else{
    Parent root= FXMLLoader.load(getClass().getResource("../Simulador/simulador.fxml"));
    Scene scene= new Scene(root);
    Main.stage.setScene(scene);
}

}


    }
    public void info(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Centro_de_Atencion/centro_de_atenciones.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);
    }
    public void sintomas (ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Sintomas/sintomas.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);
    }
    public void informacion(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Informacion/informacion.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);
    }
    public void Base(ActionEvent event) throws IOException, SQLException {

        String email=txtusuario.getText();
        String pass=txtpassword.getText();
        System.out.println(email);
        System.out.println(pass);


        ResultSet resultSet=conexion.consultar("select * from users where email='"+email+"' and password='"+pass+"'");
        System.out.println("select * from users where email= '"+email+"' and password='"+pass+"'");

        if(resultSet!=null){
            int cont=0;
            while (resultSet.next()){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Bienvenido");
                alert.setContentText("Bienvenido: "+resultSet.getObject("name"));
                alert.show();
                cont++;
                //System.out.println(resultSet.getObject("name"));
                //System.out.println(resultSet.getObject("email"));

            }
            if(cont==0){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Usuario o contaseña no valido");
                alert.show();
            }else{
                Parent root= FXMLLoader.load(getClass().getResource("../Tabla/tabla.fxml"));
                Scene scene= new Scene(root);
                Main.stage.setScene(scene);
            }

        }


    }
}
