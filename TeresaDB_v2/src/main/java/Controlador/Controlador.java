package Controlador;

import Vista.*;
import Modelo.Modelo_AC;
import Vista.Clientes.CajaCliente;
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
public class Controlador {

    private Login login;
    private Vista vista;
    private Modelo_AC modeloAC;
    private boolean autoSave = false;

    public Controlador(Login login, Vista vista, Modelo_AC modeloAC) {
        this.login = login;
        this.vista = vista;
        this.modeloAC = modeloAC;

        login.setActionListener(new ControladorAL());
        vista.setActionListener(new ControladorAL());
        vista.addWindowListener(new SalirPrograma());
        modeloAC.setActionListener(new ModeloACL());
    }

    class ControladorAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            switch (command) {
                //Seguridad para entrar al programa
                case "Login":
                    if (login.textUser.getText().equals("t") && new String(login.textPassword.getPassword()).equals("t")) {
                        login.dispose();
                        vista.setVisible(true);
                    } else {
                        login.textError.setForeground(Color.RED);
                    }
                    break;
                //Reemplazar el contenido del panel main por el Panel_AC
                case "AbrirAgendaClientes":
                    vista.panelMain.removeAll();

                    modeloAC.rellenarPanelClientes();
                    vista.panelMain.add(modeloAC.panelAC, BorderLayout.CENTER);

                    vista.panelMain.revalidate();
                    vista.panelMain.repaint();

                    break;
                //Guarda los datos de memoria en el fichero y lo sube a la nube
                case "GuardarAgendaClientes":
                    modeloAC.subirFicheroClientes();
                    break;
                //Activa el autoguardado mientras el programa esta en ejecucion
                case "AutoSave":
                    if (autoSave == true) {
                        autoSave = false;
                        vista.buttonAutoSave.setText("AutoGuardado: Apagado");
                    } else {
                        autoSave = true;
                        vista.buttonAutoSave.setText("AutoGuardado: Encendido");
                        modeloAC.subirFicheroClientes();
                    }
                    break;
            }
        }
    }

    class ModeloACL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            String str;
            switch (command.charAt(0)) {
                //Añade una CajaCliente vacia al vector de caja cliente con listener
                case '1':
                    modeloAC.cajaCliente = new CajaCliente();
                    modeloAC.cajaclientes.add(modeloAC.cajaCliente);
                    modeloAC.setCajaListener(new ModeloACL());
                    /* if (autoSave == true) {
                        modeloAC.subirFicheroClientes();
                    }*/
                    break;

                //Rellena el panel principal con la lista de clientes
                case '2':
                    modeloAC.rellenarPanelClientes();
                    //modeloAC.rellenarPanelClientesv2(command.substring(1, 4), command.substring(4));

                    if (autoSave == true) {
                        modeloAC.subirFicheroClientes();
                    }
                    break;

                //Transforma el actioncommand en un array y lo guarda en un cliente
                case '3':
                    str = command.replaceFirst("3", "");
                    modeloAC.editarCliente(modeloAC.toVector(str));
                    modeloAC.mod = true;
                    break;

                //Genera una ID aleatoria y añade un cliente al registro
                case '4':
                    str = command.replaceFirst("4", "");
                    command = str.replaceFirst("0000", String.valueOf(modeloAC.generarIdCliente()));
                    modeloAC.addCliente(modeloAC.toVector(command));
                    modeloAC.mod = true;
                    break;

                //Elimina un cliente a partir de su id
                case '5':
                    str = command.replaceFirst("5", "");
                    modeloAC.eliminarCliente(str);
                    modeloAC.mod = true;
                    break;

                //Abre la interfaz de perfil de cliente vacio.
                case '6':
                    modeloAC.vpc.limpiar();
                    modeloAC.vpc.buttonEliminar.setEnabled(false);
                    modeloAC.vpc.buttonEditar.setText("Añadir");
                    modeloAC.vpc.setEditable(true);
                    modeloAC.vpc.setVisible(true);
                    break;

                //Filtra el panel de clientes
                case '7':
                    modeloAC.filtrarPanelClientes(modeloAC.panelAC.textNombre.getText(),
                            modeloAC.panelAC.textNombreZona.getText(),
                            modeloAC.panelAC.toggleRN.isSelected());
                    break;

                //Abre la interfaz de perfil del cliente seleccionado.
                case '8':
                    str = command.replaceFirst("8", "");
                    modeloAC.vpc.limpiar();
                    modeloAC.vpc.buttonEditar.setText("Editar");
                    modeloAC.vpc.buttonEliminar.setEnabled(true);
                    modeloAC.vpc.labelRequesitos.setForeground(new Color(102, 102, 102));

                    modeloAC.vpc.setEditable(false);
                    modeloAC.vpc.setDatos(modeloAC.toVector(str));
                    modeloAC.vpc.setVisible(true);

                    break;

                //Permite al usuario entrar al programa con sus credenciales
                case '9':
                    login.buttonEntrar.setEnabled(true);
                    login.buttonEntrar.setText("Entrar");
                    break;
            }
        }
    }

    class SalirPrograma extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            if (modeloAC.mod == true) {
                int i = JOptionPane.showConfirmDialog(null,
                        "Tienes cambios sin guardar ¿Seguro que quieres salir?",
                        "Exit without saving dialog - TeatroDB v0.9",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);

                switch (i) {
                    case 0:
                        System.exit(0);

                    default:
                        break;
                }
            } else {
                System.exit(0);
            }

        }
    }
}
