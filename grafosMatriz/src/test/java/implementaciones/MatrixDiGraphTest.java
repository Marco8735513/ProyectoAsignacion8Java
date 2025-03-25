package implementaciones;

import excepciones.GraphException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de pruebas unitarias para la clase MatrixDiGraph.
 * Verifica el correcto funcionamiento de un grafo dirigido implementado con matriz de adyacencia.
 * 
 * @author TuNombre
 */
public class MatrixDiGraphTest {
    
    private MatrixDiGraph<String> grafo;
    
    /**
     * Configuración inicial antes de cada prueba.
     * Crea un grafo dirigido con capacidad para 5 vértices y añade tres vértices básicos.
     * 
     * @throws GraphException si ocurre un error al añadir los vértices iniciales
     */
    @Before
    public void setUp() throws GraphException {
        grafo = new MatrixDiGraph<>(5);
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addVertex("C");
    }

    /**
     * Prueba el método addEdge con peso.
     * Verifica que se pueda añadir una arista con peso y que esta quede registrada correctamente.
     * 
     * @throws GraphException si ocurre un error al añadir la arista
     */
    @Test
    public void testAddEdge_3args() throws GraphException {
        grafo.addEdge("A", "B", 2.5);
        assertTrue("La arista A->B debería existir", grafo.hasEdge("A", "B"));
        assertEquals("El peso de la arista debería ser 2.5", 2.5, grafo.getEdgeWeight("A", "B"), 0.001);
    }

    /**
     * Prueba que addEdge lance excepción al intentar añadir una arista ya existente.
     */
    @Test(expected = GraphException.class)
    public void testAddEdge_3args_conAristaExistente() throws GraphException {
        grafo.addEdge("A", "B", 1.0);
        grafo.addEdge("A", "B", 2.0); // Debe lanzar excepción
    }

    /**
     * Prueba el método addEdge sin peso especificado (peso por defecto 0).
     * 
     * @throws GraphException si ocurre un error al añadir la arista
     */
    @Test
    public void testAddEdge_GenericType_GenericType() throws GraphException {
        grafo.addEdge("B", "C");
        assertTrue("La arista B->C debería existir", grafo.hasEdge("B", "C"));
        assertEquals("El peso por defecto debería ser 0", 0.0, grafo.getEdgeWeight("B", "C"), 0.001);
    }

    /**
     * Prueba el método hasEdge con una arista existente y una no existente.
     * 
     * @throws GraphException si ocurre un error al verificar la arista
     */
    @Test
    public void testHasEdge() throws GraphException {
        grafo.addEdge("A", "C", 1.0);
        assertTrue("La arista A->C debería existir", grafo.hasEdge("A", "C"));
        assertFalse("La arista C->A no debería existir (grafo dirigido)", grafo.hasEdge("C", "A"));
    }

    /**
     * Prueba que hasEdge lance excepción con vértices inválidos.
     */
    @Test(expected = GraphException.class)
    public void testHasEdge_conVerticesInvalidos() throws GraphException {
        grafo.hasEdge("A", "X"); // X no existe
    }

    /**
     * Prueba el método getEdgeWeight con una arista existente.
     * 
     * @throws GraphException si ocurre un error al obtener el peso
     */
    @Test
    public void testGetEdgeWeight() throws GraphException {
        grafo.addEdge("B", "A", 3.0);
        assertEquals("El peso debería ser 3.0", 3.0, grafo.getEdgeWeight("B", "A"), 0.001);
    }

    /**
     * Prueba que getEdgeWeight lance excepción con una arista inexistente.
     */
    @Test(expected = GraphException.class)
    public void testGetEdgeWeight_conAristaInexistente() throws GraphException {
        grafo.getEdgeWeight("A", "B"); // No existe la arista
    }

    /**
     * Prueba el método removeEdge con una arista existente.
     * 
     * @throws GraphException si ocurre un error al eliminar la arista
     */
    @Test
    public void testRemoveEdge() throws GraphException {
        grafo.addEdge("A", "B", 1.0);
        grafo.removeEdge("A", "B");
        assertFalse("La arista A->B ya no debería existir", grafo.hasEdge("A", "B"));
    }

    /**
     * Prueba que removeEdge lance excepción con una arista inexistente.
     */
    @Test(expected = GraphException.class)
    public void testRemoveEdge_conAristaInexistente() throws GraphException {
        grafo.removeEdge("C", "A"); // No existe la arista
    }

    /**
     * Prueba el método setEdgeWeight modificando el peso de una arista existente.
     * 
     * @throws GraphException si ocurre un error al modificar el peso
     */
    @Test
    public void testSetEdgeWeight() throws GraphException {
        grafo.addEdge("C", "B", 1.0);
        grafo.setEdgeWeight("C", "B", 5.0);
        assertEquals("El nuevo peso debería ser 5.0", 5.0, grafo.getEdgeWeight("C", "B"), 0.001);
    }

    /**
     * Prueba que setEdgeWeight lance excepción con una arista inexistente.
     */
    @Test(expected = GraphException.class)
    public void testSetEdgeWeight_conAristaInexistente() throws GraphException {
        grafo.setEdgeWeight("A", "C", 2.0); // No existe la arista
    }

    /**
     * Prueba el método getNumberEdges con diferentes cantidades de aristas.
     * 
     * @throws GraphException si ocurre un error al añadir aristas
     */
    @Test
    public void testGetNumberEdges() throws GraphException {
        assertEquals("Grafo inicial debería tener 0 aristas", 0, grafo.getNumberEdges());
        
        grafo.addEdge("A", "B", 1.0);
        grafo.addEdge("B", "C", 1.0);
        
        assertEquals("Debería tener 2 aristas", 2, grafo.getNumberEdges());
    }

    /**
     * Prueba que addEdge lance excepción cuando se intenta añadir una arista con vértice inexistente.
     */
    @Test(expected = GraphException.class)
    public void testAddEdge_conVerticeInexistente() throws GraphException {
        grafo.addEdge("A", "X", 1.0); // X no existe
    }

    /**
     * Prueba el estado inicial de un grafo vacío.
     */
    @Test
    public void testGrafoVacio() {
        MatrixDiGraph<String> grafoVacio = new MatrixDiGraph<>(5);
        assertTrue("El grafo debería estar vacío", grafoVacio.empty());
        assertEquals("Grafo vacío debería tener 0 aristas", 0, grafoVacio.getNumberEdges());
    }

    /**
     * Prueba el método toString para verificar que contiene información relevante del grafo.
     * 
     * @throws GraphException si ocurre un error al añadir aristas
     */
    @Test
    public void testToString() throws GraphException {
        grafo.addEdge("A", "B", 1.0);
        String resultado = grafo.toString();
        
        assertTrue("Debería contener los vértices", resultado.contains("A") && resultado.contains("B"));
        assertTrue("Debería mostrar el peso de la arista", resultado.contains("1.0"));
    }
}