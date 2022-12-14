/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * varias funciones para trabajar con Puntos2D como vectores.
 *
 * @author Keyteer
 * @author segonzalez2021
 */
public class P2DMath {


    private P2DMath() {
    }

    /**
     *
     * @param p Point2D
     * @return p casteado como Point
     */
    public static Point toIntPoint(Point2D p) {
        return new Point((int) p.getX(), (int) p.getY());
    }

    /**
     *
     * @param p Point
     * @return p casteado como Point2D.double
     */
    public static Point2D toPoint2D(Point p) {
        return new Point2D.Double(p.getX(), p.getY());
    }

    /**
     *
     * @param p vector recivido
     * @return vector p multiplicado por -1
     */
    public static Point2D getNegative(Point2D p) {
        return new Point2D.Double(-p.getX(), -p.getY());
    }

    /**
     * suma de 2 vectores
     *
     * @return vector resultante
     */
    public static Point2D add(Point2D a, Point2D b) {
        return new Point2D.Double(a.getX() + b.getX(), a.getY() + b.getY());
    }

    /**
     * resta de 2 vectores
     *
     * @param a vector positivo
     * @param b vector negativo
     * @return vector resultante
     */
    public static Point2D subtract(Point2D a, Point2D b) {
        return new Point2D.Double(a.getX() - b.getX(), a.getY() - b.getY());
    }

    /**
     * calcula el angulo del vector p desde el eje x positivo
     */
    public static double getAngle(Point2D p) {
        return Math.atan2(p.getY(), p.getX());
    }

    /**
     * diferencia de angulos entre 2 vectores
     *
     * @param p1 vector con angulo de referencia
     * @param p2 vector con angulo medido
     * @return resultado double
     */
    public static double angleDiff(Point2D p1, Point2D p2) {
        return Math.atan2(p1.getY(), p1.getX())
                - Math.atan2(p2.getY(), p2.getX());
    }

    /**
     * magnitud de un vector
     *
     * @param p vector
     * @return resultado double
     */
    public static double getMagnitude(Point2D p) {
        return Math.sqrt(Math.pow(p.getX(), 2) + Math.pow(p.getY(), 2));
    }

    /**
     * magnitud de un vector
     *
     * @param a coordenada x
     * @param b coordenada y
     * @return resultado double
     */
    public static double getMagnitude(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    /**
     * genera un vector Point2D a partir de coordenadas polares
     */
    public static Point2D polarToPoint(double magnitude, double angle) {
        return new Point2D.Double(magnitude * Math.cos(angle), magnitude * Math.sin(angle));
    }

    /**
     * combina la magnitud de un vector con el angulo de otro
     *
     * @return resultado Point2D
     */
    public static Point2D combine(Point2D pMag, Point2D pAng) {
        return polarToPoint(getMagnitude(pMag), getAngle(pAng));
    }

    /**
     * combina una magnitud con el angulo de un vector
     *
     * @return resultado Point2D
     */
    public static Point2D combine(double mag, Point2D pAng) {
        return polarToPoint(mag, getAngle(pAng));
    }

    /**
     * combina la magnitud de un vector con un angulo
     *
     * @return resultado Point2D
     */
    public static Point2D combine(Point2D pMag, double ang) {
        return polarToPoint(getMagnitude(pMag), ang);
    }
    
    public static Point2D invertX(Point2D p){
        
        p.setLocation(-p.getX(), p.getY()); 
        
        return p;
    }
    
    public static Point2D invertY(Point2D p){
        
        p.setLocation(p.getX(), -p.getY()); 
        
        return p;
    }
}
