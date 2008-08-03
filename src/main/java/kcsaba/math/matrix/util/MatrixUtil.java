package kcsaba.math.matrix.util;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.MatrixFactory;

/**
 * The <code>MatrixUtil</code> class contains static utility methods related to matrices.
 * @author Kazó Csaba
 */
public class MatrixUtil {

	private MatrixUtil() {}

	/**
	 * Creates a copy of the specified matrix.
	 * @param m a matrix
	 * @return a matrix having the same dimensions and elements as the argument
	 * @throws NullPointerException if the argument is <code>null</code>
	 */
	public static Matrix copyOf(Matrix m) {
		Matrix copy = MatrixFactory.createMatrix(m.getRowCount(), m.getColumnCount());
		for (int i = 0; i < m.getRowCount(); i++)
			for (int j = 0; j < m.getColumnCount(); j++)
				copy.set(i, j, m.get(i, j));
		return copy;
	}

	/**
	 * Creates an identity matrix of the specified dimension.
	 * @param size the dimension of the matrix
	 * @return a <code>size</code>×<code>size</code> identity matrix
	 * @throws IllegalArgumentException if the size is not positive
	 */
	public static Matrix identity(int size) {
		Matrix m = MatrixFactory.createMatrix(size, size);
		for (int i = 0; i < size; i++)
			m.set(i, i, 1);
		return m;
	}

	/**
	 * Creates a matrix of the specified size whose elements are all 1.
	 * @param rows the number of rows
	 * @param columns the number of columns
	 * @return a <code>rows</code>×<code>columns</code> matrix whose elements are all 1
	 * @throws IllegalArgumentException if either argument is non-positive
	 */
	public static Matrix ones(int rows, int columns) {
		Matrix m = MatrixFactory.createMatrix(rows, columns);
		for (int i = 0; i < m.getRowCount(); i++)
			for (int j = 0; j < m.getColumnCount(); j++)
				m.set(i, j, 1);
		return m;
	}

	/**
	 * Creates a matrix of the specified size whose elements are pseudorandom, uniformly distributed
	 * values between 0 (inclusive) and 1 (exclusive).
	 * @param rows the number of rows
	 * @param columns the number of columns
	 * @return a <code>rows</code>×<code>columns</code> matrix of random elements
	 * @throws IllegalArgumentException if either argument is non-positive
	 */
	public static Matrix random(int rows, int columns) {
		Matrix m = MatrixFactory.createMatrix(rows, columns);
		for (int i = 0; i < m.getRowCount(); i++)
			for (int j = 0; j < m.getColumnCount(); j++)
				m.set(i, j, Math.random());
		return m;
	}
}
