
package kcsaba.math.matrix;

/**
 * A column vector.
 * @author Kazó Csaba
 */
public class Vector extends Matrix {
	/**
	 * Construct a column vector of the given dimension.
	 * @param size the number of coordinates of the vector
	 */
	Vector(int size) {
		super(size, 1);
	}
	/**
	 * Returns the specified element of the vector.
	 * @param coord the index of the element to return
	 * @return the specified coordinate value
	 */
	public double getCoord(int coord) {
		return super.get(coord, 0);
	}
	/**
	 * Sets the specified element of the vector.
	 * @param coord the index of the element to set
	 * @param value the new value of the specified coordinate
	 */
	public void setCoord(int coord, double value) {
		super.set(coord, 0, value);
	}
}
