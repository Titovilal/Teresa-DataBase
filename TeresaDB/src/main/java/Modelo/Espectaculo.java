package Modelo;

/**
 *
 * @author Salva Castells Juan
 */
public class Espectaculo {

    private String nombre, genero;

    public Espectaculo() {
        nombre = "";
        genero = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
