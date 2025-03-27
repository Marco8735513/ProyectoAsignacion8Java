package implementaciones;

import excepciones.GraphException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * ListDiGraph.java
 *
 * Esta clase implementa un grafo dirigido sobre una lista de adyacencias
 *
 * @param <T> Tipo de la etiqueta de un vertice del grafo
 *
 * @author mdomitsu
 */
public class ListDiGraph<T> extends ListGraph<T> {

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
        return verticeX.hasEdge(verticeY);
    }

    /**
     * Obtiene el peso de la arista entre los vertices verticeX y verticeY
     *
     * @param etqX Etiqueta del vertice origen
     * @param etqY Etiqueta del vertice destino
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
// Regresa el peso de la arista
        return verticeX.getEdge(verticeY).getPeso();
    }

    /**
     * Elimina la arista dirigida entre dos vértices especificados en el grafo.
     * Este método solo afecta la arista desde el vértice etqX hacia el vértice
     * etqY. Para grafos no dirigidos, utilice la implementación correspondiente
     * en ListNoDiGraph.
     *
     * @param etqX etiqueta del vértice origen (de donde sale la arista)
     * @param etqY etiqueta del vértice destino (hacia donde apunta la arista)
     * @throws GraphException si alguno de los vértices no existe o si la arista
     * especificada no existe
     *
     *
     */
   
    @Override
public void removeEdge(T etqX, T etqY) throws GraphException {
    // 1. Verificar que los vértices existen
    ListVertex<T> verticeX = getVertex(etqX);
    ListVertex<T> verticeY = getVertex(etqY);
    
    if (verticeX == null || verticeY == null) {
        throw new GraphException("Vértice origen o destino no existe");
    }

    // 2. Buscar y eliminar la arista
    boolean aristaEncontrada = false;
    Iterator<ListVertex<T>> vecinosIter = verticeX.getNeighborIterator();
    
    while (vecinosIter.hasNext()) {
        if (vecinosIter.next().equals(verticeY)) {
            vecinosIter.remove();  // Esto requiere que NeighborIterator.remove() esté implementado
            aristaEncontrada = true;
            break;
        }
    }

    // 3. Si no se encontró, lanzar excepción
    if (!aristaEncontrada) {
        throw new GraphException("Arista " + etqX + " -> " + etqY + " no existe");
    }
}
    
    
    

    /**
     * Establece un nuevo peso para una arista dirigida entre dos vértices
     * especificados.
     *
     * @param etqX etiqueta del vértice origen de la arista
     * @param etqY etiqueta del vértice destino de la arista
     * @param peso nuevo valor del peso que se asignará a la arista
     * @throws GraphException en los siguientes casos:
     *
     */
    @Override
    public void setEdgeWeight(T etqX, T etqY, double peso) throws GraphException {
        // Verifica si los vértices existen
        ListVertex<T> verticeX = getVertex(etqX);
        ListVertex<T> verticeY = getVertex(etqY);
        if (verticeX == null || verticeY == null) {
            throw new GraphException("Vértice origen o destino no existe");
        }

        // Itera sobre los vecinos y pesos de verticeX para actualizar el peso
        Iterator<ListVertex<T>> iterVecinos = verticeX.getNeighborIterator();
        Iterator<Double> iterPesos = verticeX.getWeightIterator();
        boolean aristaEncontrada = false;

        while (iterVecinos.hasNext()) {
            ListVertex<T> vecino = iterVecinos.next();
            if (vecino.equals(verticeY)) {
                iterPesos.remove();          // Elimina el peso antiguo
                verticeX.connect(verticeY, peso); // Vuelve a agregar con el nuevo peso
                aristaEncontrada = true;
                break;
            }
            iterPesos.next(); // Avanza el iterador de pesos si no es el vértice buscado
        }

        if (!aristaEncontrada) {
            throw new GraphException("Arista " + etqX + " -> " + etqY + " no existe");
        }
    }

    /**
     * Calcula y devuelve el número total de aristas dirigidas en el grafo. Este
     * método recorre todos los vértices del grafo y cuenta cada una de sus
     * aristas salientes para obtener el total.
     *
     * @return Entero que representa el número total de aristas dirigidas en el
     * grafo. Retorna 0 si el grafo está vacío o no contiene aristas.
     *
     */
    @Override
    public int getNumberEdges() {
        int totalAristas = 0;
        // Recorre todos los vértices y cuenta sus aristas salientes
        for (ListVertex<T> vertice : vertices) {
            Iterator<ListVertex<T>> iterVecinos = vertice.getNeighborIterator();
            while (iterVecinos.hasNext()) {
                iterVecinos.next();
                totalAristas++;
            }
        }
        return totalAristas;
    }


}
