/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Singleton Holder para retrasar la asignacion de puntos2D
 *
 * @author Keyteer
 * @author segonzalez2021
 */
public class AsignationDelayer {

    /**
     * lista de asignaciones retrasadas
     */
    private final ArrayList<Point2D[]> points;

    /**
     * instancia unica
     */
    private static final AsignationDelayer instance = new AsignationDelayer();

    private AsignationDelayer() {
        points = new ArrayList<>();
    }

    /**
     * obtener intsncia unica
     *
     * @return instancia
     */
    public static AsignationDelayer getInstance() {
        return instance;
    }

    /**
     * guarda una asignacion para hacerla efectiva al llamar a aplyHolded()
     *
     * @param p vector modificado
     * @param pAsign asignacion
     */
    public void holdAsign(Point2D p, Point2D pAsign) {
        points.add(new Point2D[]{p, pAsign});
    }

    /**
     * aplica todas las asignaciones retenidas
     */
    public void aplyHolded() {
        for (Point2D[] arr : points) {
            arr[0].setLocation(arr[1]);
        }
    }
}
