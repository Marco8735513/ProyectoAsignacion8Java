package implementaciones;

import excepciones.GraphException;
import implementaciones.ListVertex.Edge;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * ListNoDiGraph,java
 *
 * Esta clase implementa un grafo No dirigido sobre una lista de adyacencias
 *
 * @param <T> Tipo de la etiqueta de un vertice del grafo
 *
 * @author Manuel Domitsu Kono
 */
public class ListNoDiGraph<T> extends ListGraph<T> {

    /**
     * Agrega una arista entre los vertices verticeX y verticeY si no existe.
     *
     * @param etqX Etiqueta del vertice origen
     * @param etqY Etiqueta del vertice destino
     * @param peso Peso de la arista entre los vertices verticeX y verticeY
     * @throws GraphException Si los vertices no existen o si la arista ya
     * existe
     */
    @Override
    public void addEdge(T etqX, T etqY, double peso)
            throws GraphException {
// Verifica si el verticeX existe
        ListVertex<T> verticeX = getVertex(etqX);
        if (verticeX == null) {
            throw new GraphException("Vertice " + etqX
                    + " no existe");
        }
// Verifica si el verticeY existe
        ListVertex<T> verticeY = getVertex(etqY);
        if (verticeY == null) {
            throw new GraphException("Vertice " + etqY
                    + " no existe");
        }
// Agrega la arista a la lista de aristas del vertice origen
        verticeX.connect(verticeY, peso);
        verticeY.connect(verticeX, peso);
    }

    /**
     * Agrega una arista sin peso entre los vertices verticeX y verticeY si no
     * existe.
     *
     * @param etqX Etiqueta del vertice origen
     * @param etqY Etiqueta del vertice destino
     * @throws GraphException Si los vertices no existen o si la arista ya
     * existe
     */
    @Override
    public void addEdge(T etqX, T etqY)
            throws GraphException {
        addEdge(etqX, etqY, 0.0);
    }

    /**
     * Determina si hay una arista entre los vertices verticeX y verticeY.
     *
     * @param etqX Etiqueta del vertice a probar si esta conectado con verticeY
     * @param etqY Etiqueta del vertice a probar si esta conectado con verticeX
     * @return true si hay una arista entre los vertices verticeX y verticeY,
     * false en caso contrario
     * @throws GraphException Si los vertices no existen
     */
    @Override
    public boolean hasEdge(T etqX, T etqY)
            throws GraphException {
// Verifica si el verticeX existe
        ListVertex<T> verticeX = getVertex(etqX);
        if (verticeX == null) {
            throw new GraphException("Vertice " + etqX
                    + " no existe");
        }
// Verifica si el verticeY existe
        ListVertex<T> verticeY = getVertex(etqY);
        if (verticeY == null) {
            throw new GraphException("Vertice " + etqY
                    + " no existe");
        }
// Determina si hay una arista
        return verticeX.hasEdge(verticeY)
                && verticeY.hasEdge(verticeX);
    }

    /**
     * Obtiene el peso de la arista entre los vertices verticeX y verticeY
     *
     * @param etqX Etiqueta del vertice origen* @param etqY Etiqueta del vertice
     * destino
     * @return El peso de la arista entre los vertices verticeX y verticeY si
     * existe, null en caso contrario
     * @throws GraphException Si los vertices o la arista no existen
     */
    @Override
    public double getEdgeWeight(T etqX, T etqY)
            throws GraphException {
// Verifica si el verticeX existe
        ListVertex<T> verticeX = getVertex(etqX);
        if (verticeX == null) {
            throw new GraphException("Vertice " + etqX
                    + " no existe");
        }
// Verifica si el verticeY existe
        ListVertex<T> verticeY = getVertex(etqY);
        if (verticeY == null) {
            throw new GraphException("Vertice " + etqY
                    + " no existe");
        }
// Determina si hay una arista
        if (!verticeX.hasEdge(verticeY)) {
            throw new GraphException("Arista " + etqX + " - "
                    + etqY + " no existe");
        }
        if (!verticeY.hasEdge(verticeX)) {
            throw new GraphException("Arista " + etqY + " - "
                    + etqX + " no existe");
        }
// Regresa el peso de la arista
        return verticeX.getEdge(verticeY).getPeso();
    }

    /**
     * Elimina una arista no dirigida entre dos vértices especificados. En un
     * grafo no dirigido, esto implica eliminar ambas direcciones de la arista.
     *
     * @param etqX Etiqueta del primer vértice
     * @param etqY Etiqueta del segundo vértice
     * @throws GraphException si alguno de los vértices no existe o si la arista
     * no existe
     */
    @Override
    public void removeEdge(T etqX, T etqY) throws GraphException {
        // Obtener los vértices correspondientes
        ListVertex<T> verticeX = getVertex(etqX);
        ListVertex<T> verticeY = getVertex(etqY);

        // Verificar existencia de vértices
        if (verticeX == null || verticeY == null) {
            throw new GraphException("Uno o ambos vértices no existen");
        }

        // Verificar existencia de la arista en al menos una dirección
        if (!verticeX.hasEdge(verticeY) && !verticeY.hasEdge(verticeX)) {
            throw new GraphException("La arista " + etqX + "-" + etqY + " no existe");
        }

        // Eliminar en ambas direcciones (grafo no dirigido)
        try {
            verticeX.unconnect(verticeY);
            verticeY.unconnect(verticeX);
        } catch (GraphException e) {
            // Esto no debería ocurrir porque ya verificamos que existe
            throw new GraphException("Error al eliminar arista: " + e.getMessage());
        }
    }

    /**
     * Establece un nuevo peso para una arista no dirigida entre dos vértices.
     * En un grafo no dirigido, el peso debe ser el mismo en ambas direcciones.
     *
     * @param etqX Etiqueta del primer vértice
     * @param etqY Etiqueta del segundo vértice
     * @param peso Nuevo peso para la arista
     * @throws GraphException si alguno de los vértices no existe o si la arista
     * no existe
     */
    @Override
    public void setEdgeWeight(T etqX, T etqY, double peso) throws GraphException {
        ListVertex<T> verticeX = getVertex(etqX);
        ListVertex<T> verticeY = getVertex(etqY);

        if (verticeX == null || verticeY == null) {
            throw new GraphException("Vértices no existen");
        }

        // Alternativa usando getEdge() y setPeso()
        ListVertex.Edge<T> aristaXY = verticeX.getEdge(verticeY);
        ListVertex.Edge<T> aristaYX = verticeY.getEdge(verticeX);

        if (aristaXY == null || aristaYX == null) {
            throw new GraphException("Arista no existe");
        }

        aristaXY.setPeso(peso);
        aristaYX.setPeso(peso);
    }

    /**
     * Obtiene el número total de aristas únicas en el grafo no dirigido. En un
     * grafo no dirigido, cada conexión entre vértices se cuenta una sola vez
     * (aunque internamente se almacene en ambas direcciones).
     *
     * @return Número total de aristas únicas en el grafo
     */
    @Override
    public int getNumberEdges() {
        int totalAristas = 0;

        // Contamos todas las aristas de todos los vértices
        for (ListVertex<T> vertice : vertices) {
            totalAristas += vertice.getNumberEdges();
        }

        // Dividimos entre 2 porque en grafo no dirigido cada arista 
        // está almacenada en ambos vértices (duplicada)
        return totalAristas / 2;
    }

    

}
