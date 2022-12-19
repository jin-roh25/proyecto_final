/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectofinal;

import java.awt.Graphics;
import java.beans.PropertyChangeListener;
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
public class MesaPoolTest {

    boolean testFlag;

    public MesaPoolTest() {
        testFlag = false;
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testFlag = false;
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addPropertyChangeListener method, of class MesaPool.
     */
    @Test
    public void testAddPropertyChangeListener() {
        System.out.println("addPropertyChangeListener");
        MesaPool instance = new MesaPool();

        PropertyChangeListener l = new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                testFlag = true;
            }
        };

        instance.addPropertyChangeListener(l);
        instance.setPuntaje(1);

        assertTrue(testFlag);

        testFlag = false;

        instance.removePropertyChangeListener(l);
        instance.setPuntaje(2);

        assertFalse(testFlag);

    }

    /**
     * Test of setPuntaje method, of class MesaPool.
     */
    @Test
    public void testSetPuntaje() {
        System.out.println("setPuntaje");
        int puntaje = 13;
        MesaPool instance = new MesaPool();

        assertEquals(0, instance.getPuntaje());

        instance.setPuntaje(puntaje);

        assertEquals(puntaje, instance.getPuntaje());
    }

    /**
     * Test of addBola method, of class MesaPool.
     */
    @Test
    public void testAddBola() {
        System.out.println("addBola");
        MesaPool instance = new MesaPool();

        assertEquals(1, instance.getBolas().size());

        instance.addBola();
        instance.addBola();

        assertEquals(3, instance.getBolas().size());

        instance.clearBolas();

        assertEquals(1, instance.getBolas().size());
    }

    /**
     * Test of reset method, of class MesaPool.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        int nBolas = 5;
        MesaPool instance = new MesaPool();

        assertEquals(1, instance.getBolas().size());

        instance.reset(nBolas);

        assertEquals(nBolas, instance.getBolas().size());
    }
}
