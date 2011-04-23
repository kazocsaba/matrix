package kcsaba.math.matrix;

/**
 * Thrown when an operation cannot be performed because of a singular matrix.
 * @author Kazó Csaba
 */
public class SingularityException extends Exception {
	private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of <code>SingularityException</code> without detail message.
     */
    public SingularityException() {
    }


    /**
     * Constructs an instance of <code>SingularityException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public SingularityException(String msg) {
        super(msg);
    }
}
