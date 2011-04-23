package kcsaba.math.matrix;

import kcsaba.math.matrix.impl.MatrixFactoryImpl;

/**
 * Factory class for creating matrix instances.
 * @author Kazó Csaba
 */
public abstract class MatrixFactory<
		M extends Matrix,
		M2 extends Matrix2,
		M3 extends Matrix3,
		V extends Vector,
		V2 extends Vector2,
		V3 extends Vector3,
		V4 extends Vector4> {
	protected MatrixFactory() {}
	private static final MatrixFactory<Matrix,Matrix2,Matrix3,Vector,Vector2,Vector3,Vector4> INSTANCE=new MatrixFactoryImpl();
	/**
	 * Creates a new 2D column vector with the initial value of 0.
	 * @return the new vector
	 */
	public static final Vector2 createVector2() {return INSTANCE._createVector2();}
	/**
	 * Creates and initializes a new 2D column vector.
	 * @param x the x coordinate of the new vector
	 * @param y the y coordinate of the new vector
	 * @return the new vector
	 */
	public static final Vector2 createVector2(double x, double y) {
		return INSTANCE._createVector2(x, y);
	}
	/**
	 * Creates a new 3D column vector with the initial value of 0.
	 * @return the new vector
	 */
	public static final Vector3 createVector3() {return INSTANCE._createVector3();}
	/**
	 * Creates and initializes a new 3D column vector.
	 * @param x the x coordinate of the new vector
	 * @param y the y coordinate of the new vector
	 * @param z the z coordinate of the new vector
	 * @return the new vector
	 */
	public static final Vector3 createVector3(double x, double y, double z) {
		return INSTANCE._createVector3(x, y, z);
	}
	/**
	 * Creates a new 4D column vector with the initial value of 0.
	 * @return the new vector
	 */
	public static final Vector4 createVector4() {return INSTANCE._createVector4();}
	/**
	 * Creates and initializes a new 4D column vector.
	 * @param x the x coordinate of the new vector
	 * @param y the y coordinate of the new vector
	 * @param z the z coordinate of the new vector
	 * @param h the h coordinate of the new vector
	 * @return the new vector
	 */
	public static final Vector4 createVector4(double x, double y, double z, double h) {
		return INSTANCE._createVector4(x, y, z, h);
	}
	/**
	 * Creates a new column vector with all elements initialized to 0.
	 * @param dimension the dimension of the vector.
	 * @return the new vector
	 * @throws IllegalArgumentException if the argument is not positive
	 */
	public static final Vector createVector(int dimension) {
		if (dimension<=0) throw new IllegalArgumentException();
		switch (dimension) {
			case 2: return createVector2();
			case 3: return createVector3();
			case 4: return createVector4();
			default: return INSTANCE._createVector(dimension);
		}
	}
	
	/**
	 * Creates a new vector with the same contents as the argument.
	 * @param v the vector to copy
	 * @return a copy of the argument
	 * @throws NullPointerException if the argument is <code>null</code>
	 */
	public static final Vector2 createVector2(Vector2 v) {
		return createVector2(v.getX(), v.getY());
	}
	/**
	 * Creates a new vector with the same contents as the argument.
	 * @param v the vector to copy
	 * @return a copy of the argument
	 * @throws NullPointerException if the argument is <code>null</code>
	 */
	public static final Vector3 createVector3(Vector3 v) {
		return createVector3(v.getX(), v.getY(), v.getZ());
	}
	/**
	 * Creates a new vector with the same contents as the argument.
	 * @param v the vector to copy
	 * @return a copy of the argument
	 * @throws NullPointerException if the argument is <code>null</code>
	 */
	public static final Vector4 createVector4(Vector4 v) {
		return createVector4(v.getX(), v.getY(), v.getZ(), v.getH());
	}
	/**
	 * Creates a new vector with the same dimension and contents as the argument.
	 * @param v the vector to copy
	 * @return a copy of the argument
	 * @throws NullPointerException if the argument is <code>null</code>
	 */
	public static final Vector createVector(Vector v) {
		if (v==null) throw new NullPointerException();
		switch (v.getDimension()) {
			case 2: return createVector2((Vector2)v);
			case 3: return createVector3((Vector3)v);
			case 4: return createVector4((Vector4)v);
			default:
				Vector copy=createVector(v.getDimension());
				for (int i=0; i<v.getDimension(); i++)
					copy.setCoord(i, v.getCoord(i));
				return copy;
		}
	}

	/**
	 * Creates a new matrix with all elements initialized to 0.
	 * @param rowCount the number of rows
	 * @param colCount the number of columns
	 * @return a new matrix of the specified size
	 * @throws IllegalArgumentException if either argument is non-positive
	 */
	public static final Matrix createMatrix(int rowCount, int colCount) {
		if (rowCount<=0 || colCount<=0) throw new IllegalArgumentException();
		if (colCount==1)
			return createVector(rowCount);
		else if (rowCount==2 && colCount==2)
			return INSTANCE._createMatrix2();
		else if (rowCount==3 && colCount==3)
			return INSTANCE._createMatrix3();
		else
			return INSTANCE._createMatrix(rowCount, colCount);
	}
	/**
	 * Creates a new 2x2 matrix.
	 * @return a new 2x2 matrix
	 */
	public static final Matrix2 createMatrix2() {
		return INSTANCE._createMatrix2();
	}
	/**
	 * Creates a new 3x3 matrix.
	 * @return a new 3x3 matrix
	 */
	public static final Matrix3 createMatrix3() {
		return INSTANCE._createMatrix3();
	}

	/**
	 * Creates a copy of a matrix.
	 * @param m the matrix to copy
	 * @return a new matrix with the same dimensions and contents as the argument
	 * @throws NullPointerException if {@code matrix} is {@code null}
	 */
	public static final <M extends Matrix> M copy(M m) {
		if (m==null) throw new NullPointerException();
		M copy=(M)createMatrix(m.getRowCount(), m.getColumnCount());
		for (int row=0; row<m.getRowCount(); row++) for (int col=0; col<m.getColumnCount(); col++)
			copy.set(row, col, m.get(row, col));
		return copy;
	}

	public static final <M extends Matrix> M createLike(M matrix) {
		return (M)createMatrix(matrix.getRowCount(), matrix.getColumnCount());
	}
	
	/**
	 * Creates a new 2D column vector with the initial value of 0.
	 * @return the new vector
	 */
	protected abstract V2 _createVector2();
	/**
	 * Creates and initializes a new 2D column vector.
	 * @param x the x coordinate of the new vector
	 * @param y the y coordinate of the new vector
	 * @return the new vector
	 */
	protected V2 _createVector2(double x, double y) {
		V2 v=_createVector2();
		v.setX(x);
		v.setY(y);
		return v;
	}

	/**
	 * Creates a new 3D column vector with the initial value of 0.
	 * @return the new vector
	 */
	protected abstract V3 _createVector3();
	/**
	 * Creates and initializes a new 3D column vector.
	 * @param x the x coordinate of the new vector
	 * @param y the y coordinate of the new vector
	 * @param z the z coordinate of the new vector
	 * @return the new vector
	 */
	protected V3 _createVector3(double x, double y, double z) {
		V3 v=_createVector3();
		v.setX(x);
		v.setY(y);
		v.setZ(z);
		return v;
	}
	/**
	 * Creates a new 4D column vector with the initial value of 0.
	 * @return the new vector
	 */
	protected abstract V4 _createVector4();
	/**
	 * Creates and initializes a new 4D column vector.
	 * @param x the x coordinate of the new vector
	 * @param y the y coordinate of the new vector
	 * @param z the z coordinate of the new vector
	 * @param h the h coordinate of the new vector
	 * @return the new vector
	 */
	protected V4 _createVector4(double x, double y, double z, double h) {
		V4 v=_createVector4();
		v.setX(x);
		v.setY(y);
		v.setZ(z);
		v.setH(h);
		return v;
	}
	/**
	 * Creates a new column vector with all elements initialized to 0.
	 * @param dimension the dimension of the vector; will not be 3 or 4
	 * @return the new vector
	 * @throws IllegalArgumentException if the argument is not positive
	 */
	protected abstract V _createVector(int dimension);
	
	/**
	 * Creates a new matrix with all elements initialized to 0.
	 * @param rowCount the number of rows
	 * @param colCount the number of columns; will not be 1
	 * @return a new matrix of the specified size
	 */
	protected abstract M _createMatrix(int rowCount, int colCount);

	/**
	 * Creates a new 2x2 matrix with all elements initialized to 0.
	 * @return a new 2x2 matrix
	 */
	protected abstract M2 _createMatrix2();

	/**
	 * Creates a new 3x3 matrix with all elements initialized to 0.
	 * @return a new 3x3 matrix
	 */
	protected abstract M3 _createMatrix3();
}
