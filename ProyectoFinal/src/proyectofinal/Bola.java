package proyectofinal;

import java.awt.*;

public class Bola {

    private final int numero;
    private double x, dx;
    private double y, dy;
    private final int tamano;

    public Bola(double x, double y, int numero) {
        this.numero = numero;
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.tamano = 30;
    }

    public void setDelta(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

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
        return tamano;
    }

    public void movimiento() {
        x += dx;
        y += dy;
    }

    public void momentunTransferToBola(Bola b) {
        double implsX;
        double implsY;

        double proporcion = (Math.PI / 2 - Math.abs(Math.atan2(
                b.getY() - y, b.getX() - x) - Math.atan2(dy, dx)))
                / (Math.PI / 2);

        if (proporcion < 0) {
            proporcion = 0;
        }

        implsX = Math.cos(Math.atan2(b.getY() - y, b.getX() - x)) * proporcion * Math.sqrt(dx * dx + dy * dy);
        implsY = Math.sin(Math.atan2(b.getY() - y, b.getX() - x)) * proporcion * Math.sqrt(dx * dx + dy * dy);

        b.addDelta(implsX, implsY);
        this.addDelta(-implsX, -implsY);
    }

    public void paint(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.fillOval((int) x - tamano / 2, (int) y - tamano / 2,
                tamano, tamano);
    }
}
