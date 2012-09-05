package hu.kazocsaba.math.matrix.backbone;

import hu.kazocsaba.math.matrix.EigenDecomposition;
import hu.kazocsaba.math.matrix.Matrix;
import hu.kazocsaba.math.matrix.MatrixFactory;
import hu.kazocsaba.math.matrix.SingularValueDecomposition;
import hu.kazocsaba.math.matrix.SingularityException;
import hu.kazocsaba.math.matrix.immutable.ImmutableMatrixFactory;

/**
 * Implementations of the Matrix functions for the benefit of Matrix subclasses. These methods rely on the
 * {@link Matrix#get(int, int)}, {@link Matrix#set(int, int, double)}, {@link Matrix#getRowCount()}, and
 * {@link Matrix#getColumnCount()} functions, so all others can delegate to this class.
 * @author Kazó Csaba
 */
public class MatrixOp {
	MatrixOp() {}
	
	/**
	 * @see Matrix#mul(Matrix)
	 */
	public static Matrix mul(Matrix caller, Matrix m) {
		if (caller.getColumnCount() != m.getRowCount()) throw new IllegalArgumentException();
		Matrix result = MatrixFactory.createMatrix(caller.getRowCount(), m.getColumnCount());
		for (int row = 0; row < result.getRowCount(); row++)
			for (int col = 0; col < result.getColumnCount(); col++) {
				double v = 0;
				for (int i = 0; i < caller.getColumnCount(); i++)
					v += caller.getQuick(row, i) * m.getQuick(i, col);
				result.setQuick(row, col, v);
			}
		return result;
	}

	/**
	 * @see Matrix#scale(double)
	 */
	public static void scale(Matrix caller, double c) {
		for (int row = 0; row < caller.getRowCount(); row++)
			for (int col = 0; col < caller.getColumnCount(); col++)
				caller.setQuick(row, col, caller.getQuick(row, col)*c);
	}

	/**
	 * @see Matrix#times(double)
	 */
	public static Matrix times(Matrix caller, double c) {
		Matrix result=MatrixFactory.createLike(caller);
		for (int row = 0; row < caller.getRowCount(); row++)
			for (int col = 0; col < caller.getColumnCount(); col++)
				result.setQuick(row, col, caller.getQuick(row, col)*c);
		return result;
	}

	/**
	 * @see Matrix#add(Matrix)
	 */
	public static void add(Matrix caller, Matrix m) {
		if (caller.getRowCount() != m.getRowCount() || caller.getColumnCount() != m.getColumnCount())
			throw new IllegalArgumentException();
		for (int i=0; i<caller.getRowCount(); i++) for (int j=0; j<caller.getColumnCount(); j++)
			caller.setQuick(i, j, caller.getQuick(i, j) + m.getQuick(i, j));
	}

	/**
	 * @see Matrix#subtract(Matrix)
	 */
	public static void subtract(Matrix caller, Matrix m) {
		if (caller.getRowCount() != m.getRowCount() || caller.getColumnCount() != m.getColumnCount())
			throw new IllegalArgumentException();
		for (int i=0; i<caller.getRowCount(); i++) for (int j=0; j<caller.getColumnCount(); j++)
			caller.setQuick(i, j, caller.getQuick(i, j) - m.getQuick(i, j));
	}

	/**
	 * @see Matrix#getSubmatrix(int,int,int,int)
	 */
	public static Matrix getSubmatrix(Matrix caller, int row1, int row2, int col1, int col2) {
		if (row1 < 0 || col1 < 0 || row2 >= caller.getRowCount() || col2 >= caller.getColumnCount() || row2 < row1 || col2 < col1)
			throw new IllegalArgumentException();
		Matrix result = MatrixFactory.createMatrix(row2 - row1 + 1, col2 - col1 + 1);
		for (int row = 0; row < result.getRowCount(); row++)
			for (int col = 0; col < result.getColumnCount(); col++)
				result.setQuick(row, col, caller.getQuick(row1 + row, col1 + col));
		return result;
	}

	/**
	 * @see Matrix#setSubmatrix(Matrix,int,int)
	 */
	public static void setSubmatrix(Matrix caller, Matrix m, int row, int col) {
		if (row<0 || col<0 || row+m.getRowCount()>caller.getRowCount() || col+m.getColumnCount()>caller.getColumnCount())
			throw new IllegalArgumentException();
		for (int r=0; r<m.getRowCount(); r++) for (int c=0; c<m.getColumnCount(); c++)
			caller.setQuick(row+r, col+c, m.getQuick(r, c));
	}

	/**
	 * @see Matrix#plus(Matrix)
	 */
	public static Matrix plus(Matrix caller, Matrix m) {
		if (caller.getRowCount() != m.getRowCount() || caller.getColumnCount() != m.getColumnCount())
			throw new IllegalArgumentException();
		Matrix result=MatrixFactory.createLike(caller);
		for (int i=0; i<caller.getRowCount(); i++) for (int j=0; j<caller.getColumnCount(); j++)
			result.setQuick(i, j, caller.getQuick(i, j) + m.getQuick(i, j));
		return result;
	}

	/**
	 * @see Matrix#minus(Matrix)
	 */
	public static Matrix minus(Matrix caller, Matrix m) {
		if (caller.getRowCount() != m.getRowCount() || caller.getColumnCount() != m.getColumnCount())
			throw new IllegalArgumentException();
		Matrix result=MatrixFactory.createLike(caller);
		for (int i=0; i<caller.getRowCount(); i++) for (int j=0; j<caller.getColumnCount(); j++)
			result.setQuick(i, j, caller.getQuick(i, j) - m.getQuick(i, j));
		return result;
	}

	/**
	 * @see Matrix#inverse()
	 */
	public static Matrix inverse(Matrix caller) throws SingularityException {
		if (caller.getRowCount()!=caller.getColumnCount()) throw new IllegalArgumentException("Matrix is not square");
		return new JamaLU(caller).solve(ImmutableMatrixFactory.identity(caller.getRowCount()));
	}

	/**
	 * @see Matrix#pseudoInverse()
	 */
	public static Matrix pseudoInverse(Matrix caller) {
		double threshold = 1E-15;
		SingularValueDecomposition svd = caller.svd();
		Matrix D = svd.getS();
		for (int i = 0; i < D.getRowCount(); i++) {
			if (D.getQuick(i, i) > threshold) D.setQuick(i, i, 1 / D.getQuick(i, i));
		}
		return svd.getV().mul(D).mul(svd.getU().transpose());
	}
	
	/**
	 * @see Matrix#transpose()
	 */
	public static Matrix transpose(Matrix caller) {
		Matrix result = MatrixFactory.createMatrix(caller.getColumnCount(), caller.getRowCount());
		for (int i = 0; i < caller.getRowCount(); i++)
			for (int j = 0; j < caller.getColumnCount(); j++)
				result.setQuick(j, i, caller.getQuick(i, j));
		return result;
	}

	/**
	 * @see Matrix#determinant()
	 */
	public static double determinant(Matrix caller) {
		if (caller.getRowCount()!=caller.getColumnCount()) throw new IllegalArgumentException("Matrix is not square");
		switch (caller.getRowCount()) {
			case 2:
				return caller.getQuick(0, 0)*caller.getQuick(1, 1)-caller.getQuick(1, 0)*caller.getQuick(0, 1);
			case 3:
				return caller.getQuick(0, 0)*caller.getQuick(1, 1)*caller.getQuick(2, 2)+
						caller.getQuick(0, 1)*caller.getQuick(1, 2)*caller.getQuick(2, 0)+
						caller.getQuick(0, 2)*caller.getQuick(1, 0)*caller.getQuick(2, 1)-
						caller.getQuick(0, 0)*caller.getQuick(1, 2)*caller.getQuick(2, 1)-
						caller.getQuick(0, 1)*caller.getQuick(1, 0)*caller.getQuick(2, 2)-
						caller.getQuick(0, 2)*caller.getQuick(1, 1)*caller.getQuick(2, 0);
			default:
				return new JamaLU(caller).det();
		}
	}
	
	/**
	 * @see Matrix#svd()
	 */
	public static SingularValueDecomposition svd(Matrix caller) {
		return new JamaSVD(caller);
	}
	
	/**
	 * @see Matrix#eig()
	 */
	public static EigenDecomposition eig(Matrix caller) {
		return new JamaEIG(caller);
	}

	/**
	 * @see Matrix#norm()
	 */
	public static double norm(Matrix caller) {
		double n = 0;
		for (int i = 0; i < caller.getRowCount(); i++)
			for (int j = 0; j < caller.getColumnCount(); j++)
				n += caller.getQuick(i, j) * caller.getQuick(i, j);
		return Math.sqrt(n);
	}
	/**
	 * @see Matrix#normalize()
	 */
	public static void normalize(Matrix caller) {
		caller.scale(1/caller.norm());
	}
	/**
	 * @see Matrix#normalized()
	 */
	public static Matrix normalized(Matrix caller) {
		return caller.times(1/caller.norm());
	}
	/**
	 * @see Matrix#error(Matrix)
	 */
	public static double error(Matrix caller, Matrix other) {
		if (caller.getRowCount()!=other.getRowCount() || caller.getColumnCount()!=other.getColumnCount())
			throw new IllegalArgumentException("Matrix dimensions do not match");
		double error=0;
		for (int row=0; row<caller.getRowCount(); row++) for (int col=0; col<caller.getColumnCount(); col++) {
			double diff=caller.getQuick(row, col)-other.getQuick(row, col);
			error+=diff*diff;
		}
		return Math.sqrt(error);
	}
	/**
	 * @see Matrix#equals(Object)
	 */
	public static boolean equals(Matrix caller, Object o) {
		if (!(o instanceof Matrix)) return false;
		if (o==caller) return true;
		
		Matrix other=(Matrix)o;
		if (caller.getRowCount()!=other.getRowCount()) return false;
		if (caller.getColumnCount()!=other.getColumnCount()) return false;
		
		for (int row=0; row<caller.getRowCount(); row++) for (int col=0; col<caller.getColumnCount(); col++) {
			if (caller.getQuick(row, col)!=other.getQuick(row, col)) return false;
		}
		return true;
	}
	/**
	 * Implements a hashCode appropriate for the equals relation.
	 */
	public static int hashCode(Matrix caller) {
		int result = 1;
		for (int row=0; row<caller.getRowCount(); row++) for (int col=0; col<caller.getColumnCount(); col++) {
			long bits = Double.doubleToLongBits(caller.getQuick(row, col));
			result = 31 * result + (int)(bits ^ (bits >>> 32));
		}
		return result;
	}
}
