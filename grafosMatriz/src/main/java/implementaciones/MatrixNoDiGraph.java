package implementaciones;

import excepciones.GraphException;
import java.util.LinkedList;

/**
 * MatrixNoDiGraph.java
 *
 * Esta clase implementa un grafo no dirigido sobre una matriz de adyacencias
 *
 * @param <T> Tipo de la etiqueta de un vertice del grafo
 *
 * @author mdomitsu
 */
public class MatrixNoDiGraph<T> extends MatrixGraph<T> {

    /**
     * Constructor de la clase
     *
     * @param maxVertices Numero maximo de vertices en el grafo
     */
    public MatrixNoDiGraph(int maxVertices) {
        super(maxVertices);
    }

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
        int indicex = indexOf(etqX);
        if (indicex == -1) {
            throw new GraphException("Vertice " + etqX
                    + " no existe");
        }
// Verifica si el verticeY existe
        int indicey = indexOf(etqY);
        if (indicey == -1) {
            throw new GraphException("Vertice " + etqY
                    + " no existe");
        }
// Verifica si la arista existe
        if (adyacencias[indicex][indicey]
                != Double.POSITIVE_INFINITY) {
            throw new GraphException("Arista " + etqX + " - "
                    + etqY + " ya existe");
        }
        if (adyacencias[indicey][indicex]
                != Double.POSITIVE_INFINITY) {
            throw new GraphException("Arista " + etqY + " - "
                    + etqX + " ya existe");
        }
        adyacencias[indicex][indicey] = peso;
        adyacencias[indicey][indicex] = peso;
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
    @
            Override
    public void addEdge(T etqX, T etqY) {
        addEdge(etqX, etqY, 0);
    }

    /**
     * Determina si hay una arista entre los vertices verticeX y verticeY.
     *
     * @param etqX Etiqueta del vertice a probar si esta conectado con el
     * verticeY
     * @param etqY Etiqueta del vertice a probar si esta conectado con el
     * verticeX
     * @return true si hay una arista entre los vertices verticeX y verticeY,
     * false en caso contrario
     * @throws GraphException Si los vertices no existen
     */
    @Override
    public boolean hasEdge(T etqX, T etqY)
            throws GraphException {
// Verifica si el verticeX existe
        int indicex = indexOf(etqX);
        if (indicex == -1) {
            throw new GraphException("Vertice " + etqX
                    + " no existe");
        }
// Verifica si el verticeY existe
        int indicey = indexOf(etqY);
        if (indicey == -1) {
            throw new GraphException("Vertice " + etqY
                    + " no existe");
        }
        return (adyacencias[indicex][indicey]
                != Double.POSITIVE_INFINITY)
                && (adyacencias[indicey][indicex]
                != Double.POSITIVE_INFINITY)
                && adyacencias[indicex][indicey]
                == adyacencias[indicey][indicex];
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
        int indicex = indexOf(etqX);
        if (indicex == -1) {
            throw new GraphException("Vertice " + etqX
                    + " no existe");

        }
// Verifica si el verticeY existe
        int indicey = indexOf(etqY);
        if (indicey == -1) {
            throw new GraphException("Vertice " + etqY
                    + " no existe");
        }
// Verifica si la arista existe
// Verifica si la arista existe
        if (adyacencias[indicex][indicey]
                == Double.POSITIVE_INFINITY) {
            throw new GraphException("Arista " + etqX + " - "
                    + etqY + " no existe");
        }
        if (adyacencias[indicey][indicex]
                == Double.POSITIVE_INFINITY) {
            throw new GraphException("Arista " + etqY + " - "
                    + etqX + " no existe");
        }
        return adyacencias[indicex][indicey];
    }

    @Override
public void removeEdge(T etqX, T etqY) throws GraphException {
    // Verifica existencia de vértices
    int indiceX = indexOf(etqX);
    if (indiceX == -1) throw new GraphException("Vértice " + etqX + " no existe");
    
    int indiceY = indexOf(etqY);
    if (indiceY == -1) throw new GraphException("Vértice " + etqY + " no existe");
    
    // Verifica existencia de arista (en ambas direcciones)
    if (adyacencias[indiceX][indiceY] == Double.POSITIVE_INFINITY || 
        adyacencias[indiceY][indiceX] == Double.POSITIVE_INFINITY) {
        throw new GraphException("Arista " + etqX + " - " + etqY + " no existe");
    }
    
    // Elimina la arista en ambas direcciones
    adyacencias[indiceX][indiceY] = Double.POSITIVE_INFINITY;
    adyacencias[indiceY][indiceX] = Double.POSITIVE_INFINITY;
}
  
@Override
public void setEdgeWeight(T etqX, T etqY, double peso) throws GraphException {
    // Verifica existencia de vértices
    int indiceX = indexOf(etqX);
    if (indiceX == -1) throw new GraphException("Vértice " + etqX + " no existe");
    
    int indiceY = indexOf(etqY);
    if (indiceY == -1) throw new GraphException("Vértice " + etqY + " no existe");
    
    // Verifica existencia de arista
    if (adyacencias[indiceX][indiceY] == Double.POSITIVE_INFINITY || 
        adyacencias[indiceY][indiceX] == Double.POSITIVE_INFINITY) {
        throw new GraphException("Arista " + etqX + " - " + etqY + " no existe");
    }
    
    // Establece el nuevo peso en ambas direcciones
    adyacencias[indiceX][indiceY] = peso;
    adyacencias[indiceY][indiceX] = peso;
}

@Override
public int getNumberEdges() {
    int count = 0;
    for (int i = 0; i < nVertices; i++) {
        for (int j = i; j < nVertices; j++) { // j = i para evitar contar duplicados
            if (adyacencias[i][j] != Double.POSITIVE_INFINITY) {
                count++;
            }
        }
    }
    return count;
}


}
