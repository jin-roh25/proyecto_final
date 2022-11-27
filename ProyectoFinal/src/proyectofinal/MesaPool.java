package proyectofinal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class MesaPool extends javax.swing.JLayeredPane {
    
    private Timer time;
    private ArrayList<Bola> bolas;

    public MesaPool() {
        bolas = new ArrayList<>();
        initComponents();
        
        time = new Timer(10, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev){
                moverBolas();
            }
        });
    }
    
    private void moverBolas(){
        for (Bola b : bolas){
            b.movimiento();
        }
        this.repaint();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        for (Bola b : bolas){
            b.paint(g);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MesaPool.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
