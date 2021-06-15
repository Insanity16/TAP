package sample.Tabla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;
import sample.models.conexion;
import sample.models.Fila;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;


public class tabla {
    @FXML
    TextField txtnombre,txtapellido,txtedad,txtsintomas;

    private sample.models.conexion conexion;
    TableColumn colId=new TableColumn("ID");
    TableColumn colNombre=new TableColumn("NOMBRE");
    TableColumn colApe=new TableColumn("APEllIDO_P");
    TableColumn colEdad=new TableColumn("EDAD");
    TableColumn colSintomas=new TableColumn("SINTOMAS");

   @FXML TableView tabla;
    ObservableList<Fila> datosTabla= FXCollections.observableArrayList();
    @FXML protected void initialize() throws SQLException {
        conexion=new conexion();
        colId.setMinWidth(100);
        colNombre.setMinWidth(100);
        colApe.setMinWidth(100);
        colEdad.setMinWidth(100);
        colSintomas.setMinWidth(195);
        //LIGAR COLUNA CON FILA
        colId.setCellValueFactory(new PropertyValueFactory<Fila,String>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Fila,String>("nombre"));
        colApe.setCellValueFactory(new PropertyValueFactory<Fila,String>("apellido_p"));
        colEdad.setCellValueFactory(new PropertyValueFactory<Fila,String>("edad"));
        colSintomas.setCellValueFactory(new PropertyValueFactory<Fila,String>("sintomas"));
        tabla.getColumns().addAll(colId,colNombre,colApe,colEdad,colSintomas);
        recargar();
        tabla.setItems(datosTabla);
    }
   public void recargar() throws SQLException {
        ResultSet res=conexion.consultar("SELECT * from pacientes order by id DESC");
        datosTabla.clear();
        if(res != null){
            while (res.next()){
                datosTabla.add(new Fila(
                        res.getObject("id").toString(),
                        res.getObject("nombre").toString(),
                        res.getObject("apellido_p").toString(),
                        res.getObject("edad").toString(),
                        res.getObject("sintomas").toString()

                ));
            }
        }

    }
    public void login (ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Login/login.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);

    }
    public void Clinica (ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Clinica/clinica.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);

    }
    public void mod (ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../TablaMyb/tablamyb.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);

    }



    public void insertar (ActionEvent event) throws SQLException {
  if (!txtnombre.getText().trim().equals("")&&!txtapellido.getText().trim().equals("")&&
          !txtedad.getText().trim().equals("")&&!txtsintomas.getText().trim().equals("")){
      String n=txtnombre.getText();
      String p=txtapellido.getText();
      String e=txtedad.getText();
      String s=txtsintomas.getText();
conexion.insmodel("INSERT INTO pacientes (nombre,apellido_p,edad,sintomas) VALUES ('"+n+"','"+p+"',"+e+",'"+s+"')");
      System.out.println("INSERT INTO pacientes (nombre,apellido_p,edad,sintomas) VALUES ('"+n+"','"+p+"',"+e+",'"+s+"')");
      txtnombre.setText("");
      txtedad.setText("");
      txtsintomas.setText("");
      txtapellido.setText("");
      Alert alert=new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Alerta");
      alert.setContentText("Redristo exitoso");
      alert.show();
      recargar();
  }else {
      Alert alert=new Alert(Alert.AlertType.ERROR);
      alert.setTitle("ERROR");
      alert.setContentText("favor de llenar los campos");
      alert.show();

  }
    }

}
