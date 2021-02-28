package Vista.Clientes;
import Modelo.AutoCompletarTexto;
import javax.swing.KeyStroke;
import Modelo.AutoCompletarTexto;
import java.util.ArrayList;

/**
 *
 * @author Salva Castells Juan
 */
public class PanelAgenda extends javax.swing.JPanel {
    
    private AutoCompletarTexto act;

    public PanelAgenda() {
        initComponents();
        scrollPaneMain.getVerticalScrollBar().setUnitIncrement(12);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        buttonBuscar = new javax.swing.JButton();
        buttonEnviarCorreo = new javax.swing.JButton();
        toggleRN = new javax.swing.JToggleButton();
        textNombreZona = new javax.swing.JTextField();
        buttonAddCliente = new javax.swing.JButton();
        scrollPaneMain = new javax.swing.JScrollPane();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(73, 73, 73));

        jLabel2.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");

        textNombre.setBackground(new java.awt.Color(102, 102, 102));
        textNombre.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        textNombre.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Comunidad o Provincia");

        buttonBuscar.setBackground(new java.awt.Color(51, 51, 51));
        buttonBuscar.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        buttonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        buttonBuscar.setText("Buscar");
        buttonBuscar.setFocusPainted(false);

        buttonEnviarCorreo.setBackground(new java.awt.Color(51, 51, 51));
        buttonEnviarCorreo.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        buttonEnviarCorreo.setForeground(new java.awt.Color(255, 255, 255));
        buttonEnviarCorreo.setText("Enviar Correo");
        buttonEnviarCorreo.setEnabled(false);
        buttonEnviarCorreo.setFocusPainted(false);

        toggleRN.setBackground(new java.awt.Color(51, 51, 51));
        toggleRN.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        toggleRN.setForeground(new java.awt.Color(255, 255, 255));
        toggleRN.setText("RN");
        toggleRN.setFocusPainted(false);

        textNombreZona.setBackground(new java.awt.Color(102, 102, 102));
        textNombreZona.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        textNombreZona.setForeground(new java.awt.Color(255, 255, 255));

        buttonAddCliente.setBackground(new java.awt.Color(51, 51, 51));
        buttonAddCliente.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        buttonAddCliente.setForeground(new java.awt.Color(255, 255, 255));
        buttonAddCliente.setText("Añadir Cliente");
        buttonAddCliente.setFocusPainted(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonEnviarCorreo)
                    .addComponent(buttonAddCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textNombreZona)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(toggleRN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(buttonAddCliente)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(buttonEnviarCorreo)
                            .addComponent(toggleRN)
                            .addComponent(textNombreZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonBuscar)
                        .addComponent(jLabel2)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        scrollPaneMain.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPaneMain))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buttonAddCliente;
    public javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonEnviarCorreo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JScrollPane scrollPaneMain;
    public javax.swing.JTextField textNombre;
    public javax.swing.JTextField textNombreZona;
    public javax.swing.JToggleButton toggleRN;
    // End of variables declaration//GEN-END:variables
}
