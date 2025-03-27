package implementaciones;

import excepciones.GraphException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase ListNoDiGraph
 * 
 * @author Manuel Domitsu Kono
 */
public class ListNoDiGraphTest {
    
    private ListNoDiGraph<String> grafo;
    
    /**
     * Configuración inicial para las pruebas
     */
    @Before
    public void setUp() {
        grafo = new ListNoDiGraph<>();
    }

    /**
     * Prueba para agregar una arista con peso entre dos vértices existentes
     * @throws GraphException si ocurre un error al agregar la arista
     */
    @Test
    public void testAddEdgeConPeso() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addEdge("A", "B", 5.0);
        assertTrue(grafo.hasEdge("A", "B"));
        assertTrue(grafo.hasEdge("B", "A")); // Grafo no dirigido
    }

    /**
     * Prueba para agregar una arista sin peso entre dos vértices existentes
     * @throws GraphException si ocurre un error al agregar la arista
     */
    @Test
    public void testAddEdgeSinPeso() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addEdge("A", "B");
        assertTrue(grafo.hasEdge("A", "B"));
        assertEquals(0.0, grafo.getEdgeWeight("A", "B"), 0.001);
    }

    /**
     * Prueba para verificar la existencia de una arista
     * @throws GraphException si los vértices no existen
     */
    @Test
    public void testHasEdge() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addEdge("A", "B", 3.0);
        assertTrue(grafo.hasEdge("A", "B"));
        assertTrue(grafo.hasEdge("B", "A")); // Bidireccional
    }

    /**
     * Prueba para obtener el peso de una arista existente
     * @throws GraphException si los vértices o la arista no existen
     */
    @Test
    public void testGetEdgeWeight() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addEdge("A", "B", 4.5);
        assertEquals(4.5, grafo.getEdgeWeight("A", "B"), 0.001);
        assertEquals(4.5, grafo.getEdgeWeight("B", "A"), 0.001); // Mismo peso en ambas direcciones
    }

    /**
     * Prueba para eliminar una arista existente
     * @throws GraphException si los vértices no existen o la arista no existe
     */
    @Test
    public void testRemoveEdge() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addEdge("A", "B", 2.0);
        grafo.removeEdge("A", "B");
        assertFalse(grafo.hasEdge("A", "B"));
        assertFalse(grafo.hasEdge("B", "A")); // Debe eliminarse en ambas direcciones
    }

    /**
     * Prueba para eliminar una arista no existente (debe lanzar excepción)
     * @throws GraphException se espera que lance esta excepción
     */
    @Test(expected = GraphException.class)
    public void testRemoveEdgeNoExistente() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.removeEdge("A", "B");
    }

    /**
     * Prueba para establecer el peso de una arista existente
     * @throws GraphException si los vértices o la arista no existen
     */
    @Test
    public void testSetEdgeWeight() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addEdge("A", "B", 1.0);
        grafo.setEdgeWeight("A", "B", 3.0);
        assertEquals(3.0, grafo.getEdgeWeight("A", "B"), 0.001);
        assertEquals(3.0, grafo.getEdgeWeight("B", "A"), 0.001); // Debe actualizarse en ambas direcciones
    }

    /**
     * Prueba para contar el número de aristas en un grafo vacío
     */
    @Test
    public void testGetNumberEdgesGrafoVacio() {
        assertEquals(0, grafo.getNumberEdges());
    }

    /**
     * Prueba para contar el número de aristas en un grafo con conexiones
     * @throws GraphException si ocurre un error al agregar aristas
     */
    @Test
    public void testGetNumberEdges() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addVertex("C");
        grafo.addEdge("A", "B", 1.0);
        grafo.addEdge("B", "C", 2.0);
        assertEquals(2, grafo.getNumberEdges()); // A-B y B-C (no dirigido cuenta como 1 por conexión)
    }

    /**
     * Prueba para agregar arista con vértice no existente (debe lanzar excepción)
     * @throws GraphException se espera que lance esta excepción
     */
    @Test(expected = GraphException.class)
    public void testAddEdgeVerticeNoExistente() throws Exception {
        grafo.addVertex("A");
        grafo.addEdge("A", "B", 1.0);
    }

    /**
     * Prueba para obtener peso de arista no existente (debe lanzar excepción)
     * @throws GraphException se espera que lance esta excepción
     */
    @Test(expected = GraphException.class)
    public void testGetEdgeWeightNoExistente() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.getEdgeWeight("A", "B");
    }
}