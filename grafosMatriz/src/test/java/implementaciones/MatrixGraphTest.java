/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package implementaciones;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marco
 */
public class MatrixGraphTest {
    
    public MatrixGraphTest() {
    }

    /**
     * Test of addVertex method, of class MatrixGraph.
     */
    @Test
    public void testAddVertex() {
        System.out.println("addVertex");
        Object etiqueta = null;
        MatrixGraph instance = null;
        instance.addVertex(etiqueta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasVertex method, of class MatrixGraph.
     */
    @Test
    public void testHasVertex() {
        System.out.println("hasVertex");
        Object etiqueta = null;
        MatrixGraph instance = null;
        boolean expResult = false;
        boolean result = instance.hasVertex(etiqueta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of indexOf method, of class MatrixGraph.
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        Object etiqueta = null;
        MatrixGraph instance = null;
        int expResult = 0;
        int result = instance.indexOf(etiqueta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberVertices method, of class MatrixGraph.
     */
    @Test
    public void testGetNumberVertices() {
        System.out.println("getNumberVertices");
        MatrixGraph instance = null;
        int expResult = 0;
        int result = instance.getNumberVertices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of empty method, of class MatrixGraph.
     */
    @Test
    public void testEmpty() {
        System.out.println("empty");
        MatrixGraph instance = null;
        boolean expResult = false;
        boolean result = instance.empty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class MatrixGraph.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MatrixGraph instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeVertex method, of class MatrixGraph.
     */
    @Test
    public void testRemoveVertex() {
        System.out.println("removeVertex");
        Object etiqueta = null;
        MatrixGraph instance = null;
        instance.removeVertex(etiqueta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVertices method, of class MatrixGraph.
     */
    @Test
    public void testGetVertices() {
        System.out.println("getVertices");
        MatrixGraph instance = null;
        LinkedList expResult = null;
        LinkedList result = instance.getVertices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class MatrixGraph.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        MatrixGraph instance = null;
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    
    
}
