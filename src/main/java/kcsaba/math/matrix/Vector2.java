package kcsaba.math.matrix;

/**
 * A 2D column vector.
 * @author Kazó Csaba
 */
public interface Vector2 extends Vector {

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
	 * Returns a new vector that is the sum of this vector and the argument.
	 * @param v the other vector
	 * @return the sum of this vector and the argument
	 * @throws NullPointerException if the argument is null
	 */
	public Vector2 plusVec(Vector2 v);
	
	/**
	 * Returns a new vector that is the difference of this vector and the argument.
	 * @param v the other vector
	 * @return the difference of this vector and the argument
	 * @throws NullPointerException if the argument is null
	 */
	public Vector2 minusVec(Vector2 v);
}
