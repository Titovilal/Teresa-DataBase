package Modelo;

/**
 *
 * @author Salva Castells Juan
 */
public class Cia {
    private String nombreCia,espectaculos,genero;
    private Cliente cliente;

    public String getNombreCia() {
        return nombreCia;
    }

    public void setNombreCia(String nombreCia) {
        this.nombreCia = nombreCia;
    }

    public String getEspectaculos() {
        return espectaculos;
    }

    public void setEspectaculos(String espectaculos) {
        this.espectaculos = espectaculos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
