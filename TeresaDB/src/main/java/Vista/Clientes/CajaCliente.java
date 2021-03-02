package Vista.Clientes;

import Modelo.Modelo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Salva Castells Juan
 */
public class CajaCliente extends javax.swing.JPanel {

    private ArrayList<String> datos;
    private Modelo modelo;

    public CajaCliente(Modelo modelo) {
        this.modelo = modelo;
        initComponents();
        datos = new ArrayList<>();
    }
    /**
     * 
     * @return 
     */
    public ArrayList<String> getDatos (){
        return datos;
    }
    /**
     * 
     * @param datos 
     */
    public void setDatos(ArrayList<String> datos) {
        this.datos = datos;
        labelId.setText(datos.get(0));
        labelPersona.setText(datos.get(1));
        labelCorreo.setText(datos.get(4));
        labelZonaTrabajo.setText(datos.get(6) + ", " + datos.get(7));
        labelOcupacion.setText(datos.get(8));
        labelNombreTeatro.setText(datos.get(9));
        if (datos.get(11).equalsIgnoreCase("s")){
            labelRn.setVisible(true);
        }
        else{
            labelRn.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPersona = new javax.swing.JLabel();
        labelId = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelZonaTrabajo = new javax.swing.JLabel();
        labelNombreTeatro = new javax.swing.JLabel();
        labelOcupacion = new javax.swing.JLabel();
        buttonVerPerfil = new javax.swing.JButton();
        labelRn = new javax.swing.JLabel();
        checkBoxEnviar = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(51, 51, 51));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(685, 131));

        labelPersona.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelPersona.setForeground(new java.awt.Color(255, 255, 255));
        labelPersona.setText("Nombre Apellido1 Apellido2");

        labelId.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelId.setForeground(new java.awt.Color(255, 255, 255));
        labelId.setText("0000");

        labelCorreo.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelCorreo.setForeground(new java.awt.Color(255, 255, 255));
        labelCorreo.setText("googlemail@gmail.com");

        jPanel1.setBackground(new java.awt.Color(73, 73, 73));

        labelZonaTrabajo.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelZonaTrabajo.setForeground(new java.awt.Color(255, 255, 255));
        labelZonaTrabajo.setText("Localidad, Provincia");

        labelNombreTeatro.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelNombreTeatro.setForeground(new java.awt.Color(255, 255, 255));
        labelNombreTeatro.setText("Nombre Teatro/Circuito");

        labelOcupacion.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelOcupacion.setForeground(new java.awt.Color(255, 255, 255));
        labelOcupacion.setText("Ocupacion");

        buttonVerPerfil.setBackground(new java.awt.Color(51, 51, 51));
        buttonVerPerfil.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        buttonVerPerfil.setForeground(new java.awt.Color(255, 255, 255));
        buttonVerPerfil.setText("Ver Perfil");
        buttonVerPerfil.setFocusPainted(false);
        buttonVerPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVerPerfilActionPerformed(evt);
            }
        });

        labelRn.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        labelRn.setForeground(new java.awt.Color(255, 0, 0));
        labelRn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRn.setText("R.N.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNombreTeatro, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelZonaTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(labelOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonVerPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(labelRn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelZonaTrabajo)
                    .addComponent(labelOcupacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreTeatro)
                    .addComponent(buttonVerPerfil)
                    .addComponent(labelRn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        checkBoxEnviar.setBackground(new java.awt.Color(51, 51, 51));
        checkBoxEnviar.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelId, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxEnviar)
                .addGap(20, 20, 20))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelPersona)
                        .addComponent(labelId)
                        .addComponent(labelCorreo))
                    .addComponent(checkBoxEnviar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonVerPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVerPerfilActionPerformed

        if (datos.size() > 17) {
            VentanaPerfilCliente vpc = new VentanaPerfilCliente(modelo);
            vpc.setDatos(datos);
            vpc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null,
                    "El cliente seleccionado no posee todos los \n"
                    + "datos necesarios para cargar el perfil");
        }

    }//GEN-LAST:event_buttonVerPerfilActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonVerPerfil;
    private javax.swing.JCheckBox checkBoxEnviar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCorreo;
    public javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNombreTeatro;
    private javax.swing.JLabel labelOcupacion;
    public javax.swing.JLabel labelPersona;
    private javax.swing.JLabel labelRn;
    private javax.swing.JLabel labelZonaTrabajo;
    // End of variables declaration//GEN-END:variables
}
