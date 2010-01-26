package kcsaba.math.matrix;

/**
 * A column vector.
 * @author Kazó Csaba
 */
public interface Vector<V extends Vector<V>> extends Matrix<V> {
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
	 * Updates the specified coordinate of the vector.
	 * @param index the coordinate to set
	 * @param value the new value
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public void setCoord(int index, double value);
	
	/**
	 * Returns the dot product of this vector and the argument
	 * @param v another vector
	 * @return the dot product
	 * @throws NullPointerException if the argument is null
	 * @throws IllegalArgumentException if the vector dimensions differ
	 */
	public double dot(Vector v);
}
