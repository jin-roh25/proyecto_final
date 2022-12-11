/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyectofinal;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * taco para golpear bolas. se usara para aplicarle un impulso a la bola blanca
 *
 * @author Keyteer
 * @author segonzalez2021
 * @version versión 0.1, 28 de noviembre de 2022
 */
public class Taco extends javax.swing.JPanel {

    //private double angulo, distancia;
    /**
     * Creates new form Taco
     */
    public Taco() {
        initComponents();
        this.setPreferredSize(new Dimension(900,900));
    }
    
    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform t= new AffineTransform();
        t.rotate(WIDTH, ABORT, ABORT);
        g2d.setTransform(t);
        
        super.paint(g2d);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Taco.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
