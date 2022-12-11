
package proyectofinal;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
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
        initComponents();

        this.setEnabled(true);

        bolas = new ArrayList<>();

        bolas.add(new Bola(830, 300));
        bolas.get(0).setColor(new Color(255, 255, 255));

        tacoActive = true;
        coeficienteFriccion = 0.02;

        taco.setBola(bolas.get(0));

        time = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                moverBolas();
            }
        });
        time.start();
    }

    public void addBola() {
        bolas.add(new Bola(randomSpotSearcher()));
    }

    public void clearBolas() {
        bolas.retainAll(bolas.subList(0, 1));
        bolas.get(0).setLocation(randomSpotSearcher());
    }

    private Point2D randomSpotSearcher() {
        Point2D p = null;
        Boolean disponible = false;

        while (!disponible) { // ¡¡¡¡¡¡rocordar ajustar los random para quedar dentro del area de
                              // juego!!!!!!!!!!!
            p = new Point2D.Double(jLabel1.getX() + Math.random() * jLabel1.getWidth(),
                    jLabel1.getY() + Math.random() * jLabel1.getHeight());
            disponible = true;
            for (Bola b : bolas) {
                if (P2DMath.getMagnitude(P2DMath.subtract(b.getLocation(), p)) < b.getRadio() * 2 + 5) {
                    disponible = false;
                }
            }
        }

        return p;
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
                        b.checkCollision(b2);
                    }
                }
                this.checkCollision(b);
            }
        }
        for (Bola b : bolas) {
            b.movimiento(coeficienteFriccion);
        }

        if (tacoActive && movimiento) {
            tacoActive = false;
            actilizarTaco();
        } else if (!tacoActive && !movimiento) {
            tacoActive = true;
            actilizarTaco();
        }

        this.repaint();
    }

    public void actilizarTaco() {
        this.remove(taco);

        if (tacoActive) {
            this.add(taco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
            taco.resetLocation();
        }
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        taco = new proyectofinal.Taco();

        setPreferredSize(new java.awt.Dimension(1280, 720));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MesaPool.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));
        setLayer(taco, 1);
        add(taco, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, -214, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_formMouseClicked
        System.out.println(evt.getX() + " " + evt.getY());
    }// GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private proyectofinal.Taco taco;
    // End of variables declaration//GEN-END:variables
}
