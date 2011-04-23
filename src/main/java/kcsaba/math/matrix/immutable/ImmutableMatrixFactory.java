package kcsaba.math.matrix.immutable;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.Matrix2;
import kcsaba.math.matrix.Matrix3;
import kcsaba.math.matrix.Vector;
import kcsaba.math.matrix.Vector2;
import kcsaba.math.matrix.Vector3;
import kcsaba.math.matrix.Vector4;

/**
 * Factory for creating immutable matrices.
 * @author Kazó Csaba
 */
public final class ImmutableMatrixFactory {

	/**
	 * Returns an immutable matrix with the same values as the argument.
	 * @throws NullPointerException if {@code source} is {@code null}
	 */
	public static ImmutableMatrix copy(Matrix source) {
		if (source instanceof ImmutableMatrix) return (ImmutableMatrix) source;
		if (source.getColumnCount() == 1) return copy((Vector) source);
		if (source.getRowCount() == 2 && source.getColumnCount() == 2) return new ImmutableMatrix2((Matrix2) source);
		if (source.getRowCount() == 3 && source.getColumnCount() == 3) return new ImmutableMatrix3((Matrix3) source);
		return new ImmutableMatrix(source);
	}

	/**
	 * Returns an immutable matrix with the same values as the argument.
	 * @throws NullPointerException if {@code source} is {@code null}
	 */
	public static ImmutableMatrix2 copy(Matrix2 source) {
		return new ImmutableMatrix2(source);
	}

	/**
	 * Returns an immutable matrix with the same values as the argument.
	 * @throws NullPointerException if {@code source} is {@code null}
	 */
	public static ImmutableMatrix3 copy(Matrix3 source) {
		return new ImmutableMatrix3(source);
	}

	/**
	 * Returns an immutable vector with the same values as the argument.
	 * @throws NullPointerException if {@code source} is {@code null}
	 */
	public static ImmutableVector copy(Vector source) {
		if (source instanceof ImmutableVector) return (ImmutableVector) source;
		switch (source.getRowCount()) {
			case 2: return new ImmutableVector2((Vector2)source);
			case 3: return new ImmutableVector3((Vector3)source);
			case 4: return new ImmutableVector4((Vector4)source);
			default: return new ImmutableVector(source);
		}
	}
	
	/**
	 * Returns an immutable vector with the same values as the argument.
	 * @throws NullPointerException if {@code source} is {@code null}
	 */
	public static ImmutableVector2 copy(Vector2 source) {
		if (source instanceof ImmutableVector2) return (ImmutableVector2) source;
		return new ImmutableVector2(source);
	}
	
	/**
	 * Returns an immutable vector with the same values as the argument.
	 * @throws NullPointerException if {@code source} is {@code null}
	 */
	public static ImmutableVector3 copy(Vector3 source) {
		if (source instanceof ImmutableVector3) return (ImmutableVector3) source;
		return new ImmutableVector3(source);
	}
	
	/**
	 * Returns an immutable vector with the same values as the argument.
	 * @throws NullPointerException if {@code source} is {@code null}
	 */
	public static ImmutableVector4 copy(Vector4 source) {
		if (source instanceof ImmutableVector4) return (ImmutableVector4) source;
		return new ImmutableVector4(source);
	}
	
	private static ImmutableMatrix create(ImmutableData data) {
		if (data.getColumnCount() == 1) {
			switch (data.getRowCount()) {
				case 2: return new ImmutableVector2(data);
				case 3: return new ImmutableVector3(data);
				case 4: return new ImmutableVector4(data);
				default: return new ImmutableVector(data);
			}
		}
		if (data.getRowCount() == 2 && data.getColumnCount() == 2) return new ImmutableMatrix2(data);
		if (data.getRowCount() == 3 && data.getColumnCount() == 3) return new ImmutableMatrix3(data);
		return new ImmutableMatrix(data);
	}

	/**
	 * Returns an immutable matrix of the specified size whose elements are all 0.
	 * @param rows the number of rows
	 * @param cols the number of columns
	 * @return a <code>rows</code>×<code>cols</code> matrix whose elements are all 0
	 * @throws IllegalArgumentException if either argument is non-positive
	 */
	public static ImmutableMatrix zeros(final int rows, final int cols) {
		if (rows<=0 || cols<=0) throw new IllegalArgumentException("Invalid dimensions");
		return create(new ImmutableData() {

			@Override
			public double get(int row, int col) {
				if (row<0 || row>=rows || col<0 || col>=cols) throw new IndexOutOfBoundsException();
				return 0;
			}

			@Override
			public int getColumnCount() {
				return rows;
			}

			@Override
			public int getRowCount() {
				return cols;
			}
		});
	}
	
	/**
	 * Returns an immutable matrix of the specified size whose elements are all 1.
	 * @param rows the number of rows
	 * @param cols the number of columns
	 * @return a <code>rows</code>×<code>cols</code> matrix whose elements are all 1
	 * @throws IllegalArgumentException if either argument is non-positive
	 */
	public static ImmutableMatrix ones(final int rows, final int cols) {
		if (rows<=0 || cols<=0) throw new IllegalArgumentException("Invalid dimensions");
		return create(new ImmutableData() {

			@Override
			public double get(int row, int col) {
				if (row<0 || row>=rows || col<0 || col>=cols) throw new IndexOutOfBoundsException();
				return 1;
			}

			@Override
			public int getColumnCount() {
				return rows;
			}

			@Override
			public int getRowCount() {
				return cols;
			}
		});
	}
	
	/**
	 * Returns an immutable identity matrix of the specified dimension.
	 * @param size the dimension of the matrix
	 * @return a <code>size</code>×<code>size</code> identity matrix
	 * @throws IllegalArgumentException if the size is not positive
	 */
	public static ImmutableMatrix identity(final int size) {
		if (size<=0) throw new IllegalArgumentException("Invalid size");
		return create(new ImmutableData() {

			@Override
			public double get(int row, int col) {
				if (row<0 || row>=size || col<0 || col>=size) throw new IndexOutOfBoundsException();
				return row==col ? 1 : 0;
			}

			@Override
			public int getColumnCount() {
				return size;
			}

			@Override
			public int getRowCount() {
				return size;
			}
		});
	}
	
}
