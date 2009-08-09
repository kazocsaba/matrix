package kcsaba.math.matrix;

/**
 * A matrix of double values.
 * @author Kazó Csaba
 */
public interface Matrix {
	/**
	 * Retrieves an element of the matrix.
	 * @param row the row index
	 * @param col the column index
	 * @return the element at the specified position
	 * @throws IndexOutOfBoundsException if either index is out of range
	 */
	public double get(int row, int col);
	/**
	 * Updates an element of the matrix.
	 * @param row the row index
	 * @param col the column index
	 * @param value the new value
	 * @throws IndexOutOfBoundsException if either index is out of range
	 */
	public void set(int row, int col, double value);
	/**
	 * Returns the number of columns.
	 * @return the number of columns
	 */
	public int getColumnCount();
	/**
	 * Returns the number of rows.
	 * @return the number of rows
	 */
	public int getRowCount();
	
	/**
	 * Multiplies this matrix with the argument and returns the result.
	 * @param m a matrix
	 * @return the product of the two matrices
	 * @throws IllegalArgumentException if the matrix dimensions don't match (i.e.
	 * this.getColumnCount()!=m.getRowCount()
	 * @throws NullPointerException if the argument is null
	 */
	public Matrix mul(Matrix m);
	
	/**
	 * Scales this matrix (in place) by a scalar by multiplying all matrix elements with c.
	 * @param c the scalar factor
	 */
	public void scale(double c);
	/**
	 * Adds each element of the argument to the corresponding element of this matrix. (An in-place
	 * operation.)
	 * @param m the other matrix
	 * @throws NullPointerException if the argument is null
	 * @throws IllegalArgumentException if the argument has different dimensions than this matrix
	 */
	public void add(Matrix m);
	
	/**
	 * Subtracts each element of the argument from the corresponding element of this matrix. (An in-place
	 * operation.)
	 * @param m the other matrix
	 * @throws NullPointerException if the argument is null
	 * @throws IllegalArgumentException if the argument has different dimensions than this matrix
	 */
	public void subtract(Matrix m);

	/**
	 * Returns a new matrix that is the sum of this matrix and the argument.
	 * @param m the other matrix
	 * @return the sum of this matrix and the argument
	 * @throws NullPointerException if the argument is null
	 * @throws IllegalArgumentException if the argument has different dimensions than this matrix
	 */
	public Matrix plus(Matrix m);
	
	/**
	 * Returns a new matrix that is the difference of this matrix and the argument.
	 * @param m the other matrix
	 * @return the difference of this matrix and the argument
	 * @throws NullPointerException if the argument is null
	 * @throws IllegalArgumentException if the argument has different dimensions than this matrix
	 */
	public Matrix minus(Matrix m);

	/**
	 * Returns a new matrix that is a submatrix of this one. The result will be a matrix with
	 * {@code row2-row1+1} rows and {@code col2-col1+1} columns, and will be initialized with the
	 * corresponding values from this matrix.
	 * @param row1 the first row of the submatrix
	 * @param row2 the last row of the submatrix
	 * @param col1 the first column of the submatrix
	 * @param col2 the last column of the submatrix
	 * @return the submatrix
	 * @throws IllegalArgumentException if the arguments don't properly specify a submatrix
	 */
	public Matrix getSubmatrix(int row1, int row2, int col1, int col2);

	/**
	 * Sets a submatrix of the current matrix to match the argument. The submatrix position is
	 * identified by its top left element at (row, col).
	 * @param m the matrix to copy elements from
	 * @param row the row to copy the first row of {@code m} to
	 * @param col the column to copy the first column of {@code m} to
	 * @throws NullPointerException if {@code m} is <code>null</code>
	 * @throws IllegalArgumentException if {@code row} or {@code col} is negative or if
	 * {@code row+m.getRowCount()>getRowCount()} or {@code row+m.getColumnCount()>getColumnCount()}
	 * (i.e. the matrix {@code m} doesn't fit in the current matrix at the specified position)
	 */
	public void setSubmatrix(Matrix m, int row, int col);

	/**
	 * Computes the inverse of this matrix.
	 * @return the inverse of this matrix
	 * @throws IllegalArgumentException if this matrix is not square
	 * @throws SingularityException if this matrix is singular
	 */
	public Matrix inverse() throws SingularityException;
	
	/**
	 * Computes the pseudo inverse of this matrix.
	 * @return the pseudo inverse of this matrix
	 */
	public Matrix pseudoInverse();
	
	/**
	 * Returns the transpose of this matrix.
	 * @return the transpose
	 */
	public Matrix transpose();
	
	/**
	 * Returns the determinant of this matrix.
	 * @return the determinant
	 * @throws IllegalArgumentException if this matrix is not square
	 */
	public double determinant();
	
	/**
	 * Returns the 2-norm of this matrix.
	 * @return the 2-norm
	 */
	public double norm();
	
	/**
	 * Computes the singular value decomposition of this matrix.
	 * @return the SVD of this matrix
	 */
	public SingularValueDecomposition svd();
}
