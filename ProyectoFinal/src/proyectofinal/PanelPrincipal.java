/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyectofinal;

/**
 * Layered pane principal. contiene los elementos de UI y a la mesa de pool
 *
 * @author Keyteer
 * @author segonzalez2021
 * @see MesaPool
 */
public class PanelPrincipal extends javax.swing.JLayeredPane {

    /**
     * Creates new form PanelPrincipal
     */
    public PanelPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        mesa = new proyectofinal.MesaPool();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSlider1.setMinimum(1);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintTicks(true);
        jSlider1.setPaintTrack(false);
        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(16);
        jSlider1.setName(""); // NOI18N
        jSlider1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider1MouseDragged(evt);
            }
        });
        setLayer(jSlider1, 1);
        add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 200, 30));

        mesa.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                mesaPropertyChange(evt);
            }
        });
        add(mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton1.setFont(new java.awt.Font("Gill Sans MT", 1, 36)); // NOI18N
        jButton1.setText("RESET");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        setLayer(jButton1, 1);
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 180, 80));

        jLabel1.setText("cantidad de bolas:");
        setLayer(jLabel1, 1);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, -1, -1));

        jLabel2.setText(Integer.toString(jSlider1.getValue()));
        setLayer(jLabel2, 1);
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 640, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setText("PUNTAJE: " + Integer.toString(mesa.getPuntaje()));
        setLayer(jLabel3, 1);
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 230, 40));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * actualiza el conatdor de puntaje
     */
    private void mesaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_mesaPropertyChange
        if (evt.getPropertyName().equals("puntaje")) {
            jLabel3.setText("PUNTAJE: " + Integer.toString(mesa.getPuntaje()));
        }
    }//GEN-LAST:event_mesaPropertyChange

    /**
     * actualiza indicador en cantidad de bolas
     */
    private void jSlider1MouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jSlider1MouseDragged
        jLabel2.setText(Integer.toString(jSlider1.getValue()));
    }// GEN-LAST:event_jSlider1MouseDragged

    /**
     * reinicia la mesa
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        mesa.reset(jSlider1.getValue());
    }// GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSlider jSlider1;
    private proyectofinal.MesaPool mesa;
    // End of variables declaration//GEN-END:variables
}
