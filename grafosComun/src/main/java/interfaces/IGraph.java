package interfaces;

import excepciones.GraphException;
import java.util.LinkedList;

/**
 * IGraph.java * Esta interfaz declara los metodos que deben implementar una
 * clase que represente un grafo
 *
 * @param <T> Tipo de la etiqueta de un vertice del grafo
 *
 * @author Manuel Domitsu Kono
 */
public interface IGraph<T> {

    /**
     * Agrega un vertice al grafo, si no existe
     *
     * @param etqVertice Etiqueta del vertice a agregar al grafo
     * @throws GraphException Si no hay espacio para un nuevo vertice o el
     * vertice ya existe
     */
    public void addVertex(T etqVertice) throws GraphException;

    /**
     * Elimina un vertice del grafo, si existe
     *
     * @param etqVertice Etiqueta del vertice a eliminar
     * @throws GraphException Si el vertice a eliminar no existe
     */
    public void removeVertex(T etqVertice) throws GraphException;

    /**
     * Determina si el vertice existe en el grafo
     *
     * @param etqVertice Etiqueta del vertice a buscar
     * @return true si el vertice existe en el grafo, false en caso contrario
     */
    public boolean hasVertex(T etqVertice);

    /**
     * Obtiene el numero de vertices del grafo
     *
     * @return El numero de vertices del grafo
     */
    public int getNumberVertices();

    /**
     * Obtiene la lista de vertices del grafo.
     *
     * @return La lista de vertices del grafo.
     */
    public LinkedList<T> getVertices();

    /**
     * Determina si el grafo está vacio
     *
     * @return true si el grafo esta vacio, false en caso contrario
     */
    public boolean empty();

    /**
     * Remueve todos los vertices y aristas del grafo
     */
    public void clear();

    /**
     * Agrega una arista entre los vertices verticeX y vertic eY si no existe.
     *
     * @param etqVerticeX Etiqueta del vertice origen
     * @param etqVerticeY Etiqueta del vertice destino
     * @param peso Peso de la arista entre los vertices verticeX y verticeY
     * @throws GraphException Si los vertices no existen o si la arista ya
     * existe
     */
    public void addEdge(T etqVerticeX, T etqVerticeY, double peso)
            throws GraphException;

    /**
     * Agrega una arista sin peso entre los vertices verticeX y verticeY si no
     * existe.
     *
     * @param etqVerticeX Etiqueta del vertice origen
     * @param etqVerticeY Etiqueta del vertice destino
     * @throws GraphException Si los vertices no existen o si la arista ya
     * existe
     */
    public void addEdge(T etqVerticeX, T etqVerticeY)
            throws GraphException;

    /**
     * Elimina una arista entre los vertices verticeX y verticeY.
     *
     * @param etqVerticeX Etiqueta del vertice origen
     * @param etqVerticeY Etiqueta del vertice destino
     * @throws GraphException Si los vertices o la arista no existen
     */
    public void removeEdge(T etqVerticeX, T etqVerticeY)
            throws GraphException;

    /**
     * Determina si hay una arista entre los vertices verticeX y verticeY.
     *
     * @param etqVerticeX Etiqueta del vertice a probar si esta conectado con
     * verticeY
     * @param etqVerticeY Etiqueta del vertice a probar si esta conectado con
     * verticeX
     * @return true si hay una arista entre los vertices verticeX y verticeY,
     * false en caso contrario
     * @throws GraphException Si los vertices no existen
     */
    public boolean hasEdge(T etqVerticeX, T etqVerticeY)
            throws GraphException;

    /**
     * Obtiene el peso de la arista entre los vertices verticeX y verticeY
     *
     * @param etqVerticeX Etiqueta del vertice origen
     * @param etqVerticeY Etiqueta del vertice destino
     * @return El peso de la arista entre los vertices verticeX y verticeY si
     * existe, null en caso contrario
     * @throws GraphException Si los vertices o la arista no existen
     */
    public double getEdgeWeight(T etqVerticeX, T etqVerticeY
    )
            throws GraphException;

    /**
     * Establece el peso de la arista entre los vertices verticeX y verticeY
     *
     * @param etqVerticeX Etiqueta del vertice origen
     * @param etqVerticeY Etiqueta del vertice destino
     * @param peso Peso de la arista entre los vertices verticeX y verticeY
     * @throws GraphException Si los vertices no existen
     */
    public void setEdgeWeight(T etqVerticeX, T etqVerticeY,
            double peso) throws GraphException;

    /**
     * Obtiene el numero de aristas del grafo
     *
     * @return El numero de aristas del grafo
     */
    public int getNumberEdges();
}
