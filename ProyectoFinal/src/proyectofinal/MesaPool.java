package proyectofinal;

import java.awt.*;
//import javax.swing.t

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
        bola1 = new proyectofinal.Bola();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MesaPool.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 450, 249);

        javax.swing.GroupLayout bola1Layout = new javax.swing.GroupLayout(bola1);
        bola1.setLayout(bola1Layout);
        bola1Layout.setHorizontalGroup(
            bola1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        bola1Layout.setVerticalGroup(
            bola1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        setLayer(bola1, 1);
        add(bola1);
        bola1.setBounds(50, 80, 30, 30);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private proyectofinal.Bola bola1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
