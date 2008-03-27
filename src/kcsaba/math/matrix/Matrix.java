package kcsaba.math.matrix;

/**
 * A matrix.
 * @author Kazó Csaba
 */
public class Matrix extends Jama.Matrix {

	/**
	 * Construct a zero matrix of the specified size.
	 * @param rows the number of row
	 * @param cols the number of columns
	 */
	Matrix(int rows, int cols) {
		super(rows, cols);
	}

	/**
	 * Returns the number of columns.
	 * @return the number of columns
	 */
	public int getColumnCount() {return getColumnDimension();}
	/**
	 * Returns the number of rows.
	 * @return the number of rows
	 */
	public int getRowCount() {return getRowDimension();}

	public Matrix mul(Matrix B) {
		if (B.getRowDimension() != getColumnDimension()) {
			throw new IllegalArgumentException("Matrix inner dimensions must agree.");
		}
		Matrix X = MatrixFactory.createMatrix(getRowCount(), B.getColumnCount());
		for (int j = 0; j < B.getColumnDimension(); j++) {
			for (int i = 0; i < getRowDimension(); i++) {
				double s = 0;
				for (int k = 0; k < getColumnDimension(); k++) {
					s += get(i, k) * B.get(k, j);
				}
				X.set(i, j, s);
			}
		}
		return X;
	}
	
	@Override
	public Matrix getMatrix(int i0, int i1, int j0, int j1) {
		Matrix X = MatrixFactory.createMatrix(i1 - i0 + 1, j1 - j0 + 1);
		try {
			for (int i = i0; i <= i1; i++) {
				for (int j = j0; j <= j1; j++) {
					X.set(i-i0, j-j0, get(i,j));
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("Submatrix indices");
		}
		return X;
	}
	
	/**
	 * Multiplies every element of this matrix with the argument (in place).
	 * @param c the scale factor
	 */
	public void scale(double c) {
		timesEquals(c);
	}
	/**
	 * Adds each element of the argument to the corresponding element of this matrix. (An in-place
	 * operation.)
	 * @param m the other matrix
	 */
	public void add(Matrix m) {
		plusEquals(m);
	}

}
