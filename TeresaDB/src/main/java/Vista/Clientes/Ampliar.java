package Vista.Clientes;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Salva Castells Juan
 */
public class Ampliar extends javax.swing.JFrame {

    private VentanaPerfilCliente vpc;

    public Ampliar(VentanaPerfilCliente vpc) {
        this.vpc = vpc;
        initComponents();
        this.addWindowListener(new SalirPrograma());
        this.setVisible(false);
        this.setLocationRelativeTo(null);
        
    }

    class SalirPrograma extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            if (!vpc.textEspComp.getText().equals(texto.getText())) {
                int i = JOptionPane.showConfirmDialog(null,
                        "No has guardado. ¿Quieres guardar antes de salir?",
                        "Exit without save warning",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                switch (i) {
                    case 0:
                        vpc.textEspComp.setText(texto.getText());
                        dispose();
                    case 1:
                        break;
                    default:
                        dispose();
                        break;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextPane();
        buttonGuardar = new javax.swing.JButton();
        labelNombre = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jScrollPane1.setBackground(new java.awt.Color(73, 73, 73));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        texto.setBackground(new java.awt.Color(73, 73, 73));
        texto.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        texto.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(texto);

        buttonGuardar.setBackground(new java.awt.Color(51, 51, 51));
        buttonGuardar.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        buttonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        buttonGuardar.setText("Guardar");
        buttonGuardar.setFocusPainted(false);
        buttonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarActionPerformed(evt);
            }
        });

        labelNombre.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setText("Espectáculos comprados por Nombre Cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(buttonGuardar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonGuardar)
                    .addComponent(labelNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuardarActionPerformed
        vpc.textEspComp.setText(texto.getText());
    }//GEN-LAST:event_buttonGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel labelNombre;
    public javax.swing.JTextPane texto;
    // End of variables declaration//GEN-END:variables
}
