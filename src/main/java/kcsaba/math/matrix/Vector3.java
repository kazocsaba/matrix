package kcsaba.math.matrix;

/**
 * A 3D column vector.
 * @author Kazó Csaba
 */
public interface Vector3 extends Vector {

	/**
	 * Retrieves the x coordinate of the vector.
	 * @return the same as {@code getCoord(0)}
	 */
	public double getX();

	/**
	 * Retrieves the y coordinate of the vector.
	 * @return the same as {@code getCoord(1)}
	 */
	public double getY();

	/**
	 * Retrieves the z coordinate of the vector.
	 * @return the same as {@code getCoord(2)}
	 */
	public double getZ();

	/**
	 * Sets the x coordinate of the vector.
	 * @param value the new value
	 */
	public void setX(double value);

	/**
	 * Sets the x coordinate of the vector.
	 * @param value the new value
	 */
	public void setY(double value);

	/**
	 * Sets the x coordinate of the vector.
	 * @param value the new value
	 */
	public void setZ(double value);

	/**
	 * Creates a new 4D vector that represents this vector in homogeneous coordinates.
	 * (I.e. the x, y and z coordinates will be the same as of this vector, the
	 * fourth coordinate will be 1.)
	 * @return the homogeneous representation of this vector
	 */
	public Vector4 toHomogeneous();

	/**
	 * Returns the cross product of this vector and the argument.
	 * @param v another vector
	 * @return a new vector containing the cross product
	 */
	public Vector3 cross(Vector3 v);
	
	@Override
	public Vector3 plus(Matrix m);
	@Override
	public Vector3 minus(Matrix m);
	@Override
	public Vector3 times(double c);
}
