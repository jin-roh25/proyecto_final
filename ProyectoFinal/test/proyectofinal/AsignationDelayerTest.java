/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectofinal;

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
public class AsignationDelayerTest {

    public AsignationDelayerTest() {
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
     * Test of getInstance method, of class AsignationDelayer.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        AsignationDelayer result = AsignationDelayer.getInstance();

        assertNotNull(result);
    }

    /**
     * Test of holdAsign method, of class AsignationDelayer.
     */
    @Test
    public void testHoldAsign() {
        System.out.println("holdAsign");
        Point2D p = new Point2D.Double(1, 2);
        Point2D pAsign = new Point2D.Double(6, 2);
        AsignationDelayer instance = AsignationDelayer.getInstance();

        instance.holdAsign(p, pAsign);

        assertEquals(new Point2D.Double(1, 2), p);

        instance.aplyHolded();

        assertEquals(p, pAsign);
    }
}
