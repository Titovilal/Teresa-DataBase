package Vista;

/**
 *
 * @author Salva Castells Juan
 */
public class Vista extends javax.swing.JFrame {
    
    
    public Vista() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        buttonAgendaClientes = new javax.swing.JButton();
        buttonCias = new javax.swing.JButton();
        panelMain = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemGuardar = new javax.swing.JMenuItem();
        itemAcutalizar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        itemAddCliente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemGuia = new javax.swing.JMenuItem();
        itemReport = new javax.swing.JMenuItem();
        itemContacto = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Teresa Database Management Program");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        buttonAgendaClientes.setBackground(new java.awt.Color(51, 51, 51));
        buttonAgendaClientes.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        buttonAgendaClientes.setForeground(new java.awt.Color(255, 255, 255));
        buttonAgendaClientes.setText("Agenda Clientes");
        buttonAgendaClientes.setFocusPainted(false);

        buttonCias.setBackground(new java.awt.Color(51, 51, 51));
        buttonCias.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        buttonCias.setForeground(new java.awt.Color(255, 255, 255));
        buttonCias.setText("Cias");
        buttonCias.setFocusPainted(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAgendaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(buttonCias, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(buttonAgendaClientes)
                .addGap(40, 40, 40)
                .addComponent(buttonCias, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMain.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuBar1.setBorderPainted(false);
        jMenuBar1.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N

        jMenu1.setBackground(new java.awt.Color(102, 102, 102));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Programa");
        jMenu1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        itemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemGuardar.setBackground(new java.awt.Color(255, 255, 255));
        itemGuardar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        itemGuardar.setForeground(new java.awt.Color(0, 0, 0));
        itemGuardar.setText("Guardar ");
        jMenu1.add(itemGuardar);

        itemAcutalizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemAcutalizar.setBackground(new java.awt.Color(255, 255, 255));
        itemAcutalizar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        itemAcutalizar.setForeground(new java.awt.Color(0, 0, 0));
        itemAcutalizar.setText("Actualizar sin guardar");
        jMenu1.add(itemAcutalizar);

        jMenuBar1.add(jMenu1);

        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Añadir");
        jMenu3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        itemAddCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemAddCliente.setBackground(new java.awt.Color(255, 255, 255));
        itemAddCliente.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        itemAddCliente.setForeground(new java.awt.Color(0, 0, 0));
        itemAddCliente.setText("Nuevo Cliente ");
        jMenu3.add(itemAddCliente);

        jMenuBar1.add(jMenu3);

        jMenu2.setBackground(new java.awt.Color(102, 102, 102));
        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Ayuda");
        jMenu2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        itemGuia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemGuia.setBackground(new java.awt.Color(255, 255, 255));
        itemGuia.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        itemGuia.setForeground(new java.awt.Color(0, 0, 0));
        itemGuia.setText("Guia ");
        jMenu2.add(itemGuia);

        itemReport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemReport.setBackground(new java.awt.Color(255, 255, 255));
        itemReport.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        itemReport.setForeground(new java.awt.Color(0, 0, 0));
        itemReport.setText("Reportar problema");
        jMenu2.add(itemReport);

        itemContacto.setBackground(new java.awt.Color(255, 255, 255));
        itemContacto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        itemContacto.setForeground(new java.awt.Color(0, 0, 0));
        itemContacto.setText("Contacto");
        jMenu2.add(itemContacto);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buttonAgendaClientes;
    public javax.swing.JButton buttonCias;
    public javax.swing.JMenuItem itemAcutalizar;
    public javax.swing.JMenuItem itemAddCliente;
    public javax.swing.JMenuItem itemContacto;
    public javax.swing.JMenuItem itemGuardar;
    public javax.swing.JMenuItem itemGuia;
    public javax.swing.JMenuItem itemReport;
    private javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel panelMain;
    // End of variables declaration//GEN-END:variables
}
