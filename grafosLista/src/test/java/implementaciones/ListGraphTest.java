package implementaciones;

import excepciones.GraphException;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de pruebas unitarias para la clase abstracta ListGraph.
 * 
 * 
 */
public class ListGraphTest {
    
    private ListGraph<String> grafo;
    
    /**
     * Implementación concreta de ListGraph para propósitos de prueba.
     * 
     * 
     * 
     * @param <T> Tipo de la etiqueta de los vértices
     */
    private static class ListGraphImpl<T> extends ListGraph<T> {

        @Override
        public void addEdge(T etqVerticeX, T etqVerticeY, double peso) throws GraphException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void addEdge(T etqVerticeX, T etqVerticeY) throws GraphException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void removeEdge(T etqVerticeX, T etqVerticeY) throws GraphException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean hasEdge(T etqVerticeX, T etqVerticeY) throws GraphException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public double getEdgeWeight(T etqVerticeX, T etqVerticeY) throws GraphException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void setEdgeWeight(T etqVerticeX, T etqVerticeY, double peso) throws GraphException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public int getNumberEdges() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
    /**
     * Configuración inicial para cada prueba.
     * 
     
     */
    @Before
    public void setUp() {
        grafo = new ListGraphImpl<>();
    }

    // Pruebas para addVertex(T etiqueta)
    
    /**
     * Prueba que añade un vértice con etiqueta válida al grafo.
     * 
     * @throws GraphException si ocurre un error al añadir el vértice
     */
    @Test
    public void testAddVertex_etiquetaValida() throws Exception {
        grafo.addVertex("A");
        assertTrue(grafo.hasVertex("A"));
        assertEquals(1, grafo.getNumberVertices());
    }

    /**
     * Prueba que verifica que no se pueden añadir vértices con etiquetas duplicadas.
     * 
     * @throws GraphException se espera que lance esta excepción
     */
    @Test(expected = GraphException.class)
    public void testAddVertex_etiquetaRepetida() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("A"); // Debe lanzar excepción
    }

    // Pruebas para hasVertex(T etiqueta)
    
    /**
     * Prueba que verifica la existencia de un vértice añadido previamente.
     */
    @Test
    public void testHasVertex_verticeExistente() {
        try {
            grafo.addVertex("A");
        } catch (GraphException e) {
            fail("No debería lanzar excepción");
        }
        assertTrue(grafo.hasVertex("A"));
    }

    /**
     * Prueba que verifica que un vértice no existente no es reconocido.
     */
    @Test
    public void testHasVertex_verticeNoExistente() {
        assertFalse(grafo.hasVertex("B"));
    }

    // Pruebas para getNumberVertices()
    
    /**
     * Prueba que verifica el conteo de vértices en un grafo vacío.
     */
    @Test
    public void testGetNumberVertices_grafoVacio() {
        assertEquals(0, grafo.getNumberVertices());
    }

    /**
     * Prueba que verifica el conteo correcto de vértices en un grafo no vacío.
     * 
     * @throws GraphException si ocurre un error al añadir vértices
     */
    @Test
    public void testGetNumberVertices_grafoConVertices() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        assertEquals(2, grafo.getNumberVertices());
    }

    // Pruebas para empty()
    
    /**
     * Prueba que verifica que un grafo recién creado está vacío.
     */
    @Test
    public void testEmpty_grafoVacio() {
        assertTrue(grafo.empty());
    }

    /**
     * Prueba que verifica que un grafo con vértices no está vacío.
     * 
     * @throws GraphException si ocurre un error al añadir el vértice
     */
    @Test
    public void testEmpty_grafoNoVacio() throws Exception {
        grafo.addVertex("A");
        assertFalse(grafo.empty());
    }

    // Pruebas para toString()
    
    /**
     * Prueba que verifica la representación en cadena de un grafo vacío.
     */
    @Test
    public void testToString_grafoVacio() {
        assertEquals("", grafo.toString());
    }

    /**
     * Prueba que verifica la representación en cadena de un grafo con vértices.
     * 
     * @throws GraphException si ocurre un error al añadir vértices
     */
    @Test
    public void testToString_grafoConVertices() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        String resultado = grafo.toString();
        assertTrue(resultado.contains("A: []"));
        assertTrue(resultado.contains("B: []"));
    }

    // Pruebas para indexOf(T etiqueta)
    
    /**
     * Prueba que verifica el índice de vértices existentes.
     * 
     * @throws GraphException si ocurre un error al añadir vértices
     */
    @Test
    public void testIndexOf_verticeExistente() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        assertTrue(grafo.indexOf("A") >= 0);
        assertTrue(grafo.indexOf("B") >= 0);
    }

    /**
     * Prueba que verifica que un vértice no existente retorna índice -1.
     */
    @Test
    public void testIndexOf_verticeNoExistente() {
        assertEquals(-1, grafo.indexOf("Z"));
    }

    // Pruebas para getVertex(T etiqueta)
    
    /**
     * Prueba que obtiene un vértice existente por su etiqueta.
     * 
     * @throws GraphException si ocurre un error al añadir el vértice
     */
    @Test
    public void testGetVertex_verticeExistente() throws Exception {
        grafo.addVertex("A");
        assertNotNull(grafo.getVertex("A"));
        assertEquals("A", grafo.getVertex("A").getEtiqueta());
    }

    /**
     * Prueba que verifica que al buscar un vértice no existente retorna null.
     */
    @Test
    public void testGetVertex_verticeNoExistente() {
        assertNull(grafo.getVertex("X"));
    }

    // Pruebas para resetVertices()
    
    /**
     * Prueba que verifica el reinicio de los estados de los vértices.
     * 
     * @throws GraphException si ocurre un error al añadir vértices
     */
    @Test
    public void testResetVertices() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        
        // Simular valores modificados
        grafo.getVertex("A").setVisitado(true);
        grafo.getVertex("A").setPeso(10);
        grafo.getVertex("A").setPredecesor(grafo.getVertex("B"));
        
        grafo.resetVertices();
        
        assertFalse(grafo.getVertex("A").isVisitado());
        assertEquals(0, grafo.getVertex("A").getPeso(), 0.001);
        assertNull(grafo.getVertex("A").getPredecesor());
    }

    // Pruebas para removeVertex(T etiqueta)
    
    /**
     * Prueba que elimina un vértice existente del grafo.
     * 
     * @throws GraphException si ocurre un error al añadir o eliminar vértices
     */
    @Test
    public void testRemoveVertex_verticeExistente() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.removeVertex("B");
        assertEquals(1, grafo.getNumberVertices());
        assertFalse(grafo.hasVertex("B"));
    }

    /**
     * Prueba que verifica que al intentar eliminar un vértice no existente se lanza una excepción.
     * 
     * @throws GraphException se espera que lance esta excepción
     */
    @Test(expected = GraphException.class)
    public void testRemoveVertex_verticeNoExistente() throws Exception {
        grafo.removeVertex("X");
    }

    // Pruebas para getVertices()
    
    /**
     * Prueba que verifica la lista de vértices de un grafo vacío.
     */
    @Test
    public void testGetVertices_grafoVacio() {
        assertTrue(grafo.getVertices().isEmpty());
    }

    /**
     * Prueba que verifica la lista de vértices de un grafo con elementos.
     * 
     * @throws GraphException si ocurre un error al añadir vértices
     */
    @Test
    public void testGetVertices_grafoConVertices() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        LinkedList<String> vertices = grafo.getVertices();
        assertEquals(2, vertices.size());
        assertTrue(vertices.contains("A"));
        assertTrue(vertices.contains("B"));
    }

    // Pruebas para clear()
    
    /**
     * Prueba que verifica la limpieza completa de un grafo con elementos.
     * 
     * @throws GraphException si ocurre un error al añadir vértices
     */
    @Test
    public void testClear_grafoConElementos() throws Exception {
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.clear();
        assertEquals(0, grafo.getNumberVertices());
        assertTrue(grafo.empty());
    }
}