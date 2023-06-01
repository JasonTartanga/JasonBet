package vista;

import recursos.LookVentana.EventLogin;

public class Login extends PanelCustom {

    private EventLogin event;
    private VMain vMain;

    public Login() {
        initComponents();

    }

    public void setEventLogin(EventLogin event) {
        this.event = event;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtRUsuario = new javax.swing.JTextField();
        txtRContrasenia = new javax.swing.JPasswordField();
        btnIniciarSesion = new recursos.LookVentana.Button();

        setBackground(new java.awt.Color(247, 247, 247));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(76, 76, 76));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SIGN IN");

        txtRUsuario.setText("Usuario");

        txtRContrasenia.setText("Contrasenia");

        btnIniciarSesion.setBackground(new java.awt.Color(86, 142, 255));
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("Iniciar Sesion");
        btnIniciarSesion.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtRContrasenia)
                    .addComponent(txtRUsuario)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(txtRContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicarSesionActionPerformed
        if (getAlpha() == 0) {
            event.loginDone();
        }
    }//GEN-LAST:event_btnInicarSesionActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed

    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private recursos.LookVentana.Button btnIniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField txtRContrasenia;
    private javax.swing.JTextField txtRUsuario;
    // End of variables declaration//GEN-END:variables
}
