package kcsaba.math.matrix;

import kcsaba.math.matrix.impl.MatrixFactoryImpl;

/**
 * Factory class for creating matrix instances.
 * @author Kazó Csaba
 */
public abstract class MatrixFactory {
	protected MatrixFactory() {}
	private static final MatrixFactory INSTANCE=new MatrixFactoryImpl();
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
			case 3: return createVector3();
			case 4: return createVector4();
			default: return INSTANCE._createVector(dimension);
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
		else
			return INSTANCE._createMatrix(rowCount, colCount);
	}

	
	
	/**
	 * Creates a new 3D column vector with the initial value of 0.
	 * @return the new vector
	 */
	protected abstract Vector3 _createVector3();
	/**
	 * Creates and initializes a new 3D column vector.
	 * @param x the x coordinate of the new vector
	 * @param y the y coordinate of the new vector
	 * @param z the z coordinate of the new vector
	 * @return the new vector
	 */
	protected Vector3 _createVector3(double x, double y, double z) {
		Vector3 v=_createVector3();
		v.setX(x);
		v.setY(y);
		v.setZ(z);
		return v;
	}
	/**
	 * Creates a new 4D column vector with the initial value of 0.
	 * @return the new vector
	 */
	protected abstract Vector4 _createVector4();
	/**
	 * Creates and initializes a new 4D column vector.
	 * @param x the x coordinate of the new vector
	 * @param y the y coordinate of the new vector
	 * @param z the z coordinate of the new vector
	 * @param h the h coordinate of the new vector
	 * @return the new vector
	 */
	protected Vector4 _createVector4(double x, double y, double z, double h) {
		Vector4 v=_createVector4();
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
	protected abstract Vector _createVector(int dimension);
	
	/**
	 * Creates a new matrix with all elements initialized to 0.
	 * @param rowCount the number of rows
	 * @param colCount the number of columns; will not be 1
	 * @return a new matrix of the specified size
	 */
	protected abstract Matrix _createMatrix(int rowCount, int colCount);
}