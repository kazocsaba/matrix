package hu.kazocsaba.math.matrix.backbone;

import hu.kazocsaba.math.matrix.Matrix;
import hu.kazocsaba.math.matrix.Matrix2;
import hu.kazocsaba.math.matrix.Matrix3;
import hu.kazocsaba.math.matrix.MatrixFactory;
import hu.kazocsaba.math.matrix.SubmatrixAccessor;
import hu.kazocsaba.math.matrix.Vector;
import hu.kazocsaba.math.matrix.Vector2;
import hu.kazocsaba.math.matrix.Vector3;
import hu.kazocsaba.math.matrix.Vector4;

/**
 * An implementation of {@code SubmatrixAccessor} which creates mutable copies.
 * @author Kazó Csaba
 */
public class SubmatrixAccessorImpl implements SubmatrixAccessor {
	private final Matrix matrix;

	/**
	 * Creates a new accessor.
	 * @param matrix the matrix whose submatrices are to be accessed.
	 */
	public SubmatrixAccessorImpl(Matrix matrix) {
		if (matrix==null) throw new NullPointerException();
		this.matrix = matrix;
	}

	@Override
	public Matrix2 matrix2(int row, int col) {
		return (Matrix2)matrix.getSubmatrix(row, row+1, col, col+1);
	}

	@Override
	public Matrix3 matrix3(int row, int col) {
		return (Matrix3)matrix.getSubmatrix(row, row+2, col, col+2);
	}

	@Override
	public Vector vector(int row, int col, int dimension) {
		return (Vector)matrix.getSubmatrix(row, row+dimension-1, col, col);
	}

	@Override
	public Vector2 vector2(int row, int col) {
		return (Vector2)vector(row, col, 2);
	}

	@Override
	public Vector3 vector3(int row, int col) {
		return (Vector3)vector(row, col, 3);
	}

	@Override
	public Vector4 vector4(int row, int col) {
		return (Vector4)vector(row, col, 4);
	}

	@Override
	public Vector rowVector(int row, int col, int dimension) {
		if (row < 0 || col < 0 || row >= matrix.getRowCount() || dimension<=0 || col+dimension-1 >= matrix.getColumnCount())
			throw new IllegalArgumentException();
		Vector v=MatrixFactory.createVector(dimension);
		for (int i=0; i<dimension; i++)
			v.setCoordQuick(i, matrix.getQuick(row, col+i));
		return v;
	}

	@Override
	public Vector2 rowVector2(int row, int col) {
		return (Vector2)rowVector(row, col, 2);
	}

	@Override
	public Vector3 rowVector3(int row, int col) {
		return (Vector3)rowVector(row, col, 3);
	}

	@Override
	public Vector4 rowVector4(int row, int col) {
		return (Vector4)rowVector(row, col, 4);
	}

	@Override
	public Vector row(int row) {
		return rowVector(row, 0, matrix.getColumnCount());
	}

	@Override
	public Vector column(int col) {
		return vector(0, col, matrix.getRowCount());
	}
}
