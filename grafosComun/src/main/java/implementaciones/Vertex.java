package implementaciones;

import java.util.Objects;

/**
 * Vertex.java
 *
 * Esta clase representa un vértice de un grafo
 *
 * @param <T> Tipo de la etiqueta de un vertice del grafo
 *
 * @author Manuel Domitsu Kono
 */
public class Vertex<T> {

    protected final T etiqueta;
    protected boolean visitado;
    protected Vertex<T> predecesor;
    protected double peso;

    /**
     * Constructor de un vertice. Establece el valor de su etiqueta
     *
     * @param etiqueta Etiqueta del vertice
     */
    public Vertex(T etiqueta) {
        this.etiqueta = etiqueta;
        visitado = false;
        predecesor = null;
        peso = 0.0;
    }

    /**
     * Regresa la etiqueta de este vertice
     *
     ** @return La etiqueta de este vertice
     */
    public T getEtiqueta() {
        return etiqueta;
    }

    /**
     * Regresa el valor del atributo visitado
     *
     * @return true si el vertice ha sido visitado, false en caso contrario
     */
    public boolean isVisitado() {
        return visitado;
    }

    /**
     * Establece el valor del atributo visitado
     *
     * @param visitado Nuevo valor del atributo visitado
     */
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    /**
     * Obtiene el vertice previo en el camino a este vertice
     *
     * @return El vertice previo en el camino a este vertice
     */
    public Vertex<T> getPredecesor() {
        return predecesor;
    }

    /**
     * Establece el vertice previo en el camino a este vertice
     *
     * @param predecesor El vertice previo en el camino a este vertice
     */
    public void setPredecesor(Vertex<T> predecesor) {
        this.predecesor = predecesor;
    }

    /**
     * Determina si se ha establecido un vertice previo en el camino a este
     * vértice
     *
     * @return true si se ha establecido un vertice previo en el camino a este
     * vertice, false en caso contrario
     */
    public boolean hasPredecessor() {
        return predecesor != null;
    }

    /**
     * Obtiene el peso de un camino hasta este vertice
     *
     * @return El peso de un camino hasta este vertice
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el peso de un camino hasta este vertice
     *
     * @param peso El costo de un camino hasta este vertice
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Obtiene el codigo hash para este vertice usando la etiqueta del vertice
     *
     * @return El codigo hash para este vertice
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.etiqueta);
        return hash;
    }

    /**
     * Determina si el vertice del parametro es igual a este vertice comparando
     * las etiquetas
     *
     * @param obj Vertice con el que se compara este vertice
     * @return true si los vertices son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertex<?> other = (Vertex<?>) obj;
        return Objects.equals(this.etiqueta, other.etiqueta);
    }
}
