package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Salva Castells Juan
 */
public class Cliente {

    private ArrayList<String> datos;

    /*  CLIENTE AGENDA CLIENTES
             * 0    ID
             * 1    NOMBRE
             * 2    TELEFONO MOVIL
             * 3    TELEFONO FIJO
             * 4    CORREO
             * 5    DIRECCION
             * 6    LOCALIDAD
             * 7    PROVINCIA / COMUNIDAD
             * 8    OCUPACION
             * 9    NOMBRE TEATRO
             * 10   NOMBRE CIRCUITO O DIPUTACION
             * 11   CHAR RED NACIONAL   S   N
             * 12   TIPO DE PROGRAMACION
             * 13   WEB
             * 14   ESPACIOS COMPRADOS
             * 15   OBSERVACIONES
             * 16   CHAR CIRCUITO O DIPUTACION C    D
             * 17   CORREO 2
     */
    public Cliente() {
        datos = new ArrayList<>();
    }

    public ArrayList<String> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<String> datos) {
        this.datos = datos;
    }

    public void setOneDato(String l) {
        datos.add(l);
    }
}
