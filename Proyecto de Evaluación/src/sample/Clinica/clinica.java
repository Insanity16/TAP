package sample.Clinica;

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
import sample.models.FilaC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;


public class clinica {
    @FXML
    TextField txtnombre,txtcapaciodad,txtxcalle,txtxnumero;

    private sample.models.conexion conexion;
    TableColumn colId=new TableColumn("ID");
    TableColumn colNombre_Clinica=new TableColumn("NOMBRE_CLINICA");
    TableColumn colCapacidad=new TableColumn("CAPACIDAD");
    TableColumn colCalle=new TableColumn("CALLE");
    TableColumn colNumero=new TableColumn("NUMERO_#");

    @FXML TableView tabla;
    ObservableList<FilaC> datosTabla= FXCollections.observableArrayList();
    @FXML protected void initialize() throws SQLException {
        conexion=new conexion();
        colId.setMinWidth(120);
        colNombre_Clinica.setMinWidth(120);
        colCapacidad.setMinWidth(120);
        colCalle.setMinWidth(120);
        colNumero.setMinWidth(120);
        //LIGAR COLUNA CON FILA
        colId.setCellValueFactory(new PropertyValueFactory<FilaC,String>("id"));
        colNombre_Clinica.setCellValueFactory(new PropertyValueFactory<FilaC,String>("nombre_clinica"));
        colCapacidad.setCellValueFactory(new PropertyValueFactory<FilaC,String>("capacidad"));
        colCalle.setCellValueFactory(new PropertyValueFactory<FilaC,String>("calle"));
        colNumero.setCellValueFactory(new PropertyValueFactory<FilaC,String>("numero"));
        tabla.getColumns().addAll(colId,colNombre_Clinica,colCapacidad,colCalle,colNumero);
        recargar();
        tabla.setItems(datosTabla);
    }
    public void recargar() throws SQLException {

        ResultSet res=conexion.consultar("SELECT * from clinicas order by id DESC");
        datosTabla.clear();
        if(res != null){
            while (res.next()){
                datosTabla.add(new FilaC(
                        res.getObject("id").toString(),
                        res.getObject("nombre_clinica").toString(),
                        res.getObject("capacidad").toString(),
                        res.getObject("calle").toString(),
                        res.getObject("numero").toString()

                ));
            }
        }

    }
    public void login (ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Login/login.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);

    }
    public void pacientes (ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../Tabla/tabla.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);

    }
    public void mod (ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../ClinicaMyB/clinicamyb.fxml"));
        Scene scene= new Scene(root);
        Main.stage.setScene(scene);

    }

    public void insertar (ActionEvent event) throws SQLException {
        if (!txtnombre.getText().trim().equals("")&&!txtcapaciodad.getText().trim().equals("")&&
                !txtxcalle.getText().trim().equals("")&&!txtxnumero.getText().trim().equals("")){
            String n=txtnombre.getText();
            String p=txtcapaciodad.getText();
            String c=txtxcalle.getText();
            String s=txtxnumero.getText();
            conexion.insmodel("INSERT INTO clinicas (nombre_clinica,capacidad,calle,numero) VALUES ('"+n+"','"+p+"','"+c+"','"+s+"')");
            System.out.println("INSERT INTO clinicas (nombre_clinica,capacidad,calle,numero) VALUES ('"+n+"','"+p+"',"+c+",'"+s+"')");
            txtnombre.setText("");
            txtcapaciodad.setText("");
            txtxcalle.setText("");
            txtxnumero.setText("");
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Registo exitoso");
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
