package vista;

import clases.Usuario;
import java.awt.Color;
import javax.swing.JOptionPane;
import modelo.DAO;
import recursos.LookVentana.EventLogin;

public class Login extends PanelCustom {

    private EventLogin event;
    private VMain vMain;
    private DAO dao;

    public Login() {
        initComponents();

        txtUsuario.setText("Jason");
        txtContrasenia.setText("abcd*1234");
    }

    public void setEventLogin(EventLogin event) {
        this.event = event;
    }

    public void pasarParametros(VMain vMain, DAO dao) {
        this.vMain = vMain;
        this.dao = dao;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        spUsuario = new javax.swing.JSeparator();
        txtContrasenia = new javax.swing.JPasswordField();
        spContrasenia = new javax.swing.JSeparator();
        btnIniciarSesion = new recursos.LookVentana.Button();

        setBackground(new java.awt.Color(247, 247, 247));

        lblTitulo.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(76, 76, 76));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("SIGN IN");

        txtUsuario.setBackground(getBackground());
        txtUsuario.setText("Usuario");
        txtUsuario.setBorder(null);
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });

        spUsuario.setForeground(lblTitulo.getForeground());

        txtContrasenia.setBackground(getBackground());
        txtContrasenia.setText("Contraseña");
        txtContrasenia.setBorder(null);
        txtContrasenia.setEchoChar((char) 0);
        txtContrasenia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContraseniaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContraseniaFocusLost(evt);
            }
        });

        spContrasenia.setForeground(lblTitulo.getForeground());

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
                    .addComponent(spContrasenia)
                    .addComponent(spUsuario)
                    .addComponent(txtContrasenia)
                    .addComponent(txtUsuario)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(spUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(spContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicarSesionActionPerformed
        if (getAlpha() == 0) {
            event.loginDone();
        }
    }//GEN-LAST:event_btnInicarSesionActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        Usuario usu = dao.iniciarSesion(txtUsuario.getText(), txtContrasenia.getText());

        if (usu != null) {
            VPrincipal vPrincipal = new VPrincipal(vMain, true, dao, usu);
            vMain.setOpacity(0);
            vPrincipal.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "Usuario y contraseña no coinciden");
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained
        spUsuario.setForeground(new Color(0, 153, 255));

        if (txtUsuario.getText().equalsIgnoreCase("Usuario")) {
            txtUsuario.setText("");
        }
    }//GEN-LAST:event_txtUsuarioFocusGained

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        spUsuario.setForeground(lblTitulo.getForeground());

        if (txtUsuario.getText().equalsIgnoreCase("")) {
            txtUsuario.setText("Usuario");
        }
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void txtContraseniaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraseniaFocusGained
        spContrasenia.setForeground(new Color(0, 153, 255));

        if (txtContrasenia.getText().equalsIgnoreCase("Contraseña")) {
            txtContrasenia.setText("");
            txtContrasenia.setEchoChar('*');
        }
    }//GEN-LAST:event_txtContraseniaFocusGained

    private void txtContraseniaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraseniaFocusLost
        spContrasenia.setForeground(lblTitulo.getForeground());

        if (txtContrasenia.getText().equalsIgnoreCase("")) {
            txtContrasenia.setText("Contraseña");
            txtContrasenia.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_txtContraseniaFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private recursos.LookVentana.Button btnIniciarSesion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JSeparator spContrasenia;
    private javax.swing.JSeparator spUsuario;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
