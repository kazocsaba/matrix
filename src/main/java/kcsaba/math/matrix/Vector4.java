package kcsaba.math.matrix;

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
	/**
	 * Returns a new vector that is the sum of this vector and the argument.
	 * @param v the other vector
	 * @return the sum of this vector and the argument
	 * @throws NullPointerException if the argument is null
	 */
	public Vector4 plusVec(Vector4 v);
	
	/**
	 * Returns a new vector that is the difference of this vector and the argument.
	 * @param v the other vector
	 * @return the difference of this vector and the argument
	 * @throws NullPointerException if the argument is null
	 */
	public Vector4 minusVec(Vector4 v);
}
