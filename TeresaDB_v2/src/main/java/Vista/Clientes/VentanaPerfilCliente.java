package Vista.Clientes;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Salva Castells Juan
 */
public final class VentanaPerfilCliente extends javax.swing.JFrame {

    private String idCliente;
    private AmpliarCliente ampliar;
    private JButton aux;

    public VentanaPerfilCliente() {
        idCliente = "0000";
        ampliar = new AmpliarCliente(this);
        aux = new JButton();
        initComponents();

        this.setVisible(false);
        this.setLocationRelativeTo(null);
    }

    public void setActionListener(ActionListener al) {
        buttonEditar.addActionListener(al);
        buttonEliminar.addActionListener(al);
        aux.addActionListener(al);
    }
    // <editor-fold defaultstate="collapsed" desc="Funciones VPC: Set / Get / Clean / Exit">

    /**
     * Guarda el id en memoria y coloca los otros 17 datos del cliente en
     * disposicion de solo lectura
     *
     * @param datos Datos del cliente
     */
    public void setDatos(ArrayList<String> datos) {

        String str;
        idCliente = datos.get(0);
        textNombre.setText(datos.get(1));
        textNombre.setEditable(false);
        textNumMovil.setText(datos.get(2));
        textNumMovil.setEditable(false);
        textNumFijo.setText(datos.get(3));
        textNumFijo.setEditable(false);
        textCorreo.setText(datos.get(4));
        textCorreo.setEditable(false);
        textDireccion.setText(datos.get(5));
        textDireccion.setEditable(false);
        textLocalidad.setText(datos.get(6));
        textLocalidad.setEditable(false);
        textProvCom.setText(datos.get(7));
        textProvCom.setEditable(false);
        textOcupacion.setText(datos.get(8));
        textOcupacion.setEditable(false);
        textNombreTeatro.setText(datos.get(9));
        textNombreTeatro.setEditable(false);
        textRed.setText(datos.get(10));
        textRed.setEditable(false);
        textTipoProgramacion.setText(datos.get(12));
        textTipoProgramacion.setEditable(false);
        textWeb.setText(datos.get(13));
        textWeb.setEditable(false);
        //Transforma una linea con saltos a un texto adecuado
        if (datos.get(14).contains("#")) {
            str = datos.get(14).replaceAll("#", System.lineSeparator());
            textEspComp.setText(str);
        } else {
            textEspComp.setText(datos.get(14));
        }
        textEspComp.setEditable(false);
        //Transforma una linea con saltos a un texto adecuado
        if (datos.get(15).contains("#")) {
            str = datos.get(15).replaceAll("#", System.lineSeparator());
            textObservaciones.setText(str);
        } else {
            textObservaciones.setText(datos.get(15));
        }
        textObservaciones.setEditable(false);

        if (datos.get(11).equals("s")) {
            toggleRN.setSelected(true);
        } else {
            toggleRN.setSelected(false);
        }
        toggleRN.setEnabled(false);

        if (datos.get(16).equals("d")) {
            comboRed.setSelectedIndex(1);
            labelProvCom.setText("Provincia");
        } else {
            comboRed.setSelectedIndex(0);
            labelProvCom.setText("Comunidad");
        }
        comboRed.setEnabled(false);
        textCorreo2.setText(datos.get(17));
        textCorreo2.setEditable(false);
    }

    /**
     * Devuelve los 18 datos de un cliente
     *
     * @return
     */
    public ArrayList<String> getDatos() {

        ArrayList<String> datos = new ArrayList<>();
        String str;

        datos.add(idCliente);
        datos.add(textNombre.getText());
        datos.add(textNumMovil.getText());
        datos.add(textNumFijo.getText());
        datos.add(textCorreo.getText());
        datos.add(textDireccion.getText());
        datos.add(textLocalidad.getText());
        if (!textProvCom.getText().isEmpty()) {
            str = textProvCom.getText().substring(0, 1).toUpperCase() + textProvCom.getText().substring(1);
            datos.add(str);
        } else {
            datos.add(textProvCom.getText());
        }

        datos.add(textOcupacion.getText());
        datos.add(textNombreTeatro.getText());
        datos.add(textRed.getText());

        if (toggleRN.isSelected()) {
            datos.add("s");
        } else {
            datos.add("n");
        }

        datos.add(textTipoProgramacion.getText());
        datos.add(textWeb.getText());
        //Transforma el texto con saltos de lina a una sola linea
        if (textEspComp.getText().contains(System.lineSeparator())) {
            str = textEspComp.getText().replaceAll(System.lineSeparator(), "#");
            datos.add(str);
        } else {
            datos.add(textEspComp.getText());
        }
        //Transforma el texto con saltos de lina a una sola linea
        if (textObservaciones.getText().contains(System.lineSeparator())) {
            str = textObservaciones.getText().replaceAll(System.lineSeparator(), "#");
            datos.add(str);
        } else {
            datos.add(textObservaciones.getText());
        }

        if (comboRed.getSelectedIndex() == 0) {
            datos.add("c");
        } else {
            datos.add("d");
        }
        datos.add(textCorreo2.getText());

        return datos;
    }

    /**
     * Limpia las cajas de texto y resetea los toggles
     */
    public void limpiar() {
        textNombre.setText("");
        textNumMovil.setText("");
        textNumFijo.setText("");
        textCorreo.setText("");
        textDireccion.setText("");
        textLocalidad.setText("");
        textProvCom.setText("");
        textOcupacion.setText("");
        textNombreTeatro.setText("");
        textRed.setText("");
        textTipoProgramacion.setText("");
        textWeb.setText("");
        textEspComp.setText("");
        textObservaciones.setText("");
        toggleRN.setSelected(false);
        comboRed.setSelectedIndex(0);
        textCorreo2.setText("");
    }

    // </editor-fold>
    /**
     * Comprueba si un vector contiene '*' o '$'
     *
     * @param datos
     * @return True si no cotiene dichos caracteres
     */
    public boolean comprobarDatos(ArrayList<String> datos) {
        boolean ok = true;
        for (String dato : datos) {
            for (int i = 0; i < dato.length(); i++) {
                if (dato.charAt(i) == '*' || dato.charAt(i) == '$') {
                    ok = false;
                }
            }
        }
        return ok;
    }

    public String toCadena(ArrayList<String> s) {
        String st = "";

        for (String sr : s) {
            st += sr + "$";
        }
        return st;
    }

    public void setEditable(boolean ok) {
        textNombre.setEditable(ok);
        textNumMovil.setEditable(ok);
        textNumFijo.setEditable(ok);
        textCorreo.setEditable(ok);
        textDireccion.setEditable(ok);
        textLocalidad.setEditable(ok);
        textProvCom.setEditable(ok);
        textOcupacion.setEditable(ok);
        textNombreTeatro.setEditable(ok);
        textRed.setEditable(ok);
        textTipoProgramacion.setEditable(ok);
        textWeb.setEditable(ok);
        textEspComp.setEditable(ok);
        textObservaciones.setEditable(ok);
        textCorreo2.setEditable(ok);
        comboRed.setEnabled(ok);
        toggleRN.setEnabled(ok);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        textOcupacion = new javax.swing.JTextField();
        textCorreo = new javax.swing.JTextField();
        textNumFijo = new javax.swing.JTextField();
        textNumMovil = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textCorreo2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        textDireccion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textLocalidad = new javax.swing.JTextField();
        textProvCom = new javax.swing.JTextField();
        labelProvCom = new javax.swing.JLabel();
        textRed = new javax.swing.JTextField();
        comboRed = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        textNombreTeatro = new javax.swing.JTextField();
        textWeb = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        toggleRN = new javax.swing.JToggleButton();
        textTipoProgramacion = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textObservaciones = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        buttonEditar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textEspComp = new javax.swing.JTextPane();
        s = new javax.swing.JLabel();
        buttonAmpliar = new javax.swing.JButton();
        labelRequesitos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(" Perfil de un cliente - TeatroDB");
        setResizable(false);

        panelMain.setBackground(new java.awt.Color(102, 102, 102));
        panelMain.setPreferredSize(new java.awt.Dimension(859, 632));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        textOcupacion.setBackground(new java.awt.Color(73, 73, 73));
        textOcupacion.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        textOcupacion.setForeground(new java.awt.Color(255, 255, 255));
        textOcupacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        textCorreo.setBackground(new java.awt.Color(73, 73, 73));
        textCorreo.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        textCorreo.setForeground(new java.awt.Color(255, 255, 255));
        textCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        textNumFijo.setBackground(new java.awt.Color(73, 73, 73));
        textNumFijo.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        textNumFijo.setForeground(new java.awt.Color(255, 255, 255));
        textNumFijo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        textNumMovil.setBackground(new java.awt.Color(73, 73, 73));
        textNumMovil.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        textNumMovil.setForeground(new java.awt.Color(255, 255, 255));
        textNumMovil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        textNombre.setBackground(new java.awt.Color(73, 73, 73));
        textNombre.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        textNombre.setForeground(new java.awt.Color(255, 255, 255));
        textNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jLabel1.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Teléfono");

        jLabel6.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Correo");

        jLabel9.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ocupación");

        textCorreo2.setBackground(new java.awt.Color(73, 73, 73));
        textCorreo2.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        textCorreo2.setForeground(new java.awt.Color(255, 255, 255));
        textCorreo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jLabel7.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Correo 2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textCorreo2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(textNumMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textNumFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNumMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNumFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCorreo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel10.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Dirección");

        textDireccion.setBackground(new java.awt.Color(73, 73, 73));
        textDireccion.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        textDireccion.setForeground(new java.awt.Color(255, 255, 255));
        textDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jLabel11.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Localidad");

        textLocalidad.setBackground(new java.awt.Color(73, 73, 73));
        textLocalidad.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        textLocalidad.setForeground(new java.awt.Color(255, 255, 255));
        textLocalidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        textProvCom.setBackground(new java.awt.Color(73, 73, 73));
        textProvCom.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        textProvCom.setForeground(new java.awt.Color(255, 255, 255));
        textProvCom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        labelProvCom.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        labelProvCom.setForeground(new java.awt.Color(255, 255, 255));
        labelProvCom.setText("Provincia");

        textRed.setBackground(new java.awt.Color(73, 73, 73));
        textRed.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        textRed.setForeground(new java.awt.Color(255, 255, 255));
        textRed.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        comboRed.setBackground(new java.awt.Color(51, 51, 51));
        comboRed.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        comboRed.setForeground(new java.awt.Color(255, 255, 255));
        comboRed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Circuito", "Diputación" }));
        comboRed.setToolTipText("");
        comboRed.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelProvCom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboRed, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textLocalidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textRed, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textProvCom, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelProvCom)
                    .addComponent(textProvCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel13.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Teatro");

        textNombreTeatro.setBackground(new java.awt.Color(73, 73, 73));
        textNombreTeatro.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        textNombreTeatro.setForeground(new java.awt.Color(255, 255, 255));
        textNombreTeatro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        textWeb.setBackground(new java.awt.Color(73, 73, 73));
        textWeb.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        textWeb.setForeground(new java.awt.Color(255, 255, 255));
        textWeb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jLabel4.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Web");

        jLabel15.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tipo de Programación");

        toggleRN.setBackground(new java.awt.Color(51, 51, 51));
        toggleRN.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        toggleRN.setForeground(new java.awt.Color(255, 255, 255));
        toggleRN.setText("Red Nacional");
        toggleRN.setFocusPainted(false);

        textTipoProgramacion.setBackground(new java.awt.Color(73, 73, 73));
        textTipoProgramacion.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        textTipoProgramacion.setForeground(new java.awt.Color(255, 255, 255));
        textTipoProgramacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel15)
                            .addGap(222, 222, 222))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textNombreTeatro, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textTipoProgramacion))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(toggleRN, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(textNombreTeatro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTipoProgramacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(toggleRN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jLabel17.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Observaciones");

        textObservaciones.setBackground(new java.awt.Color(73, 73, 73));
        textObservaciones.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        textObservaciones.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(textObservaciones);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Gadugi", 0, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Perfil del cliente");

        buttonEditar.setBackground(new java.awt.Color(51, 51, 51));
        buttonEditar.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        buttonEditar.setForeground(new java.awt.Color(255, 255, 255));
        buttonEditar.setText("Editar");
        buttonEditar.setFocusPainted(false);
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });

        buttonEliminar.setBackground(new java.awt.Color(51, 51, 51));
        buttonEliminar.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        buttonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        buttonEliminar.setText("Eliminar");
        buttonEliminar.setFocusPainted(false);
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        textEspComp.setBackground(new java.awt.Color(73, 73, 73));
        textEspComp.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        textEspComp.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(textEspComp);

        s.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        s.setForeground(new java.awt.Color(255, 255, 255));
        s.setText("Espectáculos Vendidos");

        buttonAmpliar.setBackground(new java.awt.Color(51, 51, 51));
        buttonAmpliar.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        buttonAmpliar.setForeground(new java.awt.Color(255, 255, 255));
        buttonAmpliar.setText("Ampliar");
        buttonAmpliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAmpliarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(s)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonAmpliar)
                        .addGap(55, 55, 55))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s)
                    .addComponent(buttonAmpliar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        labelRequesitos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelRequesitos.setForeground(new java.awt.Color(102, 102, 102));
        labelRequesitos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRequesitos.setText("Ingrese un nombre al cliente*");

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(buttonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelRequesitos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonEditar)
                            .addComponent(buttonEliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(7, 7, 7)
                        .addComponent(labelRequesitos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        switch (buttonEditar.getText()) {
            case "Editar":
                buttonEditar.setText("Guardar");
                setEditable(true);
                break;

            case "Guardar":
                if (comprobarDatos(getDatos())) {
                    buttonEditar.setText("Editar");
                    setEditable(false);
                    //Llamar funcion editar cliente
                    aux.setActionCommand("3" + toCadena(getDatos()));
                    aux.doClick();
                    //Llamar funcion rellenar panel clientes
                    aux.setActionCommand("2" + "Mod" + idCliente);
                    aux.doClick();
                } else {
                    JOptionPane.showMessageDialog(null, "Ha Ocurrido un error. \n "
                            + "Elimina todos los '*' y '$' de los campos de texto.");
                }

                break;
            case "Añadir":
                if (!textNombre.getText().isEmpty()) {
                    if (comprobarDatos(getDatos())) {
                        //Añadir nuevo cliente
                        aux.setActionCommand("4" + toCadena(getDatos()));
                        aux.doClick();
                        JOptionPane.showMessageDialog(null, "Se ha añadido el cliente correctamente");
                        //Añadir nueva caja cliente al vector
                        aux.setActionCommand("1");
                        aux.doClick();
                        //Llamar funcion rellenar panel clientes
                        aux.setActionCommand("2" + "Add" + idCliente);
                        aux.doClick();
                        //Cerrar ventana y cambiar el color del panel requesitos
                        dispose();
                        labelRequesitos.setForeground(new Color(102,102,102));
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha Ocurrido un error. \n "
                                + "Elimina todos los '*' y '$' de los campos de texto.");
                    }
                } else {
                    labelRequesitos.setForeground(Color.red);
                }

                break;
            default:
                break;
        }
    }//GEN-LAST:event_buttonEditarActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        int i = JOptionPane.showConfirmDialog(null,
                "¿Quieres eliminar el cliente?",
                "Remove client warning",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        switch (i) {
            case 0:
                //Eliminar cliente
                idCliente = getDatos().get(0);
                aux.setActionCommand("5" + idCliente);//LLAMAR FUNCION ELIMINAR CLIENTE POR IDCLIENTE
                aux.doClick();
                //Llamar funcion rellenar panel clientes
                aux.setActionCommand("2" + "Del" + idCliente);
                System.out.println(idCliente);
                aux.doClick();
                dispose();

            default:
                break;
        }
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonAmpliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAmpliarActionPerformed

        ampliar.setVisible(true);
        ampliar.texto.setText(textEspComp.getText());
        ampliar.labelNombre.setText("Espectáculos comprados por " + textNombre.getText());

        if (buttonEditar.getText().equals("Editar")) {
            ampliar.texto.setEditable(false);
        } else {
            ampliar.texto.setEditable(true);
        }
    }//GEN-LAST:event_buttonAmpliarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAmpliar;
    public javax.swing.JButton buttonEditar;
    public javax.swing.JButton buttonEliminar;
    private javax.swing.JComboBox<String> comboRed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelProvCom;
    public javax.swing.JLabel labelRequesitos;
    private javax.swing.JPanel panelMain;
    private javax.swing.JLabel s;
    public javax.swing.JTextField textCorreo;
    public javax.swing.JTextField textCorreo2;
    public javax.swing.JTextField textDireccion;
    public javax.swing.JTextPane textEspComp;
    public javax.swing.JTextField textLocalidad;
    public javax.swing.JTextField textNombre;
    public javax.swing.JTextField textNombreTeatro;
    public javax.swing.JTextField textNumFijo;
    public javax.swing.JTextField textNumMovil;
    private javax.swing.JTextPane textObservaciones;
    public javax.swing.JTextField textOcupacion;
    public javax.swing.JTextField textProvCom;
    public javax.swing.JTextField textRed;
    public javax.swing.JTextField textTipoProgramacion;
    public javax.swing.JTextField textWeb;
    private javax.swing.JToggleButton toggleRN;
    // End of variables declaration//GEN-END:variables
}
