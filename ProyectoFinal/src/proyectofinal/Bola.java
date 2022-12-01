package proyectofinal;

import java.awt.*;

/**
 * Bola de billar. simula las fisicas de una bola de billar
 *
 * @author Keyteer
 * @author segonzalez2021
 * @version versión 1.0, 1 de diciembre, 2022
 */
public class Bola {

    /**
     * Color de la bola
     */
    private final Color color;

    /**
     * posición, veloidad e impulso instantaneo
     */
    private double x, dx, implsX;
    private double y, dy, implsY;

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
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.radio = 15;
    }

    public void addImpls(double implsX, double implsY) {
        this.implsX += implsX;
        this.implsY += implsY;
    }

    public void setDelta(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
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

    public int getRadio() {
        return radio;
    }

    /**
     * revisa con una tolerancia, si la velocidad es mayor a cero
     *
     * @return true si se esta moviendo
     */
    public Boolean isMoving() {
        return dx < Math.nextDown(0) || dx > Math.nextUp(0)
                || dy < Math.nextDown(0) || dy > Math.nextUp(0);
    }

    /**
     * revisa si existe una colisión entre dos bolas y aplica una transferencia
     * de momuntum en caso verdadero
     *
     * @param b segunda bola
     */
    public void checkCollisionBola(Bola b) {
        if ((radio + b.getRadio()) >= Math.sqrt(
                Math.pow(b.getX() - x, 2) + Math.pow(b.getY() - y, 2))) {

            this.unClip(b);
            this.momentunTransferToBola(b);

            //System.out.println(this + " --" + Math.sqrt(Math.pow(b.getX() - x, 2) + Math.pow(b.getY() - y, 2)) + "-> " + b);
        }
    }

    /**
     * avanza la bola respecto a la velocidad que lleva
     *
     * @param roce velocidad que se le resta a la bola por cada llamado
     */
    public void movimiento(Double roce) {

        dx += implsX;
        dy += implsY;

        x += dx;
        y += dy;

        if (Math.abs(dx) > roce) {
            dx -= Math.copySign(roce, dx);
        } else {
            dx = 0;
        }

        if (Math.abs(dy) > roce) {
            dy -= Math.copySign(roce, dy);
        } else {
            dy = 0;
        }

        implsX = 0;
        implsY = 0;
    }

    public void unClip(Bola b) {
        this.setLocation(x - Math.cos(Math.atan2(dy, dx)) * (radio + b.getRadio()
                - Math.sqrt(Math.pow(x - b.getX(), 2) + Math.pow(y - b.getY(), 2))),
                y - Math.sin(Math.atan2(dy, dx)) * (radio + b.getRadio()
                - Math.sqrt(Math.pow(x - b.getX(), 2) + Math.pow(y - b.getY(), 2))));
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

        double iX = 0, iY = 0;

        double porcion = (Math.PI / 2 - Math.abs(Math.atan2(
                b.getY() - y, b.getX() - x) - Math.atan2(dy, dx)))
                / (Math.PI / 2);

        if (porcion < 0) {
            porcion = 0;
        }
        iX += Math.cos(Math.atan2(b.getY() - y, b.getX() - x))
                * porcion * Math.sqrt(dx * dx + dy * dy);
        iY += Math.sin(Math.atan2(b.getY() - y, b.getX() - x))
                * porcion * Math.sqrt(dx * dx + dy * dy);

        b.addImpls(iX, iY);
        this.addImpls(-iX, -iY);
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval((int) x - radio, (int) y - radio,
                radio * 2, radio * 2);
    }
}
