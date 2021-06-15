package sample.ClinicaMyB;

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
import sample.models.FilaC;
import sample.models.conexion;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class clinicamyb {
    @FXML
    TextField eliminarnombre, eliminarcapacidad, eliminarcalle, eliminarnumero;
    @FXML
    TextField txnombreM, txnombreR;
    @FXML
    TextField txcapacidadM, txcapacidadR;
    @FXML
    TextField txcalleM, txcalleR;
    @FXML
    TextField txnumeroM, txnumeroR;
    private sample.models.conexion conexion;
    TableColumn colId = new TableColumn("ID");
    TableColumn colClinica = new TableColumn("NOMBRE_CLINICA");
    TableColumn colCapacidad = new TableColumn("CAPACIDAD");
    TableColumn colCalle = new TableColumn("CALLE");
    TableColumn colNumero = new TableColumn("NUMERO_#");

    @FXML
    TableView tabla;
    ObservableList<FilaC> datosTabla = FXCollections.observableArrayList();

    @FXML
    protected void initialize() throws SQLException {
        conexion = new conexion();
        colId.setMinWidth(120);
        colClinica.setMinWidth(120);
        colCapacidad.setMinWidth(120);
        colCalle.setMinWidth(120);
        colNumero.setMinWidth(120);
        //LIGAR COLUNA CON FILA
        colId.setCellValueFactory(new PropertyValueFactory<FilaC, String>("id"));
        colClinica.setCellValueFactory(new PropertyValueFactory<FilaC, String>("nombre_clinica"));
        colCapacidad.setCellValueFactory(new PropertyValueFactory<FilaC, String>("capacidad"));
        colCalle.setCellValueFactory(new PropertyValueFactory<FilaC, String>("calle"));
        colNumero.setCellValueFactory(new PropertyValueFactory<FilaC, String>("numero"));
        tabla.getColumns().addAll(colId, colClinica, colCapacidad, colCalle, colNumero);
        recargar();
        tabla.setItems(datosTabla);
    }

    public void recargar() throws SQLException {
        ResultSet res = conexion.consultar("SELECT * from clinicas order by id DESC");
        datosTabla.clear();
        if (res != null) {
            while (res.next()) {
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

    public void atras(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Clinica/clinica.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);

    }



    public void eliminar(ActionEvent event) throws SQLException {

        if (!eliminarnombre.getText().trim().equals("")) {
            String n = eliminarnombre.getText();
            conexion.insmodel("DELETE FROM clinicas WHERE nombre_clinica = ('" + n + "')");
            eliminarnombre.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Registro Borrado con exito");
            alert.show();
            recargar();

        }

        if (!eliminarcapacidad.getText().trim().equals("")) {
            String n = eliminarcapacidad.getText();
            conexion.insmodel("DELETE FROM clinicas WHERE capacidad = ('" + n + "')");
            eliminarcapacidad.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Registro Borrado con exito");
            alert.show();
            recargar();

        }

        if (!eliminarcalle.getText().trim().equals("")) {
            String n = eliminarcalle.getText();
            conexion.insmodel("DELETE FROM clinicas WHERE calle = ('" + n + "')");
            eliminarcalle.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Registro Borrado con exito");
            alert.show();
            recargar();

        }

        if (!eliminarnumero.getText().trim().equals("")) {
            String n = eliminarnumero.getText();
            conexion.insmodel("DELETE FROM clinicas WHERE numero = ('" + n + "')");
            eliminarnumero.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Registro Borrado con exito");
            alert.show();
            recargar();

        } /*else if (eliminarnombre.getText().trim().equals("") && eliminarcapacidad.getText().trim().equals("") && eliminarcalle.getText().trim().equals("") && eliminarnumero.getText().trim().equals("")) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("favor de llenar los campos");
            alert.show();
        }
*/

    }

    public void modname(ActionEvent event) throws SQLException {
        //Para modidficar los regristos
        if (!txnombreM.getText().trim().equals("") && !txnombreR.getText().trim().equals("")) {

            String m = txnombreM.getText();
            String r = txnombreR.getText();

            conexion.insmodel("UPDATE clinicas set nombre_clinica = ('" + r + "') WHERE nombre_clinica =  ('" + m + "')");
            txnombreM.setText("");
            txnombreR.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Actualizacion del nombre_clinica completa");
            alert.show();
            recargar();
        }else if (txnombreM.getText().trim().equals("") && txcapacidadM.getText().trim().equals("") && txcalleM.getText().trim().equals("") && txcalleM.getText().trim().equals("")) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("favor de llenar los campos");
            alert.show();
        }
    }


    public void modcap(ActionEvent event) throws SQLException {
        if (!txcapacidadM.getText().trim().equals("") && !txcapacidadR.getText().trim().equals("")) {

            String m = txcapacidadM.getText();
            String r = txcapacidadR.getText();

            conexion.insmodel("UPDATE clinicas set capacidad = ('" + r + "') WHERE capacidad =  ('" + m + "')");
            txcapacidadM.setText("");
            txcapacidadR.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Actualizacion de capacidad completa");
            alert.show();
            recargar();
        }else if (txnombreM.getText().trim().equals("") && txcapacidadM.getText().trim().equals("") && txcalleM.getText().trim().equals("") && txcalleM.getText().trim().equals("")) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("favor de llenar los campos");
            alert.show();
        }
    }
    public void modcalle(ActionEvent event) throws SQLException {

        if (!txcalleM.getText().trim().equals("") && !txcalleR.getText().trim().equals("")) {

            String m = txcalleM.getText();
            String r = txcalleR.getText();

            conexion.insmodel("UPDATE clinicas set calle = ('" + r + "') WHERE calle =  ('" + m + "')");
            txcalleM.setText("");
            txcalleR.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Actualizacion del calle completa");
            alert.show();
            recargar();
        }else if (txnombreM.getText().trim().equals("") && txcapacidadM.getText().trim().equals("") && txcalleM.getText().trim().equals("") && txcalleM.getText().trim().equals("")) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("favor de llenar los campos");
            alert.show();
        }
    }
    public void modnumero(ActionEvent event) throws SQLException {
        if (!txnumeroM.getText().trim().equals("")&&!txnumeroR.getText().trim().equals("")) {

            String m = txnumeroM.getText();
            String r = txnumeroR.getText();

            conexion.insmodel("UPDATE clinicas set numero = ('"+r+"') WHERE numero =  ('"+m+"')");
            txnumeroM.setText("");
            txnumeroR.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setContentText("Actualizacion del nombre completa");
            alert.show();
            recargar();
        }else if (txnombreM.getText().trim().equals("") && txcapacidadM.getText().trim().equals("") && txcalleM.getText().trim().equals("") && txcalleM.getText().trim().equals("")) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("favor de llenar los campos");
            alert.show();
        }

    }

}

