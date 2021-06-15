package sample.models;

import javafx.beans.property.SimpleStringProperty;

public class FilaC {
    private SimpleStringProperty id;
    private SimpleStringProperty nombre_clinica;
    private SimpleStringProperty capacidad;
    private SimpleStringProperty calle;
    private SimpleStringProperty numero;

    public FilaC(String id, String nombre_clinica, String capacidad, String calle, String numero) {
        this.id = new SimpleStringProperty(id);
        this.nombre_clinica = new SimpleStringProperty(nombre_clinica);
        this.capacidad = new SimpleStringProperty(capacidad);
        this.calle = new SimpleStringProperty(calle);
        this.numero = new SimpleStringProperty(numero);

    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getNombre_clinica() {
        return nombre_clinica.get();
    }

    public SimpleStringProperty nombre_clinicaProperty() {
        return nombre_clinica;
    }

    public void setNombre_clinica(String nombre_clinica) {
        this.nombre_clinica.set(nombre_clinica);
    }

    public String getCapacidad() {
        return capacidad.get();
    }

    public SimpleStringProperty capacidadProperty() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad.set(capacidad);
    }

    public String getCalle() {
        return calle.get();
    }

    public SimpleStringProperty calleProperty() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle.set(calle);
    }

    public String getNumero() {
        return numero.get();
    }

    public SimpleStringProperty numeroProperty() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero.set(numero);
    }
}
