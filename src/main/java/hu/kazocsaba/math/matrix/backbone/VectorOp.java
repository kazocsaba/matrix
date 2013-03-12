package hu.kazocsaba.math.matrix.backbone;

import hu.kazocsaba.math.matrix.Matrix;
import hu.kazocsaba.math.matrix.MatrixFactory;
import hu.kazocsaba.math.matrix.SingularityException;
import hu.kazocsaba.math.matrix.Vector;

/**
 * Implementations of the Matrix functions for the benefit of Vector subclasses. These methods rely on the
 * {@link Matrix#get(int, int)}, {@link Matrix#set(int, int, double)}, {@link Matrix#getRowCount()}, and
 * {@link Matrix#getColumnCount()} functions, so all others can delegate to this class.
 * @author Kazó Csaba
 */
public class VectorOp extends MatrixOp {
	VectorOp() {}
	
	/**
	 * @see Vector#dot(Vector)
	 */
	public static double dot(Vector caller, Vector v) {
		if (caller.getDimension() != v.getDimension()) throw new IllegalArgumentException();
		double result = 0;
		for (int i = 0; i < caller.getDimension(); i++)
			result += caller.getCoordQuick(i) * v.getCoordQuick(i);
		return result;
	}
	
	/**
	 * @see Matrix#inverse()
	 */
	public static Matrix inverse(Vector caller) throws SingularityException {
		if (caller.getRowCount() == 1) {
			if (caller.getQuick(0, 0) == 0)
				throw new SingularityException();
			else {
				Vector result = MatrixFactory.createVector(1);
				result.setQuick(0, 0, 1 / caller.getQuick(0, 0));
				return result;
			}
		} else
			throw new IllegalArgumentException("Matrix is not square");
	}
	
	/**
	 * @see Matrix#determinant()
	 */
	public static double determinant(Vector caller) {
		if (caller.getDimension()!=1) throw new IllegalArgumentException("Matrix is not square");
		return caller.getCoordQuick(0);
	}
	
	/**
	 * @see Matrix#pseudoInverse()
	 */
	public static Matrix pseudoInverse(Vector caller) {
		double threshold = 1E-15;
		double lenSq = 0;
		for (int i = 0; i < caller.getDimension(); i++)
			lenSq += caller.getCoordQuick(i) * caller.getCoordQuick(i);
		Matrix result = MatrixFactory.createMatrix(1, caller.getDimension());
		if (lenSq < threshold)
			return result;
		for (int i = 0; i < caller.getDimension(); i++)
			result.set(0, i, caller.getCoordQuick(i) / lenSq);
		return result;
	}
	
	/**
	 * @see Vector#toHomogeneous()
	 */
	public static Vector toHomogeneous(Vector caller) {
		Vector result = MatrixFactory.createVector(caller.getDimension() + 1);
		for (int i = 0; i < caller.getDimension(); i++)
			result.setCoordQuick(i, caller.getCoordQuick(i));
		result.setCoordQuick(result.getDimension() - 1, 1);
		return result;
	}
	
	/**
	 * @see Vector#fromHomogeneous()
	 */
	public static Vector fromHomogeneous(Vector caller) {
		Vector result = MatrixFactory.createVector(caller.getDimension() - 1);
		double factor = 1 / caller.getCoordQuick(caller.getDimension() - 1);
		for (int i = 0; i < result.getDimension(); i++)
			result.setCoordQuick(i, caller.getCoordQuick(i) * factor);
		return result;
	}
	
	public static String toString(Vector caller) {
		StringBuilder sb=new StringBuilder(24);
		sb.append('(');
		for (int i=0; i<caller.getDimension(); i++) {
			if (i>0) sb.append("; ");
			sb.append(String.format("%f", caller.getCoordQuick(i)));
		}
		sb.append(')');
		return sb.toString();
	}
}
