/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import clases.Caballo;
import clases.Usuario;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import javax.swing.ImageIcon;
import modelo.DAO;
import recursos.LookVentana.MessageDialog;
import recursos.Utilidades;

/**
 *
 * @author xDoble_Jx
 */
public class PCaballos extends javax.swing.JPanel {

    private DAO dao;
    private VMain vMain;
    private Usuario usu;
    private PMenu pMenu;

    private Thread t1;
    private Thread t2;

    private int velocidad1;
    private int velocidad2;

    private Caballo cab1;
    private Caballo cab2;
    private Caballo ganador = null;
    private float saldo;

    private boolean comprobar = true;

    /**
     * Creates new form PCaballos
     */
    public PCaballos(VMain vMain, PMenu pMenu, DAO dao, Usuario usu) {
        this.vMain = vMain;
        this.pMenu = pMenu;
        this.dao = dao;
        this.usu = usu;
        initComponents();

        elegirCaballos();
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.dispose();
        super.paint(grphcs);
    }

    public void elegirCaballos() {
        List<Caballo> caballos = dao.listarCaballos();

        cab1 = caballos.get(Utilidades.numeros_aleatorios(0, caballos.size() - 1));
        cab1.setCuota(Utilidades.generarCuotas(3, 1, 0, 8));
        do {
            cab2 = caballos.get(Utilidades.numeros_aleatorios(0, caballos.size() - 1));
            cab2.setCuota(Utilidades.generarCuotas(3, 1, 0, 8));
        } while (cab1.getId_caballo().equalsIgnoreCase(cab2.getId_caballo()));

        imgCaballo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Caballos/" + cab1.getIcono())));
        lblNom1.setText(cab1.getNombre());
        lblNomCaballo.setText(cab1.getNombre());
        lblCuo1.setText("Cuota: " + cab1.getCuota());

        imgCaballo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Caballos/" + cab2.getIcono())));
        lblNom2.setText(cab2.getNombre());
        lblNomCaballo1.setText(cab2.getNombre());
        lblCuo2.setText("Cuota: " + cab2.getCuota());
    }

    public void porcentajeC1() {
        progressBarCaballo1.setValue(0);
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <= progressBarCaballo2.getMaximum(); i++) {
                    try {
                        if (i % 10 == 0) {

                            velocidad1 = recursos.Utilidades.numeros_aleatorios(100, 600);

                            if (cab1.getNombre().equalsIgnoreCase("Alvarito")) {
                                velocidad1 -= 100;
                            }
                        }

                        progressBarCaballo1.setValue(progressBarCaballo1.getValue() + 1);

                        Thread.sleep(velocidad1);

                        if ((progressBarCaballo1.getValue() == 100 || progressBarCaballo2.getValue() == 100) && comprobar) {
                            comprobarGanador();
                        }
                    } catch (InterruptedException ex) {

                    }
                }
            }
        });
        t1.start();
    }

    public void porcentajeC2() {
        progressBarCaballo2.setValue(0);
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <= progressBarCaballo2.getMaximum(); i++) {
                    try {
                        if (i % 10 == 0) {
                            velocidad2 = recursos.Utilidades.numeros_aleatorios(100, 600);

                            if (cab2.getNombre().equalsIgnoreCase("Alvarito")) {
                                velocidad2 -= 100;
                            }
                        }

                        progressBarCaballo2.setValue(progressBarCaballo2.getValue() + 1);

                        Thread.sleep(velocidad2);

                    } catch (InterruptedException ex) {

                    }
                }
            }
        });
        t2.start();
    }

    public void comprobarGanador() {
        comprobar = false;

        int por1 = progressBarCaballo1.getValue();
        int por2 = progressBarCaballo2.getValue();

        if (por1 == 100 && por2 < 100) {
            ganador = cab1;
        } else if (por1 < 100 && por2 == 100) {
            ganador = cab2;
        }

        if (ganador != null) {
            if (ganador.getNombre().equalsIgnoreCase(lblCaballo.getText())) {
                saldo = ((int) txtCantidad.getValue() * ganador.getCuota());

                MessageDialog md = new MessageDialog(vMain);
                md.showMessage("Enhorabuena", "Enhorabuena, has ganado " + saldo + "€");

                pMenu.actualizarSaldo(usu.getId_usuario(), (int) txtCantidad.getValue() + saldo);

            } else {
                MessageDialog md = new MessageDialog(vMain);
                md.showMessage("Perdiste", "Una pena, has perdido " + txtCantidad.getValue().toString() + "€ la proxima vez tendras mas suerte");
            }
            elegirCaballos();

            t1.stop();
            t2.stop();
            progressBarCaballo1.setValue(0);
            progressBarCaballo2.setValue(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carrera = new recursos.LookVentana.RoundPanel();
        progressBarCaballo1 = new javax.swing.JProgressBar();
        progressBarCaballo2 = new javax.swing.JProgressBar();
        lblNomCaballo = new javax.swing.JLabel();
        lblNomCaballo1 = new javax.swing.JLabel();
        caballos = new recursos.LookVentana.RoundPanel();
        panelCaballo1 = new recursos.LookVentana.RoundPanel();
        imgCaballo1 = new recursos.LookVentana.ImageAvatar();
        lblNom1 = new javax.swing.JLabel();
        lblCuo1 = new javax.swing.JLabel();
        panelCaballo2 = new recursos.LookVentana.RoundPanel();
        imgCaballo2 = new recursos.LookVentana.ImageAvatar();
        lblNom2 = new javax.swing.JLabel();
        lblCuo2 = new javax.swing.JLabel();
        apuesta = new recursos.LookVentana.RoundPanel();
        btnApostar = new recursos.LookVentana.Button();
        lblCaballoTxt = new javax.swing.JLabel();
        lblCaballo = new javax.swing.JLabel();
        lblCuotaTxt = new javax.swing.JLabel();
        lblCuota = new javax.swing.JLabel();
        lblCantidadTxt = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JSpinner();
        spCantidad = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(21, 21, 21));

        carrera.setBackground(new java.awt.Color(49, 51, 53));

        progressBarCaballo1.setStringPainted(true);

        progressBarCaballo2.setStringPainted(true);

        lblNomCaballo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblNomCaballo.setForeground(new java.awt.Color(227, 227, 227));
        lblNomCaballo.setText("Caballa");

        lblNomCaballo1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblNomCaballo1.setForeground(new java.awt.Color(227, 227, 227));
        lblNomCaballo1.setText("Gallino");

        javax.swing.GroupLayout carreraLayout = new javax.swing.GroupLayout(carrera);
        carrera.setLayout(carreraLayout);
        carreraLayout.setHorizontalGroup(
            carreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carreraLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(carreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomCaballo1)
                    .addComponent(lblNomCaballo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(carreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progressBarCaballo2, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                    .addComponent(progressBarCaballo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(74, 74, 74))
        );
        carreraLayout.setVerticalGroup(
            carreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carreraLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(carreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(progressBarCaballo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomCaballo))
                .addGap(65, 65, 65)
                .addGroup(carreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(progressBarCaballo2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomCaballo1))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        caballos.setBackground(new java.awt.Color(49, 51, 53));

        panelCaballo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCaballo1MouseClicked(evt);
            }
        });

        lblNom1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblNom1.setText("Caballo");

        lblCuo1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblCuo1.setText("Cuota: ");

        javax.swing.GroupLayout panelCaballo1Layout = new javax.swing.GroupLayout(panelCaballo1);
        panelCaballo1.setLayout(panelCaballo1Layout);
        panelCaballo1Layout.setHorizontalGroup(
            panelCaballo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCaballo1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imgCaballo1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(lblNom1)
                .addGap(92, 92, 92)
                .addComponent(lblCuo1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        panelCaballo1Layout.setVerticalGroup(
            panelCaballo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCaballo1Layout.createSequentialGroup()
                .addGroup(panelCaballo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCaballo1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(panelCaballo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNom1)
                            .addComponent(lblCuo1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCaballo1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(imgCaballo1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelCaballo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCaballo2MouseClicked(evt);
            }
        });

        lblNom2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblNom2.setText("Caballo");

        lblCuo2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblCuo2.setText("Cuota: ");

        javax.swing.GroupLayout panelCaballo2Layout = new javax.swing.GroupLayout(panelCaballo2);
        panelCaballo2.setLayout(panelCaballo2Layout);
        panelCaballo2Layout.setHorizontalGroup(
            panelCaballo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCaballo2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imgCaballo2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(lblNom2)
                .addGap(92, 92, 92)
                .addComponent(lblCuo2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCaballo2Layout.setVerticalGroup(
            panelCaballo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCaballo2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(imgCaballo2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(panelCaballo2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(panelCaballo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNom2)
                    .addComponent(lblCuo2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout caballosLayout = new javax.swing.GroupLayout(caballos);
        caballos.setLayout(caballosLayout);
        caballosLayout.setHorizontalGroup(
            caballosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, caballosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(caballosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCaballo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCaballo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        caballosLayout.setVerticalGroup(
            caballosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, caballosLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panelCaballo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(panelCaballo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        apuesta.setBackground(new java.awt.Color(49, 51, 53));

        btnApostar.setBackground(new java.awt.Color(48, 170, 63));
        btnApostar.setForeground(new java.awt.Color(255, 255, 255));
        btnApostar.setText("Apostar");
        btnApostar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApostarActionPerformed(evt);
            }
        });

        lblCaballoTxt.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblCaballoTxt.setForeground(new java.awt.Color(227, 227, 227));
        lblCaballoTxt.setText("CABALLO");

        lblCaballo.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblCaballo.setForeground(new java.awt.Color(227, 227, 227));
        lblCaballo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblCuotaTxt.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblCuotaTxt.setForeground(new java.awt.Color(227, 227, 227));
        lblCuotaTxt.setText("CUOTA");

        lblCuota.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblCuota.setForeground(new java.awt.Color(227, 227, 227));
        lblCuota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblCantidadTxt.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblCantidadTxt.setForeground(new java.awt.Color(227, 227, 227));
        lblCantidadTxt.setText("CANTIDAD");

        txtCantidad.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCantidad.setBorder(null);

        spCantidad.setForeground(new java.awt.Color(227, 227, 227));

        javax.swing.GroupLayout apuestaLayout = new javax.swing.GroupLayout(apuesta);
        apuesta.setLayout(apuestaLayout);
        apuestaLayout.setHorizontalGroup(
            apuestaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, apuestaLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(apuestaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, apuestaLayout.createSequentialGroup()
                        .addComponent(lblCuotaTxt)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, apuestaLayout.createSequentialGroup()
                        .addGroup(apuestaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnApostar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spCantidad)
                            .addComponent(lblCuota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCaballo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCantidad)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, apuestaLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(lblCantidadTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44))))
            .addGroup(apuestaLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(lblCaballoTxt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        apuestaLayout.setVerticalGroup(
            apuestaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, apuestaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblCaballoTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCaballo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(lblCuotaTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lblCantidadTxt)
                .addGap(18, 18, 18)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(spCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnApostar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(carrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(caballos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(apuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(carrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(caballos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(apuesta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApostarActionPerformed
        pMenu.actualizarSaldo(usu.getId_usuario(), -Float.parseFloat(txtCantidad.getValue().toString()));
        porcentajeC1();
        porcentajeC2();
    }//GEN-LAST:event_btnApostarActionPerformed

    private void panelCaballo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCaballo1MouseClicked
        lblCaballo.setText(cab1.getNombre());
        lblCuota.setText(cab1.getCuota() + "");
    }//GEN-LAST:event_panelCaballo1MouseClicked

    private void panelCaballo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCaballo2MouseClicked
        lblCaballo.setText(cab2.getNombre());
        lblCuota.setText(cab2.getCuota() + "");
    }//GEN-LAST:event_panelCaballo2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private recursos.LookVentana.RoundPanel apuesta;
    private recursos.LookVentana.Button btnApostar;
    private recursos.LookVentana.RoundPanel caballos;
    private recursos.LookVentana.RoundPanel carrera;
    private recursos.LookVentana.ImageAvatar imgCaballo1;
    private recursos.LookVentana.ImageAvatar imgCaballo2;
    private javax.swing.JLabel lblCaballo;
    private javax.swing.JLabel lblCaballoTxt;
    private javax.swing.JLabel lblCantidadTxt;
    private javax.swing.JLabel lblCuo1;
    private javax.swing.JLabel lblCuo2;
    private javax.swing.JLabel lblCuota;
    private javax.swing.JLabel lblCuotaTxt;
    private javax.swing.JLabel lblNom1;
    private javax.swing.JLabel lblNom2;
    private javax.swing.JLabel lblNomCaballo;
    private javax.swing.JLabel lblNomCaballo1;
    private recursos.LookVentana.RoundPanel panelCaballo1;
    private recursos.LookVentana.RoundPanel panelCaballo2;
    private javax.swing.JProgressBar progressBarCaballo1;
    private javax.swing.JProgressBar progressBarCaballo2;
    private javax.swing.JSeparator spCantidad;
    private javax.swing.JSpinner txtCantidad;
    // End of variables declaration//GEN-END:variables
}
