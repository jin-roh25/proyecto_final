package proyectofinal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bola extends javax.swing.JPanel {

    private int numero;
    private int dx, dy;
    private Timer time;

    public Bola() {
        numero = 0;
        dx = 0;
        dy = 0;
        initComponents();

        time = new Timer(10, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                movimiento();
            }
        });
        time.start();
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
        setPreferredSize(new java.awt.Dimension(40, 40));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
