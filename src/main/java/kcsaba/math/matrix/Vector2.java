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
	
	@Override
	public Vector2 plus(Matrix m);
	@Override
	public Vector2 minus(Matrix m);
	@Override
	public Vector2 times(double c);
}
