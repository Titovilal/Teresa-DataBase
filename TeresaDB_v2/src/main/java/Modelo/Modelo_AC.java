package Modelo;

import Vista.Clientes.CajaCliente;
import Vista.Clientes.Panel_AC;
import Vista.Clientes.VentanaPerfilCliente;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.floor;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author Salva Castells Juan
 */
public class Modelo_AC {

    //MANEJO DE FICHEROS
    private static final String RUTA_FICHERO = "C:\\TeresaDB\\clientes.txt";
    private static final String RUTA_DESCARGA = "C:\\TeresaDB\\";
    private static final String NOMBRE_FICHERO = "clientes.txt";

    //NUBE DE GOOGLE DRIVE
    private ModeloDrive drive;

    //OBJETOS DEL PANEL DE CLIENTES
    public Panel_AC panelAC;
    public VentanaPerfilCliente vpc;
    public ArrayList<CajaCliente> cajaclientes, cajaclientes1;
    public CajaCliente cajaCliente;
    private JPanel panelContenedor;
    private JButton ok;

    //VARIABLES EN MEMORIA
    private ArrayList<Cliente> clientes;
    private boolean inicio = true;
    public boolean mod = false;

    public Modelo_AC() {
        //1.-Inicializamos las variables en memoria
        clientes = new ArrayList<>();
        //2.-Descargamos la BD en forma de fichero y la pasamos a memoria
        drive = new ModeloDrive();
        drive.bajarArchivo(drive.conectar(), NOMBRE_FICHERO, RUTA_DESCARGA);
        leerFicheroClientes();

        //3.-Inicializamos los objetos con los que vamos a trabajar
        panelAC = new Panel_AC();
        panelContenedor = new JPanel();
        cajaclientes = new ArrayList<>();
        cajaclientes1 = new ArrayList<>();
        vpc = new VentanaPerfilCliente();
        ok = new JButton();
        ok.setActionCommand("9");
        for (Cliente c : clientes) {
            cajaCliente = new CajaCliente();
            cajaclientes.add(cajaCliente);
        }
        jTextPluginNombreZonas(panelAC.textNombreZona);
        jTextPluginNombreZonas(vpc.textProvCom);
    }

    public void setActionListener(ActionListener al) {
        ok.addActionListener(al);
        panelAC.setActionListener(al);
        vpc.setActionListener(al);
        for (CajaCliente c : cajaclientes) {
            c.setActionListener(al);
        }
        //4.-Indicamos al usuario que ha cargado el programa y ya puede iniciar sesion
        ok.doClick();
    }

    public void setCajaListener(ActionListener al) {
        cajaclientes.get(cajaclientes.size() - 1).setActionListener(al);
    }

    /**
     * Crea un JPanel y muestra un breve contenido de cada cliente
     */
    public void rellenarPanelClientes() {
        panelContenedor.removeAll();

        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
        panelContenedor.setSize(685, 485);
        panelContenedor.setPreferredSize(new Dimension(685, 132 * clientes.size()));//144
        panelAC.scrollPaneMain.setViewportView(panelContenedor);

        //Añade Informacion a las cajas de los clientes
        for (int i = 0; i < clientes.size(); i++) {
            cajaclientes.get(i).setDatos(clientes.get(i).getDatos());
            panelContenedor.add(cajaclientes.get(i));
        }
        //Elimina las cajas vacias para evitar psoibles errores de búsqueda
        if (clientes.size() < cajaclientes.size()) {
            for (int i = clientes.size(); i < cajaclientes.size(); i++) {
                cajaclientes.remove(i);
            }
        }
        panelAC.revalidate();
        panelAC.repaint();
    }

    public void rellenarPanelClientesv2(String seleccion, String idCliente) {
        int j = 0, ultimoCliente, numCaja;
        boolean encontrado = false;
        if (inicio == true) {
            //panelContenedor.removeAll();
            panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
            panelContenedor.setSize(685, 485);
            panelContenedor.setPreferredSize(new Dimension(685, 133 * clientes.size()));//144
            panelAC.scrollPaneMain.setViewportView(panelContenedor);

            //Añade Informacion a las cajas de los clientes
            for (int i = 0; i < clientes.size(); i++) {
                cajaclientes.get(i).setDatos(clientes.get(i).getDatos());
                panelContenedor.add(cajaclientes.get(i));
            }
            panelAC.revalidate();
            panelAC.repaint();
            inicio = false;
        } else {
            switch (seleccion) {

                case "Add":
                    //Añade Informacion a la caja de un cliente
                    ultimoCliente = clientes.size() - 1;
                    System.out.println(clientes.get(ultimoCliente).getDatos().get(0));
                    cajaclientes.get(ultimoCliente).setDatos(clientes.get(ultimoCliente).getDatos());
                    panelContenedor.add(cajaclientes.get(ultimoCliente));
                    System.out.println("funciona");
                    panelAC.revalidate();
                    panelAC.repaint(); //No se si hay que quitarlo
                    break;
                case "Mod":
                    while (encontrado == false && j < clientes.size()) {
                        if (idCliente.equals(cajaclientes.get(j).getId())) {
                            //Edita la informacion de la caja de un cliente
                            numCaja = j;
                            cajaclientes.remove(numCaja);
                            cajaclientes.add(new CajaCliente());
                            cajaclientes.get(cajaclientes.size() - 1).setDatos(clientes.get(numCaja).getDatos());
                            System.out.println("funciona");

                            panelAC.revalidate();
                            panelAC.repaint();
                            encontrado = true;
                        }
                        j++;
                    }

                    break;
                case "Del":
                    while (encontrado == false && j < clientes.size()) {
                        if (idCliente.equals(cajaclientes.get(j).getId())) {
                            //Elimina la caja de un cliente
                            numCaja = j;
                            panelContenedor.remove(cajaclientes.get(numCaja));
                            System.out.println("id:" + cajaclientes.get(j).getId());
                            System.out.println("funciona");
                            panelAC.revalidate();
                            panelAC.repaint();
                            encontrado = true;
                        }
                        j++;
                    }
                    break;
            }
        }
    }

    /**
     * Rellena el panel clientes con una serie de criterios de busqueda
     *
     * @param nombre Nombre de la persona
     * @param nombreZona Nombre de la comunidad o provincia
     * @param redNacional bool si está en la red nacional
     */
    public void filtrarPanelClientes(String nombre, String nombreZona, boolean redNacional) {

        String codigo, bNombrePersona = "N", bNombreZona = "Z", bRedNacional = "R";
        boolean filtrar = true, encontrado = false;
        int contador = 0;

        if ("".equals(nombre) || " ".equals(nombre)) {
            bNombrePersona += "0";
        } else {
            bNombrePersona += "1";
        }
        if ("".equals(nombreZona) || " ".equals(nombreZona)) {
            bNombreZona += "0";
        } else {
            bNombreZona += "1";
        }
        if (!redNacional) {
            bRedNacional += "0";
        } else {
            bRedNacional += "1";
        }

        codigo = bNombrePersona + bNombreZona + bRedNacional;

        switch (codigo) {

            case "N0Z0R0":  //Todos los clientes y no repinta el panel
                rellenarPanelClientes();
                filtrar = false;
                break;

            case "N0Z0R1":  //Solo Red Nacional
                cajaclientes1.clear();
                while (contador < cajaclientes.size() && encontrado == false) {

                    if (cajaclientes.get(contador).getDatos().get(11).equals("s")) {
                        cajaclientes1.add(cajaclientes.get(contador));
                        encontrado = true;
                    }
                    contador++;
                }
                break;

            case "N0Z1R0":  //Solo Nombre de Zona
                cajaclientes1.clear();
                for (CajaCliente c : cajaclientes) {
                    nombreZona = nombreZona.substring(0, 1).toUpperCase() + nombreZona.substring(1);
                    if (c.getDatos().get(7).equals(nombreZona)) {
                        cajaclientes1.add(c);
                    }
                }
                break;

            case "N1Z0R0":  // Solo Nombre Cliente
                cajaclientes1.clear();
                nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
                for (CajaCliente c : cajaclientes) {
                    if (c.getDatos().get(1).contains(nombre)) {
                        cajaclientes1.add(c);
                    }
                }
                break;

            case "N0Z1R1":  //Nombre de Zona + Red Nacional
                cajaclientes1.clear();
                nombreZona = nombreZona.substring(0, 1).toUpperCase() + nombreZona.substring(1);
                for (CajaCliente c : cajaclientes) {
                    if (c.getDatos().get(7).equals(nombreZona)) {
                        if (c.getDatos().get(11).equals("s")) {
                            cajaclientes1.add(c);
                        }
                    }
                }
                break;

            case "N1Z0R1":  //Nombre Cliente + Red Nacional
                cajaclientes1.clear();
                nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
                for (CajaCliente c : cajaclientes) {
                    if (c.getDatos().get(1).contains(nombre)) {
                        if (c.getDatos().get(11).equals("s")) {
                            cajaclientes1.add(c);
                        }
                    }
                }
                break;

            case "N1Z1R0":  // Nombre Cliente + Nombre de Zona
                cajaclientes1.clear();
                nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
                nombreZona = nombreZona.substring(0, 1).toUpperCase() + nombreZona.substring(1);
                for (CajaCliente c : cajaclientes) {
                    if (c.getDatos().get(1).equals(nombre)) {
                        if (c.getDatos().get(7).equals(nombreZona)) {
                            cajaclientes1.add(c);
                        }
                    }
                }
                break;

            case "N1Z1R1":  //  Nombre Cliente + Nombre de zona + Red Nacional
                cajaclientes1.clear();
                nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
                nombreZona = nombreZona.substring(0, 1).toUpperCase() + nombreZona.substring(1);
                for (CajaCliente c : cajaclientes) {
                    if (c.getDatos().get(1).contains(nombre)) {
                        if (c.getDatos().get(7).equals(nombreZona)) {
                            if (c.getDatos().get(11).equals("s")) {
                                cajaclientes1.add(c);
                            }
                        }
                    }
                }
                break;
        }

        if (filtrar == true) {

            panelContenedor.removeAll();
            panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
            panelContenedor.setSize(685, 485);
            panelContenedor.setPreferredSize(new Dimension(685, 133 * cajaclientes1.size()));
            panelAC.scrollPaneMain.setViewportView(panelContenedor);

            for (CajaCliente c : cajaclientes1) {
                panelContenedor.add(c);
            }
            panelAC.revalidate();
            panelAC.repaint();
        }
    }

    /**
     * Elegir numero aleatorio entre un maximo y un minimo
     *
     * @param min cota minima
     * @param max cota maxima
     * @return numero aleatorio entre cotas
     */
    public int numeroRandom(int min, int max) {
        int numero = (int) floor(random() * (max - min + 1) + min);
        return numero;
    }

    public int getSize() {
        return clientes.size();
    }

    /**
     * Transforma un string en un array
     *
     * @param str
     * @return
     */
    public ArrayList<String> toVector(String str) {
        ArrayList<String> k = new ArrayList<>();
        String dato = "";
        for (int i = 0; i < str.length(); i++) {

            //Si el char no es un $ pero el siguiente si guarda el dato
            if (str.charAt(i) != '$' && str.charAt(i + 1) == '$') {
                dato = dato + str.charAt(i);
                k.add(dato);
                dato = "";

            } //Si hay 2 $ juntos se guarda el dato (null)
            else if (str.charAt(i) == '$') {

                if ((i + 1) == str.length()) {

                } else if (str.charAt(i + 1) == '$') {
                    k.add(dato);
                    dato = "";
                }
            } else {

                if (str.charAt(i) != '$') {
                    //si el char no es un $ lo añade al string
                    dato = dato + str.charAt(i);
                }
            }
        }
        return k;
    }

    // <editor-fold defaultstate="collapsed" desc="Funciones Cliente: Add / Edit / Del / GenID ">
    /**
     * Añade un cliente al vector de clientes
     *
     * @param datos
     */
    public void addCliente(ArrayList<String> datos) {
        Cliente c = new Cliente();
        c.setDatos(datos);
        clientes.add(c);
    }

    /**
     * Genera una id diferente a la de todos los clientes
     *
     * @return String id
     */
    public String generarIdCliente() {
        boolean diferente;
        String id = "";

        do {
            diferente = true;
            id = String.valueOf(numeroRandom(0, 9999));
            for (Cliente c : clientes) {
                if (c.getDatos().get(0).equals(id)) {
                    diferente = false;
                }
            }
        } while (diferente == false);
        return id;
    }

    /**
     * Elimina un cliente del array de clientes
     *
     * @param id
     */
    public void eliminarCliente(String id) {
        int n = 0, s = 0;
        boolean eliminar = false;

        for (Cliente cliente : clientes) {
            if (cliente.getDatos().get(0).equals(id)) {
                s = n;
                eliminar = true;
            }
            n++;
        }
        if (eliminar == true) {
            clientes.remove(clientes.get(s));
        }
    }

    /**
     * Edita los datos de un cliente a través de su ID
     *
     * @param datos
     */
    public void editarCliente(ArrayList<String> datos) {
        for (Cliente c : clientes) {
            if (c.getDatos().get(0).equals(datos.get(0))) {
                c.setDatos(datos);
            }
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Leer y Guardar Fichero ">
    /**
     * Lee un fichero y lo transforma en un vector de clientes con todos sus
     * datos
     *
     */
    @SuppressWarnings("ConvertToTryWithResources")
    public final void leerFicheroClientes() {

        try {
            String linea, dato = "";
            BufferedReader br = new BufferedReader(new FileReader(new File(RUTA_FICHERO)));
            while ((linea = br.readLine()) != null) {
                Cliente cliente = new Cliente();
                for (int i = 0; i < linea.length(); i++) {

                    //Si el char no es un asterisco pero el siguiente si guarda el dato
                    if (linea.charAt(i) != '*' && linea.charAt(i + 1) == '*') {
                        dato = dato + linea.charAt(i);
                        cliente.setOneDato(dato);
                        dato = "";

                    } //Si hay 2 asteriscos juntos se guarda el dato (null)
                    else if (linea.charAt(i) == '*') {

                        if ((i + 1) == linea.length()) {

                        } else if (linea.charAt(i + 1) == '*') {
                            cliente.setOneDato(dato);
                            dato = "";
                        }
                    } else {

                        if (linea.charAt(i) != '*') {
                            //si el char no es un asterisco lo añade al string
                            dato = dato + linea.charAt(i);
                        }
                    }
                }
                clientes.add(cliente);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error leer fichero cliente" + e);
        }
    }

    /**
     * Guarda el fichero clientes de forma adecuada creo
     */
    public void guardarFicheroClientes() {
        try {
            PrintWriter pw = new PrintWriter(new File(RUTA_FICHERO));
            pw.close();
            pw = new PrintWriter(new FileWriter(new File(RUTA_FICHERO), true));

            for (Cliente c : clientes) {
                for (int i = 0; i < 18; i++) {
                    pw.append(c.getDatos().get(i) + "*");
                }
                pw.append("\n");
            }
            pw.close();

        } catch (IOException ex) {
            Logger.getLogger(Modelo_AC.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se ha podido guardar el "
                    + "fichero donde se almacenan los clientes");
        }
    }

    /**
     *
     */
    public void subirFicheroClientes() {
        guardarFicheroClientes();
        drive.subirArchivo(drive.conectar(), NOMBRE_FICHERO, RUTA_FICHERO);
        mod = false;
    }
    // </editor-fold>

    private void jTextPluginNombreZonas(javax.swing.JTextField jTextFieldName) {
        ArrayList<String> keywords = new ArrayList<>();

        //TODAS LAS PROVINCIAS DE ESPAÑA
        keywords.add("a coruna");
        keywords.add("alava");
        keywords.add("albacete");
        keywords.add("alicante");
        keywords.add("almeria");
        keywords.add("asturias");
        keywords.add("avila");
        keywords.add("badajoz");
        keywords.add("baleares");
        keywords.add("barcelona");
        keywords.add("burgos");
        keywords.add("caceres");
        keywords.add("cadiz");
        keywords.add("cantabria");
        keywords.add("castellon");
        keywords.add("ceuta");
        keywords.add("ciudad real");
        keywords.add("cordoba");
        keywords.add("cuenca");
        keywords.add("girona");
        keywords.add("granada");
        keywords.add("guadalajara");
        keywords.add("guipuzcoa");
        keywords.add("huelva");
        keywords.add("huesca");
        keywords.add("jaen");
        keywords.add("la rioja");
        keywords.add("las palmas");
        keywords.add("leon");
        keywords.add("lleida");
        keywords.add("lugo");
        keywords.add("madrid");
        keywords.add("malaga");
        keywords.add("melilla");
        keywords.add("murcia");
        keywords.add("navarra");
        keywords.add("ourense");
        keywords.add("palencia");
        keywords.add("pontevedra");
        keywords.add("salamanca");
        keywords.add("tenerife");
        keywords.add("segovia");
        keywords.add("sevilla");
        keywords.add("soria");
        keywords.add("tarragona");
        keywords.add("teruel");
        keywords.add("toledo");
        keywords.add("valencia");
        keywords.add("valladolid");
        keywords.add("vizcaya");
        keywords.add("zamora");
        keywords.add("zaragoza");

        //TODAS LAS COMUNIDADES DE ESPAÑA
        keywords.add("Andalucía");
        keywords.add("Aragón");
        keywords.add("Asturias");
        keywords.add("Baleares");
        keywords.add("Canarias");
        keywords.add("Cantabria");
        keywords.add("Castilla-La Mancha");
        keywords.add("Castilla y León");
        keywords.add("Cataluña");
        keywords.add("Comunidad Valenciana");
        keywords.add("Extremadura");
        keywords.add("Galicia");
        keywords.add("Madrid");
        keywords.add("Murcia");
        keywords.add("Navarra ");
        keywords.add("País Vasco");
        keywords.add("La Rioja");

        jTextFieldName.setFocusTraversalKeysEnabled(false);
        Autocomplete autoComplete = new Autocomplete(jTextFieldName, keywords);
        jTextFieldName.getDocument().addDocumentListener(autoComplete);
        jTextFieldName.getInputMap().put(KeyStroke.getKeyStroke("TAB"), "commit");
        jTextFieldName.getActionMap().put("commit", autoComplete.new CommitAction());
    }
}
