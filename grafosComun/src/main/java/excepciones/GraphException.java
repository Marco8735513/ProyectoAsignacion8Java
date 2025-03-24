package excepciones;

/**
 * GraphException.java
 *
 * Esta clase implementa la excepcion lanzada por los metodos de las clases que
 * implementan la interfaz IGraph.
 *
 * @author Manuel Domitsu Kono
 */
public class GraphException extends RuntimeException {

    /**
     * Constructor por omision
     */
    public GraphException() {
        super();
    }

    /**
     * Constructor que establece un mensaje en la excepcion
     *
     * @param msj Mensaje para la excepcion
     */
    public GraphException(String msj) {
        super(msj);
    }
}
