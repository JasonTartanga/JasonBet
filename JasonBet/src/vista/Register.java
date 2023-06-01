package vista;

import java.awt.Color;

public class Register extends PanelCustom {

    public Register() {
        initComponents();
        setAlpha(1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        button1 = new recursos.LookVentana.Button();
        txtRUsuario = new javax.swing.JTextField();
        spUsuario = new javax.swing.JSeparator();
        txtApellidos = new javax.swing.JTextField();
        spApellido = new javax.swing.JSeparator();
        txtDni = new javax.swing.JTextField();
        spDeni = new javax.swing.JSeparator();
        txtRContraseña = new javax.swing.JPasswordField();
        spContrasenia = new javax.swing.JSeparator();
        txtFecha_nac = new javax.swing.JTextField();
        spFecha_nac = new javax.swing.JSeparator();
        txtGmail = new javax.swing.JTextField();
        spGmail = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(58, 58, 58));

        lblTitulo.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(242, 242, 242));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("SIGN UP");

        button1.setBackground(new java.awt.Color(86, 142, 255));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Sign Up");
        button1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        txtRUsuario.setBackground(getBackground());
        txtRUsuario.setForeground(new java.awt.Color(227, 227, 227));
        txtRUsuario.setText("Nombre");
        txtRUsuario.setBorder(null);
        txtRUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRUsuarioFocusLost(evt);
            }
        });

        spUsuario.setForeground(lblTitulo.getForeground());

        txtApellidos.setBackground(getBackground());
        txtApellidos.setForeground(new java.awt.Color(227, 227, 227));
        txtApellidos.setText("Apellidos");
        txtApellidos.setBorder(null);
        txtApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellidosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidosFocusLost(evt);
            }
        });

        spApellido.setForeground(lblTitulo.getForeground());

        txtDni.setBackground(getBackground());
        txtDni.setForeground(new java.awt.Color(227, 227, 227));
        txtDni.setText("DNI");
        txtDni.setBorder(null);
        txtDni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDniFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDniFocusLost(evt);
            }
        });

        spDeni.setForeground(lblTitulo.getForeground());

        txtRContraseña.setBackground(getBackground());
        txtRContraseña.setForeground(new java.awt.Color(227, 227, 227));
        txtRContraseña.setText("Contraseña");
        txtRContraseña.setBorder(null);
        txtRContraseña.setEchoChar((char) 0);
        txtRContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRContraseñaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRContraseñaFocusLost(evt);
            }
        });

        spContrasenia.setForeground(lblTitulo.getForeground());

        txtFecha_nac.setBackground(getBackground());
        txtFecha_nac.setForeground(new java.awt.Color(227, 227, 227));
        txtFecha_nac.setText("Nacimiento");
        txtFecha_nac.setBorder(null);
        txtFecha_nac.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFecha_nacFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFecha_nacFocusLost(evt);
            }
        });

        spFecha_nac.setForeground(lblTitulo.getForeground());

        txtGmail.setBackground(getBackground());
        txtGmail.setForeground(new java.awt.Color(227, 227, 227));
        txtGmail.setText("Gmail");
        txtGmail.setBorder(null);
        txtGmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtGmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGmailFocusLost(evt);
            }
        });

        spGmail.setForeground(lblTitulo.getForeground());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spUsuario)
                    .addComponent(txtRContraseña)
                    .addComponent(txtApellidos)
                    .addComponent(txtRUsuario)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(txtGmail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spApellido, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(spDeni, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha_nac)
                            .addComponent(spFecha_nac)))
                    .addComponent(spGmail)
                    .addComponent(spContrasenia, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(txtRUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(spUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(spApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txtRContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(spContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha_nac, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spDeni, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(spFecha_nac, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(spGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtRUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRUsuarioFocusGained
        spUsuario.setForeground(new Color(0, 153, 255));
        if (txtRUsuario.getText().equalsIgnoreCase("Usuario")) {

        }
    }//GEN-LAST:event_txtRUsuarioFocusGained

    private void txtRUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRUsuarioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRUsuarioFocusLost

    private void txtApellidosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidosFocusGained
        spUsuario.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_txtApellidosFocusGained

    private void txtApellidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidosFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosFocusLost

    private void txtRContraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRContraseñaFocusGained
        spUsuario.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_txtRContraseñaFocusGained

    private void txtRContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRContraseñaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRContraseñaFocusLost

    private void txtDniFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusGained
        spUsuario.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_txtDniFocusGained

    private void txtDniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniFocusLost

    private void txtFecha_nacFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFecha_nacFocusGained
        spUsuario.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_txtFecha_nacFocusGained

    private void txtFecha_nacFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFecha_nacFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFecha_nacFocusLost

    private void txtGmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGmailFocusGained
        spUsuario.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_txtGmailFocusGained

    private void txtGmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGmailFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGmailFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private recursos.LookVentana.Button button1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JSeparator spApellido;
    private javax.swing.JSeparator spContrasenia;
    private javax.swing.JSeparator spDeni;
    private javax.swing.JSeparator spFecha_nac;
    private javax.swing.JSeparator spGmail;
    private javax.swing.JSeparator spUsuario;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFecha_nac;
    private javax.swing.JTextField txtGmail;
    private javax.swing.JPasswordField txtRContraseña;
    private javax.swing.JTextField txtRUsuario;
    // End of variables declaration//GEN-END:variables
}
