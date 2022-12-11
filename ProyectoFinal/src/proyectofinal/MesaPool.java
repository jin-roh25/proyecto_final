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
public class MesaPool extends javax.swing.JLayeredPane {

    /**
     * timer que actualiza la posición de las bolas
     */
    private final Timer time;

    /**
     * todas las bolas de la mesa
     */
    private final ArrayList<Bola> bolas;
    
    private Boolean tacoActive;

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

        bolas.add(new Bola(600, 400));
        bolas.get(0).setColor(new Color(255, 255, 255));

        tacoActive = true;
        coeficienteFriccion = 0.02;

        initComponents();

        taco.setBola(bolas.get(0));

        time = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                moverBolas();
            }
        });
        time.start();
    }

    /**
     * aplica movimiento a todas las bola y revisa si hay movimiento
     */
    private void moverBolas() {
        Boolean movimiento = false;
        
        for (Bola b : bolas) {
            if (b.isMoving()) {
                movimiento = true;
                
                for (Bola b2 : bolas) {
                    if (b2 != b) {
                        b.checkCollisionBola(b2);
                    }
                }
            }
        }
        for (Bola b : bolas) {
            b.movimiento(coeficienteFriccion);
        }
        
        if(tacoActive && movimiento){
            this.remove(taco);
            tacoActive = false;
        }else if(!tacoActive && !movimiento){
            this.add(taco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
            taco.resetLocation();
            tacoActive = true;
        }
        
        this.repaint();
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
        taco = new proyectofinal.Taco();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MesaPool.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        setLayer(taco, 1);
        add(taco, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private proyectofinal.Taco taco;
    // End of variables declaration//GEN-END:variables
}
