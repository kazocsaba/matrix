package hu.kazocsaba.math.matrix.backbone;

import hu.kazocsaba.math.matrix.Matrix;
import hu.kazocsaba.math.matrix.MatrixFactory;
import hu.kazocsaba.math.matrix.Vector;

/**
 * An implementation of {@code SubmatrixAccessor} which creates mutable copies.
 *
 * @author Kazó Csaba
 */
class SubmatrixAccessorImpl extends AbstractSubmatrixAccessor {
	/**
	 * Creates a new accessor.
	 *
	 * @param matrix the matrix whose submatrices are to be accessed.
	 */
	public SubmatrixAccessorImpl(Matrix matrix) {
		super(matrix);
	}

	@Override
	public Matrix matrix(int row, int col, int rowCount, int colCount) {
		return matrix.getSubmatrix(row, row + rowCount - 1, col, col + colCount - 1);
	}

	@Override
	public Vector rowVector(int row, int col, int dimension) {
		if (row < 0 || col < 0 || row >= matrix.getRowCount() || dimension <= 0 || col + dimension - 1 >= matrix.getColumnCount())
			throw new IllegalArgumentException();
		Vector v = MatrixFactory.createVector(dimension);
		for (int i = 0; i < dimension; i++)
			v.setCoordQuick(i, matrix.getQuick(row, col + i));
		return v;
	}
}
