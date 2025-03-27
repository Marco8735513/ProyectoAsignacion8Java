package implementaciones;

import excepciones.GraphException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Esta clase representa un vértice de un grafo sobre una lista de adyacencias
 *
 * @param <T> Tipo de la etiqueta de un vertice del grafo
 *
 * @author mdomitsu
 */
public class ListVertex<T> extends Vertex<T> {

    private final LinkedList<Edge<T>> aristas;

    /**
     * Esta clase anidada representa una arista saliente de este vertice
     *
     * @param <T> Tipo de la etiqueta de un vertice destino de este arista
     */
    protected class Edge<T> {

        private final ListVertex<T> verticeDest;
        private double peso;

        /**
         * Construye una arista saliente de este vertice a partir del vertice
         * destino y un peso
         *
         * @param verticeDest Vertice destino
         * @param peso Peso de la arista
         */
        protected Edge(ListVertex verticeDest, double peso) {
            this.verticeDest = verticeDest;
            this.peso = peso;
        }

        /**
         * Obtiene el vertice destino de esta arista
         *
         *
         * @return El vertice destino de esta arista
         */
        protected ListVertex getVerticeDest() {
            return verticeDest;
        }

        /**
         * Establece el peso de esta arista
         *
         * @param peso Peso de la arista
         */
        protected void setPeso(double peso) {
            this.peso = peso;
        }

        /**
         * Obtiene el peso de esta arista
         *
         * @return El peso de esta arista
         */
        protected double getPeso() {
            return peso;
        }
    }

    /**
     * Esta clase anidada implementa un iterador a los vertices destino de las
     * aristas salientes de este vertice
     */
    private class NeighborIterator implements
            Iterator<ListVertex<T>> {

        private final Iterator<Edge<T>> iteradorAristas;

        private NeighborIterator() {
            iteradorAristas = aristas.listIterator(0);
        }

        @Override
        public boolean hasNext() {
            return iteradorAristas.hasNext();
        }

        @Override
        public ListVertex<T> next() {
            ListVertex<T> vecinoSiguiente = null;
            if (iteradorAristas.hasNext()) {
                Edge<T> aristaVecinoSiguiente
                        = iteradorAristas.next();
                vecinoSiguiente
                        = aristaVecinoSiguiente.getVerticeDest();
            } else {
                throw new NoSuchElementException();
            }
            return vecinoSiguiente;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Esta clase anidada implementa un iterador a los vertices destino de las
     * aristas salientes de este vertice
     */
    private class WeightIterator implements Iterator<Double> {

        private final Iterator<Edge<T>> iteradorAristas;

        private WeightIterator() {
            iteradorAristas = aristas.listIterator(0);
        }

        @Override
        public boolean hasNext() {
            return iteradorAristas.hasNext();
        }

        @Override
        public Double next() {
            Double pesoSiguiente = null;
            if (iteradorAristas.hasNext()) {
                Edge<T> aristaVecinoSiguiente
                        = iteradorAristas.next();
                pesoSiguiente = aristaVecinoSiguiente.getPeso();
            } else {
                throw new NoSuchElementException();
            }
            return pesoSiguiente;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Constructor de un vertice. Establece el valor de su etiqueta
     *
     * @param etiqueta Etiqueta del vertice
     */
    public ListVertex(T etiqueta) {
        super(etiqueta);
        aristas = new LinkedList<>();
    }

    /**
     * Agrega una arista de este vertice a un vertice dado y con el peso dado
     *
     * @param verticeDest Vertice destino de la arista
     * @param peso Peso de la arista
     * @throws GraphException Si el vertice destino es el mismo que el vertice
     * destino o ya hay una arista entre los vertices
     */
    public void connect(ListVertex<T> verticeDest, double peso)
            throws GraphException {
        if (this.equals(verticeDest)) {
            throw new GraphException("El vertice origen es el mismo que el vertice destino");
        }
        if (hasEdge(verticeDest)) {
            throw new GraphException("Ya hay una arista entre el vertice origen y el vertice destino 00");
        }
aristas.add(new Edge(verticeDest, peso));
    }

    /**
     * Agrega una arista de este vertice a un vertice dado
     *
     * @param verticeDest Vertice destino de la arista
     * @throws GraphException Si el vertice destino es el mismo que el vertice
     * destino o ya hay una arista entre los vertices
     */
    public void connect(ListVertex<T> verticeDest)
            throws GraphException {
        connect(verticeDest, 0.0);
    }

    /**
     * Elimina una arista de este vertice al vertice dado
     *
     * @param verticeDest Vertice destino de la arista
     * @throws GraphException Si no hay una arista entre los vertices
     */
    public void unconnect(ListVertex<T> verticeDest)
            throws GraphException {
        if (!hasEdge(verticeDest)) {
            throw new GraphException("No hay una arista entre el vertice origen y el vertice destino");
        }
        
for (int i = 0; i < aristas.size(); i++) {
            if (verticeDest.equals(aristas.get(i).verticeDest)) {
                aristas.remove(i);
            }
        }
    }

    /**
     * Determina si hay una arista entre este vertice y un vertice dado
     *
     * @param verticeDest Vertice destino de la arista
     * @return true si hay una arista entre este vertice y un vertice dado false
     * en caso contrario
     */
    public boolean hasEdge(ListVertex<T> verticeDest) {
        for (Edge<T> arista : aristas) {
            if (arista.getVerticeDest().equals(verticeDest)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Regresa la arista entre este vertice y un vertice dado
     *
     * @param verticeDest Vertice destino de la arista
     * @return La arista ntre este vertice y un vertice dado si existe, null en
     * caso contrario
     */
    public Edge<T> getEdge(ListVertex<T> verticeDest) {
        Edge<T> arista;
        for (int i = 0; i < aristas.size(); i++) {
            arista = aristas.get(i);
            if (verticeDest.equals(arista.verticeDest)) {
                return arista;
            }
        }
        return null;
    }

    /**
     * Obtiene el numero de aristas salientes de este vertice
     *
     * @return El numero de aristas salientes de este vertice
     */
    public int getNumberEdges() {
        return aristas.size();
    }

    /**
     * Obtiene un iterador a los vertices vecinos a este vertice
     *
     * @return El iterador a los vertices vecinos a este vertice
     */
    public Iterator<ListVertex<T>> getNeighborIterator() {
        return new NeighborIterator();
    }

    /**
     * Obtiene un iterador a los pesos de los vertices vecinos a este vertice
     *
     * @return El iterador a los pesos de los vertices vecinos a este vertice
     */
    public Iterator<Double> getWeightIterator() {
        return new WeightIterator();
    }

    /**
     * Determina si este vertice tiene al menos un vertice vecino
     *
     * @return true si este vertice tiene al menos un vertice vecino, false en
     * caso contrario
     */
    public boolean hasNeighbor() {
        return !aristas.isEmpty();
    }

    /**
     * Obtiene uno de los vertices vecinos no visitados de este vertice si
     * existe
     *
     * @return Uno de los vertices vecinos no visitados de este vertice si
     * existe, null en caso contrario
     */
    public ListVertex<T> getUnvisitedNeighbor() {
        Iterator<ListVertex<T>> vecinos = getNeighborIterator();
        while (vecinos.hasNext()) {
            ListVertex<T> vecinoSiguiente = vecinos.next();
            if (!vecinoSiguiente.isVisitado()) {
                return vecinoSiguiente;
            }
        }
        return null;
    }
}
