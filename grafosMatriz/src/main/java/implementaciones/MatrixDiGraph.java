package implementaciones;

import excepciones.GraphException;
import java.util.LinkedList;

/**
 * MatrixDiGraph.java
 *
 * Esta clase implementa un grafo dirigido sobre una matriz de adyacencias
 *
 * @param <T> Tipo de la etiqueta de un vertice del grafo
 *
 * @author Manuel Domitsu Kono
 */
public class MatrixDiGraph<T> extends MatrixGraph<T> {

    /**
     * Constructor de la clase
     *
     * @param maxVertices Numero maximo de vertices en el grafo
     */
    public MatrixDiGraph(int maxVertices) {
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
// Agrega la arista
        adyacencias[indicex][indicey] = peso;
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
    public void addEdge(T etqX, T etqY) {
        addEdge(etqX, etqY, 0);
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
        return adyacencias[indicex][indicey]
                != Double.POSITIVE_INFINITY;
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
        if (adyacencias[indicex][indicey]
                == Double.POSITIVE_INFINITY) {
            throw new GraphException("Arista " + etqX + " - "
                    + etqY + " no existe");
        }
        return adyacencias[indicex][indicey];
    }

    //AQUI EMPIEAZA LA IMPLEMENTACION DE los metodos.
    
    /**
 *
 * @param etqX 
 * @param etqY 
 * @throws GraphException
 */
@Override
public void removeEdge(T etqX, T etqY) throws GraphException {
    // Verifica si el verticeX existe
    int indiceX = indexOf(etqX);
    if (indiceX == -1) {
        throw new GraphException("Vertice " + etqX + " no existe");
    }
    
    // Verifica si el verticeY existe
    int indiceY = indexOf(etqY);
    if (indiceY == -1) {
        throw new GraphException("Vertice " + etqY + " no existe");
    }
    
    // Verifica si la arista existe
    if (adyacencias[indiceX][indiceY] == Double.POSITIVE_INFINITY) {
        throw new GraphException("Arista " + etqX + " -> " + etqY + " no existe");
    }
    
    // Elimina la arista (establece infinito)
    adyacencias[indiceX][indiceY] = Double.POSITIVE_INFINITY;
}
    
    
    /**
 *
 * @param etqX 
 * @param etqY 
 * @param peso 
 * @throws GraphException
 */
@Override
public void setEdgeWeight(T etqX, T etqY, double peso) throws GraphException {
    // Verifica si el verticeX existe
    int indiceX = indexOf(etqX);
    if (indiceX == -1) {
        throw new GraphException("Vertice " + etqX + " no existe");
    }
    
    // Verifica si el verticeY existe
    int indiceY = indexOf(etqY);
    if (indiceY == -1) {
        throw new GraphException("Vertice " + etqY + " no existe");
    }
    
    // Verifica si la arista existe
    if (adyacencias[indiceX][indiceY] == Double.POSITIVE_INFINITY) {
        throw new GraphException("Arista " + etqX + " -> " + etqY + " no existe");
    }
    
    // Establece el nuevo peso
    adyacencias[indiceX][indiceY] = peso;
}
    

/**
 *
 * @return
 */
@Override
public int getNumberEdges() {
    int count = 0;
    
    // Recorre toda la matriz de adyacencia
    for (int i = 0; i < nVertices; i++) {
        for (int j = 0; j < nVertices; j++) {
            // Si hay una arista (no es infinito)
            if (adyacencias[i][j] != Double.POSITIVE_INFINITY) {
                count++;
            }
        }
    }
    
    return count;
}
    
   
}
