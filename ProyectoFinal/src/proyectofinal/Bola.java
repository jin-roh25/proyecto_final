package proyectofinal;

import java.awt.*;

public class Bola extends javax.swing.JLayeredPane {

    private int numero;
    private int dx, dy;

    public Bola() {
        numero = 0;
        dx = 0;
        dy = 0;
        initComponents();
        this.setSize(30, 30);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(new Color(0,0,0));
        g.fillOval(0, 0, this.getWidth(), this.getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
