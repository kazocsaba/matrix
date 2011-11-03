package hu.kazocsaba.math.matrix;

/**
 * A column vector.
 * @author Kazó Csaba
 */
public interface Vector extends Matrix {
	/**
	 * Returns the dimension of this vector.
	 * @return the same as {@code getRowCount()}
	 */
	public int getDimension();
	
	/**
	 * Retrieves the specified coordinate of the vector.
	 * @param index the coordinate to return
	 * @return the same as {@code get(index,0)}
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public double getCoord(int index);
	/**
	 * Retrieves the specified coordinate of the vector without checking the argument. If the index is invalid,
	 * the behaviour of this method is unspecified. For example, it may return some value or throw an exception.
	 * @param index the coordinate to return
	 * @return the same as {@code get(index,0)}
	 */
	public double getCoordQuick(int index);
	/**
	 * Updates the specified coordinate of the vector.
	 * @param index the coordinate to set
	 * @param value the new value
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public void setCoord(int index, double value);
	/**
	 * Updates the specified coordinate of the vector without checking the index. If the index is invalid,
	 * the behaviour of this method is unspecified. For example, it may set some element or throw an exception.
	 * @param index the coordinate to set
	 * @param value the new value
	 */
	public void setCoordQuick(int index, double value);
	
	/**
	 * Returns the dot product of this vector and the argument
	 * @param v another vector
	 * @return the dot product
	 * @throws NullPointerException if the argument is null
	 * @throws IllegalArgumentException if the vector dimensions differ
	 */
	public double dot(Vector v);
	
	@Override
	public Vector plus(Matrix m);
	@Override
	public Vector minus(Matrix m);
	@Override
	public Vector times(double c);
	@Override
	public Vector normalized();
}
