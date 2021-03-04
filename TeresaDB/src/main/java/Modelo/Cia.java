package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Salva Castells Juan
 */
public class Cia {

    private String id, nombreCia, correo, nombreTecnico, telefono;

    private ArrayList<Espectaculo> espectaculos;

    public Cia() {

    }

    public void addEspectaculo (Espectaculo esp){
        espectaculos.add(esp);
    }

    public ArrayList<Espectaculo> getEspectaculos() {
        return espectaculos;
    }

    public void setEspectaculos(ArrayList<Espectaculo> espectaculos) {
        this.espectaculos = espectaculos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCia() {
        return nombreCia;
    }

    public void setNombreCia(String nombreCia) {
        this.nombreCia = nombreCia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreTecnico() {
        return nombreTecnico;
    }

    public void setNombreTecnico(String nombreTecnico) {
        this.nombreTecnico = nombreTecnico;
    }
}
