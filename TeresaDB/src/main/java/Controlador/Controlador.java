package Controlador;

import Modelo.Modelo;
import Modelo.ModeloDrive;
import Vista.Login;
import Vista.*;
import com.google.api.services.drive.Drive;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

/**
 *
 * @author Salva Castells Juan
 */
public class Controlador implements ActionListener {

    //VARIABLES PARA LA CONEXION CON GOOGLE DRIVE 
    private ModeloDrive modeloDrive;
    private Drive service;

    //VARIABLES PARA EL MANEJO DE ARCHIVOS
    private static final String TXTCLIENTES = "clientes.txt";
    private static final String RUTATXTCLIENTES = "C:\\TeresaDB\\clientes.txt";

    //VARIABLES DEL CONSTRUCTOR
    private Vista vista;
    private Login login;
    private Modelo modelo;

    /**
     * Constructor del controlador
     *
     * @param login
     * @param vista
     * @param modelo
     */
    public Controlador(Login login, Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.login = login;

        modeloDrive = new ModeloDrive();

        //Opcion para guardar antes de salir del programa
        vista.addWindowListener(new SalirPrograma());

        // <editor-fold defaultstate="collapsed" desc="Declaración de listeners y actioncommands">
        login.buttonEntrar.setActionCommand("buttonEntrar");
        login.buttonEntrar.addActionListener(this);
        vista.buttonAgendaClientes.setActionCommand("buttonAgendaClientes");
        vista.buttonAgendaClientes.addActionListener(this);
        vista.itemAddCliente.setActionCommand("buttonAddCliente");
        vista.itemAddCliente.addActionListener(this);
        modelo.panelAgenda.buttonAddCliente.setActionCommand("buttonAddCliente");
        modelo.panelAgenda.buttonAddCliente.addActionListener(this);
        vista.itemGuardar.setActionCommand("buttonGuardarCliente");
        vista.itemGuardar.addActionListener(this);
        vista.itemAcutalizar.setActionCommand("buttonActualizarCliente");
        vista.itemAcutalizar.addActionListener(this);
        modelo.panelAgenda.buttonAddCliente.setActionCommand("buttonAddCliente");
        modelo.panelAgenda.buttonAddCliente.addActionListener(this);
        modelo.panelAgenda.buttonBuscar.setActionCommand("buttonBuscarCliente");
        modelo.panelAgenda.buttonBuscar.addActionListener(this);
        vista.buttonCias.setActionCommand("buttonCias");
        vista.buttonCias.addActionListener(this);
        // </editor-fold>
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "buttonEntrar":
                if (login.textUser.getText().equals("teresa") && new String(login.textPassword.getPassword()).equals("teresa")) {

                    login.dispose();
                    vista.setVisible(true);

                } else {
                    login.textError.setForeground(Color.RED);
                }
                break;

            case "buttonAgendaClientes":
                modelo.panelAgenda.setSize(735, 581);
                vista.panelMain.removeAll();

                modelo.rellenarPanelClientes();
                vista.panelMain.add(modelo.panelAgenda, BorderLayout.CENTER);

                vista.panelMain.revalidate();
                vista.panelMain.repaint();
                break;

            case "buttonAddCliente":
                modelo.vpc.limpiar();
                modelo.vpc.buttonEliminar.setEnabled(false);
                modelo.vpc.buttonEditar.setText("Añadir");
                modelo.vpc.setVisible(true);
                break;

            case "buttonGuardarCliente":
                modelo.guardarFicheroClientes();
                service = modeloDrive.conectar();
                modeloDrive.subirArchivo(service, TXTCLIENTES, RUTATXTCLIENTES);
                break;

            case "buttonActualizarCliente":
                /*
                modeloDrive.bajarArchivo(modeloDrive.conectar(), TXTCLIENTES, carpetaDescargas);
                modelo.leerFicheroClientes();
                modelo.rellenarPanelClientes();
                 */
                JOptionPane.showMessageDialog(null, "Esta opcion esta deshabilitada debido a fallos por conflicto");
                break;
            case "buttonBuscarCliente":
                modelo.filtrarPanelClientes(modelo.panelAgenda.textNombre.getText(),
                        modelo.panelAgenda.textNombreZona.getText(),
                        modelo.panelAgenda.toggleRN.isSelected());
                break;

            case "buttonCias":
                modelo.panelCias.setSize(735, 581);
                vista.panelMain.removeAll();

                modelo.rellenarPanelClientes();
                vista.panelMain.add(modelo.panelCias, BorderLayout.CENTER);

                vista.panelMain.revalidate();
                vista.panelMain.repaint();
                break;
            default:
                break;
        }
    }

    /**
     * Pop up para guardar antes de salir del programa
     */
    class SalirPrograma extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {

            int i = JOptionPane.showConfirmDialog(null,
                    "¿Quieres guardar antes de salir? Será un momento",
                    "Exit with Save Dialog",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);

            switch (i) {
                case 0:
                    modelo.guardarFicheroClientes();
                    service = modeloDrive.conectar();
                    modeloDrive.subirArchivo(service, TXTCLIENTES, RUTATXTCLIENTES);
                    System.exit(0);

                case 1:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
