package Modelo;

import Vista.Clientes.*;
import java.awt.Dimension;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author Salva Castells Juan
 */
public class Modelo {

    //VARIABLES PARA EL MANEJO DE ARCHIVOS
    private static final String DESCARGAS = "C:\\TeresaDB\\";
    private static final String TXTCLIENTES = "clientes.txt";
    private static final String RUTATXTCLIENTES = "C:\\TeresaDB\\clientes.txt";

    //VARIABLES CONSTRUCTOR  >> AGENDA CLIENTES
    private ArrayList<Cliente> clientes;
    public ArrayList<CajaCliente> arrayCajaCliente, acc;
    private JPanel panelCajaClientes;
    private CajaCliente cajaCliente;
    public PanelAgenda panelAgenda;
    public VentanaPerfilCliente vpc;

    //CONSTROR DE LA CLASE
    public Modelo() {
        ModeloDrive modeloDrive = new ModeloDrive();

        // <editor-fold defaultstate="collapsed" desc="Inicio variables agenda clientes">
        clientes = new ArrayList<>();
        panelAgenda = new PanelAgenda();
        pluginTextField(panelAgenda.textNombreZona);
        panelCajaClientes = new JPanel();
        vpc = new VentanaPerfilCliente(this);
        arrayCajaCliente = new ArrayList<>();
        acc = new ArrayList<>();
        modeloDrive.bajarArchivo(modeloDrive.conectar(), TXTCLIENTES, DESCARGAS);
        leerFicheroClientes();
        for (Cliente c : clientes) {
            cajaCliente = new CajaCliente(this);
            arrayCajaCliente.add(cajaCliente);
        }
        // </editor-fold>
    }

    // <editor-fold defaultstate="collapsed" desc="Modelo Agenda Clientes">
    /**
     * Lee un fichero y lo transforma en un vector de clientes con todos sus
     * datos
     *
     */
    public final void leerFicheroClientes() {

        try {
            String linea, dato = "";
            System.out.println("1");
            BufferedReader br = new BufferedReader(new FileReader(new File(RUTATXTCLIENTES)));
            System.out.println("2");
            while ((linea = br.readLine()) != null) {
                Cliente cliente = new Cliente();
                System.out.println("3");
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
                System.out.println("4");
                clientes.add(cliente);
                
                System.out.println("5");
                br.close();
            }
        } catch ( Exception e) {
            //System.out.println(ex);
            //JOptionPane.showMessageDialog(null, "No se ha podido leer el fichero"
                 //   + " descargado de la nube");
        }
    }

    /**
     * Guarda el fichero clientes de forma adecuada creo
     */
    public void guardarFicheroClientes() {
        try {
            PrintWriter pw = new PrintWriter(new File(RUTATXTCLIENTES));
            pw.close();
            pw = new PrintWriter(new FileWriter(new File(RUTATXTCLIENTES), true));
            for (Cliente c : clientes) {
                for (int i = 0; i < 18; i++) {
                    pw.append(c.getDatos().get(i) + "*");
                }
                pw.append("\n");
            }
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se ha podido guardar el "
                    + "fichero donde se almacenan los clientes");
        }
    }

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

    /**
     * Crea un JPanel y muestra un berve contenido de cada cliente
     */
    public void rellenarPanelClientes() {
        panelCajaClientes.removeAll();

        panelCajaClientes.setLayout(new BoxLayout(panelCajaClientes, BoxLayout.Y_AXIS));
        panelCajaClientes.setSize(685, 485);
        panelCajaClientes.setPreferredSize(new Dimension(685, 133 * clientes.size()));//144
        panelAgenda.scrollPaneMain.setViewportView(panelCajaClientes);
        
        //Añade Informacion a las cajas de los clientes
        for (int i = 0; i < clientes.size(); i++) {

            System.out.println("Cliente " + i);

            arrayCajaCliente.get(i).setDatos(clientes.get(i).getDatos());

            panelCajaClientes.add(arrayCajaCliente.get(i));
        }
        //Elimina las cajas vacias para evitar psoibles errores de búsqueda
        if (clientes.size() < arrayCajaCliente.size()) {
            for (int i = clientes.size(); i < arrayCajaCliente.size(); i++) {
                arrayCajaCliente.remove(i);
                System.out.println("CajaCliente de sobra eliminada");
            }
        }
        
        panelAgenda.revalidate();
        panelAgenda.repaint();
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
        boolean filtrar = true;

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
                acc.clear();
                for (CajaCliente c : arrayCajaCliente) {
                    if (c.getDatos().get(11).equals("s")) {
                        acc.add(c);
                    }
                }
                break;

            case "N0Z1R0":  //Solo Nombre de Zona
                acc.clear();
                for (CajaCliente c : arrayCajaCliente) {
                    if (c.getDatos().get(7).equals(nombreZona)) {
                        acc.add(c);
                    }
                }
                break;

            case "N1Z0R0":  // Solo Nombre Cliente
                acc.clear();
                for (CajaCliente c : arrayCajaCliente) {
                    if (c.getDatos().get(1).contains(nombre)) {
                        acc.add(c);
                    }
                }
                break;

            case "N0Z1R1":  //Nombre de Zona + Red Nacional
                acc.clear();
                for (CajaCliente c : arrayCajaCliente) {
                    if (c.getDatos().get(7).equals(nombreZona)) {
                        if (c.getDatos().get(11).equals("s")) {
                            acc.add(c);
                        }
                    }
                }
                break;

            case "N1Z0R1":  //Nombre Cliente + Red Nacional
                acc.clear();
                for (CajaCliente c : arrayCajaCliente) {
                    if (c.getDatos().get(1).contains(nombre)) {
                        if (c.getDatos().get(11).equals("s")) {
                            acc.add(c);
                        }
                    }
                }
                break;

            case "N1Z1R0":  // Nombre Cliente + Nombre de Zona
                acc.clear();
                for (CajaCliente c : arrayCajaCliente) {
                    if (c.getDatos().get(1).equals(nombre)) {
                        if (c.getDatos().get(7).equals(nombreZona)) {
                            acc.add(c);
                        }
                    }
                }
                break;

            case "N1Z1R1":  //  Nombre Cliente + Nombre de zona + Red Nacional
                acc.clear();
                for (CajaCliente c : arrayCajaCliente) {
                    if (c.getDatos().get(1).contains(nombre)) {
                        if (c.getDatos().get(7).equals(nombreZona)) {
                            if (c.getDatos().get(11).equals("s")) {
                                acc.add(c);
                            }
                        }
                    }
                }
                break;
        }

        if (filtrar == true) {
            
            panelCajaClientes.removeAll();
            panelCajaClientes.setLayout(new BoxLayout(panelCajaClientes, BoxLayout.Y_AXIS));
            panelCajaClientes.setSize(685, 485);
            panelCajaClientes.setPreferredSize(new Dimension(685, 133 * acc.size()));//144
            panelAgenda.scrollPaneMain.setViewportView(panelCajaClientes);

            for (CajaCliente c : acc) {
                panelCajaClientes.add(c);
            }
            panelAgenda.revalidate();
            panelAgenda.repaint();
        }
    }
    // </editor-fold>
    
    /**
     * 
     * @param textFieldName 
     */
    public void pluginTextField (javax.swing.JTextField textFieldName){
        // Our words to complete
        ArrayList<String> keywords = new ArrayList<String>();
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

        textFieldName.setFocusTraversalKeysEnabled(false);
        AutoCompletarTexto autoComplete = new AutoCompletarTexto(textFieldName, keywords);
        textFieldName.getDocument().addDocumentListener(autoComplete);
        textFieldName.getInputMap().put(KeyStroke.getKeyStroke("TAB"), "commit");
        textFieldName.getActionMap().put("commit", autoComplete.new CommitAction());
    }
}
