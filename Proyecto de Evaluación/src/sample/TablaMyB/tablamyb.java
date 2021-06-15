package sample.TablaMyB;

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


public class tablamyb {
    @FXML
    TextField eliminarnombre, eliminarapellido, eliminaredad, eliminarsintomas;
    @FXML
    TextField txnombreM, txnombreR;
    @FXML
    TextField txapellidoM, txapellidoR;
    @FXML
    TextField txedadM, txedadR;
    @FXML
    TextField txsintomasM, txsintomasR;
    private sample.models.conexion conexion;
    TableColumn colId = new TableColumn("ID");
    TableColumn colNombre = new TableColumn("NOMBRE");
    TableColumn colApe = new TableColumn("APEllIDO_P");
    TableColumn colEdad = new TableColumn("EDAD");
    TableColumn colSintomas = new TableColumn("SINTOMAS");

    @FXML
    TableView tabla;
    ObservableList<Fila> datosTabla = FXCollections.observableArrayList();

    @FXML
    protected void initialize() throws SQLException {
        conexion = new conexion();
        colId.setMinWidth(100);
        colNombre.setMinWidth(100);
        colApe.setMinWidth(100);
        colEdad.setMinWidth(100);
        colSintomas.setMinWidth(195);
        //LIGAR COLUNA CON FILA
        colId.setCellValueFactory(new PropertyValueFactory<Fila, String>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Fila, String>("nombre"));
        colApe.setCellValueFactory(new PropertyValueFactory<Fila, String>("apellido_p"));
        colEdad.setCellValueFactory(new PropertyValueFactory<Fila, String>("edad"));
        colSintomas.setCellValueFactory(new PropertyValueFactory<Fila, String>("sintomas"));
        tabla.getColumns().addAll(colId, colNombre, colApe, colEdad, colSintomas);
        recargar();
        tabla.setItems(datosTabla);
    }

    public void recargar() throws SQLException {
        ResultSet res = conexion.consultar("SELECT * from pacientes order by id DESC");
        datosTabla.clear();
        if (res != null) {
            while (res.next()) {
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

    public void atras(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Tabla/tabla.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);

    }



    public void eliminar(ActionEvent event) throws SQLException {

        if (!eliminarnombre.getText().trim().equals("")) {
            String n = eliminarnombre.getText();
            conexion.insmodel("DELETE FROM pacientes WHERE nombre = ('" + n + "')");
            eliminarnombre.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Registro Borrado con exito");
            alert.show();
            recargar();

        }

        if (!eliminarapellido.getText().trim().equals("")) {
            String n = eliminarapellido.getText();
            conexion.insmodel("DELETE FROM pacientes WHERE apellido_p = ('" + n + "')");
            eliminarapellido.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Registro Borrado con exito");
            alert.show();
            recargar();

        }

        if (!eliminaredad.getText().trim().equals("")) {
            String n = eliminaredad.getText();
            conexion.insmodel("DELETE FROM pacientes WHERE edad = ('" + n + "')");
            eliminaredad.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Registro Borrado con exito");
            alert.show();
            recargar();

        }

        if (!eliminarsintomas.getText().trim().equals("")) {
            String n = eliminarsintomas.getText();
            conexion.insmodel("DELETE FROM pacientes WHERE sintomas = ('" + n + "')");
            eliminarsintomas.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Registro Borrado con exito");
            alert.show();
            recargar();

        } else if (eliminarnombre.getText().trim().equals("") && eliminarapellido.getText().trim().equals("") && eliminaredad.getText().trim().equals("") && eliminarsintomas.getText().trim().equals("")) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("favor de llenar los campos");
            alert.show();
        }


    }

    public void modname(ActionEvent event) throws SQLException {
        //Para modidficar los regristos
        if (!txnombreM.getText().trim().equals("") && !txnombreR.getText().trim().equals("")) {

            String m = txnombreM.getText();
            String r = txnombreR.getText();

            conexion.insmodel("UPDATE pacientes set nombre = ('" + r + "') WHERE nombre =  ('" + m + "')");
            txnombreM.setText("");
            txnombreR.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Actualizacion del nombre completa");
            alert.show();
            recargar();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("favor de llenar los campos");
            alert.show();
        }
    }
    public void modape(ActionEvent event) throws SQLException {
        if (!txapellidoM.getText().trim().equals("") && !txapellidoR.getText().trim().equals("")) {

            String m = txapellidoM.getText();
            String r = txapellidoR.getText();

            conexion.insmodel("UPDATE pacientes set apellido_p = ('" + r + "') WHERE apellido_p =  ('" + m + "')");
            txapellidoM.setText("");
            txapellidoR.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Actualizacion del nombre completa");
            alert.show();
            recargar();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("favor de llenar los campos");
            alert.show();
        }
    }
    public void modedad(ActionEvent event) throws SQLException {

        if (!txedadM.getText().trim().equals("") && !txedadR.getText().trim().equals("")) {

            String m = txedadM.getText();
            String r = txedadR.getText();

            conexion.insmodel("UPDATE pacientes set edad = ('" + r + "') WHERE edad =  ('" + m + "')");
            txedadM.setText("");
            txedadR.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Actualizacion del nombre completa");
            alert.show();
            recargar();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("favor de llenar los campos");
            alert.show();
        }
    }
    public void modsintomas(ActionEvent event) throws SQLException {
        if (!txsintomasM.getText().trim().equals("")&&!txsintomasR.getText().trim().equals("")) {

            String m = txsintomasM.getText();
            String r = txsintomasR.getText();

            conexion.insmodel("UPDATE pacientes set sintomas = ('"+r+"') WHERE sintomas =  ('"+m+"')");
            txsintomasM.setText("");
            txsintomasR.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Actualizacion del nombre completa");
            alert.show();
            recargar();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("favor de llenar los campos");
            alert.show();
        }

    }

}

