package implementaciones;

import excepciones.GraphException;
import interfaces.IGraph;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ListGraph.java Esta clase abstracta implementa los metodos comunes a un grafo
 * dirigido y un grafo no dirigido sobre una matriz de adyacencias
 *
 * @param <T> Tipo del vertice del grafo
 *
 * @author mdomitsu
 */
public abstract class ListGraph<T> implements IGraph<T> {

    protected LinkedList<ListVertex<T>> vertices;
    protected int nVertices;

    /**
     * Constructor de la clase
     */
    public ListGraph() {
        nVertices = 0;
        vertices = new LinkedList<>();
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
// Verifica que el vertice no este repetido
        int indicex = indexOf(etiqueta);
        if (indicex >= 0) {
            throw new GraphException("Vertice repetido");
        }
// Agrega el vertice
        vertices.add(new ListVertex(etiqueta));
        nVertices++;
    }

    /**
     * Determina si el vertice existe en el grafo
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
        String s = "";
        for (int i = 0; i < nVertices; i++) {
            ListVertex<T> vertice = vertices.get(i);
            s += vertice.getEtiqueta() + ": [";
            Iterator<ListVertex<T>> iter
                    = vertice.getNeighborIterator();
            Iterator<Double> iterPeso = vertice.getWeightIterator();
            while (iter.hasNext()) {
                s += "(" + iter.next().getEtiqueta() + ", ";
                s += iterPeso.next() + ")";
                if (iter.hasNext()) {
                    s += ", ";
                }
            }
            s += "]\n";
        }
        return s;
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
     * Regresa el vertice cuya etiqueta esta dada por el parametro
     *
     * @param etiqueta Etiqueta del vertice a obtener
     * @return El vertice si esta en la lista de vertices, null en caso
     * contrario
     */
    protected ListVertex<T> getVertex(T etiqueta) {
        ListVertex<T> vertex;
        for (int i = 0; i < nVertices; i++) {
            vertex = vertices.get(i);
            if (etiqueta.equals(vertex.getEtiqueta())) {
                return vertex;
            }
        }
        return null;
    }

    /**
     * Establece los atributos de todos los vértices del grafo a los siguientes
     * valores: visited = false, predecessor = null, weight = 0.
     */
    protected void resetVertices() {
        for (ListVertex<T> vertice : vertices) {
            vertice.setVisitado(false);
            vertice.setPeso(0);
            vertice.setPredecesor(null);
        }
    }

    /**
     * Elimina un vértice del grafo junto con todas las aristas asociadas.
     * Primero elimina todas las aristas que apuntan al vértice desde otros
     * vértices, luego remueve el vértice de la lista principal de vértices.
     *
     * @param etiqueta La etiqueta del vértice a eliminar
     * @throws GraphException Si el vértice con la etiqueta especificada no
     * existe en el grafo
     *
     */
    @Override
    public void removeVertex(T etiqueta) throws GraphException {
        // Busca el vértice a eliminar
        ListVertex<T> verticeAEliminar = getVertex(etiqueta);
        if (verticeAEliminar == null) {
            throw new GraphException("El vértice '" + etiqueta + "' no existe");
        }

        // Elimina todas las aristas que apuntan al vértice (en otros vértices)
        for (ListVertex<T> vertice : vertices) {
            Iterator<ListVertex<T>> iterVecinos = vertice.getNeighborIterator();
            Iterator<Double> iterPesos = vertice.getWeightIterator();

            while (iterVecinos.hasNext()) {
                ListVertex<T> vecino = iterVecinos.next();
                iterPesos.next(); // Sincroniza con el iterador de pesos
                if (vecino.equals(verticeAEliminar)) {
                    iterVecinos.remove(); // Elimina la referencia al vértice
                    iterPesos.remove(); // Elimina el peso asociado
                    break; // Suponiendo grafo simple (una sola arista por par)
                }
            }
        }

        // Elimina el vértice de la lista principal
        vertices.remove(verticeAEliminar);
        nVertices--;
    }

    /**
     * Obtiene una lista con las etiquetas de todos los vértices presentes en el
     * grafo. La lista devuelta es una nueva instancia que contiene una copia de
     * las etiquetas, por lo que modificaciones a esta lista no afectarán la
     * estructura interna del grafo.
     *
     * @return Una nueva {@link LinkedList} que contiene las etiquetas de todos
     * los vértices del grafo en el orden en que fueron almacenados. La lista
     * estará vacía si el grafo no contiene vértices.
     *
     *
     */
    @Override
    public LinkedList<T> getVertices() {
        LinkedList<T> etiquetas = new LinkedList<>();
        for (ListVertex<T> vertice : vertices) {
            etiquetas.add(vertice.getEtiqueta());
        }
        return etiquetas;
    }

    

    /**
     * Elimina todos los vértices y aristas del grafo, dejándolo en un estado
     * vacío. Esta operación es irreversible y libera todos los recursos
     * asociados al grafo.
     */
    @Override
    public void clear() {
        vertices.clear();
        nVertices = 0;
    }

}
