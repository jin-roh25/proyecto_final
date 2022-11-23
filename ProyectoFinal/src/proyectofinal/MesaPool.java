package proyectofinal;

import java.awt.*;

public class MesaPool extends javax.swing.JLayeredPane {

    public MesaPool() {
        initComponents();
        this.setPreferredSize(new Dimension(450,249));
        this.setSize(this.getPreferredSize());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setOpaque(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MesaPool.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 450, 249);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
