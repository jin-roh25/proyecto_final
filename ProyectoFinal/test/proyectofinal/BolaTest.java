/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectofinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
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
public class BolaTest {

    public BolaTest() {
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
     * Test of setColor method, of class Bola.
     */
    @Test
    public void testSetAndGetColor() {
        System.out.println("set/get Color");
        Color c = new Color(255, 255, 255);
        Bola instance = new Bola(0, 0);

        assertNotNull(instance.getColor());

        instance.setColor(c);

        assertSame(instance.getColor(), c);
    }

    /**
     * Test of setDelta method, of class Bola.
     */
    @Test
    public void testSetDelta_Point2D() {
        System.out.println("setDelta_Point2D");
        Point2D d = new Point2D.Double(1, 5);
        Bola instance = new Bola(0, 0);

        assertEquals(new Point2D.Double(0, 0), instance.getDelta());

        instance.setDelta(d);

        assertSame(d, instance.getDelta());
    }

    /**
     * Test of setDelta method, of class Bola.
     */
    @Test
    public void testSetDelta_double_double() {
        System.out.println("setDelta_double_double");
        double dx = 0.0;
        double dy = 5.0;
        Bola instance = new Bola(0, 0);

        assertEquals(new Point2D.Double(0, 0), instance.getDelta());

        instance.setDelta(dx, dy);

        assertEquals(new Point2D.Double(0, 5), instance.getDelta());
    }

    /**
     * Test of setLocation method, of class Bola.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        Point2D p = new Point2D.Double(1.3, 5);
        Bola instance = new Bola(1, 3);

        assertEquals(new Point2D.Double(1, 3), instance.getLocation());

        instance.setLocation(p);

        assertEquals(new Point2D.Double(1.3, 5), instance.getLocation());
    }

    /**
     * Test of getRadio method, of class Bola.
     */
    @Test
    public void testGetRadio() {
        System.out.println("getRadio");
        Bola instance = new Bola(0, 0);
        int expResult = 15;
        int result = instance.getRadio();
        assertEquals(expResult, result);
    }

    /**
     * Test of isMoving method, of class Bola.
     */
    @Test
    public void testIsMoving() {
        System.out.println("isMoving");
        Bola instance = new Bola(0, 0);
        boolean result = instance.isMoving();

        assertFalse(result);

        instance.setDelta(3, 0);

        assertTrue(instance.isMoving());
    }

    /**
     * Test of checkCollision method, of class Bola.
     */
    @Test
    public void testCheckCollision() {
        System.out.println("checkCollision");
        Bola b = new Bola(80, 100);
        b.setDelta(1, 0);
        Bola instance = new Bola(100, 100);

        instance.checkCollision(b);

    }

    /**
     * Test of unclip method, of class Bola.
     */
    @Test
    public void testUnclip() {
        System.out.println("unclip");
        Bola b = new Bola(100, 100);
        Bola instance = new Bola(90, 110);
        instance.setDelta(1, 0);

        instance.unclip(b);

        assertTrue(.001 > Math.abs(71.7157 - instance.getLocation().getX()));
        assertTrue(.001 > Math.abs(110 - instance.getLocation().getY()));

        instance.setLocation(new Point2D.Double(90, 100));
        instance.unclip(b);

        assertTrue(.001 > Math.abs(70 - instance.getLocation().getX()));
        assertTrue(.001 > Math.abs(100 - instance.getLocation().getY()));

        instance.setLocation(new Point2D.Double(40, 100));
        instance.unclip(b);

        assertTrue(.001 > Math.abs(70 - instance.getLocation().getX()));
        assertTrue(.001 > Math.abs(100 - instance.getLocation().getY()));
    }

    /**
     * Test of movimiento method, of class Bola.
     */
    @Test
    public void testMovimiento() {
        System.out.println("movimiento");
        double roce = 0;
        Bola instance = new Bola(0, 0);
        instance.setDelta(1, 0);

        assertEquals(new Point2D.Double(0, 0), instance.getLocation());

        instance.movimiento(roce);

        assertEquals(new Point2D.Double(1, 0), instance.getLocation());
        assertEquals(new Point2D.Double(1, 0), instance.getDelta());

        roce = .6;
        instance.movimiento(roce);

        assertEquals(new Point2D.Double(2, 0), instance.getLocation());
        assertTrue(.0001 > Math.abs(.4 - instance.getDelta().getX()));

    }

    /**
     * Test of momentunTransferToBola method, of class Bola.
     */
    @Test
    public void testMomentunTransferToBola() {
        System.out.println("momentunTransferToBola");
        Bola b = new Bola(100, 100);
        Bola instance = new Bola(60, 100);
        instance.setDelta(1, 0);

        instance.momentunTransferToBola(b);
        AsignationDelayer.getInstance().aplyHolded();

        assertTrue(.001 > Math.abs(1 - b.getDelta().getX()));
        assertTrue(.001 > Math.abs(0 - b.getDelta().getY()));
        assertTrue(.001 > Math.abs(0 - instance.getDelta().getX()));
        assertTrue(.001 > Math.abs(0 - instance.getDelta().getY()));

        b = new Bola(100, 100);
        instance = new Bola(75, 125);
        instance.setDelta(1, -1);
        
        instance.momentunTransferToBola(b);
        AsignationDelayer.getInstance().aplyHolded();

        assertTrue(.001 > Math.abs(1 - b.getDelta().getX()));
        assertTrue(.001 > Math.abs(-1 - b.getDelta().getY()));
        assertTrue(.001 > Math.abs(0 - instance.getDelta().getX()));
        assertTrue(.001 > Math.abs(0 - instance.getDelta().getY()));
                
        b = new Bola(100, 100);
        instance = new Bola(78.78679656, 121.21320344);
        instance.setDelta(1, 0);
        
        instance.momentunTransferToBola(b);
        AsignationDelayer.getInstance().aplyHolded();

        assertTrue(.001 > Math.abs(0.5 - b.getDelta().getX()));
        assertTrue(.001 > Math.abs(-0.5 - b.getDelta().getY()));
        assertTrue(.001 > Math.abs(0.5 - instance.getDelta().getX()));
        assertTrue(.001 > Math.abs(0.5 - instance.getDelta().getY()));
    }

    /**
     * Test of paint method, of class Bola.
     */
    @Test
    public void testPaint() {
        System.out.println("paint");
        JFrame frm = new JFrame();
        frm.setVisible(true);
        Graphics g = frm.getGraphics();
        Bola instance = new Bola(0, 0);
        instance.paint(g);
        
        assertSame(g.getColor(),instance.getColor());
    }

}
