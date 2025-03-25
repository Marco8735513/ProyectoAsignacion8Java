/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package implementaciones;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marco
 */
public class MatrixNoDiGraphTest {
    
    public MatrixNoDiGraphTest() {
    }

    /**
     * Test of addEdge method, of class MatrixNoDiGraph.
     */
    @Test
    public void testAddEdge_3args() {
        System.out.println("addEdge");
        Object etqX = null;
        Object etqY = null;
        double peso = 0.0;
        MatrixNoDiGraph instance = null;
        instance.addEdge(etqX, etqY, peso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEdge method, of class MatrixNoDiGraph.
     */
    @Test
    public void testAddEdge_GenericType_GenericType() {
        System.out.println("addEdge");
        Object etqX = null;
        Object etqY = null;
        MatrixNoDiGraph instance = null;
        instance.addEdge(etqX, etqY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasEdge method, of class MatrixNoDiGraph.
     */
    @Test
    public void testHasEdge() {
        System.out.println("hasEdge");
        Object etqX = null;
        Object etqY = null;
        MatrixNoDiGraph instance = null;
        boolean expResult = false;
        boolean result = instance.hasEdge(etqX, etqY);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEdgeWeight method, of class MatrixNoDiGraph.
     */
    @Test
    public void testGetEdgeWeight() {
        System.out.println("getEdgeWeight");
        Object etqX = null;
        Object etqY = null;
        MatrixNoDiGraph instance = null;
        double expResult = 0.0;
        double result = instance.getEdgeWeight(etqX, etqY);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeEdge method, of class MatrixNoDiGraph.
     */
    @Test
    public void testRemoveEdge() {
        System.out.println("removeEdge");
        Object etqX = null;
        Object etqY = null;
        MatrixNoDiGraph instance = null;
        instance.removeEdge(etqX, etqY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEdgeWeight method, of class MatrixNoDiGraph.
     */
    @Test
    public void testSetEdgeWeight() {
        System.out.println("setEdgeWeight");
        Object etqX = null;
        Object etqY = null;
        double peso = 0.0;
        MatrixNoDiGraph instance = null;
        instance.setEdgeWeight(etqX, etqY, peso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberEdges method, of class MatrixNoDiGraph.
     */
    @Test
    public void testGetNumberEdges() {
        System.out.println("getNumberEdges");
        MatrixNoDiGraph instance = null;
        int expResult = 0;
        int result = instance.getNumberEdges();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
