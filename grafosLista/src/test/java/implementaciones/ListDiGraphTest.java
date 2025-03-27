package implementaciones;

import excepciones.GraphException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList;

/**
 * Clase de pruebas unitarias para ListDiGraph que implementa un grafo dirigido.
 * 
 */
public class ListDiGraphTest {
    
    private ListDiGraph<String> grafo;
    
    /**
     * Configuración inicial antes de cada prueba.
     * Crea una nueva instancia de ListDiGraph antes de cada test.
     */
    @Before
    public void setUp() {
        grafo = new ListDiGraph<>();
    }

    // Pruebas para métodos implementados correctamente

    /**
     * Prueba que verifica la adición correcta de una arista con peso.
     * @throws GraphException si ocurre un error al añadir vértices o aristas
     */
    @Test
    public void testAddEdgeConPeso() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addEdge("A", "B", 5.0);
        assertTrue(grafo.hasEdge("A", "B"));
    }

    /**
     * Prueba que verifica la detección correcta de una arista existente.
     * @throws GraphException si ocurre un error al añadir vértices o aristas
     */
    @Test
    public void testHasEdge() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addEdge("A", "B", 3.0);
        assertTrue(grafo.hasEdge("A", "B"));
    }

    /**
     * Prueba que verifica la obtención correcta del peso de una arista.
     * @throws GraphException si ocurre un error al añadir vértices o aristas
     */
    @Test
    public void testGetEdgeWeight() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addEdge("A", "B", 4.5);
        assertEquals(4.5, grafo.getEdgeWeight("A", "B"), 0.001);
    }

    // Pruebas para métodos que lanzan GraphException

    /**
     * Prueba que verifica que se lanza excepción al intentar eliminar una arista inexistente.
     * @throws GraphException se espera que lance esta excepción
     */
    @Test(expected = GraphException.class)
    public void testRemoveEdge_aristaNoExistente() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.removeEdge("A", "B");
    }

    /**
     * Prueba que verifica que se lanza excepción al intentar establecer peso en arista inexistente.
     * @throws GraphException se espera que lance esta excepción
     */
    @Test(expected = GraphException.class)
    public void testSetEdgeWeight_aristaNoExistente() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.setEdgeWeight("A", "B", 2.0);
    }

    /**
     * Prueba que verifica que se lanza excepción al intentar eliminar un vértice inexistente.
     * @throws GraphException se espera que lance esta excepción
     */
    @Test(expected = GraphException.class)
    public void testRemoveVertex_verticeNoExistente() throws Exception {
        grafo.removeVertex("X");
    }

    // Pruebas para métodos implementados que no deberían lanzar excepciones

    /**
     * Prueba que verifica el correcto vaciado del grafo.
     */
    @Test
    public void testClear() {
        grafo.clear();
        assertTrue(grafo.empty());
    }

    /**
     * Prueba que verifica el conteo de aristas en un grafo vacío.
     */
    @Test
    public void testGetNumberEdges_grafoVacio() {
        assertEquals(0, grafo.getNumberEdges());
    }

    /**
     * Prueba que verifica la obtención de vértices en un grafo vacío.
     */
    @Test
    public void testGetVertices_grafoVacio() {
        assertTrue(grafo.getVertices().isEmpty());
    }

    /**
     * Prueba que verifica la eliminación correcta de una arista existente.
     * @throws GraphException si ocurre un error al añadir vértices o aristas
     */
    @Test
    public void testRemoveEdge_aristaExistente() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addEdge("A", "B", 2.0);
        grafo.removeEdge("A", "B");
        assertFalse(grafo.hasEdge("A", "B"));
    }
}