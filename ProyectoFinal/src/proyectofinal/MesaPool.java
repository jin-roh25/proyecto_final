package proyectofinal;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import javax.swing.*;
import java.util.ArrayList;
import org.netbeans.lib.awtextra.*;

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

    private int puntaje;

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
        puntaje = 0;

        taco.setBola(bolas.get(0));

        time = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                moverBolas();
            }
        });
        time.start();
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void addBola() {
        bolas.add(new Bola(randomSpotSearcher()));
    }

    public void clearBolas() {
        bolas.retainAll(bolas.subList(0, 1));
        bolas.get(0).setLocation(randomSpotSearcher());
        bolas.get(0).setDelta(0., 0.);
        puntaje = 0;
        jLabel2.setText("PUNTAJE: " + Integer.toString(puntaje));
    }

    private Point2D randomSpotSearcher() {
        Point2D p = null;
        Boolean disponible = false;

        while (!disponible) { // ¡¡¡¡¡¡rocordar ajustar los random para quedar dentro del area de
            // juego!!!!!!!!!!!
            p = new Point2D.Double(mesa.getX() + 72 + Math.random() * (mesa.getWidth() - 132),
                    mesa.getY() + 72 + Math.random() * (mesa.getHeight() - 132));
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
        ArrayList rmBolas = new ArrayList();

        for (Bola b : bolas) {
            if (b.isMoving()) {
                movimiento = true;

                for (Bola b2 : bolas) {
                    if (b2 != b) {
                        b.checkCollision(b2);
                    }
                }
                Bola bolaRm = checkCollision(b);
                if (bolaRm != null) {
                    rmBolas.add(checkCollision(b));
                }
            }
        }

        puntaje += rmBolas.size();
        jLabel2.setText("PUNTAJE: " + Integer.toString(puntaje));
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

        if (mesa.getY() + 72 >= b.getLocation().getY() + b.getRadio()) {
            if ((mesa.getX() + 72 <= b.getLocation().getX()) && (b.getLocation().getX() <= mesa.getX() + 379)) {
                P2DMath.invertY(b.getDelta());

            } else if ((mesa.getX() + 420 <= b.getLocation().getX()) && (b.getLocation().getX() <= mesa.getX() + 728)) {
                P2DMath.invertY(b.getDelta());
            }
        } else if (b.getLocation().getY() + b.getRadio() >= mesa.getY() + 399) {
            if ((mesa.getX() + 72 <= b.getLocation().getX()) && (b.getLocation().getX() <= mesa.getX() + 379)) {
                P2DMath.invertY(b.getDelta());
            } else if ((mesa.getX() + 420 <= b.getLocation().getX()) && (b.getLocation().getX() <= mesa.getX() + 728)) {
                P2DMath.invertY(b.getDelta());
            }
        } else if (mesa.getX() + 72 >= b.getLocation().getX() + b.getRadio()) {
            if ((mesa.getY() + 72 <= b.getLocation().getY()) && (b.getLocation().getY() <= mesa.getY() + 370)) {
                P2DMath.invertX(b.getDelta());
            }
        } else if (mesa.getX() + 756 <= b.getLocation().getX() + b.getRadio()) {
            if ((mesa.getY() + 72 <= b.getLocation().getY()) && (b.getLocation().getY() <= mesa.getY() + 370)) {
                P2DMath.invertX(b.getDelta());
            }
        }

        if (mesa.getY() + 72 >= b.getLocation().getY()) {
            if (mesa.getX() + 72 >= b.getLocation().getX()) {
                return checkblanca(b);
            } else if (b.getLocation().getX() + b.getRadio() >= mesa.getX() + 399) {
                return checkblanca(b);
            }
        } else if (mesa.getY() + 62 >= b.getLocation().getY()) {
            if ((mesa.getX() + 379 <= b.getLocation().getX()) && (b.getLocation().getX() <= mesa.getX() + 420)) {
                return checkblanca(b);
            }
        } else if (b.getLocation().getY() >= mesa.getY() + 399) {
            if ((mesa.getX() + 379 <= b.getLocation().getX()) && (b.getLocation().getX() <= mesa.getX() + 420)) {
                return checkblanca(b);
            }
        } else if (mesa.getY() + 409 <= b.getLocation().getY()) {
            if (mesa.getX() + 72 >= b.getLocation().getX()) {
                return checkblanca(b);
            } else if (b.getLocation().getX() >= mesa.getX() + 399) {
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

        AbsoluteConstraints bounds = new AbsoluteConstraints(mesa.getX(), mesa.getY(), -1, -1);
        this.remove(mesa);
        super.paint(g);
        this.add(mesa, bounds);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mesa = new javax.swing.JLabel();
        taco = new proyectofinal.Taco();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MesaPool.png"))); // NOI18N
        add(mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));
        setLayer(taco, 1);
        add(taco, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, -214, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("PUNTAJE: " + Integer.toString(puntaje));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 60));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel mesa;
    private proyectofinal.Taco taco;
    // End of variables declaration//GEN-END:variables
}
