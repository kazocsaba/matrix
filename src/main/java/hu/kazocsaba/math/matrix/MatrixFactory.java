package hu.kazocsaba.math.matrix;

/**
 * Factory class for creating matrix instances.
 * @author Kazó Csaba
 */
public class MatrixFactory {
	private MatrixFactory() {}
	/**
	 * Creates a new 2D column vector with the initial value of 0.
	 * @return the new vector
	 */
	public static Vector2 createVector2() {return new Vector2Impl();}
	/**
	 * Creates and initializes a new 2D column vector.
	 * @param x the x coordinate of the new vector
	 * @param y the y coordinate of the new vector
	 * @return the new vector
	 */
	public static Vector2 createVector(double x, double y) {
		Vector2 v=new Vector2Impl();
		v.setX(x);
		v.setY(y);
		return v;
	}
	/**
	 * Creates a new 3D column vector with the initial value of 0.
	 * @return the new vector
	 */
	public static Vector3 createVector3() {return new Vector3Impl();}
	/**
	 * Creates and initializes a new 3D column vector.
	 * @param x the x coordinate of the new vector
	 * @param y the y coordinate of the new vector
	 * @param z the z coordinate of the new vector
	 * @return the new vector
	 */
	public static Vector3 createVector(double x, double y, double z) {
		Vector3 v=new Vector3Impl();
		v.setX(x);
		v.setY(y);
		v.setZ(z);
		return v;
	}
	/**
	 * Creates a new 4D column vector with the initial value of 0.
	 * @return the new vector
	 */
	public static Vector4 createVector4() {return new Vector4Impl();}
	/**
	 * Creates and initializes a new 4D column vector.
	 * @param x the x coordinate of the new vector
	 * @param y the y coordinate of the new vector
	 * @param z the z coordinate of the new vector
	 * @param h the h coordinate of the new vector
	 * @return the new vector
	 */
	public static Vector4 createVector(double x, double y, double z, double h) {
		Vector4 v=new Vector4Impl();
		v.setX(x);
		v.setY(y);
		v.setZ(z);
		v.setH(h);
		return v;
	}
	/**
	 * Creates a new column vector with all elements initialized to 0.
	 * @param dimension the dimension of the vector.
	 * @return the new vector
	 * @throws IllegalArgumentException if the argument is not positive
	 */
	public static Vector createVector(int dimension) {
		if (dimension<=0) throw new IllegalArgumentException();
		switch (dimension) {
			case 2: return createVector2();
			case 3: return createVector3();
			case 4: return createVector4();
			default: return new VectorImpl(dimension);
		}
	}
	
	/**
	 * Creates a new matrix with all elements initialized to 0.
	 * @param rowCount the number of rows
	 * @param colCount the number of columns
	 * @return a new matrix of the specified size
	 * @throws IllegalArgumentException if either argument is non-positive
	 */
	public static Matrix createMatrix(int rowCount, int colCount) {
		if (rowCount<=0 || colCount<=0) throw new IllegalArgumentException();
		if (colCount==1)
			return createVector(rowCount);
		else if (rowCount==2 && colCount==2)
			return createMatrix2();
		else if (rowCount==3 && colCount==3)
			return createMatrix3();
		else
			return new MatrixImpl(rowCount, colCount);
	}
	/**
	 * Creates a new 2x2 matrix.
	 * @return a new 2x2 matrix
	 */
	public static Matrix2 createMatrix2() {
		return new Matrix2Impl();
	}
	/**
	 * Creates a new 3x3 matrix.
	 * @return a new 3x3 matrix
	 */
	public static Matrix3 createMatrix3() {
		return new Matrix3Impl();
	}

	/**
	 * Creates a copy of a matrix.
	 * @param m the matrix to copy
	 * @return a new matrix with the same dimensions and contents as the argument
	 * @throws NullPointerException if {@code matrix} is {@code null}
	 */
	public static Matrix copy(Matrix m) {
		if (m==null) throw new NullPointerException();
		Matrix copy=createMatrix(m.getRowCount(), m.getColumnCount());
		for (int row=0; row<m.getRowCount(); row++) for (int col=0; col<m.getColumnCount(); col++)
			copy.set(row, col, m.getQuick(row, col));
		return copy;
	}

	/**
	 * Creates a copy of a matrix.
	 * @param m the matrix to copy
	 * @return a new matrix with the same dimensions and contents as the argument
	 * @throws NullPointerException if {@code matrix} is {@code null}
	 */
	public static Matrix2 copy(Matrix2 m) {
		return (Matrix2) copy((Matrix)m);
	}

	/**
	 * Creates a copy of a matrix.
	 * @param m the matrix to copy
	 * @return a new matrix with the same dimensions and contents as the argument
	 * @throws NullPointerException if {@code matrix} is {@code null}
	 */
	public static Matrix3 copy(Matrix3 m) {
		return (Matrix3) copy((Matrix)m);
	}

	/**
	 * Creates a copy of a matrix.
	 * @param m the matrix to copy
	 * @return a new matrix with the same dimensions and contents as the argument
	 * @throws NullPointerException if {@code matrix} is {@code null}
	 */
	public static Vector copy(Vector m) {
		return (Vector) copy((Matrix)m);
	}

	/**
	 * Creates a copy of a matrix.
	 * @param m the matrix to copy
	 * @return a new matrix with the same dimensions and contents as the argument
	 * @throws NullPointerException if {@code matrix} is {@code null}
	 */
	public static Vector2 copy(Vector2 m) {
		return (Vector2) copy((Matrix)m);
	}

	/**
	 * Creates a copy of a matrix.
	 * @param m the matrix to copy
	 * @return a new matrix with the same dimensions and contents as the argument
	 * @throws NullPointerException if {@code matrix} is {@code null}
	 */
	public static Vector3 copy(Vector3 m) {
		return (Vector3) copy((Matrix)m);
	}

	/**
	 * Creates a copy of a matrix.
	 * @param m the matrix to copy
	 * @return a new matrix with the same dimensions and contents as the argument
	 * @throws NullPointerException if {@code matrix} is {@code null}
	 */
	public static Vector4 copy(Vector4 m) {
		return (Vector4) copy((Matrix)m);
	}
	
	/**
	 * Creates a matrix with the same dimensions as the argument.
	 * @param matrix the template matrix
	 * @return a new zero matrix with the same dimensions as the argument
	 * @throws NullPointerException if {@code matrix} is {@code null}
	 */
	public static Matrix createLike(Matrix matrix) {
		return createMatrix(matrix.getRowCount(), matrix.getColumnCount());
	}
	
	/**
	 * Creates a matrix with the same dimensions as the argument.
	 * @param matrix the template matrix
	 * @return a new zero matrix with the same dimensions as the argument
	 * @throws NullPointerException if {@code matrix} is {@code null}
	 */
	public static Matrix2 createLike(Matrix2 matrix) {
		return (Matrix2) createMatrix(matrix.getRowCount(), matrix.getColumnCount());
	}
	
	/**
	 * Creates a matrix with the same dimensions as the argument.
	 * @param matrix the template matrix
	 * @return a new zero matrix with the same dimensions as the argument
	 * @throws NullPointerException if {@code matrix} is {@code null}
	 */
	public static Matrix3 createLike(Matrix3 matrix) {
		return (Matrix3) createMatrix(matrix.getRowCount(), matrix.getColumnCount());
	}
	
	/**
	 * Creates a matrix with the same dimensions as the argument.
	 * @param matrix the template matrix
	 * @return a new zero matrix with the same dimensions as the argument
	 * @throws NullPointerException if {@code matrix} is {@code null}
	 */
	public static Vector createLike(Vector matrix) {
		return (Vector) createMatrix(matrix.getRowCount(), matrix.getColumnCount());
	}
	
	/**
	 * Creates a matrix with the same dimensions as the argument.
	 * @param matrix the template matrix
	 * @return a new zero matrix with the same dimensions as the argument
	 * @throws NullPointerException if {@code matrix} is {@code null}
	 */
	public static Vector2 createLike(Vector2 matrix) {
		return (Vector2) createMatrix(matrix.getRowCount(), matrix.getColumnCount());
	}
	
	/**
	 * Creates a matrix with the same dimensions as the argument.
	 * @param matrix the template matrix
	 * @return a new zero matrix with the same dimensions as the argument
	 * @throws NullPointerException if {@code matrix} is {@code null}
	 */
	public static Vector3 createLike(Vector3 matrix) {
		return (Vector3) createMatrix(matrix.getRowCount(), matrix.getColumnCount());
	}
	
	/**
	 * Creates a matrix with the same dimensions as the argument.
	 * @param matrix the template matrix
	 * @return a new zero matrix with the same dimensions as the argument
	 * @throws NullPointerException if {@code matrix} is {@code null}
	 */
	public static Vector4 createLike(Vector4 matrix) {
		return (Vector4) createMatrix(matrix.getRowCount(), matrix.getColumnCount());
	}
	
	/**
	 * Creates an identity matrix of the specified dimension.
	 * @param size the dimension of the matrix
	 * @return a <code>size</code>×<code>size</code> identity matrix
	 * @throws IllegalArgumentException if the size is not positive
	 */
	public static Matrix identity(int size) {
		Matrix m = MatrixFactory.createMatrix(size, size);
		for (int i = 0; i < size; i++)
			m.set(i, i, 1);
		return m;
	}

	/**
	 * Creates a matrix of the specified size whose elements are all 1.
	 * @param rows the number of rows
	 * @param columns the number of columns
	 * @return a <code>rows</code>×<code>columns</code> matrix whose elements are all 1
	 * @throws IllegalArgumentException if either argument is non-positive
	 */
	public static Matrix ones(int rows, int columns) {
		Matrix m = MatrixFactory.createMatrix(rows, columns);
		for (int i = 0; i < m.getRowCount(); i++)
			for (int j = 0; j < m.getColumnCount(); j++)
				m.set(i, j, 1);
		return m;
	}

	/**
	 * Creates a matrix of the specified size whose elements are pseudorandom, uniformly distributed
	 * values between 0 (inclusive) and 1 (exclusive).
	 * @param rows the number of rows
	 * @param columns the number of columns
	 * @return a <code>rows</code>×<code>columns</code> matrix of random elements
	 * @throws IllegalArgumentException if either argument is non-positive
	 */
	public static Matrix random(int rows, int columns) {
		Matrix m = MatrixFactory.createMatrix(rows, columns);
		for (int i = 0; i < m.getRowCount(); i++)
			for (int j = 0; j < m.getColumnCount(); j++)
				m.set(i, j, Math.random());
		return m;
	}
	
	//
	// Matrix creation from arrays
	//
	
	/**
	 * Creates a matrix and initializes its elements from an array. The parameter should be a {@code double[r][c]}
	 * array with {@code r>0} and {@code c>0}. The matrix element at row {@code row} and column {@code col} will be
	 * {@code elements[row][col]}.
	 * @param elements the array containing the elements of the matrix
	 * @return the new matrix initialized from the array
	 * @throws NullPointerException if the array is {@code null}
	 * @throws IllegalArgumentException if the dimensions of the array are not valid
	 */
	public static Matrix createMatrix(double[][] elements) {
		Matrix m=createMatrix(elements.length, elements[0].length);
		for (int row=0; row<m.getRowCount(); row++) {
			double[] rowData=elements[row];
			if (rowData.length!=m.getColumnCount()) throw new IllegalArgumentException("Invalid array");
			for (int col=0; col<m.getColumnCount(); col++) {
				m.set(row, col, rowData[col]);
			}
		}
		return m;
	}
	
	/**
	 * Creates a matrix and initializes its elements from an array. The parameter should be a {@code double[2][2]}
	 * array. The matrix element at row {@code row} and column {@code col} will be
	 * {@code elements[row][col]}.
	 * @param elements the array containing the elements of the matrix
	 * @return the new matrix initialized from the array
	 * @throws NullPointerException if the array is {@code null}
	 * @throws IllegalArgumentException if the dimensions of the array are not correct
	 */
	public static Matrix2 createMatrix2(double[][] elements) {
		Matrix m=createMatrix(elements);
		if (m.getRowCount()!=2 || m.getColumnCount()!=2)
			throw new IllegalArgumentException("Array describes a matrix of size "+m.getRowCount()+"x"+m.getColumnCount()+" instead of 2x2");
		return (Matrix2)m;
	}
	
	/**
	 * Creates a matrix and initializes its elements from an array. The parameter should be a {@code double[3][3]}
	 * array. The matrix element at row {@code row} and column {@code col} will be
	 * {@code elements[row][col]}.
	 * @param elements the array containing the elements of the matrix
	 * @return the new matrix initialized from the array
	 * @throws NullPointerException if the array is {@code null}
	 * @throws IllegalArgumentException if the dimensions of the array are not correct
	 */
	public static Matrix3 createMatrix3(double[][] elements) {
		Matrix m=createMatrix(elements);
		if (m.getRowCount()!=3 || m.getColumnCount()!=3)
			throw new IllegalArgumentException("Array describes a matrix of size "+m.getRowCount()+"x"+m.getColumnCount()+" instead of 3x3");
		return (Matrix3)m;
	}
	
	/**
	 * Creates a vector and initializes its elements from an array.
	 * @param elements the array containing the elements of the vector
	 * @return the new vector initialized from the array
	 * @throws NullPointerException if the array is {@code null}
	 * @throws IllegalArgumentException if the length of the array is zero
	 */
	public static Vector createVector(double[] elements) {
		Vector v=createVector(elements.length);
		for (int i=0; i<elements.length; i++)
			v.setCoordQuick(i, elements[i]);
		return v;
	}
}
