/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectofinal;

import java.awt.Graphics;
import java.awt.Point;
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
public class TacoTest {

    public TacoTest() {
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
     * Test of setBola method, of class Taco.
     */
    @Test
    public void testSetBola() {
        System.out.println("setBola");
        Bola b = new Bola(100, 100);
        Taco instance = new Taco();

        assertEquals(new Point(0, 0), instance.getLocation());

        instance.setBola(b);

        assertEquals(new Point(100, 100), instance.getLocation());
    }
}
