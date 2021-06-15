package sample.models;

import javafx.beans.property.SimpleStringProperty;

public class Fila {
    private SimpleStringProperty id;
    private SimpleStringProperty nombre;
    private SimpleStringProperty apellido_p;
    private SimpleStringProperty edad;
    private SimpleStringProperty sintomas;

    public Fila(String id, String nombre, String apellido_p, String edad, String sintomas) {
        this.id = new SimpleStringProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido_p = new SimpleStringProperty(apellido_p);
        this.edad = new SimpleStringProperty(edad);
        this.sintomas = new SimpleStringProperty(sintomas);

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

    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getApellido_p() {
        return apellido_p.get();
    }

    public SimpleStringProperty apellido_pProperty() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p.set(apellido_p);
    }

    public String getEdad() {
        return edad.get();
    }

    public SimpleStringProperty edadProperty() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad.set(edad);
    }

    public String getSintomas() {
        return sintomas.get();
    }

    public SimpleStringProperty sintomasProperty() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas.set(sintomas);
    }
}
