package hu.kazocsaba.math.matrix.immutable;

import hu.kazocsaba.math.matrix.Matrix;
import hu.kazocsaba.math.matrix.Matrix2;
import hu.kazocsaba.math.matrix.Matrix3;
import hu.kazocsaba.math.matrix.Vector;
import hu.kazocsaba.math.matrix.Vector2;
import hu.kazocsaba.math.matrix.Vector3;
import hu.kazocsaba.math.matrix.Vector4;

/**
 * Factory for creating immutable matrices.
 *
 * @author Kazó Csaba
 */
public final class ImmutableMatrixFactory {
	/**
	 * Creates a new immutable 2D column vector.
	 *
	 * @param x the x coordinate of the new vector
	 * @param y the y coordinate of the new vector
	 * @return the new vector
	 */
	public static ImmutableVector2 createVector(final double x, final double y) {
		return new ImmutableVector2(new ImmutableData(2, 1) {
			@Override
			public double getQuick(int row, int col) {
				if (row == 0)
					return x;
				else
					return y;
			}
		});
	}

	/**
	 * Creates a new immutable 3D column vector.
	 *
	 * @param x the x coordinate of the new vector
	 * @param y the y coordinate of the new vector
	 * @param z the z coordinate of the new vector
	 * @return the new vector
	 */
	public static ImmutableVector3 createVector(final double x, final double y, final double z) {
		return new ImmutableVector3(new ImmutableData(3, 1) {
			@Override
			public double getQuick(int row, int col) {
				switch (row) {
					case 0:
						return x;
					case 1:
						return y;
					default:
						return z;
				}
			}
		});
	}

	/**
	 * Creates a new immutable 4D column vector.
	 *
	 * @param x the x coordinate of the new vector
	 * @param y the y coordinate of the new vector
	 * @param z the z coordinate of the new vector
	 * @param h the h coordinate of the new vector
	 * @return the new vector
	 */
	public static ImmutableVector4 createVector(final double x, final double y, final double z, final double h) {
		return new ImmutableVector4(new ImmutableData(4, 1) {
			@Override
			public double getQuick(int row, int col) {
				switch (row) {
					case 0:
						return x;
					case 1:
						return y;
					case 2:
						return z;
					default:
						return h;
				}
			}
		});
	}

	/**
	 * Returns an immutable matrix with the same values as the argument.
	 *
	 * @param source the matrix containing the data for the new immutable matrix
	 * @return an immutable matrix containing the same elements as {@code source}
	 * @throws NullPointerException if {@code source} is {@code null}
	 */
	public static ImmutableMatrix copy(Matrix source) {
		if (source instanceof ImmutableMatrix) return (ImmutableMatrix)source;
		if (source.getColumnCount() == 1) return copy((Vector)source);
		if (source.getRowCount() == 2 && source.getColumnCount() == 2) return new ImmutableMatrix2((Matrix2)source);
		if (source.getRowCount() == 3 && source.getColumnCount() == 3) return new ImmutableMatrix3((Matrix3)source);
		return new ImmutableMatrix(source);
	}

	/**
	 * Returns an immutable matrix with the same values as the argument.
	 *
	 * @param source the matrix containing the data for the new immutable matrix
	 * @return an immutable matrix containing the same elements as {@code source}
	 * @throws NullPointerException if {@code source} is {@code null}
	 */
	public static ImmutableMatrix2 copy(Matrix2 source) {
		if (source instanceof ImmutableMatrix2) return (ImmutableMatrix2)source;
		return new ImmutableMatrix2(source);
	}

	/**
	 * Returns an immutable matrix with the same values as the argument.
	 *
	 * @param source the matrix containing the data for the new immutable matrix
	 * @return an immutable matrix containing the same elements as {@code source}
	 * @throws NullPointerException if {@code source} is {@code null}
	 */
	public static ImmutableMatrix3 copy(Matrix3 source) {
		if (source instanceof ImmutableMatrix3) return (ImmutableMatrix3)source;
		return new ImmutableMatrix3(source);
	}

	/**
	 * Returns an immutable vector with the same values as the argument.
	 *
	 * @param source the vector containing the data for the new immutable vector
	 * @return an immutable vector containing the same elements as {@code source}
	 * @throws NullPointerException if {@code source} is {@code null}
	 */
	public static ImmutableVector copy(Vector source) {
		if (source instanceof ImmutableVector) return (ImmutableVector)source;
		switch (source.getRowCount()) {
			case 2:
				return copy((Vector2)source);
			case 3:
				return copy((Vector3)source);
			case 4:
				return copy((Vector4)source);
			default:
				return new ImmutableVector(source);
		}
	}

	/**
	 * Returns an immutable vector with the same values as the argument.
	 *
	 * @param source the vector containing the data for the new immutable vector
	 * @return an immutable vector containing the same elements as {@code source}
	 * @throws NullPointerException if {@code source} is {@code null}
	 */
	public static ImmutableVector2 copy(Vector2 source) {
		if (source instanceof ImmutableVector2) return (ImmutableVector2)source;
		return createVector(source.getX(), source.getY());
	}

	/**
	 * Returns an immutable vector with the same values as the argument.
	 *
	 * @param source the vector containing the data for the new immutable vector
	 * @return an immutable vector containing the same elements as {@code source}
	 * @throws NullPointerException if {@code source} is {@code null}
	 */
	public static ImmutableVector3 copy(Vector3 source) {
		if (source instanceof ImmutableVector3) return (ImmutableVector3)source;
		return createVector(source.getX(), source.getY(), source.getZ());
	}

	/**
	 * Returns an immutable vector with the same values as the argument.
	 *
	 * @param source the vector containing the data for the new immutable vector
	 * @return an immutable vector containing the same elements as {@code source}
	 * @throws NullPointerException if {@code source} is {@code null}
	 */
	public static ImmutableVector4 copy(Vector4 source) {
		if (source instanceof ImmutableVector4) return (ImmutableVector4)source;
		return createVector(source.getX(), source.getY(), source.getZ(), source.getH());
	}

	/**
	 * Creates an immutable matrix with its elements taken from an array. The parameter should be a {@code double[r][c]}
	 * array with {@code r>0} and {@code c>0}. The matrix element at row {@code row} and column {@code col} will be
	 * {@code elements[row][col]}.
	 * 
	 * @param elements the array containing the elements of the matrix
	 * @return the new matrix
	 * @throws NullPointerException if the array is {@code null}
	 * @throws IllegalArgumentException if the dimensions of the array are not valid
	 */
	public static ImmutableMatrix createMatrix(double[][] elements) {
		return create(new ImmutableDataImpl(elements));
	}
	
	static ImmutableMatrix create(ImmutableData data) {
		if (data.getColumnCount() == 1) {
			switch (data.getRowCount()) {
				case 2:
					return new ImmutableVector2(data);
				case 3:
					return new ImmutableVector3(data);
				case 4:
					return new ImmutableVector4(data);
				default:
					return new ImmutableVector(data);
			}
		}
		if (data.getRowCount() == 2 && data.getColumnCount() == 2) return new ImmutableMatrix2(data);
		if (data.getRowCount() == 3 && data.getColumnCount() == 3) return new ImmutableMatrix3(data);
		return new ImmutableMatrix(data);
	}

	/**
	 * Returns an immutable matrix of the specified size whose elements are all 0.
	 *
	 * @param rows the number of rows
	 * @param cols the number of columns
	 * @return a <code>rows</code>×<code>cols</code> matrix whose elements are all 0
	 * @throws IllegalArgumentException if either argument is non-positive
	 */
	public static ImmutableMatrix zeros(final int rows, final int cols) {
		if (rows <= 0 || cols <= 0) throw new IllegalArgumentException("Invalid dimensions");
		return create(new ImmutableData(rows, cols) {
			@Override
			public double getQuick(int row, int col) {
				return 0;
			}
		});
	}

	/**
	 * Returns an immutable matrix of the specified size whose elements are all 1.
	 *
	 * @param rows the number of rows
	 * @param cols the number of columns
	 * @return a <code>rows</code>×<code>cols</code> matrix whose elements are all 1
	 * @throws IllegalArgumentException if either argument is non-positive
	 */
	public static ImmutableMatrix ones(final int rows, final int cols) {
		if (rows <= 0 || cols <= 0) throw new IllegalArgumentException("Invalid dimensions");
		return create(new ImmutableData(rows, cols) {
			@Override
			public double getQuick(int row, int col) {
				return 1;
			}
		});
	}

	/**
	 * Returns an immutable identity matrix of the specified dimension.
	 *
	 * @param size the dimension of the matrix
	 * @return a <code>size</code>×<code>size</code> identity matrix
	 * @throws IllegalArgumentException if the size is not positive
	 */
	public static ImmutableMatrix identity(final int size) {
		if (size <= 0) throw new IllegalArgumentException("Invalid size");
		return create(new ImmutableData(size, size) {
			@Override
			public double getQuick(int row, int col) {
				return row == col ? 1 : 0;
			}
		});
	}
}
