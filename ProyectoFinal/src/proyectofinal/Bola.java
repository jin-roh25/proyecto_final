package proyectofinal;

import java.awt.*;

/**
 * Bola de billar. simula las fisicas de una bola de billar
 *
 * @author Keyteer
 * @author segonzalez2021
 * @version versión 0.2.1, 27 de noviembre de 2022
 */
public class Bola {

    /**
     * Color de la bola
     */
    private final Color color;

    /**
     * posición y veloidad
     */
    private double x, dx;
    private double y, dy;

    /**
     * diametro de la bola
     */
    private final int Diametro;

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
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.Diametro = 30;
    }

    public void setDelta(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * suma una velocidad en vez de sobreescribirla
     * @param dx velocidad lateral añadida
     * @param dy velocidad horizontal añadida
     */
    public void addDelta(double dx, double dy) {
        this.dx += dx;
        this.dy += dy;
    }

    public double getDX() {
        return dx;
    }

    public double getDY() {
        return dy;
    }

    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getTamaño() {
        return Diametro;
    }

    /**
     * avanza la bola respecto a la velocidad que lleva
     *
     * @param roce velocidad que se le resta a la bola por cada llamado
     */
    public void movimiento(Double roce) {
        x += dx;
        y += dy;

        if (dx > roce) {
            dx -= roce;
        } else if (dx < -roce) {
            dx += roce;
        } else {
            dx = 0;
        }

        if (dy > roce) {
            dy -= roce;
        } else if (dy < -roce) {
            dy += roce;
        } else {
            dy = 0;
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
        double implsX;
        double implsY;

        double porcion = (Math.PI / 2 - Math.abs(Math.atan2(
                b.getY() - y, b.getX() - x) - Math.atan2(dy, dx)))
                / (Math.PI / 2);

        if (porcion < 0) {
            porcion = 0;
        }

        implsX = Math.cos(Math.atan2(b.getY() - y, b.getX() - x))
                * porcion * Math.sqrt(dx * dx + dy * dy);
        implsY = Math.sin(Math.atan2(b.getY() - y, b.getX() - x))
                * porcion * Math.sqrt(dx * dx + dy * dy);

        b.addDelta(implsX, implsY);
        this.addDelta(-implsX, -implsY);
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval((int) x - Diametro / 2, (int) y - Diametro / 2,
                Diametro, Diametro);
    }
}
