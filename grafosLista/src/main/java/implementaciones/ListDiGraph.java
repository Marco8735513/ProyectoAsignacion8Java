package implementaciones;

import excepciones.GraphException;
import java.util.LinkedList;

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

    @Override
    public void removeVertex(T etqVertice) throws GraphException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LinkedList<T> getVertices() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeEdge(T etqVerticeX, T etqVerticeY) throws GraphException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setEdgeWeight(T etqVerticeX, T etqVerticeY, double peso) throws GraphException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getNumberEdges() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
