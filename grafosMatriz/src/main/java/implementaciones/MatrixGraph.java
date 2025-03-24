package implementaciones;

import excepciones.GraphException;
import interfaces.IGraph;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * MatrixGraph.java
 *
 * Esta clase abstracta implementa los metodos comunes a un grafo dirigido y un
 * grafo no dirigido sobre una matriz de adyacencias
 *
 * @param <T> Tipo del vertice del grafo
 *
 * @author Manuel Domitsu Kono
 */
public abstract class MatrixGraph<T> implements IGraph<T> {

    protected final LinkedList<Vertex<T>> vertices;
    protected int nVertices;
    protected final double adyacencias[][];
    protected final int maxVertices;

    /**
     * Constructor de la clase
     *
     * @param maxVertices Numero maximo de vertices en el grafo
     */
    public MatrixGraph(int maxVertices) {
        nVertices = 0;
        vertices = new LinkedList<>();
        this.maxVertices = maxVertices;
        adyacencias = new double[maxVertices][maxVertices];
// Un elemento con el valor de Double.POSITIVE_INFINITY se
// considera como que no existe una arista
        for (int i = 0; i < maxVertices; i++) {
            for (int j = 0; j < maxVertices; j++) {
                adyacencias[i][j] = Double.POSITIVE_INFINITY;
            }
        }
    }

    /**
     * Agrega un vertice al grafo, si no existe
     *
     * @param etiqueta Etiqueta del vertice a agregar al grafo
     * @throws GraphException Si no hay espacio para un nuevo vertice o el
     * vertice ya existe
     */
    @Override
    public void addVertex(T etiqueta) throws GraphException {
// Verifica si hay espacio en la matriz de adyacencias
// para un nuevo nodo
        if (nVertices >= maxVertices) {
            throw new GraphException("Grafo lleno");
        }
// Verifica que el vertice no este repetido
        if (hasVertex(etiqueta)) {
            throw new GraphException("Vertice repetido");
        }
// Agrega el vertice
        vertices.add(new Vertex(etiqueta));
        nVertices++;
    }

    /**
     * Determina si el vertice existe en el gra fo
     *
     * @param etiqueta Etiqueta del vertice a buscar
     * @return true si el vertice existe en el grafo, false en caso contrario
     */
    @Override
    public boolean hasVertex(T etiqueta) {
        int indice = indexOf(etiqueta);
        return indice >= 0;
    }

    /**
     * Obtiene la posicion del vertice en el diccionario de vertices
     *
     * @param etiqueta vertice a buscar
     * @return La posicion del vertice en el diccionario de vertices si existe,
     * -1 en caso contrario.
     */
    protected int indexOf(T etiqueta) {
        for (int i = 0; i < nVertices; i++) {
            if (etiqueta.equals(vertices.get(i).getEtiqueta())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Obtiene el numero de vertices del grafo
     *
     * @return El numero de vertices del grafo
     */
    @Override
    public int getNumberVertices() {
        return nVertices;
    }

    /**
     * Determina si el grafo está vacio
     *
     * @return true si el grafo esta vacio, false en caso contrario
     */
    @Override
    public boolean empty() {
        return nVertices == 0;
    }

    /**
     * Obtiene una cadena con una representacion del grafo
     *
     * @return Una cadena con una representacion del grafo
     */
    @Override
    public String toString() {
        String s = " ";
        for (int j = 0; j < nVertices; j++) {
            s += vertices.get(j).getEtiqueta();
            if (j < nVertices - 1) {
                s += " ";
            }
        }
        s += "\n";
        for (int i = 0; i < nVertices; i++) {
            s += vertices.get(i).getEtiqueta();
            s += " | ";
            for (int j = 0; j < nVertices; j++) {
                if (adyacencias[i][j] == Double.POSITIVE_INFINITY) {
                    s += "---";
                } else {
                    s += adyacencias[i][j];
                }
                if (j < nVertices - 1) {
                    s += ", ";
                }
            }
            s += " |\n";
        }
        return s;
    }

    /**
     * Regresa el vertice cuya etiqueta esta dada por el parametro
     *
     * @param etiqueta Etiqueta del vertice a obtener
     * @return El vertice si esta en la lista de vertices, null en caso
     * contrario
     */
    private Vertex<T> getVertex(T etiqueta) {
        Vertex<T> vertice;
        for (int i = 0; i < nVertices; i++) {
            vertice = vertices.get(i);
            if (etiqueta.equals(vertice.getEtiqueta())) {
                return vertice;
            }
        }
        return null;
    }

    /**
     * Establece los atributos de todos los vértices del grafo a los siguientes
     * valores: visited = false, predecessor = null, weight = 0.
     */
    private void resetVertices() {
        for (Vertex<T> vertice : vertices) {
            vertice.setVisitado(false);
            vertice.setPeso(0);
            vertice.setPredecesor(null);
        }
    }

    /**
     * Obtiene un iterador a los vertices vecinos de un vertice
     *
     * @param vertice Vertice del que se desea el iterador a sus vecinos
     * @return El iterador a los vertices vecinos a un vertice
     */
    private Iterator<Vertex<T>>
            getNeighborIterator(Vertex<T> vertice) {
        LinkedList<Vertex<T>> vecinos = new LinkedList<>();
        int indice = indexOf(vertice.getEtiqueta());
        for (int i = 0; i < nVertices; i++) {
            if (adyacencias[indice][i] != Double.POSITIVE_INFINITY) {
                vecinos.add(vertices.get(i));
            }
        }
        return vecinos.listIterator();
    }

    /**
     * Obtiene un iterador a los pesos de los vertices vecinos a un vertice
     *
     * @param vertice Vertice del que se desea el iterador a sus pesos
     * @return El iterador a los pesos de los vertices vecinos a un vertice
     */
    private Iterator<Double> getWeightIterator(Vertex<T> vertice) {
        LinkedList<Double> pesos = new LinkedList<>();
        int indice = indexOf(vertice.getEtiqueta());
        for (int i = 0; i < nVertices; i++) {
            if (adyacencias[indice][i] != Double.POSITIVE_INFINITY) {
                pesos.add(vertices.get(i).getPeso());
            }
        }
        return pesos.listIterator();
    }

    /**
     * Determina si un vertice tiene al menos un vertice vecino
     *
     * @param vertice Vertice del que se desea saber si tiene al menos un vecino
     * @return true si este vertice tiene al menos un vertice vecino. false en
     * caso contrario
     */
    private boolean hasNeighbor(Vertex<T> vertice) {
        int indice = indexOf(vertice.getEtiqueta());
        for (int i = 0; i < nVertices; i++) {
            if (adyacencias[indice][i] != Double.POSITIVE_INFINITY) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene uno de los vertices vecinos no visitados de un vertice si existe
     *
     * @param vertice Vertice del que se desea obtener uno de los vertices no
     * visitado
     * @return Uno de los vertices vecinos de no visiteds de este vertice si
     * existe, null en caso contrario
     */
    private Vertex<T> getUnvisitedNeighbor(Vertex<T> vertice) {
        int indice = indexOf(vertice.getEtiqueta());
        Vertex<T> vecino;
        for (int i = 0; i < nVertices; i++ ){

        
        
if (adyacencias[indice][i] != Double.POSITIVE_INFINITY) {
            vecino = vertices.get(i);
            if (!vecino.isVisitado()) 
                return vecino;
            }
        }
        return null;
    }}
