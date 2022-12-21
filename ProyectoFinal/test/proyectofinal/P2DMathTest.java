/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectofinal;

import java.awt.Point;
import java.awt.geom.Point2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class P2DMathTest {

    public P2DMathTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of toIntPoint method, of class P2DMath.
     */
    @Test
    public void testToIntPoint() {
        System.out.println("toIntPoint");
        Point2D p = new Point2D.Double(21, 12);
        Point expResult = new Point(21, 12);
        Point result = P2DMath.toIntPoint(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of toPoint2D method, of class P2DMath.
     */
    @Test
    public void testToPoint2D() {
        System.out.println("toPoint2D");
        Point p = new Point(10, 20);
        Point2D expResult = new Point2D.Double(10, 20);
        Point2D result = P2DMath.toPoint2D(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNegative method, of class P2DMath.
     */
    @Test
    public void testGetNegative() {
        System.out.println("getNegative");
        Point2D p = new Point2D.Double(10, 20);
        Point2D expResult = new Point2D.Double(-10, -20);
        Point2D result = P2DMath.getNegative(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class P2DMath.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Point2D a = new Point2D.Double(10, 20);
        Point2D b = new Point2D.Double(20, 10);
        Point2D expResult = new Point2D.Double(30, 30);
        Point2D result = P2DMath.add(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of subtract method, of class P2DMath.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        Point2D a = new Point2D.Double(10, 20);
        Point2D b = new Point2D.Double(20, 10);
        Point2D expResult = new Point2D.Double(-10, 10);
        Point2D result = P2DMath.subtract(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAngle method, of class P2DMath.
     */
    @Test
    public void testGetAngle() {
        System.out.println("getAngle");
        Point2D p = new Point2D.Double(3, 3);
        double expResult = Math.PI / 4;
        double result = P2DMath.getAngle(p);

        assertTrue(.001 > Math.abs(expResult - result));
    }

    /**
     * Test of angleDiff method, of class P2DMath.
     */
    @Test
    public void testAngleDiff() {
        System.out.println("angleDiff");
        Point2D p1 = new Point2D.Double(3, 3);
        Point2D p2 = new Point2D.Double(-3, 3);
        double expResult = -Math.PI / 2;
        double result = P2DMath.angleDiff(p1, p2);

        assertTrue(.001 > Math.abs(expResult - result));
    }

    /**
     * Test of getMagnitude method, of class P2DMath.
     */
    @Test
    public void testGetMagnitude_Point2D() {
        System.out.println("getMagnitude");
        Point2D p = new Point2D.Double(1, 1);
        double expResult = Math.sqrt(2);
        double result = P2DMath.getMagnitude(p);

        assertTrue(.001 > Math.abs(expResult - result));
    }

    /**
     * Test of getMagnitude method, of class P2DMath.
     */
    @Test
    public void testGetMagnitude_double_double() {
        System.out.println("getMagnitude");
        double a = 1;
        double b = 1;
        double expResult = Math.sqrt(2);
        double result = P2DMath.getMagnitude(a, b);

        assertTrue(.001 > Math.abs(expResult - result));
    }

    /**
     * Test of polarToPoint method, of class P2DMath.
     */
    @Test
    public void testPolarToPoint() {
        System.out.println("polarToPoint");
        double magnitude = Math.sqrt(2);
        double angle = Math.PI / 4;
        Point2D expResult = new Point2D.Double(1, 1);
        Point2D result = P2DMath.polarToPoint(magnitude, angle);

        assertTrue(.001 > Math.abs(expResult.getX() - result.getX()));
        assertTrue(.001 > Math.abs(expResult.getY() - result.getY()));
    }

    /**
     * Test of invertX method, of class P2DMath.
     */
    @Test
    public void testInvertX() {
        System.out.println("invertX");
        Point2D p = new Point2D.Double(10, 20);
        Point2D expResult = new Point2D.Double(-10, 20);
        Point2D result = P2DMath.invertX(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of invertY method, of class P2DMath.
     */
    @Test
    public void testInvertY() {
        System.out.println("invertY");
        Point2D p = new Point2D.Double(10, 20);
        Point2D expResult = new Point2D.Double(10, -20);
        Point2D result = P2DMath.invertY(p);
        assertEquals(expResult, result);
    }

}
