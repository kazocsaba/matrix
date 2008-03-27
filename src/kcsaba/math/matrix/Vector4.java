
package kcsaba.math.matrix;

/**
 * A 4D vector.
 * @author Kazó Csaba
 */
public class Vector4 extends Vector {
	/**
	 * Creates a new 4D vector with zero elements.
	 */
	Vector4() {
		super(4);
	}
	/**
	 * Creates a new 4D vector with the specified elements
	 */
	Vector4(double x, double y, double z, double h) {
		super(4);
		setX(x);
		setY(y);
		setZ(z);
		setH(h);
	}
	/**
	 * Returns the first coordinate of the vector.
	 * @return the x coordinate
	 */
	public double getX() {return getCoord(0);}
	/**
	 * Returns the second coordinate of the vector.
	 * @return the y coordinate
	 */
	public double getY() {return getCoord(1);}
	/**
	 * Returns the third coordinate of the vector.
	 * @return the z coordinate
	 */
	public double getZ() {return getCoord(2);}
	/**
	 * Returns the fourth coordinate of the vector.
	 * @return the h coordinate
	 */
	public double getH() {return getCoord(3);}
	
	/**
	 * Sets the first coordinate of the vector.
	 * @param value the new value of the x coordinate
	 */
	public void setX(double value) {setCoord(0, value);}
	/**
	 * Sets the second coordinate of the vector.
	 * @param value the new value of the y coordinate
	 */
	public void setY(double value) {setCoord(1, value);}
	/**
	 * Sets the third coordinate of the vector.
	 * @param value the new value of the z coordinate
	 */
	public void setZ(double value) {setCoord(2, value);}
	/**
	 * Sets the fourth coordinate of the vector.
	 * @param value the new value of the h coordinate
	 */
	public void setH(double value) {setCoord(2, value);}
}
