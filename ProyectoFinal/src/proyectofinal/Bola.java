package proyectofinal;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Bola de billar. simula las fisicas de una bola de billar
 *
 * @author Keyteer
 * @author segonzalez2021
 * @version versión 2.0, 2 de diciembre, 2022
 */
public class Bola {

    /**
     * Color de la bola
     */
    private Color color;

    /**
     * posición y veloidad
     */
    private Point2D location, delta;

    /**
     * radio de la bola
     */
    private final int radio;

    /**
     * Constructor, genera un color aleatorio, velocidad inicial nula y un
     * diametro por defecto de 30 pixeles
     *
     * @param x coordenada x double
     * @param y coordenada y double
     */
    public Bola(double x, double y) {
        this.color = new Color((float) Math.random(),
                (float) Math.random(), (float) Math.random());
        this.location = new Point2D.Double(x, y);
        this.delta = new Point2D.Double();
        this.radio = 15;
    }
    
    /**
     * Constructor, genera un color aleatorio, velocidad inicial nula y un
     * diametro por defecto de 30 pixeles
     *
     * @param location posicion inicial
     */
    public Bola(Point2D.Double location) {
        this.color = new Color((float) Math.random(),
                (float) Math.random(), (float) Math.random());
        this.location = location;
        this.delta = new Point2D.Double();
        this.radio = 15;
    }

    public void setColor(Color c) {
        this.color = c;
    }
    
    public Color getColor() {
        return this.color;
    }

    public void setDelta(Point2D d) {
        this.delta = d;
    }

    public void setDelta(Double dx, double dy) {
        this.delta = new Point2D.Double(dx, dy);
    }

    public Point2D getDelta() {
        return delta;
    }

    public void setLocation(Point2D p) {
        this.location = p;
    }

    public Point2D getLocation() {
        return location;
    }

    public int getRadio() {
        return radio;
    }

    /**
     * revisa con una tolerancia, si la velocidad es mayor a cero
     *
     * @return true si se esta moviendo
     */
    public Boolean isMoving() {
        return delta.getX() < Math.nextDown(0) || delta.getX() > Math.nextUp(0)
                || delta.getY() < Math.nextDown(0) || delta.getY() > Math.nextUp(0);
    }

    /**
     * revisa si existe una colisión entre dos bolas y aplica una transferencia
     * de momuntum en caso verdadero
     *
     * @param b segunda bola
     */
    public void checkCollisionBola(Bola b) {
        if (radio + b.getRadio() >= location.distance(b.getLocation())) {

            this.momentunTransferToBola(b);

            //System.out.println(this + " --" + location.distance(b.getLocation()) + "-> " + b);
        }
    }

    /**
     * avanza la bola respecto a la velocidad que lleva
     *
     * @param roce velocidad que se le resta a la bola por cada llamado
     */
    public void movimiento(Double roce) {

        P2DMath.getInstance().aplyHolded();

        location = P2DMath.add(location, delta);

        if (P2DMath.getMagnitude(delta) > roce) {
            delta = P2DMath.subtract(delta, P2DMath.combine(roce, delta));
        } else {
            delta = new Point2D.Double(0, 0);
        }
    }

    /**
     * transfiere un porcentaje del momentum de la bola de origen a la bola
     * recivida como parametro. El porcentaje se calculo en función del angulo
     * del angulo que se forma entre la dirección de movimiento del la bola de
     * origen y el angulo que se forma entre una bola y la otra
     *
     * @param b bola a la que se le transfiere el momentum
     */
    public void momentunTransferToBola(Bola b) {
        //System.out.println("colision de " + this + " con " + b);

        double porcentaje = (Math.PI / 2 - Math.abs(P2DMath.angleDiff(delta,
                P2DMath.subtract(b.getLocation(), location)))) / (Math.PI / 2);

        if (porcentaje < 0) {
            porcentaje = 0;
        }
        System.out.println(porcentaje);
        Point2D impulso = P2DMath.combine(P2DMath.getMagnitude(delta) * porcentaje,
                P2DMath.subtract(b.getLocation(), location));

        P2DMath.getInstance().holdAsign(b.getDelta(), P2DMath.add(b.getDelta(), impulso));
        P2DMath.getInstance().holdAsign(delta, P2DMath.add(delta, P2DMath.getNegative(impulso)));
    }

    /**
     * pinta un circulo con el color y tamaño de la bola
     *
     * @param g Graphics con los que se pinta
     */
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval((int) location.getX() - radio, (int) location.getY() - radio,
                radio * 2, radio * 2);
    }
}
