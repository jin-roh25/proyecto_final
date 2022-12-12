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
public class MesaPool extends javax.swing.JLayeredPane{

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
            p = new Point2D.Double(jLabel1.getX() + 72 + Math.random() * (jLabel1.getWidth() - 132),
                    jLabel1.getY() + 72 + Math.random() * (jLabel1.getHeight() - 132));
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
        ArrayList<Bola> rmBolas = new ArrayList<>();

        for (Bola b : bolas) {
            if (b.isMoving()) {
                movimiento = true;

                for (Bola b2 : bolas) {
                    if (b2 != b) {
                        b.checkCollision(b2);
                    }
                }
                rmBolas.add(checkCollision(b));
            }
        }
        bolas.removeAll(rmBolas);
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

    public Bola checkCollision(Bola b) {

        if (jLabel1.getY() + 72 >= b.getLocation().getY() + b.getRadio()) {
            if ((jLabel1.getX() + 72 <= b.getLocation().getX()) && (b.getLocation().getX() <= jLabel1.getX() + 379)) {
                System.out.println("colision");
                P2DMath.invertY(b.getDelta());

            } else if ((jLabel1.getX() + 420 <= b.getLocation().getX()) && (b.getLocation().getX() <= jLabel1.getX() + 728)) {
                System.out.println("colision");
                P2DMath.invertY(b.getDelta());
            }
        } else if (b.getLocation().getY() + b.getRadio() >= jLabel1.getY() + 399) {
            if ((jLabel1.getX() + 72 <= b.getLocation().getX()) && (b.getLocation().getX() <= jLabel1.getX() + 379)) {
                System.out.println("colision");
                P2DMath.invertY(b.getDelta());
            } else if ((jLabel1.getX() + 420 <= b.getLocation().getX()) && (b.getLocation().getX() <= jLabel1.getX() + 728)) {
                System.out.println("colision");
                P2DMath.invertY(b.getDelta());
            }
        } else if (jLabel1.getX() + 72 >= b.getLocation().getX() + b.getRadio()) {
            if ((jLabel1.getY() + 72 <= b.getLocation().getY()) && (b.getLocation().getY() <= jLabel1.getY() + 370)) {
                System.out.println("colision");
                P2DMath.invertX(b.getDelta());
            }
        } else if (jLabel1.getX() + 756 <= b.getLocation().getX() + b.getRadio()) {
            if ((jLabel1.getY() + 72 <= b.getLocation().getY()) && (b.getLocation().getY() <= jLabel1.getY() + 370)) {
                System.out.println("colision");
                P2DMath.invertX(b.getDelta());
            }
        }

        if (jLabel1.getY() + 72 >= b.getLocation().getY()) {
            if (jLabel1.getX() + 72 >= b.getLocation().getX()) {
                System.out.println("entro");
                return checkblanca(b);
            } else if (b.getLocation().getX() + b.getRadio() >= jLabel1.getX() + 399) {
                System.out.println("entro");
                return checkblanca(b);
            }
        } else if (jLabel1.getY() + 62 >= b.getLocation().getY()) {
            if ((jLabel1.getX() + 379 <= b.getLocation().getX()) && (b.getLocation().getX() <= jLabel1.getX() + 420)) {
                System.out.println("entro");
                return checkblanca(b);
            }
        } else if (b.getLocation().getY() >= jLabel1.getY() + 399) {
            if ((jLabel1.getX() + 379 <= b.getLocation().getX()) && (b.getLocation().getX() <= jLabel1.getX() + 420)) {
                System.out.println("entro");
                return checkblanca(b);
            }
        } else if (jLabel1.getY() + 409 <= b.getLocation().getY()) {
            System.out.println("abajo ");
            if (jLabel1.getX() + 72 >= b.getLocation().getX()) {
                System.out.println("entro");
                return checkblanca(b);
            } else if (b.getLocation().getX() >= jLabel1.getX() + 399) {
                System.out.println("entro");
                return checkblanca(b);
            }
        }
        
        return null;
    }

    private Bola checkblanca(Bola b) {
        if (bolas.get(0) == b) {
            b.setLocation(this.randomSpotSearcher());
            b.setDelta(0., 0.);
            return null;
        }
        return b;
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        taco = new proyectofinal.Taco();

        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MesaPool.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));
        setLayer(taco, 1);
        add(taco, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, -214, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.out.println(evt.getX() + " " + evt.getY());
    }//GEN-LAST:event_jLabel1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private proyectofinal.Taco taco;
    // End of variables declaration//GEN-END:variables
}
