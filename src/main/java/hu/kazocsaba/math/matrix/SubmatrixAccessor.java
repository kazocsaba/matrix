package hu.kazocsaba.math.matrix;

/**
 * Provides strongly typed access to submatrices. The exact semantics of the accessor methods depend on the
 * implementation
 *
 * @author Kazó Csaba
 */
public interface SubmatrixAccessor {
	/**
	 * Returns a submatrix. <strong>Note that unlike {@link Matrix#getSubmatrix(int, int, int, int) Matrix.getSubmatrix},
	 * this function expects the dimensions of the submatrix.</strong>
	 *
	 * @param row the first row of the submatrix
	 * @param col the first column of the submatrix
	 * @param rowCount the number of rows in the submatrix
	 * @param colCount the number of columns in the submatrix
	 * @return the specified submatrix
	 * @throws IllegalArgumentException if the parameters do not specify a proper submatrix
	 */
	public Matrix matrix(int row, int col, int rowCount, int colCount);

	/**
	 * Returns a 2x2 submatrix. This function selects the elements between {@code (row, col)} and {@code (row+1, col+1)}.
	 *
	 * @param row the first row of the submatrix
	 * @param col the first column of the submatrix
	 * @return the specified submatrix
	 * @throws IllegalArgumentException if the parameters do not specify a proper submatrix
	 */
	public Matrix2 matrix2(int row, int col);

	/**
	 * Returns a 3x3 submatrix. This function selects the elements between {@code (row, col)} and {@code (row+2, col+2)}.
	 *
	 * @param row the first row of the submatrix
	 * @param col the first column of the submatrix
	 * @return the specified submatrix
	 * @throws IllegalArgumentException if the parameters do not specify a proper submatrix
	 */
	public Matrix3 matrix3(int row, int col);

	/**
	 * Returns a subvector. This function selects the elements between {@code (row, col)} and
	 * {@code (row+dimension-1, col)}.
	 *
	 * @param row the first row of the subvector
	 * @param col the column containing the subvector
	 * @param dimension the dimension of the subvector
	 * @return the specified subvector
	 * @throws IllegalArgumentException if the parameters do not specify a proper subvector
	 */
	public Vector vector(int row, int col, int dimension);

	/**
	 * Returns a 2D subvector. This function selects the elements between {@code (row, col)} and {@code (row+1, col)}.
	 *
	 * @param row the first row of the subvector
	 * @param col the column containing the subvector
	 * @return the specified subvector
	 * @throws IllegalArgumentException if the parameters do not specify a proper subvector
	 */
	public Vector2 vector2(int row, int col);

	/**
	 * Returns a 3D subvector. This function selects the elements between {@code (row, col)} and {@code (row+2, col)}.
	 *
	 * @param row the first row of the subvector
	 * @param col the column containing the subvector
	 * @return the specified subvector
	 * @throws IllegalArgumentException if the parameters do not specify a proper subvector
	 */
	public Vector3 vector3(int row, int col);

	/**
	 * Returns a 4D subvector. This function selects the elements between {@code (row, col)} and {@code (row+3, col)}.
	 *
	 * @param row the first row of the subvector
	 * @param col the column containing the subvector
	 * @return the specified subvector
	 * @throws IllegalArgumentException if the parameters do not specify a proper subvector
	 */
	public Vector4 vector4(int row, int col);

	/**
	 * Returns a row subvector. This function selects the elements between {@code (row, col)} and
	 * {@code (row, col+dimension-1)}, but returns them as a column vector.
	 *
	 * @param row the row of the subvector
	 * @param col the first column containing the subvector
	 * @param dimension the dimension of the subvector
	 * @return the specified subvector
	 * @throws IllegalArgumentException if the parameters do not specify a proper subvector
	 */
	public Vector rowVector(int row, int col, int dimension);

	/**
	 * Returns a 2D subvector. This function selects the elements between {@code (row, col)} and {@code (row, col+1)},
	 * but returns them as a column vector.
	 *
	 * @param row the row of the subvector
	 * @param col the first column containing the subvector
	 * @return the specified subvector
	 * @throws IllegalArgumentException if the parameters do not specify a proper subvector
	 */
	public Vector2 rowVector2(int row, int col);

	/**
	 * Returns a 3D subvector. This function selects the elements between {@code (row, col)} and {@code (row, col+2)},
	 * but returns them as a column vector.
	 *
	 * @param row the row of the subvector
	 * @param col the first column containing the subvector
	 * @return the specified subvector
	 * @throws IllegalArgumentException if the parameters do not specify a proper subvector
	 */
	public Vector3 rowVector3(int row, int col);

	/**
	 * Returns a 4D subvector. This function selects the elements between {@code (row, col)} and {@code (row, col+3)},
	 * but returns them as a column vector.
	 *
	 * @param row the row of the subvector
	 * @param col the first column containing the subvector
	 * @return the specified subvector
	 * @throws IllegalArgumentException if the parameters do not specify a proper subvector
	 */
	public Vector4 rowVector4(int row, int col);

	/**
	 * Returns an entire row. This function selects the elements between {@code (row, 0)} and {@code (row, c-1)} where
	 * {@code c} is the number of columns in this matrix, but returns these elements as a column vector.
	 *
	 * @param row the index of the row
	 * @return IllegalArgumentException if {@code row} is not a valid row index
	 */
	public Vector row(int row);

	/**
	 * Returns an entire column. This function selects the elements between {@code (0, col)} and {@code (r-1, col)} where
	 * {@code r} is the number of rows in this matrix.
	 *
	 * @param col the index of the column
	 * @return IllegalArgumentException if {@code col} is not a valid column index
	 */
	public Vector column(int col);
}
