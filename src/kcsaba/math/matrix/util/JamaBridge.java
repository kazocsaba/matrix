package kcsaba.math.matrix.util;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.MatrixFactory;

/**
 * Utility classes for conversion to and from Jama matrices.
 * @author Kazó Csaba
 */
public class JamaBridge {
	private JamaBridge() {}
	
	/**
	 * Returns a Jama matrix object representing the same matrix as the argument.
	 * @param m a matrix
	 * @return a Jama matrix representing the same matrix
	 * @throws NullPointerException if the argument is null
	 */
	public static Jama.Matrix toJama(Matrix m) {
		Jama.Matrix result=new Jama.Matrix(m.getRowCount(), m.getColumnCount());
		for (int i=0; i<m.getRowCount(); i++) for (int j=0; j<m.getColumnCount(); j++)
			result.set(i, j, m.get(i, j));
		return result;
	}
	
	/**
	 * Returns a matrix object representing the same matrix as the argument.
	 * @param m a Jama matrix
	 * @return a matrix representing the same matrix as the Jama instance
	 * @throws NullPointerException if the argument is null
	 */
	public static Matrix fromJama(Jama.Matrix m) {
		Matrix result=MatrixFactory.createMatrix(m.getRowDimension(), m.getColumnDimension());
		for (int i=0; i<result.getRowCount(); i++) for (int j=0; j<result.getColumnCount(); j++)
			result.set(i, j, m.get(i, j));
		return result;
	}
}
