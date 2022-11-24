package proyectofinal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bola extends javax.swing.JPanel {

    private int numero;
    private int dx, dy;
    private Timer t;

    public Bola() {
        numero = 0;
        dx = 1;
        dy = 0;
        initComponents();
        this.setSize(20, 20);

        t = new Timer(100,null);
        t.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                movimiento();
            }
        });

        t.start();
    }

    private void movimiento() {
        this.setLocation(this.getX() + dx, this.getY() + dy);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(0, 0, 0));
        g.fillOval(0, 0, this.getWidth(), this.getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
