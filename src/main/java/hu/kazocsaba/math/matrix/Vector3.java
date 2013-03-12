package hu.kazocsaba.math.matrix;

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

	@Override
	public Vector4 toHomogeneous();
	@Override
	public Vector2 fromHomogeneous();

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
	@Override
	public Vector3 normalized();
}
