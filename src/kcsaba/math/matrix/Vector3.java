
package kcsaba.math.matrix;

/**
 * A 3D vector.
 * @author Kazó Csaba
 */
public class Vector3 extends Vector {
	/**
	 * Creates a new 3D vector with zero elements.
	 */
	Vector3() {
		super(3);
	}
	/**
	 * Creates a new 3D vector with the specified elements
	 */
	Vector3(double x, double y, double z) {
		super(3);
		setX(x);
		setY(y);
		setZ(z);
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
	 * Converts this 3D vector to a homogen vector. The result will have
	 * four coordinates: (getX(), getY(), getZ(), 1).
	 * @return the homogen representation of this vector
	 */
	public Vector4 toHomogen() {
		return new Vector4(getX(), getY(), getZ(), 1);
	}
	
	/** Returns the vector corresponding to the difference of the argument and this vector. */
	public Vector3 to(Vector3 v) {
		return v.minusVec(this);
	}

	/** Returns the cross product of this vector and the argument. */
	public Vector3 cross(Vector3 v) {
		return new Vector3(getY() * v.getZ() - getZ() * v.getY(), getZ() * v.getX() - getX() * v.getZ(),
				getX() * v.getY() - getY() * v.getX());
	}
	
	/** Returns the dot product of this vector and the argument. */
	public double dot(Vector3 v) {
		return getX() * v.getX() + getY() * v.getY() + getZ() * v.getZ();
	}
	
	/** Returns the difference of this vector and the argument. */
	public Vector3 minusVec(Vector3 v) {
		return new Vector3(getX()-v.getX(), getY()-v.getY(), getZ()-v.getZ());
	}
	/** Returns the sum of this vector and the argument. */
	public Vector3 plusVec(Vector3 v) {
		return new Vector3(getX()+v.getX(), getY()+v.getY(), getZ()+v.getZ());
	}
	
	public String toString() {
		return String.format("(%f; %f; %f)", getX(), getY(), getZ());
	}
}
