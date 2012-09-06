package hu.kazocsaba.math.matrix.backbone;

import hu.kazocsaba.math.matrix.Matrix;
import hu.kazocsaba.math.matrix.Matrix2;
import hu.kazocsaba.math.matrix.Matrix3;
import hu.kazocsaba.math.matrix.SubmatrixAccessor;
import hu.kazocsaba.math.matrix.Vector;
import hu.kazocsaba.math.matrix.Vector2;
import hu.kazocsaba.math.matrix.Vector3;
import hu.kazocsaba.math.matrix.Vector4;

/**
 * This class provides a skeletal implementation of the {@code SubmatrixAccessor} interface.
 * @author Kazó Csaba
 */
public abstract class AbstractSubmatrixAccessor implements SubmatrixAccessor {
	/**
	 * The matrix whose submatrices are to be accessed.
	 */
	protected final Matrix matrix;

	/**
	 * Creates an accessor for the specified matrix.
	 * @param matrix the matrix whose submatrices are to be accessed
	 */
	public AbstractSubmatrixAccessor(Matrix matrix) {
		if (matrix==null) throw new NullPointerException();
		this.matrix = matrix;
	}
	
	@Override
	public Matrix2 matrix2(int row, int col) {
		return (Matrix2)matrix(row, col, 2, 2);
	}

	@Override
	public Matrix3 matrix3(int row, int col) {
		return (Matrix3)matrix(row, col, 3, 3);
	}

	@Override
	public Vector vector(int row, int col, int dimension) {
		return (Vector)matrix(row, col, dimension, 1);
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
