package hu.kazocsaba.math.matrix;

/**
 * A 4D column vector. The elements are called x, y, z and h, respectively.
 * @author Kazó Csaba
 */
public interface Vector4 extends Vector {
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
	 * Retrieves the h coordinate of the vector.
	 * @return the same as {@code getCoord(3)}
	 */
	public double getH();
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
	 * Sets the h coordinate of the vector.
	 * @param value the new value
	 */
	public void setH(double value);
	
	@Override
	public Vector3 fromHomogeneous();
	
	@Override
	public Vector4 plus(Matrix m);
	@Override
	public Vector4 minus(Matrix m);
	@Override
	public Vector4 times(double c);
	@Override
	public Vector4 normalized();
}
