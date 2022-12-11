package proyectofinal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Mesa de pool. ambiente en el que se desarrollan las interacciones
 *
 * @author Keyteer
 * @author segonzalez2021
 * @version versión 0.1.2, 1 de diciembre, 2022
 * @see Bola
 */
public class MesaPool extends javax.swing.JLayeredPane implements Collisions{

    /**
     * timer que actualiza la posición de las bolas
     */
    private final Timer time;

    /**
     * todas las bolas de la mesa
     */
    private final ArrayList<Bola> bolas;

    /**
     * roce del ambiente, aire + superficie
     */
    private final double coeficienteFriccion;

    /**
     * constructor, por defecto el timer actualiza cada 10 milisegundos y el
     * valor de la fricción en 0.2
     */
    public MesaPool() {
        bolas = new ArrayList<>();
        
        coeficienteFriccion = 0.02;

        initComponents();
        
        bolas.add(new Bola(300,300));

        time = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                moverBolas();
            }
        });
        time.start();
    }

    /**
     * aplica movimiento a todas las bola
     */
    private void moverBolas() {
        for (Bola b : bolas) {
            if (b.isMoving()) {
                for (Bola b2 : bolas) {
                    if (b2 != b) {
                        b.checkCollision(b2);
                    }
                }
                this.checkCollision(b);
            }
        }
        for (Bola b : bolas) {
            b.movimiento(coeficienteFriccion);
        }
        this.repaint();
    }
    
    @Override
    public void checkCollision(Bola b){
        
        if(62 >= b.getLocation().getY()+b.getRadio()){
            if((107<=b.getLocation().getX())&&(b.getLocation().getX()<=569)){
                System.out.println("colision");
                
            }else if((630<=b.getLocation().getX())&&(b.getLocation().getX()<=1092)){
                System.out.println("colision");
            }
        }else if(b.getLocation().getY()+b.getRadio()>= 599){
            if((107<=b.getLocation().getX())&&(b.getLocation().getX()<=569)){
                System.out.println("colision");
            }else if((630<=b.getLocation().getX())&&(b.getLocation().getX()<=1092)){
                System.out.println("colision");
            }
        }else if(64>= b.getLocation().getX()+b.getRadio()){
            if((107<=b.getLocation().getY())&&(b.getLocation().getY()<=555)){
                System.out.println("colision");
            }
        }else if(1135<= b.getLocation().getX()+b.getRadio()){
            if((107<=b.getLocation().getY())&&(b.getLocation().getY()<=555)){
                System.out.println("colision");
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Bola b : bolas) {
            b.paint(g);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MesaPool.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        //System.out.println("x: "+evt.getX()+", y: "+evt.getY());
        bolas.get(0).setDelta(0.0, 10.0);
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
